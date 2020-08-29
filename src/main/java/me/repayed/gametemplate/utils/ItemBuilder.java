package me.repayed.gametemplate.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class ItemBuilder {
    private final ItemStack itemStack;
    private final ItemMeta itemMeta;

    public ItemBuilder(Material material) {
        this.itemStack = new ItemStack(material);
        this.itemMeta = this.itemStack.getItemMeta();
    }

    public ItemBuilder withName(String name) {
        this.itemMeta.setDisplayName(Chat.format(name));
        return this;
    }

    public ItemBuilder withLore(String... lore) {
        List<String> temporaryLore = Arrays.asList(lore);
        temporaryLore.forEach(Chat::format);
        this.itemMeta.setLore(temporaryLore);
        return this;
    }

    public ItemBuilder withHiddenEnchantment() {
        this.itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        this.itemMeta.addEnchant(Enchantment.LUCK, 1, true);
        return this;
    }

    public ItemStack build() {
        this.itemStack.setItemMeta(this.itemMeta);
        return this.itemStack;
    }
}
