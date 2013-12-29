package me.firebreath15.backbone;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Gun implements Listener{
	main plugin;
	Gun(main c){
		plugin=c;
	}
	
	@EventHandler
	public void onGunShoot(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(plugin.getConfig().contains("players1."+p.getName()) || plugin.getConfig().contains("players2."+p.getName()) || plugin.getConfig().contains("players3."+p.getName()) || plugin.getConfig().contains("players4."+p.getName()) || plugin.getConfig().contains("players5."+p.getName())){
			if(e.getAction() == Action.RIGHT_CLICK_AIR){
				if(p.getItemInHand().getType()==Material.BLAZE_ROD){
					int lvl = p.getLevel();
					if(lvl >= 1){
						p.launchProjectile(Snowball.class);
						p.setLevel(lvl-1);
					}else{
						p.playSound(p.getLocation(), Sound.CLICK, 7, 4);
					}
				}
				p.setFoodLevel(20);
			}
		}
	}
}
