package com.nacorpio.pjsocial.config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import com.nacorpio.pjsocial.ProjectSocial;

public final class ConfigHandler {
	
	public static String api_key;
	public static YamlConfiguration yaml_config;
	public static File config_file = new File(ProjectSocial.plugin.getDataFolder().getPath() + "/config.yml");
	
	static {
		yaml_config = new YamlConfiguration();
		try {
			if (!config_file.exists()) {
				reload();
			} else {
				yaml_config.save(ProjectSocial.plugin.getDataFolder().getPath() + "/config.yml");
			}				
		} catch (IOException e) {
			e.printStackTrace();
		}
		initialize();
	}
	
	public static final void initialize() {
		
		ConfigurationSection var1 = yaml_config.createSection("settings");
		var1.set("api-key", "");

	}
	
	public static final void reload() {
		if (new File(ProjectSocial.plugin.getDataFolder().getPath() + "/config.yml").exists()) {
		
			ConfigurationSection var1 = yaml_config.getConfigurationSection("settings");
			api_key = var1.getString("api-key");
			
		}
	}
	
}
