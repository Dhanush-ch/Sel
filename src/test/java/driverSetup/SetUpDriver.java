package driverSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetUpDriver {

	public WebDriver driver;
	public String browser = "chrome";

	public SetUpDriver() {

		setDriver();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver() {
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		String urll = "https://www.zigwheels.com";
		driver.manage().window().maximize();
		driver.get(urll);
	}

}
