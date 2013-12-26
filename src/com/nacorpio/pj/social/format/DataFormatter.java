package com.nacorpio.pj.social.format;

import java.util.Arrays;
import java.util.regex.Pattern;

import org.bukkit.Location;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class DataFormatter {

	public static final String VAR_SEP = "->";
	public static final String SEPARATOR = "&";
	
	static class FormatValue {
		
		private String name;
		private String[] values = new String[]{};
		
		public FormatValue(String par1, String... par2) {
			if (!isEmpty(par1) && !isEmpty(par2)) {
				this.name = par1;
				this.values = par2;
			}
		}
		
		public final void addValue(String par1) {
			Arrays.asList(values).add(par1);
		}
		
		public final String getName() {
			return name;
		}
		
		public final String[] getValues() {
			return values;
		}
		
	}
	
	public static final boolean isEmpty(String... par1) {
		return (par1.length == 0 || par1 == null);
	}

	public static final boolean isEmpty(String par1) {
		return (par1 == null || par1.length() == 0 || par1 == "" || par1.isEmpty());
	}
<<<<<<< HEAD
	
	// [Player:{Name->Aazk&Health->100&Location->(0&0&0&0&0)}]
	
	public static final FormatValue toFormatValue(String par1) {
		
		String name = "";
		String values[] = new String[]{};
		
		if (isValidFormat(par1)) {
			
			String var1 = par1.split(Pattern.quote("["))[1].split(Pattern.quote("]"))[0];
			String var2 = var1.split(Pattern.quote("{"))[1].split(Pattern.quote("}"))[0];
			
			name = var1.split(Pattern.quote(":"))[0];
			values = var2.split(Pattern.quote(SEPARATOR));
			
		}
		
		return new FormatValue(name, values);
		
	}
	
	public static final boolean isValidFormat(String par1) {
		return (par1.startsWith("[") && par1.endsWith("}]") && par1.contains(":{"));
	}
	
=======

>>>>>>> b687e62985b69943f54df455efb8aaae772b39ba
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
					var1 += par1[i] + SEPARATOR;
				} else {
					var1 += "null" + SEPARATOR;
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
<<<<<<< HEAD
	
	public static final String toString(Enchantment... par1) {
		String var1 = "";
		for (int i = 0; i < par1.length; i++) {
			if (i < par1.length - 1) {
				if (par1[i] != null) {
					var1 += toSimpleString(par1[i]) + SEPARATOR;
				} else {
					var1 += "null" + SEPARATOR;
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
	
=======

>>>>>>> b687e62985b69943f54df455efb8aaae772b39ba
	public static final String toString(ItemStack... par1) {
		String var1 = "";
		for (int i = 0; i < par1.length; i++) {
			if (i < par1.length - 1) {
				if (par1[i] != null) {
					var1 += toSimpleString(par1[i]) + SEPARATOR;
				} else {
					var1 += "null" + SEPARATOR;
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
<<<<<<< HEAD
	
	@SuppressWarnings("deprecation")
	public static final String toSimpleString(Enchantment par1) {
		return "(" + toString(par1.getId(), par1.getItemTarget().toString()) + ")";
	}
	
=======

>>>>>>> b687e62985b69943f54df455efb8aaae772b39ba
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
		return toFormat("Player", "Name" + VAR_SEP + par1.getName(), "Location" + VAR_SEP + toSimpleString(par1.getLocation()), "Inventory:" + VAR_SEP + toSimpleString(par1.getInventory()));
	}

}
