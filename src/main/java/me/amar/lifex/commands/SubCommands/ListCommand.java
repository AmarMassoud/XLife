package me.amar.lifex.commands.SubCommands;

import me.amar.lifex.commands.SubCommand;
import me.amar.lifex.LifeX;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


import java.util.*;

public class ListCommand extends SubCommand {
    private final LifeX plugin = LifeX.getPlugin(LifeX.class);

    @Override
    public String getName() {
        return "list";
    }

    @Override
    public String getDescription() {
        return "Sends the health of all online players.";
    }

    @Override
    public String getSyntax() {
        return "/life list";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        Map<String, Double> offline = new HashMap<>();
        Map<String, Double> online = new HashMap<>();
//
//        for (OfflinePlayer p : Bukkit.getOfflinePlayers()) {
//            if (offline != null) {
//                offline.put(p.getPlayer().getName(), p.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue());
//            }
//        }
//
//        for (Player p : Bukkit.getOnlinePlayers()) {
//            offline.put(p.getPlayer().getName(), p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue());
//        }
//
//        online = (Map<String, Double>) online.entrySet().stream().sorted(Map.Entry.comparingByValue());
//        offline = (Map<String, Double>) offline.entrySet().stream().sorted(Map.Entry.comparingByValue());
//
//        for (int i = 0; i < offline.size(); i++) {
//            if (!is_online(cast(offline.get(i)))) {
//                sender.sendMessage(offline.get(i) + " - " + offline.get(i) / 2);
//            }
//        }
//
//        for (int i = 0; i < online.size(); i++) {
//            sender.sendMessage(online.get(i) + " - " + online.get(i) / 2);
//        }
    }

    public boolean is_online(OfflinePlayer p) {
        for (Player o : Bukkit.getOnlinePlayers()) {
            if (o.getName().equals(p.getName())) {
                return true;
            }
        }
        return false;
    }

    public static OfflinePlayer cast(String c) {
        for (OfflinePlayer o : Bukkit.getOfflinePlayers()) {
            if (o.getName().equals(c)) {
                return o;
            }
        }
        return null;
    }

}

