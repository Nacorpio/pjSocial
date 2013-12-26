package com.nacorpio.pj.social.listener;

import org.bukkit.Bukkit;

import com.nacorpio.pj.social.format.DataFormatter;

public final class Chat {
	
	public static final void send(String par1) {
		if (!DataFormatter.isEmpty(par1)) {
			Bukkit.broadcastMessage(par1);
		}
	}
	
}
