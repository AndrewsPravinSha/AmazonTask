package org.learn.aps;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import aps.pojo.AmazonPojo;
import aps.util.BaseClass;

public class LoggerTask2 extends BaseClass{
	AmazonPojo ap;
	
	static Logger logger = Logger.getLogger(LoggerTask2.class);
	
	@Parameters("browser")
	@BeforeClass
	private void browserIn(String browser) {
		readPropertyFile();
		openBrowser(browser);
		windowMaximize();
		ap = new AmazonPojo();
		PropertyConfigurator.configure(prop.getProperty("Log4jProperty"));
		logger.info("Browser Opened..");
		
	}
	@Test
	private void searchOrder() {
		launchUrl(prop.getProperty("amazonUrl"));
		logger.debug("Url launched");
		passInput(ap.getAmzSearchBox(),excelRead("AmazonTask", 1, 0));
		hoverCursorClick(ap.getAmzSearchButton());
		logger.info("Search Results");
		screenCapture("searchResult");	
	}
	@Test(dependsOnMethods = {"searchOrder"})
	private void placeOrder() {
		hoverCursorClick(ap.getAmzChoice());
		clickButton(ap.getAddtoCartButton());
		screenCapture("orderPlaced");
		WebElement element = explicitlyWait(ap.getCartButton());
		element.click();
		logger.info("Order placed in Cart successfully");
		
	}
	@Test(dependsOnMethods = {"placeOrder"})
	private void deleteOrder() {
		hoverCursorClick(ap.getDeleteOrder());
		logger.info("Order deleted in Cart");
		screenCapture("orderDeleted");
	}
	
	@AfterClass
	private void browserOut() {
		closeBrowser();
		logger.info("..Browser Closed");
	}

}
