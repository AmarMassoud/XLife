package me.amar.lifex.commands;

import me.amar.lifex.LifeX;
import org.bukkit.command.CommandSender;

public class HelpMethod {

    public static void getHelpMethod(CommandSender p) {
        p.sendMessage(LifeX.colorize("&cWrong usage; please use a valid command:"));
        p.sendMessage(LifeX.colorize("&7&m---------&cCommands&7&m---------"));
        p.sendMessage(LifeX.colorize("&c/life &bset <player> <hearts> &e- &9sets the hearts of a specific player to a specific number"));
        p.sendMessage(LifeX.colorize("&c/life &bset <hearts> &e- &9sets your hearts to a specific number"));
        p.sendMessage(LifeX.colorize("&c/life &breset <player> &e- &9Resets the hearts of a specific player"));
        p.sendMessage(LifeX.colorize("&c/life &breset &e- &9Resets your hearts"));
        p.sendMessage(LifeX.colorize("&7&m--------------------------"));






    }



}
