package me.shalevdev.arena;

import me.shalevdev.arena.commands.CommandsHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class Arena extends JavaPlugin {

    private static Arena instance;
    public static Arena getInstance(){
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        CommandsHandler.getInstance().registerCommands();
    }

    @Override
    public void onDisable() {

    }
}
