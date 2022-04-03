package com.vestriamc.RandomArgument;

import com.vestriamc.RandomArgument.commands.CommandRandomitem;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Random;

public final class RandomArgument extends JavaPlugin {
    public static Plugin PLUGIN;
    public static float VESTRIAN_CHANCE;
    public static float LEGENDARY_CHANCE;
    public static float RARE_CHANCE;
    public static List<String> commonItems;
    public static List<String> rareItems;
    public static List<String> legendaryItems;
    public static List<String> vestrianItems;
    public static Random RAND = new Random();
    @Override
    public void onEnable() {
        PLUGIN = this;
        PluginManager pm = this.getServer().getPluginManager();
        saveDefaultConfig();
        getCommand("randomitem").setExecutor(new CommandRandomitem());
        VESTRIAN_CHANCE = Float.parseFloat(getConfig().getString("VestrianChance"));
        LEGENDARY_CHANCE = Float.parseFloat(getConfig().getString("LegendaryChance"));
        RARE_CHANCE = Float.parseFloat(getConfig().getString("RareChance"));
        vestrianItems = getConfig().getStringList("VestrianItems");
        legendaryItems = getConfig().getStringList("LegendaryItems");
        commonItems = getConfig().getStringList("CommonItems");
        rareItems = getConfig().getStringList("RareItems");
        //pm.registerEvents(new BlockBreakListener(), this);
        //System.out.println("Something in console");
        //event.getPlayer().sendMessage(Component.text("Something said to player", TextColor.color(0xFF0000)));
    }
}
