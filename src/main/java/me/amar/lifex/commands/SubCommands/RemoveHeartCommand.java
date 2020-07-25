package me.amar.lifex.commands.SubCommands;

import me.amar.lifex.API.XMaterial;
import me.amar.lifex.LifeX;
import me.amar.lifex.commands.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
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
    /*    int requiredAmount = plugin.getConfig().getInt("RemoveHeartCommand.amount");
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
                            } else if(i == p.getInventory().getSize() && availableAmount < requiredAmount){
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

        //end*/

        ArrayList<Integer> slots = new ArrayList<>();
        int availableAmount = 0;
        int neededAmount = plugin.getConfig().getInt("RemoveHeartCommand.amount");
        ItemStack item = new ItemStack(getMaterial(plugin.getConfig().getString("RemoveHeartCommand.material")));
        Player player = ((Player) sender);
        if (player.hasPermission("life.remove")) {
            if (player.getMaxHealth() <= 2) {
                player.sendMessage(LifeX.colorize("You have 1 heart only, save your items for later!"));
            } else {
                for (int i = 0; i <= player.getInventory().getSize(); ++i) {
                    if (player.getInventory().getItem(i) != null) {
                        if (player.getInventory().getItem(i).isSimilar(item)) {
                            availableAmount += player.getInventory().getItem(i).getAmount();
                            slots.add(i);
                            player.sendMessage("+" + player.getInventory().getItem(i).getAmount());

                        }
                    }
                }
                if (availableAmount >= neededAmount) {
                    ItemStack air = new ItemStack(Material.AIR);
                    for (int slot : slots) {
                        if (neededAmount != 0) {
                            if (player.getInventory().getItem(slot).getAmount() == neededAmount) {
                                player.getInventory().setItem(slot, air);
                                neededAmount = 0;
                                availableAmount -= neededAmount;
                            } else if (player.getInventory().getItem(slot).getAmount() < neededAmount) {
                                neededAmount -= player.getInventory().getItem(slot).getAmount();
                                availableAmount -= player.getInventory().getItem(slot).getAmount();
                                player.getInventory().setItem(slot, air);
                            } else if (player.getInventory().getItem(slot).getAmount() > neededAmount) {
                                ItemStack diamondsRemaining = new ItemStack(item);
                                diamondsRemaining.setAmount(player.getInventory().getItem(slot).getAmount() - neededAmount);
                                neededAmount = 0;
                                player.getInventory().setItem(slot, diamondsRemaining);
                            }
                        }
                    }
                    player.setMaxHealth(player.getMaxHealth() - 2);
                    player.sendMessage(LifeX.colorize("Keep up the hard work!"));
                } else {
                    player.sendMessage("You don't have enough " + item.getType() + "(s) to perform this command.");
                }

            }
        }

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