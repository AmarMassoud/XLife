package me.amar.xlife.xlife.commands.Files;

import me.amar.xlife.xlife.XLife;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class DataYml {

    private static XLife plugin = XLife.getPlugin(XLife.class);

    public static FileConfiguration dataYml;
    public static File dataFile;

    public static void setUpDataYml() {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdirs();
        }

        dataFile = new File(plugin.getDataFolder(), "data.yml");


        if (!dataFile.exists()) {
            try {
                dataFile.createNewFile();
                Bukkit.getConsoleSender().sendMessage(XLife.colorize("&eLoaded data.yml &asuccessfully"));
            } catch (IOException e) {
                Bukkit.getConsoleSender().sendMessage(XLife.colorize("&cCould not load data.yml"));
                e.printStackTrace();
            }

        }

        dataYml = YamlConfiguration.loadConfiguration(dataFile);


    }

    public static FileConfiguration getDataYml() {
        return dataYml;
    }

    public static void saveDataYml() {
        try {
            dataYml.save(dataFile);
        } catch (IOException e) {
            Bukkit.getConsoleSender().sendMessage(XLife.colorize("&cCould not save data.yml"));
            e.printStackTrace();
        }
    }

    public static void reloadDataYml() {
        dataYml = YamlConfiguration.loadConfiguration(dataFile);
        Bukkit.getConsoleSender().sendMessage(XLife.colorize("&eReloaded data.yml &asuccessfully"));
    }
    public static Double getString(String node) {
        return DataYml.getString(node);
    }

    public static void setString(String node, String value) {
        DataYml.setString(node, value);
    }



}
