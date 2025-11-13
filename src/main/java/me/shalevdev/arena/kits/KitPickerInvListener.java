package me.shalevdev.arena.kits;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.springframework.stereotype.Service;

@Service
public class KitPickerInvListener implements Listener {
    private Inventory kitPickerInventory;

    public KitPickerInvListener() {
        this.kitPickerInventory = null;
    }

    public void setInventory(Inventory kitPickerInventory) {
        this.kitPickerInventory = kitPickerInventory;
    }

    @EventHandler
    public void onInventoryClick(final InventoryClickEvent event) {
        if (event.getInventory().equals(this.kitPickerInventory)) {
            event.setCancelled(true);
            this.dispatchToHandler(event.getCurrentItem());
        }
    }

    private void dispatchToHandler(ItemStack item) {
        if (item != null) {

        }
    }
}
