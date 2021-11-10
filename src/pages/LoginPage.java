package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import common.CommonMethods;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1[contains(.,'Log In')]")
	public WebElement loginTitle;
	@FindBy(id = "username")
	public WebElement userName;
	@FindBy(id = "password")
	public WebElement passWord;
	@FindBy(id = "submitButton")
	public WebElement loginButton;
	
	public void loginPageSteps(CommonMethods commonMethods, String user, String pass) {
		commonMethods.assertEquals(commonMethods.getText(loginTitle), "Log In");
		commonMethods.enterText(userName, user);
		commonMethods.enterText(passWord, pass);
		commonMethods.click(loginButton);
	}
}
