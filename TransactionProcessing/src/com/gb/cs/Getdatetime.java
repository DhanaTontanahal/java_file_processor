package com.gb.cs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Getdatetime {

	private static final DateTimeFormatter dtf = DateTimeFormatter
			.ofPattern("yyyyMMddHHmmss");

	public static StringBuilder get() {

		StringBuilder str = new StringBuilder();
		LocalDateTime now = LocalDateTime.now();
		// System.out.println(dtf.format(now));
		return str.append(dtf.format(now));

	}

}
