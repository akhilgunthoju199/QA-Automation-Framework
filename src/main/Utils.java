package main;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LogEntry;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Utils {
	
	public static WebDriver driver;
	
	@BeforeMethod
	public void launchFireFox() throws InterruptedException
	{

		WebDriverManager.firefoxdriver().setup();
		//new
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless");
		driver = new FirefoxDriver(options);
		//end
        //driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");

	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

	    if (result.getStatus() == ITestResult.FAILURE) {

	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	        File dest = new File("screenshots/" + result.getName() + ".png");

	        FileUtils.copyFile(src, dest);

	        System.out.println("Screenshot captured for failed test: " + result.getName());
	    }

	    driver.quit();
	}
	
	
}
