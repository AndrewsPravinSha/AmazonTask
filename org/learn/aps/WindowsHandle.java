package org.learn.aps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandle {
	@Test
	private void testcase() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/Window.html");
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>();
		list.addAll(handles);
		WebDriver w2 = driver.switchTo().window(list.get(1));
		w2.close();
		WebDriver w3 = driver.switchTo().window(list.get(2));		
		w3.close();
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		Thread.sleep(6000);
		Set<String> handles2 = driver.getWindowHandles();
		List<String> li2 = new ArrayList<String>();
		li2.addAll(handles2);
		driver.switchTo().window(li2.get(2));
		System.out.println(driver.getTitle());

	}

}
