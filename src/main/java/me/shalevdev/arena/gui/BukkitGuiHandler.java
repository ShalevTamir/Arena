package me.shalevdev.arena.gui;

import me.shalevdev.arena.gui.enums.GuiSize;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BukkitGuiHandler {
    private static final int AMOUNT_OF_COLUMNS = 9;
    private final Player inventoryOwner;
    private final Inventory inventory;
    public BukkitGuiHandler(GuiSize guiSize, Player inventoryOwner, String inventoryTitle) {
        this.inventory = Bukkit.createInventory(inventoryOwner, guiSize.getSlotCount(), inventoryTitle);
        this.inventory.setItem(45 / 2, new ItemStack(Material.ACACIA_FENCE));
        this.inventoryOwner = inventoryOwner;
    }

    public void open() {
        this.inventoryOwner.openInventory(this.inventory);
    }

    public void close() {
        this.inventoryOwner.closeInventory();
    }

    public void addItem(ItemStack itemToAdd) {
        this.inventory.addItem(itemToAdd);
    }

    public void addItem(ItemStack itemToAdd, int index) {
        this.inventory.setItem(index, itemToAdd);
    }

    public void applyBorder(ItemStack borderItem) {
        int firstRowIndex = 0;
        int lastRowIndex = this.inventory.getSize() / AMOUNT_OF_COLUMNS;

        this.fillRow(firstRowIndex, borderItem);
        for (int rowIndex = 1; rowIndex < lastRowIndex; rowIndex++) {
            int slotIndex = this.getSlotIndexOfRow(rowIndex);
            this.addItem(borderItem, slotIndex);
            this.addItem(borderItem, slotIndex + AMOUNT_OF_COLUMNS - 1);
        }
        this.fillRow(lastRowIndex, borderItem);
    }
    private void fillRow(int rowIndex, ItemStack item) {
        int startOfRowSlotIndex = getSlotIndexOfRow(rowIndex);
        int endOfRowSlotIndex = startOfRowSlotIndex + AMOUNT_OF_COLUMNS - 1;

        for (int slotIndex = startOfRowSlotIndex; slotIndex < endOfRowSlotIndex; slotIndex++) {
            this.addItem(item, slotIndex);
        }
    }

    private void addItemToRow()

    private int getSlotIndexOfRow(int rowIndex) {
        return rowIndex * AMOUNT_OF_COLUMNS;
    }
}
