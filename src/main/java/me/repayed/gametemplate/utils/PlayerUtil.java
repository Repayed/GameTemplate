package me.repayed.gametemplate.utils;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class PlayerUtil {

    public static void setPlayerDefault(Player player) {
        player.setHealth(20.0);
        player.setFoodLevel(20);
        player.setGameMode(GameMode.SURVIVAL);
        player.getInventory().clear();
        player.getInventory().setHelmet(null);
        player.getInventory().setChestplate(null);
        player.getInventory().setLeggings(null);
        player.getInventory().setBoots(null);
    }
}
