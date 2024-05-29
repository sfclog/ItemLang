package me.sfclog.itemlang;

import me.sfclog.itemlang.utils.TranUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main extends JavaPlugin {


    public static HashMap<String, String> langmap = new HashMap<>();

    @Override
    public void onEnable() {
        langmap = loadOne("/lang/vi_vn.json");
        Bukkit.getConsoleSender().sendMessage("[ItemLang] Load success! " + TranUtils.translate(Material.BEDROCK));
    }


    private HashMap<String, String> loadOne(String path) {
        InputStream file = getClass().getResourceAsStream(path);
        YamlConfiguration config = new YamlConfiguration();
        HashMap<String, String> items = new HashMap<>();
        BufferedReader reader;
        if (file == null){
            Bukkit.getConsoleSender().sendMessage("[ItemLang] Load fail!");
            return items;
        }
        reader = new BufferedReader(new InputStreamReader(file));
        try {
            config.load(reader);
        } catch (InvalidConfigurationException | IOException e) {
            e.printStackTrace();
        }
        for (String key : config.getKeys(true)) {
            String value = config.getString(key);
            if (value == null) continue;
            if (value.startsWith("MemorySection")) continue;
            items.put(key, value);
        }
        return items;
    }
}
