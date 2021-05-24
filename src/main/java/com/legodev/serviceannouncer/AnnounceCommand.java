package com.legodev.serviceannouncer;

import java.util.Arrays;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AnnounceCommand implements CommandExecutor {
    ServiceAnnouncer plugin;

    public AnnounceCommand(ServiceAnnouncer plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length > 1) {
            String level = args[0].toLowerCase();
            String content = String.join(" ", (CharSequence[])Arrays.copyOfRange(args, 1, args.length)).trim();

            this.plugin.sendAnnouncement(level, content);

            return true;
        } else {
            return false;
        }
    }
}