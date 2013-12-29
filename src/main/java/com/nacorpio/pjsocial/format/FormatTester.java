package com.nacorpio.pjsocial.format;

import java.util.HashMap;

import com.nacorpio.pjsocial.util.DebugUtil;
import com.nacorpio.pjsocial.util.JSONUtil;

public final class FormatTester {

	public static void main(String[] args) {
		System.out.println(JSONUtil.isJSON("{\"valid\":\"true\",\"another\":\"maybe\"}"));
	}

}
