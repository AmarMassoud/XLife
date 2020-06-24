package me.amar.xlife.xlife.commands.SubCommands;

import me.amar.xlife.xlife.XLife;
import me.amar.xlife.xlife.commands.HelpMethod;
import me.amar.xlife.xlife.commands.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ResetHeartsCommand extends SubCommand {

    @Override
    public String getName() {
        return "reset";
    }

    @Override
    public String getDescription() {
        return "Reset the hearts of a specific player.";
    }

    @Override
    public String getSyntax() {
        return "/xlife reset <player> <hearts>";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        if(args.length == 2) {
            Player target = null;
            try {
                target = Bukkit.getPlayer(args[1]);
            } catch (Exception e) {
                sender.sendMessage(XLife.colorize("&cPlease provide a valid player"));
            }
            if(sender.hasPermission("xlife.reset")) {
                try{
                    target.setMaxHealth(2);
                } catch (Exception e) {
                    sender.sendMessage(XLife.colorize("Please provide a valid player"));
                }

            } else {
                sender.sendMessage(XLife.colorize("&cYou do not have permission to do that."));
            }
        } else if(args.length == 1) {
            if(sender instanceof Player) {
                ((Player) sender).setMaxHealth(2);
            } else {
                sender.sendMessage(XLife.colorize("&cThis command can only be used by players."));
            }
        } else {
            HelpMethod.getHelpMethod(sender);
        }

    }
}
