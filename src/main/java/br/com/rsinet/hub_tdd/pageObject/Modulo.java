package br.com.rsinet.hub_tdd.pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Modulo {

	public static void criarNovaConta(WebDriver driver) {
		PageFactory.initElements(driver, HomePage.class);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		HomePage.userIcon.click();

		HomePage.criarNovaConta.sendKeys(Keys.ENTER);
	}

	public static void logaNaConta(WebDriver driver) {

		PageFactory.initElements(driver, HomePage.class);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		HomePage.userIcon.click();

		HomePage.userName.sendKeys("lucascarvalho");

		HomePage.password.sendKeys("10203040Lcc");

		HomePage.btLogar.sendKeys(Keys.ENTER);
	}

	public static void produtoCategoria(WebDriver driver) {

		PageFactory.initElements(driver, HomePage.class);

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement elemento = HomePage.laptopImg;

		executor.executeScript("arguments[0].click();", elemento);
	}

	public static void barraDePesquisa(WebDriver driver) throws InterruptedException {

		PageFactory.initElements(driver, HomePage.class);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		HomePage.lupa.click();
		
		HomePage.txtPesquisa.sendKeys("HP" + Keys.ENTER);
		
		Thread.sleep(2000);
		HomePage.fechaSegestao.click();
	}
	
	public static void barraDePesquisaErrado(WebDriver driver) {

		PageFactory.initElements(driver, HomePage.class);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		HomePage.lupa.click();
		
		HomePage.txtPesquisa.sendKeys("fones" + Keys.ENTER);
	}
	
	public static void cadastrarUsuario(WebDriver driver) {
		
		PageFactory.initElements(driver, CadastroPage.class);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		CadastroPage.userName.sendKeys("lucascarvalho");
		CadastroPage.email.sendKeys("lucas.carvalho99@hotmail.com");
		CadastroPage.password.sendKeys("10203040Lcc");
		CadastroPage.confirmPassword.sendKeys("10203040Lcc");
		CadastroPage.firstName.sendKeys("Lucas");
		CadastroPage.lastName.sendKeys("Carvalho Correia");
		CadastroPage.telefone.sendKeys("967553055");
		
		WebElement Country = CadastroPage.pais;
		Select comboBox = new Select(Country);
		comboBox.selectByVisibleText("Brazil");
		
		CadastroPage.cidade.sendKeys("Guarulhos");
		CadastroPage.endereco.sendKeys("lucinda fernandes");
		CadastroPage.estado.sendKeys("São Paulo");
		CadastroPage.cep.sendKeys("07080320");
		CadastroPage.boxOffers.click();
		CadastroPage.boxAgree.click();
		CadastroPage.btRegistrar.click();
	}
	
public static void cadastrarUsuarioErrado(WebDriver driver) {
		
		PageFactory.initElements(driver, CadastroPage.class);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		CadastroPage.userName.sendKeys("lucascarvalho");
		CadastroPage.email.sendKeys("lucas.carvalho99@hotmail.com");
		CadastroPage.password.sendKeys("10203040Lcc");
		CadastroPage.confirmPassword.sendKeys("10203040Lcc");
		CadastroPage.firstName.sendKeys("Lucas");
		CadastroPage.lastName.sendKeys("Carvalho Correia");
		CadastroPage.telefone.sendKeys("967553055");
		
		WebElement Country = CadastroPage.pais;
		Select comboBox = new Select(Country);
		comboBox.selectByVisibleText("Brazil");
		
		CadastroPage.cidade.sendKeys("Guarulhos");
		CadastroPage.endereco.sendKeys("lucinda fernandes");
		CadastroPage.estado.sendKeys("São Paulo");
		CadastroPage.cep.sendKeys("07080320");
		CadastroPage.boxOffers.click();
		CadastroPage.boxAgree.click();
		CadastroPage.btRegistrar.click();
		
		WebElement senha = CadastroPage.confirmPassword;
		senha.clear();
		senha.sendKeys("102030400Lcc");
		
		CadastroPage.password.click();
	}
	
	public static void pesquisaCategoria(WebDriver driver) {
		
		PageFactory.initElements(driver, PesquisaPage.class);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		PesquisaPage.btProduto.click();
		
		PesquisaPage.salvaProduto.click();
		
		PesquisaPage.comprar.click();
	}
	
public static void pesquisaCategoriaErrada(WebDriver driver) {
		
		PageFactory.initElements(driver, PesquisaPage.class);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		PesquisaPage.btProduto.click();
		
		PesquisaPage.quantidade.sendKeys("1");
		
		PesquisaPage.salvaProduto.click();
		
		PesquisaPage.comprar.click();
	}

public static void pesquisaPorDescricao(WebDriver driver) {
	
	PageFactory.initElements(driver, PesquisaPage.class);

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	PesquisaPage.idProduto.click();
}

}
