package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.ExpectedExceptions;

import com.relevantcodes.extentreports.LogStatus;


public class ETSMavenBasePage {
	
	public WebDriver driver = null;
	public static Logger Log = Logger.getLogger(ETSMavenBasePage.class.getName());
	 
	 
	
	public ETSMavenBasePage(WebDriver driver) {
	   this.driver = driver;	
	}
	
	
	//getting element
	public WebElement getElement(By by, String sControlName)throws Exception{	
		 ETSMavenBaseTest.extest.log(LogStatus.PASS, "Getting element " + sControlName);
		 WebElement  element = null;
		 for(int Index=0; Index < Integer.valueOf(System.getProperty("waitelement")); Index++) {
			 try {
			     element = driver.findElement(by);
			     Assert.assertNotNull(element, sControlName  +" is not avaialable");
			     ETSMavenBaseTest.extest.log(LogStatus.PASS, "Received element : " + sControlName);
			     break;
			 }
			 catch(Exception ex){
				 Thread.sleep(1000);
			 }
		 }
		 return element;
	}

	//setting test
	public void setText(WebElement element, String sContent, String sControlName) throws Exception{
		 ETSMavenBaseTest.extest.log(LogStatus.PASS, "Enterring data into " + sControlName);
		 element.sendKeys(sContent);
		 ETSMavenBaseTest.extest.log(LogStatus.PASS, "Data entered into " + sControlName + " is: " + sContent);
	}
	
	//clicks
	public void Click(WebElement element, String sControlName) throws Exception{
		ETSMavenBaseTest.extest.log(LogStatus.PASS, "Clicking on " + sControlName);
		Assert.assertTrue(element.isEnabled(), sControlName + " is not enabled");
		 element.click();
		 ETSMavenBaseTest.extest.log(LogStatus.PASS, "Clciked on " + sControlName );
	}
}
