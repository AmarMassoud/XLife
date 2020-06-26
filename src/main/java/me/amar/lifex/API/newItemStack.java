package me.amar.lifex.API;

import me.amar.lifex.LifeX;
import org.bukkit.inventory.ItemStack;

import java.util.Optional;

public class newItemStack {
    public static ItemStack getMaterial(String name) {
        final Optional<XMaterial> mat = XMaterial.matchXMaterial(name);
        final ItemStack stack = mat.map(XMaterial::parseItem).orElse(null);

        if (stack == null) System.out.println(LifeX.colorize("Invalid Material name"));

        return stack;
    }


}
