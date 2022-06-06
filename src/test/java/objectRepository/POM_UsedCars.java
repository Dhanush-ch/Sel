package objectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class POM_UsedCars {

	public WebDriver driver;

	public WebDriver getWebDriver() {
		// Get driver from POM_IdentifyBikes class
		driver = POM_IdentifyBikes.getDriver();
		return driver;
	}


	By used_Cars = By.linkText("Used Cars");
	By chennai = By.linkText("Chennai");
	By popular_Models = By.xpath("//h3[text() = 'Popular Models']");
	By home = By.xpath("//a[@href = '/']");
	
	public void gotoHome() {
		driver.findElement(home).click();
	}

	public void hoverUsedCars() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(used_Cars));
		WebElement usedCars = driver.findElement(used_Cars);
		Actions action = new Actions(driver);
		action.moveToElement(usedCars).perform();
	}

	public WebElement selectChennai() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Chennai")));
		return (driver.findElement(chennai));
	}

	public void findPopularModels() {
		WebElement popularModels = driver.findElement(popular_Models);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", popularModels);
	}

}
