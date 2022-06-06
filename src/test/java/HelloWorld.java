import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelloWorld {
	public static WebDriver driver;
	public static String urll = "https://www.zigwheels.com";
	String browser;
	String mainWindow;
	WebDriverWait wait;

	public HelloWorld(String browser) {
		this.browser = browser;
	}

	public void setDriver() {
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(urll);
	}

	public void upcomingBikes() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Hover over New bikes
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText("New Bikes")));
		WebElement newBikes = driver.findElement(By.linkText("New Bikes"));
		Actions action = new Actions(driver);
		action.moveToElement(newBikes).perform();

		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Upcoming Bikes")));

		// Click Upcoming Bikes
		WebElement upcomingBikes = driver.findElement(By.linkText("Upcoming Bikes"));
		upcomingBikes.click();

		// Select Manufacturer
		try {
			WebElement manf = driver.findElement(By.id("makeId"));
			// Wait
			wait.until(ExpectedConditions.elementToBeClickable(manf));

			Select select = new Select(manf);
			select.selectByVisibleText("Honda");

			// Get Total no.of.bikes
			String str = driver.findElement(By.xpath("//div[@id='carModels']//span[1]")).getText();
			int totalBikes = Integer.parseInt(str.replaceAll("[^0-9]", ""));
			System.out.println(totalBikes);

			// print Bikes list
			for (int i = 1; i <= totalBikes + 1; i++) {
				if (i == 7) {
					continue;
				}
				// get name of the Bike
				String bikeModel = driver.findElement(By.xpath("//ul[@id='modelList']/li[" + i + "]//a/strong"))
						.getText();
				// getPrice
				String bikePrice = driver.findElement(By.xpath("//ul[@id='modelList']/li[" + i + "]/div/div[3]/div[1]"))
						.getText();
				// get launchDate
				String launchDate = driver
						.findElement(By.xpath("//ul[@id='modelList']/li[" + i + "]/div/div[3]/div[2]")).getText();

				if (i == 6) {
					WebElement viewMoreBtn = driver.findElement(By.className("zw-cmn-loadMore"));
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView();", viewMoreBtn);
					wait.until(ExpectedConditions.elementToBeClickable(viewMoreBtn));
					js.executeScript("arguments[0].click();", viewMoreBtn);
				}
				System.out.println(bikeModel + "\t" + bikePrice + "\t" + launchDate);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void googleLogin() throws Exception {

		mainWindow = driver.getWindowHandle();
		String email = "abc@xyz.com";
		String pwd = "********";
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement loginBtn = driver.findElement(By.id("forum_login_title_lg"));
		loginBtn.click();

		// Click "using Google" button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("googleSignIn")));
		WebElement gSign = driver.findElement(By.xpath("//*[@id = 'googleSignIn']/span[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(gSign));
		Actions action = new Actions(driver);
		action.click(gSign).perform();
		System.out.println("Using google button is clicked!!");
		Thread.sleep(5000);


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

	public void usedCars() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// Hover over Used Cars
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Used Cars")));
		WebElement usedcars = driver.findElement(By.linkText("Used Cars"));
		Actions action = new Actions(driver);
		action.moveToElement(usedcars).perform();

		// Click "Chennai"
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Chennai")));
		WebElement chennai = driver.findElement(By.linkText("Chennai"));
		chennai.click();

		// Scroll to popular models field
		WebElement popularModels = driver.findElement(By.xpath("//h3[text() = 'Popular Models']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", popularModels);

		// printing popular car models
		int i = 1;
		WebElement ul = driver.findElement(By.xpath("//ul[contains(@class, ' usedCarMakeModelList ')]"));
		ArrayList<WebElement> list = new ArrayList<WebElement>(ul.findElements(By.tagName("li")));
		Iterator<WebElement> i1 = list.iterator();

		while (i1.hasNext()) {
			System.out.println(i1.next().getText());
		}
	}

	public void endSession() {
		driver.quit();
	}

	public static void main(String args[]) throws Exception {
		System.out.println("Hello World!!");
		HelloWorld obj = new HelloWorld("chrome");
		obj.setDriver();
//		obj.upcomingBikes();
		obj.googleLogin();
//		obj.usedCars();
		obj.endSession();

	}
}
