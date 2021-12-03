package aps.testing.playground;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdvancedWebTable {
	@Test
	private void browserIn() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.uitestingplayground.com/dynamictable");
		List<WebElement> headers = driver.findElements(
				By.xpath("//span[@role='columnheader']"));
		int cpuCount = 0;
		for (WebElement element : headers) {
			String value = element.getText();
			while(value.equalsIgnoreCase("CPU")) {
				cpuCount = headers.indexOf(element);
				break;
			}
		}
		String chrXpath = 
				"//div[@role='row']//span[contains(text(),'Chrome')]//following::span["+cpuCount+"]";
		WebElement chromeValue = driver.findElement(By.xpath(chrXpath));
		String cpuValue = chromeValue.getText();
		
		WebElement warning = driver.findElement(By.xpath("//p[contains(text(),'CPU')]"));
		String orgValue = warning.getText();
		boolean contains = orgValue.contains(cpuValue);
		System.out.println(contains);

	}

}
