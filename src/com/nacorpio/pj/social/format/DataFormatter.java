package com.nacorpio.pj.social.format;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class DataFormatter {

	public static final boolean isEmpty(String... par1) {
		return (par1.length == 0 || par1 == null);
	}

	public static final boolean isEmpty(String par1) {
		return (par1 == null || par1.length() == 0 || par1 == "" || par1.isEmpty());
	}

	public static final String toFormat(String par1, String... par2) {
		String var1 = "";
		if (!isEmpty(par1) && !isEmpty(par2)) {
			var1 += "[" + par1 + ":{" + toString(par2) + "}]";
		}
		return var1;
	}

	public static final boolean instanceOf(String par1, String par2) {
		return par1.contains("[" + par2 + ":{") && par1.endsWith("}]");
	}

	// //

	public static final String toString(Object... par1) {
		String var1 = "";
		for (int i = 0; i < par1.length; i++) {
			if (i < par1.length - 1) {
				if (par1[i] != null) {
					var1 += par1[i] + ":";
				} else {
					var1 += "null" + ":";
				}
			} else {
				if (par1[i] != null) {
					var1 += par1[i];
				} else {
					var1 += "null";
				}
			}
		}
		return var1;
	}

	public static final String toString(ItemStack... par1) {
		String var1 = "";
		for (int i = 0; i < par1.length; i++) {
			if (i < par1.length - 1) {
				if (par1[i] != null) {
					var1 += toSimpleString(par1[i]) + ":";
				} else {
					var1 += "null" + ":";
				}
			} else {
				if (par1[i] != null) {
					var1 += toSimpleString(par1[i]);
				} else {
					var1 += "null";
				}
			}
		}
		return var1;
	}

	public static final String toSimpleString(Location par1) {
		return "(" + toString(par1.getBlockX(), par1.getBlockY(), par1.getBlockZ(), par1.getYaw(), par1.getPitch()) + ")";
	}

	public static final String toSimpleString(ItemStack par1) {
		return "(" + toString(par1.getType(), par1.getAmount(), par1.getItemMeta().getDisplayName(), par1.getItemMeta().getLore()) + ")";
	}

	public static final String toSimpleString(Inventory par1) {
		return "(" + toString(par1.getContents()) + ")";
	}

	public static final String toString(Player par1) {
		return toFormat("Player", "Name:" + par1.getName(), "Location:" + toSimpleString(par1.getLocation()), "Inventory:" + toSimpleString(par1.getInventory()));
	}

}
