package org.autom.fr;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends ObjectPageCommun {


	@FindBy(xpath="//h2[contains(.,'HOME')]")
	public WebElement messageHome;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public PageCasDeTest accesPageCdT() {
		espaceCasDeTest.click();
		return PageFactory.initElements(driver, PageCasDeTest.class);
	}

	/*public WebElement getMessageHome() {
		return messageHome;
	}

	public void setMessageHome(WebElement messageHome) {
		this.messageHome = messageHome;
	}*/
	
}
