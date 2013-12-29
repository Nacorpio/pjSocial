package com.nacorpio.pjsocial;

import java.util.HashMap;
import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;

import com.nacorpio.pjsocial.api.Administrative;
import com.nacorpio.pjsocial.config.ConfigHandler;
import com.nacorpio.pjsocial.listener.ChatListener;

public final class ProjectSocial extends JavaPlugin {

	public static JavaPlugin plugin;
	
	public void onEnable() {
		plugin = this;
		ConfigHandler.initialize();
		this.getServer().getPluginManager().registerEvents(new ChatListener(), this);
		
		//Administrative
		HashMap<String,String> var1 = Administrative.initialize(ConfigHandler.api_key, plugin.getDescription().getVersion(), "HWID", "" + plugin.getServer().getPort());
		
		for (String s : var1.keySet()) {
			plugin.getLogger().info(s + " - " + var1.get(s));
		}
		
		if(var1.containsKey("valid") && var1.get("valid").equals("true")){
			plugin.getLogger().log(Level.INFO, var1.get("message"));
		} else {
			plugin.getLogger().log(Level.SEVERE, var1.get("message"));
		}
		
		//DEBUG PURPOSES
		plugin.getLogger().log(Level.INFO, "API-KEY: " + ConfigHandler.api_key);
	}
	
	public void onDisable() {
		
	}
	
}
