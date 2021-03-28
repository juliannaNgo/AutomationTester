import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tester extends Data{
	
	public static WebDriver driver = null;

	public static void main(String[] args) {
		//Setting Chromedriver to chromedriver.exe in project folder
		System.setProperty("webdriver.chrome.driver", ".\\webdrivers\\chromedriver.exe");
		
		//Create and setting ChromeDriver options to start browser in incognito-mode & maximized-window
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("start-maximized");
		WebDriver driver = new ChromeDriver(options);
		boolean result = true;
		
		//Creating WebDriverWait object for element visibility waiting, with TimeOut timer of 20 seconds
		WebDriverWait wait = new WebDriverWait(driver, 20);

		try {
			//Launch Google Chrome and open URL
			driver.get(url);
			
			//Search Google in search bar
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchBar)));		
			WebElement inputBox = driver.findElement(By.xpath(searchBar));
			inputBox.sendKeys("Google" + "\n");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchResult)));	
			
			//Click Maps Button
			Data.clickAndWait(driver, wait, mapsBtn, runBtn);
			
			//Click App Menu
			Data.clickAndWait(driver, wait, appMenu, menuFrame);
			
			//Switch window context to appMenu window
			WebElement appFrame=driver.findElement(By.xpath(menuFrame));
			driver.switchTo().frame(appFrame);
			
			//Scroll Down App Menu Until More Apps Button Visible
			WebElement moreAppButton = driver.findElement(By.xpath(moreAppsBtn));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", moreAppButton);
			
			//Click More Applications Button
			moreAppButton.click();
			
			//Switch window context to Products window
			for (String windowHandler : driver.getWindowHandles()) {
				driver.switchTo().window(windowHandler);
			}
			
			//Scroll Down Page Until Sheets Button is Visible
			WebElement sheetsButton = driver.findElement(By.xpath(sheetBtn));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sheetsButton);
			
			//Click Sheets Button
			sheetsButton.click();
			
		}
		catch(TimeoutException e) {
			result = false;
			System.out.println(e.toString());
		}
		catch(Exception w) {
			result = false;
			System.out.println("Unexpected Exception occured");
		}
		
		System.out.println("Test result: " + result);
		
		//Close all Browser windows
		driver.quit();
	}

}
