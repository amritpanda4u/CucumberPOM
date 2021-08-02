package parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountsPageSteps {
	
	LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	AccountsPage accountsPage;
	String userName = "";
	
	@Given("The user is logged in to the application")
	public void the_user_is_logged_in_to_the_application(DataTable credentials) {
		List<Map<String,String>> cred = credentials.asMaps();
		String username = cred.get(0).get("username");
		String password = cred.get(0).get("password");
		DriverFactory.getDriver()
		.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	   accountsPage = loginPage.doLogin(username, password);
	}

	@Given("user is in Accounts page")
	public void user_is_in_accounts_page() {
	    accountsPage.getPageTitle();
	}

	@When("user gets the logged in username")
	public void user_gets_the_logged_in_username() {
	    userName = accountsPage.getLoggedInUserName();
	}

	@Then("the username should be {string}")
	public void the_username_should_be(String user) {
	   Assert.assertTrue(userName.equals(user));
	}

	@When("user gets the page title")
	public void user_gets_the_page_title() {
		accountsPage.getPageTitle();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expPageTitle) {
		String actPageTitle = accountsPage.getPageTitle();
		Assert.assertTrue(actPageTitle.equals(expPageTitle));
	}

	@When("user gets the accounts menu list")
	public void user_gets_the_accounts_menu_list() {
	    
	}

	@Then("user gets")
	public void user_gets(DataTable menuList) {
	    List<String> expMenuOptions = menuList.asList();
	    System.out.println("Expected accounts section list: " + expMenuOptions);
	    List<String> actMenuOptions = accountsPage.getOptions();
	    System.out.println("Actual accounts section list: " + actMenuOptions);
	    Assert.assertTrue(actMenuOptions.containsAll(expMenuOptions));
	}

	@Then("the menu list count {int}")
	public void the_menu_list_count(Integer optionsCount) {
	   Assert.assertTrue(optionsCount == accountsPage.getOptionsCount());
	}

}
