package me.firebreath15.backbone;

import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

public class A3Task  extends BukkitRunnable{
	
	main plugin;
	A3Task(main c){
		plugin=c;
	}
	
	@Override
	public void run() {
		//game is over, broadcast who won
		int rp = plugin.getConfig().getInt("rpoints3");
		int bp = plugin.getConfig().getInt("bpoints3");
		
		TPPlayers tp = new TPPlayers(plugin);
		
		if(rp > bp){
			plugin.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.RED+"Red Team won the game in arena 3!");
			//plugin.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.YELLOW+"The game is now over. All players please "+ChatColor.LIGHT_PURPLE+"/leave");
			tp.TeleportPlayersToBackboneSpawn();
		}
		if(bp > rp){
			plugin.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.BLUE+"Blue Team won the game in arena 3!");
			//plugin.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.YELLOW+"The game is now over. All players please "+ChatColor.LIGHT_PURPLE+"/leave");
			tp.TeleportPlayersToBackboneSpawn();
		}
		if(bp == rp){
			plugin.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.DARK_GREEN+"The game in arena 3 ended in a tie.");
			//plugin.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.YELLOW+"The game is now over. All players please "+ChatColor.LIGHT_PURPLE+"/leave");
			tp.TeleportPlayersToBackboneSpawn();
		}
		plugin.getConfig().set("rpoints3", 0);
		plugin.getConfig().set("bpoints3", 0);
		plugin.saveConfig();
	}

}
