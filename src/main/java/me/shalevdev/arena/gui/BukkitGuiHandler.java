package me.shalevdev.arena.gui;

import me.shalevdev.arena.gui.enums.GuiAlignment;
import me.shalevdev.arena.gui.enums.GuiSize;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class BukkitGuiHandler {
    private static final int AMOUNT_OF_COLUMNS = 9;
    private final Player inventoryOwner;
    private final Inventory inventory;
    private final SlotBorders rowBorders;
    private final SlotBorders columnBorders;

    public BukkitGuiHandler(GuiSize guiSize, Player inventoryOwner, String inventoryTitle) {
        this.inventory = Bukkit.createInventory(inventoryOwner, guiSize.getSlotCount(), inventoryTitle);
        this.inventoryOwner = inventoryOwner;
        int rowsCount = this.inventory.getSize() / AMOUNT_OF_COLUMNS;
        this.rowBorders = new SlotBorders(0, rowsCount);
        this.columnBorders = new SlotBorders(0, AMOUNT_OF_COLUMNS);
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

    public void addItemsToRow(
            GuiAlignment itemsHorizontalAlignment,
            GuiAlignment itemsVerticalAlignment,
            ItemStack ...items) {
        int amountOfRowsTaken = items.length / this.columnBorders.getAvailableSlots();
        int startingRowIndex = getFirstSlotIndex(amountOfRowsTaken, itemsVerticalAlignment, this.rowBorders);
        for (int rowIndex = startingRowIndex; rowIndex <= this.rowBorders.lastSlotIndex && items.length > 0; rowIndex++) {
            System.out.println(this.columnBorders.getAvailableSlots());
            int itemsToExtractCount = Math.min(this.columnBorders.getAvailableSlots(), items.length);
            ItemStack[] itemsToInsert = Arrays.copyOfRange(items, 0, itemsToExtractCount);
            items = Arrays.copyOfRange(items, itemsToExtractCount, items.length);

            int startingColumnIndex = getFirstSlotIndex(itemsToInsert.length, itemsHorizontalAlignment, this.columnBorders);
            this.addItemsToRow(rowIndex, startingColumnIndex, itemsToInsert);
        }
    }

    private int getFirstSlotIndex(int amountOfSlotsTaken, GuiAlignment alignment, SlotBorders borders) {
        switch (alignment) {
            case START:
                return borders.firstSlotIndex;
            case MIDDLE:
                return (borders.getTotalSlots() - amountOfSlotsTaken) / 2;
            case END:
                return borders.lastSlotIndex - amountOfSlotsTaken;
            default:
                return 0;
        }
    }

    public void addItemsToRow(int rowIndex, int columnIndex, ItemStack ...items) {
        for (ItemStack itemToInsert: items) {
            this.addItemToRow(rowIndex, columnIndex, itemToInsert);
            columnIndex++;
        }
    }

    public void addItemToRow(int rowIndex, int columnIndex, ItemStack item) {
        int startOfRowSlotIndex = getSlotIndexOfRow(rowIndex);
        this.addItem(item, startOfRowSlotIndex + columnIndex);
    }

    public void applyBorder(ItemStack borderItem) {
        this.fillRow(this.rowBorders.firstSlotIndex, borderItem);
        // Fill edges of middle rows
        for (int rowIndex = 1; rowIndex < this.rowBorders.lastSlotIndex; rowIndex++) {
            this.addItemToRow(rowIndex, this.columnBorders.firstSlotIndex, borderItem);
            this.addItemToRow(rowIndex, this.columnBorders.lastSlotIndex, borderItem);
        }
        this.fillRow(this.rowBorders.lastSlotIndex, borderItem);

        this.rowBorders.narrowBorders();
        this.columnBorders.narrowBorders();
    }

    private void fillRow(int rowIndex, ItemStack item) {
        for (int columnIndex = this.columnBorders.firstSlotIndex; columnIndex <= this.columnBorders.lastSlotIndex; columnIndex++) {
            this.addItemToRow(rowIndex, columnIndex, item);
        }
    }

    private int getSlotIndexOfRow(int rowIndex) {
        return rowIndex * AMOUNT_OF_COLUMNS;
    }
}
