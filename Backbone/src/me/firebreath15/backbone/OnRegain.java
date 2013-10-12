package me.firebreath15.backbone;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class OnRegain implements Listener{
	main plugin;
	OnRegain(main c){
		plugin=c;
	}
	
	// This class stops health regain and food consumption. It helps the game feel more
	// 'solid'. Health will be regained using the reload station.
	
	@EventHandler
	public void onHealthRegain(EntityRegainHealthEvent e){
		if(e.getEntity() instanceof Player){
			Player p = (Player)e.getEntity();
			if(plugin.getConfig().contains("players1."+p.getName()) || plugin.getConfig().contains("players2."+p.getName()) || plugin.getConfig().contains("players3."+p.getName()) || plugin.getConfig().contains("players4."+p.getName()) || plugin.getConfig().contains("players5."+p.getName())){
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onFoodConsumption(FoodLevelChangeEvent e){
		if(e.getEntity() instanceof Player){
			Player p = (Player)e.getEntity();
			if(plugin.getConfig().contains("players1."+p.getName()) || plugin.getConfig().contains("players2."+p.getName()) || plugin.getConfig().contains("players3."+p.getName()) || plugin.getConfig().contains("players4."+p.getName()) || plugin.getConfig().contains("players5."+p.getName())){
				e.setCancelled(true);
			}
		}
	}
}