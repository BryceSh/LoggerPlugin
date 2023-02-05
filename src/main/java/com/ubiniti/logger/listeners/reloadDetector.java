package com.ubiniti.logger.listeners;

import com.ubiniti.logger.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.Plugin;


public class reloadDetector implements Listener {

    Plugin plugin = Logger.getPlugin(Logger.class);

    @EventHandler
    private void playerCommand(PlayerCommandPreprocessEvent e ) {
        if (e.getMessage().equalsIgnoreCase("/reload") && e.getPlayer().isOp()) {
            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                e.getPlayer().sendMessage("");
                e.getPlayer().sendMessage("" +ChatColor.DARK_RED + ChatColor.BOLD + "Notice!" + ChatColor.RED + "Logger has been disabled due to a server reload! To re-enable logger, please restart your server!");
                e.getPlayer().sendMessage("");
            }, (5) * 20L);

        }

    }

}
