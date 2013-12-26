package com.nacorpio.pj.social;

import org.bukkit.plugin.java.JavaPlugin;

import com.nacorpio.pj.social.config.ConfigHandler;

public final class ProjectSocial extends JavaPlugin {

	public static JavaPlugin plugin;
	
	public void onEnable() {
		ConfigHandler.initialize();
		plugin = this;
	}
	
	public void onDisable() {
		
	}
	
}
