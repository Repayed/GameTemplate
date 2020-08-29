package me.repayed.gametemplate.player;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 *
 * This class is designed to manage all of the current
 * GamePlayer's. It does so, by storing them in a HashSet
 * in order to make sure that there are no repeated elements.
 *
 */

public class GamePlayerManager {
    private final Set<GamePlayer> gamePlayers;

    public GamePlayerManager() {
        this.gamePlayers = new HashSet<>();
    }

    public Set<GamePlayer> getGamePlayers() {
        return gamePlayers;
    }

    /**
     * Attempts to find the player that has the
     * same uuid as the given parameter's uuid.
     *
     * @param uuid the uuid of the person being checked.
     * @return an optional which could be null or not depending on if the player is in the list.
     */

    public Optional<GamePlayer> getGamePlayer(UUID uuid) {
        return this.gamePlayers.stream()
                .filter(player -> player.getUuid().equals(uuid))
                .findAny();
    }

    public void addGamePlayer(GamePlayer gamePlayer) {
        this.gamePlayers.add(gamePlayer);
    }

    public void removeGamePlayer(GamePlayer gamePlayer) {
        this.gamePlayers.remove(gamePlayer);
    }
}
