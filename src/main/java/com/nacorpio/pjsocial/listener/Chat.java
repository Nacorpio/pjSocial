package com.nacorpio.pjsocial.listener;

import org.bukkit.Bukkit;

import com.nacorpio.pjsocial.format.DataFormatter;

public final class Chat {
	
	public static final void send(String par1) {
		if (!DataFormatter.isEmpty(par1)) {
			Bukkit.broadcastMessage(par1);
		}
	}
	
}
