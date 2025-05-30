package me.shalevdev.arena.commands.interfaces;

import org.bukkit.command.CommandExecutor;

public interface NamedCommandExecutor extends CommandExecutor {
    String getCommandName();
}
