package com.nacorpio.pj.social.format;

import java.util.regex.Pattern;

import com.nacorpio.pj.social.serialization.Section;
import com.nacorpio.pj.social.util.SerializationUtil;

public final class FormatTester {

	public static void main(String[] args) {
		Section var1 = new Section();
		var1.addProperty("Name: [Hello,Fishy]");
		var1.addProperty("Health: [Kishy,Nishy]");
		var1.addProperty("Position: [0,0,0,0,0]");
		System.out.println(var1.getSource());
	}

}
