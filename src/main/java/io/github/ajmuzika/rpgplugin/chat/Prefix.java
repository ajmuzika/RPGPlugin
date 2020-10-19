package io.github.ajmuzika.rpgplugin.chat;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Prefix implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        String prefix = ChatColor.DARK_GREEN + "[" + "] ";
        e.setFormat(prefix + player.getDisplayName() + ": " + ChatColor.RESET + e.getMessage());
    }

}
