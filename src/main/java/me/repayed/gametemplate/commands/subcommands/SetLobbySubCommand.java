package me.repayed.gametemplate.commands.subcommands;

import me.repayed.gametemplate.GameTemplate;
import me.repayed.gametemplate.commands.SubCommand;
import org.bukkit.entity.Player;

public class SetLobbySubCommand extends SubCommand {

    private GameTemplate instance;

    public SetLobbySubCommand(GameTemplate gameTemplate) {
        this.instance = gameTemplate;
    }

    @Override
    protected String getName() {
        return "setlobby";
    }

    @Override
    protected String getUsage() {
        return "/gametemplate setlobby";
    }

    @Override
    protected String getDescription() {
        return "Sets the lobby for the game.";
    }

    @Override
    protected void execute(Player player, String[] args) {

    }
}
