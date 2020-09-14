package me.repayed.gametemplate.game;

import me.repayed.gametemplate.GameTemplate;
import me.repayed.gametemplate.data.ConfigFile;
import me.repayed.gametemplate.player.GamePlayerManager;
import org.bukkit.Location;

public class GameArena {
    private final GameTemplate gameTemplate;

    private GameState gameState;

    private final GamePlayerManager playerManager;

    private final int MINIMUM_STARTING_COUNT;

    private final Location lobbyLocation;
    private final Location gameLocation;

    public GameArena(final GameTemplate gameTemplate) {
        this.gameTemplate = gameTemplate;

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

    /**
     * Method that evaluates if the game should start, depending on given criteria.
     * @return boolean which true/false depending on if the criteria to start is met.
     */

    public boolean shouldGameStart() {
        return this.gameState == GameState.WAITING && this.playerManager.getGamePlayers().size() >= this.MINIMUM_STARTING_COUNT;
    }

    public boolean hasEnoughPlayers() {
        return this.playerManager.getGamePlayers().size() >= this.MINIMUM_STARTING_COUNT;
    }

    /**
     * Method that evaluates if the game should end, depending on given criteria.
     * @return boolean which is true/false depending on if the game should end.
     */

    public boolean shouldGameEnd() {
        return false;
    }

    public void startGameCountdown() {
//        new GameCountdownStartTask(this.gameTemplate).runTaskTimerAsynchronously(this.gameTemplate, 0, 20 * 46);
    }

    public void startGame() {

    }

    public void endGame() {

    }

}
