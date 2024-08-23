package me.shalevdev.arena.commands.root_level_commands;

import me.shalevdev.arena.commands.subcommand_handlers.arena.MenuSubcommand;
import me.shalevdev.arena.commands.utils.CommandUtils;
import me.shalevdev.arena.commands.validators.CommandArgsValidator;
import me.shalevdev.arena.commands.validators.PlayerValidator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class ArenaCommand extends BaseCommand {
    private static ArenaCommand instance;
    private final CommandUtils commandUtils;

    public static ArenaCommand getInstance() {
        if (instance == null){
            instance = new ArenaCommand();
        }
        return instance;
    }

    private ArenaCommand(){
        super(new PlayerValidator()
                        .setNext(new CommandArgsValidator()),
                "arena");



        this.commandUtils = CommandUtils.getInstance();
    }

    @Override
    public boolean commandLogic(CommandSender sender, Command command, String label, String[] commandArgs) {
        return commandUtils.dispatchCommandToHandlers(
                sender,
                commandArgs,
                MenuSubcommand.getInstance());
    }
}
