package me.shalevdev.arena.config;

import me.shalevdev.arena.commands.command_executors.BaseCommandExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "me.shalevdev.arena")
public class SpringConfig {

}
