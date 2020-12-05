package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LiGlobal {
	public static WebDriver driver;
	 public static String attribute;
	public static WebDriver launchbrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pradeep\\eclipse-workspace\\driver\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;

	}

	public static void launchUrl(String url) {
		driver.get(url);

	}

	public static void CurrentPageUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

	}

	public static void maxwindow() {
		driver.manage().window().maximize();

	}

	public static void titlepage() {
		String title = driver.getTitle();
		System.out.println(title);

	}

	public static void clickButton(WebElement element) {
		element.click();

	}

	public static void submitButton(WebElement element) {
		element.submit();

	}

	public static void quittheWindows() {
		driver.quit();

	}

	public static void fill(WebElement element, String text) {
		element.sendKeys(text);

	}

	public static void getTheTextFromElement(WebElement element) {
		String text = element.getText();
		System.out.println(text);

	}

	public static String getTheTextFromAttribute(WebElement element, String value) {
		
		attribute = element.getAttribute(value);
		return attribute;
		
	}

	public static void rightClick(WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();

	}

	public static void performDoubleClick(WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();

	}

	public static void Move(WebElement element) {
		Actions a = new Actions(driver);

		a.moveToElement(element).perform();

	}

	public static void DragAndDropAction(WebElement src, WebElement dec) {
		Actions a = new Actions(driver);

		a.dragAndDrop(src, dec).perform();

	}

	public static void pressenter() {
		Actions a = new Actions(driver);

		a.keyDown(Keys.ENTER);
		a.keyUp(Keys.ENTER);
	}

	public static void pressShift() {
		Actions a = new Actions(driver);

		a.keyDown(Keys.SHIFT);
		a.keyUp(Keys.SHIFT);

	}

	public static void pressDown() {
		Actions a = new Actions(driver);
		a.keyDown(Keys.DOWN);
		a.keyUp(Keys.DOWN);
	}

	

	public static void copy() throws AWTException {
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
	}

	public static void cut() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_X);

	}

	public static void paste() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);

	}

	public static void moveToNextTab() throws AWTException {

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}

	public static void selectValue(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);

	}

	public static void selectText(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	public static void selectIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	public static void checkMultiple(WebElement element) {
		Select s = new Select(element);
		boolean multiple = s.isMultiple();
		System.out.println(multiple);
	}

	public static void deSelectAllElement(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();
	}

	public static void deselectValue(WebElement element, String value) {
		Select s = new Select(element);
		s.deselectByValue(value);

	}

	public static void deselectText(WebElement element, String text) {
		Select s = new Select(element);
		s.deselectByVisibleText(text);
	}

	public static void deselectIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.deselectByIndex(index);
	}

	public static void firstSectedElement(WebElement element) {
		Select s = new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		System.out.println(firstSelectedOption);
	}

	public static void scroolUp(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);

	}

	public static void scrollDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);

	}

	public static void hiddenAttribute(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(" return arguments[0].getAttribute('value')", element);
	}

	public static void hiddenClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public static void screenshot(String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("C:\\Users\\pradeep\\eclipse-workspace\\driver\\Screenshot\\" + name + ".png");
		FileUtils.copyFile(src, f);
	}

	public static void alertAccept() {
		Alert a = driver.switchTo().alert();
		a.accept();

	}

	public static void alertDismiss() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}

	public static void alertText(String text) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(text);

	}

	public static void allertAttribute() {
		Alert a = driver.switchTo().alert();
		String text = a.getText();
		System.out.println(text);
	}

	public static void switchToFrameByName(String name) {
		driver.switchTo().frame(name);

	}

	public static void switchToMainFrame() {
		driver.switchTo().defaultContent();

	}

	public static void switchToFrameByWebElement(WebElement element) {
		driver.switchTo().frame(element);

	}

	public static void navigateToUrl(String url) {
		driver.navigate().to(url);

	}

	public static void navigateNextPage() {
		driver.navigate().forward();

	}

	public static void navigatePreviousPage() {
		driver.navigate().back();

	}

	public static void checkWebElementEnable(WebElement element) {
		boolean enabled = element.isEnabled();
		System.out.println(enabled);

	}

	public void checkWebElementDisplay(WebElement element) {
		boolean displayed = element.isDisplayed();
		System.out.println(displayed);
	}
	public void checkWebElementSelected(WebElement element) {
		boolean selected = element.isSelected();
		System.out.println(selected);
		

	}
	public static void sleep(int millisec) throws InterruptedException {
		Thread.sleep(millisec);

	}
	public static void implicitwaitSeconds(int sec,TimeUnit seconds) {
		driver.manage().timeouts().implicitlyWait(sec ,seconds);

	}
	public static String excelRead(int rowno,int cellno) throws IOException {
		
		
		File f = new File("C:\\Users\\pradeep\\eclipse-workspace\\Frame\\TestDataExcel\\Book1.xlsx");
		FileInputStream filestream = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(filestream);
		Sheet s = w.getSheet("Sheet1");

		Row r = s.getRow(rowno);
		String value = "";

		Cell c = r.getCell(cellno);
		int cellType = c.getCellType();

		if (cellType == 1) {

			value = c.getStringCellValue();

		} else if (DateUtil.isCellDateFormatted(c)) {
			Date d = c.getDateCellValue();
			SimpleDateFormat sim = new SimpleDateFormat("dd/MM/yyyy");
			value = sim.format(d);
		} else {
			double num = c.getNumericCellValue();
			long l = (long) num;
			value = String.valueOf(l);

		}
		return value;
	}


	public static  void excelWrite(int rowno, int cellno,String value) throws IOException {
		
		File f = new File("C:\\Users\\pradeep\\eclipse-workspace\\Frame\\TestDataExcel\\Book1.xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fin);
		Sheet s = w.getSheet("Sheet1");
		Row r = s.getRow(rowno);
		Cell c = r.createCell(cellno);
		c.setCellValue(value);
		FileOutputStream fout = new FileOutputStream(f);
		w.write(fout);
		
		
	
	}
	}

	