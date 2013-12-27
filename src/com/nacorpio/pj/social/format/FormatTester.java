package com.nacorpio.pj.social.format;

import com.nacorpio.pj.social.serialization.Section;

public final class FormatTester {

	public static void main(String[] args) {
		Section var1 = new Section();
		var1.addProperty("One");
		var1.addProperty("Two");
		var1.addProperty("Three");
		System.out.println(var1.getContent());
	}

}
