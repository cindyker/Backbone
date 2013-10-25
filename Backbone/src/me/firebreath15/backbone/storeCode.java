package me.firebreath15.backbone;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public class storeCode {
	main plugin;
	storeCode(main c){
		plugin=c;
	}
	
	public void giveMenu(Player p){
		p.sendMessage(ChatColor.DARK_PURPLE+"==========[ Backbone Points Store]==========");
		p.sendMessage(ChatColor.GOLD+"[1] "+ChatColor.YELLOW+"Reload Now "+ChatColor.DARK_GREEN+"[100]");
		p.sendMessage(ChatColor.GOLD+"[2] "+ChatColor.YELLOW+"Jump Boost "+ChatColor.DARK_GREEN+"[500]");
		p.sendMessage(ChatColor.GOLD+"[3] "+ChatColor.YELLOW+"Speed Boost "+ChatColor.DARK_GREEN+"[500]");
		p.sendMessage(ChatColor.GOLD+"[4] "+ChatColor.YELLOW+"Enderpearls "+ChatColor.DARK_GREEN+"[550]");
		p.sendMessage(ChatColor.GOLD+"[5] "+ChatColor.YELLOW+"Healing Potions "+ChatColor.DARK_GREEN+"[950]");
		p.sendMessage(ChatColor.GOLD+"[6] "+ChatColor.YELLOW+"Ammo Upgrade "+ChatColor.DARK_GREEN+"[950]");
		p.sendMessage(ChatColor.GOLD+"[7] "+ChatColor.YELLOW+"Fake Team Switch "+ChatColor.DARK_GREEN+"[1000]");
		p.sendMessage(ChatColor.GOLD+"[8] "+ChatColor.YELLOW+"BombBow "+ChatColor.DARK_GREEN+"[1000]");
		p.sendMessage(ChatColor.GOLD+"[9] "+ChatColor.YELLOW+"Nausea Sticks "+ChatColor.DARK_GREEN+"[2000]");
		p.sendMessage(ChatColor.RED+"To buy, type /bb store <item number>");
		if(plugin.getConfig().contains(p.getName())){
			int points = plugin.getConfig().getInt(p.getName());
			p.sendMessage(ChatColor.BOLD+"You have "+points+" points");
			p.sendMessage(ChatColor.DARK_PURPLE+"==========[ Backbone Points Store]==========");
		}else{
			p.sendMessage(ChatColor.BOLD+"You have 0 points");
			p.sendMessage(ChatColor.DARK_PURPLE+"==========[ Backbone Points Store]==========");
		}
	}
	
	@SuppressWarnings("deprecation")
	public void goShopping(Player p, String a){
		String name = p.getName();
		if(a.equalsIgnoreCase("2")){
			//jump						
			if(plugin.getConfig().contains(name)){
				int points = plugin.getConfig().getInt(name);
				if(points >= 500){
				plugin.getConfig().set(name, points-500);
				plugin.saveConfig();
				PotionEffect effect = new PotionEffect(PotionEffectType.JUMP, 1200, 2);
				p.addPotionEffect(effect);
				p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GREEN+"Enjoy your purchase!");
				}else{
					p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.RED+"You don't have enough points!");
				}
			}else{
				p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.RED+"You don't have enough points!");
			}
		}
		
		if(a.equalsIgnoreCase("3")){
			//speed
			if(plugin.getConfig().contains(name)){
				int points = plugin.getConfig().getInt(name);
				if(points >= 500){
				plugin.getConfig().set(name, points-500);
				plugin.saveConfig();
				PotionEffect effect = new PotionEffect(PotionEffectType.SPEED, 1200, 2);
				p.addPotionEffect(effect);
				p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GREEN+"Enjoy your purchase!");
				}else{
					p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.RED+"You don't have enough points!");
				}
			}else{
				p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.RED+"You don't have enough points!");
			}
		}
		
		if(a.equalsIgnoreCase("7")){
			if(plugin.getConfig().contains(name)){
			int points = plugin.getConfig().getInt(name);
			if(points >= 1000){
				plugin.getConfig().set(name, points-1000);
				plugin.saveConfig();
				
				if(plugin.getConfig().contains("rplist1."+name)){
					ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
					LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
					meta.setColor(Color.BLUE);
					helm.setItemMeta(meta);
					p.getInventory().setHelmet(helm);
					ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
					LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
					metat.setColor(Color.BLUE);
					ches.setItemMeta(metat);
					p.getInventory().setChestplate(ches);
					ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
					LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
					metatt.setColor(Color.BLUE);
					legg.setItemMeta(metatt);
					p.getInventory().setLeggings(legg);
					ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
					LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
					metattt.setColor(Color.BLUE);
					boot.setItemMeta(metattt);
					p.getInventory().setBoots(boot);
				}
					if(plugin.getConfig().contains("bplist1."+name)){
					ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
					LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
					meta.setColor(Color.RED);
					helm.setItemMeta(meta);
					p.getInventory().setHelmet(helm);
					ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
					LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
					metat.setColor(Color.RED);
					ches.setItemMeta(metat);
					p.getInventory().setChestplate(ches);
					ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
					LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
					metatt.setColor(Color.RED);
					legg.setItemMeta(metatt);
					p.getInventory().setLeggings(legg);
					ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
					LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
					metattt.setColor(Color.RED);
					boot.setItemMeta(metattt);
					p.getInventory().setBoots(boot);
				}
					
					if(plugin.getConfig().contains("rplist2."+name)){
						ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
						LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
						meta.setColor(Color.BLUE);
						helm.setItemMeta(meta);
						p.getInventory().setHelmet(helm);
						ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
						LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
						metat.setColor(Color.BLUE);
						ches.setItemMeta(metat);
						p.getInventory().setChestplate(ches);
						ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
						LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
						metatt.setColor(Color.BLUE);
						legg.setItemMeta(metatt);
						p.getInventory().setLeggings(legg);
						ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
						LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
						metattt.setColor(Color.BLUE);
						boot.setItemMeta(metattt);
						p.getInventory().setBoots(boot);
					}
					
					if(plugin.getConfig().contains("bplist2."+name)){
						ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
						LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
						meta.setColor(Color.RED);
						helm.setItemMeta(meta);
						p.getInventory().setHelmet(helm);
						ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
						LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
						metat.setColor(Color.RED);
						ches.setItemMeta(metat);
						p.getInventory().setChestplate(ches);
						ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
						LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
						metatt.setColor(Color.RED);
						legg.setItemMeta(metatt);
						p.getInventory().setLeggings(legg);
						ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
						LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
						metattt.setColor(Color.RED);
						boot.setItemMeta(metattt);
						p.getInventory().setBoots(boot);
					}
					
					if(plugin.getConfig().contains("rplist3."+name)){
						ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
						LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
						meta.setColor(Color.BLUE);
						helm.setItemMeta(meta);
						p.getInventory().setHelmet(helm);
						ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
						LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
						metat.setColor(Color.BLUE);
						ches.setItemMeta(metat);
						p.getInventory().setChestplate(ches);
						ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
						LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
						metatt.setColor(Color.BLUE);
						legg.setItemMeta(metatt);
						p.getInventory().setLeggings(legg);
						ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
						LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
						metattt.setColor(Color.BLUE);
						boot.setItemMeta(metattt);
						p.getInventory().setBoots(boot);
					}
					
					if(plugin.getConfig().contains("bplist3."+name)){
						ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
						LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
						meta.setColor(Color.RED);
						helm.setItemMeta(meta);
						p.getInventory().setHelmet(helm);
						ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
						LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
						metat.setColor(Color.RED);
						ches.setItemMeta(metat);
						p.getInventory().setChestplate(ches);
						ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
						LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
						metatt.setColor(Color.RED);
						legg.setItemMeta(metatt);
						p.getInventory().setLeggings(legg);
						ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
						LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
						metattt.setColor(Color.RED);
						boot.setItemMeta(metattt);
						p.getInventory().setBoots(boot);
					}
				
					if(plugin.getConfig().contains("rplist4."+name)){
						ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
						LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
						meta.setColor(Color.BLUE);
						helm.setItemMeta(meta);
						p.getInventory().setHelmet(helm);
						ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
						LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
						metat.setColor(Color.BLUE);
						ches.setItemMeta(metat);
						p.getInventory().setChestplate(ches);
						ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
						LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
						metatt.setColor(Color.BLUE);
						legg.setItemMeta(metatt);
						p.getInventory().setLeggings(legg);
						ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
						LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
						metattt.setColor(Color.BLUE);
						boot.setItemMeta(metattt);
						p.getInventory().setBoots(boot);
					}
					
					if(plugin.getConfig().contains("bplist4."+name)){
						ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
						LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
						meta.setColor(Color.RED);
						helm.setItemMeta(meta);
						p.getInventory().setHelmet(helm);
						ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
						LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
						metat.setColor(Color.RED);
						ches.setItemMeta(metat);
						p.getInventory().setChestplate(ches);
						ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
						LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
						metatt.setColor(Color.RED);
						legg.setItemMeta(metatt);
						p.getInventory().setLeggings(legg);
						ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
						LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
						metattt.setColor(Color.RED);
						boot.setItemMeta(metattt);
						p.getInventory().setBoots(boot);
					}
					
					if(plugin.getConfig().contains("rplist5."+name)){
						ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
						LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
						meta.setColor(Color.BLUE);
						helm.setItemMeta(meta);
						p.getInventory().setHelmet(helm);
						ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
						LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
						metat.setColor(Color.BLUE);
						ches.setItemMeta(metat);
						p.getInventory().setChestplate(ches);
						ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
						LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
						metatt.setColor(Color.BLUE);
						legg.setItemMeta(metatt);
						p.getInventory().setLeggings(legg);
						ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
						LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
						metattt.setColor(Color.BLUE);
						boot.setItemMeta(metattt);
						p.getInventory().setBoots(boot);
					}
					
					if(plugin.getConfig().contains("bplist5."+name)){
						ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
						LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
						meta.setColor(Color.RED);
						helm.setItemMeta(meta);
						p.getInventory().setHelmet(helm);
						ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
						LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
						metat.setColor(Color.RED);
						ches.setItemMeta(metat);
						p.getInventory().setChestplate(ches);
						ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
						LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
						metatt.setColor(Color.RED);
						legg.setItemMeta(metatt);
						p.getInventory().setLeggings(legg);
						ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
						LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
						metattt.setColor(Color.RED);
						boot.setItemMeta(metattt);
						p.getInventory().setBoots(boot);
					}
					
				p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GREEN+"Enjoy your purchase!");
				p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GREEN+"Your armor color has changed, but not your team!");
				p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GREEN+"Switch will last until you are killed or login again.");
				}else{
					p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.RED+"You don't have enough points!");
				}
		}
	}
		
		if(a.equalsIgnoreCase("9")){
			if(plugin.getConfig().contains(name)){
				if(plugin.getConfig().getInt(name) >= 2000){
					ItemStack stack = new ItemStack(Material.GOLD_HOE);
					ItemMeta im = stack.getItemMeta();
					im.setDisplayName(ChatColor.DARK_GREEN+"Nausea Stick");
					stack.setItemMeta(im);
					p.getInventory().addItem(stack);
					ItemStack stack2 = new ItemStack(Material.GOLD_HOE);
					ItemMeta im2 = stack2.getItemMeta();
					im2.setDisplayName(ChatColor.DARK_GREEN+"Nausea Stick");
					stack2.setItemMeta(im2);
					p.getInventory().addItem(stack2);
					int pts = plugin.getConfig().getInt(name) ;
					plugin.getConfig().set(name, pts-2000);
					plugin.saveConfig();
					p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GREEN+"Enjoy your purchase! Punch a player with a Nausea Stick to warp their screen for a short time!");
				}else{
					p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.RED+"You don't have enough points!");
				}
			}
		}
		
		if(a.equalsIgnoreCase("6")){
			if(plugin.getConfig().contains(name)){
				if(plugin.getConfig().getInt(name) >= 950){
					
					p.setLevel(100);
					int pts = plugin.getConfig().getInt(name);
					plugin.getConfig().set(name, pts-950);
					plugin.saveConfig();
					p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GREEN+"Enjoy your purchase! You now have 100 rounds!");
				}else{
					p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.RED+"You don't have enough points!");
				}
			}
		}
		
		if(a.equalsIgnoreCase("5")){
			if(plugin.getConfig().contains(name)){
				if(plugin.getConfig().getInt(name) >= 950){
					
					Potion potion = new Potion(PotionType.INSTANT_HEAL);
					potion.splash();
					ItemStack potions = potion.toItemStack(5);
					p.getInventory().addItem(potions);
					p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GREEN+"Enjoy your purchase!");
					int pts = plugin.getConfig().getInt(name);
					plugin.getConfig().set(name, pts-950);
					plugin.saveConfig();
				}else{
					p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.RED+"You don't have enough points!");
				}
			}
		}
		
		if(a.equalsIgnoreCase("4")){
			if(plugin.getConfig().contains(name)){
				if(plugin.getConfig().getInt(name) >= 550){
					
					ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
					pearl.setAmount(5);
					p.getInventory().addItem(pearl);
					
					int pts = plugin.getConfig().getInt(name);
					plugin.getConfig().set(name, pts-550);
					plugin.saveConfig();
					p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GREEN+"Enjoy your purchase!");
				}else{
					p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.RED+"You don't have enough points!");
				}
			}
		}
		
		if(a.equalsIgnoreCase("1")){
			if(plugin.getConfig().contains(name)){
				if(plugin.getConfig().getInt(name) >= 100){
					
					p.setExp(0);
					p.setLevel(40);
					
					Damageable d = p;
					d.setHealth(20);
					
					p.setFoodLevel(20);
					
					int pts = plugin.getConfig().getInt(name);
					plugin.getConfig().set(name, pts-100);
					plugin.saveConfig();
					p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GREEN+"Enjoy your purchase! You have been fully reloaded!");
				}else{
					p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.RED+"You don't have enough points!");
				}
			}
		}
		
		if(a.equalsIgnoreCase("8")){
			int points = plugin.getConfig().getInt(name);
			if(points >= 1000){
				ItemStack bow = new ItemStack(Material.BOW);
				ItemStack arrow = new ItemStack(Material.ARROW);
				arrow.setAmount(20);
				ItemMeta am = arrow.getItemMeta();
				am.setDisplayName(ChatColor.RED+"BombBow Arrow");
				arrow.setItemMeta(am);
				ItemMeta m = bow.getItemMeta();
				m.setDisplayName(ChatColor.DARK_RED+"BombBow");
				bow.setItemMeta(m);
				p.getInventory().addItem(bow);
				p.getInventory().addItem(arrow);
				plugin.getConfig().set(name, points-1000);
				plugin.saveConfig();
				p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GREEN+"Enjoy your purchase! Use arrows to hit players or to scare them!");
			}else{
				p.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.RED+"You don't have enough points!");
			}
		}
	}
}
