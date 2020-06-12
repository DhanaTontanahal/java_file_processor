package com.gb.cs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Date;
import java.util.logging.Logger;

public class CopyFile {
	 private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private static String pathToFile = Constants.pathToFile;

	private static final String transactionFileNameToBeProcessed = Constants.transactionFileNameToBeProcessed
			.substring(0,
					Constants.transactionFileNameToBeProcessed.indexOf("."))
			+ Constants.postFixProcessed + ".csv";

	private static final String transactionFileNameProcessed = Constants.transactionFileNameProcessed
			.substring(0, Constants.transactionFileNameProcessed.indexOf("."))
			+ "-" + Constants.postFixProcessed + ".csv";

	public static void copyT() {

		File sourceFile = new File(pathToFile + "/pending/"
				+ transactionFileNameToBeProcessed);

		File destFile = new File(pathToFile + "/processed/"
				+ transactionFileNameProcessed);


		if (!sourceFile.exists()) {
			LOGGER.info("Source file not found");
		
		}

		
		if (!destFile.exists()) {
			try {
				destFile.createNewFile();
				LOGGER.info("Destination file doesn't exist. Creating one!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		FileChannel source = null;
		FileChannel destination = null;

		try {

			source = new FileInputStream(sourceFile).getChannel();

			destination = new FileOutputStream(destFile).getChannel();
			LOGGER.info("Copying files to processed folder");
			
			if (destination != null && source != null) {
				destination.transferFrom(source, 0, source.size());

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			if (source != null) {
				try {
					source.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (destination != null) {
				try {
					destination.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			LOGGER.info("Deleting source file from pending folder");
			sourceFile.delete();
			LOGGER.info("Successfully completed the process at "+new Date());
		}
	}

}