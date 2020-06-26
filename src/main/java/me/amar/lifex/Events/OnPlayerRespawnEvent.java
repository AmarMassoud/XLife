package me.amar.lifex.Events;

import me.amar.lifex.API.Public;
import me.amar.lifex.LifeX;
import me.amar.lifex.Listeners.WhitelistedPlayers;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class OnPlayerRespawnEvent implements Listener {
    private final LifeX plugin = LifeX.getPlugin(LifeX.class);
    @EventHandler
    public void OnRespawn(PlayerRespawnEvent e) {
        String prefix = plugin.getConfig().getString("prefix") + " ";
        Player p = e.getPlayer();
        if (!WhitelistedPlayers.isPlayerInWhiteList(p.getUniqueId().toString())) {
            p.sendMessage(LifeX.colorize(prefix + "&cYour health is now &e" + p.getMaxHealth() / 2));
        }
    }
}
