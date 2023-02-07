package com.ubiniti.logger.listeners;

import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class playerBlock implements Listener {

    @EventHandler
    private void playerPlaced(BlockPlaceEvent e) {

        Player player = e.getPlayer();
        Block placed = e.getBlockPlaced();
        World placedWorld = e.getBlockPlaced().getWorld();
        System.out.println("[" + placedWorld.getName() + "] Block Placed at (" + placed.getLocation().getBlockX() + ", " + placed.getLocation().getBlockY() + ", " + placed.getLocation().getBlockZ() + ") by " + player.getName());

    }

}
