package Google_Tester;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PerformanceTester {
	
	public static WebDriver driver = null;

	public static void main(String[] args) {
		//Setting Chromedriver to chromedriver.exe in project folder
		System.setProperty("webdriver.chrome.driver", ".\\webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		ChromeOptions options = new ChromeOptions();
		//Enable incognito in chrome options (avoid cache impact on RT)
		options.addArguments("--incognito");
		//Enable maximized window in start-up
		options.addArguments("--start-maximized");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY,  options);

		//Launch Google Chrome and open URL
		driver.get("https://www.google.com/");
		
		
		
	}

}
