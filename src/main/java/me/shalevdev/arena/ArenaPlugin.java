package me.shalevdev.arena;

import me.shalevdev.arena.commands.CommandsHandler;
import me.shalevdev.arena.config.SpringConfig;
import org.bukkit.plugin.java.JavaPlugin;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public final class ArenaPlugin extends JavaPlugin {
    private AnnotationConfigApplicationContext context;

    @Override
    public void onEnable() {
        initDependencyInjection();
        CommandsHandler commandsHandler = context.getBean(CommandsHandler.class);
        commandsHandler.registerCommands();
    }

    @Override
    public void onDisable() {
        if (context != null) {
            context.close();
        }
    }

    private void initDependencyInjection() {
        context = new AnnotationConfigApplicationContext() {{
            setClassLoader(getClass().getClassLoader());
            register(SpringConfig.class);

        }};
        context.getBeanFactory().registerSingleton("plugin", this);
        context.refresh();
    }
}
