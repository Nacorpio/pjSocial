package com.nacorpio.pjsocial.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.bukkit.Location;
import org.bukkit.Material;
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
	
	// Not tested
	public static final ItemStack toItemStack(String par1) {
		ItemStack built;
		String[] var1 = par1.split(":");
		String name = var1[0];
		int amount = Integer.parseInt(var1[1]);
		Short dur = Short.parseShort(var1[2]);
		String[] lore = null;
		String dis = null;
		if (var1[3] != "null") {dis = var1[3];}
		if (isArray(var1[4])) {lore = var1[4].split(",");}
		built = new ItemStack(Material.getMaterial(name), amount);
		built.setDurability(dur);
		if (lore != null && lore.length >= 1) built.getItemMeta().setLore(Arrays.asList(lore));
		if (dis != null) built.getItemMeta().setDisplayName(dis);
		return built;
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
	
	public static final boolean isArray(String par1) {
		return par1.startsWith("[") && par1.endsWith("]");
	}
	
	public static final String getProperty(String par1, String par2) {
		System.out.println(par2);
		for (String var1: par2.split("&")) {			
			if (var1.startsWith("- " + par1 + ": ")) {
				return var1.split(": ")[1];
			}
		}
		return null;
	}
	
	public static final Object[] getArray(String par1, String par2) {
		String var1 = getProperty(par1, par2);
		if (isArray(var1)) {
			String var2 = var1.split(Pattern.quote("["))[1].split(Pattern.quote("]"))[0];
			return var2.split(Pattern.quote(","));
		}
		return null;
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
