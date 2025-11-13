package me.shalevdev.arena.kits;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class BaseKit {
    private ItemStack kitSymbol;

    protected abstract ItemStack[] buildKitItems();
    protected abstract ItemStack[] buildArmorItems();

    private void applyKitToPlayer(Player player) {

    }
}
