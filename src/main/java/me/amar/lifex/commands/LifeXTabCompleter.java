package me.amar.lifex.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class LifeXTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args) {


        if (command.getName().equalsIgnoreCase("xlife")) {
        if (args.length == 1) {
            List<String> arguments = new ArrayList<>();
            arguments.add("set");
            arguments.add("reset");
            return arguments;
        } else if (args.length == 2) {
                List<String> playerNames = new ArrayList<>();
                Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
                Bukkit.getServer().getOnlinePlayers().toArray(players);
                for (int i = 0; i < players.length; i++) {
                    playerNames.add(players[i].getName());
                }
                return playerNames;
            } else {
            List<String> none = new ArrayList<>();
            none.add("Invalid usage of arguments.");
            return none;
        }
        }
        return null;
    }
}
