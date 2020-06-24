package me.amar.xlife.xlife.commands;

import me.amar.xlife.xlife.XLife;
import me.amar.xlife.xlife.commands.SubCommands.ListCommand;
import me.amar.xlife.xlife.commands.SubCommands.ResetHeartsCommand;
import me.amar.xlife.xlife.commands.SubCommands.SetHeartCommands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

public class XLifeCommandManager implements CommandExecutor {

    private final XLife plugin = XLife.getPlugin(XLife.class);
    private ArrayList<SubCommand> SubCommands = new ArrayList<SubCommand>();


    public XLifeCommandManager() {
        SubCommands.add(new ResetHeartsCommand());
        SubCommands.add(new SetHeartCommands());
        SubCommands.add(new ListCommand());
    }



    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("reload")) {
                if (sender.hasPermission("xlife.reload")) {
                    plugin.reloadConfig();
                    sender.sendMessage(XLife.colorize("&cConfig has been reloaded successfully."));
                } else {
                    sender.sendMessage(XLife.colorize("&cYou do not have permission to use this command."));
                }
            } else {


                for (int i = 0; i < getSubCommands().size(); i++) {
                    if (args[0].equalsIgnoreCase((getSubCommands().get(i)).getName()))
                        getSubCommands().get(i).perform(sender, args);
                }

            }
        } else {
            HelpMethod.getHelpMethod(sender);
        }
            return true;

    }
    public ArrayList<SubCommand> getSubCommands() {

        return SubCommands;
    }

}
