package me.repayed.gametemplate.commands;

import org.bukkit.entity.Player;

public abstract class SubCommand {

    protected abstract String getName();
    protected abstract String getUsage();
    protected abstract String getDescription();
    protected abstract void execute(Player player, String[] args);

}
