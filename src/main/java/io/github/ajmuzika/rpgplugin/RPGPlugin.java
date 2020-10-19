package io.github.ajmuzika.rpgplugin;

import io.github.ajmuzika.rpgplugin.chat.Prefix;
import io.github.ajmuzika.rpgplugin.commands.Roll;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RPGPlugin extends JavaPlugin{
    @Override
    public void onEnable() {
        getLogger().info("RPGPlugin has been enabled!");

        PluginManager pluginManager = this.getServer().getPluginManager();

        getCommand("roll").setExecutor(new Roll());
        pluginManager.registerEvents(new Prefix(), this);

    }

    @Override
    public void onDisable() {
        getLogger().info("RPGPlugin has been disabled.");
    }
}
