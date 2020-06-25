package me.amar.lifex.Events;

import me.amar.lifex.LifeX;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class OnFirstJoinEvent implements Listener {
    private final LifeX plugin = LifeX.getPlugin(LifeX.class);
    @EventHandler
    public void onFirstJoin(PlayerLoginEvent e) {
        Player p = e.getPlayer();
        if(!p.hasPlayedBefore()) {
            p.setMaxHealth(plugin.getConfig().getInt("startAt") * 2);
        }


    }
}
