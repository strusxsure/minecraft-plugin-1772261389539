package com.stormai.plugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FeatherClickListener implements Listener {
    private final Main plugin;
    private final Map<UUID, Long> cooldownMap = new HashMap<>();

    public FeatherClickListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        if (event.getAction().isRightClick() && item != null && item.getType() == Material.FEATHER) {
            ItemMeta meta = item.getItemMeta();
            if (meta != null && meta.hasCustomModelData() && meta.getCustomModelData() == 1) {
                long currentTime = System.currentTimeMillis();
                long cooldown = cooldownMap.getOrDefault(player.getUniqueId(), 0L);

                if (currentTime < cooldown) {
                    long remaining = (cooldown - currentTime) / 1000;
                    player.sendMessage("§cCooldown! Wait " + remaining + " seconds.");
                    return;
                }

                activateFlight(player);
                cooldownMap.put(player.getUniqueId(), currentTime + 15000); // 5 seconds + 10 seconds flight = 15s total
            }
        }
    }

    private void activateFlight(Player player) {
        player.sendMessage("§eFlight activated for 10 seconds!");
        player.setAllowFlight(true);
        player.setFlying(true);

        new BukkitRunnable() {
            @Override
            public void run() {
                player.setAllowFlight(false);
                player.setFlying(false);
                player.sendMessage("§eFlight deactivated!");
            }
        }.runTaskLater(plugin, 200L); // 200 ticks = 10 seconds
    }
}