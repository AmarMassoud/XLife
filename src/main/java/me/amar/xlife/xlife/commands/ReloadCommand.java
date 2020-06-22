package me.amar.xlife.xlife.commands;

import me.amar.xlife.xlife.XLife;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {
    private final XLife plugin = XLife.getPlugin(XLife.class);
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        plugin.reloadConfig();




        return true;
    }
}
