package com.nacorpio.pjsocial;

import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;

import com.nacorpio.pjsocial.config.ConfigHandler;
import com.nacorpio.pjsocial.listener.ChatListener;

public final class ProjectSocial extends JavaPlugin {

	public static JavaPlugin plugin;
	
	public void onEnable() {
		plugin = this;
		ConfigHandler.initialize();
		this.getServer().getPluginManager().registerEvents(new ChatListener(), this);
		plugin.getLogger().log(Level.INFO, "API-KEY: " + ConfigHandler.api_key);
	}
	
	public void onDisable() {
		
	}
	
}
