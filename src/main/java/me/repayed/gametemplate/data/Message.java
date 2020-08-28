package me.repayed.gametemplate.data;

public enum Message {

    PREFIX("messages.prefix"),
    NO_PERMISSION("messages.no-permission"),

    GAME_STARTED("messages.user.game-started"),
    GAME_ENDED("messages.user.game-ended"),
    GAME_RESTARTING("messages.user.game-restarting"),

    ADMIN_GAME_MENU("messages.admin.game-menu"),
    SET_GAME_SPAWN("messages.admin.set-game-spawn"),
    SET_LOBBY_SPAWN("messages.admin.set-lobby-spawn"),
    RELOADED_CONFIG("messages.admin.reloaded-config");

    private String path;

    Message(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
