package com.nacorpio.pj.social.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class SerializationUtil {

	public static final boolean isValidSectionName(String par1) {
		return !(contains(":", "(", ")", "{", "}", "%"));
	}
	
	// // //
	
	public static final String toShortString(Object... par1) {
		return join(':', par1);
	}
	
	public static final String toShortString(ItemStack par1) {
		String var1 = "";
		var1 += join(':', par1.getType(), par1.getAmount(), par1.getDurability(), par1.getItemMeta().getDisplayName(), "[" + join(',', par1.getItemMeta().getLore()) + "]");
		return var1;
	}
	
	public static final String toShortString(Enchantment par1) {
		String var1 = "";
		var1 += join(':', par1.getName(), par1.getStartLevel(), par1.getMaxLevel(), par1.getItemTarget());
		return var1;
	}
	
	public static final String toShortString(Location par1) {
		String var1 = "";
		var1 += join(':', "[" + join(',', par1.getBlockX(), par1.getBlockY(), par1.getBlockZ()) + "]", par1.getPitch(), par1.getYaw());
		return var1;
	}
	
	// // //
	
	public static final boolean contains(String par1, String... par2) {
		List<Boolean> var = new ArrayList<Boolean>();
		for (String str: par2) {
			if (par1.contains(str)) {
				var.add(true);
			}
		}
		return !var.contains(false);
	}
	
	public static final String join(Character par1, Object... par2) {
		return join(par1, Arrays.asList(par2));
	}
	
	public static final String join(Character par1, List<?> par2) {
		String var1 = "";
		for (int i = 0; i < par2.size(); i++) {
			if (i < par2.size() - 1) {
				if (par2.get(i) != null || par2.get(i) != "") {
					var1 += par2.get(i);
				} else {
					var1 += "null";
				}
				var1 += String.valueOf(par1);
			} else {
				if (par2.get(i) != null || par2.get(i) != "") {
					var1 += par2.get(i);
				} else {
					var1 += "null";
				}				
			}
		}
		return var1;
	}
	
}
