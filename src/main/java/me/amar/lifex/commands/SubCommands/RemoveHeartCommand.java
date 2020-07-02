package me.amar.lifex.commands.SubCommands;

import me.amar.lifex.API.NewItemStack;
import me.amar.lifex.API.XMaterial;
import me.amar.lifex.commands.SubCommand;
import me.amar.lifex.LifeX;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Optional;

public class RemoveHeartCommand extends SubCommand {
    private final LifeX plugin = LifeX.getPlugin(LifeX.class);

    @Override
    public String getName() {
        return "remove";
    }

    @Override
    public String getDescription() {
        return "Removes a heart if you have specified materials with a specified amount.";
    }

    @Override
    public String getSyntax() {
        return "/life remove";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        String prefix = plugin.getConfig().getString("prefix") + " ";
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (plugin.getConfig().getBoolean("RemoveHeartCommand.enabled")) {
                if (p.hasPermission("life.remove")) {
                    System.out.println(plugin.getConfig().getString("RemoveHeartCommand.material"));
                    for (int i = 0; i < p.getInventory().getSize(); i++) {
                        if (p.getInventory().getItem(i) != null) {
                            if (p.getInventory().getItem(i).isSimilar(getMaterial(plugin.getConfig().getString("RemoveHeartCommand.material")))) {
                                p.setMaxHealth(p.getMaxHealth() + 2);
                                p.setHealth(p.getMaxHealth());
                                p.sendMessage(LifeX.colorize(prefix + "&cYou have been granted one heart for your great work!"));
                                p.getInventory().remove(getMaterial(plugin.getConfig().getString("RemoveHeartCommand.material")));
                            } else {
                                p.sendMessage(LifeX.colorize(prefix + "&cYou do not have enough items to use this command."));
                            }
                        }

                    }
                } else {
                    p.sendMessage(LifeX.colorize(prefix + "&cYou do not have enough permission to use this command."));
                }
            } else {
                p.sendMessage(LifeX.colorize(prefix + "&cThis feature has been disabled by the administrators."));
            }

        } else {
            sender.sendMessage(LifeX.colorize(prefix + "&cThis command can only be used by players."));
        }
        if(isSimilar(plugin.getConfig().getBoolean("RemoveHeartCommand.enabled"))) {

        }
    }

    public ItemStack getMaterial(String name) {
        final Optional<XMaterial> mat = XMaterial.matchXMaterial(name);
        final ItemStack stack = mat.map(XMaterial::parseItem).orElse(null);

        if (stack == null) System.out.println(LifeX.colorize("Invalid Material name"));


        stack.setAmount(plugin.getConfig().getInt("remove.amount"));
        return stack;
    }

    public boolean isSimilar(boolean o) {
        if(o == true) {
            return  true;
        } else {
            return false;
        }
    }

}