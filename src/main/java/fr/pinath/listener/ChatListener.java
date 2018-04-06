package fr.pinath.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

@SuppressWarnings("unused")
public class ChatListener implements Listener {
    private Scoreboard scoreboard;

    public ChatListener() {
        scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Team team = scoreboard.getEntryTeam(e.getPlayer().getDisplayName());
        if (team != null) {
            String teamColor = "§" + team.getColor().getChar();
            e.setFormat(teamColor + team.getDisplayName() + " " + e.getPlayer().getName()
                    + "§7 :§f " + e.getMessage());
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Team team = scoreboard.getEntryTeam(e.getPlayer().getDisplayName());
        if (team != null) {
            String teamColor = "§" + team.getColor().getChar();
            e.setJoinMessage(teamColor + team.getDisplayName() + " " + e.getPlayer().getName()
                    + "§e joined the game");
        }
    }

    @EventHandler
    public void onLeft(PlayerQuitEvent e) {
        Team team = scoreboard.getEntryTeam(e.getPlayer().getDisplayName());
        if (team != null) {
            String teamColor = "§" + team.getColor().getChar();
            e.setQuitMessage(teamColor + team.getDisplayName() + " " + e.getPlayer().getName()
                    + "§e left the game");
        }
    }
}
