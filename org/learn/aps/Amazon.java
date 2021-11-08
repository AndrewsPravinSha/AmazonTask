package org.learn.aps;


import java.io.IOException;
import org.practical.base.BaseClass;
import org.practice.pojo.AmazonPojo;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Amazon extends BaseClass{
	AmazonPojo ap;
	@BeforeClass
	private void browserIn() {
		chromeBrowser();
		ap = new AmazonPojo();
		windowMaximize();
	}
	@Test
	private void testCase1() throws IOException, InterruptedException {
		for (int i = 1; i < 5; i++) {
			productIterator(i);
		}
	}
	@AfterClass
	private void browserOut() {
		exitBrowser();
	}


	private void productIterator(int rowNum) throws IOException, InterruptedException {
		launchUrl("https://www.amazon.in/");
		passInput(ap.getAmzSearchBox(),excelRead(rowNum, 0));
		addtoCartMsg(rowNum, 1);

	}
	private void addtoCartMsg(int rowNum,int colnNum) throws IOException, InterruptedException {
		hoverCursorClick(ap.getAmzSearchButton());
		hoverCursorClick(ap.getAmzChoice());
		hoverCursorClick(ap.getAddtoCartButton());
		Thread.sleep(3000);
		if (ap.getCartButton().isDisplayed()==true) {
			excelWrite(rowNum, colnNum,"The Product is added to cart");
		} else {
			excelWrite(rowNum, colnNum,"The Product is not added to cart");
		}
	}
}

