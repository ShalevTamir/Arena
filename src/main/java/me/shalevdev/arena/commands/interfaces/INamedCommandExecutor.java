package me.shalevdev.arena.commands.interfaces;

import org.bukkit.command.CommandExecutor;

public interface INamedCommandExecutor extends CommandExecutor {
    String getCommandName();
}
