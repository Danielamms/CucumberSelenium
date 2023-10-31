package Utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;




public class BaseClass {
	
	
	public static WebDriver driver;
	
	public static WebDriver getDriver() {
		
		if(driver == null) { 
		
			initializeDriver();}
		return driver;
		
	}
	
	
	
	public static void initializeDriver() {
		
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.edge.driver", "C:\\Users\\DANIELA\\Desktop\\Daniela\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.get("https://www.saucedemo.com/");
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
