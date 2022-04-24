package com.vestriamc.RandomArgument.commands;

import com.vestriamc.RandomArgument.RandomArgument;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;

public class CommandRandomitem implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, @NotNull final Command cmd, @NotNull final String label, String[] args) {
        if (!sender.hasPermission("RandomArgument.admin")) {
            sender.sendMessage(Component.text("You don't have permission to perform this command!", TextColor.color(0xFF0000)));
            return true;
        }

        if (args.length == 0 || args[0].isEmpty()) {
            sender.sendMessage(Component.text("Please provide a command argument!", TextColor.color(0xFF0000)));
            return true;
        }
        if(RandomArgument.PLUGIN.getServer().getPlayerExact(args[0]) == null)
        {
            sender.sendMessage(Component.text("No player with that name online", TextColor.color(0xFF0000)));
            return true;
        }
        float randomNumber = RandomArgument.RAND.nextFloat(100);
        if(randomNumber < RandomArgument.VESTRIAN_CHANCE)
        {
            String command = "items give " + args[0] + " construct " + returnARandomElement(RandomArgument.vestrianItems) + " drop";
            RandomArgument.PLUGIN.getServer().dispatchCommand(RandomArgument.PLUGIN.getServer().getConsoleSender(),command);
            System.out.println(command);
        }
        else if(randomNumber < RandomArgument.LEGENDARY_CHANCE + RandomArgument.VESTRIAN_CHANCE)
        {
            String command = "items give " + args[0] + " construct " + returnARandomElement(RandomArgument.legendaryItems) + " drop";
            RandomArgument.PLUGIN.getServer().dispatchCommand(RandomArgument.PLUGIN.getServer().getConsoleSender(),command);
            System.out.println(command);
        }
        else if(randomNumber < RandomArgument.RARE_CHANCE + RandomArgument.LEGENDARY_CHANCE + RandomArgument.VESTRIAN_CHANCE)
        {
            String command = "items give " + args[0] + " construct " + returnARandomElement(RandomArgument.rareItems) + " drop";
            RandomArgument.PLUGIN.getServer().dispatchCommand(RandomArgument.PLUGIN.getServer().getConsoleSender(),command);
            System.out.println(command);
        }
        else
        {
            String command = "items give " + args[0] + " construct " + returnARandomElement(RandomArgument.commonItems) + " drop";
            RandomArgument.PLUGIN.getServer().dispatchCommand(RandomArgument.PLUGIN.getServer().getConsoleSender(),command);
            System.out.println(command);
        }
        return true;
    }
    public String returnARandomElement(List<String> givenList) {
        return givenList.get(RandomArgument.RAND.nextInt(givenList.size()));
    }

}
