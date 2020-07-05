package me.amar.lifex.Events;

import me.amar.lifex.API.sendTitleMethod;
import me.amar.lifex.LifeX;
import me.amar.lifex.Listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class OnChatEvent implements Listener {
    private final LifeX plugin = LifeX.getPlugin(LifeX.class);

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String prefix = plugin.getConfig().getString("prefix") + " ";
        if (PlayerAmountOfHeartsOnFirstJoinChat.isPlayerInAmountOfHeartsOnJoin(p.getUniqueId().toString())) {
            e.setCancelled(true);
            if (e.getMessage() .equalsIgnoreCase("cancel")) {
                p.sendMessage(LifeX.colorize(prefix + "&cYou have cancelled setting the hearts on first join"));
                PlayerAmountOfHeartsOnFirstJoinChat.removePlayerFromAmountOfHeartsOnJoin(p.getUniqueId().toString());
                sendTitleMethod.sendTitle(p, "", "", 1, 1, 1);
            } else {
            Bukkit.getScheduler().runTask(plugin, () -> {
                try {
                    int number = Integer.parseInt(e.getMessage());
                    plugin.getConfig().set("StartAt", number);
                    plugin.saveConfig();
                    plugin.reloadConfig();
                    p.sendMessage(LifeX.colorize(prefix + "&cThe Amount of hearts a player starts with has been successfully set to &e" + number + "&c."));
                    PlayerAmountOfHeartsOnFirstJoinChat.removePlayerFromAmountOfHeartsOnJoin(p.getUniqueId().toString());
                    sendTitleMethod.sendTitle(p, "", "", 3, 1, 1);
                } catch (NumberFormatException exc) {
                    p.sendMessage(LifeX.colorize(prefix + "&cPlease specify a valid number."));
                }
            });
        }
        } else if (PlayerAmountOfHeartsOnDeathChat.isPlayerInAmountOfHeartsOnDeath(p.getUniqueId().toString())) {
            e.setCancelled(true);
            if(e.getMessage() .equalsIgnoreCase("cancel")) {
                p.sendMessage(LifeX.colorize(prefix + "&cYou have cancelled setting the hearts on death"));
                PlayerAmountOfHeartsOnDeathChat.removePlayerFromAmountOfHeartsOnDeath(p.getUniqueId().toString());
                sendTitleMethod.sendTitle(p, "", "", 1, 1, 1);
            } else {
                Bukkit.getScheduler().runTask(plugin, () -> {
                    try {
                        int number = Integer.parseInt(e.getMessage());
                        plugin.getConfig().set("IncrementsBy", number);
                        plugin.saveConfig();
                        plugin.reloadConfig();
                        p.sendMessage(LifeX.colorize(prefix + "&cThe Amount of hearts a player increased on death has been successfully set to &e" + number + "&c."));
                        PlayerAmountOfHeartsOnFirstJoinChat.removePlayerFromAmountOfHeartsOnJoin(p.getUniqueId().toString());
                        sendTitleMethod.sendTitle(p, "", "", 3, 1, 1);
                    } catch (NumberFormatException exc) {
                        p.sendMessage(LifeX.colorize(prefix + "&cPlease specify a valid number."));
                    }


                });
            }

        } else if (AddWhitelistChatListener.isPlayerInWhitelistAddChatListener(p.getUniqueId().toString())) {
            e.setCancelled(true);
            if(e.getMessage() .equalsIgnoreCase("cancel")) {

                p.sendMessage(LifeX.colorize(prefix + "&cYou have cancelled adding a player to the whitelist"));
                AddWhitelistChatListener.removePlayerFromWhitelistAddPlayerChatListener(p.getUniqueId().toString());
                sendTitleMethod.sendTitle(p, "", "", 1, 1, 1);
            } else {
                Bukkit.getScheduler().runTask(plugin, () -> {
                    try {
                        Player target = Bukkit.getPlayer(e.getMessage());
                        if (WhitelistedPlayers.isPlayerInWhiteList(target.getUniqueId().toString())) {
                            p.sendMessage(LifeX.colorize(prefix + "&cThis player is already whitelisted."));
                        } else {
                            WhitelistedPlayers.addPlayerToWhitelist(target.getUniqueId().toString());
                            p.sendMessage(LifeX.colorize(prefix + "&e" + target.getName() + " &cHas been successfully added to the whitelist."));
                            target.sendMessage(LifeX.colorize(prefix + "&eYou &chave been added to the LifeX whitelisted"));
                        }

                        AddWhitelistChatListener.removePlayerFromWhitelistAddPlayerChatListener(p.getUniqueId().toString());
                        sendTitleMethod.sendTitle(p, "", "", 3, 1, 1);
                    } catch (NullPointerException exc) {
                        p.sendMessage(LifeX.colorize(prefix + "&cPlease specify a valid player."));
                    }


                });
            }
        } else if(RemoveWhitelistPlayerChatListener.isPlayerInWhitelistRemoveChatListener(p.getUniqueId().toString())) {
            e.setCancelled(true);
            if (e.getMessage() .equalsIgnoreCase("cancel")) {
                p.sendMessage(LifeX.colorize(prefix + "&cYou have cancelled removing a player from the whitelist"));
                RemoveWhitelistPlayerChatListener.removePlayerFromWhitelistRemoveChatListener(p.getUniqueId().toString());
                sendTitleMethod.sendTitle(p, "", "", 1, 1, 1);
            } else {
                Bukkit.getScheduler().runTask(plugin, () -> {
                    try {
                        Player target = Bukkit.getPlayer(e.getMessage());
                        if (!WhitelistedPlayers.isPlayerInWhiteList(target.getUniqueId().toString())) {
                            p.sendMessage(LifeX.colorize(prefix + "&cThis player is not whitelisted."));
                        } else {
                            WhitelistedPlayers.removePlayerFromWhitelist(target.getUniqueId().toString());
                            p.sendMessage(LifeX.colorize(prefix + "&e" + target.getName() + " &cHas been successfully removed from the whitelist."));
                            target.sendMessage(LifeX.colorize(prefix + "&eYou &chave been removed from the LifeX whitelisted"));
                        }

                        RemoveWhitelistPlayerChatListener.removePlayerFromWhitelistRemoveChatListener(p.getUniqueId().toString());
                        sendTitleMethod.sendTitle(p, "", "", 3, 1, 1);
                    } catch (NullPointerException exc) {
                        p.sendMessage(LifeX.colorize(prefix + "&cPlease specify a valid player."));
                    }


                });
            }
        }

    }
}
