package pom_files;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import main.Utils;




public class Login_Page_POM extends Utils {
	
	 WebDriver driver;
	    WebDriverWait wait;
	
	@FindBy(id="user-name")
	private WebElement usernameTestbox;
	
	@FindBy(id="password")
	private WebElement passwordTextbox;
	
	@FindBy(id="login-button")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[@class=\"app_logo\"]")
	private WebElement productsHeading;
	
	@FindBy(id="shopping_cart_container")
	private WebElement cartIcon;
	
	@FindBy(xpath="//button[text()='Open Menu']")
	private WebElement menuButton;
	
	@FindBy(xpath = "//div[@class='inventory_item']")
	private List<WebElement> productList;
	
	@FindBy(xpath="//*[@id=\"login_button_container\"]/div/form/div[3]/h3/text()")
	private WebElement errorMessage;
	
	@FindBy(xpath="//h3[text()='Epic sadface: Username is required']")
	private WebElement errorMessageForRequiredFields;
	
	
	
	  public Login_Page_POM(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	  }
	  
	  public void enterValidUsername(String Username) {
		  usernameTestbox.sendKeys(Username);
	  }
	  
	  public void enterPassword(String Password) {
		  passwordTextbox.sendKeys(Password);
	  }
	  
	  public void clickLoginButton() {
		  loginButton.click();
	  }
	  
	  public boolean verifyProductsHeading() {

	        return productsHeading.isDisplayed();
	    }

	    public boolean verifyCartIcon() {

	        return cartIcon.isDisplayed();
	    }

	    public boolean verifyMenuButton() {

	        return menuButton.isDisplayed();
	    }

	    public boolean verifyProductList() {

	        return productList.size() > 0;
	    }
	    
	    public String verifyErrorMessage() {
	    	return errorMessage.getText();
	    	
	    }
	    
	    public String getErrorMessage() {
	    	return errorMessageForRequiredFields.getText();
	    }
	}

