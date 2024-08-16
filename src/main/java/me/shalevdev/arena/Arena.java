package me.shalevdev.arena;

import me.shalevdev.arena.commands.CommandHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class Arena extends JavaPlugin {

    private static Arena instance;
    public static Arena getInstance(){
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        CommandHandler.getInstance().registerCommands();
    }

    @Override
    public void onDisable() {

    }
}
