package me.amar.lifex.Events;

import me.amar.lifex.commands.Files.DataYml;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;

public class EntityRegenEvent implements Listener {
    @EventHandler
    public void onHeal (EntityRegainHealthEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        } else {
            Player p = (Player) e.getEntity();
            DataYml.getDataYml().set("health." + p.getUniqueId().toString() + ".health", p.getMaxHealth() / 2 + "ABCZ");
            DataYml.saveDataYml();
        }
    }
}
