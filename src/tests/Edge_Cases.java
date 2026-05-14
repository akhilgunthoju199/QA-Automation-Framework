package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import main.Utils;
import pom_files.Login_Page_POM;

public class Edge_Cases extends Utils{

	@Test
	public void verifyLoginWithEmpty_Username(String emptyUsername, String validPassword) {
		Login_Page_POM loginPgae = new Login_Page_POM(driver);
		loginPgae.enterValidUsername(emptyUsername);
		loginPgae.enterPassword(validPassword);
		loginPgae.clickLoginButton();
		
		Assert.assertTrue(
                loginPgae.getErrorMessage().contains("Username is required")
        );
	}
	
	@Test
	public void emptyPasswordTest(String validUsername, String emptyPassword) {
		Login_Page_POM loginPgae = new Login_Page_POM(driver);
		loginPgae.enterValidUsername(validUsername);
		loginPgae.enterPassword(emptyPassword);
		loginPgae.clickLoginButton();
		
		Assert.assertTrue(loginPgae.getErrorMessage().contains("Password is required"));
		
	}
	
	@Test
	public void emptyUsernameAndPasswordTest(String emptyUsername, String emptyPassword) {
		Login_Page_POM loginPgae = new Login_Page_POM(driver);
		loginPgae.enterValidUsername(emptyUsername);
		loginPgae.enterPassword(emptyPassword);
		loginPgae.clickLoginButton();
		
		Assert.assertTrue(loginPgae.getErrorMessage().contains("Username is required"));
	}
	
	@Test
	public void specialCharactersLoginTest(String specialCharacters, String SpecialCharacterPassword) {
		Login_Page_POM loginPgae = new Login_Page_POM(driver);
		loginPgae.enterValidUsername(specialCharacters);
		loginPgae.enterPassword(SpecialCharacterPassword);
		loginPgae.clickLoginButton();
		
		Assert.assertTrue(loginPgae.getErrorMessage().contains("Username and password do not match"));
	}
	
	
}
