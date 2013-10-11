/*
 * This deals with when the player joins / leaves the game
 * 
 * Created by FireBreath15
 */

package me.firebreath15.backbone;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
public class OnLeave implements Listener{

main plugin;
    
    OnLeave(main c) {
        plugin = c;
    }
    
    @EventHandler(priority=EventPriority.LOWEST)
    public void onPJoin(PlayerJoinEvent e){
    	plugin.api.removePlayerScoreboard(e.getPlayer());
    }
	
    @EventHandler
    public void onPKick(PlayerKickEvent event){
    	Player p = event.getPlayer();
    	String name = p.getName();
    	
		if(plugin.getConfig().contains("rplist1."+name)){
			//if they were on the red team
			plugin.getConfig().set("rplist1."+name, null);  //remove them from the red team
			plugin.getConfig().set("players1."+name, null);
			int np = plugin.getConfig().getInt("rplayers1");
			plugin.getConfig().set("rplayers1",np-1);
			plugin.saveConfig();
			p.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+name+" left the game!");
		}
		if(plugin.getConfig().contains("bplist1."+name)){
			//if they were on the blue team
			plugin.getConfig().set("bplist1."+name, null); //remove them from the blue team
			plugin.getConfig().set("players1."+name, null);
			int np = plugin.getConfig().getInt("bplayers1");
			plugin.getConfig().set("bplayers1",np-1);
			plugin.saveConfig();
			p.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+name+" left the game!");
		}
		
		if(plugin.getConfig().contains("rplist2."+name)){
			//if they were on the red team
			plugin.getConfig().set("rplist2."+name, null);  //remove them from the red team
			plugin.getConfig().set("players2."+name, null);
			int np = plugin.getConfig().getInt("rplayers2");
			plugin.getConfig().set("rplayers2",np-1);
			plugin.saveConfig();
			p.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+name+" left the game!");
		}
		if(plugin.getConfig().contains("bplist2."+name)){
			//if they were on the blue team
			plugin.getConfig().set("bplist2."+name, null); //remove them from the blue team
			plugin.getConfig().set("players2."+name, null);
			int np = plugin.getConfig().getInt("bplayers2");
			plugin.getConfig().set("bplayers2",np-1);
			plugin.saveConfig();
			p.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+name+" left the game!");
		}
		
		if(plugin.getConfig().contains("rplist3."+name)){
			//if they were on the red team
			plugin.getConfig().set("rplist3."+name, null);  //remove them from the red team
			plugin.getConfig().set("players3."+name, null);
			int np = plugin.getConfig().getInt("rplayers3");
			plugin.getConfig().set("rplayers3",np-1);
			plugin.saveConfig();
			p.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+name+" left the game!");
		}
		if(plugin.getConfig().contains("bplist3."+name)){
			//if they were on the blue team
			plugin.getConfig().set("bplist3."+name, null); //remove them from the blue team
			plugin.getConfig().set("players3."+name, null);
			int np = plugin.getConfig().getInt("bplayers3");
			plugin.getConfig().set("bplayers3",np-1);
			plugin.saveConfig();
			p.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+name+" left the game!");
		}
		
		if(plugin.getConfig().contains("rplist4."+name)){
			//if they were on the red team
			plugin.getConfig().set("rplist4."+name, null);  //remove them from the red team
			plugin.getConfig().set("players4."+name, null);
			int np = plugin.getConfig().getInt("rplayers4");
			plugin.getConfig().set("rplayers4",np-1);
			plugin.saveConfig();
			p.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+name+" left the game!");
		}
		if(plugin.getConfig().contains("bplist4."+name)){
			//if they were on the blue team
			plugin.getConfig().set("bplist4."+name, null); //remove them from the blue team
			plugin.getConfig().set("players4."+name, null);
			int np = plugin.getConfig().getInt("bplayers4");
			plugin.getConfig().set("bplayers4",np-1);
			plugin.saveConfig();
			p.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+name+" left the game!");
		}
		
		if(plugin.getConfig().contains("rplist5."+name)){
			//if they were on the red team
			plugin.getConfig().set("rplist5."+name, null);  //remove them from the red team
			plugin.getConfig().set("players5."+name, null);
			int np = plugin.getConfig().getInt("rplayers5");
			plugin.getConfig().set("rplayers5",np-1);
			plugin.saveConfig();
			p.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+name+" left the game!");
		}
		if(plugin.getConfig().contains("bplist5."+name)){
			//if they were on the blue team
			plugin.getConfig().set("bplist5."+name, null); //remove them from the blue team
			plugin.getConfig().set("players5."+name, null);
			int np = plugin.getConfig().getInt("bplayers5");
			plugin.getConfig().set("bplayers5",np-1);
			plugin.saveConfig();
			p.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+name+" left the game!");
		}
    }
    
	@EventHandler
	public void OnPQuit(PlayerQuitEvent event){
		Player p = event.getPlayer();
    	String name = p.getName();

		if(plugin.getConfig().contains("rplist1."+name)){
			//if they were on the red team
			plugin.getConfig().set("rplist1."+name, null);  //remove them from the red team
			plugin.getConfig().set("players1."+name, null);
			int np = plugin.getConfig().getInt("rplayers1");
			plugin.getConfig().set("rplayers1",np-1);
			plugin.saveConfig();
			p.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+name+" left the game!");
		}
		if(plugin.getConfig().contains("bplist1."+name)){
			//if they were on the blue team
			plugin.getConfig().set("bplist1."+name, null); //remove them from the blue team
			plugin.getConfig().set("players1."+name, null);
			int np = plugin.getConfig().getInt("bplayers1");
			plugin.getConfig().set("bplayers1",np-1);
			plugin.saveConfig();
			p.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+name+" left the game!");
		}
		
		if(plugin.getConfig().contains("rplist2."+name)){
			//if they were on the red team
			plugin.getConfig().set("rplist2."+name, null);  //remove them from the red team
			plugin.getConfig().set("players2."+name, null);
			int np = plugin.getConfig().getInt("rplayers2");
			plugin.getConfig().set("rplayers2",np-1);
			plugin.saveConfig();
			p.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+name+" left the game!");
		}
		if(plugin.getConfig().contains("bplist2."+name)){
			//if they were on the blue team
			plugin.getConfig().set("bplist2."+name, null); //remove them from the blue team
			plugin.getConfig().set("players2."+name, null);
			int np = plugin.getConfig().getInt("bplayers2");
			plugin.getConfig().set("bplayers2",np-1);
			plugin.saveConfig();
			p.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+name+" left the game!");
		}
		
		if(plugin.getConfig().contains("rplist3."+name)){
			//if they were on the red team
			plugin.getConfig().set("rplist3."+name, null);  //remove them from the red team
			plugin.getConfig().set("players3."+name, null);
			int np = plugin.getConfig().getInt("rplayers3");
			plugin.getConfig().set("rplayers3",np-1);
			plugin.saveConfig();
			p.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+name+" left the game!");
		}
		if(plugin.getConfig().contains("bplist3."+name)){
			//if they were on the blue team
			plugin.getConfig().set("bplist3."+name, null); //remove them from the blue team
			plugin.getConfig().set("players3."+name, null);
			int np = plugin.getConfig().getInt("bplayers3");
			plugin.getConfig().set("bplayers3",np-1);
			plugin.saveConfig();
			p.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+name+" left the game!");
		}
		
		if(plugin.getConfig().contains("rplist4."+name)){
			//if they were on the red team
			plugin.getConfig().set("rplist4."+name, null);  //remove them from the red team
			plugin.getConfig().set("players4."+name, null);
			int np = plugin.getConfig().getInt("rplayers4");
			plugin.getConfig().set("rplayers4",np-1);
			plugin.saveConfig();
			p.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+name+" left the game!");
		}
		if(plugin.getConfig().contains("bplist4."+name)){
			//if they were on the blue team
			plugin.getConfig().set("bplist4."+name, null); //remove them from the blue team
			plugin.getConfig().set("players4."+name, null);
			int np = plugin.getConfig().getInt("bplayers4");
			plugin.getConfig().set("bplayers4",np-1);
			plugin.saveConfig();
			p.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+name+" left the game!");
		}
		
		if(plugin.getConfig().contains("rplist5."+name)){
			//if they were on the red team
			plugin.getConfig().set("rplist5."+name, null);  //remove them from the red team
			plugin.getConfig().set("players5."+name, null);
			int np = plugin.getConfig().getInt("rplayers5");
			plugin.getConfig().set("rplayers5",np-1);
			plugin.saveConfig();
			p.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+name+" left the game!");
		}
		if(plugin.getConfig().contains("bplist5."+name)){
			//if they were on the blue team
			plugin.getConfig().set("bplist5."+name, null); //remove them from the blue team
			plugin.getConfig().set("players5."+name, null);
			int np = plugin.getConfig().getInt("bplayers5");
			plugin.getConfig().set("bplayers5",np-1);
			plugin.saveConfig();
			p.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+name+" left the game!");
		}
	}
	
	@EventHandler
	public void stopCommands(PlayerCommandPreprocessEvent e){
		Player p = e.getPlayer();
		String n = p.getName();
		if((plugin.getConfig().contains("players1."+n) || plugin.getConfig().contains("players2."+n) || plugin.getConfig().contains("players3."+n) || plugin.getConfig().contains("players4."+n) || plugin.getConfig().contains("players5."+n)) && (!e.getMessage().contains("bb"))){
			e.setCancelled(true);
			p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.RED+"You have to leave the game first!");
		}
	}
}
