package me.sfclog.itemlang.utils;

import me.sfclog.itemlang.Main;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class TranUtils {

    public static String translate(Material mat){
        if(mat == null) return "...";
        if(Main.langmap.containsKey(mat.getItemTranslationKey())) {
            return Main.langmap.get(mat.getItemTranslationKey());
        }
        return mat.name().toLowerCase();
    }
    public String translate(ItemStack item) {
        if(item == null || item.getType() == null) return "...";
        return translate(item.getType());
    }
}
