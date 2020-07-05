package me.amar.lifex.commands.SubCommands;

import me.amar.lifex.API.XMaterial;
import me.amar.lifex.LifeX;
import me.amar.lifex.commands.SubCommand;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
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
        int requiredAmount = plugin.getConfig().getInt("RemoveHeartCommand.amount");
        ItemStack itemstack = getMaterial(plugin.getConfig().getString("RemoveHeartCommand.material"));
        int availableAmount = 0;
        ArrayList<Integer> slots = new ArrayList<>();
        String prefix = plugin.getConfig().getString("prefix") + " ";
        String materialWithoutUnderscores = plugin.getConfig().getString("RemoveHeartCommand.material").toLowerCase().replace("_", " ");
        Player p = (Player) sender;
        if (p.hasPermission("life.remove")) {
            if (plugin.getConfig().getBoolean("RemoveHeartCommand.enabled")) {

                for (int i = 0; i <= p.getInventory().getSize(); ++i) {
                    if (p.getInventory().getItem(i) != null) {
                        if (p.getInventory().getItem(i).isSimilar(getMaterial(plugin.getConfig().getString("RemoveHeartCommand.material")))) {
                            slots.add(i);
                            availableAmount += p.getInventory().getItem(i).getAmount();
                            if (availableAmount >= requiredAmount) {
                                i += p.getInventory().getSize() + 1;
                                for (int slot : slots) {
                                    if (p.getInventory().getItem(slot).getAmount() > requiredAmount) {
                                        ItemStack item = new ItemStack(getMaterial(plugin.getConfig().getString("RemoveHeartCommand.material")));
                                        item.setAmount(p.getInventory().getItem(slot).getAmount() - requiredAmount);
                                        p.getInventory().setItem(slot, item);
                                        p.updateInventory();
                                    }
                                    if (p.getInventory().getItem(slot).getAmount() <= requiredAmount) {
                                        ItemStack air = new ItemStack(Material.AIR);
                                        requiredAmount -= p.getInventory().getItem(slot).getAmount();
                                        p.getInventory().setItem(slot, air);
                                        p.updateInventory();
                                    }
                                }
                                p.sendMessage(LifeX.colorize(prefix + "&bYou have exchanged " + plugin.getConfig().getInt("RemoveHeartCommand.amount") + " " + materialWithoutUnderscores + "(s) for " + plugin.getConfig().getInt("IncrementsBy") + " heart(s)!"));
                                p.setMaxHealth((p.getMaxHealth() + plugin.getConfig().getInt("IncrementsBy")) * 2);
                                p.setHealth(p.getMaxHealth());
                            } else {
                                p.sendMessage(LifeX.colorize(prefix + "&bYou need " + plugin.getConfig().getInt("RemoveHeartCommand.amount") + " " + materialWithoutUnderscores + "(s) to perform this command."));
                                i += p.getInventory().getSize() + 1;
                                System.out.println("not work it");
                            }
                        }

                    }
                }
            } else {
                p.sendMessage(LifeX.colorize(prefix + "&cThis feature is not enabled in the config."));
            }
        } else {
            p.sendMessage(LifeX.colorize(prefix + "&cYou don't have permission to run this command."));
        }

        //end
    }

    public ItemStack getMaterial(String name) {
        final Optional<XMaterial> mat = XMaterial.matchXMaterial(name);
        final ItemStack stack = mat.map(XMaterial::parseItem).orElse(null);

        if (stack == null) System.out.println(LifeX.colorize("Invalid Material name"));


        stack.setAmount(plugin.getConfig().getInt("RemoveHeartCommand.amount"));
        return stack;
    }

    public boolean isSimilar(boolean o) {
        if (o == true) {
            return true;
        } else {
            return false;
        }
    }
}