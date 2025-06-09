package me.shalevdev.arena.commands.command_executors.arena.subcommands;

import me.shalevdev.arena.commands.command_executors.BaseCommandExecutor;
import me.shalevdev.arena.gui.BukkitGuiHandler;
import me.shalevdev.arena.gui.enums.GuiAlignment;
import me.shalevdev.arena.gui.enums.GuiSize;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StartSubCommandExecutor extends BaseCommandExecutor {
    public StartSubCommandExecutor() {
        super("start");
    }

    @Override
    public boolean commandLogic(CommandSender sender, Command command, String label, String[] commandArgs) {
        BukkitGuiHandler gui = new BukkitGuiHandler(GuiSize.LARGE, (Player) sender, "test");
        gui.applyBorder(new ItemStack(Material.ACACIA_DOOR));
        gui.applyBorder(new ItemStack(Material.AIR));
        ArrayList<ItemStack> items = new ArrayList<ItemStack>();
        for (int i = 0; i < 8; i++) {
            items.add(new ItemStack(Material.BEACON));
        }
        gui.addItemsToRow(GuiAlignment.MIDDLE, GuiAlignment.MIDDLE, items.toArray(new ItemStack[8]));
        gui.open();
        return true;
    }
}
