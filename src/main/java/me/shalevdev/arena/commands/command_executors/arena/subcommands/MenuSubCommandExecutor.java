package me.shalevdev.arena.commands.command_executors.arena.subcommands;

import me.shalevdev.arena.commands.command_executors.BaseCommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.springframework.stereotype.Service;

@Service
public class MenuSubCommandExecutor extends BaseCommandExecutor {
    public MenuSubCommandExecutor(){
        super("menu");
    }

    @Override
    public boolean commandLogic(CommandSender sender, Command command, String label, String[] commandArgs) {
        sender.sendMessage("heyyy you have used the menu subcommand yayyy!!");
        return true;
    }
}
