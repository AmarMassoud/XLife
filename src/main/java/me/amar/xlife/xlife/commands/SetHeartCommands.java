package me.amar.xlife.xlife.commands;

import me.amar.xlife.xlife.XLife;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetHeartCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (args.length == 2) {
            Player target = null;
            try {
                target = Bukkit.getPlayer(args[0]);
            } catch (NullPointerException e) {
                sender.sendMessage(XLife.colorize("&cPlease provide a valid player"));
            }
            if (sender.hasPermission("xlife.reset")) {
                try {
                    int number = (int) Double.parseDouble(args[1]) * 2;
                    target.setMaxHealth(number);
                    target.setHealth(number);
                } catch(NullPointerException e) {
                    sender.sendMessage(XLife.colorize("Please provide a valid number"));
                }
                } else {
                sender.sendMessage(XLife.colorize("&cYou do not have permission to do that."));
            }
        } else if(args.length == 1) {
            if(sender instanceof Player) {
                if(args[0].equals("0")) {
                    sender.sendMessage(XLife.colorize("&cplease use proper numbers."));
                }
                try {
                    int number = (int) Double.parseDouble(args[0]) * 2;
                    ((Player) sender).setMaxHealth(number);
                    ((Player) sender).setHealth(number);
                } catch (NullPointerException e) {
                    sender.sendMessage(XLife.colorize("Please provide a valid number"));
                }
            }

        }
        return true;
    }
}
