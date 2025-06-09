package me.shalevdev.arena.gui.enums;

public enum GuiSize {
    SMALL(9),
    MEDIUM(36),
    LARGE(54);

    private final int slotCount;

    GuiSize(int slotCount) {
        this.slotCount = slotCount;
    }

    public int getSlotCount() {
        return this.slotCount;
    }
}
