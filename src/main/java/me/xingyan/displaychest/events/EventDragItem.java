package me.xingyan.displaychest.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class EventDragItem implements Listener {

    @EventHandler
    public void onDragItem(InventoryClickEvent event){
        if(event.getView().getTitle().equals(ChatColor.GREEN+"Locked Chest")) {
            event.setCancelled(true);
        }
    }

}
