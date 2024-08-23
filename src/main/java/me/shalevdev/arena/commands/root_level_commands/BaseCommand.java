package me.shalevdev.arena.commands.root_level_commands;

import me.shalevdev.arena.commands.interfaces.INamedCommandExecutor;
import me.shalevdev.arena.commands.validators.BaseValidator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public abstract  class BaseCommand implements CommandExecutor, INamedCommandExecutor {
    private final BaseValidator validator;
    private final String commandName;

    public BaseCommand(String commandName){
        this.commandName = commandName;
        this.validator = null;
    }

    public BaseCommand(BaseValidator validator, String commandName){
        this.commandName = commandName;
        this.validator = validator.getRootValidator() == null ? validator : validator.getRootValidator();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] commandArgs) {
        if(validator == null || validator.validate(sender, commandArgs)){
            return commandLogic(sender, command, label, commandArgs);
        }
        else{
            return false;
        }
    }

    @Override
    public String getCommandName() {
        return commandName;
    }

    public abstract boolean commandLogic(CommandSender sender, Command command, String label, String[] commandArgs);
}
