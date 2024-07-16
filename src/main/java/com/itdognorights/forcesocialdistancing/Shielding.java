package com.itdognorights.forcesocialdistancing;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Shielding {
//    public void shieldCheckingTask(){
//        new BukkitRunnable() {
//            @Override
//            public void run(){
//                teleportPlayersWithShield();
//            }
//        }.runTaskTimer(this, 0, 20);
//    }

    public void teleportPlayersWithShield(){
        for (Player player : Bukkit.getOnlinePlayers()){

            // Loop through all online players and assign a default hasShield variable of false
            if (player.getGameMode() != GameMode.SPECTATOR && !player.getName().equals("Sam")) {
                boolean hasShield = false;

                // If the entity tag contains shield, then assign hasShield to true
                 for (Entity entity : player.getNearbyEntities(12, 12, 12)){
                     if (entity instanceof Player && entity.getCustomName() != null && entity.getCustomName().contains("shield") && entity.getScoreboardTags().contains("shield")){
                         hasShield = true;
                     }
                 }
                 if (hasShield){
                     player.teleport(player.getLocation().add(0, 0, -25));
                 }
            }


        }
    }
}
