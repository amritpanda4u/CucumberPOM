package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
		
	public LoginPage(WebDriver driver) {
		this.driver = driver ;
	}

	private By SigninLink = By.xpath("//a[contains(text(),'Sign in')]");
	private By ForgotPassword = By.linkText("Forgot your password?");
	private By Email = By.id("email");
	private By Password = By.id("passwd");
	private By SignInBtn = By.id("SubmitLogin");
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void clickSigninLInk() {
		driver.findElement(SigninLink).click();
	}
	public boolean ForgotPasswordIsDisplayed() {
		return driver.findElement(ForgotPassword).isDisplayed();
	}
	
	public void enterUserName(String username) {
		driver.findElement(Email).sendKeys(username);
	}
	
	public void enterPassword(String passwd) {
		driver.findElement(Password).sendKeys(passwd);
	}
	
	public void clickSigninBtn() {
		driver.findElement(SignInBtn).click();
	}
	
	public AccountsPage doLogin(String username, String password) {
		driver.findElement(Email).sendKeys(username);
		driver.findElement(Password).sendKeys(password);
		driver.findElement(SignInBtn).click();
		return new AccountsPage(driver);
	}
}
