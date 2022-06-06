package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import driverSetup.SetUpDriver;

public class POM_IdentifyBikes {
	public static WebDriver driver;
	
	//Driver started from here
	SetUpDriver obj = new SetUpDriver(driver);
	
	By newBikes = By.linkText("New Bikes");
	By upcoming_Bikes = By.linkText("Upcoming Bikes");
	public By manufacturer = By.id("makeId");
	By total_Bikes = By.xpath("//div[@id='carModels']//span[1]");
	By viewmore_Btn = By.className("zw-cmn-loadMore");
	
	
	public void hoverNewBikes() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(newBikes)).perform();
	}
	
	public WebElement selectUpcomingBikes() {
		WebElement upcomingBikes = driver.findElement(upcoming_Bikes);
		return upcomingBikes;
	}
	
	public WebElement selectManufacturer() {
		WebElement manufacturerName = driver.findElement(manufacturer);
		return manufacturerName;
	}
	
	public int getTotalBikes() {
		String getTotalNoOfBikes = driver.findElement(total_Bikes).getText();
		int totalBikes = Integer.parseInt(getTotalNoOfBikes.replaceAll("[^0-9]", ""));
		return totalBikes;
	}
	
	public WebElement clickViewmoreBtn() {
		WebElement viewmoreBtn = driver.findElement(viewmore_Btn);
		return viewmoreBtn;
	}

}
