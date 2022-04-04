package me.xingyan.displaychest.events;

import org.bukkit.ChatColor;
import org.bukkit.block.Chest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class EventBreakChest implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event){
        Chest chest = (Chest) event.getBlock().getState();
        if(chest.getCustomName().equals(ChatColor.GREEN+"Locked Chest")){
            event.getPlayer().sendMessage(ChatColor.RED+"You Can't Break This Locked Chest!");
            event.setCancelled(true);
        }
    }
}
