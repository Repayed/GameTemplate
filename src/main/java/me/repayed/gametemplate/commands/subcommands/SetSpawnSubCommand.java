package me.repayed.gametemplate.commands.subcommands;

import me.repayed.gametemplate.commands.SubCommand;
import org.bukkit.entity.Player;

public class SetSpawnSubCommand extends SubCommand {

    @Override
    protected String getName() {
        return "setspawn";
    }

    @Override
    protected String getUsage() {
        return "/gametemplate setspawn";
    }

    @Override
    protected String getDescription() {
        return "Sets the spawn for the game.";
    }

    @Override
    protected void execute(Player player, String[] args) {

    }
}
