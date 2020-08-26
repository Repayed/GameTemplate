package me.repayed.gametemplate.data;

import me.repayed.gametemplate.GameTemplate;
import me.repayed.gametemplate.utils.Chat;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.Optional;

public class ConfigFile {

    private final FileConfiguration configuration;

    private Location lobbyLocation;
    private Location gameLocation;

    public ConfigFile(final GameTemplate gameTemplate) {
        this.configuration = gameTemplate.getConfig();

        this.lobbyLocation = loadNewLocation("locations.lobby");
        this.gameLocation = loadNewLocation("locations.game");
    }

    private Location loadNewLocation(String path) {
        final String locationWorld = this.configuration.getString(path + ".world");
        final double xLocation = this.configuration.getDouble(path + ".x");
        final double yLocation = this.configuration.getDouble(path + ".y");
        final double zLocation = this.configuration.getDouble(path + ".z");

        Optional<String> locationWorldName = Optional.ofNullable(locationWorld);
        return locationWorldName.map(s -> new Location(Bukkit.getWorld(s), xLocation, yLocation, zLocation)).orElse(null);
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
        String receivedMessage = this.configuration.getString(message.getPath());
        String formattedMessage = StringUtils.replace(receivedMessage, "%prefix%", this.configuration.getString(Message.PREFIX.getPath()));
        player.sendMessage(Chat.format(formattedMessage));
    }

    public void sendPlayerListMessage(Player player, Message message) {
        this.configuration.getStringList(message.getPath()).forEach(line -> player.sendMessage(Chat.format(line)));
    }
}
