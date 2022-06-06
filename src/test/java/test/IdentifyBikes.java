package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.POM_IdentifyBikes;

public class IdentifyBikes {

	public String browser;

	// Creating a instance of POM_IdentifyBikes to access its non-static methods
	POM_IdentifyBikes bikesObj = new POM_IdentifyBikes();

	public WebDriver driver = POM_IdentifyBikes.getDriver();

	public void upcomingBikes() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Hover over New bikes
		bikesObj.hoverNewBikes();

		// Click Upcoming Bikes
		bikesObj.selectUpcomingBikes().click();

		// Select Manufacturer
		bikesObj.selectManufacturer();

		// Get Total no.of.bikes
		int totalBikes = bikesObj.getTotalBikes();
		System.out.println(totalBikes);

		// print Bikes list
		for (int i = 1; i <= totalBikes + 1; i++) {
			if (i == 7) {
				continue;
			}
			// get name of the Bike
			String bikeModel = driver.findElement(By.xpath("//ul[@id='modelList']/li[" + i + "]//a/strong")).getText();
			// getPrice
			String bikePrice = driver.findElement(By.xpath("//ul[@id='modelList']/li[" + i + "]/div/div[3]/div[1]"))
					.getText();
			// get launchDate
			String launchDate = driver.findElement(By.xpath("//ul[@id='modelList']/li[" + i + "]/div/div[3]/div[2]"))
					.getText();

			if (i == 6) {
				WebElement viewmoreBtn = driver.findElement(By.className("zw-cmn-loadMore"));
//				viewmoreBtn.click();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView();", viewmoreBtn);
				wait.until(ExpectedConditions.elementToBeClickable(viewmoreBtn));
				js.executeScript("arguments[0].click();", viewmoreBtn);
			}
			System.out.println(bikeModel + "\t" + bikePrice + "\t" + launchDate);
		}

	}

}
