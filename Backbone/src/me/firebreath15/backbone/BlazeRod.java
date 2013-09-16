/*
 * This listener codes the fact that in-game, right clicking air with a
 * blaze rod in hand will throw a snowball.
 * This also subtracts from the player's EXP. So make note of that ;)
 * 
 * Created by FireBreath15
 */

package me.firebreath15.backbone;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
//import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class BlazeRod implements Listener{
	
	main plugin;
	BlazeRod(main c){
		plugin=c;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onShoot(PlayerInteractEvent event){
		String name = event.getPlayer().getName();
		if(plugin.getConfig().contains("players1."+name) || plugin.getConfig().contains("players2."+name) || plugin.getConfig().contains("players3."+name) || plugin.getConfig().contains("players4."+name) || plugin.getConfig().contains("players5."+name)){
		//if theyre shooting with the blaze rod
		if (event.getPlayer().getItemInHand().getType() == Material.BLAZE_ROD && event.getAction() == Action.RIGHT_CLICK_AIR){
			//if they have ammo
			if (event.getPlayer().getLevel() >= 1){
				//they do! lets shoot at those nasty enemy players!
				event.getPlayer().throwSnowball();
				int exp = (int)event.getPlayer().getLevel();
				int newexp = exp - 1;
				event.getPlayer().setLevel(newexp);
			}else{
				//no ammo, no snowball!
				//event.getPlayer().sendMessage(ChatColor.RED+"You're out of ammo!");
				Location loc = event.getPlayer().getLocation();
				event.getPlayer().playSound(loc, Sound.CLICK, 5, 5);
			}
		}
		}
	}
}