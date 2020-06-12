package com.gb.cs;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteToFile {

	static PrintWriter writer = null;

	private static String pathToFile = Constants.pathToFile;

	private static String reportFileName = Constants.reportFileName;

	private static String extensionForReport = "txt";

	public static void write(String content) {

		try {
			writer = new PrintWriter(pathToFile + "/reports" + "/"
					+ reportFileName + "_" + Getdatetime.get() + "."
					+ extensionForReport);
			writer.write("Created on : (YYYYMMDDHHmmss)"
					+ System.lineSeparator() + Getdatetime.get()
					+ System.lineSeparator());
			writer.append(content);
			writer.flush();
			writer.close();
			System.out.println("Done with processing:success");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
