package me.shalevdev.arena.commands.subcommand_handlers.arena;

import me.shalevdev.arena.commands.interfaces.ISubCommandHandler;
import org.bukkit.command.CommandSender;

public class MenuSubcommand implements ISubCommandHandler {
    private static MenuSubcommand instance;
    private final String name;

    public static MenuSubcommand getInstance(){
        if (instance == null){
            instance = new MenuSubcommand();
        }
        return instance;
    }
    private MenuSubcommand(){
        name = "menu";
    }

    @Override
    public boolean handle(CommandSender sender, String[] args) {
        sender.sendMessage("heyyy you have used the menu subcommand yayyy!!");
        return true;
    }

    @Override
    public String getSubcommandName(){
        return name;
    }
}
