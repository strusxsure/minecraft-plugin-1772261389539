package com.stormai.plugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;

public class JoinListener implements Listener {
    private final Main plugin;

    public JoinListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        ItemStack feather = new ItemStack(Material.FEATHER, 1);
        ItemMeta meta = feather.getItemMeta();
        meta.setDisplayName("§6§lFly Feather");
        meta.setCustomModelData(1);
        feather.setItemMeta(meta);

        player.getInventory().addItem(feather);
        player.sendMessage("§eYou received a Fly Feather! Right click to activate.");
    }
}