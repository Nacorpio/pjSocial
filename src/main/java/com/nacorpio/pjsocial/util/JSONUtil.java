package com.nacorpio.pjsocial.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;

public final class JSONUtil {

	public static String val = "{\"valid\":\"false\",\"message\":\"The api entered in the config doesn\'t seem to exist in our database. Please verify that you\'ve registered on our website and followed the setup wizard.\"}";
	public static final String getValue(String par1, String par2) {
		String var1 = par1.split(Pattern.quote("{"))[1].split(Pattern.quote("}"))[0];
		String[] var2 = var1.split(Pattern.quote(",")); // "valid":"false"
		for (String var : var2) {
			if (var.startsWith("\"" + par2)) {
				String value = var.split(Pattern.quote(":"))[1];
				return value.replace("\"", "");
			}
		}
		return null;
	}

	public static final String getContent(String par1, String par2) {
		String var1 = "";
		var1 = par1.split(Pattern.quote("{\"" + par2 + "\":{"))[1].split(String.valueOf(par1.toCharArray()[par1.lastIndexOf("}")]))[0];
		return var1;
	}
	
	public static final HashMap<String, String> getValues(String par1) {
		HashMap<String, String> values = new HashMap<String, String>();
		String var1 = par1.split(Pattern.quote("{"))[1].split(Pattern.quote("}"))[0].replace(',', '_');
		String[] var2 = var1.split(Pattern.quote(","));
		for (String var : var2) {
			String val = var.replace("\"", "").replace('_', ',');
			values.put(val.split(Pattern.quote(":"))[0], val.split(Pattern.quote(":"))[1]);
		}
		return values;
	}

	public static final String toJSON(HashMap<String, String> par1) {
		String var1 = "{";
		String[] keys = Arrays.copyOf(par1.keySet().toArray(), par1.size(), String[].class);
		String[] values = Arrays.copyOf(par1.values().toArray(), par1.size(), String[].class);
		for (int i = 0; i < par1.size(); i++) {
			if (i < par1.size() - 1) {
				var1 += toJSONValue(keys[i], values[i]) + ",";
			} else {
				var1 += toJSONValue(keys[i], values[i]);
			}
		}	
		var1 += "}";
		return var1;
	}
	
	private static final String toJSONValue(String par1, String par2) {
		return "\"" + par1 + "\":\"" + par2 + "\"";
	}
	
}
