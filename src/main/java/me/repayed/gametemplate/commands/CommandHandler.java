package me.repayed.gametemplate.commands;

import me.repayed.gametemplate.GameTemplate;
import me.repayed.gametemplate.commands.subcommands.ReloadSubCommand;
import me.repayed.gametemplate.commands.subcommands.SetLobbySubCommand;
import me.repayed.gametemplate.commands.subcommands.SetGameSpawnSubCommand;
import me.repayed.gametemplate.data.ConfigFile;
import me.repayed.gametemplate.data.Message;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class CommandHandler implements CommandExecutor {

    private Set<SubCommand> subCommands;
    private GameTemplate gameTemplate;
    private ConfigFile configFile;

    public CommandHandler(GameTemplate gameTemplate) {
        this.gameTemplate = gameTemplate;
        this.configFile = gameTemplate.getConfigFile();

        this.subCommands = new HashSet<>();
        this.subCommands.add(new ReloadSubCommand(this.gameTemplate));
        this.subCommands.add(new SetLobbySubCommand(this.gameTemplate));
        this.subCommands.add(new SetGameSpawnSubCommand(this.gameTemplate));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("[GameTemplate] Only players can access this command.");
        } else {
            Player player = (Player) sender;

            Optional<String> optionalPermission = Optional.ofNullable(this.gameTemplate.getConfig().getString("permissions.gametemplate-admin"));
            if (optionalPermission.isPresent()) {
                if (!player.hasPermission(optionalPermission.get())) {
                    this.configFile.sendPlayerMessage(player, Message.NO_PERMISSION);
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 0.95F, 1.0F);
                    return true;
                } else {
                    if (args.length == 1) {
                        this.subCommands.stream()
                                .filter(subCommand -> subCommand.getName().equalsIgnoreCase(args[0]))
                                .findAny()
                                .ifPresent(subCommand -> subCommand.execute(player, args));
                    } else {
                        this.configFile.sendPlayerListMessage(player, Message.ADMIN_GAME_MENU);
                        player.playSound(player.getLocation(), Sound.ENTITY_COW_STEP, .95F, 1.0F);
                    }

                }
            }
        }
        return true;
    }
}
