package com.itdognorights.forcesocialdistancing;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class ForceSocalDistancing extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("[Force Socal Distancing] Plugin has been enabled");
        shieldCheckingTask();

    }

    public void shieldCheckingTask() {
        new BukkitRunnable() {
            @Override
            public void run() {
                teleportPlayersWithShield();
            }
        }.runTaskTimer(this, 0, 1);
    }

    public void teleportPlayersWithShield() {

        // Execute as @a
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getScoreboardTags().contains("shield")){
//                getServer().broadcastMessage("Shield Detected on player" + " " + player.getName());
                for (Entity entity : player.getNearbyEntities(3, 3, 3)) {
                    entity.teleport(player.getLocation().add(0, 0, -5));
                    getServer().broadcastMessage(entity.getName() + " " + "was pushed!");
                }
            }
        }
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("[Force Socal Distancing] Plugin has been disabled");
    }
}
