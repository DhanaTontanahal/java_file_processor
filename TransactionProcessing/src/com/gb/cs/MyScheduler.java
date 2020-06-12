package com.gb.cs;

import java.util.Date;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.gb.cs.logging.MyLogger;

public class MyScheduler {

	 private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	public void callScheduler() throws Exception {

		LOGGER.setLevel(Level.SEVERE);
        LOGGER.severe("Info Log");
        MyLogger.setup();
        
        LOGGER.info("Customer Transaction Processing started at "+new Date());
		
		ReadPropertiesFile.readConfig();
		Timer timer = new Timer();

		timer.scheduleAtFixedRate(new MyTask(),
				getTimePrecision(Constants.delay),
				getTimePrecision(Constants.timetoquery));

	

	}

	public long getTimePrecision(String value) throws Exception {
		long l = 0;
		String val = "";
		try {
			if (value.endsWith("d") || value.endsWith("D")) {
				val = value.substring(0, value.length() - 1);
				l = Long.parseLong(val) * 24 * 60 * 60 * 1000;
			}

			else if (value.endsWith("h") || value.endsWith("H")) {

				val = value.substring(0, value.length() - 1);
				l = Long.parseLong(val) * 60 * 60 * 1000;

			} else if (value.endsWith("m") || value.endsWith("M")) {
				val = value.substring(0, value.length() - 1);
				l = Long.parseLong(val) * 60 * 1000;
			} else if (value.endsWith("s") || value.endsWith("S")) {

				val = value.substring(0, value.length() - 1);
				l = Long.parseLong(val) * 1000;
			} else {

				l = Long.parseLong(value);
			}

		} catch (Exception e) {

			throw new Exception(e);
		}

		return l;
	}

	public static void main(String a[]) throws Exception {
		MyScheduler customerTransactionProcessing = new MyScheduler();
		customerTransactionProcessing.callScheduler();
	}

}