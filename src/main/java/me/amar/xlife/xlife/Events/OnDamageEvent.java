package me.amar.xlife.xlife.Events;

import me.amar.xlife.xlife.XLife;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class OnDamageEvent implements Listener {
    private final XLife plugin = XLife.getPlugin(XLife.class);
    @EventHandler
    public void OnDamageEvent(EntityDamageEvent e) {
        if(e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if(p.getHealth() < e.getDamage()) {
                p.setMaxHealth(p.getMaxHealth() + 2);
                p.sendMessage(XLife.colorize("&cYour health is now &e" + p.getMaxHealth() / 2));
            }
            if(p.getMaxHealth() == 20) {
                for(String commands : plugin.getConfig().getStringList("commands-after-tenth-death")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), commands);
                }
            }

        }
    }
}
