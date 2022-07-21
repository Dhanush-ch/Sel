package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class POM_googleLogin {

	// Get the driver from POM_IdentifyBikes class
	WebDriver driver = POM_IdentifyBikes.getDriver();

	By login_Btn = By.id("forum_login_title_lg");
	By gSign = By.id("forum_login_cover_image_sm");

	public WebElement clickLoginBtn() {
		return (driver.findElement(gSign));
	}

	public void clickUsingGoogleBtn() {
		WebElement usingGoogleBtn = driver.findElement(gSign);
		Actions action = new Actions(driver);
		action.click(usingGoogleBtn).perform();
	}

}
