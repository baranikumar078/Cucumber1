package org.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	
	public static void launchChrome() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();	
	}
	
	public static void launchFireFox() {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	
	public static void launchEdge() {
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
	}
	
	public static void maxWindow() {
	driver.manage().window().maximize();
	}
	
	public static void loadUrl(String url) {
	driver.get(url);
	}
	
	public static void printTilte() {
	
	System.out.println(driver.getTitle());
	}
	
	public static void printCurrentUrl() {
	System.out.println(driver.getCurrentUrl());
	}
	
	public static String currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
		
		}
	
	public static void fillValue(WebElement e,String f) {
		e.sendKeys(f);
	
	} 
	public static void clickBtn(WebElement e) {
	       e.click();
	}
	public static void movemouse(WebElement wed) {
		Actions act=new Actions(driver);
		act.moveToElement(wed).perform();
	}
	public static void dragDrop(WebElement wed,WebElement drop) {
		Actions act=new Actions(driver);
		act.dragAndDrop(wed, drop).perform();
	}
	public static void rightClick (WebElement wed) {
		Actions act=new Actions(driver);
		act.contextClick(wed).perform();
	}
	public static void doubleClickBtn(WebElement wed) {
		Actions act=new Actions(driver);
		act.doubleClick(wed).perform();
	}
	
	public static void copyBtn(WebElement wed) throws AWTException {
		Actions act=new Actions(driver);
		act.doubleClick(wed).perform();
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
	    r.keyRelease(KeyEvent.VK_C);
	    r.keyRelease(KeyEvent.VK_CONTROL);
	    }
	public static void pasteBtn(WebElement wed) throws AWTException {
		clickBtn(wed);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
	    r.keyRelease(KeyEvent.VK_V);
	    r.keyRelease(KeyEvent.VK_CONTROL);
	    }
	public static void enterBtn() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	    }
	public static void tabBtn() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		}	
	public static void downBtn() throws AWTException {
	    Robot r=new Robot();
	    r.keyPress(KeyEvent.VK_DOWN);
	    r.keyRelease(KeyEvent.VK_DOWN);
	    }
	
	public static void upBtn() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
		}
	public static void rightBtn() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_RIGHT);
		r.keyRelease(KeyEvent.VK_RIGHT);
		}
	public static void leftBtn() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
		}
	public static void pageUpBtn() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_PAGE_UP);
		r.keyRelease(KeyEvent.VK_PAGE_UP);
		}
	public static void pageDownBtn() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		}
	public static void capsBtn() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CAPS_LOCK);
		r.keyRelease(KeyEvent.VK_CAPS_LOCK);
		}
	public static void numLock() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_NUM_LOCK);
		r.keyRelease(KeyEvent.VK_NUM_LOCK);
		}
	public static void alphabets(char c) throws AWTException {
		Robot r=new Robot();
		r.keyPress(c);
		r.keyRelease(c);
		}
	public static void fresh(){
		driver.navigate().refresh();
	}
	public static void holdClickBtn(WebElement wed) {
		Actions act=new Actions(driver);
		act.clickAndHold(wed);
	}
	public static void closeBtn() {
		driver.close();
	}
	public static String titleReturn() {
	     String title = driver.getTitle();
		return title;
	
	}
	
	public static void printTagName(WebElement wed) {
		System.out.println(wed.getTagName());
	}
	public static void checkDisplayed(WebElement wed) {
		System.out.println(wed.isDisplayed());
	}
	public static void printClass(WebElement wed) {
		System.out.println(wed.getClass());
	}
	public static String getData(int rownum, int cellnum) throws IOException {
	
File f=new File("C:\\Users\\SBK\\eclipse-workspace\\MavenFrameWork\\testdata\\file_example_XLSX_10.xlsx");
	
	FileInputStream fin=new FileInputStream(f);
	
	Workbook w=new XSSFWorkbook(fin);
	
	Sheet s = w.getSheet("Details");
	
	Row row = s.getRow(rownum);
	
	Cell cell = row.getCell(cellnum);
	
	int cellType = cell.getCellType();
	String value="";
	if (cellType==1) {
		value = cell.getStringCellValue();
	}
	else if (cellType==0) {
		if (DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			
			SimpleDateFormat sim=new SimpleDateFormat("dd/MM/YYYY zzzz");
			 value = sim.format(dateCellValue);
						
		}
		else {
			double numericCellValue = cell.getNumericCellValue();
			long l=(long)numericCellValue;
		     value = String.valueOf(l);
		}
		
	}
	return value;
	
	
	}
	
public static void screenShot(String name) throws IOException {
		
		TakesScreenshot t=(TakesScreenshot)driver;
		
		File scr = t.getScreenshotAs(OutputType.FILE);
		
		File f=new File("C:\\Users\\SBK\\eclipse-workspace\\CucumberJunit\\ScreenShots\\"+name+".jpg");
		
		FileUtils.copyFile(scr, f);
		
		
	}
	
	
	
	
	
	
	
	
}

