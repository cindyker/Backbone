package me.firebreath15.backbone;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ISCOREAPI{
	Scoreboard board;
	Objective obj;
	
	public ISCOREAPI(){
		board = Bukkit.getScoreboardManager().getNewScoreboard();
	}
	
	public void setScoreboard(Player p){
		board = p.getScoreboard();
		obj = board.getObjective(DisplaySlot.SIDEBAR);
	}
	
	public void createObjective(String name, String desc){
		if(board.getObjective(name) == null){
			obj = board.registerNewObjective(name, desc);
			obj.setDisplayName(name);
			obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		}
	}
	
	public void removeObjective(String obj){
		board.getObjective(obj).unregister();
	}
	
	public void createTeam(String name){
		if(board.getTeam(name) == null){
			Team team = board.registerNewTeam(name);
			team.setDisplayName(name);
		}
	}
	
	public void removeTeam(String team){
		board.getTeam(team).unregister();
	}
	
	public void addPlayerToTeam(String team, Player p){
		board.getTeam(team).addPlayer(p);
	}
	
	public int getScores(OfflinePlayer p){
		Score score = obj.getScore(p);
		return score.getScore();
	}
	
	public void setScore(OfflinePlayer p, int sc){
		Score score = obj.getScore(p);
		score.setScore(sc);
	}
	
	public void removePlayerFromTeam(String team, Player p){
		board.getTeam(team).removePlayer(p);
	}
	
	public void refreshPlayerScoreboard(Player p){
		p.setScoreboard(board);
	}
	
	public Scoreboard getPlayerScoreboard(Player p){
		return p.getScoreboard();
	}
	
	public void removePlayerScoreboard(Player p){
		p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
	}
}
