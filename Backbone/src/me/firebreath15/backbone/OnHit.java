package me.firebreath15.backbone;

import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class OnHit implements Listener{
	
main plugin;
    
    OnHit(main c) {
        plugin = c;
    }
    
    @SuppressWarnings("deprecation")
	@EventHandler
    public void onEnemyHit(EntityDamageByEntityEvent e){
    	Entity damager = e.getDamager();
    	Entity victim = e.getEntity();
    	World w = e.getEntity().getWorld();
    	if(victim instanceof Player && damager instanceof Snowball){
    		Player v = (Player)victim;
    		Snowball sb = (Snowball)damager;
    		Player k = (Player)sb.getShooter();
    		String kn = k.getName();
    		String vn = v.getName();
    		if(plugin.getConfig().contains("players1."+vn) || plugin.getConfig().contains("players2."+vn) || plugin.getConfig().contains("players3."+vn) || plugin.getConfig().contains("players4."+vn) || plugin.getConfig().contains("players5."+vn)){
    			if(plugin.getConfig().contains("rplist1."+vn) || plugin.getConfig().contains("rplist2."+vn) || plugin.getConfig().contains("rplist3."+vn) || plugin.getConfig().contains("rplist4."+vn) || plugin.getConfig().contains("rplist5."+vn)){
    				if(plugin.getConfig().contains("bplist1."+kn) || plugin.getConfig().contains("bplist2."+kn) || plugin.getConfig().contains("bplist3."+kn) || plugin.getConfig().contains("bplist4."+kn) || plugin.getConfig().contains("bplist5."+kn)){
    					//victim is on red and shooter is on blue
    					Damageable dv = v;
    					if(dv.getHealth() >= 3){
    						e.setDamage(2);
    					}else{
    						//if in arena 1
    						if(plugin.getConfig().contains("rplist1."+vn)){
    							double x = plugin.getConfig().getDouble("redspawn1.x");
    							double y = plugin.getConfig().getDouble("redspawn1.y");
    							double z = plugin.getConfig().getDouble("redspawn1.z");
    							Location l = new Location(w,x,y,z);
    							Firework firework = v.getWorld().spawn(v.getLocation(), Firework.class);
    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
    							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
    							data.setPower(0);
    							firework.setFireworkMeta(data);
    							v.teleport(l);
    							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
    							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
    							meta.setColor(Color.RED);
    							helm.setItemMeta(meta);
    							v.getInventory().setHelmet(helm);
    							//chestplate
    							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
    							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
    							metat.setColor(Color.RED);
    							ches.setItemMeta(metat);
    							v.getInventory().setChestplate(ches);
    							//leggings
    							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
    							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
    							metatt.setColor(Color.RED);
    							legg.setItemMeta(metatt);
    							v.getInventory().setLeggings(legg);
    							//boots
    							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
    							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
    							metattt.setColor(Color.RED);
    							boot.setItemMeta(metattt);
    							v.getInventory().setBoots(boot);
    							v.setLevel(40);
    							v.setHealth(20);
    							v.setFoodLevel(20);
    							k.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+vn+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
    							v.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+kn);
    							if(plugin.getConfig().contains(kn)){
    								int pts = plugin.getConfig().getInt(kn);
    								plugin.getConfig().set(kn,pts+100);
    								plugin.saveConfig();
    							}else{
    								plugin.getConfig().set(kn,100);
    								plugin.saveConfig();
    							}
    							int kpoints = plugin.getConfig().getInt("bpoints1");
    							plugin.getConfig().set("bpoints1", kpoints+1);
    						}//end of arena
    						//if in arena 2
    						if(plugin.getConfig().contains("rplist2."+vn)){
    							double x = plugin.getConfig().getDouble("redspawn2.x");
    							double y = plugin.getConfig().getDouble("redspawn2.y");
    							double z = plugin.getConfig().getDouble("redspawn2.z");
    							Location l = new Location(w,x,y,z);
    							Firework firework = v.getWorld().spawn(v.getLocation(), Firework.class);
    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
    							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
    							data.setPower(0);
    							firework.setFireworkMeta(data);
    							v.teleport(l);
    							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
    							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
    							meta.setColor(Color.RED);
    							helm.setItemMeta(meta);
    							v.getInventory().setHelmet(helm);
    							//chestplate
    							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
    							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
    							metat.setColor(Color.RED);
    							ches.setItemMeta(metat);
    							v.getInventory().setChestplate(ches);
    							//leggings
    							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
    							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
    							metatt.setColor(Color.RED);
    							legg.setItemMeta(metatt);
    							v.getInventory().setLeggings(legg);
    							//boots
    							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
    							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
    							metattt.setColor(Color.RED);
    							boot.setItemMeta(metattt);
    							v.getInventory().setBoots(boot);
    							v.setLevel(40);
    							v.setHealth(20);
    							v.setFoodLevel(20);
    							k.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+vn+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
    							v.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+kn);
    							if(plugin.getConfig().contains(kn)){
    								int pts = plugin.getConfig().getInt(kn);
    								plugin.getConfig().set(kn,pts+100);
    								plugin.saveConfig();
    							}else{
    								plugin.getConfig().set(kn,100);
    								plugin.saveConfig();
    							}
    							int kpoints = plugin.getConfig().getInt("bpoints2");
    							plugin.getConfig().set("bpoints2", kpoints+1);
    						}//end of arena
    						//if in arena 3
    						if(plugin.getConfig().contains("rplist3."+vn)){
    							double x = plugin.getConfig().getDouble("redspawn3.x");
    							double y = plugin.getConfig().getDouble("redspawn3.y");
    							double z = plugin.getConfig().getDouble("redspawn3.z");
    							Location l = new Location(w,x,y,z);
    							Firework firework = v.getWorld().spawn(v.getLocation(), Firework.class);
    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
    							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
    							data.setPower(0);
    							firework.setFireworkMeta(data);
    							v.teleport(l);
    							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
    							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
    							meta.setColor(Color.RED);
    							helm.setItemMeta(meta);
    							v.getInventory().setHelmet(helm);
    							//chestplate
    							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
    							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
    							metat.setColor(Color.RED);
    							ches.setItemMeta(metat);
    							v.getInventory().setChestplate(ches);
    							//leggings
    							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
    							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
    							metatt.setColor(Color.RED);
    							legg.setItemMeta(metatt);
    							v.getInventory().setLeggings(legg);
    							//boots
    							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
    							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
    							metattt.setColor(Color.RED);
    							boot.setItemMeta(metattt);
    							v.getInventory().setBoots(boot);
    							v.setLevel(40);
    							v.setHealth(20);
    							v.setFoodLevel(20);
    							k.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+vn+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
    							v.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+kn);
    							if(plugin.getConfig().contains(kn)){
    								int pts = plugin.getConfig().getInt(kn);
    								plugin.getConfig().set(kn,pts+100);
    								plugin.saveConfig();
    							}else{
    								plugin.getConfig().set(kn,100);
    								plugin.saveConfig();
    							}
    							int kpoints = plugin.getConfig().getInt("bpoints3");
    							plugin.getConfig().set("bpoints3", kpoints+1);
    						}//end of arena
    						//if in arena 4
    						if(plugin.getConfig().contains("rplist4."+vn)){
    							double x = plugin.getConfig().getDouble("redspawn4.x");
    							double y = plugin.getConfig().getDouble("redspawn4.y");
    							double z = plugin.getConfig().getDouble("redspawn4.z");
    							Location l = new Location(w,x,y,z);
    							Firework firework = v.getWorld().spawn(v.getLocation(), Firework.class);
    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
    							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
    							data.setPower(0);
    							firework.setFireworkMeta(data);
    							v.teleport(l);
    							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
    							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
    							meta.setColor(Color.RED);
    							helm.setItemMeta(meta);
    							v.getInventory().setHelmet(helm);
    							//chestplate
    							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
    							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
    							metat.setColor(Color.RED);
    							ches.setItemMeta(metat);
    							v.getInventory().setChestplate(ches);
    							//leggings
    							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
    							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
    							metatt.setColor(Color.RED);
    							legg.setItemMeta(metatt);
    							v.getInventory().setLeggings(legg);
    							//boots
    							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
    							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
    							metattt.setColor(Color.RED);
    							boot.setItemMeta(metattt);
    							v.getInventory().setBoots(boot);
    							v.setLevel(40);
    							v.setHealth(20);
    							v.setFoodLevel(20);
    							k.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+vn+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
    							v.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+kn);
    							if(plugin.getConfig().contains(kn)){
    								int pts = plugin.getConfig().getInt(kn);
    								plugin.getConfig().set(kn,pts+100);
    								plugin.saveConfig();
    							}else{
    								plugin.getConfig().set(kn,100);
    								plugin.saveConfig();
    							}
    							int kpoints = plugin.getConfig().getInt("bpoints4");
    							plugin.getConfig().set("bpoints4", kpoints+1);
    						}//end of arena
    						//if in arena 5
    						if(plugin.getConfig().contains("rplist5."+vn)){
    							double x = plugin.getConfig().getDouble("redspawn5.x");
    							double y = plugin.getConfig().getDouble("redspawn5.y");
    							double z = plugin.getConfig().getDouble("redspawn5.z");
    							Location l = new Location(w,x,y,z);
    							Firework firework = v.getWorld().spawn(v.getLocation(), Firework.class);
    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
    							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
    							data.setPower(0);
    							firework.setFireworkMeta(data);
    							v.teleport(l);
    							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
    							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
    							meta.setColor(Color.RED);
    							helm.setItemMeta(meta);
    							v.getInventory().setHelmet(helm);
    							//chestplate
    							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
    							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
    							metat.setColor(Color.RED);
    							ches.setItemMeta(metat);
    							v.getInventory().setChestplate(ches);
    							//leggings
    							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
    							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
    							metatt.setColor(Color.RED);
    							legg.setItemMeta(metatt);
    							v.getInventory().setLeggings(legg);
    							//boots
    							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
    							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
    							metattt.setColor(Color.RED);
    							boot.setItemMeta(metattt);
    							v.getInventory().setBoots(boot);
    							v.setLevel(40);
    							v.setHealth(20);
    							v.setFoodLevel(20);
    							k.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+vn+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
    							v.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+kn);
    							if(plugin.getConfig().contains(kn)){
    								int pts = plugin.getConfig().getInt(kn);
    								plugin.getConfig().set(kn,pts+100);
    								plugin.saveConfig();
    							}else{
    								plugin.getConfig().set(kn,100);
    								plugin.saveConfig();
    							}
    							int kpoints = plugin.getConfig().getInt("bpoints5");
    							plugin.getConfig().set("bpoints5", kpoints+1);
    						}//end of arena
    					}
    				}else{
    					e.setCancelled(true);
    					//cancel the pain because the snowball shooter is not an enemy player!
    				}
    			}
    			if(plugin.getConfig().contains("bplist1."+vn) || plugin.getConfig().contains("bplist2."+vn) || plugin.getConfig().contains("bplist3."+vn) || plugin.getConfig().contains("bplist4."+vn) || plugin.getConfig().contains("bplist5."+vn)){
    				if(plugin.getConfig().contains("rplist1."+kn) || plugin.getConfig().contains("rplist2."+kn) || plugin.getConfig().contains("rplist3."+kn) || plugin.getConfig().contains("rplist4."+kn) || plugin.getConfig().contains("rplist5."+kn)){
    					//victim is on blue and shooter is on red
    					Damageable dv = v;
    					if(dv.getHealth() >= 3){
    						e.setDamage(2);
    					}else{
    						//if in arena 1
    						if(plugin.getConfig().contains("bplist1."+vn)){
    							double x = plugin.getConfig().getDouble("bluespawn1.x");
    							double y = plugin.getConfig().getDouble("bluespawn1.y");
    							double z = plugin.getConfig().getDouble("bluespawn1.z");
    							Location l = new Location(w,x,y,z);
    							Firework firework = v.getWorld().spawn(v.getLocation(), Firework.class);
    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
    							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
    							data.setPower(0);
    							firework.setFireworkMeta(data);
    							v.teleport(l);
    							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
    							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
    							meta.setColor(Color.BLUE);
    							helm.setItemMeta(meta);
    							v.getInventory().setHelmet(helm);
    							//chestplate
    							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
    							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
    							metat.setColor(Color.BLUE);
    							ches.setItemMeta(metat);
    							v.getInventory().setChestplate(ches);
    							//leggings
    							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
    							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
    							metatt.setColor(Color.BLUE);
    							legg.setItemMeta(metatt);
    							v.getInventory().setLeggings(legg);
    							//boots
    							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
    							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
    							metattt.setColor(Color.BLUE);
    							boot.setItemMeta(metattt);
    							v.getInventory().setBoots(boot);
    							v.setLevel(40);
    							v.setHealth(20);
    							v.setFoodLevel(20);
    							k.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+vn+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
    							v.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+kn);
    							if(plugin.getConfig().contains(kn)){
    								int pts = plugin.getConfig().getInt(kn);
    								plugin.getConfig().set(kn,pts+100);
    								plugin.saveConfig();
    							}else{
    								plugin.getConfig().set(kn,100);
    								plugin.saveConfig();
    							}
    							int kpoints = plugin.getConfig().getInt("rpoints1");
    							plugin.getConfig().set("rpoints1", kpoints+1);
    						}//end of arena
    						//if in arena 2
    						if(plugin.getConfig().contains("bplist2."+vn)){
    							double x = plugin.getConfig().getDouble("bluespawn2.x");
    							double y = plugin.getConfig().getDouble("bluespawn2.y");
    							double z = plugin.getConfig().getDouble("bluespawn2.z");
    							Location l = new Location(w,x,y,z);
    							Firework firework = v.getWorld().spawn(v.getLocation(), Firework.class);
    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
    							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
    							data.setPower(0);
    							firework.setFireworkMeta(data);
    							v.teleport(l);
    							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
    							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
    							meta.setColor(Color.BLUE);
    							helm.setItemMeta(meta);
    							v.getInventory().setHelmet(helm);
    							//chestplate
    							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
    							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
    							metat.setColor(Color.BLUE);
    							ches.setItemMeta(metat);
    							v.getInventory().setChestplate(ches);
    							//leggings
    							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
    							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
    							metatt.setColor(Color.BLUE);
    							legg.setItemMeta(metatt);
    							v.getInventory().setLeggings(legg);
    							//boots
    							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
    							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
    							metattt.setColor(Color.BLUE);
    							boot.setItemMeta(metattt);
    							v.getInventory().setBoots(boot);
    							v.setLevel(40);
    							v.setHealth(20);
    							v.setFoodLevel(20);
    							k.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+vn+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
    							v.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+kn);
    							if(plugin.getConfig().contains(kn)){
    								int pts = plugin.getConfig().getInt(kn);
    								plugin.getConfig().set(kn,pts+100);
    								plugin.saveConfig();
    							}else{
    								plugin.getConfig().set(kn,100);
    								plugin.saveConfig();
    							}
    							int kpoints = plugin.getConfig().getInt("rpoints2");
    							plugin.getConfig().set("rpoints2", kpoints+1);
    						}//end of arena
    						//if in arena 3
    						if(plugin.getConfig().contains("bplist3."+vn)){
    							double x = plugin.getConfig().getDouble("bluespawn3.x");
    							double y = plugin.getConfig().getDouble("bluespawn3.y");
    							double z = plugin.getConfig().getDouble("bluespawn3.z");
    							Location l = new Location(w,x,y,z);
    							Firework firework = v.getWorld().spawn(v.getLocation(), Firework.class);
    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
    							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
    							data.setPower(0);
    							firework.setFireworkMeta(data);
    							v.teleport(l);
    							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
    							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
    							meta.setColor(Color.BLUE);
    							helm.setItemMeta(meta);
    							v.getInventory().setHelmet(helm);
    							//chestplate
    							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
    							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
    							metat.setColor(Color.BLUE);
    							ches.setItemMeta(metat);
    							v.getInventory().setChestplate(ches);
    							//leggings
    							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
    							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
    							metatt.setColor(Color.BLUE);
    							legg.setItemMeta(metatt);
    							v.getInventory().setLeggings(legg);
    							//boots
    							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
    							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
    							metattt.setColor(Color.BLUE);
    							boot.setItemMeta(metattt);
    							v.getInventory().setBoots(boot);
    							v.setLevel(40);
    							v.setHealth(20);
    							v.setFoodLevel(20);
    							k.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+vn+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
    							v.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+kn);
    							if(plugin.getConfig().contains(kn)){
    								int pts = plugin.getConfig().getInt(kn);
    								plugin.getConfig().set(kn,pts+100);
    								plugin.saveConfig();
    							}else{
    								plugin.getConfig().set(kn,100);
    								plugin.saveConfig();
    							}
    							int kpoints = plugin.getConfig().getInt("rpoints3");
    							plugin.getConfig().set("rpoints3", kpoints+1);
    						}//end of arena
    						//if in arena 4
    						if(plugin.getConfig().contains("bplist4."+vn)){
    							double x = plugin.getConfig().getDouble("bluespawn4.x");
    							double y = plugin.getConfig().getDouble("bluespawn4.y");
    							double z = plugin.getConfig().getDouble("bluespawn4.z");
    							Location l = new Location(w,x,y,z);
    							Firework firework = v.getWorld().spawn(v.getLocation(), Firework.class);
    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
    							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
    							data.setPower(0);
    							firework.setFireworkMeta(data);
    							v.teleport(l);
    							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
    							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
    							meta.setColor(Color.BLUE);
    							helm.setItemMeta(meta);
    							v.getInventory().setHelmet(helm);
    							//chestplate
    							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
    							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
    							metat.setColor(Color.BLUE);
    							ches.setItemMeta(metat);
    							v.getInventory().setChestplate(ches);
    							//leggings
    							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
    							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
    							metatt.setColor(Color.BLUE);
    							legg.setItemMeta(metatt);
    							v.getInventory().setLeggings(legg);
    							//boots
    							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
    							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
    							metattt.setColor(Color.BLUE);
    							boot.setItemMeta(metattt);
    							v.getInventory().setBoots(boot);
    							v.setLevel(40);
    							v.setHealth(20);
    							v.setFoodLevel(20);
    							k.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+vn+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
    							v.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+kn);
    							if(plugin.getConfig().contains(kn)){
    								int pts = plugin.getConfig().getInt(kn);
    								plugin.getConfig().set(kn,pts+100);
    								plugin.saveConfig();
    							}else{
    								plugin.getConfig().set(kn,100);
    								plugin.saveConfig();
    							}
    							int kpoints = plugin.getConfig().getInt("rpoints4");
    							plugin.getConfig().set("rpoints4", kpoints+1);
    						}//end of arena
    						//if in arena 5
    						if(plugin.getConfig().contains("bplist5."+vn)){
    							double x = plugin.getConfig().getDouble("bluespawn5.x");
    							double y = plugin.getConfig().getDouble("bluespawn5.y");
    							double z = plugin.getConfig().getDouble("bluespawn5.z");
    							Location l = new Location(w,x,y,z);
    							Firework firework = v.getWorld().spawn(v.getLocation(), Firework.class);
    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
    							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
    							data.setPower(0);
    							firework.setFireworkMeta(data);
    							v.teleport(l);
    							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
    							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
    							meta.setColor(Color.BLUE);
    							helm.setItemMeta(meta);
    							v.getInventory().setHelmet(helm);
    							//chestplate
    							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
    							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
    							metat.setColor(Color.BLUE);
    							ches.setItemMeta(metat);
    							v.getInventory().setChestplate(ches);
    							//leggings
    							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
    							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
    							metatt.setColor(Color.BLUE);
    							legg.setItemMeta(metatt);
    							v.getInventory().setLeggings(legg);
    							//boots
    							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
    							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
    							metattt.setColor(Color.BLUE);
    							boot.setItemMeta(metattt);
    							v.getInventory().setBoots(boot);
    							v.setLevel(40);
    							v.setHealth(20);
    							v.setFoodLevel(20);
    							k.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+vn+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
    							v.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+kn);
    							if(plugin.getConfig().contains(kn)){
    								int pts = plugin.getConfig().getInt(kn);
    								plugin.getConfig().set(kn,pts+100);
    								plugin.saveConfig();
    							}else{
    								plugin.getConfig().set(kn,100);
    								plugin.saveConfig();
    							}
    							int kpoints = plugin.getConfig().getInt("rpoints5");
    							plugin.getConfig().set("rpoints5", kpoints+1);
    						}//end of arena
    					}
    				}else{
    					e.setCancelled(true);
    					//cancel because the snowball shooter is not an enemy player!
    				}
    			}
    		}//victim not playing
    	}//not a player victim or not a snowball damager
    }//end of onEnemyHit
    
    @SuppressWarnings("deprecation")
	@EventHandler
    public void swordFight(EntityDamageByEntityEvent e){
    	Entity damager = e.getDamager();
    	Entity victim = e.getEntity();
    	World w = e.getEntity().getWorld();
    	if(damager instanceof Player && victim instanceof Player){
    		Player k = (Player)damager;
    		Player v = (Player)victim;
    		String kn = k.getName();
    		String vn = v.getName();
    		if(plugin.getConfig().contains("players1."+vn) || plugin.getConfig().contains("players2."+vn) || plugin.getConfig().contains("players3."+vn) || plugin.getConfig().contains("players4."+vn) || plugin.getConfig().contains("players5."+vn)){
    			if(plugin.getConfig().contains("rplist1."+vn) || plugin.getConfig().contains("rplist2."+vn) || plugin.getConfig().contains("rplist3."+vn) || plugin.getConfig().contains("rplist4."+vn) || plugin.getConfig().contains("rplist5."+vn)){
    				if(plugin.getConfig().contains("bplist1."+kn) || plugin.getConfig().contains("bplist2."+kn) || plugin.getConfig().contains("bplist3."+kn) || plugin.getConfig().contains("bplist4."+kn) || plugin.getConfig().contains("bplist5."+kn)){
    					//player is on red, enemy on blue
    					//victim is on red and slasher is on blue
    					Damageable dv = v;
    					
    					if(dv.getHealth() >= 5){
    						e.setDamage(4);
    					}else{
    						//if in arena 1
    						if(plugin.getConfig().contains("rplist1."+vn)){
    							double x = plugin.getConfig().getDouble("redspawn1.x");
    							double y = plugin.getConfig().getDouble("redspawn1.y");
    							double z = plugin.getConfig().getDouble("redspawn1.z");
    							Location l = new Location(w,x,y,z);
    							Firework firework = v.getWorld().spawn(v.getLocation(), Firework.class);
    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
    							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
    							data.setPower(0);
    							firework.setFireworkMeta(data);
    							v.teleport(l);
    							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
    							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
    							meta.setColor(Color.RED);
    							helm.setItemMeta(meta);
    							v.getInventory().setHelmet(helm);
    							//chestplate
    							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
    							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
    							metat.setColor(Color.RED);
    							ches.setItemMeta(metat);
    							v.getInventory().setChestplate(ches);
    							//leggings
    							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
    							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
    							metatt.setColor(Color.RED);
    							legg.setItemMeta(metatt);
    							v.getInventory().setLeggings(legg);
    							//boots
    							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
    							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
    							metattt.setColor(Color.RED);
    							boot.setItemMeta(metattt);
    							v.getInventory().setBoots(boot);
    							v.setLevel(40);
    							v.setHealth(20);
    							v.setFoodLevel(20);
    							k.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+vn+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
    							v.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+kn);
    							if(plugin.getConfig().contains(kn)){
    								int pts = plugin.getConfig().getInt(kn);
    								plugin.getConfig().set(kn,pts+100);
    								plugin.saveConfig();
    							}else{
    								plugin.getConfig().set(kn,100);
    								plugin.saveConfig();
    							}
    							int kpoints = plugin.getConfig().getInt("bpoints1");
    							plugin.getConfig().set("bpoints1", kpoints+1);
    						}//end of arena
    						//if in arena 2
    						if(plugin.getConfig().contains("rplist2."+vn)){
    							double x = plugin.getConfig().getDouble("redspawn2.x");
    							double y = plugin.getConfig().getDouble("redspawn2.y");
    							double z = plugin.getConfig().getDouble("redspawn2.z");
    							Location l = new Location(w,x,y,z);
    							Firework firework = v.getWorld().spawn(v.getLocation(), Firework.class);
    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
    							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
    							data.setPower(0);
    							firework.setFireworkMeta(data);
    							v.teleport(l);
    							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
    							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
    							meta.setColor(Color.RED);
    							helm.setItemMeta(meta);
    							v.getInventory().setHelmet(helm);
    							//chestplate
    							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
    							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
    							metat.setColor(Color.RED);
    							ches.setItemMeta(metat);
    							v.getInventory().setChestplate(ches);
    							//leggings
    							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
    							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
    							metatt.setColor(Color.RED);
    							legg.setItemMeta(metatt);
    							v.getInventory().setLeggings(legg);
    							//boots
    							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
    							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
    							metattt.setColor(Color.RED);
    							boot.setItemMeta(metattt);
    							v.getInventory().setBoots(boot);
    							v.setLevel(40);
    							v.setHealth(20);
    							v.setFoodLevel(20);
    							k.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+vn+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
    							v.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+kn);
    							if(plugin.getConfig().contains(kn)){
    								int pts = plugin.getConfig().getInt(kn);
    								plugin.getConfig().set(kn,pts+100);
    								plugin.saveConfig();
    							}else{
    								plugin.getConfig().set(kn,100);
    								plugin.saveConfig();
    							}
    							int kpoints = plugin.getConfig().getInt("bpoints2");
    							plugin.getConfig().set("bpoints2", kpoints+1);
    						}//end of arena
    						//if in arena 3
    						if(plugin.getConfig().contains("rplist3."+vn)){
    							double x = plugin.getConfig().getDouble("redspawn3.x");
    							double y = plugin.getConfig().getDouble("redspawn3.y");
    							double z = plugin.getConfig().getDouble("redspawn3.z");
    							Location l = new Location(w,x,y,z);
    							Firework firework = v.getWorld().spawn(v.getLocation(), Firework.class);
    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
    							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
    							data.setPower(0);
    							firework.setFireworkMeta(data);
    							v.teleport(l);
    							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
    							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
    							meta.setColor(Color.RED);
    							helm.setItemMeta(meta);
    							v.getInventory().setHelmet(helm);
    							//chestplate
    							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
    							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
    							metat.setColor(Color.RED);
    							ches.setItemMeta(metat);
    							v.getInventory().setChestplate(ches);
    							//leggings
    							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
    							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
    							metatt.setColor(Color.RED);
    							legg.setItemMeta(metatt);
    							v.getInventory().setLeggings(legg);
    							//boots
    							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
    							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
    							metattt.setColor(Color.RED);
    							boot.setItemMeta(metattt);
    							v.getInventory().setBoots(boot);
    							v.setLevel(40);
    							v.setHealth(20);
    							v.setFoodLevel(20);
    							k.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+vn+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
    							v.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+kn);
    							if(plugin.getConfig().contains(kn)){
    								int pts = plugin.getConfig().getInt(kn);
    								plugin.getConfig().set(kn,pts+100);
    								plugin.saveConfig();
    							}else{
    								plugin.getConfig().set(kn,100);
    								plugin.saveConfig();
    							}
    							int kpoints = plugin.getConfig().getInt("bpoints3");
    							plugin.getConfig().set("bpoints3", kpoints+1);
    						}//end of arena
    						//if in arena 4
    						if(plugin.getConfig().contains("rplist4."+vn)){
    							double x = plugin.getConfig().getDouble("redspawn4.x");
    							double y = plugin.getConfig().getDouble("redspawn4.y");
    							double z = plugin.getConfig().getDouble("redspawn4.z");
    							Location l = new Location(w,x,y,z);
    							Firework firework = v.getWorld().spawn(v.getLocation(), Firework.class);
    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
    							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
    							data.setPower(0);
    							firework.setFireworkMeta(data);
    							v.teleport(l);
    							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
    							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
    							meta.setColor(Color.RED);
    							helm.setItemMeta(meta);
    							v.getInventory().setHelmet(helm);
    							//chestplate
    							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
    							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
    							metat.setColor(Color.RED);
    							ches.setItemMeta(metat);
    							v.getInventory().setChestplate(ches);
    							//leggings
    							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
    							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
    							metatt.setColor(Color.RED);
    							legg.setItemMeta(metatt);
    							v.getInventory().setLeggings(legg);
    							//boots
    							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
    							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
    							metattt.setColor(Color.RED);
    							boot.setItemMeta(metattt);
    							v.getInventory().setBoots(boot);
    							v.setLevel(40);
    							v.setHealth(20);
    							v.setFoodLevel(20);
    							k.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+vn+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
    							v.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+kn);
    							if(plugin.getConfig().contains(kn)){
    								int pts = plugin.getConfig().getInt(kn);
    								plugin.getConfig().set(kn,pts+100);
    								plugin.saveConfig();
    							}else{
    								plugin.getConfig().set(kn,100);
    								plugin.saveConfig();
    							}
    							int kpoints = plugin.getConfig().getInt("bpoints4");
    							plugin.getConfig().set("bpoints4", kpoints+1);
    						}//end of arena
    						//if in arena 5
    						if(plugin.getConfig().contains("rplist5."+vn)){
    							double x = plugin.getConfig().getDouble("redspawn5.x");
    							double y = plugin.getConfig().getDouble("redspawn5.y");
    							double z = plugin.getConfig().getDouble("redspawn5.z");
    							Location l = new Location(w,x,y,z);
    							Firework firework = v.getWorld().spawn(v.getLocation(), Firework.class);
    							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
    							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
    							data.setPower(0);
    							firework.setFireworkMeta(data);
    							v.teleport(l);
    							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
    							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
    							meta.setColor(Color.RED);
    							helm.setItemMeta(meta);
    							v.getInventory().setHelmet(helm);
    							//chestplate
    							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
    							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
    							metat.setColor(Color.RED);
    							ches.setItemMeta(metat);
    							v.getInventory().setChestplate(ches);
    							//leggings
    							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
    							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
    							metatt.setColor(Color.RED);
    							legg.setItemMeta(metatt);
    							v.getInventory().setLeggings(legg);
    							//boots
    							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
    							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
    							metattt.setColor(Color.RED);
    							boot.setItemMeta(metattt);
    							v.getInventory().setBoots(boot);
    							v.setLevel(40);
    							v.setHealth(20);
    							v.setFoodLevel(20);
    							k.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+vn+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
    							v.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+kn);
    							if(plugin.getConfig().contains(kn)){
    								int pts = plugin.getConfig().getInt(kn);
    								plugin.getConfig().set(kn,pts+100);
    								plugin.saveConfig();
    							}else{
    								plugin.getConfig().set(kn,100);
    								plugin.saveConfig();
    							}
    							int kpoints = plugin.getConfig().getInt("bpoints5");
    							plugin.getConfig().set("bpoints5", kpoints+1);
    						}//end of arena
    					}
    				}else{
    					e.setCancelled(true);
    					//killer isnt an enemy, so ignore his strikes.
    				}
    			}
    		}
    		if(plugin.getConfig().contains("bplist1."+vn) || plugin.getConfig().contains("bplist2."+vn) || plugin.getConfig().contains("bplist3."+vn) || plugin.getConfig().contains("bplist4."+vn) || plugin.getConfig().contains("bplist5."+vn)){
				if(plugin.getConfig().contains("rplist1."+kn) || plugin.getConfig().contains("rplist2."+kn) || plugin.getConfig().contains("rplist3."+kn) || plugin.getConfig().contains("rplist4."+kn) || plugin.getConfig().contains("rplist5."+kn)){
					//victim is on blue and slasher is on red
					Damageable dv = v;
					if(dv.getHealth() >= 5){
						e.setDamage(4);
					}else{
						//if in arena 1
						if(plugin.getConfig().contains("bplist1."+vn)){
							double x = plugin.getConfig().getDouble("bluespawn1.x");
							double y = plugin.getConfig().getDouble("bluespawn1.y");
							double z = plugin.getConfig().getDouble("bluespawn1.z");
							Location l = new Location(w,x,y,z);
							Firework firework = v.getWorld().spawn(v.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							v.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							v.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							v.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							v.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							v.getInventory().setBoots(boot);
							v.setLevel(40);
							v.setHealth(20);
							v.setFoodLevel(20);
							k.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+vn+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
							v.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+kn);
							if(plugin.getConfig().contains(kn)){
								int pts = plugin.getConfig().getInt(kn);
								plugin.getConfig().set(kn,pts+100);
								plugin.saveConfig();
							}else{
								plugin.getConfig().set(kn,100);
								plugin.saveConfig();
							}
							int kpoints = plugin.getConfig().getInt("rpoints1");
							plugin.getConfig().set("rpoints1", kpoints+1);
						}//end of arena
						//if in arena 2
						if(plugin.getConfig().contains("bplist2."+vn)){
							double x = plugin.getConfig().getDouble("bluespawn2.x");
							double y = plugin.getConfig().getDouble("bluespawn2.y");
							double z = plugin.getConfig().getDouble("bluespawn2.z");
							Location l = new Location(w,x,y,z);
							Firework firework = v.getWorld().spawn(v.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							v.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							v.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							v.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							v.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							v.getInventory().setBoots(boot);
							v.setLevel(40);
							v.setHealth(20);
							v.setFoodLevel(20);
							k.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+vn+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
							v.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+kn);
							if(plugin.getConfig().contains(kn)){
								int pts = plugin.getConfig().getInt(kn);
								plugin.getConfig().set(kn,pts+100);
								plugin.saveConfig();
							}else{
								plugin.getConfig().set(kn,100);
								plugin.saveConfig();
							}
							int kpoints = plugin.getConfig().getInt("rpoints2");
							plugin.getConfig().set("rpoints2", kpoints+1);
						}//end of arena
						//if in arena 3
						if(plugin.getConfig().contains("bplist3."+vn)){
							double x = plugin.getConfig().getDouble("bluespawn3.x");
							double y = plugin.getConfig().getDouble("bluespawn3.y");
							double z = plugin.getConfig().getDouble("bluespawn3.z");
							Location l = new Location(w,x,y,z);
							Firework firework = v.getWorld().spawn(v.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							v.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							v.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							v.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							v.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							v.getInventory().setBoots(boot);
							v.setLevel(40);
							v.setHealth(20);
							v.setFoodLevel(20);
							k.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+vn+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
							v.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+kn);
							if(plugin.getConfig().contains(kn)){
								int pts = plugin.getConfig().getInt(kn);
								plugin.getConfig().set(kn,pts+100);
								plugin.saveConfig();
							}else{
								plugin.getConfig().set(kn,100);
								plugin.saveConfig();
							}
							int kpoints = plugin.getConfig().getInt("rpoints3");
							plugin.getConfig().set("rpoints3", kpoints+1);
						}//end of arena
						//if in arena 4
						if(plugin.getConfig().contains("bplist4."+vn)){
							double x = plugin.getConfig().getDouble("bluespawn4.x");
							double y = plugin.getConfig().getDouble("bluespawn4.y");
							double z = plugin.getConfig().getDouble("bluespawn4.z");
							Location l = new Location(w,x,y,z);
							Firework firework = v.getWorld().spawn(v.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							v.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							v.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							v.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							v.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							v.getInventory().setBoots(boot);
							v.setLevel(40);
							v.setHealth(20);
							v.setFoodLevel(20);
							k.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+vn+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
							v.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+kn);
							if(plugin.getConfig().contains(kn)){
								int pts = plugin.getConfig().getInt(kn);
								plugin.getConfig().set(kn,pts+100);
								plugin.saveConfig();
							}else{
								plugin.getConfig().set(kn,100);
								plugin.saveConfig();
							}
							int kpoints = plugin.getConfig().getInt("rpoints4");
							plugin.getConfig().set("rpoints4", kpoints+1);
						}//end of arena
						//if in arena 5
						if(plugin.getConfig().contains("bplist5."+vn)){
							double x = plugin.getConfig().getDouble("bluespawn5.x");
							double y = plugin.getConfig().getDouble("bluespawn5.y");
							double z = plugin.getConfig().getDouble("bluespawn5.z");
							Location l = new Location(w,x,y,z);
							Firework firework = v.getWorld().spawn(v.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							v.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							v.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							v.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							v.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							v.getInventory().setBoots(boot);
							v.setLevel(40);
							v.setHealth(20);
							v.setFoodLevel(20);
							k.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You killed "+ChatColor.RED+vn+ChatColor.GOLD+"! "+ChatColor.DARK_PURPLE+"+100");
							v.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were killed by "+ChatColor.RED+kn);
							if(plugin.getConfig().contains(kn)){
								int pts = plugin.getConfig().getInt(kn);
								plugin.getConfig().set(kn,pts+100);
								plugin.saveConfig();
							}else{
								plugin.getConfig().set(kn,100);
								plugin.saveConfig();
							}
							int kpoints = plugin.getConfig().getInt("rpoints5");
							plugin.getConfig().set("rpoints5", kpoints+1);
						}//end of arena
					} 		
    	}else{
    		e.setCancelled(true);
    	}
    		}
    	}//damager
    }//end of sword fight
    
	@SuppressWarnings("deprecation")
	@EventHandler
	public void otherDamage(EntityDamageEvent event){
		if(event.getEntity() instanceof Player){
			Player p = (Player)event.getEntity();
			String name = p.getName();
			if(plugin.getConfig().contains("players1."+name) || plugin.getConfig().contains("players2."+name) || plugin.getConfig().contains("players3."+name) || plugin.getConfig().contains("players4."+name) || plugin.getConfig().contains("players5."+name)){
				if(event.getCause().equals(DamageCause.FALL)){
					Damageable d = p;
					if(d.getHealth()>=3){
						event.setDamage(2);
					}else{
						if(plugin.getConfig().contains("bplist1."+name)){
							double x = plugin.getConfig().getDouble("bluespawn1.x");
							double y = plugin.getConfig().getDouble("bluespawn1.y");
							double z = plugin.getConfig().getDouble("bluespawn1.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You fell to your doom!");
						}//end of arena
						if(plugin.getConfig().contains("bplist2."+name)){
							double x = plugin.getConfig().getDouble("bluespawn2.x");
							double y = plugin.getConfig().getDouble("bluespawn2.y");
							double z = plugin.getConfig().getDouble("bluespawn2.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You fell to your doom!");
						}//end of arena
						if(plugin.getConfig().contains("bplist3."+name)){
							double x = plugin.getConfig().getDouble("bluespawn3.x");
							double y = plugin.getConfig().getDouble("bluespawn3.y");
							double z = plugin.getConfig().getDouble("bluespawn3.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You fell to your doom!");
						}//end of arena
						if(plugin.getConfig().contains("bplist4."+name)){
							double x = plugin.getConfig().getDouble("bluespawn4.x");
							double y = plugin.getConfig().getDouble("bluespawn4.y");
							double z = plugin.getConfig().getDouble("bluespawn4.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You fell to your doom!");
						}//end of arena
						if(plugin.getConfig().contains("bplist5."+name)){
							double x = plugin.getConfig().getDouble("bluespawn5.x");
							double y = plugin.getConfig().getDouble("bluespawn5.y");
							double z = plugin.getConfig().getDouble("bluespawn5.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You fell to your doom!");
						}//end of arena
						
						if(plugin.getConfig().contains("rplist1."+name)){
							double x = plugin.getConfig().getDouble("redspawn1.x");
							double y = plugin.getConfig().getDouble("redspawn1.y");
							double z = plugin.getConfig().getDouble("redspawn1.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.RED);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.RED);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.RED);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.RED);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You fell to your doom!");
						}//end of arena
						if(plugin.getConfig().contains("rplist2."+name)){
							double x = plugin.getConfig().getDouble("redspawn2.x");
							double y = plugin.getConfig().getDouble("redspawn2.y");
							double z = plugin.getConfig().getDouble("redspawn2.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.RED);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.RED);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.RED);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.RED);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You fell to your doom!");
						}//end of arena
						if(plugin.getConfig().contains("rplist3."+name)){
							double x = plugin.getConfig().getDouble("redspawn3.x");
							double y = plugin.getConfig().getDouble("redspawn3.y");
							double z = plugin.getConfig().getDouble("redspawn3.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.RED);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.RED);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.RED);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.RED);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You fell to your doom!");
						}//end of arena
						if(plugin.getConfig().contains("rplist4."+name)){
							double x = plugin.getConfig().getDouble("redspawn4.x");
							double y = plugin.getConfig().getDouble("redspawn4.y");
							double z = plugin.getConfig().getDouble("redspawn4.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.RED);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.RED);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.RED);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.RED);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You fell to your doom!");
						}//end of arena
						if(plugin.getConfig().contains("rplist5."+name)){
							double x = plugin.getConfig().getDouble("redspawn5.x");
							double y = plugin.getConfig().getDouble("redspawn5.y");
							double z = plugin.getConfig().getDouble("redspawn5.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.RED);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.RED);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.RED);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.RED);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You fell to your doom!");
						}//end of arena
					}
				}
			
				if(event.getCause().equals(DamageCause.LAVA)){
					Damageable d = p;
					if(d.getHealth()>=3){
						event.setDamage(2);
					}else{
						if(plugin.getConfig().contains("bplist1."+name)){
							double x = plugin.getConfig().getDouble("bluespawn1.x");
							double y = plugin.getConfig().getDouble("bluespawn1.y");
							double z = plugin.getConfig().getDouble("bluespawn1.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You got torched in lava");
							p.setFireTicks(0);
						}//end of arena
						if(plugin.getConfig().contains("bplist2."+name)){
							double x = plugin.getConfig().getDouble("bluespawn2.x");
							double y = plugin.getConfig().getDouble("bluespawn2.y");
							double z = plugin.getConfig().getDouble("bluespawn2.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You got torched in lava");
							p.setFireTicks(0);
						}//end of arena
						if(plugin.getConfig().contains("bplist3."+name)){
							double x = plugin.getConfig().getDouble("bluespawn3.x");
							double y = plugin.getConfig().getDouble("bluespawn3.y");
							double z = plugin.getConfig().getDouble("bluespawn3.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You got torched in lava");
							p.setFireTicks(0);
						}//end of arena
						if(plugin.getConfig().contains("bplist4."+name)){
							double x = plugin.getConfig().getDouble("bluespawn4.x");
							double y = plugin.getConfig().getDouble("bluespawn4.y");
							double z = plugin.getConfig().getDouble("bluespawn4.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You got torched in lava");
							p.setFireTicks(0);
						}//end of arena
						if(plugin.getConfig().contains("bplist5."+name)){
							double x = plugin.getConfig().getDouble("bluespawn5.x");
							double y = plugin.getConfig().getDouble("bluespawn5.y");
							double z = plugin.getConfig().getDouble("bluespawn5.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You got torched in lava");
							p.setFireTicks(0);
						}//end of arena
						
						if(plugin.getConfig().contains("rplist1."+name)){
							double x = plugin.getConfig().getDouble("redspawn1.x");
							double y = plugin.getConfig().getDouble("redspawn1.y");
							double z = plugin.getConfig().getDouble("redspawn1.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.RED);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.RED);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.RED);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.RED);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You got torched in lava");
							p.setFireTicks(0);
						}//end of arena
						if(plugin.getConfig().contains("rplist2."+name)){
							double x = plugin.getConfig().getDouble("redspawn2.x");
							double y = plugin.getConfig().getDouble("redspawn2.y");
							double z = plugin.getConfig().getDouble("redspawn2.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.RED);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.RED);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.RED);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.RED);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You got torched in lava");
							p.setFireTicks(0);
						}//end of arena
						if(plugin.getConfig().contains("rplist3."+name)){
							double x = plugin.getConfig().getDouble("redspawn3.x");
							double y = plugin.getConfig().getDouble("redspawn3.y");
							double z = plugin.getConfig().getDouble("redspawn3.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.RED);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.RED);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.RED);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.RED);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You got torched in lava");
							p.setFireTicks(0);
						}//end of arena
						if(plugin.getConfig().contains("rplist4."+name)){
							double x = plugin.getConfig().getDouble("redspawn4.x");
							double y = plugin.getConfig().getDouble("redspawn4.y");
							double z = plugin.getConfig().getDouble("redspawn4.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.RED);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.RED);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.RED);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.RED);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You got torched in lava");
							p.setFireTicks(0);
						}//end of arena
						if(plugin.getConfig().contains("rplist5."+name)){
							double x = plugin.getConfig().getDouble("redspawn5.x");
							double y = plugin.getConfig().getDouble("redspawn5.y");
							double z = plugin.getConfig().getDouble("redspawn5.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.RED);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.RED);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.RED);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.RED);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You got torched in lava");
							p.setFireTicks(0);
						}//end of arena
					}
				}
			
				if(event.getCause().equals(DamageCause.DROWNING)){
					Damageable d = p;
					if(d.getHealth()>=3){
						event.setDamage(2);
					}else{
						if(plugin.getConfig().contains("bplist1."+name)){
							double x = plugin.getConfig().getDouble("bluespawn1.x");
							double y = plugin.getConfig().getDouble("bluespawn1.y");
							double z = plugin.getConfig().getDouble("bluespawn1.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You ran out of air!");
						}//end of arena
						if(plugin.getConfig().contains("bplist2."+name)){
							double x = plugin.getConfig().getDouble("bluespawn2.x");
							double y = plugin.getConfig().getDouble("bluespawn2.y");
							double z = plugin.getConfig().getDouble("bluespawn2.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You ran out of air!");
						}//end of arena
						if(plugin.getConfig().contains("bplist3."+name)){
							double x = plugin.getConfig().getDouble("bluespawn3.x");
							double y = plugin.getConfig().getDouble("bluespawn3.y");
							double z = plugin.getConfig().getDouble("bluespawn3.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You ran out of air!");
						}//end of arena
						if(plugin.getConfig().contains("bplist4."+name)){
							double x = plugin.getConfig().getDouble("bluespawn4.x");
							double y = plugin.getConfig().getDouble("bluespawn4.y");
							double z = plugin.getConfig().getDouble("bluespawn4.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You ran out of air!");
						}//end of arena
						if(plugin.getConfig().contains("bplist5."+name)){
							double x = plugin.getConfig().getDouble("bluespawn5.x");
							double y = plugin.getConfig().getDouble("bluespawn5.y");
							double z = plugin.getConfig().getDouble("bluespawn5.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You ran out of air!");
						}//end of arena
						
						if(plugin.getConfig().contains("rplist1."+name)){
							double x = plugin.getConfig().getDouble("redspawn1.x");
							double y = plugin.getConfig().getDouble("redspawn1.y");
							double z = plugin.getConfig().getDouble("redspawn1.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.RED);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.RED);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.RED);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.RED);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You ran out of air!");
						}//end of arena
						if(plugin.getConfig().contains("rplist2."+name)){
							double x = plugin.getConfig().getDouble("redspawn2.x");
							double y = plugin.getConfig().getDouble("redspawn2.y");
							double z = plugin.getConfig().getDouble("redspawn2.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.RED);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.RED);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.RED);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.RED);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You ran out of air!");
						}//end of arena
						if(plugin.getConfig().contains("rplist3."+name)){
							double x = plugin.getConfig().getDouble("redspawn3.x");
							double y = plugin.getConfig().getDouble("redspawn3.y");
							double z = plugin.getConfig().getDouble("redspawn3.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.RED);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.RED);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.RED);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.RED);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You ran out of air!");
						}//end of arena
						if(plugin.getConfig().contains("rplist4."+name)){
							double x = plugin.getConfig().getDouble("redspawn4.x");
							double y = plugin.getConfig().getDouble("redspawn4.y");
							double z = plugin.getConfig().getDouble("redspawn4.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.RED);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.RED);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.RED);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.RED);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You ran out of air!");
						}//end of arena
						if(plugin.getConfig().contains("rplist5."+name)){
							double x = plugin.getConfig().getDouble("redspawn5.x");
							double y = plugin.getConfig().getDouble("redspawn5.y");
							double z = plugin.getConfig().getDouble("redspawn5.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.RED);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.RED);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.RED);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.RED);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You ran out of air!");
						}//end of arena
					}
				}
			
				if(event.getCause().equals(DamageCause.FIRE)){
					event.setCancelled(true);
				}
			
				if(event.getCause().equals(DamageCause.FIRE_TICK)){
					Damageable d = p;
					if(d.getHealth()>=3){
						event.setDamage(2);
					}else{
						if(plugin.getConfig().contains("bplist1."+name)){
							double x = plugin.getConfig().getDouble("bluespawn1.x");
							double y = plugin.getConfig().getDouble("bluespawn1.y");
							double z = plugin.getConfig().getDouble("bluespawn1.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You died while on fire!");
							p.setFireTicks(0);
						}//end of arena
						if(plugin.getConfig().contains("bplist2."+name)){
							double x = plugin.getConfig().getDouble("bluespawn2.x");
							double y = plugin.getConfig().getDouble("bluespawn2.y");
							double z = plugin.getConfig().getDouble("bluespawn2.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You died while on fire!");
							p.setFireTicks(0);
						}//end of arena
						if(plugin.getConfig().contains("bplist3."+name)){
							double x = plugin.getConfig().getDouble("bluespawn3.x");
							double y = plugin.getConfig().getDouble("bluespawn3.y");
							double z = plugin.getConfig().getDouble("bluespawn3.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You died while on fire!");
							p.setFireTicks(0);
						}//end of arena
						if(plugin.getConfig().contains("bplist4."+name)){
							double x = plugin.getConfig().getDouble("bluespawn4.x");
							double y = plugin.getConfig().getDouble("bluespawn4.y");
							double z = plugin.getConfig().getDouble("bluespawn4.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You died while on fire!");
							p.setFireTicks(0);
						}//end of arena
						if(plugin.getConfig().contains("bplist5."+name)){
							double x = plugin.getConfig().getDouble("bluespawn5.x");
							double y = plugin.getConfig().getDouble("bluespawn5.y");
							double z = plugin.getConfig().getDouble("bluespawn5.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You died while on fire!");
							p.setFireTicks(0);
						}//end of arena
						
						if(plugin.getConfig().contains("rplist1."+name)){
							double x = plugin.getConfig().getDouble("redspawn1.x");
							double y = plugin.getConfig().getDouble("redspawn1.y");
							double z = plugin.getConfig().getDouble("redspawn1.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.RED);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.RED);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.RED);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.RED);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You died while on fire!");
							p.setFireTicks(0);
						}//end of arena
						if(plugin.getConfig().contains("rplist2."+name)){
							double x = plugin.getConfig().getDouble("redspawn2.x");
							double y = plugin.getConfig().getDouble("redspawn2.y");
							double z = plugin.getConfig().getDouble("redspawn2.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.RED);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.RED);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.RED);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.RED);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You died while on fire!");
							p.setFireTicks(0);
						}//end of arena
						if(plugin.getConfig().contains("rplist3."+name)){
							double x = plugin.getConfig().getDouble("redspawn3.x");
							double y = plugin.getConfig().getDouble("redspawn3.y");
							double z = plugin.getConfig().getDouble("redspawn3.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.RED);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.RED);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.RED);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.RED);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You died while on fire!");
							p.setFireTicks(0);
						}//end of arena
						if(plugin.getConfig().contains("rplist4."+name)){
							double x = plugin.getConfig().getDouble("redspawn4.x");
							double y = plugin.getConfig().getDouble("redspawn4.y");
							double z = plugin.getConfig().getDouble("redspawn4.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.RED);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.RED);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.RED);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.RED);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You died while on fire!");
							p.setFireTicks(0);
						}//end of arena
						if(plugin.getConfig().contains("rplist5."+name)){
							double x = plugin.getConfig().getDouble("redspawn5.x");
							double y = plugin.getConfig().getDouble("redspawn5.y");
							double z = plugin.getConfig().getDouble("redspawn5.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.RED);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.RED);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.RED);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.RED);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You died while on fire!");
							p.setFireTicks(0);
						}//end of arena
					}
				}//ft
				
				if(event.getCause().equals(DamageCause.VOID)){
					Damageable d = p;
					if(d.getHealth()>=3){
						event.setDamage(2);
					}else{
						if(plugin.getConfig().contains("bplist1."+name)){
							double x = plugin.getConfig().getDouble("bluespawn1.x");
							double y = plugin.getConfig().getDouble("bluespawn1.y");
							double z = plugin.getConfig().getDouble("bluespawn1.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You fell through the world!");
						}//end of arena
						if(plugin.getConfig().contains("bplist2."+name)){
							double x = plugin.getConfig().getDouble("bluespawn2.x");
							double y = plugin.getConfig().getDouble("bluespawn2.y");
							double z = plugin.getConfig().getDouble("bluespawn2.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You fell through the world!");
						}//end of arena
						if(plugin.getConfig().contains("bplist3."+name)){
							double x = plugin.getConfig().getDouble("bluespawn3.x");
							double y = plugin.getConfig().getDouble("bluespawn3.y");
							double z = plugin.getConfig().getDouble("bluespawn3.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You fell through the world!");
						}//end of arena
						if(plugin.getConfig().contains("bplist4."+name)){
							double x = plugin.getConfig().getDouble("bluespawn4.x");
							double y = plugin.getConfig().getDouble("bluespawn4.y");
							double z = plugin.getConfig().getDouble("bluespawn4.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You fell through the world!");
						}//end of arena
						if(plugin.getConfig().contains("bplist5."+name)){
							double x = plugin.getConfig().getDouble("bluespawn5.x");
							double y = plugin.getConfig().getDouble("bluespawn5.y");
							double z = plugin.getConfig().getDouble("bluespawn5.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You fell through the world!");
						}//end of arena
						
						if(plugin.getConfig().contains("rplist1."+name)){
							double x = plugin.getConfig().getDouble("redspawn1.x");
							double y = plugin.getConfig().getDouble("redspawn1.y");
							double z = plugin.getConfig().getDouble("redspawn1.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.RED);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.RED);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.RED);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.RED);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You fell through the world!");
						}//end of arena
						if(plugin.getConfig().contains("rplist2."+name)){
							double x = plugin.getConfig().getDouble("redspawn2.x");
							double y = plugin.getConfig().getDouble("redspawn2.y");
							double z = plugin.getConfig().getDouble("redspawn2.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.RED);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.RED);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.RED);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.RED);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You fell through the world!");
						}//end of arena
						if(plugin.getConfig().contains("rplist3."+name)){
							double x = plugin.getConfig().getDouble("redspawn3.x");
							double y = plugin.getConfig().getDouble("redspawn3.y");
							double z = plugin.getConfig().getDouble("redspawn3.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.RED);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.RED);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.RED);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.RED);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You fell through the world!");
						}//end of arena
						if(plugin.getConfig().contains("rplist4."+name)){
							double x = plugin.getConfig().getDouble("redspawn4.x");
							double y = plugin.getConfig().getDouble("redspawn4.y");
							double z = plugin.getConfig().getDouble("redspawn4.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.RED);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.RED);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.RED);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.RED);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You fell through the world!");
						}//end of arena
						if(plugin.getConfig().contains("rplist5."+name)){
							double x = plugin.getConfig().getDouble("redspawn5.x");
							double y = plugin.getConfig().getDouble("redspawn5.y");
							double z = plugin.getConfig().getDouble("redspawn5.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.RED);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.RED);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.RED);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.RED);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You fell through the world!");
						}//end of arena
					}
				}//v
				
				if(event.getCause().equals(DamageCause.PROJECTILE)){
					Damageable d = p;
					if(d.getHealth()>=3){
						event.setDamage(2);
					}else{
						if(plugin.getConfig().contains("bplist1."+name)){
							double x = plugin.getConfig().getDouble("bluespawn1.x");
							double y = plugin.getConfig().getDouble("bluespawn1.y");
							double z = plugin.getConfig().getDouble("bluespawn1.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were shot to death!");
						}//end of arena
						if(plugin.getConfig().contains("bplist2."+name)){
							double x = plugin.getConfig().getDouble("bluespawn2.x");
							double y = plugin.getConfig().getDouble("bluespawn2.y");
							double z = plugin.getConfig().getDouble("bluespawn2.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were shot to death!");
						}//end of arena
						if(plugin.getConfig().contains("bplist3."+name)){
							double x = plugin.getConfig().getDouble("bluespawn3.x");
							double y = plugin.getConfig().getDouble("bluespawn3.y");
							double z = plugin.getConfig().getDouble("bluespawn3.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were shot to death!");
						}//end of arena
						if(plugin.getConfig().contains("bplist4."+name)){
							double x = plugin.getConfig().getDouble("bluespawn4.x");
							double y = plugin.getConfig().getDouble("bluespawn4.y");
							double z = plugin.getConfig().getDouble("bluespawn4.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were shot to death!");
						}//end of arena
						if(plugin.getConfig().contains("bplist5."+name)){
							double x = plugin.getConfig().getDouble("bluespawn5.x");
							double y = plugin.getConfig().getDouble("bluespawn5.y");
							double z = plugin.getConfig().getDouble("bluespawn5.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.BLUE);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.BLUE);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.BLUE);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.BLUE);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were shot to death!");
						}//end of arena
						
						if(plugin.getConfig().contains("rplist1."+name)){
							double x = plugin.getConfig().getDouble("redspawn1.x");
							double y = plugin.getConfig().getDouble("redspawn1.y");
							double z = plugin.getConfig().getDouble("redspawn1.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.RED);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.RED);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.RED);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.RED);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were shot to death!");
						}//end of arena
						if(plugin.getConfig().contains("rplist2."+name)){
							double x = plugin.getConfig().getDouble("redspawn2.x");
							double y = plugin.getConfig().getDouble("redspawn2.y");
							double z = plugin.getConfig().getDouble("redspawn2.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.RED);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.RED);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.RED);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.RED);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were shot to death!");
						}//end of arena
						if(plugin.getConfig().contains("rplist3."+name)){
							double x = plugin.getConfig().getDouble("redspawn3.x");
							double y = plugin.getConfig().getDouble("redspawn3.y");
							double z = plugin.getConfig().getDouble("redspawn3.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.RED);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.RED);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.RED);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.RED);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were shot to death!");
						}//end of arena
						if(plugin.getConfig().contains("rplist4."+name)){
							double x = plugin.getConfig().getDouble("redspawn4.x");
							double y = plugin.getConfig().getDouble("redspawn4.y");
							double z = plugin.getConfig().getDouble("redspawn4.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.RED);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.RED);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.RED);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.RED);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were shot to death!");
						}//end of arena
						if(plugin.getConfig().contains("rplist5."+name)){
							double x = plugin.getConfig().getDouble("redspawn5.x");
							double y = plugin.getConfig().getDouble("redspawn5.y");
							double z = plugin.getConfig().getDouble("redspawn5.z");
							Location l = new Location(p.getWorld(),x,y,z);
							Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
							FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
							data.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).build());
							data.setPower(0);
							firework.setFireworkMeta(data);
							p.teleport(l);
							ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
							LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
							meta.setColor(Color.RED);
							helm.setItemMeta(meta);
							p.getInventory().setHelmet(helm);
							//chestplate
							ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
							LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
							metat.setColor(Color.RED);
							ches.setItemMeta(metat);
							p.getInventory().setChestplate(ches);
							//leggings
							ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
							LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
							metatt.setColor(Color.RED);
							legg.setItemMeta(metatt);
							p.getInventory().setLeggings(legg);
							//boots
							ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
							LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
							metattt.setColor(Color.RED);
							boot.setItemMeta(metattt);
							p.getInventory().setBoots(boot);
							p.setLevel(40);
							d.setHealth(20);
							p.setFoodLevel(20);
							p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You were shot to death!");
						}//end of arena
					}
				}//a
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
		guy.kickPlayer(ChatColor.GOLD+"[Backbone]"+ChatColor.RED+"Please login again. There was an error in the software!");
			}
		}
		// This is coded in here as a patch for an old bug. The bug is that if a player is playing and dies (a real death)  
		// his client will ask him to log out of the server or respawn. If a player chooses to respawn, they are taken out of
		// the arena and sent to spawn. But they are still hooked into backbone! This method will kick them if they were to
		// seriously die. The OnJoin class will unhook any kicked players from the plugin. The player can simply re-join the 
		// server and re-run /join. Simple :^)
	}
}