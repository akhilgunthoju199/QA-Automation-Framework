package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import main.Utils;
import pom_files.CartPage_POM;
import pom_files.Login_Page_POM;

public class CartTest extends Utils{

	 @Test
	    public void verifyAddToCartFlow() throws InterruptedException {

	        Login_Page_POM login = new Login_Page_POM(driver);

	        login.enterValidUsername("standard_user");
	        login.enterPassword("secret_sauce");
	        login.clickLoginButton();

	        CartPage_POM cart = new CartPage_POM(driver);

	        cart.clickAddToCartButton();

	        Assert.assertEquals(
	                cart.getCartBadgeCount(),
	                "1"
	        );

	        cart.openCartPage();

	        Assert.assertEquals(
	                cart.getCartItemName(),
	                "Sauce Labs Backpack"
	        );
	    }
	}

