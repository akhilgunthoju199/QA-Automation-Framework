package pom_files;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.Utils;

public class DashBoardPOM {
	
	WebDriver driver;
    WebDriverWait wait;
    
    @FindBy(xpath = "//span[text()='Products']")
    private WebElement pageHeader;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement menuButton;

    @FindBy(id = "shopping_cart_container")
    private WebElement cartIcon;

    @FindBy(xpath = "//div[@class='inventory_list']")
    private WebElement productListSection;

    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<WebElement> productCards;

    @FindBy(xpath = "//button[contains(text(),'Add to cart')]")
    private List<WebElement> addToCartButtons;

    public DashBoardPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isPageHeaderVisible() {
        wait.until(ExpectedConditions.visibilityOf(pageHeader));
        return pageHeader.isDisplayed();
    }

    public boolean isMenuButtonVisible() {
        return menuButton.isDisplayed();
    }

    public boolean isCartIconVisible() {
        return cartIcon.isDisplayed();
    }

    public boolean isProductListVisible() {
        return productListSection.isDisplayed();
    }

    public boolean areProductCardsVisible() {
        return productCards.size() > 0;
    }

    public boolean isUserActionButtonVisible() {
        return addToCartButtons.size() > 0;
    }
}

