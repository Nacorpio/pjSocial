package com.nacorpio.pjsocial.config;

import java.io.File;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.nacorpio.pjsocial.ProjectSocial;

public final class ConfigHandler {
	
	public static String api_key;
	
	public static File plugin_folder;
	public static File config_file;
	public static FileConfiguration config;
	
	public static final void initialize() {
		try {
			plugin_folder = ProjectSocial.plugin.getDataFolder();
			config_file = new File(plugin_folder, "config.yml");
			config = new YamlConfiguration();
			
			if(!plugin_folder.exists())
				plugin_folder.mkdir();
			
			if(!config_file.exists()){
				config_file.createNewFile();
				setConfigDefaults();
			} else {
				config.load(config_file);
				loadConfigInformation();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static final void save() {
		try { config.save(config_file); } catch (Exception e) {e.printStackTrace();}
	}
	
	public static final void reload() {
		try { config.load(config_file); } catch (Exception e) {e.printStackTrace();}
	}
	
	private static final void loadConfigInformation() {
		ConfigurationSection var1 = config.getConfigurationSection("settings");
		api_key = var1.getString("api-key");
	}
	
	private static final void setConfigDefaults() {
		ConfigurationSection var1 = config.createSection("settings");
		var1.set("api-key", "");
		save();
	}
}
