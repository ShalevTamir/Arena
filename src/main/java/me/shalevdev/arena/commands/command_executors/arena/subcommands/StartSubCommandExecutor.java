package me.shalevdev.arena.commands.command_executors.arena.subcommands;

import me.shalevdev.arena.commands.command_executors.BaseCommandExecutor;
import me.shalevdev.arena.gui.BukkitGuiHandler;
import me.shalevdev.arena.gui.enums.GuiSize;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.springframework.stereotype.Service;

@Service
public class StartSubCommandExecutor extends BaseCommandExecutor {
    public StartSubCommandExecutor(){
        super("start");
    }

    @Override
    public boolean commandLogic(CommandSender sender, Command command, String label, String[] commandArgs) {
        BukkitGuiHandler gui = new BukkitGuiHandler(GuiSize.LARGE, (Player) sender, "test");
        gui.open();
        return true;
    }
}
