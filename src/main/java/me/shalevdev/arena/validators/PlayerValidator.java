package me.shalevdev.arena.validators;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerValidator extends BaseValidator {
    @Override
    public boolean validate(CommandSender sender, String[] commandArgs) {
        if (sender instanceof Player){
            return passToNextValidator(sender, commandArgs);
        }
        else{
            return false;
        }
    }
}
