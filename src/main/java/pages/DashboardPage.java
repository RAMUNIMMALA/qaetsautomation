package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import base.ETSMavenBasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.*;

public class DashboardPage extends ETSMavenBasePage{
	
	public DashboardPage(WebDriver driver) {
		super(driver);
		Assert.assertNotNull(getLoginInformation(),"Login Information on Dashboard is not available");
		Log.info("Launchging DashboardPage");
	}
	
	By byLoginInfo = By.id("lgnview_lbl_name");
	
	protected WebElement getLoginInformation() {
		return driver.findElement(byLoginInfo);
	}

}
