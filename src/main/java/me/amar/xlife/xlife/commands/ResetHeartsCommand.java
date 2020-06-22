package me.amar.xlife.xlife.commands;

import me.amar.xlife.xlife.XLife;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ResetHeartsCommand implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(args.length == 1) {
            Player target = null;
            try {
                target = Bukkit.getPlayer(args[0]);
            } catch (NullPointerException e) {
                sender.sendMessage(XLife.colorize("&cPlease provide a valid player"));
            }
                if(sender.hasPermission("xlife.reset")) {
                target.setMaxHealth(2);
            } else {
                    sender.sendMessage(XLife.colorize("&cYou do not have permission to do that."));
                }
        } else if(args.length == 0) {
            if(sender instanceof Player) {
                ((Player) sender).setMaxHealth(2);
            } else {
                sender.sendMessage(XLife.colorize("&cThis command can only be used by players."));
            }
        } else {
            sender.sendMessage(XLife.colorize("&cWrong usage."));
        }

        return true;
    }
}
