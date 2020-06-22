package me.amar.xlife.xlife;

import com.google.gson.internal.$Gson$Preconditions;
import com.sun.org.glassfish.external.statistics.annotations.Reset;
import me.amar.xlife.xlife.Events.OnDamageEvent;
import me.amar.xlife.xlife.Events.OnFirstJoinEvent;
import me.amar.xlife.xlife.commands.ReloadCommand;
import me.amar.xlife.xlife.commands.ResetHeartsCommand;
import me.amar.xlife.xlife.commands.SetHeartCommands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class XLife extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        getCommand("reset").setExecutor(new ResetHeartsCommand());
        getCommand("set").setExecutor(new SetHeartCommands());
        getCommand("rlconfig").setExecutor(new ReloadCommand());
        Bukkit.getPluginManager().registerEvents(new OnDamageEvent(), this);
        Bukkit.getPluginManager().registerEvents(new OnFirstJoinEvent(), this);
        getLogger().info("XLife " + getDescription().getVersion() + " has been enabled");

    }

    @Override
    public void onDisable() {
        getLogger().info("XLife " + getDescription().getVersion() + " has been disabled.");
    }
    public static String colorize(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }


}
