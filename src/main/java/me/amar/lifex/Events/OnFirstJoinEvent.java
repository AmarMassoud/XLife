package me.amar.lifex.Events;

import me.amar.lifex.API.Public;
import me.amar.lifex.LifeX;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class OnFirstJoinEvent implements Listener {
    private final LifeX plugin = LifeX.getPlugin(LifeX.class);

    @EventHandler
    public void onFirstJoin(PlayerLoginEvent e) {
        String prefix = plugin.getConfig().getString("prefix") + " ";
        Player p = e.getPlayer();
        if (!p.hasPlayedBefore()) {
            if (plugin.getConfig().getStringList("whitelisted-players").contains(p.getUniqueId().toString())) {
                p.sendMessage(LifeX.colorize(prefix + "&cYou are immune to the LifeX system since you have been whitelisted."));
            } else {

            }

        } else {
            int maxhealth = plugin.getConfig().getInt("StartAt") * 2;
            p.setMaxHealth(maxhealth);
        }


    }
}
