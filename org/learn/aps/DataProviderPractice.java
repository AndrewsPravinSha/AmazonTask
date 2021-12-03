package org.learn.aps;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import aps.pojo.FbPojo;
import aps.util.BaseClass;

public class DataProviderPractice extends BaseClass{
	FbPojo fb;
	@DataProvider(name = "loginData")
	public static String[][] getData() {
		String [][] data= {{"andrews","qwert123"},
				           {"Anand","asdfg123"},
				           {"Ajith","123456"},
				           {"ferdin","poiter"}
		};

		return data;
	}

	@Test(dataProvider = "loginData")
	private void testCase1(String userName, String passWord) {
		readPropertyFile();
		fb = new FbPojo();
		openBrowser(prop.getProperty("browser"));
		windowMaximize();
		launchUrl(prop.getProperty("fbUrl"));
		
		passInput(fb.getFbEmail(),userName);
		passInput(fb.getFbPaswrd(), passWord);
		hoverCursorClick(fb.getFbLoginButton());
		
	}
	@AfterClass
	private void browserOut() {
		closeBrowser();

	}
	

}
