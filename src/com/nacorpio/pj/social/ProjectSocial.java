package com.nacorpio.pj.social;

import org.bukkit.plugin.java.JavaPlugin;

import com.nacorpio.pj.social.config.ConfigHandler;
import com.nacorpio.pj.social.listener.ChatListener;

public final class ProjectSocial extends JavaPlugin {

	public static JavaPlugin plugin;
	
	public void onEnable() {
		ConfigHandler.initialize();
		this.getServer().getPluginManager().registerEvents(new ChatListener(), this);
		plugin = this;
	}
	
	public void onDisable() {
		
	}
	
}
