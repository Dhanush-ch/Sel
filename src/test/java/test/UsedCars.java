package test;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.POM_UsedCars;

public class UsedCars {

	WebDriverWait wait;

	// Initiating POM_UsedCars object
	POM_UsedCars cars = new POM_UsedCars();
	// Get driver from POM_UsedCars class
	WebDriver driver = cars.getWebDriver();

	public void usedCars() {
		
		//Go to home
		cars.gotoHome();

		// Hover over Used Cars
		cars.hoverUsedCars();

		// Click "Chennai"
		cars.selectChennai().click();

		// Scroll to popular models field
		cars.findPopularModels();

		// printing popular car models
		WebElement ul = driver.findElement(By.xpath("//ul[contains(@class, ' usedCarMakeModelList ')]"));
		ArrayList<WebElement> list = new ArrayList<WebElement>(ul.findElements(By.tagName("li")));
		Iterator<WebElement> i1 = list.iterator();
		
		//print popular car models list
		while (i1.hasNext()) {
			System.out.println(i1.next().getText());
		}
	}

}
