package aps.testing.playground;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import aps.util.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;


public class ClickEvent extends BaseClass{
	WebDriver driver;
	
	@Test
	private void clickElement() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.uitestingplayground.com/");
		WebElement click = driver.findElement(By.xpath("//a[text()='Click']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(click).click().build().perform();
		WebElement badButton = driver.findElement(By.id("badButton"));
		badButton.click();
		

	}

}
