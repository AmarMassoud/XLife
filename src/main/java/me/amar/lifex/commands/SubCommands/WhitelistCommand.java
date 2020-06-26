package me.amar.lifex.commands.SubCommands;

import me.amar.lifex.API.Public;
import me.amar.lifex.LifeX;
import me.amar.lifex.Listeners.WhitelistedPlayers;
import me.amar.lifex.commands.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WhitelistCommand extends SubCommand {
    private final LifeX plugin = LifeX.getPlugin(LifeX.class);
    @Override
    public String getName() {
        return "whitelist";
    }

    @Override
    public String getDescription() {
        return "Whitelists a player";
    }

    @Override
    public String getSyntax() {
        return "/life whitelist add/remove <player>";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {// /l whitelist add/remove PLAYER
        String prefix = plugin.getConfig().getString("prefix") + " ";
        Player target = null;
        try {
            target = Bukkit.getPlayer(args[2]);
        } catch (NullPointerException e) {
            sender.sendMessage(LifeX.colorize(prefix + "&cPlease provide a valid player."));
        } catch (ArrayIndexOutOfBoundsException exc) {
            sender.sendMessage(LifeX.colorize(prefix + "&cPlease specify whether to add or remove a player from the whitelist."));
        }
        Player p = (Player) sender;
        if (args.length == 2) {
            p.sendMessage(LifeX.colorize(prefix + "&cPlease specify a player."));
        } else if (args.length == 3) {

            if (args[1].equalsIgnoreCase("add")) {
                if (WhitelistedPlayers.isPlayerInWhiteList(target.getUniqueId().toString())) {
                    p.sendMessage(LifeX.colorize(prefix + "&cThis player is already whitelisted"));
                } else {
                    WhitelistedPlayers.addPlayerToWhitelist(target.getUniqueId().toString());
                    p.sendMessage(LifeX.colorize(prefix + "&e" + target.getName() + " &cHas been successfully added to the whitelist."));
                    target.sendMessage(LifeX.colorize(prefix + "&eYou &chave been added to the whe LifeX whitelisted"));
                }
            } else if (args[1].equalsIgnoreCase("remove")) {
                if (!WhitelistedPlayers.isPlayerInWhiteList(target.getUniqueId().toString())) {
                    p.sendMessage(LifeX.colorize(prefix + "&cThis player is not whitelisted"));
                } else {
                    WhitelistedPlayers.removePlayerFromWhitelist(target.getUniqueId().toString());
                    p.sendMessage(LifeX.colorize("&e" + target.getName() + " &cHas been successfully removed from the whitelist."));
                    target.sendMessage(LifeX.colorize(prefix + "&eYou &chave been removed from the LifeX whitelist."));
                }
            }


        }


    }
}
