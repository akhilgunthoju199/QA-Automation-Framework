package pom_files;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage_POM {

	WebDriver driver;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement cartBadge;

    @FindBy(xpath = "//div[@id='shopping_cart_container']")
    private WebElement cartIcon;

    @FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
    private WebElement cartItemName;

    public CartPage_POM(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void clickAddToCartButton() {

        addToCartButton.click();
    }

    public String getCartBadgeCount() {

        return cartBadge.getText();
    }

    public void openCartPage() {

        cartIcon.click();
    }

    public String getCartItemName() {

        return cartItemName.getText();
    }
}
