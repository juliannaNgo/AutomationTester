import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import org.openqa.selenium.WebElement;

public interface Data {
	//Test Data
	final static int iterations = 1;
	final static int version = 1;
	final static String url = "https://www.google.com/";
	final static String path = ""; //Input path to TestResults folder
	
	//Page-Object xpaths
	final static String searchBar = "//input[contains(@title,'Search')]";
	final static String searchResult = "//div[contains(@id,'result-stats')]";
	final static String newsBtn = "//a[contains(text(),'News')]";
}
