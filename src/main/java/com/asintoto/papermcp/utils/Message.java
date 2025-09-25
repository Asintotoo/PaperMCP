package com.asintoto.papermcp.utils;

import lombok.AllArgsConstructor;
import org.bukkit.World;
import org.bukkit.entity.Player;

@AllArgsConstructor
public class Message {
    private String content;

    public Message player(String name) {
        return replace("%player%", name);
    }

    public Message player(Player player) {
        return player(player.getName());
    }

    public Message world(String name) {
        return replace("%world%", name);
    }

    public Message world(World world) {
        return world(world.getName());
    }

    public Message replace(String regex, String replace) {
        this.content = this.content.replace(regex, replace);
        return this;
    }

    public String create() {
        return this.content;
    }
}
