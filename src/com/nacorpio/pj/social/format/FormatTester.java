package com.nacorpio.pj.social.format;

import java.util.regex.Pattern;

import com.nacorpio.pj.social.serialization.Section;
import com.nacorpio.pj.social.util.SerializationUtil;

public final class FormatTester {

	public static void main(String[] args) {
		Section var1 = new Section();
		var1.addProperty("Name: [Value1,Value2]");
		System.out.println(SerializationUtil.getArray("Name", var1.getContent())[0]);
	}

}
