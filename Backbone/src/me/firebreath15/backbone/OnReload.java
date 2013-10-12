/*
 * This handles the reloading station. When players right click a block, and if that block
 * is our reloader, their ammo and food is replenished. Health is regained normally.
 * 
 * Created by FireBreath15
 */

package me.firebreath15.backbone;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class OnReload implements Listener{
	
    main plugin;
    
    OnReload(main c) {
        plugin = c;
    }
	
    @EventHandler
	public void onReload(PlayerInteractEvent event){
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
			if(plugin.getConfig().contains("reloader1.x")){
				//ok so theyre rightclicking a block, and we've already set the reloader
				//that means theyre reloading =D
				//
				//lets get all the variables together
		double reloadx = event.getClickedBlock().getX();
		double reloady = event.getClickedBlock().getY();
		double reloadz = event.getClickedBlock().getZ();
		World wor = event.getClickedBlock().getWorld();
		double rx = plugin.getConfig().getDouble("reloader1.x");
		double ry = plugin.getConfig().getDouble("reloader1.y");
		double rz = plugin.getConfig().getDouble("reloader1.z");
		String wn = plugin.getConfig().getString("reloader1.world");
		World w = plugin.getServer().getWorld(wn);
		
		//kk, now are they clicking the reloader block?
		if(reloadx == rx && reloady == ry && reloadz == rz && wor == w){
			//ok theyre clicking the right block. Lets reload them now.
					Player guy = event.getPlayer();	
					if(guy.getLevel() == 0){
					guy.setLevel(40);
					guy.setHealth(20D);
					guy.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"Ammo and Health Reloaded!");
					//tell them theyre all good. ok done reloading!
					}else{
						guy.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You still have ammo left!");
						guy.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You still have ammo left!");
					}
				}
			}
			
			if(plugin.getConfig().contains("reloader2.x")){
				//ok so theyre rightclicking a block, and we've already set the reloader
				//that means theyre reloading =D
				//
				//lets get all the variables together
				double reloadx = event.getClickedBlock().getX();
				double reloady = event.getClickedBlock().getY();
				double reloadz = event.getClickedBlock().getZ();
				World wor = event.getClickedBlock().getWorld();
				double rx = plugin.getConfig().getDouble("reloader2.x");
				double ry = plugin.getConfig().getDouble("reloader2.y");
				double rz = plugin.getConfig().getDouble("reloader2.z");
				String wn = plugin.getConfig().getString("reloader2.world");
				World w = plugin.getServer().getWorld(wn);
				
				//kk, now are they clicking the reloader block?
				if(reloadx == rx && reloady == ry && reloadz == rz && wor == w){
			//ok theyre clicking the right block. Lets reload them now.
					Player guy = event.getPlayer();	
					if(guy.getLevel() == 0){
						guy.setLevel(40);
						guy.setHealth(20D);
						guy.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"Ammo and Health Reloaded!");
					//tell them theyre all good. ok done reloading!
					}else{
						guy.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You still have ammo left!");
					}
				}
			}
			
			if(plugin.getConfig().contains("reloader3.x")){
				//ok so theyre rightclicking a block, and we've already set the reloader
				//that means theyre reloading =D
				//
				//lets get all the variables together
				double reloadx = event.getClickedBlock().getX();
				double reloady = event.getClickedBlock().getY();
				double reloadz = event.getClickedBlock().getZ();
				World wor = event.getClickedBlock().getWorld();
				double rx = plugin.getConfig().getDouble("reloader3.x");
				double ry = plugin.getConfig().getDouble("reloader3.y");
				double rz = plugin.getConfig().getDouble("reloader3.z");
				String wn = plugin.getConfig().getString("reloader3.world");
				World w = plugin.getServer().getWorld(wn);
				
				//kk, now are they clicking the reloader block?
				if(reloadx == rx && reloady == ry && reloadz == rz && wor == w){
			//ok theyre clicking the right block. Lets reload them now.
					Player guy = event.getPlayer();	
					if(guy.getLevel() == 0){
						guy.setLevel(40);
						guy.setHealth(20D);
						guy.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"Ammo and Health Reloaded!");
					//tell them theyre all good. ok done reloading!
					}else{
						guy.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You still have ammo left!");
					}
				}
			}
			
			if(plugin.getConfig().contains("reloader4.x")){
				//ok so theyre rightclicking a block, and we've already set the reloader
				//that means theyre reloading =D
				//
				//lets get all the variables together
				double reloadx = event.getClickedBlock().getX();
				double reloady = event.getClickedBlock().getY();
				double reloadz = event.getClickedBlock().getZ();
				World wor = event.getClickedBlock().getWorld();
				double rx = plugin.getConfig().getDouble("reloader4.x");
				double ry = plugin.getConfig().getDouble("reloader4.y");
				double rz = plugin.getConfig().getDouble("reloader4.z");
				String wn = plugin.getConfig().getString("reloader4.world");
				World w = plugin.getServer().getWorld(wn);
				
				//kk, now are they clicking the reloader block?
				if(reloadx == rx && reloady == ry && reloadz == rz && wor == w){
			//ok theyre clicking the right block. Lets reload them now.
					Player guy = event.getPlayer();	
					if(guy.getLevel() == 0){
						guy.setLevel(40);
						guy.setHealth(20D);
						guy.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"Ammo and Health Reloaded!");
					//tell them theyre all good. ok done reloading!
					}else{
						guy.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You still have ammo left!");
					}
				}
			}
			
			if(plugin.getConfig().contains("reloader5.x")){
				//ok so theyre rightclicking a block, and we've already set the reloader
				//that means theyre reloading =D
				//
				//lets get all the variables together
				double reloadx = event.getClickedBlock().getX();
				double reloady = event.getClickedBlock().getY();
				double reloadz = event.getClickedBlock().getZ();
				World wor = event.getClickedBlock().getWorld();
				double rx = plugin.getConfig().getDouble("reloader5.x");
				double ry = plugin.getConfig().getDouble("reloader5.y");
				double rz = plugin.getConfig().getDouble("reloader5.z");
				String wn = plugin.getConfig().getString("reloader5.world");
				World w = plugin.getServer().getWorld(wn);
				
				//kk, now are they clicking the reloader block?
				if(reloadx == rx && reloady == ry && reloadz == rz && wor == w){
			//ok theyre clicking the right block. Lets reload them now.
					Player guy = event.getPlayer();	
					if(guy.getLevel() == 0){
						guy.setLevel(40);
						guy.setHealth(20D);
						guy.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"Ammo and Health Reloaded!");
					//tell them theyre all good. ok done reloading!
					}else{
						guy.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You still have ammo left!");
					}
		}
		
	}
		} } }