package me.amar.xlife.xlife.Events;

import me.amar.xlife.xlife.XLife;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.UUID;

public class OnPlayerRespawnEvent implements Listener {
    private final XLife plugin = XLife.getPlugin(XLife.class);
    @EventHandler
    public void OnRespawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        p.sendMessage(XLife.colorize("&cYour health is now &e" + p.getMaxHealth() / 2));
    }
}
