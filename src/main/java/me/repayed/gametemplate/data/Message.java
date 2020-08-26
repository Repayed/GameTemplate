package me.repayed.gametemplate.data;

public enum Message {

    PREFIX("messages.prefix"),
    NO_PERMISSION("messages.no-permission"),

    GAME_STARTED("messages.user.game-started"),
    GAME_ENDED("messages.user.game-ended"),
    GAME_RESTARTING("messages.user.game-restarting"),

    ADMIN_GAME_MENU("messages.admin.game-menu");

    private String path;

    Message(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
