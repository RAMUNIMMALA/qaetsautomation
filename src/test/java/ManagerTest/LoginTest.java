package ManagerTest;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.ETSMavenBaseTest;
import actions.LoginActions;


public class LoginTest extends ETSMavenBaseTest{
	
	LoginActions loginActions = null;
	
	
	@Test
	public void ValidateManagerLoginWithValidEmailIdAndPassword() throws Exception{
		try {
		   loginActions = new LoginActions(driver);
		   loginActions.performSuccessfulLogin("ramun@goggery.com", "ets@17");
		}
	   catch (Exception ex) {
			extest.log(LogStatus.FAIL, ex.getMessage());
			throw new Exception(ex);
		}
	}
	
	@Test
	public void ValidateManagerLoginWithValidEmpIdAndPassword() throws Exception{

		try {
		   loginActions = new LoginActions(driver);
		   loginActions.performFailureLogin("RA4545", "ets@1", "Invalid credentials");
		}
		catch (Exception ex) {
			extest.log(LogStatus.FAIL, ex.getMessage());
			throw new Exception(ex);
		}
	}
	
	
}
