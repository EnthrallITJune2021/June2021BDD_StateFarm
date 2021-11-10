package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.CommonMethods;

public class FindAccountPage {

	public FindAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1[contains(.,'find your account')]")
	public WebElement findAccountTitle;
	@FindBy(id = "forgotPhoneInput")
	public WebElement phoneLookup;
	@FindBy(id = "forgotDobInput")
	public WebElement DOBLookup;
	@FindBy(id = "forgotEmailInput")
	public WebElement emailLookup;
	@FindBy(xpath = "//label[@for='emailId']")
	public WebElement sendEmail;
	@FindBy(id = "submitBtn")
	public WebElement submitButton;
	
	public void findAccountSteps(CommonMethods commonMethods) {
		commonMethods.assertEquals(commonMethods.getText(findAccountTitle), "Let's find your account.");
		commonMethods.enterText(phoneLookup, "1112223333");
		commonMethods.enterText(DOBLookup, "10152000");
		commonMethods.enterText(emailLookup, "test@test.com");
		commonMethods.click(sendEmail);
		commonMethods.click(submitButton);
	}
	
}
