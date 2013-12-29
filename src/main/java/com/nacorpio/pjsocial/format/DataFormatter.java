package com.nacorpio.pjsocial.format;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.bukkit.Location;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class DataFormatter {

	/**
	 * The separator used for splitting a value.
	 */
	public static final String VAR_SEP = "->";
	
	/**
	 * The separator used for splitting the values.
	 */
	public static final String SEPARATOR = "&";
	
	static class Value {
		
		private String name;
		private Object value;
		
		public Value(String par1, Object par2) {
			this.name = par1;
			this.value = par2;
		}
		
		/**
		 * Returns the name of the value.
		 * @return the name.
		 */
		public final String getName() {
			return this.name;
		}
		
		/**
		 * Returns the value of the value.
		 * @return the value.
		 */
		public final Object getValue() {
			return this.value;
		}
		
		public final String getSource() {
			return this.name + VAR_SEP + this.value;
		}
		
	}
	
	static class FormatValue {
		
		private String name;
		private String[] values = new String[]{};
		private List<Value> data_values = new ArrayList<Value>();
		
		public FormatValue(String par1, String... par2) {
			if (!isEmpty(par1) && !isEmpty(par2)) {
				this.name = par1;
				this.values = par2;
				for (String value: values) {
					String name = value.split(Pattern.quote(VAR_SEP))[0];
					String val = value.split(Pattern.quote(VAR_SEP))[1];
					Value fval = new Value(name, val);
					data_values.add(fval);
				}
			}
		}

		/**
		 * Returns the name of the FormatValue.
		 * @return the name.
		 */
		public final String getName() {
			return name;
		}
		
		/**
		 * Returns all the data values of the FormatValue.
		 * @return the data values.
		 */
		public final List<Value> getDataValues() {
			return data_values;
		}
		
		/**
		 * Returns the value with the specified parent name.
		 * @param par1 the name of the parent.
		 * @return the value.
		 */
		public final String getValue(String par1) {
			for (String var1: values) {
				if (var1.startsWith(par1 + "->")) {
					return var1.split(Pattern.quote(VAR_SEP))[1];
				}
			}
			return null;
		}
		
		public final boolean hasValue(String par1) {
			for (String var1: values) {
				if (var1.contains(par1 + "->")) {
					return true;
				}
			}
			return false;
		}
		
		/**
		 * Returns all values in unparsed form.
		 * @return the values.
		 */
		public final String[] getValues() {
			return values;
		}
		
	}

	public static final String val(String par1, Object par2) {
		if (par2 instanceof Location) {
			return new Value(par1, DataFormatter.toSimpleString((Location) par2)).getSource();
		} else if (par2 instanceof Player) {
			return new Value(par1, DataFormatter.toString((Player) par2)).getSource();
		} else if (par2 instanceof Inventory) {
			return new Value(par1, DataFormatter.toSimpleString((Inventory) par2)).getSource();
		} else if (par2 instanceof ItemStack) {
			return new Value(par1, DataFormatter.toSimpleString((ItemStack) par2)).getSource();
		} else if (par2 instanceof Enchantment) {
			return new Value(par1, DataFormatter.toSimpleString((Enchantment) par2)).getSource();
		}
		return new Value(par1, par2).getSource();
	}
	
	public static final boolean isEmpty(String... par1) {
		return (par1.length == 0 || par1 == null);
	}

	public static final boolean isEmpty(String par1) {
		return (par1 == null || par1.length() == 0 || par1 == "" || par1.isEmpty());
	}
	
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
	
	/**
	 * Returns whether the specified String is of valid format.
	 * @param par1 the String to check.
	 * @return the end-result.
	 */
	public static final boolean isValidFormat(String par1) {
		return (par1.startsWith("[") && par1.endsWith("}]") && par1.contains(":{"));
	}
	
	/**
	 * Serializes the String into readable format.
	 * @param par1 the name of the FormatValue.
	 * @param par2 the values of the FormatValue.
	 * @return the unparsed String.
	 */
	public static final String toFormat(String par1, String... par2) {
		String var1 = "";
		if (!isEmpty(par1) && !isEmpty(par2)) {
			var1 += "[" + par1 + ":{" + toString((Object[]) par2) + "}]";
		}
		return var1;
	}

	/**
	 * Returns whether the specified format-string is of the specified type.
	 * @param par1 the String to check.
	 * @param par2 the type to check for.
	 * @return the end-result.
	 */
	public static final boolean instanceOf(String par1, String par2) {
		return par1.contains("[" + par2 + ":{") && par1.endsWith("}]");
	}

	// //

	/**
	 * Separates the specified objects into a String.<br>
	 * Used for the format that is used for serialization.
	 * @param par1 the array of objects to separate.
	 * @return the end-result.
	 */
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
	
	public static final String[] toStringArray(Object... par1) {
		return Arrays.copyOf(par1, par1.length, String[].class);
	}
	
	@SuppressWarnings("deprecation")
	public static final String toSimpleString(Enchantment par1) {
		return "(" + toString(par1.getId(), par1.getItemTarget().toString()) + ")";
	}

	/**d
	 * Serializes the specified Location into a readable String.
	 * @param par1 the Location to use.
	 * @return the end-result.
	 */
	public static final String toSimpleString(Location par1) {
		return "(" + toString(par1.getBlockX(), par1.getBlockY(), par1.getBlockZ(), par1.getYaw(), par1.getPitch()) + ")";
	}

	/**
	 * Serializes the specified ItemStack into a readable String.
	 * @param par1 the ItemStack to use.
	 * @return the end-result.g
	 *
	 */
	public static final String toSimpleString(ItemStack par1) {
		return "(" + toString(par1.getType(), par1.getAmount(), par1.getItemMeta().getDisplayName(), par1.getItemMeta().getLore()) + ")";
	}

	/**
	 * Serializes the specified Inventory into a readable String.
	 * @param par1 the Inventory to use.
	 * @return the end-result.
	 */
	public static final String toSimpleString(Inventory par1) {
		return "(" + toString(par1.getContents()) + ")";
	}

	public static final String toString(Player par1) {
		return toFormat("Player", val("Name", par1.getName()), val("Location", par1.getLocation()), val("Inventory", par1.getInventory()));
	}

}
