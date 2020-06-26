package me.amar.lifex.commands.SubCommands;

import me.amar.lifex.API.Public;
import me.amar.lifex.API.newItemStack;
import me.amar.lifex.commands.SubCommand;
import me.amar.lifex.LifeX;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RemoveHeartCommand extends SubCommand {
    private final LifeX plugin = LifeX.getPlugin(LifeX.class);

    @Override
    public String getName() {
        return "remove";
    }

    @Override
    public String getDescription() {
        return "Removes a heart if you have specified materials with a specified amount.";
    }

    @Override
    public String getSyntax() {
        return "/life remove";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        String prefix = plugin.getConfig().getString("prefix") + " ";
          if (sender instanceof Player) {
            Player p = (Player) sender;
                if (plugin.getConfig().getBoolean("removeHeartCommand.enabled")) {
                    if (p.hasPermission("life.remove")) {
                        if (p.getInventory().contains(newItemStack.getMaterial(plugin.getConfig().getString("removeHeartCommand.material")))) {
                            p.setMaxHealth(p.getMaxHealth() + 2);
                            p.setHealth(p.getMaxHealth());
                            p.sendMessage(LifeX.colorize(prefix + "&cYou have been granted one heart for your great work!"));
                            p.getInventory().remove(newItemStack.getMaterial(plugin.getConfig().getString("removeHeartCommand.material")));
                        } else {
                            p.sendMessage(LifeX.colorize(prefix + "&cYou do not have enough items to use this command."));
                        }


                    } else {
                        p.sendMessage(LifeX.colorize(prefix + "&cYou do not have enough permission to use this command."));
                    }
                } else {
                    p.sendMessage(LifeX.colorize(prefix + "&cThis feature has been disabled by the administrators."));
                }

        } else {
            sender.sendMessage(LifeX.colorize(prefix + "&cThis command can only be used by players."));
        }
    }
}