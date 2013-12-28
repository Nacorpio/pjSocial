package com.nacorpio.pjsocial.config;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;

import com.nacorpio.pjsocial.ProjectSocial;

public final class ConfigHandler {
	
	public static String api_key;
	
	public static File plugin_folder;
	public static File config_file;
	public static FileConfiguration config;
	
	public static final void initialize() {
		plugin_folder = ProjectSocial.plugin.getDataFolder();
		config_file = new File(plugin_folder, "config.yml");
		
		if(!plugin_folder.exists())
			try{ plugin_folder.mkdir(); } catch(Exception e){e.printStackTrace();}
		
		if(!config_file.exists())
			try{ config_file.createNewFile(); } catch(Exception e){e.printStackTrace();}
		
		try { config.load(config_file); } catch (Exception e) {e.printStackTrace();}
	}
	
	public static final void save() {
		try { config.save(config_file); } catch (Exception e) {e.printStackTrace();}
	}
	
	public static final void reload() {
		try { config.load(config_file); } catch (Exception e) {e.printStackTrace();}
	}
	
}
