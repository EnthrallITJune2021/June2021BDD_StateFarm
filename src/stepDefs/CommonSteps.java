package stepDefs;

import java.util.logging.Level;
import static utils.LogClass.logger;
import common.CommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FindAccountPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.Step1Page;
import utils.ExcelReader;
import utils.ReadProperties;

public class CommonSteps{
	
	LandingPage landingPage = new LandingPage(BasePage.driver);
	Step1Page step1Page = new Step1Page(BasePage.driver);
	LoginPage loginPage = new LoginPage(BasePage.driver);
	FindAccountPage findAccountPage = new FindAccountPage(BasePage.driver);
	CommonMethods commonMethods = new CommonMethods();
	ExcelReader reader = new ExcelReader(System.getProperty("user.dir") + ReadProperties.instanceOFProp().getExcelPath(), ReadProperties.instanceOFProp().getSheetName());
	
	static String product = null;
	
	@Given("user is in the landing page")
	public void user_is_in_the_landing_page() {
		String titleString = landingPage.getTitle(commonMethods);
	    logger.log(Level.INFO, "Landing Page title is :"+ titleString +" \nVerified...");
	}
	
	@When("user select {string} from products")
	public void user_select_from_product(String string) {
		product = string;
		landingPage.selectProduct(commonMethods, string);
		logger.log(Level.INFO, string +" is verified");
	}
	
	@When("user enter {string} in zipcode")
	public void user_enter_in_zipcode(String string) {
		landingPage.enterZipCode(commonMethods, string);
		logger.log(Level.INFO, string + " is verified");
	}
	
	@When("user click {string} button")
	public void click_on_button(String string) {
		landingPage.clickStartQuote(commonMethods);
		logger.log(Level.INFO, "Button is verified");
	}
	
	@Then("user will be in a page title {string}")
	public void user_will_be_in_a_page_title(String string) {
		String titleString = null;
		if(product.contains("Auto")) {
			titleString = step1Page.getTitle();
		}else {
			titleString = step1Page.getHomeHeader();
		}
		commonMethods.assertEquals(titleString, string);
	    logger.log(Level.INFO, "Page title is :"+ titleString +" \nVerified...");
	}
	
	@Given("user validate landing page steps")
	public void user_validate_landing_page_steps() {
		landingPage.landingPageSteps(commonMethods, "Auto", "11101");
		logger.log(Level.INFO, "Landing Page Validated...");
	}
	
	@Given("user select existing user flow")
	public void user_select_existing_user_flow() {
		step1Page.step1PageExistingCustomerSteps(commonMethods);
		logger.log(Level.INFO, "Step1 Page Validated...");
	}
	
	@Then("user validate Login Page {int}")
	public void user_validate_login_page(Integer int1) {
		String user = String.valueOf(reader.dataTable()[int1][0]);
		String pass = String.valueOf(reader.dataTable()[int1][1]);
		loginPage.loginPageSteps(commonMethods, user, pass);
		reader.writeInExcel(int1, 2, "Passed");
		logger.log(Level.INFO, "Validated Login Page ...");
	}
	
	@Then("user validate Find Account steps")
	public void user_validate_find_account_steps() {
		findAccountPage.findAccountSteps(commonMethods);
		logger.log(Level.INFO, "Find Account Page Validated...");
	}
}
