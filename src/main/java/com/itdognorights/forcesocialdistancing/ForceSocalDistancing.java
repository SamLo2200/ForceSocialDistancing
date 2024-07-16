package com.itdognorights.forcesocialdistancing;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ForceSocalDistancing extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("[Force Socal Distancing] Plugin has been enabled");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("[Force Socal Distancing] Plugin has been disabled");
    }
}
