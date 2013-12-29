package com.nacorpio.pjsocial.util;

import java.util.Arrays;
import java.util.HashMap;

public final class DebugUtil {

	public static final void debug(HashMap<Object, Object> par1) {
		String output = "";
		String[] keys = Arrays.copyOf(par1.keySet().toArray(), par1.size(), String[].class);
		String[] values = Arrays.copyOf(par1.values().toArray(), par1.size(), String[].class);
		System.out.println("==== [Size: " + par1.size() + "] ====");
		for (int i = 0; i < par1.size(); i++) {
			output += keys[i] + " : " + values[i] + "\n";
		}
		System.out.println("==== =========================== ====");
		System.out.println(output);
	}
	
}
