package com.legodev.serviceannouncer;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ServiceAnnouncer extends JavaPlugin {
    FileConfiguration config;

    public ServiceAnnouncer() {
    }

    public void onEnable() {
        this.saveDefaultConfig();
        this.config = this.getConfig();
        this.getCommand("serviceannounce").setExecutor(new AnnounceCommand(this));
    }

    public boolean sendAnnouncement(String level, String content) {
        String messageFormat = this.getConfig().getString(level, "noPrefix").replaceAll("&", "§");
        if ("noPrefix".equals(messageFormat)) {
            return false;
        } else {
            this.getServer().broadcastMessage(messageFormat + content);
            return true;
        }
    }
}