package org.autom.fr;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MiniProjetPipiliniTest {

	protected WebDriver driver;

	public String TUT = System.getProperty("navigateur");
	public String user="admin";
	public String pwd="admin";

	@Before
	public void monBefore() {	

		if (TUT.equals("chrome")) {
			System.setProperty("driver.chrome.driver", "C:\\Users\\formation\\Desktop\\SUT\\chromedriver.exe");
			driver = new ChromeDriver();

		}
		else if(TUT.equals("firefox")) {
			System.setProperty("driver.gecko.driver", "C:\\Users\\formation\\Desktop\\SUT\\geckodriver.exe");
			driver = new FirefoxDriver();

		};

		driver.get("http://192.168.102.184:9876/squash/");
		//PageFactory.initElements(driver, PageConnection.class);

	}

	@Test
	public void creerUnCasDeTest() throws Exception {
		System.out.println("/////////////*********DEBUT_DES_TESTS*********/////////////");
		PageFactory.initElements(driver, PageConnection.class);
		PageConnection pageConnect = new PageConnection(driver);

		//Se connecter en tant que 'admin'
		HomePage homePage = new HomePage(driver);

		WebElement userInput = driver.findElement(By.id("username"));
		WebElement pwdInput = driver.findElement(By.id("password"));
		WebElement buttonSeConnecter = driver.findElement(By.className("sq-btn"));
		homePage = pageConnect.connection(userInput, pwdInput, buttonSeConnecter, user, pwd);

		//On vérifie qu'on se situe bien sur la page d'accueil
		//assertTrue(homePage.getMessageHome().getText().equals("HOME"));

		//Aller dans l'Espace Cas de test et sélectionner un projet dans l'arbre des cas de test.
		PageCasDeTest pageCasdT = new PageCasDeTest(driver);
		pageCasdT = homePage.accesPageCdT();
		Thread.sleep(6000);
		WebElement projet = driver.findElement(By.xpath("//div[@id='tree']/ul/li[1]/a"));
		pageCasdT.casDeTestSurbrillance(projet);

		//ajouter un cas de test
		WebElement buttonPlusse = driver.findElement(By.id("tree-create-button"));
		WebElement ajouterCdT = driver.findElement(By.id("new-test-case-tree-button"));
		pageCasdT.ajouterCasDeTest(buttonPlusse, ajouterCdT);

		//Vérification des champs
		WebElement titre = driver.findElement(By.id("ui-id-17"));
		WebElement fermerPop = driver.findElement(By.xpath("//span[@id='ui-id-17']/following-sibling::a[@class='ui-dialog-titlebar-close ui-corner-all']"));
		WebElement fermerPopButtopn = driver.findElement(By.xpath("/html/body/div[13]/div[3]/div/input[3]"));
		pageCasdT.popUpAjoutCdT1(titre, fermerPop);

		pageCasdT.ajouterCasDeTest(buttonPlusse, ajouterCdT);
		pageCasdT.popUpAjoutCdT2(titre, fermerPopButtopn);

		/*pageCasdT.ajouterCasDeTest(buttonPlusse, ajouterCdT);
		WebElement ajoutTableau = driver.findElement(By.xpath("//a[@id='cke_80']"));
		WebElement okTableau = driver.findElement(By.cssSelector("span#cke_613_label"));
		WebElement validerTableau = driver.findElement(By.xpath("/html/body/div[13]/div[3]/div/input[2]"));
		pageCasdT.popUpAjoutTableau(ajoutTableau, validerTableau);*/
	}

	@After
	public void monAfter() {
		driver.close();
		driver.quit();

	}

}
