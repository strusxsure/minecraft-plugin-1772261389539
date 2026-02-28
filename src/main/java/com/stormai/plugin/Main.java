package com.stormai.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        getLogger().info("FlyFeather plugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("FlyFeather plugin disabled!");
    }
}