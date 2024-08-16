package me.shalevdev.arena.commands.interfaces;

import org.bukkit.command.CommandSender;

public interface ICommandDispatcher extends INamedCommandExecutor {
    boolean dispatchCommandToHandlers(CommandSender sender, String[] args);
}
