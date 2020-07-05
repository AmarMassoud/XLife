package me.amar.lifex.API;

import me.amar.lifex.LifeX;
import org.bukkit.command.CommandSender;

public class Public {
        private final LifeX plugin = LifeX.getPlugin(LifeX.class);
    public static void getHelpMethod(CommandSender p) {
        p.sendMessage(LifeX.colorize("&cWrong usage; please use a valid command:"));
        p.sendMessage(LifeX.colorize("&7&m---------&cCommands&7&m---------"));
        p.sendMessage(LifeX.colorize("&c/life &bset <player> <hearts> &e- &9sets the hearts of a specific player to a specific number"));
        p.sendMessage(LifeX.colorize("&c/life &bset <hearts> &e- &9sets your hearts to a specific number"));
        p.sendMessage(LifeX.colorize("&c/life &breset <player> &e- &9Resets the hearts of a specific player"));
        p.sendMessage(LifeX.colorize("&c/life &breset &e- &9Resets your hearts"));
        p.sendMessage(LifeX.colorize("&c/life &breload &e- &9Reloads the config.yml"));
        p.sendMessage(LifeX.colorize("&c/life &bwhitelist <add/remove> <player> &e- &9Adds/removes a player from the whitelist"));
        p.sendMessage(LifeX.colorize("&7&m--------------------------"));
    }
    public String prefix = plugin.getConfig().getString("prefix") + " ";



}
