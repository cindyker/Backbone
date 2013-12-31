package me.firebreath15.backbone;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class Pregame extends BukkitRunnable{	
	main plugin;
	String a;
	Player p;
	int q;
	Pregame(main c, String ar, Player pl, int queue){
		plugin=c;
		a=ar;
		p=pl;
		q=queue;
	}
	
	public void run(){
		if(q == 2){ //there is 1 other player in the game, so we're the second. START COUNTDOWN!
			//start StartGame
			@SuppressWarnings("unused")
			BukkitTask start = new Startgame(plugin).runTaskLater(plugin, 400);
			Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"Arena "+a+" starting in 20 seconds!");
			//queue player in StartGame array
			Startgame.map.put(p.getName(), a);
		}
		if(q >= 3){ //there are other players playing and the countdown has started. 
			//queue player in StartGame array
			Startgame.map.put(p.getName(), a);
		}
		if(q == 1){ //we're first. queue us! 
			//queue player in StartGame array
			Startgame.map.put(p.getName(), a);
		}
	}
}
