package me.amar.xlife.xlife.Events;

import me.amar.xlife.xlife.XLife;
import me.amar.xlife.xlife.commands.Files.DataYml;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.io.File;
import java.io.IOException;

public class OnPlayerJoinEvent implements Listener {
    private final XLife plugin = XLife.getPlugin(XLife.class);



    @EventHandler
    public void onJoin(PlayerLoginEvent e) throws IOException {

        if(DataYml.getDataYml() != null && DataYml.getDataYml().getString("health." + e.getPlayer().getUniqueId().toString() + ".health") == null){
            DataYml.getDataYml().set("health." + e.getPlayer().getUniqueId().toString() + ".health", e.getPlayer().getMaxHealth() / 2 + "ABCZ");
            DataYml.getDataYml().save(new File(plugin.getDataFolder() + "/data.yml"));
        }



    }
}
