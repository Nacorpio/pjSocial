package com.nacorpio.pjsocial.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class DebugUtil {

	public static final String buildLog(Exception par1) {
		HashMap<String, String> var1 = new HashMap<String, String>();
		var1.put("message", par1.getMessage());
		var1.put("localization", par1.getLocalizedMessage());
		var1.put("cause", par1.getCause().getMessage());
		return JSONUtil.toJSON(var1);
	}
	
	public static final void debug(Map<?, ?> par1) {
		debug(par1);
	}
	
	public static final void debug(Object par1, Exception par2) {
		System.out.println("==== [ID: \'" + par1 + "\' debugging] ====");
		System.out.println("Message: " + par2.getMessage());
		System.out.println("Localization: " + par2.getLocalizedMessage());
		System.out.println("Cause: " + par2.getCause().toString());
		System.out.println("========");
	}
	
	public static final void debug(HashMap<?, ?> par1) {
		String output = "";
		String[] keys = Arrays.copyOf(par1.keySet().toArray(), par1.size(), String[].class);
		String[] values = Arrays.copyOf(par1.values().toArray(), par1.size(), String[].class);
		System.out.println("==== [Size: " + par1.size() + "] ====");
		for (int i = 0; i < par1.size(); i++) {
			if (i < par1.size() - 1) {
				output += keys[i] + " : " + values[i] + "\n";
			} else {
				output += keys[i] + " : " + values[i];
			}
		}
		System.out.println(output);
		System.out.println("==== =========================== ====");
	}
	
	public static final void debug(Object... par1) {
		String output = "";
		System.out.println("==== [Size: " + par1.length + "] ====");
		for (int i = 0; i < par1.length; i++) {
			if (i < par1.length - 1) {
				output += "(" + i + "): " + par1[i] + "\n";
			} else {
				output += "(" + i + "): " + par1[i];
			}
		}
		System.out.println(output);
		System.out.println("==== =========================== ====");
	}
	
}
