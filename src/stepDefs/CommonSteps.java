package stepDefs;

import java.util.logging.Level;

import common.CommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LandingPage;
import utils.LogClass;

public class CommonSteps{
	
	LandingPage landingPage = new LandingPage(BasePage.driver);
	CommonMethods commonMethods = new CommonMethods();
	
	@Given("user is in the landing page")
	public void user_is_in_the_landing_page() {
		String titleString = landingPage.getTitle(commonMethods);
	    LogClass.logger.log(Level.INFO, "Landing Page title is :"+ titleString +" \nVerified...");
	}
	@When("user select {string} from products")
	public void user_select_from_product(String string) {
		landingPage.selectProduct(commonMethods, string);
		LogClass.logger.log(Level.INFO, string +" is verified");
	}
	@When("user enter {string} in zipcode")
	public void user_enter_in_zipcode(String string) {
		landingPage.enterZipCode(commonMethods, string);
		LogClass.logger.log(Level.INFO, string + " is verified");
	}
	@When("user click {string} button")
	public void click_on_button(String string) {
		landingPage.clickStartQuote(commonMethods);
		LogClass.logger.log(Level.INFO, "Button is verified");
	}
	@Then("user will be in a page title {string}")
	public void user_will_be_in_a_page_title(String string) {
		String titleString = landingPage.getTitle(commonMethods);
	    LogClass.logger.log(Level.INFO, "Page title is :"+ titleString +" \nVerified...");
	}
}
