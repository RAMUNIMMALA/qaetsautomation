package base;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import java.text.SimpleDateFormat;
import java.util.Date;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Properties;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class ETSMavenBaseTest {
	
	public WebDriver driver = null;
    public static String extentReport = System.getProperty("user.dir")+"\\Reports\\ETSMavenReport_"+ System.getProperty("browsername")+"_" +new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"extent.html";
	//public static String extentImage = "D:\\Reports\\extent.png";
	public static ExtentReports extentReportseport = new ExtentReports(extentReport, true);
	public static ExtentTest extest = null;
	    
	    
	
	public ETSMavenBaseTest() {
		
	}
	
	@BeforeSuite
	public void BeforeSuiteMethod() {
		System.out.println("In Before Suite");
	}	
	
	@BeforeMethod
	public void BeforeMethodSetup(Method method, ITestContext testContext) {
		extest = extentReportseport.startTest(method.getName());
		LaunchDriver();		
	}
	
	//driver launch
	private void LaunchDriver() {
		
		if(System.getProperty("browsername").toUpperCase().equals("CHROME")) {
			 extest.log(LogStatus.PASS, "Launching chrome driver");
			String strDriverPath = System.getProperty("user.dir")+"\\chromedriver.exe";
			System.out.println(strDriverPath);
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");	
			driver = new ChromeDriver();
			
		}
		else if(System.getProperty("browsername").toUpperCase().equals("FIREFOX")) {
			 extest.log(LogStatus.PASS, "Launching firefox driver");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");	
			driver = new FirefoxDriver();
		}
		extest.log(LogStatus.PASS, "Launching app url: " +System.getProperty("appUrl"));
		driver.get(System.getProperty("appUrl"));
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void AfterMethodSetup(ITestResult result) {
		 if(result.isSuccess()) {
			 extest.log(LogStatus.PASS, "Test Case Passed");
	        }
	        else{
	        	extest.log(LogStatus.FAIL, "Test case failed");
	        }
	    extest.log(LogStatus.PASS, "Quitting drivers");
		driver.close();
		driver.quit();
	}
	
	
	@AfterSuite
	public void AfterSuiteMethod() {
		extest.log(LogStatus.PASS, "End Suite");
        extentReportseport.flush();
	}
	
	
}
