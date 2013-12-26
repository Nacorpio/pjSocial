package com.nacorpio.pj.social.data;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;

public class Dictionary {

	private static Map<String, Object> object_dict = new HashMap<String, Object>();
	
	static {
		
		for (ChatColor var1: ChatColor.values()) {
			object_dict.put("%" + var1.name().toLowerCase(), ChatColor.valueOf(var1.name()));
		}
		
	}
	
	private static final void add(String par1, Object par2) {
		object_dict.put(par1, par2);
	}
	
	public static final Object get(String par1) {
		return object_dict.get(par1);
	}
	
}
