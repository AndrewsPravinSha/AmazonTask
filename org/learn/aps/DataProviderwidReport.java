package org.learn.aps;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import aps.pojo.OrangePojo;
import aps.util.BaseClass;
import aps.util.testData;

public class DataProviderwidReport extends BaseClass {
	OrangePojo op;
	ExtentReports report;
	ExtentTest test;


	@Test( dataProviderClass = testData.class,dataProvider = "loginData")
	private void orangeData(String userName, String passWord) {
		readPropertyFile();
		report = new ExtentReports(prop.getProperty("reportPath") + "Orange.html");
		test = report.startTest("--Credential Validation--");
		op = new OrangePojo();
		openBrowser(prop.getProperty("browser"));
		test.log(LogStatus.INFO, "Browser Initialized");
		launchUrl(prop.getProperty("orangeUrl"));
		passInput(op.getOrangeUserId(), userName);
		passInput(op.getOrangePassword(), passWord);
		clickButton(op.getOrangeSubmitBtn());
		test.log(LogStatus.INFO, "Credentials Submitted");

//		if (op.getInvalidCred().isDisplayed()==true) {
//			System.out.println("Invalid");
//			//test.log(LogStatus.FAIL, "Invalid Credentials");
//		} 
		
		if (currentUrl().contains("dashboard")){
			test.log(LogStatus.PASS, "Valid Credentials");
			System.out.println("valid");
		} else {
			System.out.println("Invalid");
			test.log(LogStatus.FAIL, "Invalid Credentials");
		}
		
	}

	@AfterClass
	private void browserOut() {
		closeBrowser();
		report.endTest(test);
		report.flush();

	}

}
