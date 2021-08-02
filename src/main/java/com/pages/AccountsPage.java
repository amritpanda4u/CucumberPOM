package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	
	WebDriver driver;
	private By menuList = By.xpath("//ul[@class='myaccount-link-list']/li/a/span");
	private By username = By.xpath("//a[@class= 'account']/span");
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getLoggedInUserName() {
		return driver.findElement(username).getText();
	}
	
	public List<String> getOptions(){
		List<WebElement> options = driver.findElements(menuList);
		List<String> menuListOptions = new ArrayList<String>();
		System.out.println("Inside Accounts Page");
		for (WebElement opt : options) {
			 menuListOptions.add(opt.getText());
			 System.out.println(opt.getText());
		}
		return menuListOptions;
	}
	
	public int getOptionsCount() {
		return driver.findElements(menuList).size();
	}
}
