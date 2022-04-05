package me.xingyan.displaychest.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CommandDisplayChest implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length == 0){
            sender.sendMessage(ChatColor.GOLD+"----------"+ChatColor.AQUA+"Display Chest"+ChatColor.GOLD+"----------");
            sender.sendMessage(ChatColor.GOLD+"Commands:");
            sender.sendMessage(ChatColor.GOLD+"/"+label+" Debug  "+ChatColor.GRAY+"| "+ChatColor.AQUA+"Display Debug Command Help Menu");
            sender.sendMessage(ChatColor.GOLD+"/"+label+" Lock   "+ChatColor.GRAY+"| "+ChatColor.AQUA+"The Chest");
            sender.sendMessage(ChatColor.GOLD+"/"+label+" Unlock "+ChatColor.GRAY+"| "+ChatColor.AQUA+"Unlock The Chest");
            sender.sendMessage(ChatColor.GOLD+"----------"+ChatColor.AQUA+"Display Chest"+ChatColor.GOLD+"----------");
            return true;
        }
        if(args[0].equals("debug")){
            if(!(args.length == 1)){
                if(args[1].equals("ChestTest1")){
                    ItemStack is = new ItemStack(Material.CHEST);
                    ItemMeta im = is.getItemMeta();
                    im.setDisplayName(ChatColor.GREEN+"Locked Chest");
                    is.setItemMeta(im);
                    sender.getServer().getPlayer(sender.getName()).getInventory().addItem(is);
                    sender.sendMessage(ChatColor.GREEN+"Successful!");
                    return true;
                }
                if(args[1].equals("ChestTest2")){
                    ItemStack is = new ItemStack(Material.CHEST);
                    ItemMeta im = is.getItemMeta();
                    im.setDisplayName(ChatColor.GRAY+"Unlocked Chest");
                    is.setItemMeta(im);
                    sender.getServer().getPlayer(sender.getName()).getInventory().addItem(is);
                    sender.sendMessage(ChatColor.GREEN+"Successful!");
                    return true;
                }
            }else{
                sender.sendMessage(ChatColor.GOLD+"----------"+ChatColor.AQUA+"Debug"+ChatColor.GOLD+"----------");
                sender.sendMessage(ChatColor.GOLD+"Debugs:");
                sender.sendMessage(ChatColor.AQUA+"ChestTest1"+ChatColor.GOLD+", "+ChatColor.AQUA+"ChestTest2");
                sender.sendMessage(ChatColor.GOLD+"----------"+ChatColor.AQUA+"Debug"+ChatColor.GOLD+"----------");
                return true;
            }
        }
        if(args[0].equals("unlock")){
            Player player = sender.getServer().getPlayer(sender.getName());
            assert player != null;
            if(!player.getTargetBlock(null, 200).getType().equals(Material.CHEST)){
                player.sendMessage(ChatColor.RED+"Please Look At The Chest");
                return true;
            }
            Chest chest = (Chest) player.getTargetBlock(null, 200).getState();
            if(Objects.equals(chest.getCustomName(), ChatColor.GRAY + "Unlocked Chest")){
                player.sendMessage(ChatColor.RED+"Chest Already Unlocked!");
                return true;
            }
            player.sendMessage(ChatColor.GREEN+"Chest Unlocked!");
            chest.setCustomName(ChatColor.GRAY+"Unlocked Chest");
            chest.update();
        }
        if(args[0].equals("lock")){
            Player player = sender.getServer().getPlayer(sender.getName());
            assert player != null;
            if(!player.getTargetBlock(null, 200).getType().equals(Material.CHEST)){
                player.sendMessage(ChatColor.RED+"Please Look At The Chest");
                return true;
            }
            Chest chest = (Chest) player.getTargetBlock(null, 200).getState();
            if(Objects.equals(chest.getCustomName(), ChatColor.GREEN + "Locked Chest")){
                player.sendMessage(ChatColor.RED+"Chest Already Locked!");
                return true;
            }
            player.sendMessage(ChatColor.GREEN+"Chest Locked!");
            chest.setCustomName(ChatColor.GREEN+"Locked Chest");
            chest.update();
        }
        return true;
    }
}
