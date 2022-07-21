package test;

import org.openqa.selenium.WebDriver;

import objectRepository.POM_IdentifyBikes;

public class QuitDriver {

	WebDriver driver = POM_IdentifyBikes.getDriver();

	//Quit driver
	public void endSession() {
		driver.quit();
	}

}
