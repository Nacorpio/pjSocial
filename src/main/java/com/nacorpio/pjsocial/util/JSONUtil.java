package com.nacorpio.pjsocial.util;

import java.util.HashMap;
import java.util.regex.Pattern;

public final class JSONUtil {

	// {"valid":"false","message":"The api entered in the config doesn't seem to exist in our database. Please verify that you've registered on our website and followed the setup wizard."}
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

	public static final HashMap<String, String> getValues(String par1) {
		HashMap<String, String> values = new HashMap<String, String>();
		String var1 = par1.split(Pattern.quote("{"))[1].split(Pattern.quote("}"))[0];
		String[] var2 = var1.split(Pattern.quote(","));
		for (String var : var2) {
			String val = var.replace("\"", "");
			values.put(val.split(Pattern.quote(":"))[0], val.split(Pattern.quote(":"))[1]);
		}
		return values;
	}

	public static final String toJSON(HashMap<String, String> par1) {
		String var1 = "{";
		String[] keys = (String[]) par1.keySet().toArray();
		String[] values = (String[]) par1.values().toArray();
		for (String key: keys) {
			for (String val: values) {
				var1 += toJSONValue(key, val);
			}
		}
		var1 += "}";
		return var1;
	}
	
	private static final String toJSONValue(String par1, String par2) {
		return "\"" + par1 + "\":\"" + par2 + "\"";
	}
	
}
