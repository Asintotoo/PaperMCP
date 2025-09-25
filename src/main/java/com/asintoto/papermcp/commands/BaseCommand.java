package com.asintoto.papermcp.commands;

import com.asintoto.papermcp.PaperMCP;
import lombok.RequiredArgsConstructor;
import org.bukkit.command.CommandSender;
import revxrsal.commands.bukkit.actor.BukkitCommandActor;

@SuppressWarnings("all")
@RequiredArgsConstructor
public abstract class BaseCommand {
    protected final PaperMCP plugin;
    protected final String PLUGIN_BASE_PERMISSION = "papermcp.commands.";

    protected boolean checkPermission(CommandSender sender, String permission) {
        if(!sender.hasPermission(PLUGIN_BASE_PERMISSION + permission)) {
            String msg = plugin.getMessages().getString("error.no-permission");
            sender.sendRichMessage(msg);
            return false;
        }
        return true;
    }

    protected boolean checkPermission(BukkitCommandActor actor, String permission) {
        return checkPermission(actor.sender(), permission);
    }
}
