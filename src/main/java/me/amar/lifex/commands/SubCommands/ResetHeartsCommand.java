package me.amar.lifex.commands.SubCommands;

import me.amar.lifex.commands.HelpMethod;
import me.amar.lifex.commands.SubCommand;
import me.amar.lifex.LifeX;
import org.bukkit.Bukkit;
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
                sender.sendMessage(LifeX.colorize("&cPlease provide a valid player"));
            }
            if(sender.hasPermission("xlife.reset")) {
                try{
                    target.setMaxHealth(2);
                } catch (Exception e) {
                    sender.sendMessage(LifeX.colorize("Please provide a valid player"));
                }

            } else {
                sender.sendMessage(LifeX.colorize("&cYou do not have permission to do that."));
            }
        } else if(args.length == 1) {
            if(sender instanceof Player) {
                ((Player) sender).setMaxHealth(2);
            } else {
                sender.sendMessage(LifeX.colorize("&cThis command can only be used by players."));
            }
        } else {
            HelpMethod.getHelpMethod(sender);
        }

    }
}
