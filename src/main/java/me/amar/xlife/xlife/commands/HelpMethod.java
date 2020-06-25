package me.amar.xlife.xlife.commands;

import me.amar.xlife.xlife.XLife;
import org.bukkit.command.CommandSender;

public class HelpMethod {

    public static void getHelpMethod(CommandSender p) {
        p.sendMessage(XLife.colorize("&cWrong usage; please use a valid command:"));
        p.sendMessage(XLife.colorize("&7&m---------&cCommands&7&m---------"));
        p.sendMessage(XLife.colorize("&c/xlife &bset <player> <hearts> &e- &9sets the hearts of a specific player to a specific number"));
        p.sendMessage(XLife.colorize("&c/xlife &bset <hearts> &e- &9sets your hearts to a specific number"));
        p.sendMessage(XLife.colorize("&c/xlife &breset <player> <hearts> &e- &9Resets the hearts of a specific player"));
        p.sendMessage(XLife.colorize("&c/xlife &breset <player> <hearts> &e- &9Resets your hearts"));
        p.sendMessage(XLife.colorize("&7&m--------------------------"));






    }



}
