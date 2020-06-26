package me.amar.lifex;

import me.amar.lifex.Events.*;
import me.amar.lifex.commands.Files.DataYml;
import me.amar.lifex.commands.LifeXTabCompleter;
import me.amar.lifex.commands.LifeXCommandManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;

public final class LifeX extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        getCommand("life").setExecutor(new LifeXCommandManager());
        getCommand("life").setTabCompleter(new LifeXTabCompleter());
        Bukkit.getPluginManager().registerEvents(new OnDamageEvent(), this);
        Bukkit.getPluginManager().registerEvents(new OnFirstJoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new OnPlayerRespawnEvent(), this);
        Bukkit.getPluginManager().registerEvents(new OnChatEvent(), this);
        loadConfigManager();
        getLogger().info("LifeX " + getDescription().getVersion() + " has been enabled");

    }

    @Override
    public void onDisable() {
        getLogger().info("LifeX " + getDescription().getVersion() + " has been disabled.");
    }

    public static String colorize(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public void loadConfigManager() {
        DataYml.setUpDataYml();
        final List<String> whitelistedplayers = Arrays.asList();
        DataYml.getDataYml().addDefault("whitelisted-players", whitelistedplayers);
        DataYml.reloadDataYml();
        DataYml.getDataYml().options().copyDefaults(true);
        DataYml.saveDataYml();
    }

}
