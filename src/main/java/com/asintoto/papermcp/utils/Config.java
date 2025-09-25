package com.asintoto.papermcp.utils;

import com.asintoto.papermcp.PaperMCP;
import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

@SuppressWarnings("all")
public class Config {
    @Getter
    private File file;
    @Getter
    private YamlConfiguration config;
    @Getter
    private String fileName;

    private final PaperMCP plugin;

    public Config(PaperMCP plugin, String fileName) {
        this.plugin = plugin;
        this.fileName = fileName;

        file = new File(plugin.getDataFolder(), fileName);

        if(!file.exists()) {
            plugin.saveResource(fileName, false);
        }

        config = YamlConfiguration.loadConfiguration(file);
    }

    public void reload() {
        config = YamlConfiguration.loadConfiguration(file);
    }

    @SneakyThrows
    public void save() {
        config.save(file);
        reload();
    }
}