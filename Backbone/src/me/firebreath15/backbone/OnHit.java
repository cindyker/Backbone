package me.firebreath15.backbone;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class OnHit
  implements Listener
{
  main plugin;
  ISCOREAPI api = new ISCOREAPI();

  OnHit(main c)
  {
    this.plugin = c;
  }

  @EventHandler
  public void onSnowballFight(EntityDamageByEntityEvent e)
  {
    Entity damager = e.getDamager();
    Entity victim = e.getEntity();
    World w = e.getEntity().getWorld();
    if (((victim instanceof Player)) && ((damager instanceof Snowball))) {
      Player v = (Player)victim;
      Snowball sb = (Snowball)damager;
      Player k = (Player)sb.getShooter();
      String kn = k.getName();
      String vn = v.getName();
      if ((this.plugin.getConfig().contains("players1." + vn)) || (this.plugin.getConfig().contains("players2." + vn)) || (this.plugin.getConfig().contains("players3." + vn)) || (this.plugin.getConfig().contains("players4." + vn)) || (this.plugin.getConfig().contains("players5." + vn))) {
        if ((this.plugin.getConfig().contains("rplist1." + vn)) || (this.plugin.getConfig().contains("rplist2." + vn)) || (this.plugin.getConfig().contains("rplist3." + vn)) || (this.plugin.getConfig().contains("rplist4." + vn)) || (this.plugin.getConfig().contains("rplist5." + vn))) {
          if ((this.plugin.getConfig().contains("bplist1." + kn)) || (this.plugin.getConfig().contains("bplist2." + kn)) || (this.plugin.getConfig().contains("bplist3." + kn)) || (this.plugin.getConfig().contains("bplist4." + kn)) || (this.plugin.getConfig().contains("bplist5." + kn)))
          {
            Damageable dv = v;
            if (dv.getHealth() >= 3.0D) {
              e.setDamage(2d);
            }
            else {
              if (this.plugin.getConfig().contains("rplist1." + vn))
              {
                Player[] online = Bukkit.getServer().getOnlinePlayers();
                for (int i = 0; i < online.length; i++) {
                  Player p = online[i];
                  if ((this.plugin.getConfig().contains("rplist1." + p.getName())) || (this.plugin.getConfig().contains("bplist1." + p.getName()))) {
                    this.api.setScoreboard(p);
                    int sc = this.api.getScores(Bukkit.getOfflinePlayer(ChatColor.BLUE + "Blue"));
                    this.api.setScore(Bukkit.getOfflinePlayer(ChatColor.BLUE + "Blue"), sc + 1);
                  }
                }

                double x = this.plugin.getConfig().getDouble("redspawn1.x");
                double y = this.plugin.getConfig().getDouble("redspawn1.y");
                double z = this.plugin.getConfig().getDouble("redspawn1.z");
                Location l = new Location(w, x, y, z);
                Firework firework = (Firework)v.getWorld().spawn(v.getLocation(), Firework.class);
                FireworkMeta data = firework.getFireworkMeta();
                data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
                data.setPower(0);
                firework.setFireworkMeta(data);
                v.teleport(l);
                ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
                LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
                meta.setColor(Color.RED);
                helm.setItemMeta(meta);
                v.getInventory().setHelmet(helm);

                ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
                metat.setColor(Color.RED);
                ches.setItemMeta(metat);
                v.getInventory().setChestplate(ches);

                ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
                metatt.setColor(Color.RED);
                legg.setItemMeta(metatt);
                v.getInventory().setLeggings(legg);

                ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
                metattt.setColor(Color.RED);
                boot.setItemMeta(metattt);
                v.getInventory().setBoots(boot);
                v.setLevel(40);
                v.setHealth(20d);
                v.setFoodLevel(20);
                k.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You killed " + ChatColor.RED + vn + ChatColor.GOLD + "! " + ChatColor.DARK_PURPLE + "+100");
                v.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You were killed by " + ChatColor.RED + kn);
                if (this.plugin.getConfig().contains(kn)) {
                  int pts = this.plugin.getConfig().getInt(kn);
                  this.plugin.getConfig().set(kn, Integer.valueOf(pts + 100));
                  this.plugin.saveConfig();
                } else {
                  this.plugin.getConfig().set(kn, Integer.valueOf(100));
                  this.plugin.saveConfig();
                }
                int kpoints = this.plugin.getConfig().getInt("bpoints1");
                this.plugin.getConfig().set("bpoints1", Integer.valueOf(kpoints + 1));
              }

              if (this.plugin.getConfig().contains("rplist2." + vn))
              {
                Player[] online = Bukkit.getServer().getOnlinePlayers();
                for (int i = 0; i < online.length; i++) {
                  Player p = online[i];
                  if ((this.plugin.getConfig().contains("rplist2." + p.getName())) || (this.plugin.getConfig().contains("bplist2." + p.getName()))) {
                    this.api.setScoreboard(p);
                    int sc = this.api.getScores(Bukkit.getOfflinePlayer(ChatColor.BLUE + "Blue"));
                    this.api.setScore(Bukkit.getOfflinePlayer(ChatColor.BLUE + "Blue"), sc + 1);
                  }
                }

                double x = this.plugin.getConfig().getDouble("redspawn2.x");
                double y = this.plugin.getConfig().getDouble("redspawn2.y");
                double z = this.plugin.getConfig().getDouble("redspawn2.z");
                Location l = new Location(w, x, y, z);
                Firework firework = (Firework)v.getWorld().spawn(v.getLocation(), Firework.class);
                FireworkMeta data = firework.getFireworkMeta();
                data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
                data.setPower(0);
                firework.setFireworkMeta(data);
                v.teleport(l);
                ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
                LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
                meta.setColor(Color.RED);
                helm.setItemMeta(meta);
                v.getInventory().setHelmet(helm);

                ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
                metat.setColor(Color.RED);
                ches.setItemMeta(metat);
                v.getInventory().setChestplate(ches);

                ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
                metatt.setColor(Color.RED);
                legg.setItemMeta(metatt);
                v.getInventory().setLeggings(legg);

                ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
                metattt.setColor(Color.RED);
                boot.setItemMeta(metattt);
                v.getInventory().setBoots(boot);
                v.setLevel(40);
                v.setHealth(20d);
                v.setFoodLevel(20);
                k.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You killed " + ChatColor.RED + vn + ChatColor.GOLD + "! " + ChatColor.DARK_PURPLE + "+100");
                v.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You were killed by " + ChatColor.RED + kn);
                if (this.plugin.getConfig().contains(kn)) {
                  int pts = this.plugin.getConfig().getInt(kn);
                  this.plugin.getConfig().set(kn, Integer.valueOf(pts + 100));
                  this.plugin.saveConfig();
                } else {
                  this.plugin.getConfig().set(kn, Integer.valueOf(100));
                  this.plugin.saveConfig();
                }
                int kpoints = this.plugin.getConfig().getInt("bpoints2");
                this.plugin.getConfig().set("bpoints2", Integer.valueOf(kpoints + 1));
              }

              if (this.plugin.getConfig().contains("rplist3." + vn))
              {
                Player[] online = Bukkit.getServer().getOnlinePlayers();
                for (int i = 0; i < online.length; i++) {
                  Player p = online[i];
                  if ((this.plugin.getConfig().contains("rplist3." + p.getName())) || (this.plugin.getConfig().contains("bplist3." + p.getName()))) {
                    this.api.setScoreboard(p);
                    int sc = this.api.getScores(Bukkit.getOfflinePlayer(ChatColor.BLUE + "Blue"));
                    this.api.setScore(Bukkit.getOfflinePlayer(ChatColor.BLUE + "Blue"), sc + 1);
                  }
                }

                double x = this.plugin.getConfig().getDouble("redspawn3.x");
                double y = this.plugin.getConfig().getDouble("redspawn3.y");
                double z = this.plugin.getConfig().getDouble("redspawn3.z");
                Location l = new Location(w, x, y, z);
                Firework firework = (Firework)v.getWorld().spawn(v.getLocation(), Firework.class);
                FireworkMeta data = firework.getFireworkMeta();
                data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
                data.setPower(0);
                firework.setFireworkMeta(data);
                v.teleport(l);
                ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
                LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
                meta.setColor(Color.RED);
                helm.setItemMeta(meta);
                v.getInventory().setHelmet(helm);

                ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
                metat.setColor(Color.RED);
                ches.setItemMeta(metat);
                v.getInventory().setChestplate(ches);

                ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
                metatt.setColor(Color.RED);
                legg.setItemMeta(metatt);
                v.getInventory().setLeggings(legg);

                ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
                metattt.setColor(Color.RED);
                boot.setItemMeta(metattt);
                v.getInventory().setBoots(boot);
                v.setLevel(40);
                v.setHealth(20d);
                v.setFoodLevel(20);
                k.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You killed " + ChatColor.RED + vn + ChatColor.GOLD + "! " + ChatColor.DARK_PURPLE + "+100");
                v.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You were killed by " + ChatColor.RED + kn);
                if (this.plugin.getConfig().contains(kn)) {
                  int pts = this.plugin.getConfig().getInt(kn);
                  this.plugin.getConfig().set(kn, Integer.valueOf(pts + 100));
                  this.plugin.saveConfig();
                } else {
                  this.plugin.getConfig().set(kn, Integer.valueOf(100));
                  this.plugin.saveConfig();
                }
                int kpoints = this.plugin.getConfig().getInt("bpoints3");
                this.plugin.getConfig().set("bpoints3", Integer.valueOf(kpoints + 1));
              }

              if (this.plugin.getConfig().contains("rplist4." + vn))
              {
                Player[] online = Bukkit.getServer().getOnlinePlayers();
                for (int i = 0; i < online.length; i++) {
                  Player p = online[i];
                  if ((this.plugin.getConfig().contains("rplist4." + p.getName())) || (this.plugin.getConfig().contains("bplist4." + p.getName()))) {
                    this.api.setScoreboard(p);
                    int sc = this.api.getScores(Bukkit.getOfflinePlayer(ChatColor.BLUE + "Blue"));
                    this.api.setScore(Bukkit.getOfflinePlayer(ChatColor.BLUE + "Blue"), sc + 1);
                  }
                }

                double x = this.plugin.getConfig().getDouble("redspawn4.x");
                double y = this.plugin.getConfig().getDouble("redspawn4.y");
                double z = this.plugin.getConfig().getDouble("redspawn4.z");
                Location l = new Location(w, x, y, z);
                Firework firework = (Firework)v.getWorld().spawn(v.getLocation(), Firework.class);
                FireworkMeta data = firework.getFireworkMeta();
                data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
                data.setPower(0);
                firework.setFireworkMeta(data);
                v.teleport(l);
                ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
                LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
                meta.setColor(Color.RED);
                helm.setItemMeta(meta);
                v.getInventory().setHelmet(helm);

                ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
                metat.setColor(Color.RED);
                ches.setItemMeta(metat);
                v.getInventory().setChestplate(ches);

                ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
                metatt.setColor(Color.RED);
                legg.setItemMeta(metatt);
                v.getInventory().setLeggings(legg);

                ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
                metattt.setColor(Color.RED);
                boot.setItemMeta(metattt);
                v.getInventory().setBoots(boot);
                v.setLevel(40);
                v.setHealth(20d);
                v.setFoodLevel(20);
                k.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You killed " + ChatColor.RED + vn + ChatColor.GOLD + "! " + ChatColor.DARK_PURPLE + "+100");
                v.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You were killed by " + ChatColor.RED + kn);
                if (this.plugin.getConfig().contains(kn)) {
                  int pts = this.plugin.getConfig().getInt(kn);
                  this.plugin.getConfig().set(kn, Integer.valueOf(pts + 100));
                  this.plugin.saveConfig();
                } else {
                  this.plugin.getConfig().set(kn, Integer.valueOf(100));
                  this.plugin.saveConfig();
                }
                int kpoints = this.plugin.getConfig().getInt("bpoints4");
                this.plugin.getConfig().set("bpoints4", Integer.valueOf(kpoints + 1));
              }

              if (this.plugin.getConfig().contains("rplist5." + vn))
              {
                Player[] online = Bukkit.getServer().getOnlinePlayers();
                for (int i = 0; i < online.length; i++) {
                  Player p = online[i];
                  if ((this.plugin.getConfig().contains("rplist5." + p.getName())) || (this.plugin.getConfig().contains("bplist5." + p.getName()))) {
                    this.api.setScoreboard(p);
                    int sc = this.api.getScores(Bukkit.getOfflinePlayer(ChatColor.BLUE + "Blue"));
                    this.api.setScore(Bukkit.getOfflinePlayer(ChatColor.BLUE + "Blue"), sc + 1);
                  }
                }

                double x = this.plugin.getConfig().getDouble("redspawn5.x");
                double y = this.plugin.getConfig().getDouble("redspawn5.y");
                double z = this.plugin.getConfig().getDouble("redspawn5.z");
                Location l = new Location(w, x, y, z);
                Firework firework = (Firework)v.getWorld().spawn(v.getLocation(), Firework.class);
                FireworkMeta data = firework.getFireworkMeta();
                data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
                data.setPower(0);
                firework.setFireworkMeta(data);
                v.teleport(l);
                ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
                LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
                meta.setColor(Color.RED);
                helm.setItemMeta(meta);
                v.getInventory().setHelmet(helm);

                ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
                metat.setColor(Color.RED);
                ches.setItemMeta(metat);
                v.getInventory().setChestplate(ches);

                ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
                metatt.setColor(Color.RED);
                legg.setItemMeta(metatt);
                v.getInventory().setLeggings(legg);

                ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
                metattt.setColor(Color.RED);
                boot.setItemMeta(metattt);
                v.getInventory().setBoots(boot);
                v.setLevel(40);
                v.setHealth(20d);
                v.setFoodLevel(20);
                k.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You killed " + ChatColor.RED + vn + ChatColor.GOLD + "! " + ChatColor.DARK_PURPLE + "+100");
                v.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You were killed by " + ChatColor.RED + kn);
                if (this.plugin.getConfig().contains(kn)) {
                  int pts = this.plugin.getConfig().getInt(kn);
                  this.plugin.getConfig().set(kn, Integer.valueOf(pts + 100));
                  this.plugin.saveConfig();
                } else {
                  this.plugin.getConfig().set(kn, Integer.valueOf(100));
                  this.plugin.saveConfig();
                }
                int kpoints = this.plugin.getConfig().getInt("bpoints5");
                this.plugin.getConfig().set("bpoints5", Integer.valueOf(kpoints + 1));
              }
            }
          } else {
            e.setCancelled(true);
          }
        }

        if ((this.plugin.getConfig().contains("bplist1." + vn)) || (this.plugin.getConfig().contains("bplist2." + vn)) || (this.plugin.getConfig().contains("bplist3." + vn)) || (this.plugin.getConfig().contains("bplist4." + vn)) || (this.plugin.getConfig().contains("bplist5." + vn)))
          if ((this.plugin.getConfig().contains("rplist1." + kn)) || (this.plugin.getConfig().contains("rplist2." + kn)) || (this.plugin.getConfig().contains("rplist3." + kn)) || (this.plugin.getConfig().contains("rplist4." + kn)) || (this.plugin.getConfig().contains("rplist5." + kn)))
          {
            Damageable dv = v;
            if (dv.getHealth() >= 3.0D) {
              e.setDamage(2d);
            }
            else {
              if (this.plugin.getConfig().contains("bplist1." + vn))
              {
                Player[] online = Bukkit.getServer().getOnlinePlayers();
                for (int i = 0; i < online.length; i++) {
                  Player p = online[i];
                  if ((this.plugin.getConfig().contains("rplist1." + p.getName())) || (this.plugin.getConfig().contains("bplist1." + p.getName()))) {
                    this.api.setScoreboard(p);
                    int sc = this.api.getScores(Bukkit.getOfflinePlayer(ChatColor.RED + "Red"));
                    this.api.setScore(Bukkit.getOfflinePlayer(ChatColor.RED + "Red"), sc + 1);
                  }
                }

                double x = this.plugin.getConfig().getDouble("bluespawn1.x");
                double y = this.plugin.getConfig().getDouble("bluespawn1.y");
                double z = this.plugin.getConfig().getDouble("bluespawn1.z");
                Location l = new Location(w, x, y, z);
                Firework firework = (Firework)v.getWorld().spawn(v.getLocation(), Firework.class);
                FireworkMeta data = firework.getFireworkMeta();
                data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
                data.setPower(0);
                firework.setFireworkMeta(data);
                v.teleport(l);
                ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
                LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
                meta.setColor(Color.BLUE);
                helm.setItemMeta(meta);
                v.getInventory().setHelmet(helm);

                ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
                metat.setColor(Color.BLUE);
                ches.setItemMeta(metat);
                v.getInventory().setChestplate(ches);

                ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
                metatt.setColor(Color.BLUE);
                legg.setItemMeta(metatt);
                v.getInventory().setLeggings(legg);

                ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
                metattt.setColor(Color.BLUE);
                boot.setItemMeta(metattt);
                v.getInventory().setBoots(boot);
                v.setLevel(40);
                v.setHealth(20d);
                v.setFoodLevel(20);
                k.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You killed " + ChatColor.RED + vn + ChatColor.GOLD + "! " + ChatColor.DARK_PURPLE + "+100");
                v.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You were killed by " + ChatColor.RED + kn);
                if (this.plugin.getConfig().contains(kn)) {
                  int pts = this.plugin.getConfig().getInt(kn);
                  this.plugin.getConfig().set(kn, Integer.valueOf(pts + 100));
                  this.plugin.saveConfig();
                } else {
                  this.plugin.getConfig().set(kn, Integer.valueOf(100));
                  this.plugin.saveConfig();
                }
                int kpoints = this.plugin.getConfig().getInt("rpoints1");
                this.plugin.getConfig().set("rpoints1", Integer.valueOf(kpoints + 1));
              }

              if (this.plugin.getConfig().contains("bplist2." + vn))
              {
                Player[] online = Bukkit.getServer().getOnlinePlayers();
                for (int i = 0; i < online.length; i++) {
                  Player p = online[i];
                  if ((this.plugin.getConfig().contains("rplist2." + p.getName())) || (this.plugin.getConfig().contains("bplist2." + p.getName()))) {
                    this.api.setScoreboard(p);
                    int sc = this.api.getScores(Bukkit.getOfflinePlayer(ChatColor.RED + "Red"));
                    this.api.setScore(Bukkit.getOfflinePlayer(ChatColor.RED + "Red"), sc + 1);
                  }
                }

                double x = this.plugin.getConfig().getDouble("bluespawn2.x");
                double y = this.plugin.getConfig().getDouble("bluespawn2.y");
                double z = this.plugin.getConfig().getDouble("bluespawn2.z");
                Location l = new Location(w, x, y, z);
                Firework firework = (Firework)v.getWorld().spawn(v.getLocation(), Firework.class);
                FireworkMeta data = firework.getFireworkMeta();
                data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
                data.setPower(0);
                firework.setFireworkMeta(data);
                v.teleport(l);
                ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
                LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
                meta.setColor(Color.BLUE);
                helm.setItemMeta(meta);
                v.getInventory().setHelmet(helm);

                ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
                metat.setColor(Color.BLUE);
                ches.setItemMeta(metat);
                v.getInventory().setChestplate(ches);

                ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
                metatt.setColor(Color.BLUE);
                legg.setItemMeta(metatt);
                v.getInventory().setLeggings(legg);

                ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
                metattt.setColor(Color.BLUE);
                boot.setItemMeta(metattt);
                v.getInventory().setBoots(boot);
                v.setLevel(40);
                v.setHealth(20d);
                v.setFoodLevel(20);
                k.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You killed " + ChatColor.RED + vn + ChatColor.GOLD + "! " + ChatColor.DARK_PURPLE + "+100");
                v.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You were killed by " + ChatColor.RED + kn);
                if (this.plugin.getConfig().contains(kn)) {
                  int pts = this.plugin.getConfig().getInt(kn);
                  this.plugin.getConfig().set(kn, Integer.valueOf(pts + 100));
                  this.plugin.saveConfig();
                } else {
                  this.plugin.getConfig().set(kn, Integer.valueOf(100));
                  this.plugin.saveConfig();
                }
                int kpoints = this.plugin.getConfig().getInt("rpoints2");
                this.plugin.getConfig().set("rpoints2", Integer.valueOf(kpoints + 1));
              }

              if (this.plugin.getConfig().contains("bplist3." + vn))
              {
                Player[] online = Bukkit.getServer().getOnlinePlayers();
                for (int i = 0; i < online.length; i++) {
                  Player p = online[i];
                  if ((this.plugin.getConfig().contains("rplist3." + p.getName())) || (this.plugin.getConfig().contains("bplist3." + p.getName()))) {
                    this.api.setScoreboard(p);
                    int sc = this.api.getScores(Bukkit.getOfflinePlayer(ChatColor.RED + "Red"));
                    this.api.setScore(Bukkit.getOfflinePlayer(ChatColor.RED + "Red"), sc + 1);
                  }
                }

                double x = this.plugin.getConfig().getDouble("bluespawn3.x");
                double y = this.plugin.getConfig().getDouble("bluespawn3.y");
                double z = this.plugin.getConfig().getDouble("bluespawn3.z");
                Location l = new Location(w, x, y, z);
                Firework firework = (Firework)v.getWorld().spawn(v.getLocation(), Firework.class);
                FireworkMeta data = firework.getFireworkMeta();
                data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
                data.setPower(0);
                firework.setFireworkMeta(data);
                v.teleport(l);
                ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
                LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
                meta.setColor(Color.BLUE);
                helm.setItemMeta(meta);
                v.getInventory().setHelmet(helm);

                ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
                metat.setColor(Color.BLUE);
                ches.setItemMeta(metat);
                v.getInventory().setChestplate(ches);

                ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
                metatt.setColor(Color.BLUE);
                legg.setItemMeta(metatt);
                v.getInventory().setLeggings(legg);

                ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
                metattt.setColor(Color.BLUE);
                boot.setItemMeta(metattt);
                v.getInventory().setBoots(boot);
                v.setLevel(40);
                v.setHealth(20d);
                v.setFoodLevel(20);
                k.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You killed " + ChatColor.RED + vn + ChatColor.GOLD + "! " + ChatColor.DARK_PURPLE + "+100");
                v.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You were killed by " + ChatColor.RED + kn);
                if (this.plugin.getConfig().contains(kn)) {
                  int pts = this.plugin.getConfig().getInt(kn);
                  this.plugin.getConfig().set(kn, Integer.valueOf(pts + 100));
                  this.plugin.saveConfig();
                } else {
                  this.plugin.getConfig().set(kn, Integer.valueOf(100));
                  this.plugin.saveConfig();
                }
                int kpoints = this.plugin.getConfig().getInt("rpoints3");
                this.plugin.getConfig().set("rpoints3", Integer.valueOf(kpoints + 1));
              }

              if (this.plugin.getConfig().contains("bplist4." + vn))
              {
                Player[] online = Bukkit.getServer().getOnlinePlayers();
                for (int i = 0; i < online.length; i++) {
                  Player p = online[i];
                  if ((this.plugin.getConfig().contains("rplist4." + p.getName())) || (this.plugin.getConfig().contains("bplist4." + p.getName()))) {
                    this.api.setScoreboard(p);
                    int sc = this.api.getScores(Bukkit.getOfflinePlayer(ChatColor.RED + "Red"));
                    this.api.setScore(Bukkit.getOfflinePlayer(ChatColor.RED + "Red"), sc + 1);
                  }
                }

                double x = this.plugin.getConfig().getDouble("bluespawn4.x");
                double y = this.plugin.getConfig().getDouble("bluespawn4.y");
                double z = this.plugin.getConfig().getDouble("bluespawn4.z");
                Location l = new Location(w, x, y, z);
                Firework firework = (Firework)v.getWorld().spawn(v.getLocation(), Firework.class);
                FireworkMeta data = firework.getFireworkMeta();
                data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
                data.setPower(0);
                firework.setFireworkMeta(data);
                v.teleport(l);
                ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
                LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
                meta.setColor(Color.BLUE);
                helm.setItemMeta(meta);
                v.getInventory().setHelmet(helm);

                ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
                metat.setColor(Color.BLUE);
                ches.setItemMeta(metat);
                v.getInventory().setChestplate(ches);

                ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
                metatt.setColor(Color.BLUE);
                legg.setItemMeta(metatt);
                v.getInventory().setLeggings(legg);

                ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
                metattt.setColor(Color.BLUE);
                boot.setItemMeta(metattt);
                v.getInventory().setBoots(boot);
                v.setLevel(40);
                v.setHealth(20d);
                v.setFoodLevel(20);
                k.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You killed " + ChatColor.RED + vn + ChatColor.GOLD + "! " + ChatColor.DARK_PURPLE + "+100");
                v.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You were killed by " + ChatColor.RED + kn);
                if (this.plugin.getConfig().contains(kn)) {
                  int pts = this.plugin.getConfig().getInt(kn);
                  this.plugin.getConfig().set(kn, Integer.valueOf(pts + 100));
                  this.plugin.saveConfig();
                } else {
                  this.plugin.getConfig().set(kn, Integer.valueOf(100));
                  this.plugin.saveConfig();
                }
                int kpoints = this.plugin.getConfig().getInt("rpoints4");
                this.plugin.getConfig().set("rpoints4", Integer.valueOf(kpoints + 1));
              }

              if (this.plugin.getConfig().contains("bplist5." + vn))
              {
                Player[] online = Bukkit.getServer().getOnlinePlayers();
                for (int i = 0; i < online.length; i++) {
                  Player p = online[i];
                  if ((this.plugin.getConfig().contains("rplist5." + p.getName())) || (this.plugin.getConfig().contains("bplist5." + p.getName()))) {
                    this.api.setScoreboard(p);
                    int sc = this.api.getScores(Bukkit.getOfflinePlayer(ChatColor.RED + "Red"));
                    this.api.setScore(Bukkit.getOfflinePlayer(ChatColor.RED + "Red"), sc + 1);
                  }
                }

                double x = this.plugin.getConfig().getDouble("bluespawn5.x");
                double y = this.plugin.getConfig().getDouble("bluespawn5.y");
                double z = this.plugin.getConfig().getDouble("bluespawn5.z");
                Location l = new Location(w, x, y, z);
                Firework firework = (Firework)v.getWorld().spawn(v.getLocation(), Firework.class);
                FireworkMeta data = firework.getFireworkMeta();
                data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
                data.setPower(0);
                firework.setFireworkMeta(data);
                v.teleport(l);
                ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
                LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
                meta.setColor(Color.BLUE);
                helm.setItemMeta(meta);
                v.getInventory().setHelmet(helm);

                ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
                metat.setColor(Color.BLUE);
                ches.setItemMeta(metat);
                v.getInventory().setChestplate(ches);

                ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
                metatt.setColor(Color.BLUE);
                legg.setItemMeta(metatt);
                v.getInventory().setLeggings(legg);

                ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
                metattt.setColor(Color.BLUE);
                boot.setItemMeta(metattt);
                v.getInventory().setBoots(boot);
                v.setLevel(40);
                v.setHealth(20d);
                v.setFoodLevel(20);
                k.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You killed " + ChatColor.RED + vn + ChatColor.GOLD + "! " + ChatColor.DARK_PURPLE + "+100");
                v.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You were killed by " + ChatColor.RED + kn);
                if (this.plugin.getConfig().contains(kn)) {
                  int pts = this.plugin.getConfig().getInt(kn);
                  this.plugin.getConfig().set(kn, Integer.valueOf(pts + 100));
                  this.plugin.saveConfig();
                } else {
                  this.plugin.getConfig().set(kn, Integer.valueOf(100));
                  this.plugin.saveConfig();
                }
                int kpoints = this.plugin.getConfig().getInt("rpoints5");
                this.plugin.getConfig().set("rpoints5", Integer.valueOf(kpoints + 1));
              }
            }
          } else {
            e.setCancelled(true);
          }
      }
    }
  }

  @EventHandler
  public void swordFight(EntityDamageByEntityEvent e)
  {
    Entity damager = e.getDamager();
    Entity victim = e.getEntity();
    World w = e.getEntity().getWorld();
    if (((damager instanceof Player)) && ((victim instanceof Player))) {
      Player k = (Player)damager;
      Player v = (Player)victim;
      String kn = k.getName();
      String vn = v.getName();
      if (((this.plugin.getConfig().contains("players1." + vn)) || (this.plugin.getConfig().contains("players2." + vn)) || (this.plugin.getConfig().contains("players3." + vn)) || (this.plugin.getConfig().contains("players4." + vn)) || (this.plugin.getConfig().contains("players5." + vn))) && (((Player)damager).getItemInHand().getType() == Material.DIAMOND_SWORD)) {
        if ((this.plugin.getConfig().contains("rplist1." + vn)) || (this.plugin.getConfig().contains("rplist2." + vn)) || (this.plugin.getConfig().contains("rplist3." + vn)) || (this.plugin.getConfig().contains("rplist4." + vn)) || (this.plugin.getConfig().contains("rplist5." + vn))) {
          if ((this.plugin.getConfig().contains("bplist1." + kn)) || (this.plugin.getConfig().contains("bplist2." + kn)) || (this.plugin.getConfig().contains("bplist3." + kn)) || (this.plugin.getConfig().contains("bplist4." + kn)) || (this.plugin.getConfig().contains("bplist5." + kn)))
          {
            Damageable dv = v;

            if (dv.getHealth() >= 5d) {
              e.setDamage(4d);
            }
            else {
              if (this.plugin.getConfig().contains("rplist1." + vn))
              {
                Player[] online = Bukkit.getServer().getOnlinePlayers();
                for (int i = 0; i < online.length; i++) {
                  Player p = online[i];
                  if ((this.plugin.getConfig().contains("rplist1." + p.getName())) || (this.plugin.getConfig().contains("bplist1." + p.getName()))) {
                    this.api.setScoreboard(p);
                    int sc = this.api.getScores(Bukkit.getOfflinePlayer(ChatColor.BLUE + "Blue"));
                    this.api.setScore(Bukkit.getOfflinePlayer(ChatColor.BLUE + "Blue"), sc + 1);
                  }
                }

                double x = this.plugin.getConfig().getDouble("redspawn1.x");
                double y = this.plugin.getConfig().getDouble("redspawn1.y");
                double z = this.plugin.getConfig().getDouble("redspawn1.z");
                Location l = new Location(w, x, y, z);
                Firework firework = (Firework)v.getWorld().spawn(v.getLocation(), Firework.class);
                FireworkMeta data = firework.getFireworkMeta();
                data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
                data.setPower(0);
                firework.setFireworkMeta(data);
                v.teleport(l);
                ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
                LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
                meta.setColor(Color.RED);
                helm.setItemMeta(meta);
                v.getInventory().setHelmet(helm);

                ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
                metat.setColor(Color.RED);
                ches.setItemMeta(metat);
                v.getInventory().setChestplate(ches);

                ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
                metatt.setColor(Color.RED);
                legg.setItemMeta(metatt);
                v.getInventory().setLeggings(legg);

                ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
                metattt.setColor(Color.RED);
                boot.setItemMeta(metattt);
                v.getInventory().setBoots(boot);
                v.setLevel(40);
                v.setHealth(20d);
                v.setFoodLevel(20);
                k.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You killed " + ChatColor.RED + vn + ChatColor.GOLD + "! " + ChatColor.DARK_PURPLE + "+100");
                v.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You were killed by " + ChatColor.RED + kn);
                if (this.plugin.getConfig().contains(kn)) {
                  int pts = this.plugin.getConfig().getInt(kn);
                  this.plugin.getConfig().set(kn, Integer.valueOf(pts + 100));
                  this.plugin.saveConfig();
                } else {
                  this.plugin.getConfig().set(kn, Integer.valueOf(100));
                  this.plugin.saveConfig();
                }
                int kpoints = this.plugin.getConfig().getInt("bpoints1");
                this.plugin.getConfig().set("bpoints1", Integer.valueOf(kpoints + 1));
              }

              if (this.plugin.getConfig().contains("rplist2." + vn))
              {
                Player[] online = Bukkit.getServer().getOnlinePlayers();
                for (int i = 0; i < online.length; i++) {
                  Player p = online[i];
                  if ((this.plugin.getConfig().contains("rplist2." + p.getName())) || (this.plugin.getConfig().contains("bplist2." + p.getName()))) {
                    this.api.setScoreboard(p);
                    int sc = this.api.getScores(Bukkit.getOfflinePlayer(ChatColor.BLUE + "Blue"));
                    this.api.setScore(Bukkit.getOfflinePlayer(ChatColor.BLUE + "Blue"), sc + 1);
                  }
                }

                double x = this.plugin.getConfig().getDouble("redspawn2.x");
                double y = this.plugin.getConfig().getDouble("redspawn2.y");
                double z = this.plugin.getConfig().getDouble("redspawn2.z");
                Location l = new Location(w, x, y, z);
                Firework firework = (Firework)v.getWorld().spawn(v.getLocation(), Firework.class);
                FireworkMeta data = firework.getFireworkMeta();
                data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
                data.setPower(0);
                firework.setFireworkMeta(data);
                v.teleport(l);
                ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
                LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
                meta.setColor(Color.RED);
                helm.setItemMeta(meta);
                v.getInventory().setHelmet(helm);

                ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
                metat.setColor(Color.RED);
                ches.setItemMeta(metat);
                v.getInventory().setChestplate(ches);

                ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
                metatt.setColor(Color.RED);
                legg.setItemMeta(metatt);
                v.getInventory().setLeggings(legg);

                ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
                metattt.setColor(Color.RED);
                boot.setItemMeta(metattt);
                v.getInventory().setBoots(boot);
                v.setLevel(40);
                v.setHealth(20d);
                v.setFoodLevel(20);
                k.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You killed " + ChatColor.RED + vn + ChatColor.GOLD + "! " + ChatColor.DARK_PURPLE + "+100");
                v.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You were killed by " + ChatColor.RED + kn);
                if (this.plugin.getConfig().contains(kn)) {
                  int pts = this.plugin.getConfig().getInt(kn);
                  this.plugin.getConfig().set(kn, Integer.valueOf(pts + 100));
                  this.plugin.saveConfig();
                } else {
                  this.plugin.getConfig().set(kn, Integer.valueOf(100));
                  this.plugin.saveConfig();
                }
                int kpoints = this.plugin.getConfig().getInt("bpoints2");
                this.plugin.getConfig().set("bpoints2", Integer.valueOf(kpoints + 1));
              }

              if (this.plugin.getConfig().contains("rplist3." + vn))
              {
                Player[] online = Bukkit.getServer().getOnlinePlayers();
                for (int i = 0; i < online.length; i++) {
                  Player p = online[i];
                  if ((this.plugin.getConfig().contains("rplist3." + p.getName())) || (this.plugin.getConfig().contains("bplist3." + p.getName()))) {
                    this.api.setScoreboard(p);
                    int sc = this.api.getScores(Bukkit.getOfflinePlayer(ChatColor.BLUE + "Blue"));
                    this.api.setScore(Bukkit.getOfflinePlayer(ChatColor.BLUE + "Blue"), sc + 1);
                  }
                }

                double x = this.plugin.getConfig().getDouble("redspawn3.x");
                double y = this.plugin.getConfig().getDouble("redspawn3.y");
                double z = this.plugin.getConfig().getDouble("redspawn3.z");
                Location l = new Location(w, x, y, z);
                Firework firework = (Firework)v.getWorld().spawn(v.getLocation(), Firework.class);
                FireworkMeta data = firework.getFireworkMeta();
                data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
                data.setPower(0);
                firework.setFireworkMeta(data);
                v.teleport(l);
                ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
                LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
                meta.setColor(Color.RED);
                helm.setItemMeta(meta);
                v.getInventory().setHelmet(helm);

                ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
                metat.setColor(Color.RED);
                ches.setItemMeta(metat);
                v.getInventory().setChestplate(ches);

                ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
                metatt.setColor(Color.RED);
                legg.setItemMeta(metatt);
                v.getInventory().setLeggings(legg);

                ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
                metattt.setColor(Color.RED);
                boot.setItemMeta(metattt);
                v.getInventory().setBoots(boot);
                v.setLevel(40);
                v.setHealth(20d);
                v.setFoodLevel(20);
                k.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You killed " + ChatColor.RED + vn + ChatColor.GOLD + "! " + ChatColor.DARK_PURPLE + "+100");
                v.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You were killed by " + ChatColor.RED + kn);
                if (this.plugin.getConfig().contains(kn)) {
                  int pts = this.plugin.getConfig().getInt(kn);
                  this.plugin.getConfig().set(kn, Integer.valueOf(pts + 100));
                  this.plugin.saveConfig();
                } else {
                  this.plugin.getConfig().set(kn, Integer.valueOf(100));
                  this.plugin.saveConfig();
                }
                int kpoints = this.plugin.getConfig().getInt("bpoints3");
                this.plugin.getConfig().set("bpoints3", Integer.valueOf(kpoints + 1));
              }

              if (this.plugin.getConfig().contains("rplist4." + vn))
              {
                Player[] online = Bukkit.getServer().getOnlinePlayers();
                for (int i = 0; i < online.length; i++) {
                  Player p = online[i];
                  if ((this.plugin.getConfig().contains("rplist4." + p.getName())) || (this.plugin.getConfig().contains("bplist4." + p.getName()))) {
                    this.api.setScoreboard(p);
                    int sc = this.api.getScores(Bukkit.getOfflinePlayer(ChatColor.BLUE + "Blue"));
                    this.api.setScore(Bukkit.getOfflinePlayer(ChatColor.BLUE + "Blue"), sc + 1);
                  }
                }

                double x = this.plugin.getConfig().getDouble("redspawn4.x");
                double y = this.plugin.getConfig().getDouble("redspawn4.y");
                double z = this.plugin.getConfig().getDouble("redspawn4.z");
                Location l = new Location(w, x, y, z);
                Firework firework = (Firework)v.getWorld().spawn(v.getLocation(), Firework.class);
                FireworkMeta data = firework.getFireworkMeta();
                data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
                data.setPower(0);
                firework.setFireworkMeta(data);
                v.teleport(l);
                ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
                LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
                meta.setColor(Color.RED);
                helm.setItemMeta(meta);
                v.getInventory().setHelmet(helm);

                ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
                metat.setColor(Color.RED);
                ches.setItemMeta(metat);
                v.getInventory().setChestplate(ches);

                ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
                metatt.setColor(Color.RED);
                legg.setItemMeta(metatt);
                v.getInventory().setLeggings(legg);

                ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
                metattt.setColor(Color.RED);
                boot.setItemMeta(metattt);
                v.getInventory().setBoots(boot);
                v.setLevel(40);
                v.setHealth(20d);
                v.setFoodLevel(20);
                k.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You killed " + ChatColor.RED + vn + ChatColor.GOLD + "! " + ChatColor.DARK_PURPLE + "+100");
                v.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You were killed by " + ChatColor.RED + kn);
                if (this.plugin.getConfig().contains(kn)) {
                  int pts = this.plugin.getConfig().getInt(kn);
                  this.plugin.getConfig().set(kn, Integer.valueOf(pts + 100));
                  this.plugin.saveConfig();
                } else {
                  this.plugin.getConfig().set(kn, Integer.valueOf(100));
                  this.plugin.saveConfig();
                }
                int kpoints = this.plugin.getConfig().getInt("bpoints4");
                this.plugin.getConfig().set("bpoints4", Integer.valueOf(kpoints + 1));
              }

              if (this.plugin.getConfig().contains("rplist5." + vn))
              {
                Player[] online = Bukkit.getServer().getOnlinePlayers();
                for (int i = 0; i < online.length; i++) {
                  Player p = online[i];
                  if ((this.plugin.getConfig().contains("rplist5." + p.getName())) || (this.plugin.getConfig().contains("bplist5." + p.getName()))) {
                    this.api.setScoreboard(p);
                    int sc = this.api.getScores(Bukkit.getOfflinePlayer(ChatColor.BLUE + "Blue"));
                    this.api.setScore(Bukkit.getOfflinePlayer(ChatColor.BLUE + "Blue"), sc + 1);
                  }
                }

                double x = this.plugin.getConfig().getDouble("redspawn5.x");
                double y = this.plugin.getConfig().getDouble("redspawn5.y");
                double z = this.plugin.getConfig().getDouble("redspawn5.z");
                Location l = new Location(w, x, y, z);
                Firework firework = (Firework)v.getWorld().spawn(v.getLocation(), Firework.class);
                FireworkMeta data = firework.getFireworkMeta();
                data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
                data.setPower(0);
                firework.setFireworkMeta(data);
                v.teleport(l);
                ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
                LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
                meta.setColor(Color.RED);
                helm.setItemMeta(meta);
                v.getInventory().setHelmet(helm);

                ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
                metat.setColor(Color.RED);
                ches.setItemMeta(metat);
                v.getInventory().setChestplate(ches);

                ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
                metatt.setColor(Color.RED);
                legg.setItemMeta(metatt);
                v.getInventory().setLeggings(legg);

                ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
                metattt.setColor(Color.RED);
                boot.setItemMeta(metattt);
                v.getInventory().setBoots(boot);
                v.setLevel(40);
                v.setHealth(20d);
                v.setFoodLevel(20);
                k.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You killed " + ChatColor.RED + vn + ChatColor.GOLD + "! " + ChatColor.DARK_PURPLE + "+100");
                v.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You were killed by " + ChatColor.RED + kn);
                if (this.plugin.getConfig().contains(kn)) {
                  int pts = this.plugin.getConfig().getInt(kn);
                  this.plugin.getConfig().set(kn, Integer.valueOf(pts + 100));
                  this.plugin.saveConfig();
                } else {
                  this.plugin.getConfig().set(kn, Integer.valueOf(100));
                  this.plugin.saveConfig();
                }
                int kpoints = this.plugin.getConfig().getInt("bpoints5");
                this.plugin.getConfig().set("bpoints5", Integer.valueOf(kpoints + 1));
              }
            }
          } else {
            e.setCancelled(true);
          }

        }

        if ((this.plugin.getConfig().contains("bplist1." + vn)) || (this.plugin.getConfig().contains("bplist2." + vn)) || (this.plugin.getConfig().contains("bplist3." + vn)) || (this.plugin.getConfig().contains("bplist4." + vn)) || (this.plugin.getConfig().contains("bplist5." + vn)))
          if ((this.plugin.getConfig().contains("rplist1." + kn)) || (this.plugin.getConfig().contains("rplist2." + kn)) || (this.plugin.getConfig().contains("rplist3." + kn)) || (this.plugin.getConfig().contains("rplist4." + kn)) || (this.plugin.getConfig().contains("rplist5." + kn)))
          {
            Damageable dv = v;
            if (dv.getHealth() >= 5d) {
              e.setDamage(4d);
            }
            else {
              if (this.plugin.getConfig().contains("bplist1." + vn))
              {
                Player[] online = Bukkit.getServer().getOnlinePlayers();
                for (int i = 0; i < online.length; i++) {
                  Player p = online[i];
                  if ((this.plugin.getConfig().contains("rplist1." + p.getName())) || (this.plugin.getConfig().contains("bplist1." + p.getName()))) {
                    this.api.setScoreboard(p);
                    int sc = this.api.getScores(Bukkit.getOfflinePlayer(ChatColor.RED + "Red"));
                    this.api.setScore(Bukkit.getOfflinePlayer(ChatColor.RED + "Red"), sc + 1);
                  }
                }

                double x = this.plugin.getConfig().getDouble("bluespawn1.x");
                double y = this.plugin.getConfig().getDouble("bluespawn1.y");
                double z = this.plugin.getConfig().getDouble("bluespawn1.z");
                Location l = new Location(w, x, y, z);
                Firework firework = (Firework)v.getWorld().spawn(v.getLocation(), Firework.class);
                FireworkMeta data = firework.getFireworkMeta();
                data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
                data.setPower(0);
                firework.setFireworkMeta(data);
                v.teleport(l);
                ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
                LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
                meta.setColor(Color.BLUE);
                helm.setItemMeta(meta);
                v.getInventory().setHelmet(helm);

                ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
                metat.setColor(Color.BLUE);
                ches.setItemMeta(metat);
                v.getInventory().setChestplate(ches);

                ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
                metatt.setColor(Color.BLUE);
                legg.setItemMeta(metatt);
                v.getInventory().setLeggings(legg);

                ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
                metattt.setColor(Color.BLUE);
                boot.setItemMeta(metattt);
                v.getInventory().setBoots(boot);
                v.setLevel(40);
                v.setHealth(20d);
                v.setFoodLevel(20);
                k.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You killed " + ChatColor.RED + vn + ChatColor.GOLD + "! " + ChatColor.DARK_PURPLE + "+100");
                v.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You were killed by " + ChatColor.RED + kn);
                if (this.plugin.getConfig().contains(kn)) {
                  int pts = this.plugin.getConfig().getInt(kn);
                  this.plugin.getConfig().set(kn, Integer.valueOf(pts + 100));
                  this.plugin.saveConfig();
                } else {
                  this.plugin.getConfig().set(kn, Integer.valueOf(100));
                  this.plugin.saveConfig();
                }
                int kpoints = this.plugin.getConfig().getInt("rpoints1");
                this.plugin.getConfig().set("rpoints1", Integer.valueOf(kpoints + 1));
              }

              if (this.plugin.getConfig().contains("bplist2." + vn))
              {
                Player[] online = Bukkit.getServer().getOnlinePlayers();
                for (int i = 0; i < online.length; i++) {
                  Player p = online[i];
                  if ((this.plugin.getConfig().contains("rplist2." + p.getName())) || (this.plugin.getConfig().contains("bplist2." + p.getName()))) {
                    this.api.setScoreboard(p);
                    int sc = this.api.getScores(Bukkit.getOfflinePlayer(ChatColor.RED + "Red"));
                    this.api.setScore(Bukkit.getOfflinePlayer(ChatColor.RED + "Red"), sc + 1);
                  }
                }

                double x = this.plugin.getConfig().getDouble("bluespawn2.x");
                double y = this.plugin.getConfig().getDouble("bluespawn2.y");
                double z = this.plugin.getConfig().getDouble("bluespawn2.z");
                Location l = new Location(w, x, y, z);
                Firework firework = (Firework)v.getWorld().spawn(v.getLocation(), Firework.class);
                FireworkMeta data = firework.getFireworkMeta();
                data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
                data.setPower(0);
                firework.setFireworkMeta(data);
                v.teleport(l);
                ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
                LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
                meta.setColor(Color.BLUE);
                helm.setItemMeta(meta);
                v.getInventory().setHelmet(helm);

                ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
                metat.setColor(Color.BLUE);
                ches.setItemMeta(metat);
                v.getInventory().setChestplate(ches);

                ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
                metatt.setColor(Color.BLUE);
                legg.setItemMeta(metatt);
                v.getInventory().setLeggings(legg);

                ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
                metattt.setColor(Color.BLUE);
                boot.setItemMeta(metattt);
                v.getInventory().setBoots(boot);
                v.setLevel(40);
                v.setHealth(20d);
                v.setFoodLevel(20);
                k.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You killed " + ChatColor.RED + vn + ChatColor.GOLD + "! " + ChatColor.DARK_PURPLE + "+100");
                v.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You were killed by " + ChatColor.RED + kn);
                if (this.plugin.getConfig().contains(kn)) {
                  int pts = this.plugin.getConfig().getInt(kn);
                  this.plugin.getConfig().set(kn, Integer.valueOf(pts + 100));
                  this.plugin.saveConfig();
                } else {
                  this.plugin.getConfig().set(kn, Integer.valueOf(100));
                  this.plugin.saveConfig();
                }
                int kpoints = this.plugin.getConfig().getInt("rpoints2");
                this.plugin.getConfig().set("rpoints2", Integer.valueOf(kpoints + 1));
              }

              if (this.plugin.getConfig().contains("bplist3." + vn))
              {
                Player[] online = Bukkit.getServer().getOnlinePlayers();
                for (int i = 0; i < online.length; i++) {
                  Player p = online[i];
                  if ((this.plugin.getConfig().contains("rplist3." + p.getName())) || (this.plugin.getConfig().contains("bplist3." + p.getName()))) {
                    this.api.setScoreboard(p);
                    int sc = this.api.getScores(Bukkit.getOfflinePlayer(ChatColor.RED + "Red"));
                    this.api.setScore(Bukkit.getOfflinePlayer(ChatColor.RED + "Red"), sc + 1);
                  }
                }

                double x = this.plugin.getConfig().getDouble("bluespawn3.x");
                double y = this.plugin.getConfig().getDouble("bluespawn3.y");
                double z = this.plugin.getConfig().getDouble("bluespawn3.z");
                Location l = new Location(w, x, y, z);
                Firework firework = (Firework)v.getWorld().spawn(v.getLocation(), Firework.class);
                FireworkMeta data = firework.getFireworkMeta();
                data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
                data.setPower(0);
                firework.setFireworkMeta(data);
                v.teleport(l);
                ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
                LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
                meta.setColor(Color.BLUE);
                helm.setItemMeta(meta);
                v.getInventory().setHelmet(helm);

                ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
                metat.setColor(Color.BLUE);
                ches.setItemMeta(metat);
                v.getInventory().setChestplate(ches);

                ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
                metatt.setColor(Color.BLUE);
                legg.setItemMeta(metatt);
                v.getInventory().setLeggings(legg);

                ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
                metattt.setColor(Color.BLUE);
                boot.setItemMeta(metattt);
                v.getInventory().setBoots(boot);
                v.setLevel(40);
                v.setHealth(20d);
                v.setFoodLevel(20);
                k.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You killed " + ChatColor.RED + vn + ChatColor.GOLD + "! " + ChatColor.DARK_PURPLE + "+100");
                v.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You were killed by " + ChatColor.RED + kn);
                if (this.plugin.getConfig().contains(kn)) {
                  int pts = this.plugin.getConfig().getInt(kn);
                  this.plugin.getConfig().set(kn, Integer.valueOf(pts + 100));
                  this.plugin.saveConfig();
                } else {
                  this.plugin.getConfig().set(kn, Integer.valueOf(100));
                  this.plugin.saveConfig();
                }
                int kpoints = this.plugin.getConfig().getInt("rpoints3");
                this.plugin.getConfig().set("rpoints3", Integer.valueOf(kpoints + 1));
              }

              if (this.plugin.getConfig().contains("bplist4." + vn))
              {
                Player[] online = Bukkit.getServer().getOnlinePlayers();
                for (int i = 0; i < online.length; i++) {
                  Player p = online[i];
                  if ((this.plugin.getConfig().contains("rplist4." + p.getName())) || (this.plugin.getConfig().contains("bplist4." + p.getName()))) {
                    this.api.setScoreboard(p);
                    int sc = this.api.getScores(Bukkit.getOfflinePlayer(ChatColor.RED + "Red"));
                    this.api.setScore(Bukkit.getOfflinePlayer(ChatColor.RED + "Red"), sc + 1);
                  }
                }

                double x = this.plugin.getConfig().getDouble("bluespawn4.x");
                double y = this.plugin.getConfig().getDouble("bluespawn4.y");
                double z = this.plugin.getConfig().getDouble("bluespawn4.z");
                Location l = new Location(w, x, y, z);
                Firework firework = (Firework)v.getWorld().spawn(v.getLocation(), Firework.class);
                FireworkMeta data = firework.getFireworkMeta();
                data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
                data.setPower(0);
                firework.setFireworkMeta(data);
                v.teleport(l);
                ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
                LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
                meta.setColor(Color.BLUE);
                helm.setItemMeta(meta);
                v.getInventory().setHelmet(helm);

                ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
                metat.setColor(Color.BLUE);
                ches.setItemMeta(metat);
                v.getInventory().setChestplate(ches);

                ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
                metatt.setColor(Color.BLUE);
                legg.setItemMeta(metatt);
                v.getInventory().setLeggings(legg);

                ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
                metattt.setColor(Color.BLUE);
                boot.setItemMeta(metattt);
                v.getInventory().setBoots(boot);
                v.setLevel(40);
                v.setHealth(20d);
                v.setFoodLevel(20);
                k.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You killed " + ChatColor.RED + vn + ChatColor.GOLD + "! " + ChatColor.DARK_PURPLE + "+100");
                v.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You were killed by " + ChatColor.RED + kn);
                if (this.plugin.getConfig().contains(kn)) {
                  int pts = this.plugin.getConfig().getInt(kn);
                  this.plugin.getConfig().set(kn, Integer.valueOf(pts + 100));
                  this.plugin.saveConfig();
                } else {
                  this.plugin.getConfig().set(kn, Integer.valueOf(100));
                  this.plugin.saveConfig();
                }
                int kpoints = this.plugin.getConfig().getInt("rpoints4");
                this.plugin.getConfig().set("rpoints4", Integer.valueOf(kpoints + 1));
              }

              if (this.plugin.getConfig().contains("bplist5." + vn))
              {
                Player[] online = Bukkit.getServer().getOnlinePlayers();
                for (int i = 0; i < online.length; i++) {
                  Player p = online[i];
                  if ((this.plugin.getConfig().contains("rplist5." + p.getName())) || (this.plugin.getConfig().contains("bplist5." + p.getName()))) {
                    this.api.setScoreboard(p);
                    int sc = this.api.getScores(Bukkit.getOfflinePlayer(ChatColor.RED + "Red"));
                    this.api.setScore(Bukkit.getOfflinePlayer(ChatColor.RED + "Red"), sc + 1);
                  }
                }

                double x = this.plugin.getConfig().getDouble("bluespawn5.x");
                double y = this.plugin.getConfig().getDouble("bluespawn5.y");
                double z = this.plugin.getConfig().getDouble("bluespawn5.z");
                Location l = new Location(w, x, y, z);
                Firework firework = (Firework)v.getWorld().spawn(v.getLocation(), Firework.class);
                FireworkMeta data = firework.getFireworkMeta();
                data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
                data.setPower(0);
                firework.setFireworkMeta(data);
                v.teleport(l);
                ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
                LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
                meta.setColor(Color.BLUE);
                helm.setItemMeta(meta);
                v.getInventory().setHelmet(helm);

                ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
                metat.setColor(Color.BLUE);
                ches.setItemMeta(metat);
                v.getInventory().setChestplate(ches);

                ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
                metatt.setColor(Color.BLUE);
                legg.setItemMeta(metatt);
                v.getInventory().setLeggings(legg);

                ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
                metattt.setColor(Color.BLUE);
                boot.setItemMeta(metattt);
                v.getInventory().setBoots(boot);
                v.setLevel(40);
                v.setHealth(20d);
                v.setFoodLevel(20);
                k.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You killed " + ChatColor.RED + vn + ChatColor.GOLD + "! " + ChatColor.DARK_PURPLE + "+100");
                v.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You were killed by " + ChatColor.RED + kn);
                if (this.plugin.getConfig().contains(kn)) {
                  int pts = this.plugin.getConfig().getInt(kn);
                  this.plugin.getConfig().set(kn, Integer.valueOf(pts + 100));
                  this.plugin.saveConfig();
                } else {
                  this.plugin.getConfig().set(kn, Integer.valueOf(100));
                  this.plugin.saveConfig();
                }
                int kpoints = this.plugin.getConfig().getInt("rpoints5");
                this.plugin.getConfig().set("rpoints5", Integer.valueOf(kpoints + 1));
              }
            }
          } else {
            e.setCancelled(true);
          }
      }else{
    	  if ((this.plugin.getConfig().contains("players1." + vn)) || (this.plugin.getConfig().contains("players2." + vn)) || (this.plugin.getConfig().contains("players3." + vn)) || (this.plugin.getConfig().contains("players4." + vn)) || (this.plugin.getConfig().contains("players5." + vn))) {
    		  //if this is true, then the player wasn't holding a diamond sword in the beginning and therefore the event must
    		  //be cancelled.
    		  e.setCancelled(true);
    	  }
      }
    }
  }

  @EventHandler
  public void otherDamage(EntityDamageEvent event)
  {
    if ((event.getEntity() instanceof Player)) {
      Player p = (Player)event.getEntity();
      String name = p.getName();
      if ((this.plugin.getConfig().contains("players1." + name)) || (this.plugin.getConfig().contains("players2." + name)) || (this.plugin.getConfig().contains("players3." + name)) || (this.plugin.getConfig().contains("players4." + name)) || (this.plugin.getConfig().contains("players5." + name))) {
        if (event.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
          Damageable d = p;
          if (d.getHealth() >= 3.0D) {
            event.setDamage(2d);
          } else {
            if (this.plugin.getConfig().contains("bplist1." + name)) {
              double x = this.plugin.getConfig().getDouble("bluespawn1.x");
              double y = this.plugin.getConfig().getDouble("bluespawn1.y");
              double z = this.plugin.getConfig().getDouble("bluespawn1.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.BLUE);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.BLUE);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.BLUE);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.BLUE);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You fell to your doom!");
            }
            if (this.plugin.getConfig().contains("bplist2." + name)) {
              double x = this.plugin.getConfig().getDouble("bluespawn2.x");
              double y = this.plugin.getConfig().getDouble("bluespawn2.y");
              double z = this.plugin.getConfig().getDouble("bluespawn2.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.BLUE);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.BLUE);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.BLUE);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.BLUE);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You fell to your doom!");
            }
            if (this.plugin.getConfig().contains("bplist3." + name)) {
              double x = this.plugin.getConfig().getDouble("bluespawn3.x");
              double y = this.plugin.getConfig().getDouble("bluespawn3.y");
              double z = this.plugin.getConfig().getDouble("bluespawn3.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.BLUE);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.BLUE);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.BLUE);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.BLUE);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You fell to your doom!");
            }
            if (this.plugin.getConfig().contains("bplist4." + name)) {
              double x = this.plugin.getConfig().getDouble("bluespawn4.x");
              double y = this.plugin.getConfig().getDouble("bluespawn4.y");
              double z = this.plugin.getConfig().getDouble("bluespawn4.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.BLUE);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.BLUE);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.BLUE);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.BLUE);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You fell to your doom!");
            }
            if (this.plugin.getConfig().contains("bplist5." + name)) {
              double x = this.plugin.getConfig().getDouble("bluespawn5.x");
              double y = this.plugin.getConfig().getDouble("bluespawn5.y");
              double z = this.plugin.getConfig().getDouble("bluespawn5.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.BLUE);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.BLUE);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.BLUE);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.BLUE);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You fell to your doom!");
            }

            if (this.plugin.getConfig().contains("rplist1." + name)) {
              double x = this.plugin.getConfig().getDouble("redspawn1.x");
              double y = this.plugin.getConfig().getDouble("redspawn1.y");
              double z = this.plugin.getConfig().getDouble("redspawn1.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.RED);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.RED);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.RED);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.RED);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You fell to your doom!");
            }
            if (this.plugin.getConfig().contains("rplist2." + name)) {
              double x = this.plugin.getConfig().getDouble("redspawn2.x");
              double y = this.plugin.getConfig().getDouble("redspawn2.y");
              double z = this.plugin.getConfig().getDouble("redspawn2.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.RED);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.RED);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.RED);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.RED);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You fell to your doom!");
            }
            if (this.plugin.getConfig().contains("rplist3." + name)) {
              double x = this.plugin.getConfig().getDouble("redspawn3.x");
              double y = this.plugin.getConfig().getDouble("redspawn3.y");
              double z = this.plugin.getConfig().getDouble("redspawn3.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.RED);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.RED);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.RED);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.RED);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You fell to your doom!");
            }
            if (this.plugin.getConfig().contains("rplist4." + name)) {
              double x = this.plugin.getConfig().getDouble("redspawn4.x");
              double y = this.plugin.getConfig().getDouble("redspawn4.y");
              double z = this.plugin.getConfig().getDouble("redspawn4.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.RED);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.RED);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.RED);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.RED);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You fell to your doom!");
            }
            if (this.plugin.getConfig().contains("rplist5." + name)) {
              double x = this.plugin.getConfig().getDouble("redspawn5.x");
              double y = this.plugin.getConfig().getDouble("redspawn5.y");
              double z = this.plugin.getConfig().getDouble("redspawn5.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.RED);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.RED);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.RED);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.RED);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You fell to your doom!");
            }
          }
        }

        if (event.getCause().equals(EntityDamageEvent.DamageCause.LAVA)) {
          Damageable d = p;
          if (d.getHealth() >= 3.0D) {
            event.setDamage(2d);
          } else {
            if (this.plugin.getConfig().contains("bplist1." + name)) {
              double x = this.plugin.getConfig().getDouble("bluespawn1.x");
              double y = this.plugin.getConfig().getDouble("bluespawn1.y");
              double z = this.plugin.getConfig().getDouble("bluespawn1.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.BLUE);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.BLUE);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.BLUE);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.BLUE);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You got torched in lava");
              p.setFireTicks(0);
            }
            if (this.plugin.getConfig().contains("bplist2." + name)) {
              double x = this.plugin.getConfig().getDouble("bluespawn2.x");
              double y = this.plugin.getConfig().getDouble("bluespawn2.y");
              double z = this.plugin.getConfig().getDouble("bluespawn2.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.BLUE);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.BLUE);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.BLUE);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.BLUE);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You got torched in lava");
              p.setFireTicks(0);
            }
            if (this.plugin.getConfig().contains("bplist3." + name)) {
              double x = this.plugin.getConfig().getDouble("bluespawn3.x");
              double y = this.plugin.getConfig().getDouble("bluespawn3.y");
              double z = this.plugin.getConfig().getDouble("bluespawn3.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.BLUE);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.BLUE);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.BLUE);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.BLUE);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You got torched in lava");
              p.setFireTicks(0);
            }
            if (this.plugin.getConfig().contains("bplist4." + name)) {
              double x = this.plugin.getConfig().getDouble("bluespawn4.x");
              double y = this.plugin.getConfig().getDouble("bluespawn4.y");
              double z = this.plugin.getConfig().getDouble("bluespawn4.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.BLUE);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.BLUE);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.BLUE);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.BLUE);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You got torched in lava");
              p.setFireTicks(0);
            }
            if (this.plugin.getConfig().contains("bplist5." + name)) {
              double x = this.plugin.getConfig().getDouble("bluespawn5.x");
              double y = this.plugin.getConfig().getDouble("bluespawn5.y");
              double z = this.plugin.getConfig().getDouble("bluespawn5.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.BLUE);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.BLUE);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.BLUE);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.BLUE);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You got torched in lava");
              p.setFireTicks(0);
            }

            if (this.plugin.getConfig().contains("rplist1." + name)) {
              double x = this.plugin.getConfig().getDouble("redspawn1.x");
              double y = this.plugin.getConfig().getDouble("redspawn1.y");
              double z = this.plugin.getConfig().getDouble("redspawn1.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.RED);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.RED);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.RED);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.RED);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You got torched in lava");
              p.setFireTicks(0);
            }
            if (this.plugin.getConfig().contains("rplist2." + name)) {
              double x = this.plugin.getConfig().getDouble("redspawn2.x");
              double y = this.plugin.getConfig().getDouble("redspawn2.y");
              double z = this.plugin.getConfig().getDouble("redspawn2.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.RED);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.RED);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.RED);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.RED);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You got torched in lava");
              p.setFireTicks(0);
            }
            if (this.plugin.getConfig().contains("rplist3." + name)) {
              double x = this.plugin.getConfig().getDouble("redspawn3.x");
              double y = this.plugin.getConfig().getDouble("redspawn3.y");
              double z = this.plugin.getConfig().getDouble("redspawn3.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.RED);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.RED);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.RED);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.RED);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You got torched in lava");
              p.setFireTicks(0);
            }
            if (this.plugin.getConfig().contains("rplist4." + name)) {
              double x = this.plugin.getConfig().getDouble("redspawn4.x");
              double y = this.plugin.getConfig().getDouble("redspawn4.y");
              double z = this.plugin.getConfig().getDouble("redspawn4.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.RED);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.RED);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.RED);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.RED);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You got torched in lava");
              p.setFireTicks(0);
            }
            if (this.plugin.getConfig().contains("rplist5." + name)) {
              double x = this.plugin.getConfig().getDouble("redspawn5.x");
              double y = this.plugin.getConfig().getDouble("redspawn5.y");
              double z = this.plugin.getConfig().getDouble("redspawn5.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.RED);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.RED);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.RED);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.RED);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You got torched in lava");
              p.setFireTicks(0);
            }
          }
        }

        if (event.getCause().equals(EntityDamageEvent.DamageCause.DROWNING)) {
          Damageable d = p;
          if (d.getHealth() >= 3.0D) {
            event.setDamage(2d);
          } else {
            if (this.plugin.getConfig().contains("bplist1." + name)) {
              double x = this.plugin.getConfig().getDouble("bluespawn1.x");
              double y = this.plugin.getConfig().getDouble("bluespawn1.y");
              double z = this.plugin.getConfig().getDouble("bluespawn1.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.BLUE);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.BLUE);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.BLUE);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.BLUE);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You ran out of air!");
            }
            if (this.plugin.getConfig().contains("bplist2." + name)) {
              double x = this.plugin.getConfig().getDouble("bluespawn2.x");
              double y = this.plugin.getConfig().getDouble("bluespawn2.y");
              double z = this.plugin.getConfig().getDouble("bluespawn2.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.BLUE);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.BLUE);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.BLUE);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.BLUE);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You ran out of air!");
            }
            if (this.plugin.getConfig().contains("bplist3." + name)) {
              double x = this.plugin.getConfig().getDouble("bluespawn3.x");
              double y = this.plugin.getConfig().getDouble("bluespawn3.y");
              double z = this.plugin.getConfig().getDouble("bluespawn3.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.BLUE);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.BLUE);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.BLUE);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.BLUE);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You ran out of air!");
            }
            if (this.plugin.getConfig().contains("bplist4." + name)) {
              double x = this.plugin.getConfig().getDouble("bluespawn4.x");
              double y = this.plugin.getConfig().getDouble("bluespawn4.y");
              double z = this.plugin.getConfig().getDouble("bluespawn4.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.BLUE);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.BLUE);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.BLUE);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.BLUE);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You ran out of air!");
            }
            if (this.plugin.getConfig().contains("bplist5." + name)) {
              double x = this.plugin.getConfig().getDouble("bluespawn5.x");
              double y = this.plugin.getConfig().getDouble("bluespawn5.y");
              double z = this.plugin.getConfig().getDouble("bluespawn5.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.BLUE);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.BLUE);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.BLUE);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.BLUE);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You ran out of air!");
            }

            if (this.plugin.getConfig().contains("rplist1." + name)) {
              double x = this.plugin.getConfig().getDouble("redspawn1.x");
              double y = this.plugin.getConfig().getDouble("redspawn1.y");
              double z = this.plugin.getConfig().getDouble("redspawn1.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.RED);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.RED);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.RED);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.RED);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You ran out of air!");
            }
            if (this.plugin.getConfig().contains("rplist2." + name)) {
              double x = this.plugin.getConfig().getDouble("redspawn2.x");
              double y = this.plugin.getConfig().getDouble("redspawn2.y");
              double z = this.plugin.getConfig().getDouble("redspawn2.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.RED);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.RED);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.RED);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.RED);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You ran out of air!");
            }
            if (this.plugin.getConfig().contains("rplist3." + name)) {
              double x = this.plugin.getConfig().getDouble("redspawn3.x");
              double y = this.plugin.getConfig().getDouble("redspawn3.y");
              double z = this.plugin.getConfig().getDouble("redspawn3.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.RED);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.RED);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.RED);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.RED);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You ran out of air!");
            }
            if (this.plugin.getConfig().contains("rplist4." + name)) {
              double x = this.plugin.getConfig().getDouble("redspawn4.x");
              double y = this.plugin.getConfig().getDouble("redspawn4.y");
              double z = this.plugin.getConfig().getDouble("redspawn4.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.RED);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.RED);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.RED);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.RED);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You ran out of air!");
            }
            if (this.plugin.getConfig().contains("rplist5." + name)) {
              double x = this.plugin.getConfig().getDouble("redspawn5.x");
              double y = this.plugin.getConfig().getDouble("redspawn5.y");
              double z = this.plugin.getConfig().getDouble("redspawn5.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.RED);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.RED);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.RED);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.RED);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You ran out of air!");
            }
          }
        }

        if (event.getCause().equals(EntityDamageEvent.DamageCause.FIRE)) {
          event.setCancelled(true);
        }

        if (event.getCause().equals(EntityDamageEvent.DamageCause.FIRE_TICK)) {
          Damageable d = p;
          if (d.getHealth() >= 3.0D) {
            event.setDamage(2d);
          } else {
            if (this.plugin.getConfig().contains("bplist1." + name)) {
              double x = this.plugin.getConfig().getDouble("bluespawn1.x");
              double y = this.plugin.getConfig().getDouble("bluespawn1.y");
              double z = this.plugin.getConfig().getDouble("bluespawn1.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.BLUE);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.BLUE);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.BLUE);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.BLUE);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You died while on fire!");
              p.setFireTicks(0);
            }
            if (this.plugin.getConfig().contains("bplist2." + name)) {
              double x = this.plugin.getConfig().getDouble("bluespawn2.x");
              double y = this.plugin.getConfig().getDouble("bluespawn2.y");
              double z = this.plugin.getConfig().getDouble("bluespawn2.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.BLUE);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.BLUE);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.BLUE);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.BLUE);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You died while on fire!");
              p.setFireTicks(0);
            }
            if (this.plugin.getConfig().contains("bplist3." + name)) {
              double x = this.plugin.getConfig().getDouble("bluespawn3.x");
              double y = this.plugin.getConfig().getDouble("bluespawn3.y");
              double z = this.plugin.getConfig().getDouble("bluespawn3.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.BLUE);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.BLUE);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.BLUE);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.BLUE);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You died while on fire!");
              p.setFireTicks(0);
            }
            if (this.plugin.getConfig().contains("bplist4." + name)) {
              double x = this.plugin.getConfig().getDouble("bluespawn4.x");
              double y = this.plugin.getConfig().getDouble("bluespawn4.y");
              double z = this.plugin.getConfig().getDouble("bluespawn4.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.BLUE);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.BLUE);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.BLUE);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.BLUE);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You died while on fire!");
              p.setFireTicks(0);
            }
            if (this.plugin.getConfig().contains("bplist5." + name)) {
              double x = this.plugin.getConfig().getDouble("bluespawn5.x");
              double y = this.plugin.getConfig().getDouble("bluespawn5.y");
              double z = this.plugin.getConfig().getDouble("bluespawn5.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.BLUE);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.BLUE);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.BLUE);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.BLUE);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You died while on fire!");
              p.setFireTicks(0);
            }

            if (this.plugin.getConfig().contains("rplist1." + name)) {
              double x = this.plugin.getConfig().getDouble("redspawn1.x");
              double y = this.plugin.getConfig().getDouble("redspawn1.y");
              double z = this.plugin.getConfig().getDouble("redspawn1.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.RED);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.RED);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.RED);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.RED);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You died while on fire!");
              p.setFireTicks(0);
            }
            if (this.plugin.getConfig().contains("rplist2." + name)) {
              double x = this.plugin.getConfig().getDouble("redspawn2.x");
              double y = this.plugin.getConfig().getDouble("redspawn2.y");
              double z = this.plugin.getConfig().getDouble("redspawn2.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.RED);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.RED);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.RED);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.RED);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You died while on fire!");
              p.setFireTicks(0);
            }
            if (this.plugin.getConfig().contains("rplist3." + name)) {
              double x = this.plugin.getConfig().getDouble("redspawn3.x");
              double y = this.plugin.getConfig().getDouble("redspawn3.y");
              double z = this.plugin.getConfig().getDouble("redspawn3.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.RED);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.RED);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.RED);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.RED);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You died while on fire!");
              p.setFireTicks(0);
            }
            if (this.plugin.getConfig().contains("rplist4." + name)) {
              double x = this.plugin.getConfig().getDouble("redspawn4.x");
              double y = this.plugin.getConfig().getDouble("redspawn4.y");
              double z = this.plugin.getConfig().getDouble("redspawn4.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.RED);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.RED);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.RED);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.RED);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You died while on fire!");
              p.setFireTicks(0);
            }
            if (this.plugin.getConfig().contains("rplist5." + name)) {
              double x = this.plugin.getConfig().getDouble("redspawn5.x");
              double y = this.plugin.getConfig().getDouble("redspawn5.y");
              double z = this.plugin.getConfig().getDouble("redspawn5.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.RED);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.RED);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.RED);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.RED);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You died while on fire!");
              p.setFireTicks(0);
            }
          }
        }

        if (event.getCause().equals(EntityDamageEvent.DamageCause.VOID)) {
          Damageable d = p;
          if (d.getHealth() >= 3.0D) {
            event.setDamage(2d);
          } else {
            if (this.plugin.getConfig().contains("bplist1." + name)) {
              double x = this.plugin.getConfig().getDouble("bluespawn1.x");
              double y = this.plugin.getConfig().getDouble("bluespawn1.y");
              double z = this.plugin.getConfig().getDouble("bluespawn1.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.BLUE);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.BLUE);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.BLUE);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.BLUE);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You fell through the world!");
            }
            if (this.plugin.getConfig().contains("bplist2." + name)) {
              double x = this.plugin.getConfig().getDouble("bluespawn2.x");
              double y = this.plugin.getConfig().getDouble("bluespawn2.y");
              double z = this.plugin.getConfig().getDouble("bluespawn2.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.BLUE);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.BLUE);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.BLUE);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.BLUE);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You fell through the world!");
            }
            if (this.plugin.getConfig().contains("bplist3." + name)) {
              double x = this.plugin.getConfig().getDouble("bluespawn3.x");
              double y = this.plugin.getConfig().getDouble("bluespawn3.y");
              double z = this.plugin.getConfig().getDouble("bluespawn3.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.BLUE);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.BLUE);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.BLUE);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.BLUE);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You fell through the world!");
            }
            if (this.plugin.getConfig().contains("bplist4." + name)) {
              double x = this.plugin.getConfig().getDouble("bluespawn4.x");
              double y = this.plugin.getConfig().getDouble("bluespawn4.y");
              double z = this.plugin.getConfig().getDouble("bluespawn4.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.BLUE);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.BLUE);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.BLUE);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.BLUE);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You fell through the world!");
            }
            if (this.plugin.getConfig().contains("bplist5." + name)) {
              double x = this.plugin.getConfig().getDouble("bluespawn5.x");
              double y = this.plugin.getConfig().getDouble("bluespawn5.y");
              double z = this.plugin.getConfig().getDouble("bluespawn5.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.BLUE);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.BLUE);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.BLUE);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.BLUE);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You fell through the world!");
            }

            if (this.plugin.getConfig().contains("rplist1." + name)) {
              double x = this.plugin.getConfig().getDouble("redspawn1.x");
              double y = this.plugin.getConfig().getDouble("redspawn1.y");
              double z = this.plugin.getConfig().getDouble("redspawn1.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.RED);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.RED);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.RED);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.RED);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You fell through the world!");
            }
            if (this.plugin.getConfig().contains("rplist2." + name)) {
              double x = this.plugin.getConfig().getDouble("redspawn2.x");
              double y = this.plugin.getConfig().getDouble("redspawn2.y");
              double z = this.plugin.getConfig().getDouble("redspawn2.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.RED);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.RED);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.RED);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.RED);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You fell through the world!");
            }
            if (this.plugin.getConfig().contains("rplist3." + name)) {
              double x = this.plugin.getConfig().getDouble("redspawn3.x");
              double y = this.plugin.getConfig().getDouble("redspawn3.y");
              double z = this.plugin.getConfig().getDouble("redspawn3.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.RED);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.RED);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.RED);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.RED);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You fell through the world!");
            }
            if (this.plugin.getConfig().contains("rplist4." + name)) {
              double x = this.plugin.getConfig().getDouble("redspawn4.x");
              double y = this.plugin.getConfig().getDouble("redspawn4.y");
              double z = this.plugin.getConfig().getDouble("redspawn4.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.RED);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.RED);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.RED);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.RED);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You fell through the world!");
            }
            if (this.plugin.getConfig().contains("rplist5." + name)) {
              double x = this.plugin.getConfig().getDouble("redspawn5.x");
              double y = this.plugin.getConfig().getDouble("redspawn5.y");
              double z = this.plugin.getConfig().getDouble("redspawn5.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.RED);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.RED);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.RED);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.RED);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You fell through the world!");
            }
          }
        }

        if (event.getCause().equals(EntityDamageEvent.DamageCause.PROJECTILE)) {
          Damageable d = p;
          if (d.getHealth() >= 3.0D) {
            event.setDamage(2d);
          } else {
            if (this.plugin.getConfig().contains("bplist1." + name)) {
              double x = this.plugin.getConfig().getDouble("bluespawn1.x");
              double y = this.plugin.getConfig().getDouble("bluespawn1.y");
              double z = this.plugin.getConfig().getDouble("bluespawn1.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.BLUE);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.BLUE);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.BLUE);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.BLUE);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You were shot to death!");
            }
            if (this.plugin.getConfig().contains("bplist2." + name)) {
              double x = this.plugin.getConfig().getDouble("bluespawn2.x");
              double y = this.plugin.getConfig().getDouble("bluespawn2.y");
              double z = this.plugin.getConfig().getDouble("bluespawn2.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.BLUE);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.BLUE);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.BLUE);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.BLUE);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You were shot to death!");
            }
            if (this.plugin.getConfig().contains("bplist3." + name)) {
              double x = this.plugin.getConfig().getDouble("bluespawn3.x");
              double y = this.plugin.getConfig().getDouble("bluespawn3.y");
              double z = this.plugin.getConfig().getDouble("bluespawn3.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.BLUE);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.BLUE);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.BLUE);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.BLUE);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You were shot to death!");
            }
            if (this.plugin.getConfig().contains("bplist4." + name)) {
              double x = this.plugin.getConfig().getDouble("bluespawn4.x");
              double y = this.plugin.getConfig().getDouble("bluespawn4.y");
              double z = this.plugin.getConfig().getDouble("bluespawn4.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.BLUE);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.BLUE);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.BLUE);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.BLUE);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You were shot to death!");
            }
            if (this.plugin.getConfig().contains("bplist5." + name)) {
              double x = this.plugin.getConfig().getDouble("bluespawn5.x");
              double y = this.plugin.getConfig().getDouble("bluespawn5.y");
              double z = this.plugin.getConfig().getDouble("bluespawn5.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.BLUE);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.BLUE);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.BLUE);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.BLUE);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You were shot to death!");
            }

            if (this.plugin.getConfig().contains("rplist1." + name)) {
              double x = this.plugin.getConfig().getDouble("redspawn1.x");
              double y = this.plugin.getConfig().getDouble("redspawn1.y");
              double z = this.plugin.getConfig().getDouble("redspawn1.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.RED);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.RED);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.RED);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.RED);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You were shot to death!");
            }
            if (this.plugin.getConfig().contains("rplist2." + name)) {
              double x = this.plugin.getConfig().getDouble("redspawn2.x");
              double y = this.plugin.getConfig().getDouble("redspawn2.y");
              double z = this.plugin.getConfig().getDouble("redspawn2.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.RED);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.RED);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.RED);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.RED);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You were shot to death!");
            }
            if (this.plugin.getConfig().contains("rplist3." + name)) {
              double x = this.plugin.getConfig().getDouble("redspawn3.x");
              double y = this.plugin.getConfig().getDouble("redspawn3.y");
              double z = this.plugin.getConfig().getDouble("redspawn3.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.RED);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.RED);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.RED);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.RED);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You were shot to death!");
            }
            if (this.plugin.getConfig().contains("rplist4." + name)) {
              double x = this.plugin.getConfig().getDouble("redspawn4.x");
              double y = this.plugin.getConfig().getDouble("redspawn4.y");
              double z = this.plugin.getConfig().getDouble("redspawn4.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.RED);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.RED);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.RED);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.RED);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You were shot to death!");
            }
            if (this.plugin.getConfig().contains("rplist5." + name)) {
              double x = this.plugin.getConfig().getDouble("redspawn5.x");
              double y = this.plugin.getConfig().getDouble("redspawn5.y");
              double z = this.plugin.getConfig().getDouble("redspawn5.z");
              Location l = new Location(p.getWorld(), x, y, z);
              Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
              FireworkMeta data = firework.getFireworkMeta();
              data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build() });
              data.setPower(0);
              firework.setFireworkMeta(data);
              p.teleport(l);
              ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta meta = (LeatherArmorMeta)helm.getItemMeta();
              meta.setColor(Color.RED);
              helm.setItemMeta(meta);
              p.getInventory().setHelmet(helm);

              ItemStack ches = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta metat = (LeatherArmorMeta)ches.getItemMeta();
              metat.setColor(Color.RED);
              ches.setItemMeta(metat);
              p.getInventory().setChestplate(ches);

              ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta metatt = (LeatherArmorMeta)legg.getItemMeta();
              metatt.setColor(Color.RED);
              legg.setItemMeta(metatt);
              p.getInventory().setLeggings(legg);

              ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta metattt = (LeatherArmorMeta)boot.getItemMeta();
              metattt.setColor(Color.RED);
              boot.setItemMeta(metattt);
              p.getInventory().setBoots(boot);
              p.setLevel(40);
              d.setHealth(20d);
              p.setFoodLevel(20);
              p.sendMessage(ChatColor.DARK_PURPLE + "[Backbone] " + ChatColor.GOLD + "You were shot to death!");
            }
          }
        }
      }
    }
  }

  @EventHandler
  public void Dead(EntityDeathEvent event) {
    if ((event.getEntity() instanceof Player)) {
      Player p = (Player)event.getEntity();
      String name = p.getName();
      if ((this.plugin.getConfig().contains("players1." + name)) || (this.plugin.getConfig().contains("players2." + name)) || (this.plugin.getConfig().contains("players3." + name)) || (this.plugin.getConfig().contains("players4." + name)) || (this.plugin.getConfig().contains("players5." + name))) {
        event.setDroppedExp(0);
        event.getDrops().clear();
        this.plugin.getServer().broadcastMessage(ChatColor.RED + "Oops! Something glitched in Backbone's code!");
        Player guy = (Player)event.getEntity();
        guy.kickPlayer(ChatColor.GOLD + "[Backbone]" + ChatColor.RED + "Please login again. There was an error in the software!");
      }
    }
  }
}