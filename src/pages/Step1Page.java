package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import common.CommonMethods;
import data.Details;
import stepDefs.BasePage;

public class Step1Page {

	public Step1Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "eyebrow")
	public WebElement stepTitle;
	@FindBy(id = "btnExisting")
	public WebElement existingCustomer;
	@FindBy(id = "first_name")
	public WebElement firstName;
	@FindBy(id = "middle_name")
	public WebElement middleName;
	@FindBy(id = "last_name")
	public WebElement lastName;
	@FindBy(id = "suffix_name-button")
	public WebElement suffixButton;
	@FindBy(id = "suffix_name")
	public WebElement suffixName;
	@FindBy(id = "street1")
	public WebElement street;
	@FindBy(id = "street2")
	public WebElement aptNo;
	@FindBy(id = "city")
	public WebElement city;
	@FindBy(id = "zipPostalCode")
	public WebElement zipCode;
	@FindBy(id = "date_of_birth")
	public WebElement DOB;
	@FindBy(id = "effectiveDate")
	public WebElement effectiveDate;
	@FindBy(id = "btnContinue")
	public WebElement continueButton;
	
	public String title = "STEP 1 OF 9"; 
	
	public void step1PageNewCustomerDetailsSteps(CommonMethods commonMethods, Details details) {
		commonMethods.waitUntilVisible(stepTitle);
		commonMethods.assertEquals(commonMethods.getText(stepTitle), title);
		commonMethods.enterText(firstName, details.getFirstName());
		commonMethods.enterText(middleName, details.getMiddleName());
		commonMethods.enterText(lastName, details.getLastName());
		commonMethods.click(suffixButton);
		commonMethods.click(clickSuffix(details.getPrefix()));
		commonMethods.enterText(street, details.getStreet());
		commonMethods.enterText(aptNo, details.getApt());
		commonMethods.clearText(city);
		commonMethods.enterText(city, details.getCity());
		commonMethods.clearText(zipCode);
		commonMethods.enterText(zipCode, details.getZip());
		commonMethods.enterText(DOB, details.getDob());
		commonMethods.clearText(effectiveDate);
		commonMethods.enterText(effectiveDate, details.getTodaysDate());
		commonMethods.click(continueButton);
	}
	
	public void step1PageExistingCustomerSteps(CommonMethods commonMethods) {
		commonMethods.click(existingCustomer);
	}
	
	public WebElement clickSuffix(String expectedSuffix) {
		return BasePage.driver.findElement(By.xpath("//li[contains(.,'"+ expectedSuffix +"')]"));
	}
	
	public String getTitle(CommonMethods commonMethods) {
		return commonMethods.getTitle();
	}
}
