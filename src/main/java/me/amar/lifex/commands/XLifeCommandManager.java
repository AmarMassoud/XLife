package me.amar.lifex.commands;

import me.amar.lifex.commands.SubCommands.ListCommand;
import me.amar.lifex.commands.SubCommands.RemoveHeartCommand;
import me.amar.lifex.LifeX;
import me.amar.lifex.commands.SubCommands.ResetHeartsCommand;
import me.amar.lifex.commands.SubCommands.SetHeartCommands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

public class XLifeCommandManager implements CommandExecutor {

    private final LifeX plugin = LifeX.getPlugin(LifeX.class);
    private ArrayList<SubCommand> SubCommands = new ArrayList<SubCommand>();


    public XLifeCommandManager() {
        SubCommands.add(new ResetHeartsCommand());
        SubCommands.add(new SetHeartCommands());
        SubCommands.add(new ListCommand());
        SubCommands.add(new RemoveHeartCommand());
    }



    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("reload")) {
                if (sender.hasPermission("xlife.reload")) {
                    plugin.reloadConfig();
                    sender.sendMessage(LifeX.colorize("&cConfig has been reloaded successfully."));
                } else {
                    sender.sendMessage(LifeX.colorize("&cYou do not have permission to use this command."));
                }
            } else if(!args[0].equalsIgnoreCase("reload")){


                for (int i = 0; i < getSubCommands().size(); i++) {
                    if (args[0].equalsIgnoreCase((getSubCommands().get(i)).getName()))
                        getSubCommands().get(i).perform(sender, args);
                }

            } else {
                HelpMethod.getHelpMethod(sender);
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
