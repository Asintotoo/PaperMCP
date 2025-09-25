package com.asintoto.papermcp;

import com.asintoto.papermcp.commands.types.MainCommand;
import com.asintoto.papermcp.implementations.PaperJacksonJsonSchemaValidatorSupplier;
import com.asintoto.papermcp.listeners.ServerStartUpListener;
import com.asintoto.papermcp.utils.Config;
import com.asintoto.papermcp.implementations.PaperJacksonMcpJsonMapper;
import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.json.schema.JsonSchemaValidator;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import revxrsal.commands.bukkit.BukkitLamp;

import java.lang.reflect.Field;
import java.util.ServiceLoader;


public final class PaperMCP extends JavaPlugin {

    private Config messages;

    @Override
    public void onLoad() {
        this.setCustomDefaultMapper(new PaperJacksonMcpJsonMapper());
        this.createDefaultMapper();

        ServiceLoader<McpJsonMapper> loader = ServiceLoader.load(McpJsonMapper.class, this.getClass().getClassLoader());

        if(loader.stream().findFirst().isEmpty()) {
            this.getLogger().warning("No McpJsonMapper implementations found!");
        } else {
            this.getLogger().info("McpJsonMapper implementations found:");

            for (McpJsonMapper impl : loader) {
                this.getLogger().info(" - " + impl.getClass().getName());
            }
        }
    }

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.messages = new Config(this, "messages.yml");

        var lamp = BukkitLamp.builder(this).build();
        lamp.register(new MainCommand(this));

        this.getServer().getPluginManager().registerEvents(new ServerStartUpListener(this), this);

        this.getLogger().info("PaperMCP: Enabled!");
    }

    @Override
    public void onDisable() {
        this.getLogger().info("PaperMCP: Disabled!");
    }

    public void reload() {
        this.reloadConfig();
        this.messages.reload();

        this.getLogger().info("PaperMCP: Reloaded!");
    }

    public YamlConfiguration getMessages() {
        return this.messages.getConfig();
    }

    public static PaperMCP getInstance() {
        return getPlugin(PaperMCP.class);
    }

    private McpJsonMapper createDefaultMapper() {
        return new PaperJacksonMcpJsonMapper();
    }

    public void setCustomDefaultMapper(McpJsonMapper customMapper) {
        try {
            Class<?> clazz = Class.forName("io.modelcontextprotocol.json.McpJsonInternal");
            Field field = clazz.getDeclaredField("defaultJsonMapper");
            field.setAccessible(true);
            field.set(null, customMapper);


            JsonSchemaValidator customValidator = new PaperJacksonJsonSchemaValidatorSupplier().get();
            Field defaultValidatorField = Class.forName("io.modelcontextprotocol.json.schema.JsonSchemaInternal")
                    .getDeclaredField("defaultValidator");
            defaultValidatorField.setAccessible(true);
            defaultValidatorField.set(null, customValidator);

        } catch (Exception e) {
            throw new RuntimeException("Failed to set custom default mapper", e);
        }
    }

}
