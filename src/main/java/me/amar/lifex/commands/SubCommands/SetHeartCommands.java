package me.amar.lifex.commands.SubCommands;

import me.amar.lifex.commands.HelpMethod;
import me.amar.lifex.commands.SubCommand;
import me.amar.lifex.LifeX;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetHeartCommands extends SubCommand {
    @Override
    public String getName() {
        return "set";
    }

    @Override
    public String getDescription() {
        return "Set the hearts of a specific player";
    }

    @Override
    public String getSyntax() {
        return "/xlife set <player> <hearts>";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {

        if (args.length == 3) { // /xlife set magnifiedneonate 2
            Player target = null;
            try {
                target = Bukkit.getPlayer(args[1]);
            } catch (NullPointerException e) {
                sender.sendMessage(LifeX.colorize("&cPlease provide a valid player"));
            }
            if (sender.hasPermission("xlife.reset")) {
                try {
                    int number = (int) Double.parseDouble(args[2]) * 2;
                    target.setMaxHealth(number);
                    target.setHealth(number);
                } catch(Exception e) {
                    sender.sendMessage(LifeX.colorize("&cPlease provide a valid player"));
                }
            } else {
                sender.sendMessage(LifeX.colorize("&cYou do not have permission to do that."));
            }
        } else if(args.length == 2) { // /xlife set 2
            if (sender instanceof Player) {
                if (args[1].equals("0")) {
                    sender.sendMessage(LifeX.colorize("&cplease use proper numbers."));
                } else {
                try {
                    int number = (int) Double.parseDouble(args[1]) * 2;
                    ((Player) sender).setMaxHealth(number);
                    ((Player) sender).setHealth(number);
                } catch (Exception e) {
                    sender.sendMessage(LifeX.colorize("&cPlease provide a valid number"));
                }
            }
        } else {
                sender.sendMessage(LifeX.colorize("&cYou can not change your hearts, silly!"));
            }
        } else if(args.length == 1) {
            HelpMethod.getHelpMethod(sender);

        }
    }
}
