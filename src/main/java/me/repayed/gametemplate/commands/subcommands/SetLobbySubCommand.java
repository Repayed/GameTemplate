package me.repayed.gametemplate.commands.subcommands;

import me.repayed.gametemplate.GameTemplate;
import me.repayed.gametemplate.commands.SubCommand;
import me.repayed.gametemplate.data.ConfigFile;
import me.repayed.gametemplate.data.Message;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.Objects;

public class SetLobbySubCommand extends SubCommand {

    private final GameTemplate gameTemplate;
    private final ConfigFile configFile;

    public SetLobbySubCommand(final GameTemplate gameTemplate) {
        this.gameTemplate = gameTemplate;
        this.configFile = gameTemplate.getConfigFile();
    }

    @Override
    protected String getName() {
        return "setlobby";
    }

    @Override
    protected String getUsage() {
        return "/gametemplate setlobby";
    }

    @Override
    protected String getDescription() {
        return "Sets the lobby for the game.";
    }

    @Override
    protected void execute(Player player, String[] args) {
        Location location = player.getLocation();

        this.gameTemplate.getConfig().set("locations.lobby.world", Objects.requireNonNull(location.getWorld()).getName());
        this.gameTemplate.getConfig().set("locations.lobby.x", location.getX());
        this.gameTemplate.getConfig().set("locations.lobby.y", location.getY());
        this.gameTemplate.getConfig().set("locations.lobby.z", location.getZ());

        this.gameTemplate.saveConfig();

        this.configFile.sendPlayerMessage(player, Message.SET_LOBBY_SPAWN);
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, .95F, 1.0F);
    }
}
