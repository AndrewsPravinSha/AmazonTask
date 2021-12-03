package aps.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static Actions ac;
	public static Properties prop;
	public static JavascriptExecutor js;
	public static WebDriver driver;

	public void openBrowser(String browser) {
		DriverInit init = DriverInit.getInstance();
		driver = init.browserConfig(browser);
	}

	public static void passInput(WebElement element, String value) {
		element.sendKeys(value);

	}

	public static void clickButton(WebElement element) {
		element.click();

	}

	public static void hoverCursorClick(WebElement element) {
		ac = new Actions(driver);
		ac.moveToElement(element).click().build().perform();

	}

	public static void mouseHover(WebElement element) {
		ac = new Actions(driver);
		ac.moveToElement(element).build().perform();

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

	public static void closeBrowser() {
		driver.quit();
	}

	public static String windowHandle() {
		String handle = driver.getWindowHandle();
		return handle;
	}

	public static void jumpTowindow(int index) {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>();
		list.addAll(windowHandles);
		driver.switchTo().window(list.get(index));
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

	public static void screenCapture(String fileName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "\\ScreenCaptures\\" + fileName + ".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void jsClick(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public static void scrollDown() {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)", "");
	}

	public static void jsAlert() {
		js.executeScript("alert('Alert is Present');");
	}

	public static List<WebElement> listGetElements(String xpathExpression) {
		List<WebElement> list = driver.findElements(By.xpath(xpathExpression));
		return list;
	}

	public static void uploadFile(String fileLocation) {
		// TODO Auto-generated method stub
		try {
			// Setting clip board with file location
			setClipboardData(fileLocation);
			// native key strokes for CTRL, V and ENTER keys

			Robot robot = new Robot();
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(1000);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

	public static void setClipboardData(String string) {
		// StringSelection is a class that can be used for copy and paste operations.

		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	public static String excelRead(String workbook, int rowNum, int cellNum) {
		Workbook wb;
		String value = "";
		try {
			File srcPath = new File(System.getProperty("user.dir") + "\\Excel\\" + workbook + ".xlsx");
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

	public static String excelWrite(String workbook, int rowNum, int cellNum, String setValue) {
		Workbook wb;
		try {
			File srcPath = new File(System.getProperty("user.dir") + "\\Excel\\" + workbook + ".xlsx");
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

	public static void readPropertyFile() {
		try {
			File srcPath = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
			FileInputStream fis = new FileInputStream(srcPath);
			prop = new Properties();
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/*
	 * public static void excelIterator(String path, int indexNum,String name)
	 * throws IOException { File srcPath = new File(path); FileInputStream fis = new
	 * FileInputStream(srcPath); Workbook wb = new XSSFWorkbook(fis); Sheet sheetAt
	 * = wb.getSheetAt(indexNum); Iterator<Row> rowIterator = sheetAt.iterator();
	 * while (rowIterator.hasNext()) { Row rowValue = rowIterator.next();
	 * Iterator<Cell> columnIterator = rowValue.iterator();
	 * while(columnIterator.hasNext()) { Cell cellValue = columnIterator.next(); } }
	 * 
	 * 
	 * }
	 */

}
