package com.aiiet.BasePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Select select;
	public static List<WebElement> list;
	public static JavascriptExecutor js;
	public static WebElement element;
	public static Actions actions;
	public static String path;
	public static ExtentReports extent;
	public static ExtentHtmlReporter htmlReporter;

	public static void browserLaunch(String browser) {
		switch(browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			break;
		}
	}
	public static void submit(WebElement ele) {
		ele.submit();
	}

	public static void clear(WebElement ele) {
		ele.clear();
	}
	public static LocalDateTime getFutureDate(int day, int month, int year){
		LocalDateTime  now = LocalDateTime.now();
		now = now.plusDays(day).plusMonths(month).plusYears(year);
		return now;
	}

	public static void url(String url) {
		driver.get(url);
	}
	public static void closeWindow() {
		driver.close();
	}
	public static void input(WebElement ele,String sendkeys) {
		ele.click();
		ele.sendKeys(sendkeys);
	}
	public static void click(WebElement ele) {
		ele.click();	
	}
	// Select Function

	public static void selectByIndex(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);
	}
	public static void selectByValue(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);
	}
	public static void selectByText(WebElement element, String text) {
		select = new Select(element);
		select.selectByVisibleText(text);
	}
	public static void radio(WebElement element) {
		WebElement radio = element;
		if (!radio.isSelected()) {
			radio.click();
		}
	}
	public static String readProp(String key) throws IOException
	{
		File file = new File("C:\\Users\\PC1\\eclipse-workspace\\TestNg\\src\\test\\resources\\Credentials.properties");
		FileInputStream fs = new FileInputStream(file);
		Properties p = new Properties();
		p.load(fs);
		String property = p.getProperty(key);
		return property;
	}
	public static void wait(int wait) {
		driver.manage().timeouts().implicitlyWait(wait,TimeUnit.SECONDS);
	}
	public static String excelRead(int row1,int cell1) throws IOException 
	{
		String s = null;
		File file = new File(path);
		FileInputStream fls = new FileInputStream(file);
		Workbook wk = new XSSFWorkbook(fls);
		Sheet sh =  wk.getSheet("Sheet1");
		Row row =  sh.getRow(row1);
		Cell cell = row.getCell(cell1);
		CellType ct = cell.getCellType();
		if(ct==ct.STRING)
		{
			s = cell.getStringCellValue();
		}
		else if(ct==ct.NUMERIC)
		{
			if(DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat sd = new SimpleDateFormat("dd-MMM-YYYY");
				s = sd.format(dateCellValue);
			}
			else
			{
				double numericCellValue = cell.getNumericCellValue();
				long s1 = (long) numericCellValue;
				s = String.valueOf(s1);
			}
		}
		return s;
	}
	public static void createFile(int row,int cell,String str) throws IOException
	{

		File file = new File(path);
		FileInputStream fls = new FileInputStream(file);
		Workbook wk = new XSSFWorkbook(fls);
		Sheet sheet =  wk.getSheet("Sheet1");
		Row row1 =  sheet.getRow(row);
		Cell createCell = row1.createCell(cell);
		createCell.setCellValue(str);
		FileOutputStream fo = new FileOutputStream(file);
		wk.write(fo);
		wk.close();
	}
	public static String excelAll(int row1,int cell1) throws IOException {
		String s = null;
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		Workbook wk =new XSSFWorkbook(fis);
		Sheet sheet = wk.getSheet("Sheet1");
		for(int i=0; i<sheet.getPhysicalNumberOfRows(); i++) 
		{
			Row row = sheet.getRow(i);
			for(int j=0; j<row.getPhysicalNumberOfCells();j++)
			{
				Cell cell = row.getCell(j);
				CellType cellType = cell.getCellType();		
				if(cellType==CellType.STRING) {
					s = cell.getStringCellValue();
				}
				else if(cellType==CellType.NUMERIC) {
					if(DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat sd = new SimpleDateFormat("dd-MMM-yyyy");
						s = sd.format(dateCellValue);
					}
					else {
						double cellValue = cell.getNumericCellValue();
						long s1 = (long) cellValue;
						s = String.valueOf(s1);
					}
				}
			}
		}
		return s;
	}
	public static Object[][] excelData() throws IOException {
		File file = new File("D:\\java\\credentials.xlsx");
		FileInputStream fs = new FileInputStream(file);

		Workbook wk = new XSSFWorkbook(fs);
		Sheet sheet = wk.getSheet("Sheet1");
		int rows = sheet.getPhysicalNumberOfRows()-1;
		int lastCell = sheet.getRow(0).getLastCellNum();
		String[][]data = new String[rows][lastCell];
		for (int i = 1; i < rows+1; i++) {
			for (int j = 0; j < lastCell; j++) {
				Cell dat = sheet.getRow(i).getCell(j);
				data[i-1][j] = dat.getStringCellValue();
			}
		}
		return data;
	}
	public static String Attribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}

	public static void scroll(int i) {
		js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,"+i+")");			
	}

	public static void scrollToView(By a) {
		element = driver.findElement(a);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	public static void Takescreenshots(String image_name) throws IOException {
		TakesScreenshot screensshots = (TakesScreenshot) driver;
		File source = screensshots.getScreenshotAs(OutputType.FILE);
		File dest =new File("D:\\java\\sreenshot\\"+image_name +".png");
		FileUtils.copyFile(source, dest);	
	}

	public static void scrolldown(){
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public static void scrolltop(){
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}
	public static void scrollDownToMiddleOfPage() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight/2);");
	}
	public static String text(WebElement element) {

		String s1 = element.getText();
		return s1;
	} 
	public static void acTion(WebElement element,String function) {
		actions = new Actions(driver);
		switch(function) {
		case "move":
			actions.moveToElement(element).build().perform();
			break;
		case "RightClick":
			actions.contextClick(element).build().perform();
			break;
		case "DoubleClick":	
			actions.doubleClick(element).build().perform();
			break;
		}
	}
	public static void dragDrop(WebElement source, WebElement destination) {
		actions = new Actions(driver);
		actions.dragAndDrop(source,destination).build().perform();
	}

	public static void waitE(int seconds,WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
	}
	public static void window() {
		String parentWindow = driver.getWindowHandle();
		Set<String> childWindow = driver.getWindowHandles();	  

		Iterator<String> I1= childWindow.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parentWindow.equals(childWindow))
			{
				driver.switchTo().window(child_window);
			}
		}
	}
	//FindElement and locators
	
	public static WebElement findElementBy(String type, String typeaddress)
	{
	            WebElement element=null;
	            switch(type){
	                case "id":
	                    element= driver.findElement(By.id(typeaddress));
	                    break;
	                case "name":
	                    element= driver.findElement(By.name(typeaddress));
	                    break;
	                case "class":
	                    element = driver.findElement(By.className(typeaddress));
	                    break;
	                case "tagName":
	                    element = driver.findElement(By.tagName(typeaddress));
	                    break;
	                case "link":
	                    element = driver.findElement(By.linkText(typeaddress));
	                case "partial_link":
	                    element = driver.findElement(By.partialLinkText(typeaddress));
	                    break;
	                case "xpath":
	                    element = driver.findElement(By.xpath(typeaddress));
	                    break;
	                case "css":
	                    element = driver.findElement(By.cssSelector(typeaddress));
	                    break;
	            }
				return element;
		}

	//FindElements
	
		public static List<WebElement> listOfElement(By element) 
		{
			List<WebElement> list = driver.findElements(element);
			System.out.println(list.size());
			return list;
		}
	public static void extentReport(String name) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}	
	public static void extentFlush() {
		extent.flush();
	}

}


