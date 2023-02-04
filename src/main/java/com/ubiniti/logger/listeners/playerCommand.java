package com.ubiniti.logger.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class playerCommand implements Listener {

    @EventHandler
    private void playerCommand(PlayerCommandPreprocessEvent e ) {
        Player player = e.getPlayer();
        String message = e.getMessage();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String dateTime = dtf.format(now);
        System.out.println("Command Executed from " + player.getName() + " on " + dateTime + " saying: " + message);

    }

}
