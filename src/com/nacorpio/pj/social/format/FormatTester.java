package com.nacorpio.pj.social.format;

import com.nacorpio.pj.social.format.DataFormatter.FormatValue;

public final class FormatTester {

	public static void main(String[] args) {
		String var1 = DataFormatter.toFormat("Player", "Name->Aazk", "Health->100");
		//Name->Aazk&Health->100
		FormatValue var2 = DataFormatter.toFormatValue(var1);
		System.out.println(var2.getValue("Health"));
	}

}
