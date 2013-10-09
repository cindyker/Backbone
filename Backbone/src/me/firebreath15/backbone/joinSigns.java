package me.firebreath15.backbone;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class joinSigns implements Listener{
	
	main plugin;
	joinSigns(main c){
		plugin=c;
	}
	
	@EventHandler
	public void onSignCreate(SignChangeEvent e){
		Player p = e.getPlayer();
		if(e.getLine(0).equalsIgnoreCase("[backbone]")){
			if(p.hasPermission("backbone.sign")){
				e.setLine(0, ChatColor.DARK_PURPLE+"[Backbone]");
				
				if(e.getLine(1).equalsIgnoreCase("join")){
					if(e.getLine(2) != null){
						e.setLine(1, ChatColor.YELLOW+"Join");
						String l2 = e.getLine(2);
						e.setLine(2,"Arena: "+l2);
						e.setLine(3, ChatColor.DARK_BLUE+"Click to play!");
						p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"Sign created!");
					}else{
						e.setLine(1, ChatColor.YELLOW+"!ERROR!");
						e.setLine(2, ChatColor.DARK_RED+"Unsupported");
						e.setLine(3, ChatColor.DARK_RED+"Action!");
						p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"Sign creation error: is it following the format?");
					}
				}else{
					e.setLine(1, ChatColor.YELLOW+"!ERROR!");
					e.setLine(2, ChatColor.DARK_RED+"Unsupported");
					e.setLine(3, ChatColor.DARK_RED+"Action!");
					p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"Sign creation error: is it following the format?");
				}
			}else{
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onSignClick(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(e.getAction()==Action.RIGHT_CLICK_BLOCK && (e.getClickedBlock().getType()==Material.SIGN_POST || e.getClickedBlock().getType()==Material.WALL_SIGN || e.getClickedBlock().getType()==Material.SIGN)){
			Sign s = (Sign)e.getClickedBlock().getState();
			if(s.getLine(0).equalsIgnoreCase(ChatColor.DARK_PURPLE+"[Backbone]")){
				if(s.getLine(1).equalsIgnoreCase(ChatColor.YELLOW+"Join")){
					String l3 = s.getLine(2);
					String an = l3.replaceAll("Arena: ", "");
					plugin.cc.joinGame(p, an);
					
					ISCOREAPI api = new ISCOREAPI();
					
					api.createObjective("Arena_"+an, "Backbone");
					api.createTeam("Player");
					api.setScore(Bukkit.getOfflinePlayer(ChatColor.RED+"Red"), 0);
					api.setScore(Bukkit.getOfflinePlayer(ChatColor.BLUE+"Blue"), 0);
					api.addPlayerToTeam("Player", p);
					api.refreshPlayerScoreboard(p);
					
				}
			}
		}
	}
}
