package me.firebreath15.backbone;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class TPPlayers {
	
	main plugin;
	TPPlayers(main c){
		plugin=c;
	}
	
	public void TeleportPlayersToBackboneSpawn(){
		Player[] players = plugin.getServer().getOnlinePlayers();
		int pl = players.length;
		
		for(int i=0; i<pl; i++){
			Player p = players[i];
			String name = p.getName();
			
			if(plugin.getConfig().contains("rplist1."+name)){
				//if they were on the red team
				plugin.getConfig().set("rplist1."+name, null);  //remove them from the red team
				plugin.getConfig().set("players1."+name, null);
				int np = plugin.getConfig().getInt("rplayers1");
				plugin.getConfig().set("rplayers1",np-1);
				plugin.saveConfig();
				this.teleportThePlayer(p);
			}
			if(plugin.getConfig().contains("bplist1."+name)){
				//if they were on the blue team
				plugin.getConfig().set("bplist1."+name, null); //remove them from the blue team
				plugin.getConfig().set("players1."+name, null);
				int np = plugin.getConfig().getInt("bplayers1");
				plugin.getConfig().set("bplayers1",np-1);
				plugin.saveConfig();
				this.teleportThePlayer(p);
			}
			
			if(plugin.getConfig().contains("rplist2."+name)){
				//if they were on the red team
				plugin.getConfig().set("rplist2."+name, null);  //remove them from the red team
				plugin.getConfig().set("players2."+name, null);
				int np = plugin.getConfig().getInt("rplayers2");
				plugin.getConfig().set("rplayers2",np-1);
				plugin.saveConfig();
				this.teleportThePlayer(p);
			}
			if(plugin.getConfig().contains("bplist2."+name)){
				//if they were on the blue team
				plugin.getConfig().set("bplist2."+name, null); //remove them from the blue team
				plugin.getConfig().set("players2."+name, null);
				int np = plugin.getConfig().getInt("bplayers2");
				plugin.getConfig().set("bplayers2",np-1);
				plugin.saveConfig();
				this.teleportThePlayer(p);
			}
			
			if(plugin.getConfig().contains("rplist3."+name)){
				//if they were on the red team
				plugin.getConfig().set("rplist3."+name, null);  //remove them from the red team
				plugin.getConfig().set("players3."+name, null);
				int np = plugin.getConfig().getInt("rplayers3");
				plugin.getConfig().set("rplayers3",np-1);
				plugin.saveConfig();
				this.teleportThePlayer(p);
			}
			if(plugin.getConfig().contains("bplist3."+name)){
				//if they were on the blue team
				plugin.getConfig().set("bplist3."+name, null); //remove them from the blue team
				plugin.getConfig().set("players3."+name, null);
				int np = plugin.getConfig().getInt("bplayers3");
				plugin.getConfig().set("bplayers3",np-1);
				plugin.saveConfig();
				this.teleportThePlayer(p);
			}
			
			if(plugin.getConfig().contains("rplist4."+name)){
				//if they were on the red team
				plugin.getConfig().set("rplist4."+name, null);  //remove them from the red team
				plugin.getConfig().set("players4."+name, null);
				int np = plugin.getConfig().getInt("rplayers4");
				plugin.getConfig().set("rplayers4",np-1);
				plugin.saveConfig();
				this.teleportThePlayer(p);
			}
			if(plugin.getConfig().contains("bplist4."+name)){
				//if they were on the blue team
				plugin.getConfig().set("bplist4."+name, null); //remove them from the blue team
				plugin.getConfig().set("players4."+name, null);
				int np = plugin.getConfig().getInt("bplayers4");
				plugin.getConfig().set("bplayers4",np-1);
				plugin.saveConfig();
				this.teleportThePlayer(p);
			}
			
			if(plugin.getConfig().contains("rplist5."+name)){
				//if they were on the red team
				plugin.getConfig().set("rplist5."+name, null);  //remove them from the red team
				plugin.getConfig().set("players5."+name, null);
				int np = plugin.getConfig().getInt("rplayers5");
				plugin.getConfig().set("rplayers5",np-1);
				plugin.saveConfig();
				this.teleportThePlayer(p);
			}
			if(plugin.getConfig().contains("bplist5."+name)){
				//if they were on the blue team
				plugin.getConfig().set("bplist5."+name, null); //remove them from the blue team
				plugin.getConfig().set("players5."+name, null);
				int np = plugin.getConfig().getInt("bplayers5");
				plugin.getConfig().set("bplayers5",np-1);
				plugin.saveConfig();
				this.teleportThePlayer(p);
			}
		}
	}	
	
	@SuppressWarnings("deprecation")
	public void teleportThePlayer(Player p){
		if(plugin.getConfig().contains("spawn.x")){
			double x = plugin.getConfig().getDouble("spawn.x");
			double y = plugin.getConfig().getDouble("spawn.y");
			double z = plugin.getConfig().getDouble("spawn.z");
			String wn = plugin.getConfig().getString("spawn.world");
			World w = plugin.getServer().getWorld(wn);
			Location l = new Location(w,x,y,z);
			p.teleport(l);
			p.setLevel(0);	
			p.setFoodLevel(20);
			p.setHealth(20);
			p.sendMessage(ChatColor.GREEN+"You left the game! Thanks for playing!");
			this.nowRemoveTheirArmor(p);
		}
	}
	
	public void nowRemoveTheirArmor(Player p){
		ItemStack air = new ItemStack(Material.AIR);
		p.getInventory().setHelmet(air);
		p.getInventory().setChestplate(air);
		p.getInventory().setLeggings(air);
		p.getInventory().setBoots(air);
		
		p.getInventory().clear();
		
		ISCOREAPI api = new ISCOREAPI();
		api.setScoreboard(p);
		api.removePlayerFromTeam("Player", p);
		api.refreshPlayerScoreboard(p);
		api.removePlayerScoreboard(p);
	}
}
