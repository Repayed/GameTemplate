package me.repayed.gametemplate.data;

public enum Message {

    PREFIX("messages.prefix"),
    NO_PERMISSION("messages.no-permission");

    private String path;

    Message(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
