package me.xingyan.displaychest;

import me.xingyan.displaychest.commands.CommandDisplayChest;
import me.xingyan.displaychest.events.EventBreakChest;
import me.xingyan.displaychest.events.EventDragItem;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getServer().getPluginManager().registerEvents(new EventDragItem(), this);
        this.getServer().getPluginManager().registerEvents(new EventBreakChest(), this);
        Objects.requireNonNull(getCommand("displaychest")).setExecutor(new CommandDisplayChest());
        Objects.requireNonNull(getCommand("displaychest")).setTabCompleter(new TabComp());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
