package com.asintoto.papermcp.commands.types;

import com.asintoto.papermcp.PaperMCP;
import com.asintoto.papermcp.commands.BaseCommand;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Subcommand;
import revxrsal.commands.bukkit.actor.BukkitCommandActor;
import revxrsal.commands.bukkit.annotation.CommandPermission;

@Command({"papermcp", "pmcp"})
@CommandPermission("papermcp.commands.use")
public class MainCommand extends BaseCommand {
    public MainCommand(PaperMCP plugin) {
        super(plugin);
    }

    @Subcommand("reload")
    public void onReload(BukkitCommandActor actor) {
        if(!checkPermission(actor,"reload")) return;

        plugin.reload();
        String msg = plugin.getMessages().getString("admin.reload");
        actor.sender().sendRichMessage(msg);
    }
}
