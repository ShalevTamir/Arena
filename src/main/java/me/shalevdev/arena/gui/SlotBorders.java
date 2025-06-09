package me.shalevdev.arena.gui;

public class SlotBorders {
    public int firstSlotIndex;
    public int lastSlotIndex;
    private int totalSlots;

    public SlotBorders() {}

    public SlotBorders(int firstSlotIndex, int totalSlots) {
        this.firstSlotIndex = firstSlotIndex;
        this.lastSlotIndex = totalSlots - 1;
        this.totalSlots = totalSlots;
    }

    public void narrowBorders() {
        this.firstSlotIndex++;
        this.lastSlotIndex--;
    }

    public int getTotalSlots() {
        return totalSlots;
    }

    public int getAvailableSlots() {
        return this.lastSlotIndex - this.firstSlotIndex + 1;
    }
}
