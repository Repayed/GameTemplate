package me.repayed.gametemplate.player;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * This class manages all of the current game players.
 *
 * It allows you to search for specific players, remove them, add them,
 * and so on.
 */

public class GamePlayerManager {
    private Set<GamePlayer> gamePlayers;

    public GamePlayerManager() {
        this.gamePlayers = new HashSet<>();
    }

    public Set<GamePlayer> getGamePlayers() {
        return gamePlayers;
    }

    /**
     * Attempts to find the first player within the set
     * that has the same uuid to the parameter uuid.
     *
     * @param uuid the uuid of the person being checked.
     * @return an optional which could be null or not depending on if the player is in the list.
     */

    public Optional<GamePlayer> getGamePlayer(UUID uuid) {
        return this.gamePlayers.stream()
                .filter(player -> player.toString().equalsIgnoreCase(uuid.toString()))
                .findFirst();
    }

    public void addGamePlayer(GamePlayer gamePlayer) {
        this.gamePlayers.add(gamePlayer);
    }

    public void removeGamePlayer(GamePlayer gamePlayer) {
        this.gamePlayers.remove(gamePlayer);
    }
}
