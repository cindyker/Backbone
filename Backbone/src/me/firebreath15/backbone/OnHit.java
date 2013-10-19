package me.firebreath15.backbone;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.meta.FireworkMeta;

public class OnHit implements Listener{
	main plugin;
	OnHit(main c){
		plugin=c;
	}
	
	Armor a = new Armor();
	ISCOREAPI api = new ISCOREAPI();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerFight(EntityDamageByEntityEvent e){
		if(e.getEntity() instanceof Player){
			Player p = (Player)e.getEntity();
			World w = p.getWorld();
			if(plugin.getConfig().contains("players1."+p.getName()) || plugin.getConfig().contains("players2."+p.getName()) || plugin.getConfig().contains("players3."+p.getName()) || plugin.getConfig().contains("players4."+p.getName()) || plugin.getConfig().contains("players5."+p.getName())){
				
				//If snowball fighting
				if(e.getDamager() instanceof Snowball){
					Snowball s = (Snowball)e.getDamager();
					Player d = (Player)s.getShooter();
					if((plugin.getConfig().contains("bplist1."+p.getName()) && plugin.getConfig().contains("rplist1."+d.getName())) || (plugin.getConfig().contains("rplist1."+p.getName()) && plugin.getConfig().contains("bplist1."+d.getName())) || (plugin.getConfig().contains("bplist2."+p.getName()) && plugin.getConfig().contains("rplist2."+d.getName())) || (plugin.getConfig().contains("rplist2."+p.getName()) && plugin.getConfig().contains("bplist2."+d.getName())) || (plugin.getConfig().contains("bplist3."+p.getName()) && plugin.getConfig().contains("rplist3."+d.getName())) || (plugin.getConfig().contains("rplist3."+p.getName()) && plugin.getConfig().contains("bplist3."+d.getName())) || (plugin.getConfig().contains("bplist4."+p.getName()) && plugin.getConfig().contains("rplist4."+d.getName())) || (plugin.getConfig().contains("rplist4."+p.getName()) && plugin.getConfig().contains("bplist4."+d.getName())) || (plugin.getConfig().contains("bplist5."+p.getName()) && plugin.getConfig().contains("rplist5."+d.getName())) || (plugin.getConfig().contains("rplist5."+p.getName()) && plugin.getConfig().contains("bplist5."+d.getName())) ){
						Damageable dm = p;
						if(dm.getHealth() >= 3){
							e.setDamage(2d);
						}else{
							if(plugin.getConfig().contains("rplist1."+p.getName())){
								
								   if(plugin.getConfig().contains("rplist1."+p.getName())){
                                       
                                       Player[] online = Bukkit.getServer().getOnlinePlayers();
                                       for(int i=0; i<online.length; i++){
                                               Player pl = online[i];
                                               if(plugin.getConfig().contains("rplist1."+pl.getName()) || plugin.getConfig().contains("bplist1."+pl.getName())){
                                                       api.setScoreboard(pl);
                                                       int sc = api.getScores(Bukkit.getOfflinePlayer(ChatColor.BLUE+"Blue"));
                                                       api.setScore(Bukkit.getOfflinePlayer(ChatColor.BLUE+"Blue"), sc+1);
                                               }
                                       }
								
								p.getInventory().setArmorContents(a.redarmor);
								double x = plugin.getConfig().getDouble("redspawn1.x");
								double y = plugin.getConfig().getDouble("redspawn1.y");
								double z = plugin.getConfig().getDouble("redspawn1.z");
    							Location l = new Location(w,x,y,z);
    							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
    							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
    							data.setPower(0);
    							firework.setFireworkMeta(data);
    							p.teleport(l);
    							p.setLevel(40);
    							p.setHealth(20);
    							p.setFoodLevel(20);
    							d.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+p.getName()+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+d.getName());
    							if(plugin.getConfig().contains(d.getName())){
    								int pts = plugin.getConfig().getInt(d.getName());
    								plugin.getConfig().set(d.getName(),pts+100);
    								plugin.saveConfig();
    							}else{
    								plugin.getConfig().set(d.getName(),100);
    								plugin.saveConfig();
    							}
    							int kpoints = plugin.getConfig().getInt("bpoints1");
    							plugin.getConfig().set("bpoints1", kpoints+1);
							}
							if(plugin.getConfig().contains("rplist2."+p.getName())){
								
								Player[] online = Bukkit.getServer().getOnlinePlayers();
                                for(int i=0; i<online.length; i++){
                                        Player pl = online[i];
                                        if(plugin.getConfig().contains("rplist2."+pl.getName()) || plugin.getConfig().contains("bplist2."+pl.getName())){
                                                api.setScoreboard(pl);
                                                int sc = api.getScores(Bukkit.getOfflinePlayer(ChatColor.BLUE+"Blue"));
                                                api.setScore(Bukkit.getOfflinePlayer(ChatColor.BLUE+"Blue"), sc+1);
                                        }
                                }
								
								p.getInventory().setArmorContents(a.redarmor);
								double x = plugin.getConfig().getDouble("redspawn2.x");
								double y = plugin.getConfig().getDouble("redspawn2.y");
								double z = plugin.getConfig().getDouble("redspawn2.z");
    							Location l = new Location(w,x,y,z);
    							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
    							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
    							data.setPower(0);
    							firework.setFireworkMeta(data);
    							p.teleport(l);
    							p.setLevel(40);
    							p.setHealth(20);
    							p.setFoodLevel(20);
    							d.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+p.getName()+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+d.getName());
    							if(plugin.getConfig().contains(d.getName())){
    								int pts = plugin.getConfig().getInt(d.getName());
    								plugin.getConfig().set(d.getName(),pts+100);
    								plugin.saveConfig();
    							}else{
    								plugin.getConfig().set(d.getName(),100);
    								plugin.saveConfig();
    							}
    							int kpoints = plugin.getConfig().getInt("bpoints2");
    							plugin.getConfig().set("bpoints2", kpoints+1);
							}
							if(plugin.getConfig().contains("rplist3."+p.getName())){
								
								Player[] online = Bukkit.getServer().getOnlinePlayers();
                                for(int i=0; i<online.length; i++){
                                        Player pl = online[i];
                                        if(plugin.getConfig().contains("rplist3."+pl.getName()) || plugin.getConfig().contains("bplist3."+pl.getName())){
                                                api.setScoreboard(pl);
                                                int sc = api.getScores(Bukkit.getOfflinePlayer(ChatColor.BLUE+"Blue"));
                                                api.setScore(Bukkit.getOfflinePlayer(ChatColor.BLUE+"Blue"), sc+1);
                                        }
                                }
								
								p.getInventory().setArmorContents(a.redarmor);
								double x = plugin.getConfig().getDouble("redspawn3.x");
								double y = plugin.getConfig().getDouble("redspawn3.y");
								double z = plugin.getConfig().getDouble("redspawn3.z");
    							Location l = new Location(w,x,y,z);
    							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
    							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
    							data.setPower(0);
    							firework.setFireworkMeta(data);
    							p.teleport(l);
    							p.setLevel(40);
    							p.setHealth(20);
    							p.setFoodLevel(20);
    							d.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+p.getName()+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+d.getName());
    							if(plugin.getConfig().contains(d.getName())){
    								int pts = plugin.getConfig().getInt(d.getName());
    								plugin.getConfig().set(d.getName(),pts+100);
    								plugin.saveConfig();
    							}else{
    								plugin.getConfig().set(d.getName(),100);
    								plugin.saveConfig();
    							}
    							int kpoints = plugin.getConfig().getInt("bpoints3");
    							plugin.getConfig().set("bpoints3", kpoints+1);
							}
							if(plugin.getConfig().contains("rplist4."+p.getName())){
								
								Player[] online = Bukkit.getServer().getOnlinePlayers();
                                for(int i=0; i<online.length; i++){
                                        Player pl = online[i];
                                        if(plugin.getConfig().contains("rplist4."+pl.getName()) || plugin.getConfig().contains("bplist4."+pl.getName())){
                                                api.setScoreboard(pl);
                                                int sc = api.getScores(Bukkit.getOfflinePlayer(ChatColor.BLUE+"Blue"));
                                                api.setScore(Bukkit.getOfflinePlayer(ChatColor.BLUE+"Blue"), sc+1);
                                        }
                                }
								
								p.getInventory().setArmorContents(a.redarmor);
								double x = plugin.getConfig().getDouble("redspawn4.x");
								double y = plugin.getConfig().getDouble("redspawn4.y");
								double z = plugin.getConfig().getDouble("redspawn4.z");
    							Location l = new Location(w,x,y,z);
    							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
    							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
    							data.setPower(0);
    							firework.setFireworkMeta(data);
    							p.teleport(l);
    							p.setLevel(40);
    							p.setHealth(20);
    							p.setFoodLevel(20);
    							d.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+p.getName()+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+d.getName());
    							if(plugin.getConfig().contains(d.getName())){
    								int pts = plugin.getConfig().getInt(d.getName());
    								plugin.getConfig().set(d.getName(),pts+100);
    								plugin.saveConfig();
    							}else{
    								plugin.getConfig().set(d.getName(),100);
    								plugin.saveConfig();
    							}
    							int kpoints = plugin.getConfig().getInt("bpoints4");
    							plugin.getConfig().set("bpoints4", kpoints+1);
							}
							if(plugin.getConfig().contains("rplist5."+p.getName())){
								
								Player[] online = Bukkit.getServer().getOnlinePlayers();
                                for(int i=0; i<online.length; i++){
                                        Player pl = online[i];
                                        if(plugin.getConfig().contains("rplist5."+pl.getName()) || plugin.getConfig().contains("bplist5."+pl.getName())){
                                                api.setScoreboard(pl);
                                                int sc = api.getScores(Bukkit.getOfflinePlayer(ChatColor.BLUE+"Blue"));
                                                api.setScore(Bukkit.getOfflinePlayer(ChatColor.BLUE+"Blue"), sc+1);
                                        }
                                }
								
								p.getInventory().setArmorContents(a.redarmor);
								double x = plugin.getConfig().getDouble("redspawn5.x");
								double y = plugin.getConfig().getDouble("redspawn5.y");
								double z = plugin.getConfig().getDouble("redspawn5.z");
    							Location l = new Location(w,x,y,z);
    							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
    							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
    							data.setPower(0);
    							firework.setFireworkMeta(data);
    							p.teleport(l);
    							p.setLevel(40);
    							p.setHealth(20);
    							p.setFoodLevel(20);
    							d.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+p.getName()+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+d.getName());
    							if(plugin.getConfig().contains(d.getName())){
    								int pts = plugin.getConfig().getInt(d.getName());
    								plugin.getConfig().set(d.getName(),pts+100);
    								plugin.saveConfig();
    							}else{
    								plugin.getConfig().set(d.getName(),100);
    								plugin.saveConfig();
    							}
    							int kpoints = plugin.getConfig().getInt("bpoints5");
    							plugin.getConfig().set("bpoints5", kpoints+1);
							}
							
							if(plugin.getConfig().contains("bplist1."+p.getName())){
								
								Player[] online = Bukkit.getServer().getOnlinePlayers();
                                for(int i=0; i<online.length; i++){
                                        Player pl = online[i];
                                        if(plugin.getConfig().contains("rplist1."+pl.getName()) || plugin.getConfig().contains("bplist1."+pl.getName())){
                                                api.setScoreboard(pl);
                                                int sc = api.getScores(Bukkit.getOfflinePlayer(ChatColor.RED+"Red"));
                                                api.setScore(Bukkit.getOfflinePlayer(ChatColor.RED+"Red"), sc+1);
                                        }
                                }
								
								p.getInventory().setArmorContents(a.bluearmor);
								double x = plugin.getConfig().getDouble("bluespawn1.x");
								double y = plugin.getConfig().getDouble("bluespawn1.y");
								double z = plugin.getConfig().getDouble("bluespawn1.z");
    							Location l = new Location(w,x,y,z);
    							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
    							data.addEffects(FireworkEffect.builder().withColor(Color.BLUE).with(Type.BALL).build());
    							data.setPower(0);
    							firework.setFireworkMeta(data);
    							p.teleport(l);
    							p.setLevel(40);
    							p.setHealth(20);
    							p.setFoodLevel(20);
    							d.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+p.getName()+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+d.getName());
    							if(plugin.getConfig().contains(d.getName())){
    								int pts = plugin.getConfig().getInt(d.getName());
    								plugin.getConfig().set(d.getName(),pts+100);
    								plugin.saveConfig();
    							}else{
    								plugin.getConfig().set(d.getName(),100);
    								plugin.saveConfig();
    							}
    							int kpoints = plugin.getConfig().getInt("rpoints1");
    							plugin.getConfig().set("rpoints1", kpoints+1);
							}
							if(plugin.getConfig().contains("bplist2."+p.getName())){
								
								Player[] online = Bukkit.getServer().getOnlinePlayers();
                                for(int i=0; i<online.length; i++){
                                        Player pl = online[i];
                                        if(plugin.getConfig().contains("rplist2."+pl.getName()) || plugin.getConfig().contains("bplist2."+pl.getName())){
                                                api.setScoreboard(pl);
                                                int sc = api.getScores(Bukkit.getOfflinePlayer(ChatColor.RED+"Red"));
                                                api.setScore(Bukkit.getOfflinePlayer(ChatColor.RED+"Red"), sc+1);
                                        }
                                }
								
								p.getInventory().setArmorContents(a.bluearmor);
								double x = plugin.getConfig().getDouble("bluespawn2.x");
								double y = plugin.getConfig().getDouble("bluespawn2.y");
								double z = plugin.getConfig().getDouble("bluespawn2.z");
    							Location l = new Location(w,x,y,z);
    							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
    							data.addEffects(FireworkEffect.builder().withColor(Color.BLUE).with(Type.BALL).build());
    							data.setPower(0);
    							firework.setFireworkMeta(data);
    							p.teleport(l);
    							p.setLevel(40);
    							p.setHealth(20);
    							p.setFoodLevel(20);
    							d.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+p.getName()+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+d.getName());
    							if(plugin.getConfig().contains(d.getName())){
    								int pts = plugin.getConfig().getInt(d.getName());
    								plugin.getConfig().set(d.getName(),pts+100);
    								plugin.saveConfig();
    							}else{
    								plugin.getConfig().set(d.getName(),100);
    								plugin.saveConfig();
    							}
    							int kpoints = plugin.getConfig().getInt("rpoints2");
    							plugin.getConfig().set("rpoints2", kpoints+1);
							}
							if(plugin.getConfig().contains("bplist3."+p.getName())){
								
								Player[] online = Bukkit.getServer().getOnlinePlayers();
                                for(int i=0; i<online.length; i++){
                                        Player pl = online[i];
                                        if(plugin.getConfig().contains("rplist3."+pl.getName()) || plugin.getConfig().contains("bplist3."+pl.getName())){
                                                api.setScoreboard(pl);
                                                int sc = api.getScores(Bukkit.getOfflinePlayer(ChatColor.RED+"Red"));
                                                api.setScore(Bukkit.getOfflinePlayer(ChatColor.RED+"Red"), sc+1);
                                        }
                                }
								
								p.getInventory().setArmorContents(a.bluearmor);
								double x = plugin.getConfig().getDouble("bluespawn3.x");
								double y = plugin.getConfig().getDouble("bluespawn3.y");
								double z = plugin.getConfig().getDouble("bluespawn3.z");
    							Location l = new Location(w,x,y,z);
    							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
    							data.addEffects(FireworkEffect.builder().withColor(Color.BLUE).with(Type.BALL).build());
    							data.setPower(0);
    							firework.setFireworkMeta(data);
    							p.teleport(l);
    							p.setLevel(40);
    							p.setHealth(20);
    							p.setFoodLevel(20);
    							d.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+p.getName()+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+d.getName());
    							if(plugin.getConfig().contains(d.getName())){
    								int pts = plugin.getConfig().getInt(d.getName());
    								plugin.getConfig().set(d.getName(),pts+100);
    								plugin.saveConfig();
    							}else{
    								plugin.getConfig().set(d.getName(),100);
    								plugin.saveConfig();
    							}
    							int kpoints = plugin.getConfig().getInt("rpoints3");
    							plugin.getConfig().set("rpoints3", kpoints+1);
							}
							if(plugin.getConfig().contains("bplist4."+p.getName())){
								
								Player[] online = Bukkit.getServer().getOnlinePlayers();
                                for(int i=0; i<online.length; i++){
                                        Player pl = online[i];
                                        if(plugin.getConfig().contains("rplist4."+pl.getName()) || plugin.getConfig().contains("bplist4."+pl.getName())){
                                                api.setScoreboard(pl);
                                                int sc = api.getScores(Bukkit.getOfflinePlayer(ChatColor.RED+"Red"));
                                                api.setScore(Bukkit.getOfflinePlayer(ChatColor.RED+"Red"), sc+1);
                                        }
                                }
								
								p.getInventory().setArmorContents(a.bluearmor);
								double x = plugin.getConfig().getDouble("bluespawn4.x");
								double y = plugin.getConfig().getDouble("bluespawn4.y");
								double z = plugin.getConfig().getDouble("bluespawn4.z");
    							Location l = new Location(w,x,y,z);
    							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
    							data.addEffects(FireworkEffect.builder().withColor(Color.BLUE).with(Type.BALL).build());
    							data.setPower(0);
    							firework.setFireworkMeta(data);
    							p.teleport(l);
    							p.setLevel(40);
    							p.setHealth(20);
    							p.setFoodLevel(20);
    							d.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+p.getName()+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+d.getName());
    							if(plugin.getConfig().contains(d.getName())){
    								int pts = plugin.getConfig().getInt(d.getName());
    								plugin.getConfig().set(d.getName(),pts+100);
    								plugin.saveConfig();
    							}else{
    								plugin.getConfig().set(d.getName(),100);
    								plugin.saveConfig();
    							}
    							int kpoints = plugin.getConfig().getInt("rpoints4");
    							plugin.getConfig().set("rpoints4", kpoints+1);
							}
							if(plugin.getConfig().contains("bplist5."+p.getName())){
								
								Player[] online = Bukkit.getServer().getOnlinePlayers();
                                for(int i=0; i<online.length; i++){
                                        Player pl = online[i];
                                        if(plugin.getConfig().contains("rplist5."+pl.getName()) || plugin.getConfig().contains("bplist5."+pl.getName())){
                                                api.setScoreboard(pl);
                                                int sc = api.getScores(Bukkit.getOfflinePlayer(ChatColor.RED+"Red"));
                                                api.setScore(Bukkit.getOfflinePlayer(ChatColor.RED+"Red"), sc+1);
                                        }
                                }
								
								p.getInventory().setArmorContents(a.bluearmor);
								double x = plugin.getConfig().getDouble("bluespawn5.x");
								double y = plugin.getConfig().getDouble("bluespawn5.y");
								double z = plugin.getConfig().getDouble("bluespawn5.z");
    							Location l = new Location(w,x,y,z);
    							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
    							data.addEffects(FireworkEffect.builder().withColor(Color.BLUE).with(Type.BALL).build());
    							data.setPower(0);
    							firework.setFireworkMeta(data);
    							p.teleport(l);
    							p.setLevel(40);
    							p.setHealth(20);
    							p.setFoodLevel(20);
    							d.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+p.getName()+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+d.getName());
    							if(plugin.getConfig().contains(d.getName())){
    								int pts = plugin.getConfig().getInt(d.getName());
    								plugin.getConfig().set(d.getName(),pts+100);
    								plugin.saveConfig();
    							}else{
    								plugin.getConfig().set(d.getName(),100);
    								plugin.saveConfig();
    							}
    							int kpoints = plugin.getConfig().getInt("rpoints5");
    							plugin.getConfig().set("rpoints5", kpoints+1);
							}
						}
						}
					}else{
						e.setCancelled(true);
					}
				}
				
				
				//If sword fighting
				if(e.getDamager() instanceof Player){
					Player d = (Player)e.getDamager();
					
					if((plugin.getConfig().contains("bplist1."+p.getName()) && plugin.getConfig().contains("rplist1."+d.getName())) || (plugin.getConfig().contains("rplist1."+p.getName()) && plugin.getConfig().contains("bplist1."+d.getName())) || (plugin.getConfig().contains("bplist2."+p.getName()) && plugin.getConfig().contains("rplist2."+d.getName())) || (plugin.getConfig().contains("rplist2."+p.getName()) && plugin.getConfig().contains("bplist2."+d.getName())) || (plugin.getConfig().contains("bplist3."+p.getName()) && plugin.getConfig().contains("rplist3."+d.getName())) || (plugin.getConfig().contains("rplist3."+p.getName()) && plugin.getConfig().contains("bplist3."+d.getName())) || (plugin.getConfig().contains("bplist4."+p.getName()) && plugin.getConfig().contains("rplist4."+d.getName())) || (plugin.getConfig().contains("rplist4."+p.getName()) && plugin.getConfig().contains("bplist4."+d.getName())) || (plugin.getConfig().contains("bplist5."+p.getName()) && plugin.getConfig().contains("rplist5."+d.getName())) || (plugin.getConfig().contains("rplist5."+p.getName()) && plugin.getConfig().contains("bplist5."+d.getName())) ){
						if(d.getItemInHand().getType()==Material.DIAMOND_SWORD){
							Damageable dm = p;
							if(dm.getHealth() >= 5){
								e.setDamage(4d);
							}else{
								if(plugin.getConfig().contains("rplist1."+p.getName())){
									
									   if(plugin.getConfig().contains("rplist1."+p.getName())){
	                                       
	                                       Player[] online = Bukkit.getServer().getOnlinePlayers();
	                                       for(int i=0; i<online.length; i++){
	                                               Player pl = online[i];
	                                               if(plugin.getConfig().contains("rplist1."+pl.getName()) || plugin.getConfig().contains("bplist1."+pl.getName())){
	                                                       api.setScoreboard(pl);
	                                                       int sc = api.getScores(Bukkit.getOfflinePlayer(ChatColor.BLUE+"Blue"));
	                                                       api.setScore(Bukkit.getOfflinePlayer(ChatColor.BLUE+"Blue"), sc+1);
	                                               }
	                                       }
									
									p.getInventory().setArmorContents(a.redarmor);
									double x = plugin.getConfig().getDouble("redspawn1.x");
									double y = plugin.getConfig().getDouble("redspawn1.y");
									double z = plugin.getConfig().getDouble("redspawn1.z");
	    							Location l = new Location(w,x,y,z);
	    							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
	    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
	    							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
	    							data.setPower(0);
	    							firework.setFireworkMeta(data);
	    							p.teleport(l);
	    							p.setLevel(40);
	    							p.setHealth(20);
	    							p.setFoodLevel(20);
	    							d.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+p.getName()+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
	    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+d.getName());
	    							if(plugin.getConfig().contains(d.getName())){
	    								int pts = plugin.getConfig().getInt(d.getName());
	    								plugin.getConfig().set(d.getName(),pts+100);
	    								plugin.saveConfig();
	    							}else{
	    								plugin.getConfig().set(d.getName(),100);
	    								plugin.saveConfig();
	    							}
	    							int kpoints = plugin.getConfig().getInt("bpoints1");
	    							plugin.getConfig().set("bpoints1", kpoints+1);
								}
								if(plugin.getConfig().contains("rplist2."+p.getName())){
									
									Player[] online = Bukkit.getServer().getOnlinePlayers();
	                                for(int i=0; i<online.length; i++){
	                                        Player pl = online[i];
	                                        if(plugin.getConfig().contains("rplist2."+pl.getName()) || plugin.getConfig().contains("bplist2."+pl.getName())){
	                                                api.setScoreboard(pl);
	                                                int sc = api.getScores(Bukkit.getOfflinePlayer(ChatColor.BLUE+"Blue"));
	                                                api.setScore(Bukkit.getOfflinePlayer(ChatColor.BLUE+"Blue"), sc+1);
	                                        }
	                                }
									
									p.getInventory().setArmorContents(a.redarmor);
									double x = plugin.getConfig().getDouble("redspawn2.x");
									double y = plugin.getConfig().getDouble("redspawn2.y");
									double z = plugin.getConfig().getDouble("redspawn2.z");
	    							Location l = new Location(w,x,y,z);
	    							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
	    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
	    							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
	    							data.setPower(0);
	    							firework.setFireworkMeta(data);
	    							p.teleport(l);
	    							p.setLevel(40);
	    							p.setHealth(20);
	    							p.setFoodLevel(20);
	    							d.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+p.getName()+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
	    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+d.getName());
	    							if(plugin.getConfig().contains(d.getName())){
	    								int pts = plugin.getConfig().getInt(d.getName());
	    								plugin.getConfig().set(d.getName(),pts+100);
	    								plugin.saveConfig();
	    							}else{
	    								plugin.getConfig().set(d.getName(),100);
	    								plugin.saveConfig();
	    							}
	    							int kpoints = plugin.getConfig().getInt("bpoints2");
	    							plugin.getConfig().set("bpoints2", kpoints+1);
								}
								if(plugin.getConfig().contains("rplist3."+p.getName())){
									
									Player[] online = Bukkit.getServer().getOnlinePlayers();
	                                for(int i=0; i<online.length; i++){
	                                        Player pl = online[i];
	                                        if(plugin.getConfig().contains("rplist3."+pl.getName()) || plugin.getConfig().contains("bplist3."+pl.getName())){
	                                                api.setScoreboard(pl);
	                                                int sc = api.getScores(Bukkit.getOfflinePlayer(ChatColor.BLUE+"Blue"));
	                                                api.setScore(Bukkit.getOfflinePlayer(ChatColor.BLUE+"Blue"), sc+1);
	                                        }
	                                }
									
									p.getInventory().setArmorContents(a.redarmor);
									double x = plugin.getConfig().getDouble("redspawn3.x");
									double y = plugin.getConfig().getDouble("redspawn3.y");
									double z = plugin.getConfig().getDouble("redspawn3.z");
	    							Location l = new Location(w,x,y,z);
	    							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
	    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
	    							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
	    							data.setPower(0);
	    							firework.setFireworkMeta(data);
	    							p.teleport(l);
	    							p.setLevel(40);
	    							p.setHealth(20);
	    							p.setFoodLevel(20);
	    							d.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+p.getName()+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
	    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+d.getName());
	    							if(plugin.getConfig().contains(d.getName())){
	    								int pts = plugin.getConfig().getInt(d.getName());
	    								plugin.getConfig().set(d.getName(),pts+100);
	    								plugin.saveConfig();
	    							}else{
	    								plugin.getConfig().set(d.getName(),100);
	    								plugin.saveConfig();
	    							}
	    							int kpoints = plugin.getConfig().getInt("bpoints3");
	    							plugin.getConfig().set("bpoints3", kpoints+1);
								}
								if(plugin.getConfig().contains("rplist4."+p.getName())){
									
									Player[] online = Bukkit.getServer().getOnlinePlayers();
	                                for(int i=0; i<online.length; i++){
	                                        Player pl = online[i];
	                                        if(plugin.getConfig().contains("rplist4."+pl.getName()) || plugin.getConfig().contains("bplist4."+pl.getName())){
	                                                api.setScoreboard(pl);
	                                                int sc = api.getScores(Bukkit.getOfflinePlayer(ChatColor.BLUE+"Blue"));
	                                                api.setScore(Bukkit.getOfflinePlayer(ChatColor.BLUE+"Blue"), sc+1);
	                                        }
	                                }
									
									p.getInventory().setArmorContents(a.redarmor);
									double x = plugin.getConfig().getDouble("redspawn4.x");
									double y = plugin.getConfig().getDouble("redspawn4.y");
									double z = plugin.getConfig().getDouble("redspawn4.z");
	    							Location l = new Location(w,x,y,z);
	    							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
	    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
	    							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
	    							data.setPower(0);
	    							firework.setFireworkMeta(data);
	    							p.teleport(l);
	    							p.setLevel(40);
	    							p.setHealth(20);
	    							p.setFoodLevel(20);
	    							d.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+p.getName()+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
	    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+d.getName());
	    							if(plugin.getConfig().contains(d.getName())){
	    								int pts = plugin.getConfig().getInt(d.getName());
	    								plugin.getConfig().set(d.getName(),pts+100);
	    								plugin.saveConfig();
	    							}else{
	    								plugin.getConfig().set(d.getName(),100);
	    								plugin.saveConfig();
	    							}
	    							int kpoints = plugin.getConfig().getInt("bpoints4");
	    							plugin.getConfig().set("bpoints4", kpoints+1);
								}
								if(plugin.getConfig().contains("rplist5."+p.getName())){
									
									Player[] online = Bukkit.getServer().getOnlinePlayers();
	                                for(int i=0; i<online.length; i++){
	                                        Player pl = online[i];
	                                        if(plugin.getConfig().contains("rplist5."+pl.getName()) || plugin.getConfig().contains("bplist5."+pl.getName())){
	                                                api.setScoreboard(pl);
	                                                int sc = api.getScores(Bukkit.getOfflinePlayer(ChatColor.BLUE+"Blue"));
	                                                api.setScore(Bukkit.getOfflinePlayer(ChatColor.BLUE+"Blue"), sc+1);
	                                        }
	                                }
									
									p.getInventory().setArmorContents(a.redarmor);
									double x = plugin.getConfig().getDouble("redspawn5.x");
									double y = plugin.getConfig().getDouble("redspawn5.y");
									double z = plugin.getConfig().getDouble("redspawn5.z");
	    							Location l = new Location(w,x,y,z);
	    							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
	    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
	    							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
	    							data.setPower(0);
	    							firework.setFireworkMeta(data);
	    							p.teleport(l);
	    							p.setLevel(40);
	    							p.setHealth(20);
	    							p.setFoodLevel(20);
	    							d.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+p.getName()+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
	    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+d.getName());
	    							if(plugin.getConfig().contains(d.getName())){
	    								int pts = plugin.getConfig().getInt(d.getName());
	    								plugin.getConfig().set(d.getName(),pts+100);
	    								plugin.saveConfig();
	    							}else{
	    								plugin.getConfig().set(d.getName(),100);
	    								plugin.saveConfig();
	    							}
	    							int kpoints = plugin.getConfig().getInt("bpoints5");
	    							plugin.getConfig().set("bpoints5", kpoints+1);
								}
								
								if(plugin.getConfig().contains("bplist1."+p.getName())){
									
									Player[] online = Bukkit.getServer().getOnlinePlayers();
	                                for(int i=0; i<online.length; i++){
	                                        Player pl = online[i];
	                                        if(plugin.getConfig().contains("rplist1."+pl.getName()) || plugin.getConfig().contains("bplist1."+pl.getName())){
	                                                api.setScoreboard(pl);
	                                                int sc = api.getScores(Bukkit.getOfflinePlayer(ChatColor.RED+"Red"));
	                                                api.setScore(Bukkit.getOfflinePlayer(ChatColor.RED+"Red"), sc+1);
	                                        }
	                                }
									
									p.getInventory().setArmorContents(a.bluearmor);
									double x = plugin.getConfig().getDouble("bluespawn1.x");
									double y = plugin.getConfig().getDouble("bluespawn1.y");
									double z = plugin.getConfig().getDouble("bluespawn1.z");
	    							Location l = new Location(w,x,y,z);
	    							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
	    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
	    							data.addEffects(FireworkEffect.builder().withColor(Color.BLUE).with(Type.BALL).build());
	    							data.setPower(0);
	    							firework.setFireworkMeta(data);
	    							p.teleport(l);
	    							p.setLevel(40);
	    							p.setHealth(20);
	    							p.setFoodLevel(20);
	    							d.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+p.getName()+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
	    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+d.getName());
	    							if(plugin.getConfig().contains(d.getName())){
	    								int pts = plugin.getConfig().getInt(d.getName());
	    								plugin.getConfig().set(d.getName(),pts+100);
	    								plugin.saveConfig();
	    							}else{
	    								plugin.getConfig().set(d.getName(),100);
	    								plugin.saveConfig();
	    							}
	    							int kpoints = plugin.getConfig().getInt("rpoints1");
	    							plugin.getConfig().set("rpoints1", kpoints+1);
								}
								if(plugin.getConfig().contains("bplist2."+p.getName())){
									
									Player[] online = Bukkit.getServer().getOnlinePlayers();
	                                for(int i=0; i<online.length; i++){
	                                        Player pl = online[i];
	                                        if(plugin.getConfig().contains("rplist2."+pl.getName()) || plugin.getConfig().contains("bplist2."+pl.getName())){
	                                                api.setScoreboard(pl);
	                                                int sc = api.getScores(Bukkit.getOfflinePlayer(ChatColor.RED+"Red"));
	                                                api.setScore(Bukkit.getOfflinePlayer(ChatColor.RED+"Red"), sc+1);
	                                        }
	                                }
									
									p.getInventory().setArmorContents(a.bluearmor);
									double x = plugin.getConfig().getDouble("bluespawn2.x");
									double y = plugin.getConfig().getDouble("bluespawn2.y");
									double z = plugin.getConfig().getDouble("bluespawn2.z");
	    							Location l = new Location(w,x,y,z);
	    							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
	    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
	    							data.addEffects(FireworkEffect.builder().withColor(Color.BLUE).with(Type.BALL).build());
	    							data.setPower(0);
	    							firework.setFireworkMeta(data);
	    							p.teleport(l);
	    							p.setLevel(40);
	    							p.setHealth(20);
	    							p.setFoodLevel(20);
	    							d.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+p.getName()+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
	    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+d.getName());
	    							if(plugin.getConfig().contains(d.getName())){
	    								int pts = plugin.getConfig().getInt(d.getName());
	    								plugin.getConfig().set(d.getName(),pts+100);
	    								plugin.saveConfig();
	    							}else{
	    								plugin.getConfig().set(d.getName(),100);
	    								plugin.saveConfig();
	    							}
	    							int kpoints = plugin.getConfig().getInt("rpoints2");
	    							plugin.getConfig().set("rpoints2", kpoints+1);
								}
								if(plugin.getConfig().contains("bplist3."+p.getName())){
									
									Player[] online = Bukkit.getServer().getOnlinePlayers();
	                                for(int i=0; i<online.length; i++){
	                                        Player pl = online[i];
	                                        if(plugin.getConfig().contains("rplist3."+pl.getName()) || plugin.getConfig().contains("bplist3."+pl.getName())){
	                                                api.setScoreboard(pl);
	                                                int sc = api.getScores(Bukkit.getOfflinePlayer(ChatColor.RED+"Red"));
	                                                api.setScore(Bukkit.getOfflinePlayer(ChatColor.RED+"Red"), sc+1);
	                                        }
	                                }
									
									p.getInventory().setArmorContents(a.bluearmor);
									double x = plugin.getConfig().getDouble("bluespawn3.x");
									double y = plugin.getConfig().getDouble("bluespawn3.y");
									double z = plugin.getConfig().getDouble("bluespawn3.z");
	    							Location l = new Location(w,x,y,z);
	    							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
	    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
	    							data.addEffects(FireworkEffect.builder().withColor(Color.BLUE).with(Type.BALL).build());
	    							data.setPower(0);
	    							firework.setFireworkMeta(data);
	    							p.teleport(l);
	    							p.setLevel(40);
	    							p.setHealth(20);
	    							p.setFoodLevel(20);
	    							d.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+p.getName()+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
	    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+d.getName());
	    							if(plugin.getConfig().contains(d.getName())){
	    								int pts = plugin.getConfig().getInt(d.getName());
	    								plugin.getConfig().set(d.getName(),pts+100);
	    								plugin.saveConfig();
	    							}else{
	    								plugin.getConfig().set(d.getName(),100);
	    								plugin.saveConfig();
	    							}
	    							int kpoints = plugin.getConfig().getInt("rpoints3");
	    							plugin.getConfig().set("rpoints3", kpoints+1);
								}
								if(plugin.getConfig().contains("bplist4."+p.getName())){
									
									Player[] online = Bukkit.getServer().getOnlinePlayers();
	                                for(int i=0; i<online.length; i++){
	                                        Player pl = online[i];
	                                        if(plugin.getConfig().contains("rplist4."+pl.getName()) || plugin.getConfig().contains("bplist4."+pl.getName())){
	                                                api.setScoreboard(pl);
	                                                int sc = api.getScores(Bukkit.getOfflinePlayer(ChatColor.RED+"Red"));
	                                                api.setScore(Bukkit.getOfflinePlayer(ChatColor.RED+"Red"), sc+1);
	                                        }
	                                }
									
									p.getInventory().setArmorContents(a.bluearmor);
									double x = plugin.getConfig().getDouble("bluespawn4.x");
									double y = plugin.getConfig().getDouble("bluespawn4.y");
									double z = plugin.getConfig().getDouble("bluespawn4.z");
	    							Location l = new Location(w,x,y,z);
	    							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
	    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
	    							data.addEffects(FireworkEffect.builder().withColor(Color.BLUE).with(Type.BALL).build());
	    							data.setPower(0);
	    							firework.setFireworkMeta(data);
	    							p.teleport(l);
	    							p.setLevel(40);
	    							p.setHealth(20);
	    							p.setFoodLevel(20);
	    							d.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+p.getName()+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
	    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+d.getName());
	    							if(plugin.getConfig().contains(d.getName())){
	    								int pts = plugin.getConfig().getInt(d.getName());
	    								plugin.getConfig().set(d.getName(),pts+100);
	    								plugin.saveConfig();
	    							}else{
	    								plugin.getConfig().set(d.getName(),100);
	    								plugin.saveConfig();
	    							}
	    							int kpoints = plugin.getConfig().getInt("rpoints4");
	    							plugin.getConfig().set("rpoints4", kpoints+1);
								}
								if(plugin.getConfig().contains("bplist5."+p.getName())){
									
									Player[] online = Bukkit.getServer().getOnlinePlayers();
	                                for(int i=0; i<online.length; i++){
	                                        Player pl = online[i];
	                                        if(plugin.getConfig().contains("rplist5."+pl.getName()) || plugin.getConfig().contains("bplist5."+pl.getName())){
	                                                api.setScoreboard(pl);
	                                                int sc = api.getScores(Bukkit.getOfflinePlayer(ChatColor.RED+"Red"));
	                                                api.setScore(Bukkit.getOfflinePlayer(ChatColor.RED+"Red"), sc+1);
	                                        }
	                                }
									
									p.getInventory().setArmorContents(a.bluearmor);
									double x = plugin.getConfig().getDouble("bluespawn5.x");
									double y = plugin.getConfig().getDouble("bluespawn5.y");
									double z = plugin.getConfig().getDouble("bluespawn5.z");
	    							Location l = new Location(w,x,y,z);
	    							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
	    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
	    							data.addEffects(FireworkEffect.builder().withColor(Color.BLUE).with(Type.BALL).build());
	    							data.setPower(0);
	    							firework.setFireworkMeta(data);
	    							p.teleport(l);
	    							p.setLevel(40);
	    							p.setHealth(20);
	    							p.setFoodLevel(20);
	    							d.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+p.getName()+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
	    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+d.getName());
	    							if(plugin.getConfig().contains(d.getName())){
	    								int pts = plugin.getConfig().getInt(d.getName());
	    								plugin.getConfig().set(d.getName(),pts+100);
	    								plugin.saveConfig();
	    							}else{
	    								plugin.getConfig().set(d.getName(),100);
	    								plugin.saveConfig();
	    							}
	    							int kpoints = plugin.getConfig().getInt("rpoints5");
	    							plugin.getConfig().set("rpoints5", kpoints+1);
								}
							}
							}
						}else{
							d.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You must melee with your Diamond Sword!");
							e.setCancelled(true);
						}
					}else{
						e.setCancelled(true);
					}
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void otherDamage(EntityDamageEvent e){
		World w = e.getEntity().getWorld();
		if(e.getEntity() instanceof Player){
			Player p = (Player)e.getEntity();
			if(plugin.getConfig().contains("players1."+p.getName()) || plugin.getConfig().contains("players2."+p.getName()) || plugin.getConfig().contains("players3."+p.getName()) || plugin.getConfig().contains("players4."+p.getName()) || plugin.getConfig().contains("players5."+p.getName())){
				if(e.getCause().equals(DamageCause.VOID) || e.getCause().equals(DamageCause.LAVA) || e.getCause().equals(DamageCause.FIRE) || e.getCause().equals(DamageCause.FIRE_TICK) || e.getCause().equals(DamageCause.DROWNING) || e.getCause().equals(DamageCause.PROJECTILE)){
					Damageable dm = p;
					if(dm.getHealth() < 4d){
						if(plugin.getConfig().contains("rplist1."+p.getName())){
							p.getInventory().setArmorContents(a.bluearmor);
							double x = plugin.getConfig().getDouble("redspawn1.x");
							double y = plugin.getConfig().getDouble("redspawn1.y");
							double z = plugin.getConfig().getDouble("redspawn1.z");
							Location l = new Location(w,x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.YELLOW).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							p.setLevel(40);
							p.setHealth(20);
							p.setFoodLevel(20);
						}
						if(plugin.getConfig().contains("rplist2."+p.getName())){
							p.getInventory().setArmorContents(a.bluearmor);
							double x = plugin.getConfig().getDouble("redspawn2.x");
							double y = plugin.getConfig().getDouble("redspawn2.y");
							double z = plugin.getConfig().getDouble("redspawn2.z");
							Location l = new Location(w,x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.YELLOW).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							p.setLevel(40);
							p.setHealth(20);
							p.setFoodLevel(20);
						}
						if(plugin.getConfig().contains("rplist3."+p.getName())){
							p.getInventory().setArmorContents(a.bluearmor);
							double x = plugin.getConfig().getDouble("redspawn3.x");
							double y = plugin.getConfig().getDouble("redspawn3.y");
							double z = plugin.getConfig().getDouble("redspawn3.z");
							Location l = new Location(w,x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.YELLOW).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							p.setLevel(40);
							p.setHealth(20);
							p.setFoodLevel(20);
						}
						if(plugin.getConfig().contains("rplist4."+p.getName())){
							p.getInventory().setArmorContents(a.bluearmor);
							double x = plugin.getConfig().getDouble("redspawn4.x");
							double y = plugin.getConfig().getDouble("redspawn4.y");
							double z = plugin.getConfig().getDouble("redspawn4.z");
							Location l = new Location(w,x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.YELLOW).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							p.setLevel(40);
							p.setHealth(20);
							p.setFoodLevel(20);
						}
						if(plugin.getConfig().contains("rplist5."+p.getName())){
							p.getInventory().setArmorContents(a.bluearmor);
							double x = plugin.getConfig().getDouble("redspawn5.x");
							double y = plugin.getConfig().getDouble("redspawn5.y");
							double z = plugin.getConfig().getDouble("redspawn5.z");
							Location l = new Location(w,x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.YELLOW).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							p.setLevel(40);
							p.setHealth(20);
							p.setFoodLevel(20);
						}
						
						if(plugin.getConfig().contains("rplist1."+p.getName())){
							p.getInventory().setArmorContents(a.bluearmor);
							double x = plugin.getConfig().getDouble("bluespawn1.x");
							double y = plugin.getConfig().getDouble("bluespawn1.y");
							double z = plugin.getConfig().getDouble("bluespawn1.z");
							Location l = new Location(w,x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.YELLOW).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							p.setLevel(40);
							p.setHealth(20);
							p.setFoodLevel(20);
						}
						if(plugin.getConfig().contains("rplist2."+p.getName())){
							p.getInventory().setArmorContents(a.bluearmor);
							double x = plugin.getConfig().getDouble("bluespawn2.x");
							double y = plugin.getConfig().getDouble("bluespawn2.y");
							double z = plugin.getConfig().getDouble("bluespawn2.z");
							Location l = new Location(w,x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.YELLOW).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							p.setLevel(40);
							p.setHealth(20);
							p.setFoodLevel(20);
						}
						if(plugin.getConfig().contains("rplist3."+p.getName())){
							p.getInventory().setArmorContents(a.bluearmor);
							double x = plugin.getConfig().getDouble("bluespawn3.x");
							double y = plugin.getConfig().getDouble("bluespawn3.y");
							double z = plugin.getConfig().getDouble("bluespawn3.z");
							Location l = new Location(w,x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.YELLOW).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							p.setLevel(40);
							p.setHealth(20);
							p.setFoodLevel(20);
						}
						if(plugin.getConfig().contains("rplist4."+p.getName())){
							p.getInventory().setArmorContents(a.bluearmor);
							double x = plugin.getConfig().getDouble("bluespawn4.x");
							double y = plugin.getConfig().getDouble("bluespawn4.y");
							double z = plugin.getConfig().getDouble("bluespawn4.z");
							Location l = new Location(w,x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.YELLOW).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							p.setLevel(40);
							p.setHealth(20);
							p.setFoodLevel(20);
						}
						if(plugin.getConfig().contains("rplist5."+p.getName())){
							p.getInventory().setArmorContents(a.bluearmor);
							double x = plugin.getConfig().getDouble("bluespawn5.x");
							double y = plugin.getConfig().getDouble("bluespawn5.y");
							double z = plugin.getConfig().getDouble("bluespawn5.z");
							Location l = new Location(w,x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.YELLOW).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							p.setLevel(40);
							p.setHealth(20);
							p.setFoodLevel(20);
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void Dead(EntityDeathEvent event){
		if(event.getEntity() instanceof Player){
			Player p = (Player)event.getEntity();
			String name = p.getName();
			if(plugin.getConfig().contains("players1."+name) || plugin.getConfig().contains("players2."+name) || plugin.getConfig().contains("players3."+name) || plugin.getConfig().contains("players4."+name) || plugin.getConfig().contains("players5."+name)){
				event.setDroppedExp(0);
				event.getDrops().clear();
				plugin.getServer().broadcastMessage(ChatColor.RED+"Oops! Something glitched in Backbone's code!");
				Player guy = (Player)event.getEntity();
				guy.kickPlayer(ChatColor.DARK_PURPLE+"[Backbone]"+ChatColor.GOLD+"There was a serious error in Backbone! You were automatically removed from the game. Please login again and REJOIN your arena when possible.");
			}
		}

	}
}
