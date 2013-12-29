package me.firebreath15.backbone;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class SetReload implements Listener{
	main plugin;
	String a;
	
	SetReload(main c, String arena){
		plugin=c;
		a=arena;
	}
	
	@EventHandler
	public void onReloaderSet(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(e.getAction()==Action.RIGHT_CLICK_BLOCK){
			if(p.hasPermission("backbone.setreload")){
				Location l = e.getClickedBlock().getLocation();
				plugin.getConfig().set("reloader"+a+".x", l.getX());
				plugin.getConfig().set("reloader"+a+".y", l.getY());
				plugin.getConfig().set("reloader"+a+".z", l.getZ());
				plugin.getConfig().set("reloader"+a+".world", l.getWorld().getName());
				plugin.saveConfig();
				p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You set the arena "+a+" Reload Station! Players can click that block to regain health and ammo!");
				PlayerInteractEvent.getHandlerList().unregister(this);
			}
		}
	}
}
