package com.nacorpio.pjsocial.format;

import java.util.HashMap;

import com.nacorpio.pjsocial.util.DebugUtil;
import com.nacorpio.pjsocial.util.JSONUtil;

public final class FormatTester {

	public static void main(String[] args) {
		HashMap<String, String> var1 = new HashMap<String, String>();
		var1.put("name", "value");
		var1.put("valid", "false");
		DebugUtil.debug(var1);
	}

}
