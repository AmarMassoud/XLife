package me.amar.xlife.xlife;

import me.amar.xlife.xlife.Events.*;
import me.amar.xlife.xlife.commands.Files.DataYml;
import me.amar.xlife.xlife.commands.LifeXTabCompleter;
import me.amar.xlife.xlife.commands.XLifeCommandManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import javax.sql.DataSource;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public final class XLife extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        getCommand("xlife").setExecutor(new XLifeCommandManager());
        getCommand("xlife").setTabCompleter(new LifeXTabCompleter());
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
