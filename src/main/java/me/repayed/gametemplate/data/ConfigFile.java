package me.repayed.gametemplate.data;

import me.repayed.gametemplate.GameTemplate;
import me.repayed.gametemplate.utils.Chat;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class ConfigFile {

    private final GameTemplate instance;

    private Location lobbyLocation;
    private Location gameLocation;

    public ConfigFile(final GameTemplate gameTemplate) {
        this.instance = gameTemplate;

        loadLobbyLocation();
        loadGameLocation();
    }

    private void loadLobbyLocation() {
        final String lobbyWorld = this.instance.getConfig().getString("locations.lobby.world");
        final double lobbyXLocation = this.instance.getConfig().getInt("locations.lobby.x");
        final double lobbyYLocation = this.instance.getConfig().getInt("locations.lobby.y");
        final double lobbyZLocation = this.instance.getConfig().getInt("locations.lobby.z");

        this.lobbyLocation = new Location(Bukkit.getWorld(lobbyWorld), lobbyXLocation, lobbyYLocation, lobbyZLocation);
    }

    private void loadGameLocation() {
        final String gameWorld = this.instance.getConfig().getString("locations.game.world");
        final double gameXLocation = this.instance.getConfig().getInt("locations.game.x");
        final double gameYLocation = this.instance.getConfig().getInt("locations.game.y");
        final double gameZLocation = this.instance.getConfig().getInt("locations.game.z");

        this.gameLocation = new Location(Bukkit.getWorld(gameWorld), gameXLocation, gameYLocation, gameZLocation);
    }

    public Location getLobbyLocation() {
        return lobbyLocation;
    }

    public Location getGameLocation() {
        return gameLocation;
    }

    public int getMinimumStartingCount() {
        return 1;
    }

    public void sendPlayerMessage(Player player, Message message) {
        String receivedMessage = this.instance.getConfig().getString(message.getPath());
        String formattedMessage = StringUtils.replace(receivedMessage, "%prefix%", this.instance.getConfig().getString(Message.PREFIX.getPath()));
        player.sendMessage(Chat.format(formattedMessage));
    }

    public void sendPlayerListMessage(Player player, Message message) {
        this.instance.getConfig().getStringList(message.getPath()).forEach(line -> player.sendMessage(Chat.format(line)));
    }
}
