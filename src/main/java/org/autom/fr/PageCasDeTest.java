package org.autom.fr;


//import org.junit.Assert.assertEquals;
//import org.junit.Assert.assertFalse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class PageCasDeTest extends ObjectPageCommun {

	public PageCasDeTest(WebDriver driver) {
		super(driver);
	}

	

	String titrePo = "Ajouter un cas de test";
	String messageSurbrillance = "jstree-clicked ui-state-default";
	/*@FindBy(xpath ="//div[@id='tree']/ul/li[1]/a")
	public WebElement projet;
	@FindBy(xpath ="//a[@id='tree-create-button']")
	public WebElement boutonPlusse;
	*/
	
	
	public void casDeTestSurbrillance(WebElement projet) throws Exception {
		String originalClass = projet.getAttribute("class");
		System.err.println("Etat original : "+originalClass);
		projet.click();
		Thread.sleep(5000);
		projet.click();
		String clickedClass = projet.getAttribute("class");
		System.err.println("Etat apres click : "+clickedClass);
		//assertFalse(originalClass.equals(clickedClass));
		//assertEquals(messageSurbrillance, clickedClass);
	}
	public void ajouterCasDeTest(WebElement bouton, WebElement ajouter) {
		bouton.click();
		ajouter.click();
	}
	
	public void popUpAjoutCdT1(WebElement titrePopUp, WebElement xPopUp) {
		System.err.println("Titre de la PopUp : "+titrePopUp.getText());
		xPopUp.click();
	}
	
	public void popUpAjoutCdT2(WebElement titrePopUp, WebElement fermerPopUp) {
		System.err.println("Titre de la PopUp : "+titrePopUp.getText());
		fermerPopUp.click();		
	}
	
	public void popUpAjoutTableau(WebElement ajoutTableau, WebElement validerPopUp) {
		ajoutTableau.click();

		//validerTableau.click();
		validerPopUp.click();
	}
	
}
