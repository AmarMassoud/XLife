package me.amar.lifex.Menus;

import com.demeng7215.demlib.api.items.ItemBuilder;
import com.demeng7215.demlib.api.items.XMaterial;
import com.demeng7215.demlib.api.menus.CustomMenu;
import me.amar.lifex.API.sendTitleMethod;
import me.amar.lifex.LifeX;
import me.amar.lifex.Listeners.PlayerAmountOfHeartsOnDeathChat;
import me.amar.lifex.Listeners.PlayerAmountOfHeartsOnFirstJoinChat;
import me.amar.lifex.Listeners.AddWhitelistChatListener;
import me.amar.lifex.Listeners.RemoveWhitelistPlayerChatListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class LifeXMainMenu extends CustomMenu {
    private final LifeX plugin = LifeX.getPlugin(LifeX.class);
    public LifeXMainMenu(Player p) {
        super(45, "&b&lLifeX Main Menu");

        setItem(10, ItemBuilder.build(new ItemStack(XMaterial.BEDROCK.parseItem()), "&bAmount of hearts on first join", Arrays.asList("&eClick me to change the amount of hearts a player starts with when they first join the server.")), event -> {
            p.closeInventory();
            PlayerAmountOfHeartsOnFirstJoinChat.addPlayerToAmountOfHeartsOnJoin(p.getUniqueId().toString());
            sendTitleMethod.sendTitle(p, LifeX.colorize("&bSpecify a number in chat"), LifeX.colorize("&cTo set the amount of hearts a player starts with"), 1, 600, 1);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                @Override
                public void run() {
                    PlayerAmountOfHeartsOnFirstJoinChat.removePlayerFromAmountOfHeartsOnJoin(p.getUniqueId().toString());
                }
            }, 20 * 30L);
        });
        setItem(13, ItemBuilder.build(new ItemStack(XMaterial.RED_STAINED_GLASS_PANE.parseItem()), "&bAmount of hearts increased on death", Arrays.asList("&eClick me to change the amount of hearts", "&ethat will be added to a player on death.")), event -> {
            p.closeInventory();
            PlayerAmountOfHeartsOnDeathChat.addPlayerToAmountOfHeartsOnDeath(p.getUniqueId().toString());
            sendTitleMethod.sendTitle(p, LifeX.colorize("&bSpecify a number in chat"), LifeX.colorize("&cTo set the amount of hearts increased on death"), 1, 600, 1);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                @Override
                public void run() {
                    PlayerAmountOfHeartsOnDeathChat.removePlayerFromAmountOfHeartsOnDeath(p.getUniqueId().toString());
                }
            }, 20 * 30L);
        });
        setItem(16, ItemBuilder.build(new ItemStack(XMaterial.RED_STAINED_GLASS.parseItem()), "&bAdd player to the LifeX whitelist.", Arrays.asList("&eClick me to add a player to the LifeX whitelist")), event -> {
            p.closeInventory();
            AddWhitelistChatListener.addPlayerToWhitelistAddPlayerChatListener(p.getUniqueId().toString());
            sendTitleMethod.sendTitle(p, LifeX.colorize("&bSpecify a player name in chat"), LifeX.colorize("&cTo add them to the whitelist"), 1, 600, 1);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                @Override
                public void run() {
                    AddWhitelistChatListener.removePlayerFromWhitelistAddPlayerChatListener(p.getUniqueId().toString());
                }
            }, 20 * 30L);
        });
        setItem(25, ItemBuilder.build(new ItemStack(XMaterial.RED_WOOL.parseItem()), "&bRemove player from the LifeX whitelist.", Arrays.asList("&eClick me to remove a player from the LifeX whitelist")), event -> {
            p.closeInventory();
            RemoveWhitelistPlayerChatListener.addPlayerToWhitelistRemoveChatListener(p.getUniqueId().toString());
            sendTitleMethod.sendTitle(p, LifeX.colorize("&bSpecify a player name in chat"), LifeX.colorize("&cTo add them to the whitelist"), 1, 600, 1);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                @Override
                public void run() {
                    RemoveWhitelistPlayerChatListener.removePlayerFromWhitelistRemoveChatListener(p.getUniqueId().toString());
                }
            }, 20 * 30L);
        });




        open(p);
    }

}
