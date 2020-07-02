package me.amar.lifex.Events;

import me.amar.lifex.API.sendTitleMethod;
import me.amar.lifex.LifeX;
import me.amar.lifex.Listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class OnDamageEvent implements Listener {
    private final LifeX plugin = LifeX.getPlugin(LifeX.class);

    @EventHandler
    public void OnDamageEvent(EntityDamageEvent e) {
        String prefix = plugin.getConfig().getString("prefix") + " ";
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            sendTitleMethod.sendTitle(p, "", "", 1, 1, 1);
            AddWhitelistChatListener.removePlayerFromWhitelistAddPlayerChatListener(p.getUniqueId().toString());
            RemoveWhitelistPlayerChatListener.removePlayerFromWhitelistRemoveChatListener(p.getUniqueId().toString());
            PlayerAmountOfHeartsOnDeathChat.removePlayerFromAmountOfHeartsOnDeath(p.getUniqueId().toString());
            PlayerAmountOfHeartsOnFirstJoinChat.removePlayerFromAmountOfHeartsOnJoin(p.getUniqueId().toString());
            if (p.getHealth() <= e.getDamage()) {
                if (WhitelistedPlayers.isPlayerInWhiteList(p.getUniqueId().toString())) {
                    p.sendMessage(LifeX.colorize(prefix + "&cYou are immune to the LifeX system since you have been whitelisted."));
                } else {
                p.setMaxHealth(p.getMaxHealth() + (plugin.getConfig().getInt("IncrementsBy") * 2));
                if (p.getMaxHealth() == plugin.getConfig().getInt("AmountOfDeaths") * 2) {
                    for (String commands : plugin.getConfig().getStringList("Commands-After-Last-Death")) {
                        String commands1 = commands.replace("%player%", p.getDisplayName());
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), commands1);
                    }
                }
                }

            }
        }
    }

}

