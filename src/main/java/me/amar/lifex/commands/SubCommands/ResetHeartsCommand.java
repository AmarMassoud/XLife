package me.amar.lifex.commands.SubCommands;

import me.amar.lifex.API.Public;
import me.amar.lifex.commands.SubCommand;
import me.amar.lifex.LifeX;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ResetHeartsCommand extends SubCommand {
    private final LifeX plugin = LifeX.getPlugin(LifeX.class);
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
        return "/life reset <player> <hearts>";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        String prefix = plugin.getConfig().getString("prefix") + " ";
        if(args.length == 2) {
            Player target = null;
            try {
                target = Bukkit.getPlayer(args[1]);
            } catch (Exception e) {
                sender.sendMessage(LifeX.colorize(prefix + "&cPlease provide a valid player"));
            }
            if(sender.hasPermission("lifex.reset")) {
                try{
                    target.setMaxHealth(2);
                    sender.sendMessage(LifeX.colorize(prefix + "&b" + target.getDisplayName() + " &chearts has been reset."));
                } catch (Exception e) {
                    sender.sendMessage(LifeX.colorize(prefix + "Please provide a valid player"));
                }

            } else {
                sender.sendMessage(LifeX.colorize(prefix + "&cYou do not have permission to use this command."));
            }
        } else if(args.length == 1) {
            if(sender instanceof Player) {
                Player p = (Player) sender;
                p.setMaxHealth(2);
                sender.sendMessage(LifeX.colorize(prefix + "&bYour &chearts has been reset."));
            } else {
                sender.sendMessage(LifeX.colorize(prefix + "&cThis command can only be used by players."));
            }
        } else {
            Public.getHelpMethod(sender);
        }

    }
}
