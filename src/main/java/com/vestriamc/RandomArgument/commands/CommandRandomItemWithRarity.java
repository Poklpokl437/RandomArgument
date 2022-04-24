package com.vestriamc.RandomArgument.commands;

import com.vestriamc.RandomArgument.RandomArgument;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CommandRandomItemWithRarity implements CommandExecutor {
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
        String command = "";
        switch(args[0])
        {
            case "common":
                command = "items give " + sender.getName() + " construct " + returnARandomElement(RandomArgument.commonItems) + " drop";
                RandomArgument.PLUGIN.getServer().dispatchCommand(RandomArgument.PLUGIN.getServer().getConsoleSender(),command);
                System.out.println(command);
                break;
            case "rare":
                command = "items give " + sender.getName() + " construct " + returnARandomElement(RandomArgument.rareItems) + " drop";
                RandomArgument.PLUGIN.getServer().dispatchCommand(RandomArgument.PLUGIN.getServer().getConsoleSender(),command);
                System.out.println(command);
                break;
            case "legendary":
                command = "items give " + sender.getName() + " construct " + returnARandomElement(RandomArgument.legendaryItems) + " drop";
                RandomArgument.PLUGIN.getServer().dispatchCommand(RandomArgument.PLUGIN.getServer().getConsoleSender(),command);
                System.out.println(command);
                break;
            case "vestrian":
                command = "items give " + sender.getName() + " construct " + returnARandomElement(RandomArgument.vestrianItems) + " drop";
                RandomArgument.PLUGIN.getServer().dispatchCommand(RandomArgument.PLUGIN.getServer().getConsoleSender(),command);
                System.out.println(command);
                break;
            default:
                break;
        }
        return true;
    }
    public String returnARandomElement(List<String> givenList) {
        return givenList.get(RandomArgument.RAND.nextInt(givenList.size()));
    }

}
