import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Data {
	//Test Data
	static int iterations = 1;
	static int version = 1;
	static String url = "https://www.google.com/";
	static String path = ""; //Input path to TestResults folder
	
	//Page-Object xpaths
	static String searchBar = "//input[contains(@title,'Search')]";
	static String searchResult = "//div[contains(@id,'result-stats')]";
	static String mapsBtn = "//a[contains(text(),'Maps')]";
	static String runBtn = "//div[contains(@id,'runway-expand-button')]";
	static String appMenu = "//a[contains(@title,'apps')]";
	static String menuFrame = "//iframe";
	static String appMenuScrollBar = "//div[contains(@class,'qWu')]";
	static String appMenuNoScroller = "//div[contains(@class,'EHzcec')]";
	static String accountApp = "//span[contains(text(),'Account')]";
	static String moreAppsBtn = "//a[contains(text(),'More from')]";
	static String prodHdr = "//h1[contains(text(),'Helpful products')]";
	static String sheetBtn = "//p[contains(text(),'Sheet')]";
	static String googleSheetsBtn = "(//a[contains(text(),'Go to Google Sheets')])[2]";

	//helper method to click web element with xpath obj, then wait until web element with xpath waitObj is visible
	static void clickAndWait(WebDriver driver, WebDriverWait wait, String obj, String waitObj) {
		WebElement webObj = driver.findElement(By.xpath(obj));
		webObj.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(waitObj)));
	}
	
	
}
