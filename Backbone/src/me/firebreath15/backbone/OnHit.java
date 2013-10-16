package me.firebreath15.backbone;

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
							e.setDamage(2);
						}else{
							for(int i=0; i<5; i++){
								
								//check if on red
								if(plugin.getConfig().contains("rplist"+i+"."+p.getName())){
									p.getInventory().setArmorContents(a.redarmor);
									double x = plugin.getConfig().getDouble("redspawn"+i+".x");
									double y = plugin.getConfig().getDouble("redspawn"+i+".y");
									double z = plugin.getConfig().getDouble("redspawn"+i+".z");
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
	    							int kpoints = plugin.getConfig().getInt("bpoints"+i);
	    							plugin.getConfig().set("bpoints"+i, kpoints+1);
								}
								
								//check if on blue
								if(plugin.getConfig().contains("bplist"+i+"."+p.getName())){
									p.getInventory().setArmorContents(a.bluearmor);
									double x = plugin.getConfig().getDouble("bluespawn"+i+".x");
									double y = plugin.getConfig().getDouble("bluespawn"+i+".y");
									double z = plugin.getConfig().getDouble("bluespawn"+i+".z");
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
	    							int kpoints = plugin.getConfig().getInt("rpoints"+i);
	    							plugin.getConfig().set("rpoints"+i, kpoints+1);
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
								e.setDamage(4);
							}else{
								for(int i=0; i<5; i++){
									
									//check if on red
									if(plugin.getConfig().contains("rplist"+i+"."+p.getName())){
										p.getInventory().setArmorContents(a.redarmor);
										double x = plugin.getConfig().getDouble("redspawn"+i+".x");
										double y = plugin.getConfig().getDouble("redspawn"+i+".y");
										double z = plugin.getConfig().getDouble("redspawn"+i+".z");
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
		    							int kpoints = plugin.getConfig().getInt("bpoints"+i);
		    							plugin.getConfig().set("bpoints"+i, kpoints+1);
									}
									
									//check if on blue
									if(plugin.getConfig().contains("bplist"+i+"."+p.getName())){
										p.getInventory().setArmorContents(a.bluearmor);
										double x = plugin.getConfig().getDouble("bluespawn"+i+".x");
										double y = plugin.getConfig().getDouble("bluespawn"+i+".y");
										double z = plugin.getConfig().getDouble("bluespawn"+i+".z");
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
		    							int kpoints = plugin.getConfig().getInt("rpoints"+i);
		    							plugin.getConfig().set("rpoints"+i, kpoints+1);
									}
								}
							}
						}else{
							d.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You must melee with your Diamond Sword!");
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
			for(int i=0; i<5; i++){
				if(plugin.getConfig().contains("players"+i+"."+p.getName())){
					DamageCause c = e.getCause();
					
					//falling
					if(c.equals(DamageCause.FALL)){
						Damageable dm = p;
						if(dm.getHealth() >= 3){
							e.setDamage(2);
						}else{
							//check if on red
							if(plugin.getConfig().contains("rplist"+i+"."+p.getName())){
								p.getInventory().setArmorContents(a.redarmor);
								double x = plugin.getConfig().getDouble("redspawn"+i+".x");
								double y = plugin.getConfig().getDouble("redspawn"+i+".y");
								double z = plugin.getConfig().getDouble("redspawn"+i+".z");
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
    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You fell to your doom!");
							}
							
							//check if on blue
							if(plugin.getConfig().contains("bplist"+i+"."+p.getName())){
								p.getInventory().setArmorContents(a.bluearmor);
								double x = plugin.getConfig().getDouble("bluespawn"+i+".x");
								double y = plugin.getConfig().getDouble("bluespawn"+i+".y");
								double z = plugin.getConfig().getDouble("bluespawn"+i+".z");
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
    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You fell to your doom!");
							}
						}
					}
					
					//falling
					if(c.equals(DamageCause.LAVA)){
						Damageable dm = p;
						if(dm.getHealth() >= 3){
							e.setDamage(2);
						}else{
							//check if on red
							if(plugin.getConfig().contains("rplist"+i+"."+p.getName())){
								p.getInventory().setArmorContents(a.redarmor);
								double x = plugin.getConfig().getDouble("redspawn"+i+".x");
								double y = plugin.getConfig().getDouble("redspawn"+i+".y");
								double z = plugin.getConfig().getDouble("redspawn"+i+".z");
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
    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You got torched in lava!");
							}
							
							//check if on blue
							if(plugin.getConfig().contains("bplist"+i+"."+p.getName())){
								p.getInventory().setArmorContents(a.bluearmor);
								double x = plugin.getConfig().getDouble("bluespawn"+i+".x");
								double y = plugin.getConfig().getDouble("bluespawn"+i+".y");
								double z = plugin.getConfig().getDouble("bluespawn"+i+".z");
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
    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You got torched in lava!");
							}
						}
					}
					
					//fire
					if(c.equals(DamageCause.FIRE)){
						Damageable dm = p;
						if(dm.getHealth() >= 3){
							e.setDamage(2);
						}else{
							//check if on red
							if(plugin.getConfig().contains("rplist"+i+"."+p.getName())){
								p.getInventory().setArmorContents(a.redarmor);
								double x = plugin.getConfig().getDouble("redspawn"+i+".x");
								double y = plugin.getConfig().getDouble("redspawn"+i+".y");
								double z = plugin.getConfig().getDouble("redspawn"+i+".z");
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
    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were cremated alive!");
							}
							
							//check if on blue
							if(plugin.getConfig().contains("bplist"+i+"."+p.getName())){
								p.getInventory().setArmorContents(a.bluearmor);
								double x = plugin.getConfig().getDouble("bluespawn"+i+".x");
								double y = plugin.getConfig().getDouble("bluespawn"+i+".y");
								double z = plugin.getConfig().getDouble("bluespawn"+i+".z");
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
    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were cremated alive!");
							}
						}
					}
					
					//fire
					if(c.equals(DamageCause.FIRE_TICK)){
						Damageable dm = p;
						if(dm.getHealth() >= 3){
							e.setDamage(2);
						}else{
							//check if on red
							if(plugin.getConfig().contains("rplist"+i+"."+p.getName())){
								p.getInventory().setArmorContents(a.redarmor);
								double x = plugin.getConfig().getDouble("redspawn"+i+".x");
								double y = plugin.getConfig().getDouble("redspawn"+i+".y");
								double z = plugin.getConfig().getDouble("redspawn"+i+".z");
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
    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were cremated alive!");
							}
							
							//check if on blue
							if(plugin.getConfig().contains("bplist"+i+"."+p.getName())){
								p.getInventory().setArmorContents(a.bluearmor);
								double x = plugin.getConfig().getDouble("bluespawn"+i+".x");
								double y = plugin.getConfig().getDouble("bluespawn"+i+".y");
								double z = plugin.getConfig().getDouble("bluespawn"+i+".z");
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
    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were cremated alive!");
							}
						}
					}
					
					//drowning
					if(c.equals(DamageCause.DROWNING)){
						Damageable dm = p;
						if(dm.getHealth() >= 3){
							e.setDamage(2);
						}else{
							//check if on red
							if(plugin.getConfig().contains("rplist"+i+"."+p.getName())){
								p.getInventory().setArmorContents(a.redarmor);
								double x = plugin.getConfig().getDouble("redspawn"+i+".x");
								double y = plugin.getConfig().getDouble("redspawn"+i+".y");
								double z = plugin.getConfig().getDouble("redspawn"+i+".z");
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
    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You ran out of air underwater!");
							}
							
							//check if on blue
							if(plugin.getConfig().contains("bplist"+i+"."+p.getName())){
								p.getInventory().setArmorContents(a.bluearmor);
								double x = plugin.getConfig().getDouble("bluespawn"+i+".x");
								double y = plugin.getConfig().getDouble("bluespawn"+i+".y");
								double z = plugin.getConfig().getDouble("bluespawn"+i+".z");
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
    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You ran out of air underwater!");
							}
						}
					}
					
					//void
					if(c.equals(DamageCause.VOID)){
						Damageable dm = p;
						if(dm.getHealth() >= 3){
							e.setDamage(2);
						}else{
							//check if on red
							if(plugin.getConfig().contains("rplist"+i+"."+p.getName())){
								p.getInventory().setArmorContents(a.redarmor);
								double x = plugin.getConfig().getDouble("redspawn"+i+".x");
								double y = plugin.getConfig().getDouble("redspawn"+i+".y");
								double z = plugin.getConfig().getDouble("redspawn"+i+".z");
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
    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You fell through the world!");
							}
							
							//check if on blue
							if(plugin.getConfig().contains("bplist"+i+"."+p.getName())){
								p.getInventory().setArmorContents(a.bluearmor);
								double x = plugin.getConfig().getDouble("bluespawn"+i+".x");
								double y = plugin.getConfig().getDouble("bluespawn"+i+".y");
								double z = plugin.getConfig().getDouble("bluespawn"+i+".z");
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
    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You fell through the world!");
							}
						}
					}
					
					//falling
					if(c.equals(DamageCause.PROJECTILE)){
						Damageable dm = p;
						if(dm.getHealth() >= 3){
							e.setDamage(2);
						}else{
							//check if on red
							if(plugin.getConfig().contains("rplist"+i+"."+p.getName())){
								p.getInventory().setArmorContents(a.redarmor);
								double x = plugin.getConfig().getDouble("redspawn"+i+".x");
								double y = plugin.getConfig().getDouble("redspawn"+i+".y");
								double z = plugin.getConfig().getDouble("redspawn"+i+".z");
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
    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were shot to death!");
							}
							
							//check if on blue
							if(plugin.getConfig().contains("bplist"+i+"."+p.getName())){
								p.getInventory().setArmorContents(a.bluearmor);
								double x = plugin.getConfig().getDouble("bluespawn"+i+".x");
								double y = plugin.getConfig().getDouble("bluespawn"+i+".y");
								double z = plugin.getConfig().getDouble("bluespawn"+i+".z");
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
    							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were shot to death!");
							}
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
