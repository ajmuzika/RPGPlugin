package io.github.ajmuzika.rpgplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Roll implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You must be a player to execute this command.");
            return false;
        }
        Player player = (Player) sender;

        if (!player.hasPermission("rpg.roll")) {
            player.sendMessage(ChatColor.RED + "You are not permitted to do this.");
            return false;
        }

        if (args.length > 3) {
            player.sendMessage(ChatColor.RED + "Unknown arguments.");
            return false;
        }

        if (args.length == 0) {
            player.sendMessage(ChatColor.DARK_PURPLE + rollDice(1, 10) + " was rolled!");
            return true;
        } else if (args.length <= 2) {
            if (args.length == 1) {
                try {
                    player.sendMessage(ChatColor.DARK_PURPLE + rollDice(Integer.parseInt(args[0])));
                    return true;
                } catch (NumberFormatException e) {
                    player.sendMessage(ChatColor.RED + "Invalid maximum.");
                    return false;
                }
            } else {
                try {
                    if (Integer.parseInt(args[0]) > Integer.parseInt(args[1])) {
                        String temp = args[0];
                        args[0] = args[1];
                        args[1] = temp;
                    }
                    player.sendMessage(ChatColor.DARK_PURPLE + rollDice(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
                    return true;
                } catch (NumberFormatException e) {
                    player.sendMessage(ChatColor.RED + "Invalid range.");
                    return false;
                }
            }
        }

        return false;
    }

    /**
     * Generates a random number between 1 and the specified maximum.
     * @param max the maximum random number.
     * @return a random number between 1 and max.
     */
    public String rollDice(int max) {
        return Integer.toString((int) Math.round((Math.random() * (max - 1)) + 1));
    }

    /**
     * Generates a random number between the specified parameters.
     * @param min the lowest number possible.
     * @param max the greatest number possible.
     * @return a number between max and min.
     */
    public String rollDice(int min, int max) {
        return Integer.toString((int) Math.round((Math.random() * (max - min)) + min));
    }
}
