package com.asintoto.papermcp.components.tools;

import com.asintoto.papermcp.components.ToolProvider;
import com.github.codeboyzhou.mcp.declarative.annotation.McpTool;
import com.github.codeboyzhou.mcp.declarative.annotation.McpToolParam;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

@SuppressWarnings("all")
public class PlayerTools extends ToolProvider {

    @McpTool(name = "player_send_message",
        description = "Send a message to a given player on the Minecraft Server. The message supports MiniMessage formatting")
    public String sendRichMessage(@McpToolParam(name = "playerName", description = "The name of the player to send the message to")
                                      String playerName,
                                  @McpToolParam(name = "message", description = "The message to send")
                                  String message) {
        Player player = player(playerName);
        if(player == null) {
            return message("mcp.error.player-not-found").player(playerName).create();
        }

        player.sendRichMessage(message);
        return message("mcp.success.player-message").player(player).create();
    }

    @McpTool(name = "change_player_gamemode",
            description = "Change the gamemode of a given player on the Minecraft Server")
    public String setGamemode(@McpToolParam(name = "playerName", description = "The name of the player to change the gamemode to")
                              String playerName,
                              @McpToolParam(name = "gamemode", description = "The gamemode")
                              String gamemode) {

        Player player = player(playerName);
        if(player == null) {
            return message("mcp.error.player-not-found").player(playerName).create();
        }

        GameMode mode = gamemode(gamemode);
        if(mode == null) {
            return message("mcp.error.gamemode-not-found").player(playerName).create();
        }
        player.setGameMode(mode);
        return message("mcp.success.gamemode-changed").player(player).create();
    }
}
