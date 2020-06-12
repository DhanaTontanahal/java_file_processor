package com.gb.cs;

public class ExtractPostfix {

	public static String postFixExtract(String fileName) {
		return fileName.substring(fileName.indexOf("transactions") + 12,
				fileName.indexOf("."));

	}

}
