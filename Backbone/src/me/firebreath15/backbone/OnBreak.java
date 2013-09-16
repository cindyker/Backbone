/*
 * This tests if the server is protected. If so, no one can break blocks. Otherwise
 * everyone can.
 * 
 * Created by Firebreath15
 */

package me.firebreath15.backbone;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class OnBreak implements Listener{

main plugin;
    
    OnBreak(main c) {
        plugin = c;
    }
	
    @EventHandler
    public void onBreak(BlockBreakEvent event){
    	if(!event.getPlayer().hasPermission("backbone.break")){
    		if(plugin.getConfig().contains("players1."+event.getPlayer().getName()) || plugin.getConfig().contains("players2."+event.getPlayer().getName()) || plugin.getConfig().contains("players3."+event.getPlayer().getName()) || plugin.getConfig().contains("players4."+event.getPlayer().getName()) || plugin.getConfig().contains("players5."+event.getPlayer().getName())){
    			event.setCancelled(true);
    		}
    	}
    }
    
    @EventHandler
    public void onPlace(BlockPlaceEvent event){
    	if(!event.getPlayer().hasPermission("backbone.place")){
    		if(plugin.getConfig().contains("players1."+event.getPlayer().getName()) || plugin.getConfig().contains("players2."+event.getPlayer().getName()) || plugin.getConfig().contains("players3."+event.getPlayer().getName()) || plugin.getConfig().contains("players4."+event.getPlayer().getName()) || plugin.getConfig().contains("players5."+event.getPlayer().getName())){
    			event.setCancelled(true);
    		}
    	}
    }
}
