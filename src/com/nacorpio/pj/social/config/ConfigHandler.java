package com.nacorpio.pj.social.config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import com.nacorpio.pj.social.ProjectSocial;

public final class ConfigHandler {
	
	public static boolean log_actions;
	public static YamlConfiguration yaml_config;
	
	static {
		yaml_config = new YamlConfiguration();
		try {
			yaml_config.save(ProjectSocial.plugin.getDataFolder().getPath() + "/config.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		initialize();
	}
	
	public static final void initialize() {
		
		ConfigurationSection var1 = yaml_config.createSection("settings");
		var1.set("log-actions", false);

	}
	
	public static final void reload() {
		if (new File(ProjectSocial.plugin.getDataFolder().getPath() + "/config.yml").exists()) {
		
			ConfigurationSection var1 = yaml_config.getConfigurationSection("settings");
			log_actions = var1.getBoolean("log-actions");
			
		}
	}
	
}
