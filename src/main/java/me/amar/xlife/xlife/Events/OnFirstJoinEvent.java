package me.amar.xlife.xlife.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class OnFirstJoinEvent implements Listener {
    @EventHandler
    public void onFirstJoin(PlayerLoginEvent e) {
        Player p = e.getPlayer();
        if(!p.hasPlayedBefore()) {
            p.setMaxHealth(2);
        }


    }
}
