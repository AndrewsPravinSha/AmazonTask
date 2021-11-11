package org.learn.aps;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class spare {
	   @Test()
	   private void report() {
		ExtentReports reports = new ExtentReports(System.getProperty("user.dir")+"\\Reports\\firstTry.html");
		ExtentTest test = reports.startTest("First Attempt");
		test.log(LogStatus.INFO,"Test Started");
		test.log(LogStatus.FATAL, "Fatal Defect");
		test.log(LogStatus.WARNING, "Warning Message");
		test.log(LogStatus.PASS, "testcase passed");
		test.log(LogStatus.SKIP, "testcase skipped");
		test.log(LogStatus.FAIL, "testcase failed");
		reports.endTest(test);
		reports.flush();

	}
}
