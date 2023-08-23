package com.stepDefination;

import java.sql.DriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.Utitles.Drivermanger;
import com.Utitles.Globalvariables;
import com.pageobjects.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.LoginPageSteps;

public class Testcase_001 implements Globalvariables {
	private static final Logger LOG = LogManager.getLogger(Testcase_001.class);

	LoginPageSteps loginPageSteps = new LoginPageSteps(Drivermanger.getDriver());

	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {

		Drivermanger.getDriver().get(BASE_URL);
	}

	@When("the user enters valid username and password")
	public void the_user_enters_valid_username_and_password() throws InterruptedException {
		loginPageSteps.Enter_the_Login_details(MOBILE, PIN);
	}

	@When("the user clicks the login button")
	public void the_user_clicks_the_login_button() throws InterruptedException {
		loginPageSteps.Login();
	}

	@When("the user clicks the Check button")
	public void the_user_clicks_the_check_button() {

	}

	@Then("the user should be navigated to the site list")
	public void the_user_should_be_navigated_to_the_site_list() {

	}

	@Then("the user clicks the Automation Bot site")
	public void the_user_clicks_the_automation_bot_site() {

	}

	@When("the user enters data in the first form")
	public void the_user_enters_data_in_the_first_form() {

	}

	@When("submits the form")
	public void submits_the_form() {

	}

	@Then("the user should see a confirmation for the first form")
	public void the_user_should_see_a_confirmation_for_the_first_form() {

	}

	@When("the user enters data in the second form")
	public void the_user_enters_data_in_the_second_form() {

	}

	@Then("the user should see a confirmation for the second form")
	public void the_user_should_see_a_confirmation_for_the_second_form() {

	}

	@When("the user enters data in the third form")
	public void the_user_enters_data_in_the_third_form() {

	}

	@Then("the user should see a confirmation for the third form")
	public void the_user_should_see_a_confirmation_for_the_third_form() {

	}

	@When("the user clicks the Checkout button")
	public void the_user_clicks_the_checkout_button() {

	}

	@Then("a confirmation pop-up should appear")
	public void a_confirmation_pop_up_should_appear() {

	}

	@When("the user confirms Yes")
	public void the_user_confirms_yes() {

	}

	@Then("the user should be checked out and see a checkout confirmation")
	public void the_user_should_be_checked_out_and_see_a_checkout_confirmation() {

	}

	@When("the user clicks the Logout button")
	public void the_user_clicks_the_logout_button() {

	}

	@Then("the user should be logged out and redirected to the login page")
	public void the_user_should_be_logged_out_and_redirected_to_the_login_page() {

	}

}
