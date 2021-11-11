package org.learn.aps;

import org.practical.base.BaseClass;
import org.practical.pojo.OrangePojo;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ConfigurationTask extends BaseClass{
	OrangePojo op;
	
	@BeforeClass
	private void browser() {
		//Browser configuration using Property Files
		readPropertyFile();
		browserConfig(prop.getProperty("browser"));
		
		op = new OrangePojo();	
		windowMaximize();
	}
	@Test
	private void credentialIterator() {
		for (int i = 1; i < 4; i++) {
			credentialExecutor(i);
			credentialValidator(i);
		}		
	}
	@AfterClass
	private void browserOut() {
		exitBrowser();
	}
	private void credentialExecutor(int rowNum) {
		//Launching url from Config.properties file
		launchUrl(prop.getProperty("orangeUrl"));
		
		passInput(op.getOrangeUserId(), excelRead("OrangeTask", rowNum, 0));
		passInput(op.getOrangePassword(), excelRead("OrangeTask", rowNum, 1));
		hoverCursorClick(op.getOrangeSubmitBtn());
	}
	private void credentialValidator(int rowNum) {
		//If the credentials are valid then the welcome page should contain "dashboard" in url.
		if (currentUrl().contains("dashboard")){
			excelWrite("OrangeTask", rowNum, 2, "Valid");
		}else {
			excelWrite("OrangeTask", rowNum, 2, "Invalid");
		}
	}

}
