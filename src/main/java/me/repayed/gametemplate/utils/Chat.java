package me.repayed.gametemplate.utils;

import org.bukkit.ChatColor;

public class Chat {

    public static String format(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

}
