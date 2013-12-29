package com.nacorpio.pjsocial.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class DebugUtil {

	public static final void debug(Map<?, ?> par1) {
		debug(par1);
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
