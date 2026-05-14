package pom_files;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPagePOM {

	WebDriver driver;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement menuButton;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement logoutButton;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    public LogoutPagePOM(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void clickMenuButton() {

        menuButton.click();
    }

    public void clickLogoutButton() {

        logoutButton.click();
    }

    public boolean verifyLoginPageDisplayed() {

        return loginButton.isDisplayed();
    }

    public String getCurrentURL() {

        return driver.getCurrentUrl();
    }
}
