package org.autom.fr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ObjectPageCommun {
	
	public WebDriver driver;

	@FindBy(id="requirement-link")
	public WebElement espaceExigences;
	@FindBy(id="test-case-link")
	public WebElement espaceCasDeTest;
	@FindBy(id="campaign-link")
	public WebElement espaceCampagne;
	
	public ObjectPageCommun(WebDriver driver) {
		super();
		this.driver = driver;
	}

}
