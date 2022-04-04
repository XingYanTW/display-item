package me.xingyan.displaychest.commands;

import net.kyori.adventure.text.Component;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CommandDisplayItem implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length == 0){
            sender.sendMessage("----------Display Item----------");
            sender.sendMessage("Commands:");
            sender.sendMessage("/di debug  | Display Debug Command Help Menu");
            sender.sendMessage("/di lock   | Lock The Chest");
            sender.sendMessage("/di unlock | Unlock The Chest");
            sender.sendMessage("----------Display Item----------");
            return true;
        }
        if(args[0].equals("debug")){
            if(!(args.length == 1)){
                if(args[1].equals("ChestTest")){
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
                sender.sendMessage("----------Debug----------");
                sender.sendMessage("Debugs:");
                sender.sendMessage("ChestTest, ChestTest2");
                sender.sendMessage("----------Debug----------");
                return true;
            }
        }
        if(args[0].equals("unlock")){
            Player player = sender.getServer().getPlayer(sender.getName());
            assert player != null;
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
