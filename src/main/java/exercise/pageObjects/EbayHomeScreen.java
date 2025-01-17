package exercise.pageObjects;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EbayHomeScreen {
	WebDriver driver;

	@FindBy(id = "gh-ac")
	WebElement searchBox;

	@FindBy(id = "gh-search-btn")
	WebElement searchButton;

	@FindBy(xpath = "//*[@id='item3bc741ce51']/div/div[2]/a")
	WebElement book;

	public EbayHomeScreen(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void searchQuery(String query) {
		searchBox.sendKeys(query + Keys.ENTER);
	}

	public void clickOnSearchButton() {
		searchButton.click();
	}
	
	public void clickOnItem() {
		book.click();
	}
	
	public void waitForResults() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(book));
	}
	
}
