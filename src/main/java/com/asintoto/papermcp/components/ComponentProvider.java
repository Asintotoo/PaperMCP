package com.asintoto.papermcp.components;

import com.asintoto.papermcp.PaperMCP;
import com.asintoto.papermcp.utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class ComponentProvider {
    protected final PaperMCP plugin = PaperMCP.getInstance();

    protected final Player player(String name) {
        return Bukkit.getPlayer(name);
    }

    protected final World world(String name) {
        return Bukkit.getWorld(name);
    }

    protected final GameMode gamemode(String name) {
        return switch (name.toUpperCase()) {
            case "CREATIVE" -> GameMode.CREATIVE;
            case "SURVIVAL" -> GameMode.SURVIVAL;
            case "SPECATOR" -> GameMode.SPECTATOR;
            case "ADVENTURE" -> GameMode.ADVENTURE;
            default -> null;
        };
    }

    protected final Message message(String path) {
        String content = plugin.getMessages().getString(path, path);
        return new Message(content);
    }

    protected final List<Message> messageList(String path) {
        List<Message> list = new ArrayList<>();
        List<String> msgs = plugin.getMessages().getStringList(path);
        for(String msg : msgs) {
            list.add(new Message(msg));
        }
        return list;
    }
}
