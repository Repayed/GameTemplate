package me.repayed.gametemplate.player;

import java.util.UUID;

public class GamePlayer {
    private UUID uuid;
    private boolean isPlaying;

    public GamePlayer(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public void setPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    @Override
    public String toString() {
        return this.uuid.toString();
    }

//    @Override
//    public boolean equals(Object object) {
//        if(object == null) return false;
//
//        if(object.getClass() != this.getClass()) return false;
//
//        GamePlayer otherGamePlayer = (GamePlayer) object;
//        return this.toString().equalsIgnoreCase(otherGamePlayer.toString());
//    }
}
