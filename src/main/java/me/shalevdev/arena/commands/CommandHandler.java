package me.shalevdev.arena.commands;

import me.shalevdev.arena.Arena;
import me.shalevdev.arena.commands.interfaces.INamedCommandExecutor;

import java.util.Objects;

public class CommandHandler {
    private static CommandHandler instance;
    private INamedCommandExecutor[] commands;
    private Arena mainInstance;
    public static CommandHandler getInstance(){
        if (instance == null){
            instance = new CommandHandler();
        }
        return instance;
    }

    private CommandHandler(){
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
