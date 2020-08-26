package me.repayed.gametemplate.data;

import me.repayed.gametemplate.GameTemplate;
import me.repayed.gametemplate.utils.Chat;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Optional;

public class ConfigFile {

    private final GameTemplate instance;

    private Location lobbyLocation;
    private Location gameLocation;

    public ConfigFile(final GameTemplate gameTemplate) {
        this.instance = gameTemplate;

        this.lobbyLocation = loadNewLocation("locations.lobby");
        this.gameLocation = loadNewLocation("locations.game");
    }


    // TODO: this method needs to changed, as it's giving me warnings, and I hate warnings D: ;/
    private Location loadNewLocation(String path) {
        final String locationWorld = this.instance.getConfig().getString(path + ".world");
        final double xLocation = this.instance.getConfig().getDouble(path + ".x");
        final double yLocation = this.instance.getConfig().getDouble(path + ".y");
        final double zLocation = this.instance.getConfig().getDouble(path + ".z");

        Optional<String> locationWorldName = Optional.ofNullable(locationWorld);
        if(!locationWorldName.isPresent()) return null;

        return new Location(Bukkit.getWorld(locationWorldName.get()), xLocation, yLocation, zLocation);
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
