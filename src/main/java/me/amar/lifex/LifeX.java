package me.amar.lifex;

import me.amar.lifex.Events.*;
import me.amar.lifex.commands.Files.DataYml;
import me.amar.lifex.commands.LifeXTabCompleter;
import me.amar.lifex.commands.XLifeCommandManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class LifeX extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        getCommand("life").setExecutor(new XLifeCommandManager());
        getCommand("life").setTabCompleter(new LifeXTabCompleter());
        Bukkit.getPluginManager().registerEvents(new OnDamageEvent(), this);
        Bukkit.getPluginManager().registerEvents(new OnFirstJoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new QuitEvent(), this);
        Bukkit.getPluginManager().registerEvents(new OnPlayerJoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new EntityRegenEvent(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerGameModeChangeEvent(), this);
        Bukkit.getPluginManager().registerEvents(new OnPlayerRespawnEvent(), this);
        loadConfigManager();
        DataYml.getDataYml().set("health.random.health", "56498745468465ABCZ");
        DataYml.saveDataYml();
        getLogger().info("XLife " + getDescription().getVersion() + " has been enabled");

    }

    @Override
    public void onDisable() {
        getLogger().info("XLife " + getDescription().getVersion() + " has been disabled.");
    }

    public static String colorize(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public void loadConfigManager() {
        DataYml.setUpDataYml();
        DataYml.reloadDataYml();
        DataYml.getDataYml().options().copyDefaults(true);
        DataYml.saveDataYml();
    }

}
