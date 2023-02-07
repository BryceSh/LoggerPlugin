package com.ubiniti.logger;

import com.ubiniti.logger.commands.loggerCommand;
import com.ubiniti.logger.listeners.playerChatted;
import com.ubiniti.logger.listeners.playerCommand;
import com.ubiniti.logger.listeners.reloadDetector;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Logger extends JavaPlugin {

    public static final String prefix = "" + ChatColor.AQUA + ChatColor.BOLD + "Logger" + ChatColor.GOLD + ChatColor.BOLD + " >> " + ChatColor.RESET;

    @Override
    public void onEnable() {
        // Plugin startup logic

        loadConfig();

        if (startup()) {
            System.out.println("\n" + ChatColor.GREEN + "Logging is enabled!\n");
        } else {
            System.out.println("\n" + ChatColor.DARK_RED + "Unable to create log directory. Logging has been disabled!\n");
        }

        System.out.println("Attempting to connect to database...");
        System.out.println("Connection failed, logging will be done in text files. Do /logger retry to try to connect to your database again.");

        getServer().getPluginManager().registerEvents(new playerChatted(), this);
        getServer().getPluginManager().registerEvents(new playerCommand(), this);
        getServer().getPluginManager().registerEvents(new reloadDetector(), this);
        getCommand("logger").setExecutor(new loggerCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private boolean startup() {
        // Checks for log folder, if no folder exist, create one!
        File f = new File("logs");
        return f.exists() && f.isDirectory();
    }

    public static boolean log(String message, int type) {
        if (type == 1) {

        }
        return false;
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }


}
