package actions;

import pages.DashboardPage;
import pages.LoginPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import base.ETSMavenBaseTest;

public class LoginActions extends LoginPage{
	
	public LoginActions(WebDriver driver) {
		super(driver);
	}
	

public DashboardPage performSuccessfulLogin (String sUserName, String sPassword) throws Exception {
		setText(getMailTextBox(), sUserName, "User MailID Textbox");
		setText(getPasswordTextBox(), sPassword, "Password Textbox");
		Click(getLoginButton(), "Login Button");		 
		return new DashboardPage(driver);
	}

public void performFailureLogin (String sUserName, String sPassword, String validateMessage) throws Exception {
	setText(getMailTextBox(), sUserName, "User MailID Textbox");
	setText(getPasswordTextBox(), sPassword, "Password Textbox");
	Click(getLoginButton(), "Login Button");	
	Thread.sleep(5000);
	validateInvalidLoginMessage(validateMessage);
}

public void validateInvalidLoginMessage(String strMessageText)throws Exception{
	try {
	 Alert alert = driver.switchTo().alert();
	 ETSMavenBaseTest.extest.log(LogStatus.PASS, "Verifying validation message: " + strMessageText);
	 Assert.assertNotNull(alert, "Alert popup is not available");;	 
	 Assert.assertEquals(strMessageText, alert.getText(), "Alert text is not macthing" );
	 ETSMavenBaseTest.extest.log(LogStatus.PASS, "Message is validated");
	 ETSMavenBaseTest.extest.log(LogStatus.PASS, "Clickin on OK button on alert popup");
	 alert.accept();
	}
	catch(Exception ex) {
		throw ex;
	}
}

}
