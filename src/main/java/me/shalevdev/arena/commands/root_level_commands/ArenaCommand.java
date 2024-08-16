package me.shalevdev.arena.commands.root_level_commands;

import me.shalevdev.arena.commands.CommandValidator;
import me.shalevdev.arena.commands.interfaces.INamedCommandExecutor;
import me.shalevdev.arena.commands.subcommand_handlers.arena.MenuSubcommand;
import me.shalevdev.arena.commands.utils.CommandUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArenaCommand implements INamedCommandExecutor {
    private static ArenaCommand instance;
    private final String commandName = "arena";
    private final CommandValidator validator;
    private final CommandUtils commandUtils;

    public static ArenaCommand getInstance() {
        if (instance == null){
            instance = new ArenaCommand();
        }
        return instance;
    }

    private ArenaCommand(){
        this.validator = CommandValidator.getInstance();
        this.commandUtils = CommandUtils.getInstance();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        List<Boolean> validations = Arrays.asList(
                validator.isPlayerSender(sender),
                validator.isProperArgsLength(args)
        );
        if (validations.stream().anyMatch(validationResult -> !validationResult)){
            return false;
        }

        return commandUtils.dispatchCommandToHandlers(
                Collections.singletonList(MenuSubcommand.getInstance()),
                sender,
                args);
    }

    @Override
    public String getCommandName() {
        return this.commandName;
    }
}
