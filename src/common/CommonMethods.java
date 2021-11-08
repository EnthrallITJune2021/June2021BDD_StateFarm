package common;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepDefs.BasePage;

public class CommonMethods {

	public void dropDownSelectByValue(WebElement element, String value) {
		Select productDropdown = new Select(element);
		productDropdown.selectByValue(value);
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public void waitUntilVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(BasePage.driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void enterText(WebElement element, String zip) {
		element.sendKeys(zip);
	}
	
	public void enterText(WebElement element, int zip) {
		element.sendKeys(String.valueOf(zip));
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public void assertEquals(String actual, String expected) {
		Assert.assertEquals(actual, expected);
	}
	
	public void clearText(WebElement element) {
		element.clear();
	}
	
	public void hoverOnly(WebElement element) {
		Actions actions = new Actions(BasePage.driver);
		actions.moveToElement(element).build().perform();
	}
	
	public void hoverAndClick(WebElement element) {
		Actions actions = new Actions(BasePage.driver);
		actions.moveToElement(element).click().perform();
	}
	
	public String getTitle() {
		return BasePage.driver.getTitle();
	}
}
