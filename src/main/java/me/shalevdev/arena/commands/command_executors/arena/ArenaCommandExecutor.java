package me.shalevdev.arena.commands.command_executors.arena;

import me.shalevdev.arena.commands.command_executors.BaseCommandExecutor;
import me.shalevdev.arena.commands.command_executors.arena.subcommands.MenuSubCommandExecutor;
import me.shalevdev.arena.validators.CommandArgsValidator;
import me.shalevdev.arena.validators.PlayerValidator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArenaCommandExecutor extends BaseCommandExecutor {
    private final MenuSubCommandExecutor menuSubCommand;

    @Autowired
    public ArenaCommandExecutor(MenuSubCommandExecutor menuSubCommand){
        super("arena",
                new PlayerValidator().setNext(new CommandArgsValidator()));
        this.menuSubCommand = menuSubCommand;
    }

    @Override
    public boolean commandLogic(CommandSender sender, Command command, String label, String[] commandArgs) {
        return delegateToSubCommand(sender, command, label, commandArgs, menuSubCommand);
    }
}
