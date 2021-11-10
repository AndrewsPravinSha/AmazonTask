package org.practical.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.config.configuration.PropertiesFile;
import org.learn.aps.ConfigurationTask;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Actions ac;
	public static Properties prop;

	public static void browserConfig(String browser) {
		if (browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		if (browser.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		if (browser.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

	}
	public static void passInput(WebElement element,String value) {
		element.sendKeys(value);

	}
	public static void clickButton(WebElement element) {
		element.click();

	}
	public static void hoverCursorClick(WebElement element) {
		ac = new Actions(driver);
		ac.moveToElement(element).click().build().perform();

	}
	public static void launchUrl(String url) {
		driver.navigate().to(url);
	}
	public static String currentUrl() {
		String url = driver.getCurrentUrl();
		return url;

	}
	public static void windowMaximize() {
		driver.manage().window().maximize();
	}
	public static void exitBrowser() {
		driver.quit();
	}
	public static boolean isDisplay(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}
	public static void implicitlyWait() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	public static WebElement explicitlyWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement until = wait.until(ExpectedConditions.elementToBeClickable(element));
		return until;
	}
	public static String getTextFrm(WebElement element) {
		String text = element.getText();
		return text;
	}
	public static void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	}

	public static String excelRead(String workbook,int rowNum,int cellNum) {
		Workbook wb;
		String value = "";
		try {
			File srcPath = new File(System.getProperty("user.dir")+"\\Excel\\"+workbook+".xlsx");
			FileInputStream fis = new FileInputStream(srcPath);
			wb = new XSSFWorkbook(fis);
			Sheet sheetAt = wb.getSheetAt(0);
			Row row = sheetAt.getRow(rowNum);
			Cell cell = row.getCell(cellNum);
			value = cell.getStringCellValue();		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
		
		
	}

	public static String excelWrite(String workbook,int rowNum,int cellNum,String setValue) {
		Workbook wb;
		try {
			File srcPath = new File(System.getProperty("user.dir")+"\\Excel\\"+workbook+".xlsx");
			FileInputStream fis = new FileInputStream(srcPath);
			wb = new XSSFWorkbook(fis);
			Sheet sheetAt = wb.getSheetAt(0);
			Row row = sheetAt.getRow(rowNum);
			Cell cell = row.createCell(cellNum);
			cell.setCellValue(setValue);
			FileOutputStream fos = new FileOutputStream(srcPath);
			wb.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return setValue;

	}

	public static void excelIterator(String path, int indexNum,String name) throws IOException { 
		File srcPath = new File(path); 
		FileInputStream fis = new FileInputStream(srcPath);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetAt = wb.getSheetAt(indexNum);
		Iterator<Row> rowIterator = sheetAt.iterator();
		while (rowIterator.hasNext()) {
			Row rowValue = rowIterator.next();
			Iterator<Cell> columnIterator = rowValue.iterator();
			while(columnIterator.hasNext()) {
				Cell cellValue = columnIterator.next();
			}
		}


	}
	public static void readPropertyFile() {
		try {
			File srcPath = new File(System.getProperty("user.dir")+"\\src\\test\\java\\org\\config\\configuration\\config.properties");
			FileInputStream fis = new FileInputStream(srcPath);
			prop = new Properties();
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
			

	}



}
