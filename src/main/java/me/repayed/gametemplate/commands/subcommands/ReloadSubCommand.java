package me.repayed.gametemplate.commands.subcommands;

import me.repayed.gametemplate.GameTemplate;
import me.repayed.gametemplate.commands.SubCommand;
import me.repayed.gametemplate.data.ConfigFile;
import me.repayed.gametemplate.data.Message;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class ReloadSubCommand extends SubCommand {

    private final GameTemplate gameTemplate;
    private final ConfigFile configFile;

    public ReloadSubCommand(final GameTemplate gameTemplate) {
        this.gameTemplate = gameTemplate;
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

    // TODO: Make a proper configuration file as this won't work properly and it's a waste of time.
    @Override
    protected void execute(Player player, String[] args) {
        this.gameTemplate.reloadConfig();
        this.configFile.sendPlayerMessage(player, Message.RELOADED_CONFIG);
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, .95F, 1.0F);
    }
}
