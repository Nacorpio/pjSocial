package com.nacorpio.pjsocial.serialization;

import org.bukkit.entity.Player;

import com.nacorpio.pjsocial.util.SerializationUtil;

public class PlayerSection extends Section {

	public PlayerSection(Player par1) {
		this.setName("Player");
		this.addProperty("Name: " + par1.getName());
		this.addProperty("GameMode: " + par1.getGameMode());
		this.addProperty("Operator: " + par1.isOp());
		this.addProperty("Location: [" + SerializationUtil.toShortString(par1.getLocation().getBlockX(),
																		 par1.getLocation().getBlockY(),
																		 par1.getLocation().getBlockZ(),
																		 par1.getLocation().getPitch(),
																		 par1.getLocation().getYaw()) + "]");
	}
	
}
