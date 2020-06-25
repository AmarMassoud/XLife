package me.amar.xlife.xlife.commands.SubCommands;

import me.amar.xlife.xlife.XLife;
import me.amar.xlife.xlife.commands.SubCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RemoveHeart extends SubCommand {
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
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("xlife.remove")) {



            }



        } else {
            sender.sendMessage(XLife.colorize("&cThis command can only be used by players."));
        }








    }
}
