package exercise.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import exercise.pageObjects.EbayHomeScreen;
import exercise.pageObjects.ItemScreen;
import exercise.utility.DriverManagement;
import exercise.utility.TestDataHandling;

public class Scenario1 {
	WebDriver driver;
	TestDataHandling data;
	DriverManagement driverManager;
	String URL = "url";
	String BROWSER = "chrome";

	@BeforeClass
	public void setup() {
		data = new TestDataHandling();
		driverManager = new DriverManagement();
		driver = driverManager.getDriver(data.getProperty(URL), BROWSER);
	}

	@Test
	public void testLogin() {
		EbayHomeScreen home = new EbayHomeScreen(driver);
		ItemScreen item = new ItemScreen(driver);
		home.searchQuery("book");
		home.waitForResults();
		home.clickOnItem();
		item.newTab();
		String oldValue=item.getAddToCartText();
		item.clickAddToCart();
		item.waitForCheckOut();
		String newValue = item.getAddToCartText();
		Assert.assertNotEquals(newValue, oldValue);
		Assert.assertEquals(Integer.parseInt(newValue), 1);
	}
	
	@AfterClass
	public void closeTest() {
		driver.quit();
	}
}
