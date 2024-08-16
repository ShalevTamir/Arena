package me.shalevdev.arena.commands;

import me.shalevdev.arena.commands.interfaces.INamedCommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class ArenaCommand implements INamedCommandExecutor {
    private static ArenaCommand instance;
    private final String commandName = "arena";

    public static ArenaCommand getInstance() {
        if (instance == null){
            instance = new ArenaCommand();
        }
        return instance;
    }

    private ArenaCommand(){}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return true;
    }

    @Override
    public String getCommandName() {
        return this.commandName;
    }
}
