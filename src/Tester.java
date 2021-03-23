import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tester implements Data{
	
	public static WebDriver driver = null;

	public static void main(String[] args) {
		//Setting Chromedriver to chromedriver.exe in project folder
		System.setProperty("webdriver.chrome.driver", ".\\webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		boolean result = true;
		//Creating WebDriverWait object for element visibility waiting, with TimeOut timer of 20 seconds
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		ChromeOptions options = new ChromeOptions();
		//Enable incognito in chrome options (avoid cache impact on RT)
		options.addArguments("--incognito");
		//Enable maximized window in start-up
		options.addArguments("--start-maximized");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY,  options);

		try {
			//Launch Google Chrome and open URL
			driver.get(url);
			
			//Search Google in search bar
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchBar)));		
			WebElement inputBox = driver.findElement(By.xpath(searchBar));
			inputBox.sendKeys("Google" + "\n");
			//Click News Button
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchResult)));	
			WebElement newsButton = driver.findElement(By.xpath(newsBtn));
			newsButton.click();
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
	}

}
