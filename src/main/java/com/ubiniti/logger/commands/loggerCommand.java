package com.ubiniti.logger.commands;

import com.ubiniti.logger.Logger;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class loggerCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.isOp()) {

                if (args.length == 0) {
                    player.sendMessage(Logger.prefix + "Logger is up and running keeping your server in check! " + ChatColor.GOLD + "/logger help " + ChatColor.RESET + "for more options!");
                } else if (args.length > 0 && args[0].equalsIgnoreCase("help")) {
                  player.sendMessage(Logger.prefix + "Help Menu:");
                  player.sendMessage("> /logger test");
                  player.sendMessage("> /logger export");
                  player.sendMessage("> /logger pause");
                  player.sendMessage("> /logger disable");
                  player.sendMessage("> /logger reload");
                } else {
                    player.sendMessage(Logger.prefix + ChatColor.RED + "Invalid command! Do " + ChatColor.GOLD + "/logger help " + ChatColor.RED + "for more options!");
                }
            } else {
                player.sendMessage(ChatColor.RED + "Unknown or incomplete command!");
            }
        }

        return true;
    }
}
