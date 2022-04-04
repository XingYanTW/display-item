package me.xingyan.displaychest;

import me.xingyan.displaychest.commands.CommandDisplayItem;
import me.xingyan.displaychest.events.EventBreakChest;
import me.xingyan.displaychest.events.EventDragItem;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getServer().getPluginManager().registerEvents(new EventDragItem(), this);
        this.getServer().getPluginManager().registerEvents(new EventBreakChest(), this);
        getCommand("DisplayItem").setExecutor(new CommandDisplayItem());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
