/*
 * 
 * Did someone drop an item? :O they cant do that its illegal! This class stops them from dropping items when theyre not dead
 * well we'll stop em if there playing
 * 
 */

package me.firebreath15.backbone;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerDropItemEvent;

public class OnDrop implements Listener{
	
	main plugin;
	OnDrop(main c){
		plugin=c;
	}
	
	@EventHandler
	public void DontDropIt(PlayerDropItemEvent event){
		String name = event.getPlayer().getName();
		if(plugin.getConfig().contains("players1."+name) || plugin.getConfig().contains("players2."+name) || plugin.getConfig().contains("players3."+name) || plugin.getConfig().contains("players4."+name) || plugin.getConfig().contains("players5."+name)){
			event.setCancelled(true);
		}
	}
}