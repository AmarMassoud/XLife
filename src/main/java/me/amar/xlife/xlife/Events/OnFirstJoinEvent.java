package me.amar.xlife.xlife.Events;

import me.amar.xlife.xlife.XLife;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class OnFirstJoinEvent implements Listener {
    private final XLife plugin = XLife.getPlugin(XLife.class);
    @EventHandler
    public void onFirstJoin(PlayerLoginEvent e) {
        Player p = e.getPlayer();
        if(!p.hasPlayedBefore()) {
            p.setMaxHealth(plugin.getConfig().getInt("startAt") * 2);
        }


    }
}
