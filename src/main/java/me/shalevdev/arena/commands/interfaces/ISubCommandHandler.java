package me.shalevdev.arena.commands.interfaces;

import org.bukkit.command.CommandSender;

public interface ISubCommandHandler {
    boolean handle(CommandSender sender, String[] args);
    String getSubcommandName();
}
