package me.shalevdev.arena.commands.command_executors;

import me.shalevdev.arena.models.commands.interfaces.NamedCommandExecutor;
import me.shalevdev.arena.commands.validators.BaseValidator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.Arrays;

public abstract class BaseCommandExecutor implements NamedCommandExecutor {
    private final BaseValidator validator;
    private final String commandName;

    public BaseCommandExecutor(String commandName){
        this.commandName = commandName;
        this.validator = null;
    }
    public BaseCommandExecutor(String commandName, BaseValidator validator){
        this.commandName = commandName;
        this.validator = validator.getRootValidator();
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

    protected boolean delegateToSubCommand(CommandSender commandSender, Command command, String label, String[] commandArgs, NamedCommandExecutor ...possibleSubCommands){
        for (NamedCommandExecutor subCommandExecutor : possibleSubCommands){
            if (subCommandExecutor.getCommandName().equals(commandArgs[0].toLowerCase())) {
                String[] subCommandArgs = Arrays.copyOfRange(commandArgs, 1, commandArgs.length);
                return subCommandExecutor.onCommand(commandSender, command, label, subCommandArgs);
            }
        }
        return false;
    }

    protected abstract boolean commandLogic(CommandSender sender, Command command, String label, String[] commandArgs);
}
