package fr.pinath.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.Team;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Team team = Bukkit.getScoreboardManager().getMainScoreboard().getPlayerTeam(e.getPlayer());
        if (team != null) {
            String teamColor = "§" + team.getColor().getChar();
            e.setFormat("<" + teamColor + "[" + team.getDisplayName() + "] " + e.getPlayer().getName()
                    + "§f> " + e.getMessage());
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Team team = Bukkit.getScoreboardManager().getMainScoreboard().getPlayerTeam(e.getPlayer());
        if (team != null) {
            String teamColor = "§" + team.getColor().getChar();
            e.setJoinMessage(teamColor + "[" + team.getDisplayName() + "] " + e.getPlayer().getName()
                    + "§e joined the game");
        }
    }

    @EventHandler
    public void onLeft(PlayerQuitEvent e) {
        Team team = Bukkit.getScoreboardManager().getMainScoreboard().getPlayerTeam(e.getPlayer());
        if (team != null) {
            String teamColor = "§" + team.getColor().getChar();
            e.setQuitMessage(teamColor + "[" + team.getDisplayName() + "] " + e.getPlayer().getName()
                    + "§e left the game");
        }
    }
}
