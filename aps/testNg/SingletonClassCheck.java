package aps.testNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import aps.util.BaseClass;


public class SingletonClassCheck extends BaseClass{
	
	@BeforeClass
	private void setUp() {
		readPropertyFile();
		openBrowser(prop.getProperty("browser"));
	}
	
	@Test
	private void testCase() {
		launchUrl("https://www.amazon.in");
		System.out.println(driver.getTitle());
	}
	
	@AfterClass
	private void tearDown() {
		closeBrowser();
	}
	

}
