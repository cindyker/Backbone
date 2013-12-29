package me.firebreath15.backbone;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class OnReload implements Listener{
	main plugin;
	OnReload(main c){
		plugin=c;
	}
	
	@EventHandler
	public void onClickReloaderBlock(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(e.getAction()==Action.RIGHT_CLICK_BLOCK){
			Location l = e.getClickedBlock().getLocation();
			
			if(plugin.getConfig().contains("players1."+p.getName())){
				double rx = plugin.getConfig().getDouble("reloader1.x");
				double ry = plugin.getConfig().getDouble("reloader1.y");
				double rz = plugin.getConfig().getDouble("reloader1.z");
				if(rx==l.getX() && ry==l.getY() && rz==l.getZ()){
					if(p.getLevel() == 0){
						p.setExp(0);
						p.setLevel(40);
						p.setFoodLevel(20);
						p.setHealth(20d);
						p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"Reloaded!");
					}
				}
			}
			
			if(plugin.getConfig().contains("players2."+p.getName())){
				double rx = plugin.getConfig().getDouble("reloader2.x");
				double ry = plugin.getConfig().getDouble("reloader2.y");
				double rz = plugin.getConfig().getDouble("reloader2.z");
				if(rx==l.getX() && ry==l.getY() && rz==l.getZ()){
					if(p.getLevel() == 0){
						p.setExp(0);
						p.setLevel(40);
						p.setFoodLevel(20);
						p.setHealth(20d);
						p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"Reloaded!");
					}
				}
			}
			
			if(plugin.getConfig().contains("players3."+p.getName())){
				double rx = plugin.getConfig().getDouble("reloader3.x");
				double ry = plugin.getConfig().getDouble("reloader3.y");
				double rz = plugin.getConfig().getDouble("reloader3.z");
				if(rx==l.getX() && ry==l.getY() && rz==l.getZ()){
					if(p.getLevel() == 0){
						p.setExp(0);
						p.setLevel(40);
						p.setFoodLevel(20);
						p.setHealth(20d);
						p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"Reloaded!");
					}
				}
			}
			
			if(plugin.getConfig().contains("players4."+p.getName())){
				double rx = plugin.getConfig().getDouble("reloader4.x");
				double ry = plugin.getConfig().getDouble("reloader4.y");
				double rz = plugin.getConfig().getDouble("reloader4.z");
				if(rx==l.getX() && ry==l.getY() && rz==l.getZ()){
					if(p.getLevel() == 0){
						p.setExp(0);
						p.setLevel(40);
						p.setFoodLevel(20);
						p.setHealth(20d);
						p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"Reloaded!");
					}
				}
			}
			
			if(plugin.getConfig().contains("players5."+p.getName())){
				double rx = plugin.getConfig().getDouble("reloader5.x");
				double ry = plugin.getConfig().getDouble("reloader5.y");
				double rz = plugin.getConfig().getDouble("reloader5.z");
				if(rx==l.getX() && ry==l.getY() && rz==l.getZ()){
					if(p.getLevel() == 0){
						p.setExp(0);
						p.setLevel(40);
						p.setFoodLevel(20);
						p.setHealth(20d);
						p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"Reloaded!");
					}
				}
			}
		}
	}
}
