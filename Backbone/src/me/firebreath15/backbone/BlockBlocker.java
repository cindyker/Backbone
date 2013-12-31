package me.firebreath15.backbone;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class BlockBlocker implements Listener{
	main plugin;
	BlockBlocker(main c){
		plugin=c;
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e){
		Player p = e.getPlayer();
		if(plugin.getConfig().contains("players1."+p.getName()) || plugin.getConfig().contains("players2."+p.getName()) || plugin.getConfig().contains("players3."+p.getName()) || plugin.getConfig().contains("players4."+p.getName()) || plugin.getConfig().contains("players5."+p.getName())){
			if(!p.isOp()){
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onBlockPlace(BlockBreakEvent e){
		Player p = e.getPlayer();
		if(plugin.getConfig().contains("players1."+p.getName()) || plugin.getConfig().contains("players2."+p.getName()) || plugin.getConfig().contains("players3."+p.getName()) || plugin.getConfig().contains("players4."+p.getName()) || plugin.getConfig().contains("players5."+p.getName())){
			if(!p.isOp()){
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void stopCommands(PlayerCommandPreprocessEvent e){
		Player p = e.getPlayer();
		if(plugin.getConfig().contains("players1."+p.getName()) || plugin.getConfig().contains("players2."+p.getName()) || plugin.getConfig().contains("players3."+p.getName()) || plugin.getConfig().contains("players4."+p.getName()) || plugin.getConfig().contains("players5."+p.getName())){
			if(e.getMessage().contains("bb") || e.getMessage().contains("backbone")){
				//do nothing
			}else{
				e.setCancelled(true);
				p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.RED+"You must leave before sending commands!");
			}
		}
	}
}
