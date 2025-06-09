package me.shalevdev.arena.commands.command_executors.arena;

import me.shalevdev.arena.commands.command_executors.BaseCommandExecutor;
import me.shalevdev.arena.commands.command_executors.arena.subcommands.StartSubCommandExecutor;
import me.shalevdev.arena.commands.validators.CommandArgsValidator;
import me.shalevdev.arena.commands.validators.PlayerValidator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArenaCommandExecutor extends BaseCommandExecutor {
    private final StartSubCommandExecutor menuSubCommand;

    @Autowired
    public ArenaCommandExecutor(StartSubCommandExecutor menuSubCommand){
        super("arena",
                new PlayerValidator().setNext(new CommandArgsValidator()));
        this.menuSubCommand = menuSubCommand;
    }

    @Override
    public boolean commandLogic(CommandSender sender, Command command, String label, String[] commandArgs) {
        return delegateToSubCommand(sender, command, label, commandArgs, menuSubCommand);
    }
}
