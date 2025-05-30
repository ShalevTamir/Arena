package me.shalevdev.arena.commands;

import me.shalevdev.arena.ArenaPlugin;
import me.shalevdev.arena.commands.interfaces.NamedCommandExecutor;
import me.shalevdev.arena.commands.command_executors.arena.ArenaCommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandsHandler {
    private final NamedCommandExecutor[] commands;
    private final ArenaPlugin plugin;

    @Autowired
    public CommandsHandler(ArenaPlugin plugin, ArenaCommandExecutor arenaCommandExecutor){
        this.plugin = plugin;
        commands = new NamedCommandExecutor[] {
                arenaCommandExecutor
        };
    }

    public void registerCommands(){
         for (NamedCommandExecutor commandExecutor : this.commands){
             plugin.getCommand(commandExecutor.getCommandName()).setExecutor(commandExecutor);
         }
    }
}
