package org.learn.aps;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import aps.pojo.OrangePojo;
import aps.util.BaseClass;

public class spare extends BaseClass{
	   @Test()
	   private void report() {
		readPropertyFile();
		OrangePojo op = new OrangePojo();
		openBrowser(prop.getProperty("browser"));
		launchUrl(prop.getProperty("orangeUrl"));
		passInput(null, null);

	}
}
