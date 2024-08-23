package me.shalevdev.arena.commands.validators;

import org.bukkit.command.CommandSender;

public class CommandArgsValidator extends BaseValidator {
    @Override
    public boolean validate(CommandSender sender, String[] commandArgs) {
        if (commandArgs.length > 0){
            return passToNextValidator(sender, commandArgs);
        }
        else{
            return false;
        }
    }
}
