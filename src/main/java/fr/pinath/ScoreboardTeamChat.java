package fr.pinath;

import fr.pinath.listener.ChatListener;
import org.bukkit.plugin.java.JavaPlugin;

public class ScoreboardTeamChat extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info(getDescription().getName() + " has been enabled !");
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
    }

    @Override
    public void onDisable() {
        // no need to do things here
    }
}
