package Utils;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	
	public static WebDriver getDriver() {
		if(driver == null) {
			initializeDriver();
		}
		return driver;
	}

	
	public static void initializeDriver() {
		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}


	public static void closeDriver() {
		if(driver != null ) {
			driver.quit();
			driver = null;
		}
	}
}