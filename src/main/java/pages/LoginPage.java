package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import base.ETSMavenBasePage;

public class LoginPage extends ETSMavenBasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	By byLoginButton = By.xpath("//input[@type='submit']");
	By byMailTextbox = By.xpath("//input[@type='text']");
	By byPassword = By.xpath("//input[@type='password']");
	
	
	protected WebElement getLoginButton() throws Exception {
		//return driver.findElement(byLoginButton);
		return getElement(byLoginButton, "Login Button");
	}
	
	protected WebElement getMailTextBox() throws Exception {
		//return driver.findElement(byMailTextbox);
		return getElement(byMailTextbox, "User mail ID textbox");
	}
	
	protected WebElement getPasswordTextBox() throws Exception {
		//return driver.findElement(byPassword);
		return getElement(byPassword, "Password Textbox");
	}
	

}
