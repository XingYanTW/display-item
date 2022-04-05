package me.xingyan.displaychest;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.command.TabExecutor;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class TabComp implements TabCompleter {
    private static final String[] COMMANDS = {"minecraft", "spigot", "bukkit", "google"};


    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        List<String> tabs = Arrays.asList("lock", "unlock");
        String input = args[0].toLowerCase(Locale.ROOT);

        List<String> completions = null;
        if (args.length == 1) {

            for (String s : tabs) {
                if (s.startsWith(input)) {
                    if (completions == null) {
                        completions = new ArrayList<>();
                    }
                    completions.add(s);

                }
            }

            if (completions != null)
                Collections.sort(completions);

            return completions;
        }


        //create a static array
        return null;
    }
}