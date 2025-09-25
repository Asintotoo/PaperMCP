package com.asintoto.papermcp.components.tools;

import com.asintoto.papermcp.components.ToolProvider;
import com.asintoto.papermcp.utils.Message;
import com.github.codeboyzhou.mcp.declarative.annotation.McpTool;
import com.github.codeboyzhou.mcp.declarative.annotation.McpToolParam;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("all")
public class ConsoleTools extends ToolProvider {

    @McpTool(name = "console_command", description = "Run a command as the Minecraft Server Console")
    public String runConsoleCommand(@McpToolParam(name = "command", description = "the command to execute", required = true)
                                        String command) {

        Bukkit.getScheduler().runTask(plugin, () -> {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
        });
        return message("mcp.success.command-run").create();
    }

    @McpTool(name = "server_info", description = "Get Minecraft Server information")
    public String getServerInfo() {
        String version = Bukkit.getServer().getVersion();
        String port = Integer.toString(Bukkit.getServer().getPort());
        String javaVersion = System.getProperty("java.version");
        String os =  System.getProperty("os.name") + " " + System.getProperty("os.version");
        String tps = getTPS();
        String memory = (Runtime.getRuntime().totalMemory() / 1024 / 1024 - Runtime.getRuntime().freeMemory() / 1024 / 1024) + "MB / " + (Runtime.getRuntime().totalMemory() / 1024 / 1024) + "MB";

        List<Message> list = messageList("mcp.success.server-info");

        for(Message msg : list) {
            msg.replace("%server_version%", version)
                    .replace("%server_port%", port)
                    .replace("%java_version%", javaVersion)
                    .replace("%os%", os)
                    .replace("%tps%", tps)
                    .replace("%memory%", memory);
        }
        return list.stream().map(Message::create).collect(Collectors.joining("\n"));
    }

    private String getTPS() {
        double[] tps = plugin.getServer().getTPS();
        List<String> tpsString = new ArrayList<>();

        for (double d : tps) {
            tpsString.add(String.format("%.2f", d));
        }

        return String.join(" ", tpsString);
    }
}
