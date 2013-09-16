package me.firebreath15.backbone;

//import org.bukkit.entity.Entity;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class OnHoeHit implements Listener{
	
	main plugin;
	OnHoeHit(main c){
		plugin=c;
	}
	
	@EventHandler
	public void onSplash(EntityDamageByEntityEvent event){
			Entity ent = event.getEntity();
			Entity damager = event.getDamager();
			if(ent instanceof Player && damager instanceof Player){
				Player player = (Player)event.getEntity();
				Player confuser = (Player)event.getDamager();
				if(confuser.getItemInHand().getType() == Material.GOLD_HOE){
					String name = confuser.getName();
					if(plugin.getConfig().contains("players1."+name) || plugin.getConfig().contains("players2."+name) || plugin.getConfig().contains("players3."+name) || plugin.getConfig().contains("players4."+name) || plugin.getConfig().contains("players5."+name)){
						event.setCancelled(true);
						PotionEffect effect = new PotionEffect(PotionEffectType.CONFUSION, 600, 2);
						PotionEffect effect2 = new PotionEffect(PotionEffectType.BLINDNESS, 600, 2);
						player.addPotionEffect(effect);
						player.addPotionEffect(effect2);
						int slot = confuser.getInventory().getHeldItemSlot();
						confuser.getInventory().clear(slot);
					}
				}
		}
	}
}
