package objectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverSetup.SetUpDriver;

public class POM_IdentifyBikes {
	public static WebDriver driver;
	public String browser;
	
	public POM_IdentifyBikes() {
		setDriver();
	}
	
	// Driver started from here
	SetUpDriver obj = new SetUpDriver();
	
	public void setDriver() {
		driver = obj.getDriver();
	}

	// To use the initiated web driver in other classes
	public static WebDriver getDriver() {
		return driver;
	}

	By newBikes = By.linkText("New Bikes");
	By upcoming_Bikes = By.linkText("Upcoming Bikes");
	public By manufacturer = By.id("makeId");
	By total_Bikes = By.xpath("//div[@id='carModels']//span[1]");
	By viewmore_Btn = By.className("zw-cmn-loadMore");
	

	public void hoverNewBikes() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(newBikes));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(newBikes)).perform();
	}

	public WebElement selectUpcomingBikes() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(upcoming_Bikes));
		WebElement upcomingBikes = driver.findElement(upcoming_Bikes);
		return upcomingBikes;
	}

	public void selectManufacturer() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement manufacturerName = driver.findElement(manufacturer);
		wait.until(ExpectedConditions.elementToBeClickable(manufacturerName));
		Select select = new Select(manufacturerName);
		select.selectByVisibleText("Honda");
	}

	public int getTotalBikes() {
		String getTotalNoOfBikes = driver.findElement(total_Bikes).getText();
		int totalBikes = Integer.parseInt(getTotalNoOfBikes.replaceAll("[^0-9]", ""));
		return totalBikes;
	}

	public WebElement clickViewmoreBtn() {
		WebElement viewmoreBtn = driver.findElement(By.className("zw-cmn-loadMore"));
		return viewmoreBtn;
	}

}
