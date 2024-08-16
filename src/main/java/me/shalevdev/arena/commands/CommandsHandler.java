package me.shalevdev.arena.commands;

import me.shalevdev.arena.Arena;
import me.shalevdev.arena.commands.interfaces.INamedCommandExecutor;
import me.shalevdev.arena.commands.root_level_commands.ArenaCommand;

import java.util.Objects;

public class CommandsHandler {
    private static CommandsHandler instance;
    private final INamedCommandExecutor[] commands;
    private final Arena mainInstance;
    public static CommandsHandler getInstance(){
        if (instance == null){
            instance = new CommandsHandler();
        }
        return instance;
    }

    private CommandsHandler(){
        mainInstance = Arena.getInstance();
        commands = new INamedCommandExecutor[] {
                ArenaCommand.getInstance()
        };
    }

    public void registerCommands(){
         for (INamedCommandExecutor command : this.commands){
             Objects.requireNonNull(mainInstance.getCommand(command.getCommandName())).setExecutor(command);
         }
    }
}
