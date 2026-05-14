package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import main.Utils;
import pom_files.Login_Page_POM;
import pom_files.LogoutPagePOM;

public class LogoutTest extends Utils{

	@Test
    public void verifyLogoutFlow() {

        Login_Page_POM login = new Login_Page_POM(driver);

        login.enterValidUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLoginButton();

        LogoutPagePOM logout = new LogoutPagePOM(driver);

        logout.clickMenuButton();

        logout.clickLogoutButton();

        Assert.assertTrue(
                logout.verifyLoginPageDisplayed()
        );

        Assert.assertEquals(
                logout.getCurrentURL(),
                "https://www.saucedemo.com/"
        );

        driver.navigate()
              .to("https://www.saucedemo.com/inventory.html");

        Assert.assertFalse(
                driver.getCurrentUrl()
                .contains("inventory.html")
        );
    }
}
