package me.amar.lifex.commands;

import me.amar.lifex.API.Public;
import me.amar.lifex.Menus.LifeXMainMenu;
import me.amar.lifex.commands.SubCommands.*;
import me.amar.lifex.LifeX;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class LifeXCommandManager implements CommandExecutor {

    private final LifeX plugin = LifeX.getPlugin(LifeX.class);
    private ArrayList<SubCommand> SubCommands = new ArrayList<SubCommand>();


    public LifeXCommandManager() {
        SubCommands.add(new ResetHeartsCommand());
        SubCommands.add(new SetHeartCommands());
        SubCommands.add(new ListCommand());
        SubCommands.add(new RemoveHeartCommand());
        SubCommands.add(new WhitelistCommand());
    }



    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        String prefix = plugin.getConfig().getString("prefix") + " ";
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("reload")) {
                if (sender.hasPermission("lifex.reload")) {
                    plugin.reloadConfig();
                    sender.sendMessage(LifeX.colorize(prefix + "&cConfig has been reloaded successfully."));
                } else {
                    sender.sendMessage(LifeX.colorize(prefix + "&cYou do not have permission to use this command."));
                }
            } else if(!args[0].equalsIgnoreCase("reload")){


                for (int i = 0; i < getSubCommands().size(); i++) {
                    if (args[0].equalsIgnoreCase((getSubCommands().get(i)).getName()))
                        getSubCommands().get(i).perform(sender, args);
                }

            } else {
                Public.getHelpMethod(sender);
            }
        } else {
            if(sender.hasPermission("lifex.main")) {
                if(sender instanceof Player) {
                    new LifeXMainMenu((Player) sender);

                } else {
                sender.sendMessage(LifeX.colorize("This command can only be used players"));
                Public.getHelpMethod(sender);
                }
            } else {
                sender.sendMessage(LifeX.colorize(prefix + "&cYou do not have permission to use this command"));
            }
        }
            return true;

    }
    public ArrayList<SubCommand> getSubCommands() {

        return SubCommands;
    }

}
