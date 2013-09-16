package me.firebreath15.backbone;

import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ArrowShoot implements Listener{
	main plugin;
	ArrowShoot(main c){
		plugin=c;
	}
	
	@EventHandler
	public void onArrowShoot(ProjectileHitEvent e){
		if(e.getEntity().getShooter() instanceof Player){
			if(e.getEntity() instanceof Arrow){
				Player p = (Player)e.getEntity().getShooter();
				if(plugin.getConfig().contains("players1."+p.getName()) || plugin.getConfig().contains("players2."+p.getName()) || plugin.getConfig().contains("players3."+p.getName()) || plugin.getConfig().contains("players4."+p.getName()) || plugin.getConfig().contains("players5."+p.getName())){
					Location l = e.getEntity().getLocation();
					e.getEntity().remove();
					
					l.getWorld().createExplosion(l, 0F);
				}
			}
		}
	}
}
