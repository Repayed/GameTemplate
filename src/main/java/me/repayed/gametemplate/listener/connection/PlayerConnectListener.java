package me.repayed.gametemplate.listener.connection;

import me.repayed.gametemplate.GameTemplate;
import me.repayed.gametemplate.data.ConfigFile;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerConnectListener implements Listener {

    private final ConfigFile configFile;

    public PlayerConnectListener(final GameTemplate gameTemplate) {
        this.configFile = gameTemplate.getConfigFile();
    }

    @EventHandler
    public void onPlayerConnect(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.teleport(this.configFile.getLobbyLocation());
    }
}
