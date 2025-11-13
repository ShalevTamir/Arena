package me.shalevdev.arena.models.commands.interfaces;

import org.bukkit.command.CommandExecutor;

public interface NamedCommandExecutor extends CommandExecutor {
    String getCommandName();
}
