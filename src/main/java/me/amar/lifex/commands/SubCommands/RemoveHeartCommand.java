package me.amar.lifex.commands.SubCommands;

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
        return "/xlife remove";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        String s = plugin.getConfig().getString("remove.material");
        int amount = plugin.getConfig().getInt("remove.amount");
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("xlife.remove")) {
                if (plugin.getConfig().getBoolean("remove.enabled")) {

//
//                    if (p.getInventory().contains(new ItemStack(XMaterial.valueOf(plugin.getConfig().getString("remove.material"))))) {
//
//                    }

                }


            }


        } else {
            sender.sendMessage(LifeX.colorize("&cThis command can only be used by players."));
        }
    }
}