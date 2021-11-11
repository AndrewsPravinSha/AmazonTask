package org.learn.aps;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class PropertyFileSample {
	
	static Logger logger = Logger.getLogger(PropertyFileSample.class);
	
	public static void main(String[] args) {
		
		PropertyConfigurator.configure("Log4j.properties");
		logger.debug("Debug Message");
		logger.info("Info Message");
		logger.warn("Warning Message");
		logger.error("Error Message");
		logger.fatal("fatal meesage");
	}

}
