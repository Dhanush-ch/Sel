package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.POM_IdentifyBikes;
import objectRepository.POM_googleLogin;

public class GoogleLogin {

	String mainWindow;
	WebDriverWait wait;

	// Get the driver from POM_IdentifyBikes class
	WebDriver driver = POM_IdentifyBikes.getDriver();

	POM_googleLogin gSign = new POM_googleLogin();

	public void googleLogin() throws Exception {

		mainWindow = driver.getWindowHandle();
		String email = "abc@xyz.com";
		String pwd = "********";
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Click Login Button
		gSign.clickLoginBtn().click();

		try {
			// Click "using Google" button
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("googleSignIn")));
			gSign.clickUsingGoogleBtn();

			System.out.println("Using google button is clicked!!");
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e);
		}

//		// Get Window Handles
//		Set<String> s1 = driver.getWindowHandles();
//		Iterator<String> i1 = s1.iterator();
//
//		while (i1.hasNext()) {
//			i1.next();
//			String childWindow = i1.next();
//			if (!mainWindow.equalsIgnoreCase(childWindow)) {
//				// Switching to SignIn window
//				driver.switchTo().window(childWindow);
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
//				// Enter email
//				driver.findElement(By.id("identifierId")).sendKeys(email);
//				driver.close();
//				driver.findElement(By.xpath("//button[@type='button']")).click();
//				
//				//Handling Alert
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='button']/span/span")));
//				driver.findElement(By.xpath("//div[@role='button']/span/span")).click();
//				
//				// Enter password
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
//				driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
//				driver.findElement(By.xpath("//button[@type='button']")).click();
//			}
//		}

	}

}
