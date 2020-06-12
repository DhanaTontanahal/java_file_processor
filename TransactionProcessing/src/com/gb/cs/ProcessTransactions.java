package com.gb.cs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

import com.gb.cs.encrypt.CryptoUtil;

public class ProcessTransactions {

	 private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	 
	private static final String transactionFileNameToBeProcessed = Constants.transactionFileNameToBeProcessed;

	private static BufferedReader br = null;

	private static String line = "";

	private static String cvsSplitBy = ",";

	private static String pathToFile = Constants.pathToFile;

	private static int totalLines = 0;

	private static int skippedTransactions = 0;

	private static double credit = 0;

	private static double debit = 0;

	private static boolean isFileProcessed;

	private static Scanner scanner;

	public static void processFileTransactions() throws Exception {
		
		String homeDir = pathToFile + "/pending";
		LOGGER.info("processing transactions...");
		
		File[] filNames = new File(homeDir).listFiles();
		if (filNames.length == 0)
			LOGGER.info("waiting for the new transaction files to be written to the target folder");
		for (int i = 0; i < filNames.length; i++) {

			if (filNames[i].isFile()
					&& filNames[i].getName().toString().contains("finance")) {
				String originalFileName = filNames[i].getName().toString();
				String postFixProcessed = ExtractPostfix
						.postFixExtract(originalFileName);
				Constants.postFixProcessed = postFixProcessed;
				try {
					br = new BufferedReader(new FileReader(homeDir + "/"
							+ originalFileName));
					while ((line = br.readLine()) != null) {
						String[] values = line.split(cvsSplitBy);
						if (values.length > 1) {
							if (!(values[0].toString()
									.contains("Customer Account#"))) {
								totalLines += 1;
								if (!(values[0].matches("^[0-9]+$")))
									skippedTransactions = skippedTransactions + 1;

								if ((values[0].matches("^[0-9]+$"))
										&& Double.parseDouble(values[1]) < 0)
									debit = (values[0].matches("^[0-9]+$")) ? debit
											+ Double.parseDouble(values[1])
											: 0;

								else if ((values[0].matches("^[0-9]+$"))
										&& Double.parseDouble(values[1]) >= 0)
									credit = (values[0].matches("^[0-9]+$")) ? credit
											+ Double.parseDouble(values[1])
											: 0;

							}
						} else {
							break;
						}

					}
					LOGGER.info("File processing done");
					WriteToFile.write("File processed :" + originalFileName
							+ System.lineSeparator() + "Total Accounts :"
							+ totalLines + " " + System.lineSeparator()
							+ "Total Credit Amount :" + "$" + credit + ""
							+ System.lineSeparator() + "Total Debit Amount :"
							+ "$" + debit + System.lineSeparator()
							+ "Skipped Transactions :" + skippedTransactions);
					ReadPropertiesFile.readConfig();
					LOGGER.info("Decrypting password for sending mail");
					String originalPassword = CryptoUtil.decrypt(Constants.key,  Constants.setPassword);
					LOGGER.info("Sending email");
					new GMailServer(Constants.setFrom,originalPassword)
							.sendMail(
									"Reminder mail:Processing done",
									"File processed :" + originalFileName
											+ System.lineSeparator()
											+ "Total Accounts :" + totalLines
											+ " " + System.lineSeparator()
											+ "Total Credit Amount :" + "$"
											+ credit + ""
											+ System.lineSeparator()
											+ "Total Debit Amount :" + "$"
											+ debit + System.lineSeparator()
											+ "Skipped Transactions :"
											+ skippedTransactions,
									Constants.setFrom, Constants.emailTO);
					isFileProcessed = true;

				} catch (IOException e) {

					e.printStackTrace();
				}

			}
			if (isFileProcessed) {
				br.close();
				CopyFile.copyT();
				break;
			}

		}

	}

}
