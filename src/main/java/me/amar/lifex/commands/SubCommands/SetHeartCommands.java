package me.amar.lifex.commands.SubCommands;

import me.amar.lifex.API.Public;
import me.amar.lifex.commands.SubCommand;
import me.amar.lifex.LifeX;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetHeartCommands extends SubCommand {
    private final LifeX plugin = LifeX.getPlugin(LifeX.class);
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
        return "/life set <player> <hearts>";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        String prefix = plugin.getConfig().getString("prefix") + " ";
        if (args.length == 3) { // /life set magnifiedneonate 2
            Player target = null;
            try {
                target = Bukkit.getPlayer(args[1]);
            } catch (NullPointerException e) {
                sender.sendMessage(LifeX.colorize("&cPlease provide a valid player"));
            }
            if (sender.hasPermission("lifex.set")) {
                try {
                    int number = (int) Double.parseDouble(args[2]) * 2;
                    target.setMaxHealth(number);
                    target.setHealth(number);
                    target.sendMessage(LifeX.colorize(prefix + "&cYour health has been set to &e" + target.getMaxHealth() / 2+ " &cby an administrator"));
                    sender.sendMessage(LifeX.colorize(prefix + "&b" + target.getName() + " &cHearts has been set to &e" + target.getMaxHealth() /2));
                } catch(Exception e) {
                    sender.sendMessage(LifeX.colorize(prefix + "&cPlease provide a valid player"));
                }
            } else {
                sender.sendMessage(LifeX.colorize(prefix + "&cYou do not have permission to use this command."));
            }
        } else if(args.length == 2) { // /life set 2
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (args[1].equals("0")) {
                    p.sendMessage(LifeX.colorize(prefix + "&cplease use proper numbers."));
                } else {
                try {
                    int number = (int) Double.parseDouble(args[1]) * 2;
                    p.setMaxHealth(number);
                    p.setHealth(number);
                    p.sendMessage(LifeX.colorize(prefix + "&cYour hearts as been set to &e" + p.getMaxHealth() / 2));

                } catch (Exception e) {
                    sender.sendMessage(LifeX.colorize(prefix + "&cPlease provide a valid number"));
                }
            }
        } else {
                sender.sendMessage(LifeX.colorize(prefix + "&cConsoles can not change their hearts, silly!"));
            }
        } else if(args.length == 1) {
            Public.getHelpMethod(sender);

        }
    }
}
