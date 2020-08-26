package me.repayed.gametemplate.commands.subcommands;

import me.repayed.gametemplate.commands.SubCommand;
import org.bukkit.entity.Player;

public class ReloadSubCommand extends SubCommand {

    @Override
    protected String getName() {
        return "reload";
    }

    @Override
    protected String getUsage() {
        return "/gametemplate reload";
    }

    @Override
    protected String getDescription() {
        return "Reloads the configuration.";
    }

    @Override
    protected void execute(Player player, String[] args) {

    }
}
