package com.nacorpio.pjsocial.serialization;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.nacorpio.pjsocial.util.SerializationUtil;

public class PlayerSection extends Section {
	
	public PlayerSection(Object par1) {
		super(par1);
		this.setName("Player");
	}

	public final String getPlayerName() {
		return this.getValue("Name").toString();
	}
	
	public final GameMode getGameMode() {
		return GameMode.valueOf(getValue("GameMode").toString());
	}
	
	public final boolean operator() {
		return Boolean.parseBoolean(getValue("Operator").toString());
	}
	
	public final Location getLocation() {
		Object[] var1 = this.getArray("Location");
		return new Location(Bukkit.getWorld(var1[0].toString()), Integer.parseInt(var1[1].toString()), Integer.parseInt(var1[2].toString()), Integer.parseInt(var1[3].toString()));
	}

	@Override
	void initialize(Object par1) {
		Player var1 = (Player) par1;
		this.addProperty("Name: " + var1.getName());
		this.addProperty("GameMode: " + var1.getGameMode());
		this.addProperty("Operator: " + var1.isOp());
		this.addProperty("Location: [" + SerializationUtil.toShortString(var1.getLocation().getWorld().getName(),
																		 var1.getLocation().getBlockX(),
																		 var1.getLocation().getBlockY(),
																		 var1.getLocation().getBlockZ(),
																		 var1.getLocation().getPitch(),
																		 var1.getLocation().getYaw()) + "]");
	}
	
}
