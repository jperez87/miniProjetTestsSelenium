package org.autom.fr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageConnection {

	protected final WebDriver driver;
	
	//public WebElement userInput = driver.findElement(By.id("username"));

	/*@FindBy(id = "username")
	public WebElement userInput;
	@FindBy(id = "password")
	public WebElement pwdInput;
	@FindBy(className = "sq-btn")
	public WebElement buttonSeConnecter;*/
	
	public PageConnection(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public HomePage connection(WebElement userInput, WebElement pwdInput, WebElement buttonSeConnecter, String name, String code) {
		userInput.clear();
		pwdInput.clear();
		userInput.sendKeys(name);
		pwdInput.sendKeys(code);
		buttonSeConnecter.click();

		return PageFactory.initElements(driver, HomePage.class);

	}
}
