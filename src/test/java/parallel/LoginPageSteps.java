package parallel;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
//	@Given("user is on login page")
//	public void user_is_on_login_page() {
//		DriverFactory.getDriver()
//		.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
//	}
//
//	@When("user clicks on Signin link")
//	public void user_clicks_on_signin_link() {
//		loginPage.clickSigninLInk();
//	}
//
//	@Then("forgot password link is displayed")
//	public void forgot_password_link_is_displayed() {
//	   Assert.assertTrue(loginPage.ForgotPasswordIsDisplayed());
//	}

	@Given("user is on login button")
	public void user_is_on_login_button() {
	   
	}

//	@When("user enters username{string}")
//	public void user_enters_username(String username) {
//	    loginPage.enterUserName(username);
//	}
//
//	@When("user enters password{string}")
//	public void user_enters_password(String password) {
//	    loginPage.enterPassword(password);
//	}
	
	@When("clicks on Signin button")
	public void clicks_on_signin_button() {
	   loginPage.clickSigninBtn();
	}

	@Then("user is in home page")
	public void user_is_in_home_page() {
	    loginPage.getPageTitle();
	}

	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver()
		.get("http://automationpractice.com");
	}
	@When("user clicks on Signin link")
	public void user_clicks_on_signin_link() {
		loginPage.clickSigninLInk();
	}
	@Then("forgot password link is displayed")
	public void forgot_password_link_is_displayed() {
		Assert.assertTrue(loginPage.ForgotPasswordIsDisplayed());
	}
	
	@When("user enters username {string}")
	public void user_enters_username(String username) {
		loginPage.enterUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
	}

}
