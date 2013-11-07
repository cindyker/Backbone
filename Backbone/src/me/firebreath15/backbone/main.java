package me.firebreath15.backbone;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin{
	
	ISCOREAPI api;
	coreCode cc;
	
	public void onEnable(){		
		getServer().getPluginManager().registerEvents(new BlazeRod(this), this);
		getServer().getPluginManager().registerEvents(new OnHit(this), this);
		getServer().getPluginManager().registerEvents(new OnLeave(this), this);
		getServer().getPluginManager().registerEvents(new OnReload(this), this);
		getServer().getPluginManager().registerEvents(new OnBreak(this), this);
		getServer().getPluginManager().registerEvents(new OnDrop(this), this);
		getServer().getPluginManager().registerEvents(new OnHoeHit(this), this);
		getServer().getPluginManager().registerEvents(new ArrowShoot(this), this);
		getServer().getPluginManager().registerEvents(new joinSigns(this), this);
		getServer().getPluginManager().registerEvents(new OnRegain(this), this);
		
		this.reloadConfig();
		this.getConfig().set("bplist1", null);
		this.getConfig().set("rplist1", null);
		this.getConfig().set("players1", null);
		
		this.getConfig().set("bplist2", null);
		this.getConfig().set("rplist2", null);
		this.getConfig().set("players2", null);
		
		this.getConfig().set("bplist3", null);
		this.getConfig().set("rplist3", null);
		this.getConfig().set("players3", null);
		
		this.getConfig().set("bplist4", null);
		this.getConfig().set("rplist4", null);
		this.getConfig().set("players4", null);
		
		this.getConfig().set("bplist5", null);
		this.getConfig().set("rplist5", null);
		this.getConfig().set("players5", null);
		
		this.getConfig().set("bplayers1", 0);
		this.getConfig().set("rplayers1", 0);
		
		this.getConfig().set("bplayers2", 0);
		this.getConfig().set("rplayers2", 0);
		
		this.getConfig().set("bplayers3", 0);
		this.getConfig().set("rplayers3", 0);
		
		this.getConfig().set("bplayers4", 0);
		this.getConfig().set("rplayers4", 0);
		
		this.getConfig().set("bplayers5", 0);
		this.getConfig().set("rplayers5", 0);
		
		this.getConfig().set("rpoints1", 0);
		this.getConfig().set("bpoints1", 0);
		
		this.getConfig().set("rpoints2", 0);
		this.getConfig().set("bpoints2", 0);
		
		this.getConfig().set("rpoints3", 0);
		this.getConfig().set("bpoints3", 0);
		
		this.getConfig().set("rpoints4", 0);
		this.getConfig().set("bpoints4", 0);
		
		this.getConfig().set("rpoints5", 0);
		this.getConfig().set("bpoints5", 0);
		this.saveConfig();
		
		api=new ISCOREAPI();
		cc = new coreCode(this);
		cc.initInvApi();
	}
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("bb")){
			if(sender instanceof Player){
				if(args.length==0){
					sender.sendMessage(ChatColor.RED+"/bb <help|join|bspawn|rspawn|setreload|store|setend|leave>");
				}
				if(args.length==1){
					if(args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("setend") || args[0].equalsIgnoreCase("leave") || args[0].equalsIgnoreCase("store")){
						if(args[0].equalsIgnoreCase("help")){
							sender.sendMessage(ChatColor.GOLD+"==========[ Backbone Commands ]==========");
							sender.sendMessage(ChatColor.RED+"/bb help "+ChatColor.YELLOW+"- show this help page");
							sender.sendMessage(ChatColor.RED+"/bb join <arena> "+ChatColor.YELLOW+"- join an arena");
							sender.sendMessage(ChatColor.RED+"/bb bspawn <arena> "+ChatColor.YELLOW+"- set the Blue team's spawn for an arena");
							sender.sendMessage(ChatColor.RED+"/bb rspawn <arena> "+ChatColor.YELLOW+"- set the Red team's spawn for an arena");
							sender.sendMessage(ChatColor.RED+"/bb setreload <arena> "+ChatColor.YELLOW+"- set the ammo & food reloader for an arena!");
							sender.sendMessage(ChatColor.RED+"/bb store "+ChatColor.YELLOW+"- buy power-ups using your kill points!");
							sender.sendMessage(ChatColor.RED+"/bb setend "+ChatColor.YELLOW+"- set where players will teleport to when the game is over");
							sender.sendMessage(ChatColor.RED+"/bb leave "+ChatColor.YELLOW+"- leave the game");
							sender.sendMessage(ChatColor.GOLD+"==========[ Backbone Commands ]==========");
						}
						if(args[0].equalsIgnoreCase("setend")){
							if(sender.hasPermission("backbone.setend")){
							Player guy = (Player)sender;
							double spawnx = guy.getLocation().getX();
							double spawny = guy.getLocation().getY();
							double spawnz = guy.getLocation().getZ();
							this.getConfig().set("spawn.x", spawnx);
							this.getConfig().set("spawn.y", spawny);
							this.getConfig().set("spawn.z", spawnz);
							this.getConfig().set("spawn.world", guy.getWorld().getName());
							sender.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You set the game's endpoint!");
							this.saveConfig();
							}else{
								sender.sendMessage(ChatColor.DARK_RED+"You don't have permission!");
							}
						}
						if(args[0].equalsIgnoreCase("leave")){
							
							String name = sender.getName();
							if(this.getConfig().contains("players1."+name) || this.getConfig().contains("players2."+name) || this.getConfig().contains("players3."+name) || this.getConfig().contains("players4."+name) || this.getConfig().contains("players5."+name)){
							cc.removeFromGame(name);
							if(this.getConfig().contains("spawn.x")){
								double x = this.getConfig().getDouble("spawn.x");
								double y = this.getConfig().getDouble("spawn.y");
								double z = this.getConfig().getDouble("spawn.z");
								Player player = (Player)sender;
								String wn = this.getConfig().getString("spawn.world");
								World w = this.getServer().getWorld(wn);
								Location l = new Location(w,x,y,z);
								player.teleport(l);
								player.setLevel(0);	
								player.setFoodLevel(20);
								player.setHealth(20);
								player.sendMessage(ChatColor.GREEN+"You left the game! Thanks for playing!");
								
								api.setScoreboard(player);
								api.removePlayerFromTeam("Player", player);
								api.refreshPlayerScoreboard(player);
								api.removePlayerScoreboard(player);
								
								}else{
									sender.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.RED+"Missing end!");
								}
							}else{
								sender.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.RED+"You aren't playing!");
							}
						}
						if(args[0].equalsIgnoreCase("store")){
							if(sender.hasPermission("backbone.store")){
								storeCode sc = new storeCode(this);
								String name = sender.getName();
								if(this.getConfig().contains("players1."+name) || this.getConfig().contains("players2."+name) || this.getConfig().contains("players3."+name) || this.getConfig().contains("players4."+name) || this.getConfig().contains("players5."+name)){
									sc.giveMenu((Player)sender);
								}else{
									sender.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.RED+"You aren't playing!");
								}
							}else{
								sender.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.RED+"You don't have permission!");
							}
						}
					}else{
						sender.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.RED+"Invalid command / usage!");
					}
				}
				
				if(args.length==2){					
					if(args[0].equalsIgnoreCase("bspawn") || args[0].equalsIgnoreCase("rspawn") || args[0].equalsIgnoreCase("join") || args[0].equalsIgnoreCase("store") || args[0].equalsIgnoreCase("setreload")){
						if(args[0].equalsIgnoreCase("bspawn")){
							if(sender.hasPermission("backbone.bspawn")){
							String num = args[1];
							if(num.equals("1")){
							Player guy = (Player)sender;
							double bspawnx = guy.getLocation().getX();
							double bspawny = guy.getLocation().getY();
							double bspawnz = guy.getLocation().getZ();
							this.getConfig().set("bluespawn1.x", bspawnx);
							this.getConfig().set("bluespawn1.y", bspawny);
							this.getConfig().set("bluespawn1.z", bspawnz);
							this.getConfig().set("bluespawn1.world", guy.getWorld().getName());
							sender.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You set the Blue team's spawnpoint for arena 1!");
							this.saveConfig();
							}
							if(num.equals("2")){
							Player guy = (Player)sender;
							double bspawnx = guy.getLocation().getX();
							double bspawny = guy.getLocation().getY();
							double bspawnz = guy.getLocation().getZ();
							this.getConfig().set("bluespawn2.x", bspawnx);
							this.getConfig().set("bluespawn2.y", bspawny);
							this.getConfig().set("bluespawn2.z", bspawnz);
							this.getConfig().set("bluespawn2.world", guy.getWorld().getName());
							sender.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You set the Blue team's spawnpoint for arena 2!");
							this.saveConfig();
							}
							if(num.equals("3")){
							Player guy = (Player)sender;
							double bspawnx = guy.getLocation().getX();
							double bspawny = guy.getLocation().getY();
							double bspawnz = guy.getLocation().getZ();
							this.getConfig().set("bluespawn3.x", bspawnx);
							this.getConfig().set("bluespawn3.y", bspawny);
							this.getConfig().set("bluespawn3.z", bspawnz);
							this.getConfig().set("bluespawn3.world", guy.getWorld().getName());
							sender.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You set the Blue team's spawnpoint for arena 3!");
							this.saveConfig();
							}
							if(num.equals("4")){
							Player guy = (Player)sender;
							double bspawnx = guy.getLocation().getX();
							double bspawny = guy.getLocation().getY();
							double bspawnz = guy.getLocation().getZ();
							this.getConfig().set("bluespawn4.x", bspawnx);
							this.getConfig().set("bluespawn4.y", bspawny);
							this.getConfig().set("bluespawn4.z", bspawnz);
							this.getConfig().set("bluespawn4.world", guy.getWorld().getName());
							sender.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You set the Blue team's spawnpoint for arena 4!");
							this.saveConfig();
							}
							if(num.equals("5")){
							Player guy = (Player)sender;
							double bspawnx = guy.getLocation().getX();
							double bspawny = guy.getLocation().getY();
							double bspawnz = guy.getLocation().getZ();
							this.getConfig().set("bluespawn5.x", bspawnx);
							this.getConfig().set("bluespawn5.y", bspawny);
							this.getConfig().set("bluespawn5.z", bspawnz);
							this.getConfig().set("bluespawn5.world", guy.getWorld().getName());
							sender.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You set the Blue team's spawnpoint for arena 5!");
							this.saveConfig();
							}
							}
						}
						if(args[0].equalsIgnoreCase("rspawn")){
							if(sender.hasPermission("backbone.rspawn")){
							String num = args[1];
							if(num.equals("1")){
							Player guy = (Player)sender;
							double rspawnx = guy.getLocation().getX();
							double rspawny = guy.getLocation().getY();
							double rspawnz = guy.getLocation().getZ();
							this.getConfig().set("redspawn1.x", rspawnx);
							this.getConfig().set("redspawn1.y", rspawny);
							this.getConfig().set("redspawn1.z", rspawnz);
							this.getConfig().set("redspawn1.world", guy.getWorld().getName());
							sender.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You set the Red team's spawnpoint for arena 1!");
							this.saveConfig();
							}
							if(num.equals("2")){
							Player guy = (Player)sender;
							double rspawnx = guy.getLocation().getX();
							double rspawny = guy.getLocation().getY();
							double rspawnz = guy.getLocation().getZ();
							this.getConfig().set("redspawn2.x", rspawnx);
							this.getConfig().set("redspawn2.y", rspawny);
							this.getConfig().set("redspawn2.z", rspawnz);
							this.getConfig().set("redspawn2.world", guy.getWorld().getName());
							sender.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You set the Red team's spawnpoint for arena 2!");
							this.saveConfig();
							}
							if(num.equals("3")){
							Player guy = (Player)sender;
							double rspawnx = guy.getLocation().getX();
							double rspawny = guy.getLocation().getY();
							double rspawnz = guy.getLocation().getZ();
							this.getConfig().set("redspawn3.x", rspawnx);
							this.getConfig().set("redspawn3.y", rspawny);
							this.getConfig().set("redspawn3.z", rspawnz);
							this.getConfig().set("redspawn3.world", guy.getWorld().getName());
							sender.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You set the Red team's spawnpoint for arena 3!");
							this.saveConfig();
							}
							if(num.equals("4")){
							Player guy = (Player)sender;
							double rspawnx = guy.getLocation().getX();
							double rspawny = guy.getLocation().getY();
							double rspawnz = guy.getLocation().getZ();
							this.getConfig().set("redspawn4.x", rspawnx);
							this.getConfig().set("redspawn4.y", rspawny);
							this.getConfig().set("redspawn4.z", rspawnz);
							this.getConfig().set("redspawn4.world", guy.getWorld().getName());
							sender.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You set the Red team's spawnpoint for arena 4!");
							this.saveConfig();
							}
							if(num.equals("5")){
							Player guy = (Player)sender;
							double rspawnx = guy.getLocation().getX();
							double rspawny = guy.getLocation().getY();
							double rspawnz = guy.getLocation().getZ();
							this.getConfig().set("redspawn5.x", rspawnx);
							this.getConfig().set("redspawn5.y", rspawny);
							this.getConfig().set("redspawn5.z", rspawnz);
							this.getConfig().set("redspawn5.world", guy.getWorld().getName());
							sender.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"You set the Red team's spawnpoint for arena 5!");
							this.saveConfig();
							}
							}
						}
						if(args[0].equalsIgnoreCase("setreload")){
							if(sender.hasPermission("backbone.setreload")){
								String num = args[1];
								if(num.equals("1")){
								getServer().getPluginManager().registerEvents(new SetReload(this), this);
								sender.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"Right click the block you want to become the Reloading Station.");
								}
								if(num.equals("2")){
								getServer().getPluginManager().registerEvents(new SetReloadT(this), this);
								sender.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"Right click the block you want to become the Reloading Station.");
								}
								if(num.equals("3")){
								getServer().getPluginManager().registerEvents(new SetReloadTh(this), this);
								sender.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"Right click the block you want to become the Reloading Station.");
								}
								if(num.equals("4")){
								getServer().getPluginManager().registerEvents(new SetReloadFo(this), this);
								sender.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"Right click the block you want to become the Reloading Station.");
								}
								if(num.equals("5")){
								getServer().getPluginManager().registerEvents(new SetReloadFi(this), this);
								sender.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.GOLD+"Right click the block you want to become the Reloading Station.");
								}
							}
						}
						if(args[0].equalsIgnoreCase("store")){
							if(sender.hasPermission("backbone.store")){
								storeCode sc = new storeCode(this);
								sc.goShopping((Player)sender, args[1]);
							}
						}
						
						
						if(args[0].equalsIgnoreCase("join")){
							Player p = (Player)sender;							
							cc.joinGame((Player)sender, args[1]);
							
							if(args[1].equalsIgnoreCase("1")){
								api.createObjective("Arena_1", "Backbone");
								api.createTeam("Player");
								api.setScore(Bukkit.getOfflinePlayer(ChatColor.RED+"Red"), 0);
								api.setScore(Bukkit.getOfflinePlayer(ChatColor.BLUE+"Blue"), 0);
								api.addPlayerToTeam("Player", p);
								api.refreshPlayerScoreboard(p);
							}
							
							if(args[1].equalsIgnoreCase("2")){
								api.createObjective("Arena_2", "Backbone");
								api.createTeam("Player");
								api.setScore(Bukkit.getOfflinePlayer(ChatColor.RED+"Red"), 0);
								api.setScore(Bukkit.getOfflinePlayer(ChatColor.BLUE+"Blue"), 0);
								api.addPlayerToTeam("Player", p);
								api.refreshPlayerScoreboard(p);
							}
							
							if(args[1].equalsIgnoreCase("3")){
								api.createObjective("Arena_3", "Backbone");
								api.createTeam("Player");
								api.setScore(Bukkit.getOfflinePlayer(ChatColor.RED+"Red"), 0);
								api.setScore(Bukkit.getOfflinePlayer(ChatColor.BLUE+"Blue"), 0);
								api.addPlayerToTeam("Player", p);
								api.refreshPlayerScoreboard(p);
							}
							
							if(args[1].equalsIgnoreCase("4")){
								api.createObjective("Arena_4", "Backbone");
								api.createTeam("Player");
								api.setScore(Bukkit.getOfflinePlayer(ChatColor.RED+"Red"), 0);
								api.setScore(Bukkit.getOfflinePlayer(ChatColor.BLUE+"Blue"), 0);
								api.addPlayerToTeam("Player", p);
								api.refreshPlayerScoreboard(p);
							}
							
							if(args[1].equalsIgnoreCase("5")){
								api.createObjective("Arena_5", "Backbone");
								api.createTeam("Player");
								api.setScore(Bukkit.getOfflinePlayer(ChatColor.RED+"Red"), 0);
								api.setScore(Bukkit.getOfflinePlayer(ChatColor.BLUE+"Blue"), 0);
								api.addPlayerToTeam("Player", p);
								api.refreshPlayerScoreboard(p);
							}
						}
					}else{
						sender.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.RED+"Invalid command / usage!");
					}
				}
			}else{
				sender.sendMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.RED+"Sorry Console, you can't use minigame commands!");
			}
			return true;
		}
		return false;
	}
	
}
