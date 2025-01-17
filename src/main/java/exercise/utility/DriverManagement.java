package exercise.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManagement {
	WebDriver driver;

	@SuppressWarnings("deprecation")
	public WebDriver getDriver(String url, String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.navigate().to(url);
			return driver;
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			return driver;
		}
		return null;

	}
	
	public WebDriver getDriver() {
		if(driver!=null) {
			return driver;
		}
		return driver;
	}
}
