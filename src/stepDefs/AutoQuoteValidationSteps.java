package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AutoQuoteValidationSteps {

	@Given("user is in the landing page")
	public void user_is_in_the_landing_page() {
	    System.out.println("It is step 1");
	}
	@When("user select {string} from product")
	public void user_select_from_product(String string) {
	    System.out.println("Step 2");
	}
	@When("insert {string} into zipcode")
	public void insert_into_zipcode(String string) {
		System.out.println("Step 3");
	}
	@When("click on {string} button")
	public void click_on_button(String string) {
		System.out.println("Step 4");
	}
	@Then("user will be in a page title {string}")
	public void user_will_be_in_a_page_title(String string) {
		System.out.println("Step 5");
	}

}
