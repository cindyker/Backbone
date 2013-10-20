package me.firebreath15.backbone;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.scheduler.BukkitTask;

public class coreCode
{
  main plugin;
  INVAPI api;

  coreCode(main c)
  {
    this.plugin = c;
  }

  public void initInvApi()
  {
    this.api = new INVAPI();
  }

  public void removeFromGame(String name) {
    if (this.plugin.getConfig().contains("rplist1." + name))
    {
      this.plugin.getConfig().set("rplist1." + name, null);
      this.plugin.getConfig().set("players1." + name, null);
      int np = this.plugin.getConfig().getInt("rplayers1");
      this.plugin.getConfig().set("rplayers1", Integer.valueOf(np - 1));
      this.plugin.saveConfig();
      this.plugin.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + name + " left the game.");
      this.api.restorePlayerArmor(name);
      this.api.restorePlayerInventory(name);
    }

    if (this.plugin.getConfig().contains("bplist1." + name))
    {
      this.plugin.getConfig().set("bplist1." + name, null);
      this.plugin.getConfig().set("players1." + name, null);
      int np = this.plugin.getConfig().getInt("bplayers1");
      this.plugin.getConfig().set("bplayers1", Integer.valueOf(np - 1));
      this.plugin.saveConfig();
      this.plugin.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + name + " left the game.");
      this.api.restorePlayerArmor(name);
      this.api.restorePlayerInventory(name);
    }

    if (this.plugin.getConfig().contains("rplist2." + name))
    {
      this.plugin.getConfig().set("rplist2." + name, null);
      this.plugin.getConfig().set("players2." + name, null);
      int np = this.plugin.getConfig().getInt("rplayers2");
      this.plugin.getConfig().set("rplayers2", Integer.valueOf(np - 1));
      this.plugin.saveConfig();
      this.plugin.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + name + " left the game.");
      this.api.restorePlayerArmor(name);
      this.api.restorePlayerInventory(name);
    }

    if (this.plugin.getConfig().contains("bplist2." + name))
    {
      this.plugin.getConfig().set("bplist2." + name, null);
      this.plugin.getConfig().set("players2." + name, null);
      int np = this.plugin.getConfig().getInt("bplayers2");
      this.plugin.getConfig().set("bplayers2", Integer.valueOf(np - 1));
      this.plugin.saveConfig();
      this.plugin.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + name + " left the game.");
      this.api.restorePlayerArmor(name);
      this.api.restorePlayerInventory(name);
    }

    if (this.plugin.getConfig().contains("rplist3." + name))
    {
      this.plugin.getConfig().set("rplist3." + name, null);
      this.plugin.getConfig().set("players3." + name, null);
      int np = this.plugin.getConfig().getInt("rplayers3");
      this.plugin.getConfig().set("rplayers3", Integer.valueOf(np - 1));
      this.plugin.saveConfig();
      this.plugin.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + name + " left the game.");
      this.api.restorePlayerArmor(name);
      this.api.restorePlayerInventory(name);
    }

    if (this.plugin.getConfig().contains("bplist3." + name))
    {
      this.plugin.getConfig().set("bplist3." + name, null);
      this.plugin.getConfig().set("players3." + name, null);
      int np = this.plugin.getConfig().getInt("bplayers3");
      this.plugin.getConfig().set("bplayers3", Integer.valueOf(np - 1));
      this.plugin.saveConfig();
      this.plugin.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + name + " left the game.");
      this.api.restorePlayerArmor(name);
      this.api.restorePlayerInventory(name);
    }

    if (this.plugin.getConfig().contains("rplist4." + name))
    {
      this.plugin.getConfig().set("rplist4." + name, null);
      this.plugin.getConfig().set("players4." + name, null);
      int np = this.plugin.getConfig().getInt("rplayers4");
      this.plugin.getConfig().set("rplayers4", Integer.valueOf(np - 1));
      this.plugin.saveConfig();
      this.plugin.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + name + " left the game.");
      this.api.restorePlayerArmor(name);
      this.api.restorePlayerInventory(name);
    }

    if (this.plugin.getConfig().contains("bplist4." + name))
    {
      this.plugin.getConfig().set("bplist4." + name, null);
      this.plugin.getConfig().set("players4." + name, null);
      int np = this.plugin.getConfig().getInt("bplayers4");
      this.plugin.getConfig().set("bplayers4", Integer.valueOf(np - 1));
      this.plugin.saveConfig();
      this.plugin.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + name + " left the game.");
      this.api.restorePlayerArmor(name);
      this.api.restorePlayerInventory(name);
    }

    if (this.plugin.getConfig().contains("rplist5." + name))
    {
      this.plugin.getConfig().set("rplist5." + name, null);
      this.plugin.getConfig().set("players5." + name, null);
      int np = this.plugin.getConfig().getInt("rplayers5");
      this.plugin.getConfig().set("rplayers5", Integer.valueOf(np - 1));
      this.plugin.saveConfig();
      this.plugin.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + name + " left the game.");
      this.api.restorePlayerArmor(name);
      this.api.restorePlayerInventory(name);
    }

    if (this.plugin.getConfig().contains("bplist5." + name))
    {
      this.plugin.getConfig().set("bplist5." + name, null);
      this.plugin.getConfig().set("players5." + name, null);
      int np = this.plugin.getConfig().getInt("bplayers5");
      this.plugin.getConfig().set("bplayers5", Integer.valueOf(np - 1));
      this.plugin.saveConfig();
      this.plugin.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + name + " left the game.");
      this.api.restorePlayerArmor(name);
      this.api.restorePlayerInventory(name);
    }
  }

  @SuppressWarnings({ "unused", "deprecation" })
public void joinGame(Player p, String a)
  {
    String num = a;
    Player rofl = p;
    rofl.setGameMode(GameMode.SURVIVAL);
    if (num.equals("1")) {
      if ((this.plugin.getConfig().contains("redspawn1.x")) && (this.plugin.getConfig().contains("bluespawn1.x")))
      {
        String lol = p.getName();
        if ((!this.plugin.getConfig().contains("players1." + lol)) && (!this.plugin.getConfig().contains("players2." + lol)) && (!this.plugin.getConfig().contains("players3." + lol)) && (!this.plugin.getConfig().contains("players4." + lol)) && (!this.plugin.getConfig().contains("players5." + lol))) {
          int bplayers = this.plugin.getConfig().getInt("bplayers1");
          int rplayers = this.plugin.getConfig().getInt("rplayers1");
          rofl.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + rofl.getName() + " joined arena 1!");
          if (bplayers >= rplayers) {
            Player guy = p;
            double x = this.plugin.getConfig().getDouble("redspawn1.x");
            double y = this.plugin.getConfig().getDouble("redspawn1.y");
            double z = this.plugin.getConfig().getDouble("redspawn1.z");
            String wn = this.plugin.getConfig().getString("redspawn1.world");
            World w = this.plugin.getServer().getWorld(wn);
            Location l = new Location(w, x, y, z);
            guy.teleport(l);
            int np = rplayers + 1;
            this.plugin.getConfig().set("rplayers1", Integer.valueOf(np));
            this.plugin.saveConfig();
            guy.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.RED + "You joined the red team!");
            String ggg = guy.getName();
            this.plugin.getConfig().createSection("rplist1." + ggg);
            this.plugin.getConfig().createSection("players1." + ggg);
            this.plugin.saveConfig();
            this.api.storePlayerInventory(guy.getName());
            this.api.storePlayerArmor(guy.getName());
            guy.setHealth(20d);
            guy.setFoodLevel(20);
            PlayerInventory inv = guy.getInventory();
            ItemStack brod = new ItemStack(Material.BLAZE_ROD, 1);
            ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
            ItemStack team = new ItemStack(Material.NETHERRACK);
            ItemMeta bim = brod.getItemMeta();
            ItemMeta sim = sword.getItemMeta();
            ItemMeta tim = team.getItemMeta();
            bim.setDisplayName(ChatColor.GOLD + "Snowball Gun");
            sim.setDisplayName(ChatColor.BLUE + "Close-Range Combat Sword");
            tim.setDisplayName(ChatColor.RED + "You are on the Red team");
            brod.setItemMeta(bim);
            sword.setItemMeta(sim);
            team.setItemMeta(tim);
            inv.addItem(new ItemStack[] { brod });
            inv.addItem(new ItemStack[] { sword });
            inv.addItem(new ItemStack[] { team });

            guy.setLevel(40);

            ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
            LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
            meta.setColor(Color.RED);
            helm.setItemMeta(meta);
            guy.getInventory().setHelmet(helm);

            ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
            LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
            metat.setColor(Color.RED);
            ches.setItemMeta(metat);
            guy.getInventory().setChestplate(ches);

            ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
            LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
            metatt.setColor(Color.RED);
            legg.setItemMeta(metatt);
            guy.getInventory().setLeggings(legg);

            ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
            metattt.setColor(Color.RED);
            boot.setItemMeta(metattt);
            guy.getInventory().setBoots(boot);
            guy.updateInventory();
          } else {
            Player guy = p;
            double x = this.plugin.getConfig().getDouble("bluespawn1.x");
            double y = this.plugin.getConfig().getDouble("bluespawn1.y");
            double z = this.plugin.getConfig().getDouble("bluespawn1.z");
            String wn = this.plugin.getConfig().getString("bluespawn1.world");
            World w = this.plugin.getServer().getWorld(wn);
            Location l = new Location(w, x, y, z);
            guy.teleport(l);
            int np = bplayers + 1;
            this.plugin.getConfig().set("bplayers1", Integer.valueOf(np));
            this.plugin.saveConfig();
            guy.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.BLUE + "You joined the blue team!");
            String ggg = guy.getName();
            this.plugin.getConfig().createSection("bplist1." + ggg);
            this.plugin.getConfig().createSection("players1." + ggg);
            this.plugin.saveConfig();

            int bp = this.plugin.getConfig().getInt("bplayers1");
            int rp = this.plugin.getConfig().getInt("rplayers1");
            int tplayers = bp + rp;
            if (tplayers == 2) {
              BukkitTask task = new A1Task(this.plugin).runTaskLater(this.plugin, 6000L);
              this.plugin.getServer().broadcastMessage(ChatColor.GOLD + "[Backbone] " + ChatColor.DARK_GREEN + "Game has begun in arena 1! This game will last 5 minutes!");
            }

            this.api.storePlayerInventory(guy.getName()); guy.setHealth(20d); guy.setFoodLevel(20);
            this.api.storePlayerArmor(guy.getName());
            PlayerInventory inv = guy.getInventory();
            ItemStack brod = new ItemStack(Material.BLAZE_ROD, 1);
            ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
            ItemStack team = new ItemStack(Material.LAPIS_BLOCK);
            ItemMeta bim = brod.getItemMeta();
            ItemMeta sim = sword.getItemMeta();
            ItemMeta tim = team.getItemMeta();
            bim.setDisplayName(ChatColor.GOLD + "Snowball Gun");
            sim.setDisplayName(ChatColor.BLUE + "Close-Range Combat Sword");
            tim.setDisplayName(ChatColor.AQUA + "You are on the Blue team");
            brod.setItemMeta(bim);
            sword.setItemMeta(sim);
            team.setItemMeta(tim);
            inv.addItem(new ItemStack[] { brod });
            inv.addItem(new ItemStack[] { sword });
            inv.addItem(new ItemStack[] { team });

            guy.setLevel(40);

            ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
            LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
            meta.setColor(Color.BLUE);
            helm.setItemMeta(meta);
            guy.getInventory().setHelmet(helm);

            ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
            LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
            metat.setColor(Color.BLUE);
            ches.setItemMeta(metat);
            guy.getInventory().setChestplate(ches);

            ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
            LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
            metatt.setColor(Color.BLUE);
            legg.setItemMeta(metatt);
            guy.getInventory().setLeggings(legg);

            ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
            metattt.setColor(Color.BLUE);
            boot.setItemMeta(metattt);
            guy.getInventory().setBoots(boot);

            guy.updateInventory();
          }
        }
        else {
          p.sendMessage(ChatColor.RED + "You're already in the game! To switch arenas, use /bb leave");
        }
      } else {
        p.sendMessage(ChatColor.RED + "Arena 1 hasn't been created yet!");
      }
    }
    if (num.equals("2")) {
      if ((this.plugin.getConfig().contains("redspawn2.x")) && (this.plugin.getConfig().contains("bluespawn2.x")))
      {
        String lol = p.getName();
        if ((!this.plugin.getConfig().contains("players1." + lol)) && (!this.plugin.getConfig().contains("players2." + lol)) && (!this.plugin.getConfig().contains("players3." + lol)) && (!this.plugin.getConfig().contains("players4." + lol)) && (!this.plugin.getConfig().contains("players5." + lol))) {
          int bplayers = this.plugin.getConfig().getInt("bplayers2");
          int rplayers = this.plugin.getConfig().getInt("rplayers2");
          rofl.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + rofl.getName() + " joined arena 2!");
          if (bplayers >= rplayers) {
            Player guy = p;
            double x = this.plugin.getConfig().getDouble("redspawn2.x");
            double y = this.plugin.getConfig().getDouble("redspawn2.y");
            double z = this.plugin.getConfig().getDouble("redspawn2.z");
            String wn = this.plugin.getConfig().getString("redspawn2.world");
            World w = this.plugin.getServer().getWorld(wn);
            Location l = new Location(w, x, y, z);
            guy.teleport(l);
            int np = rplayers + 1;
            this.plugin.getConfig().set("rplayers2", Integer.valueOf(np));
            this.plugin.saveConfig();
            guy.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.RED + "You joined the red team!");
            String ggg = guy.getName();
            this.plugin.getConfig().createSection("rplist2." + ggg);
            this.plugin.getConfig().createSection("players2." + ggg);
            this.plugin.saveConfig();
            this.api.storePlayerInventory(guy.getName()); guy.setHealth(20d); guy.setFoodLevel(20);
            this.api.storePlayerArmor(guy.getName());
            PlayerInventory inv = guy.getInventory();
            ItemStack brod = new ItemStack(Material.BLAZE_ROD, 1);
            ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
            ItemStack team = new ItemStack(Material.NETHERRACK);
            ItemMeta bim = brod.getItemMeta();
            ItemMeta sim = sword.getItemMeta();
            ItemMeta tim = team.getItemMeta();
            bim.setDisplayName(ChatColor.GOLD + "Snowball Gun");
            sim.setDisplayName(ChatColor.BLUE + "Close-Range Combat Sword");
            tim.setDisplayName(ChatColor.RED + "You are on the Red team");
            brod.setItemMeta(bim);
            sword.setItemMeta(sim);
            team.setItemMeta(tim);
            inv.addItem(new ItemStack[] { brod });
            inv.addItem(new ItemStack[] { sword });
            inv.addItem(new ItemStack[] { team });

            guy.setLevel(40);

            ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
            LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
            meta.setColor(Color.RED);
            helm.setItemMeta(meta);
            guy.getInventory().setHelmet(helm);

            ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
            LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
            metat.setColor(Color.RED);
            ches.setItemMeta(metat);
            guy.getInventory().setChestplate(ches);

            ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
            LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
            metatt.setColor(Color.RED);
            legg.setItemMeta(metatt);
            guy.getInventory().setLeggings(legg);

            ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
            metattt.setColor(Color.RED);
            boot.setItemMeta(metattt);
            guy.getInventory().setBoots(boot);

            guy.updateInventory();
          } else {
            Player guy = p;
            double x = this.plugin.getConfig().getDouble("bluespawn2.x");
            double y = this.plugin.getConfig().getDouble("bluespawn2.y");
            double z = this.plugin.getConfig().getDouble("bluespawn2.z");
            String wn = this.plugin.getConfig().getString("bluespawn2.world");
            World w = this.plugin.getServer().getWorld(wn);
            Location l = new Location(w, x, y, z);
            guy.teleport(l);
            int np = bplayers + 1;
            this.plugin.getConfig().set("bplayers2", Integer.valueOf(np));
            this.plugin.saveConfig();
            guy.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.BLUE + "You joined the blue team!");
            String ggg = guy.getName();
            this.plugin.getConfig().createSection("bplist2." + ggg);
            this.plugin.getConfig().createSection("players2." + ggg);
            this.plugin.saveConfig();

            int bp = this.plugin.getConfig().getInt("bplayers2");
            int rp = this.plugin.getConfig().getInt("rplayers2");
            int tplayers = bp + rp;
            if (tplayers == 2) {
              BukkitTask task = new A2Task(this.plugin).runTaskLater(this.plugin, 6000L);
              this.plugin.getServer().broadcastMessage(ChatColor.GOLD + "[Backbone] " + ChatColor.DARK_GREEN + "Game has begun in arena 2! This game will last 5 minutes!");
            }

            this.api.storePlayerInventory(guy.getName()); guy.setHealth(20d); guy.setFoodLevel(20);
            this.api.storePlayerArmor(guy.getName());
            PlayerInventory inv = guy.getInventory();
            ItemStack brod = new ItemStack(Material.BLAZE_ROD, 1);
            ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
            ItemStack team = new ItemStack(Material.LAPIS_BLOCK);
            ItemMeta bim = brod.getItemMeta();
            ItemMeta sim = sword.getItemMeta();
            ItemMeta tim = team.getItemMeta();
            bim.setDisplayName(ChatColor.GOLD + "Snowball Gun");
            sim.setDisplayName(ChatColor.BLUE + "Close-Range Combat Sword");
            tim.setDisplayName(ChatColor.AQUA + "You are on the Blue team");
            brod.setItemMeta(bim);
            sword.setItemMeta(sim);
            team.setItemMeta(tim);
            inv.addItem(new ItemStack[] { brod });
            inv.addItem(new ItemStack[] { sword });
            inv.addItem(new ItemStack[] { team });

            guy.setLevel(40);

            ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
            LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
            meta.setColor(Color.BLUE);
            helm.setItemMeta(meta);
            guy.getInventory().setHelmet(helm);

            ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
            LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
            metat.setColor(Color.BLUE);
            ches.setItemMeta(metat);
            guy.getInventory().setChestplate(ches);

            ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
            LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
            metatt.setColor(Color.BLUE);
            legg.setItemMeta(metatt);
            guy.getInventory().setLeggings(legg);

            ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
            metattt.setColor(Color.BLUE);
            boot.setItemMeta(metattt);
            guy.getInventory().setBoots(boot);

            guy.updateInventory();
          }
        } else {
          p.sendMessage(ChatColor.RED + "You're already in the game! To switch arenas, use /bb leave");
        }
      } else {
        p.sendMessage(ChatColor.RED + "Arena 2 hasn't been created yet!");
      }
    }

    if (num.equals("3")) {
      if ((this.plugin.getConfig().contains("redspawn3.x")) && (this.plugin.getConfig().contains("bluespawn3.x")))
      {
        String lol = p.getName();
        if ((!this.plugin.getConfig().contains("players1." + lol)) && (!this.plugin.getConfig().contains("players2." + lol)) && (!this.plugin.getConfig().contains("players3." + lol)) && (!this.plugin.getConfig().contains("players4." + lol)) && (!this.plugin.getConfig().contains("players5." + lol))) {
          int bplayers = this.plugin.getConfig().getInt("bplayers3");
          int rplayers = this.plugin.getConfig().getInt("rplayers3");
          rofl.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + rofl.getName() + " joined arena 3!");
          if (bplayers >= rplayers) {
            Player guy = p;
            double x = this.plugin.getConfig().getDouble("redspawn3.x");
            double y = this.plugin.getConfig().getDouble("redspawn3.y");
            double z = this.plugin.getConfig().getDouble("redspawn3.z");
            String wn = this.plugin.getConfig().getString("redspawn3.world");
            World w = this.plugin.getServer().getWorld(wn);
            Location l = new Location(w, x, y, z);
            guy.teleport(l);
            int np = rplayers + 1;
            this.plugin.getConfig().set("rplayers3", Integer.valueOf(np));
            this.plugin.saveConfig();
            guy.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.RED + "You joined the red team!");
            String ggg = guy.getName();
            this.plugin.getConfig().createSection("rplist3." + ggg);
            this.plugin.getConfig().createSection("players3." + ggg);
            this.plugin.saveConfig();
            this.api.storePlayerInventory(guy.getName()); guy.setHealth(20d); guy.setFoodLevel(20);
            this.api.storePlayerArmor(guy.getName());
            PlayerInventory inv = guy.getInventory();
            ItemStack brod = new ItemStack(Material.BLAZE_ROD, 1);
            ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
            ItemStack team = new ItemStack(Material.NETHERRACK);
            ItemMeta bim = brod.getItemMeta();
            ItemMeta sim = sword.getItemMeta();
            ItemMeta tim = team.getItemMeta();
            bim.setDisplayName(ChatColor.GOLD + "Snowball Gun");
            sim.setDisplayName(ChatColor.BLUE + "Close-Range Combat Sword");
            tim.setDisplayName(ChatColor.RED + "You are on the Red team");
            brod.setItemMeta(bim);
            sword.setItemMeta(sim);
            team.setItemMeta(tim);
            inv.addItem(new ItemStack[] { brod });
            inv.addItem(new ItemStack[] { sword });
            inv.addItem(new ItemStack[] { team });

            guy.setLevel(40);

            ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
            LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
            meta.setColor(Color.RED);
            helm.setItemMeta(meta);
            guy.getInventory().setHelmet(helm);

            ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
            LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
            metat.setColor(Color.RED);
            ches.setItemMeta(metat);
            guy.getInventory().setChestplate(ches);

            ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
            LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
            metatt.setColor(Color.RED);
            legg.setItemMeta(metatt);
            guy.getInventory().setLeggings(legg);

            ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
            metattt.setColor(Color.RED);
            boot.setItemMeta(metattt);
            guy.getInventory().setBoots(boot);

            guy.updateInventory();
          } else {
            Player guy = p;
            double x = this.plugin.getConfig().getDouble("bluespawn3.x");
            double y = this.plugin.getConfig().getDouble("bluespawn3.y");
            double z = this.plugin.getConfig().getDouble("bluespawn3.z");
            String wn = this.plugin.getConfig().getString("bluespawn3.world");
            World w = this.plugin.getServer().getWorld(wn);
            Location l = new Location(w, x, y, z);
            guy.teleport(l);
            int np = bplayers + 1;
            this.plugin.getConfig().set("bplayers3", Integer.valueOf(np));
            this.plugin.saveConfig();
            guy.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.BLUE + "You joined the blue team!");
            String ggg = guy.getName();
            this.plugin.getConfig().createSection("bplist3." + ggg);
            this.plugin.getConfig().createSection("players3." + ggg);
            this.plugin.saveConfig();

            int bp = this.plugin.getConfig().getInt("bplayers3");
            int rp = this.plugin.getConfig().getInt("rplayers3");
            int tplayers = bp + rp;
            if (tplayers == 2) {
              BukkitTask task = new A3Task(this.plugin).runTaskLater(this.plugin, 6000L);
              this.plugin.getServer().broadcastMessage(ChatColor.GOLD + "[Backbone] " + ChatColor.DARK_GREEN + "Game has begun in arena 3! This game will last 5 minutes!");
            }

            this.api.storePlayerInventory(guy.getName()); guy.setHealth(20d); guy.setFoodLevel(20);
            this.api.storePlayerArmor(guy.getName());
            PlayerInventory inv = guy.getInventory();
            ItemStack brod = new ItemStack(Material.BLAZE_ROD, 1);
            ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
            ItemStack team = new ItemStack(Material.LAPIS_BLOCK);
            ItemMeta bim = brod.getItemMeta();
            ItemMeta sim = sword.getItemMeta();
            ItemMeta tim = team.getItemMeta();
            bim.setDisplayName(ChatColor.GOLD + "Snowball Gun");
            sim.setDisplayName(ChatColor.BLUE + "Close-Range Combat Sword");
            tim.setDisplayName(ChatColor.AQUA + "You are on the Blue team");
            brod.setItemMeta(bim);
            sword.setItemMeta(sim);
            team.setItemMeta(tim);
            inv.addItem(new ItemStack[] { brod });
            inv.addItem(new ItemStack[] { sword });
            inv.addItem(new ItemStack[] { team });

            guy.setLevel(40);

            ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
            LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
            meta.setColor(Color.BLUE);
            helm.setItemMeta(meta);
            guy.getInventory().setHelmet(helm);

            ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
            LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
            metat.setColor(Color.BLUE);
            ches.setItemMeta(metat);
            guy.getInventory().setChestplate(ches);

            ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
            LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
            metatt.setColor(Color.BLUE);
            legg.setItemMeta(metatt);
            guy.getInventory().setLeggings(legg);

            ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
            metattt.setColor(Color.BLUE);
            boot.setItemMeta(metattt);
            guy.getInventory().setBoots(boot);

            guy.updateInventory();
          }
        } else {
          p.sendMessage(ChatColor.RED + "You're already in the game! To switch arenas, use /bb leave");
        }
      } else {
        p.sendMessage(ChatColor.RED + "Arena 3 hasn't been created yet!");
      }
    }

    if (num.equals("4")) {
      if ((this.plugin.getConfig().contains("redspawn4.x")) && (this.plugin.getConfig().contains("bluespawn4.x")))
      {
        String lol = p.getName();
        if ((!this.plugin.getConfig().contains("players1." + lol)) && (!this.plugin.getConfig().contains("players2." + lol)) && (!this.plugin.getConfig().contains("players3." + lol)) && (!this.plugin.getConfig().contains("players4." + lol)) && (!this.plugin.getConfig().contains("players5." + lol))) {
          int bplayers = this.plugin.getConfig().getInt("bplayers4");
          int rplayers = this.plugin.getConfig().getInt("rplayers4");
          rofl.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + rofl.getName() + " joined arena 4!");
          if (bplayers >= rplayers) {
            Player guy = p;
            double x = this.plugin.getConfig().getDouble("redspawn4.x");
            double y = this.plugin.getConfig().getDouble("redspawn4.y");
            double z = this.plugin.getConfig().getDouble("redspawn4.z");
            String wn = this.plugin.getConfig().getString("redspawn4.world");
            World w = this.plugin.getServer().getWorld(wn);
            Location l = new Location(w, x, y, z);
            guy.teleport(l);
            int np = rplayers + 1;
            this.plugin.getConfig().set("rplayers4", Integer.valueOf(np));
            this.plugin.saveConfig();
            guy.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.RED + "You joined the red team!");
            String ggg = guy.getName();
            this.plugin.getConfig().createSection("rplist4." + ggg);
            this.plugin.getConfig().createSection("players4." + ggg);
            this.plugin.saveConfig();
            this.api.storePlayerInventory(guy.getName()); guy.setHealth(20d); guy.setFoodLevel(20);
            this.api.storePlayerArmor(guy.getName());
            PlayerInventory inv = guy.getInventory();
            ItemStack brod = new ItemStack(Material.BLAZE_ROD, 1);
            ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
            ItemStack team = new ItemStack(Material.NETHERRACK);
            ItemMeta bim = brod.getItemMeta();
            ItemMeta sim = sword.getItemMeta();
            ItemMeta tim = team.getItemMeta();
            bim.setDisplayName(ChatColor.GOLD + "Snowball Gun");
            sim.setDisplayName(ChatColor.BLUE + "Close-Range Combat Sword");
            tim.setDisplayName(ChatColor.RED + "You are on the Red team");
            brod.setItemMeta(bim);
            sword.setItemMeta(sim);
            team.setItemMeta(tim);
            inv.addItem(new ItemStack[] { brod });
            inv.addItem(new ItemStack[] { sword });
            inv.addItem(new ItemStack[] { team });

            guy.setLevel(40);

            ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
            LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
            meta.setColor(Color.RED);
            helm.setItemMeta(meta);
            guy.getInventory().setHelmet(helm);

            ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
            LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
            metat.setColor(Color.RED);
            ches.setItemMeta(metat);
            guy.getInventory().setChestplate(ches);

            ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
            LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
            metatt.setColor(Color.RED);
            legg.setItemMeta(metatt);
            guy.getInventory().setLeggings(legg);

            ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
            metattt.setColor(Color.RED);
            boot.setItemMeta(metattt);
            guy.getInventory().setBoots(boot);

            guy.updateInventory();
          } else {
            Player guy = p;
            double x = this.plugin.getConfig().getDouble("bluespawn4.x");
            double y = this.plugin.getConfig().getDouble("bluespawn4.y");
            double z = this.plugin.getConfig().getDouble("bluespawn4.z");
            String wn = this.plugin.getConfig().getString("bluespawn4.world");
            World w = this.plugin.getServer().getWorld(wn);
            Location l = new Location(w, x, y, z);
            guy.teleport(l);
            int np = bplayers + 1;
            this.plugin.getConfig().set("bplayers4", Integer.valueOf(np));
            this.plugin.saveConfig();
            guy.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.BLUE + "You joined the blue team!");
            String ggg = guy.getName();
            this.plugin.getConfig().createSection("bplist4." + ggg);
            this.plugin.getConfig().createSection("players4." + ggg);
            this.plugin.saveConfig();

            int bp = this.plugin.getConfig().getInt("bplayers4");
            int rp = this.plugin.getConfig().getInt("rplayers4");
            int tplayers = bp + rp;
            if (tplayers == 2) {
              BukkitTask task = new A4Task(this.plugin).runTaskLater(this.plugin, 6000L);
              this.plugin.getServer().broadcastMessage(ChatColor.GOLD + "[Backbone] " + ChatColor.DARK_GREEN + "Game has begun in arena 4! This game will last 5 minutes!");
            }

            this.api.storePlayerInventory(guy.getName()); guy.setHealth(20d); guy.setFoodLevel(20);
            this.api.storePlayerArmor(guy.getName());
            PlayerInventory inv = guy.getInventory();
            ItemStack brod = new ItemStack(Material.BLAZE_ROD, 1);
            ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
            ItemStack team = new ItemStack(Material.LAPIS_BLOCK);
            ItemMeta bim = brod.getItemMeta();
            ItemMeta sim = sword.getItemMeta();
            ItemMeta tim = team.getItemMeta();
            bim.setDisplayName(ChatColor.GOLD + "Snowball Gun");
            sim.setDisplayName(ChatColor.BLUE + "Close-Range Combat Sword");
            tim.setDisplayName(ChatColor.AQUA + "You are on the Blue team");
            brod.setItemMeta(bim);
            sword.setItemMeta(sim);
            team.setItemMeta(tim);
            inv.addItem(new ItemStack[] { brod });
            inv.addItem(new ItemStack[] { sword });
            inv.addItem(new ItemStack[] { team });

            guy.setLevel(40);

            ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
            LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
            meta.setColor(Color.BLUE);
            helm.setItemMeta(meta);
            guy.getInventory().setHelmet(helm);

            ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
            LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
            metat.setColor(Color.BLUE);
            ches.setItemMeta(metat);
            guy.getInventory().setChestplate(ches);

            ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
            LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
            metatt.setColor(Color.BLUE);
            legg.setItemMeta(metatt);
            guy.getInventory().setLeggings(legg);

            ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
            metattt.setColor(Color.BLUE);
            boot.setItemMeta(metattt);
            guy.getInventory().setBoots(boot);

            guy.updateInventory();
          }
        } else {
          p.sendMessage(ChatColor.RED + "You're already in the game! To switch arenas, use /bb leave");
        }
      } else {
        p.sendMessage(ChatColor.RED + "Arena 4 hasn't been created yet!");
      }
    }

    if (num.equals("5"))
      if ((this.plugin.getConfig().contains("redspawn5.x")) && (this.plugin.getConfig().contains("bluespawn5.x")))
      {
        String lol = p.getName();
        if ((!this.plugin.getConfig().contains("players1." + lol)) && (!this.plugin.getConfig().contains("players2." + lol)) && (!this.plugin.getConfig().contains("players3." + lol)) && (!this.plugin.getConfig().contains("players4." + lol)) && (!this.plugin.getConfig().contains("players5." + lol))) {
          int bplayers = this.plugin.getConfig().getInt("bplayers5");
          int rplayers = this.plugin.getConfig().getInt("rplayers5");
          rofl.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + rofl.getName() + " joined arena 5!");
          if (bplayers >= rplayers) {
            Player guy = p;
            double x = this.plugin.getConfig().getDouble("redspawn5.x");
            double y = this.plugin.getConfig().getDouble("redspawn5.y");
            double z = this.plugin.getConfig().getDouble("redspawn5.z");
            String wn = this.plugin.getConfig().getString("redspawn5.world");
            World w = this.plugin.getServer().getWorld(wn);
            Location l = new Location(w, x, y, z);
            guy.teleport(l);
            int np = rplayers + 1;
            this.plugin.getConfig().set("rplayers5", Integer.valueOf(np));
            this.plugin.saveConfig();
            guy.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.RED + "You joined the red team!");
            String ggg = guy.getName();
            this.plugin.getConfig().createSection("rplist5." + ggg);
            this.plugin.getConfig().createSection("players5." + ggg);
            this.plugin.saveConfig();
            this.api.storePlayerInventory(guy.getName()); guy.setHealth(20d); guy.setFoodLevel(20);
            this.api.storePlayerArmor(guy.getName());
            PlayerInventory inv = guy.getInventory();
            ItemStack brod = new ItemStack(Material.BLAZE_ROD, 1);
            ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
            ItemStack team = new ItemStack(Material.NETHERRACK);
            ItemMeta bim = brod.getItemMeta();
            ItemMeta sim = sword.getItemMeta();
            ItemMeta tim = team.getItemMeta();
            bim.setDisplayName(ChatColor.GOLD + "Snowball Gun");
            sim.setDisplayName(ChatColor.BLUE + "Close-Range Combat Sword");
            tim.setDisplayName(ChatColor.RED + "You are on the Red team");
            brod.setItemMeta(bim);
            sword.setItemMeta(sim);
            team.setItemMeta(tim);
            inv.addItem(new ItemStack[] { brod });
            inv.addItem(new ItemStack[] { sword });
            inv.addItem(new ItemStack[] { team });

            guy.setLevel(40);

            ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
            LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
            meta.setColor(Color.RED);
            helm.setItemMeta(meta);
            guy.getInventory().setHelmet(helm);

            ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
            LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
            metat.setColor(Color.RED);
            ches.setItemMeta(metat);
            guy.getInventory().setChestplate(ches);

            ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
            LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
            metatt.setColor(Color.RED);
            legg.setItemMeta(metatt);
            guy.getInventory().setLeggings(legg);

            ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
            metattt.setColor(Color.RED);
            boot.setItemMeta(metattt);
            guy.getInventory().setBoots(boot);

            guy.updateInventory();
          } else {
            Player guy = p;
            double x = this.plugin.getConfig().getDouble("bluespawn5.x");
            double y = this.plugin.getConfig().getDouble("bluespawn5.y");
            double z = this.plugin.getConfig().getDouble("bluespawn5.z");
            String wn = this.plugin.getConfig().getString("bluespawn5.world");
            World w = this.plugin.getServer().getWorld(wn);
            Location l = new Location(w, x, y, z);
            guy.teleport(l);
            int np = bplayers + 1;
            this.plugin.getConfig().set("bplayers5", Integer.valueOf(np));
            this.plugin.saveConfig();
            guy.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.BLUE + "You joined the blue team!");
            String ggg = guy.getName();
            this.plugin.getConfig().createSection("bplist5." + ggg);
            this.plugin.getConfig().createSection("players5." + ggg);
            this.plugin.saveConfig();

            int bp = this.plugin.getConfig().getInt("bplayers5");
            int rp = this.plugin.getConfig().getInt("rplayers5");
            int tplayers = bp + rp;
            if (tplayers == 2) {
              BukkitTask task = new A5Task(this.plugin).runTaskLater(this.plugin, 6000L);
              this.plugin.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "Game has begun in arena 5! This game will last 5 minutes!");
            }

            this.api.storePlayerInventory(guy.getName()); guy.setHealth(20d); guy.setFoodLevel(20);
            this.api.storePlayerArmor(guy.getName());
            PlayerInventory inv = guy.getInventory();
            ItemStack brod = new ItemStack(Material.BLAZE_ROD, 1);
            ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
            ItemStack team = new ItemStack(Material.LAPIS_BLOCK);
            ItemMeta bim = brod.getItemMeta();
            ItemMeta sim = sword.getItemMeta();
            ItemMeta tim = team.getItemMeta();
            bim.setDisplayName(ChatColor.GOLD + "Snowball Gun");
            sim.setDisplayName(ChatColor.BLUE + "Close-Range Combat Sword");
            tim.setDisplayName(ChatColor.AQUA + "You are on the Blue team");
            brod.setItemMeta(bim);
            sword.setItemMeta(sim);
            team.setItemMeta(tim);
            inv.addItem(new ItemStack[] { brod });
            inv.addItem(new ItemStack[] { sword });
            inv.addItem(new ItemStack[] { team });

            guy.setLevel(40);

            ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
            LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
            meta.setColor(Color.BLUE);
            helm.setItemMeta(meta);
            guy.getInventory().setHelmet(helm);

            ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
            LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
            metat.setColor(Color.BLUE);
            ches.setItemMeta(metat);
            guy.getInventory().setChestplate(ches);

            ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
            LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
            metatt.setColor(Color.BLUE);
            legg.setItemMeta(metatt);
            guy.getInventory().setLeggings(legg);

            ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
            metattt.setColor(Color.BLUE);
            boot.setItemMeta(metattt);
            guy.getInventory().setBoots(boot);

            guy.updateInventory();
          }
        } else {
          p.sendMessage(ChatColor.RED + "You're already in the game! To switch arenas, use /bb leave");
        }
      } else {
        p.sendMessage(ChatColor.RED + "Arena 5 hasn't been created yet!");
      }
  }
}