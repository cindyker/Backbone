package me.firebreath15.backbone;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Armor {
	public ItemStack[] redarmor;
	public ItemStack[] bluearmor;
	
	public void prepareArmor(){
		ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
		LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
		meta.setColor(Color.RED);
		helm.setItemMeta(meta);
		redarmor[1] = helm;
		
		ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
		LeatherArmorMeta metat = (LeatherArmorMeta) ches.getItemMeta();
		metat.setColor(Color.RED);
		ches.setItemMeta(metat);
		redarmor[2] = ches;
		
		ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
		LeatherArmorMeta metatt = (LeatherArmorMeta) legg.getItemMeta();
		metatt.setColor(Color.RED);
		legg.setItemMeta(metatt);
		redarmor[3] = legg;
		
		ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
		LeatherArmorMeta metattt = (LeatherArmorMeta) boot.getItemMeta();
		metattt.setColor(Color.RED);
		boot.setItemMeta(metattt);
		redarmor[4] = boot;
		
		ItemStack helmb = new ItemStack(Material.LEATHER_HELMET);
		LeatherArmorMeta metab = (LeatherArmorMeta) helm.getItemMeta();
		meta.setColor(Color.BLUE);
		helm.setItemMeta(metab);
		bluearmor[1] = helmb;
		
		ItemStack chesb = new ItemStack(Material.LEATHER_CHESTPLATE);
		LeatherArmorMeta metatb = (LeatherArmorMeta) ches.getItemMeta();
		metat.setColor(Color.BLUE);
		ches.setItemMeta(metatb);
		bluearmor[2] = chesb;
		
		ItemStack leggb = new ItemStack(Material.LEATHER_LEGGINGS);
		LeatherArmorMeta metattb = (LeatherArmorMeta) legg.getItemMeta();
		metatt.setColor(Color.BLUE);
		legg.setItemMeta(metattb);
		bluearmor[3] = leggb;
		
		ItemStack bootb = new ItemStack(Material.LEATHER_BOOTS);
		LeatherArmorMeta metatttb = (LeatherArmorMeta) boot.getItemMeta();
		metattt.setColor(Color.BLUE);
		boot.setItemMeta(metatttb);
		bluearmor[4] = bootb;
	}
	
}
