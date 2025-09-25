package com.asintoto.papermcp.listeners;

import com.asintoto.papermcp.PaperMCP;
import com.asintoto.papermcp.components.MCPPackage;
import com.github.codeboyzhou.mcp.declarative.McpServers;
import com.github.codeboyzhou.mcp.declarative.annotation.McpI18nEnabled;
import com.github.codeboyzhou.mcp.declarative.annotation.McpServerApplication;
import com.github.codeboyzhou.mcp.declarative.server.McpStreamableServerInfo;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerLoadEvent;

@SuppressWarnings("all")
@McpI18nEnabled
@McpServerApplication(basePackageClass = MCPPackage.class)
@RequiredArgsConstructor
public final class ServerStartUpListener implements Listener {
    private final PaperMCP plugin;

    @EventHandler
    public void onLoad(ServerLoadEvent event) {
        if(event.getType() == ServerLoadEvent.LoadType.STARTUP) {
            int port = plugin.getConfig().getInt("port", 15000);
            String serverName = plugin.getConfig().getString("server-name", "papermcp-server");
            String endpoint = plugin.getConfig().getString("endpoint", "/mcp");
            String version = plugin.getDescription().getVersion();

            plugin.getLogger().info("Starting MCP Server on port " + port);

            McpStreamableServerInfo info = McpStreamableServerInfo.builder()
                    .port(port)
                    .name(serverName)
                    .mcpEndpoint(endpoint)
                    .version(version)
                    .build();

            McpServers.run(ServerStartUpListener.class, new String[]{}).startStreamableServer(info);

            plugin.getLogger().info("MCP Server started on port " + port);
        }
    }
}
