package com.gb.cs;

import java.util.Calendar;
import java.util.TimerTask;
import java.util.logging.Logger;

public class MyTask extends TimerTask {
	
	 private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public MyTask() {

	}

	public int getCurrentHours() {
		return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
	}

	public void run() {

		try {

			if (getCurrentHours() == Integer.parseInt(Constants.schedule1)
					|| getCurrentHours() == Integer
							.parseInt(Constants.schedule2))

			{
				LOGGER.info("scheduled for this time...");
				ProcessTransactions.processFileTransactions();

			} else {
				LOGGER.info("Scheduled for 6 HOURS OR 21 hours But now time is different:");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
