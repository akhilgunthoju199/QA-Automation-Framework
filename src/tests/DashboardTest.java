package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import main.Utils;
import pom_files.DashBoardPOM;
import pom_files.Login_Page_POM;

public class DashboardTest extends Utils{
	
	@Test
    public void validateDashboardAfterLogin() throws InterruptedException {

		Login_Page_POM login = new Login_Page_POM(driver);
				
        login.enterValidUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLoginButton();

        DashBoardPOM dashboard = new DashBoardPOM(driver);

        Assert.assertEquals(dashboard.getPageTitle(), "Swag Labs");

        Assert.assertTrue(
                dashboard.getCurrentUrl().contains("inventory")
        );

        Assert.assertTrue(dashboard.isPageHeaderVisible());

        Assert.assertTrue(dashboard.isMenuButtonVisible());

        Assert.assertTrue(dashboard.isCartIconVisible());

        Assert.assertTrue(dashboard.isProductListVisible());

        Assert.assertTrue(dashboard.areProductCardsVisible());

        Assert.assertTrue(dashboard.isUserActionButtonVisible());
    }
}


