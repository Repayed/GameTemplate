package me.repayed.gametemplate;

import me.repayed.gametemplate.commands.CommandHandler;
import me.repayed.gametemplate.data.ConfigFile;
import me.repayed.gametemplate.game.GameArena;
import me.repayed.gametemplate.listener.blocks.BlockBreakListener;
import me.repayed.gametemplate.listener.blocks.BlockPlaceListener;
import me.repayed.gametemplate.listener.connection.PlayerConnectListener;
import me.repayed.gametemplate.listener.connection.PlayerDisconnectListener;
import me.repayed.gametemplate.listener.damage.PlayerDamagePlayerListener;
import me.repayed.gametemplate.player.GamePlayerManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class GameTemplate extends JavaPlugin {

    private ConfigFile configFile;
    private GamePlayerManager gamePlayerManager;
    private GameArena gameArena;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.configFile = new ConfigFile(this);
        this.gamePlayerManager = new GamePlayerManager();
        this.gameArena = new GameArena(this);

        this.getCommand("gametemplate").setExecutor(new CommandHandler(this));
        loadListeners();
    }

    public ConfigFile getConfigFile() {
        return this.configFile;
    }

    public GamePlayerManager getGamePlayerManager() {
        return gamePlayerManager;
    }

    public GameArena getGameArena() {
        return this.gameArena;
    }

    private void loadListeners() {
        Arrays.asList(
                new BlockBreakListener(), new BlockPlaceListener(),
                new PlayerConnectListener(this), new PlayerDisconnectListener(),
                new PlayerDamagePlayerListener()
        ).forEach(listener -> getServer().getPluginManager().registerEvents(listener, this));
    }

}
