package me.amar.lifex.Events;

import me.amar.lifex.LifeX;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class OnPlayerRespawnEvent implements Listener {
    private final LifeX plugin = LifeX.getPlugin(LifeX.class);
    @EventHandler
    public void OnRespawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        p.sendMessage(LifeX.colorize("&cYour health is now &e" + p.getMaxHealth() / 2));
    }
}
