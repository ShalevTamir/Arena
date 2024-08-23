package me.shalevdev.arena.commands.utils;

import me.shalevdev.arena.commands.interfaces.ISubCommandHandler;
import org.bukkit.command.CommandSender;

public class CommandUtils {
    private static CommandUtils instance;
    public static CommandUtils getInstance(){
        if (instance == null){
            instance = new CommandUtils();
        }
        return instance;
    }
    public boolean dispatchCommandToHandlers(CommandSender sender, String[] args, ISubCommandHandler ...handlers){
        for (ISubCommandHandler handler : handlers){
            if (handler.getSubcommandName().equals(args[0].toLowerCase()))
                return handler.handle(sender, args);
        }
        return false;
    }
}
