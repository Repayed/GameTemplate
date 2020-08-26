package me.repayed.gametemplate.commands.subcommands;

import me.repayed.gametemplate.GameTemplate;
import me.repayed.gametemplate.commands.SubCommand;
import me.repayed.gametemplate.data.ConfigFile;
import me.repayed.gametemplate.data.Message;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class ReloadSubCommand extends SubCommand {

    private final GameTemplate instance;
    private ConfigFile configFile;

    public ReloadSubCommand(GameTemplate gameTemplate) {
        this.instance = gameTemplate;
        this.configFile = gameTemplate.getConfigFile();
    }


    @Override
    protected String getName() {
        return "reload";
    }

    @Override
    protected String getUsage() {
        return "/gametemplate reload";
    }

    @Override
    protected String getDescription() {
        return "Reloads the configuration.";
    }

    @Override
    protected void execute(Player player, String[] args) {
        this.instance.reloadConfig();
        this.configFile.sendPlayerMessage(player, Message.RELOADED_CONFIG);
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, .95F, 1.0F);
    }
}
