package exercise.pageObjects;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemScreen {
	WebDriver driver;

	@FindBy(id = "atcBtn_btn_1")
	WebElement addToCartButton;

	@FindBy(xpath = "//*[@class='gh-cart__icon']//span")
	WebElement cartLink;
	
	@FindBy(xpath = "//*[text()='Go to checkout']")
	WebElement checkOut;
	

	public ItemScreen(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickAddToCart() {
		addToCartButton.click();
	}

	public String getAddToCartText() {
		return cartLink.getText();
	}
	
	public void newTab() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}
	
	public void oldTab() {
		driver.close();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
	}
	
	public void waitForCheckOut() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(checkOut));
	}
}
