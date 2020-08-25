package me.repayed.gametemplate.game;

import me.repayed.gametemplate.GameTemplate;
import me.repayed.gametemplate.data.ConfigFile;
import me.repayed.gametemplate.player.GamePlayerManager;
import org.bukkit.Location;

public class GameArena {
    private GameState gameState;

    private final GamePlayerManager playerManager;

    private final int MINIMUM_STARTING_COUNT;

    private final Location lobbyLocation;
    private final Location gameLocation;

    public GameArena(GameTemplate gameTemplate) {
        final ConfigFile configFile = gameTemplate.getConfigFile();
        this.playerManager = gameTemplate.getGamePlayerManager();

        this.MINIMUM_STARTING_COUNT = configFile.getMinimumStartingCount();

        this.lobbyLocation = configFile.getLobbyLocation();
        this.gameLocation = configFile.getGameLocation();

        this.gameState = GameState.WAITING;
    }

    public GameState getGameState() {
        return this.gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public GamePlayerManager getPlayerManager() {
        return this.playerManager;
    }

    public int getMinimumStartingCount() {
        return this.MINIMUM_STARTING_COUNT;
    }

    public Location getLobbyLocation() {
        return this.lobbyLocation;
    }

    public Location getGameLocation() {
        return this.gameLocation;
    }
}
