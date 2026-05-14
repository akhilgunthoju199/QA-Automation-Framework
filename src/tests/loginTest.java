package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import main.Utils;
import pom_files.Login_Page_POM;

public class loginTest extends Utils {
	
	
	@Parameters({"Username", "Password"}) 
	@Test(priority = 1)
	public void verifyLoginWithValidCredentials(String Username, String Password) {
		Login_Page_POM loginPgae = new Login_Page_POM(driver);
		loginPgae.enterValidUsername(Username);
		loginPgae.enterPassword(Password);
		loginPgae.clickLoginButton();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
		
		Assert.assertTrue(loginPgae.verifyProductsHeading());

        //Assert.assertEquals(login.getPageHeadingText(), "Products");

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));

        Assert.assertTrue(loginPgae.verifyCartIcon());

        Assert.assertTrue(loginPgae.verifyMenuButton());

        Assert.assertTrue(loginPgae.verifyProductsHeading());
    }
	
	@Parameters({"InvalidUsername", "InvalidPassword"})
	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials(String InvalidUsername, String InvalidPassword) {
		Login_Page_POM loginPgae = new Login_Page_POM(driver);
		loginPgae.enterValidUsername(InvalidUsername);
		loginPgae.enterPassword(InvalidPassword);
		loginPgae.clickLoginButton();
		
		String actualErrorMessage = loginPgae.verifyErrorMessage();
		
		Assert.assertTrue(
                actualErrorMessage.contains("Username and password do not match"),
                "Invalid login error message is not displayed");
		Assert.assertTrue(
                driver.getCurrentUrl().contains("saucedemo.com"),
                "User navigated away from login page"
        );
	}
	
}
	
	

