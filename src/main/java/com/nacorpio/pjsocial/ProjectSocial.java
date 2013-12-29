package com.nacorpio.pjsocial;

import java.util.HashMap;
import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;

import com.nacorpio.pjsocial.api.Administrative;
import com.nacorpio.pjsocial.config.ConfigHandler;
import com.nacorpio.pjsocial.listener.ChatListener;
import com.nacorpio.pjsocial.util.DebugUtil;

public final class ProjectSocial extends JavaPlugin {

	public static JavaPlugin plugin;
	
	public void onEnable() {
		plugin = this;
		ConfigHandler.initialize();
		this.getServer().getPluginManager().registerEvents(new ChatListener(), this);
		
		//Administrative
		HashMap<String,String> var1 = Administrative.initialize(ConfigHandler.api_key, plugin.getDescription().getVersion(), "HWID", "" + plugin.getServer().getPort());
		if(var1.containsKey("valid") && var1.get("valid").equals("true")){
			plugin.getLogger().log(Level.INFO, var1.get("message"));
		} else {
			if(var1.containsKey("message")){
				plugin.getLogger().log(Level.SEVERE, var1.get("message"));
			} else {
				plugin.getLogger().log(Level.SEVERE, "Var1 'message' doesn't exist.");
			}
		}
		
		//DEBUG PURPOSES
		DebugUtil.debug(var1);
		plugin.getLogger().log(Level.INFO, "API-KEY: " + ConfigHandler.api_key);
	}
	
	public void onDisable() {
		
	}
	
}
