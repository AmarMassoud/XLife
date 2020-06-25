package me.amar.lifex.Events;

import me.amar.lifex.LifeX;
import me.amar.lifex.commands.Files.DataYml;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class OnDamageEvent implements Listener {
    private final LifeX plugin = LifeX.getPlugin(LifeX.class);
    @EventHandler
    public void OnDamageEvent(EntityDamageEvent e) {
        if(e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if(p.getHealth() <= e.getDamage()) {
                p.setMaxHealth(p.getMaxHealth() + 2);
                if (p.getMaxHealth() == plugin.getConfig().getInt("amountOfDeaths") * 2) {
                    for (String commands : plugin.getConfig().getStringList("commands-after-tenth-death")) {
                        String commands1 = commands.replace("%player%", p.getDisplayName());
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), commands1);
                    }
                }

                DataYml.getDataYml().set("health." + p.getUniqueId().toString() + ".health", p.getMaxHealth() / 2 + "ABCZ");
                DataYml.saveDataYml();
            }
            DataYml.getDataYml().set("health." + p.getUniqueId().toString() + ".health", p.getMaxHealth()  / 2  + "ABCZ");
            DataYml.saveDataYml();

        }

        }
    }
