package com.gb.cs;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class ReadPropertiesFile {
	 private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	public static void readConfig() throws Exception {
		try {

			LOGGER.info("Setting the properties");
			Properties pro = new Properties();
			String path = Constants.pathToFile
					+ "/properties/TransactionProcessing_Props.properties";
			pro.load(new FileInputStream(path));

			Constants.delay = pro.getProperty("delay");
			Constants.timetoquery = pro.getProperty("timetoquery");
			Constants.setFrom = pro.getProperty("setFrom");
			Constants.setPassword = pro.getProperty("setPassword");
			Constants.emailTO = pro.getProperty("emailTO");
			Constants.schedule1 = pro.getProperty("schedule1");
			Constants.schedule2 = pro.getProperty("schedule2");
			Constants.key = pro.getProperty("key");
			

		} catch (Exception e) {
			throw new Exception(e);
		}

	}

}
