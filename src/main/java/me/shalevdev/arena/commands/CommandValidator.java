package me.shalevdev.arena.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandValidator {
    private static CommandValidator instance;
    public static CommandValidator getInstance(){
        if (instance == null){
            instance = new CommandValidator();
        }
        return instance;
    }
    private CommandValidator(){}

    public boolean isProperArgsLength(String[] args){
        return args.length > 0;
    }

    public boolean isPlayerSender(CommandSender sender){
        return sender instanceof Player;
    }
}
