package me.repayed.gametemplate;

import me.repayed.gametemplate.commands.CommandHandler;
import me.repayed.gametemplate.data.ConfigFile;
import me.repayed.gametemplate.game.GameArena;
import me.repayed.gametemplate.listeners.blocks.BlockBreakListener;
import me.repayed.gametemplate.listeners.blocks.BlockPlaceListener;
import me.repayed.gametemplate.listeners.connection.PlayerConnectListener;
import me.repayed.gametemplate.listeners.connection.PlayerDisconnectListener;
import me.repayed.gametemplate.listeners.damage.PlayerDamagePlayerListener;
import me.repayed.gametemplate.player.GamePlayerManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class GameTemplate extends JavaPlugin {

    private ConfigFile configFile;
    private GamePlayerManager gamePlayerManager;
    private GameArena gameArena;

    @Override
    public void onEnable() {
        loadConfig();
        this.configFile = new ConfigFile(this);
        this.gamePlayerManager = new GamePlayerManager();
        this.gameArena = new GameArena(this);

        this.getCommand("gametemplate").setExecutor(new CommandHandler(this));
        loadListeners();
    }

    private void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
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
                new PlayerConnectListener(), new PlayerDisconnectListener(),
                new PlayerDamagePlayerListener()
        ).forEach(listener -> getServer().getPluginManager().registerEvents(listener, this));
    }

}
