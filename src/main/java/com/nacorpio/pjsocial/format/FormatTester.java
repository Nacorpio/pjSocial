package com.nacorpio.pjsocial.format;

import java.util.HashMap;

import com.nacorpio.pjsocial.util.JSONUtil;

public final class FormatTester {

	public static void main(String[] args) {
		HashMap<String, String> vals = new HashMap<String, String>();
		vals.put("name", "value");
		vals.put("boolean", "false");
		System.out.println(JSONUtil.toJSON(vals));
	}

}
