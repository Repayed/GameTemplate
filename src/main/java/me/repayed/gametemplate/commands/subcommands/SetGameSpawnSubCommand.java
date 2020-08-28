package me.repayed.gametemplate.commands.subcommands;

import me.repayed.gametemplate.GameTemplate;
import me.repayed.gametemplate.commands.SubCommand;
import me.repayed.gametemplate.data.ConfigFile;
import me.repayed.gametemplate.data.Message;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SetGameSpawnSubCommand extends SubCommand {

    private GameTemplate gameTemplate;
    private ConfigFile configFile;

    public SetGameSpawnSubCommand(GameTemplate gameTemplate) {
        this.gameTemplate = gameTemplate;
        this.configFile = gameTemplate.getConfigFile();
    }

    @Override
    protected String getName() {
        return "setspawn";
    }

    @Override
    protected String getUsage() {
        return "/gametemplate setspawn";
    }

    @Override
    protected String getDescription() {
        return "Sets the spawn for the game.";
    }

    @Override
    protected void execute(Player player, String[] args) {
        Location location = player.getLocation();

        this.gameTemplate.getConfig().set("locations.game.world", location.getWorld().getName());
        this.gameTemplate.getConfig().set("locations.game.x", location.getX());
        this.gameTemplate.getConfig().set("locations.game.y", location.getY());
        this.gameTemplate.getConfig().set("locations.game.z", location.getZ());

        this.gameTemplate.saveConfig();

        this.configFile.sendPlayerMessage(player, Message.SET_GAME_SPAWN);
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, .95F, 1.0F);

    }
}