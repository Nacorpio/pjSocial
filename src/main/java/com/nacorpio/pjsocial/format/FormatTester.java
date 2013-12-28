package com.nacorpio.pjsocial.format;

import com.nacorpio.pjsocial.serialization.Section;

public final class FormatTester {

	public static void main(String[] args) {
		Section var1 = new Section();
		var1.addProperty("Name: [Hello,Fishy]");
		var1.addProperty("Health: [Kishy,Nishy]");
		var1.addProperty("Position: [0,0,0,0,0]");
		System.out.println(var1.getArray("Name")[0]);
	}

}
