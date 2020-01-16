package br.com.rsinet.hub_tdd.pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_tdd.util.Constant;
import br.com.rsinet.hub_tdd.util.ExcelUtils;

public class HomePage{

	static WebDriver driver;

	@FindBy(how = How.ID, using = "hrefUserIcon")
	private static WebElement bt_UserIcon;

	@FindBy(how = How.XPATH, using = "/html/body/login-modal/div/div/div[3]/a[2]")
	private static WebElement bt_CriarNovaConta;

	@FindBy(how = How.NAME, using = "username")
	private static WebElement txt_UserName;

	@FindBy(how = How.NAME, using = "password")
	private static WebElement txt_Password;

	@FindBy(how = How.ID, using = "sign_in_btnundefined")
	private static WebElement bt_Logar;

	@FindBy(how = How.ID, using = "laptopsImg")
	private static WebElement bt_LaptopImg;

	@FindBy(how = How.ID, using = "menuSearch")
	private static WebElement bt_Lupa;

	@FindBy(how = How.ID, using = "autoComplete")
	private static WebElement txt_Pesquisa;

	@FindBy(how = How.XPATH, using = "//*[@id=\"search\"]/div/div/img")
	private static WebElement bt_FechaSugestao;

	@FindBy(how = How.XPATH, using = "//*[@id=\"searchPage\"]/div[3]/div/label/span")
	public static WebElement result_Produto;

	public static void criarNovaConta(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, HomePage.class);

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Cadastro");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		bt_UserIcon.click();

		bt_CriarNovaConta.sendKeys(Keys.ENTER);
	}

	public static void logaNaConta(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, HomePage.class);

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "PesquisaCat");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		bt_UserIcon.click();

		txt_UserName.sendKeys(ExcelUtils.getCellData(1, Constant.txt_UserNameCat));

		txt_Password.sendKeys(ExcelUtils.getCellData(1, Constant.txt_PasswordCat));

		bt_Logar.sendKeys(Keys.ENTER);
	}

	public static void produtoCategoria(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, HomePage.class);

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement elemento = bt_LaptopImg;
		executor.executeScript("arguments[0].click();", elemento);
	}

	public static void barraDePesquisa(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, HomePage.class);

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "PesquisaBarra");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		bt_Lupa.click();

		txt_Pesquisa.sendKeys(ExcelUtils.getCellData(1, Constant.txt_PesquisaBarra), Keys.ENTER);

		// Coloquei este thread.sleep devido a uma animação em java script onde nenhum
		// outro tipo de waiter funcionou
		// e estava atrapalhando a execução do código.
		Thread.sleep(3000);
		bt_FechaSugestao.click();
	}

	public static void barraDePesquisaErrado(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, HomePage.class);

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "PesquisaBarra");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		bt_Lupa.click();

		txt_Pesquisa.sendKeys(ExcelUtils.getCellData(1, Constant.txt_PesquisaBarraErro), Keys.ENTER);

		// Coloquei este thread.sleep devido a uma animação em java script onde nenhum
		// outro tipo de waiter funcionou
		// e estava atrapalhando a execução do código.
		Thread.sleep(1000);
		bt_FechaSugestao.click();
	}
}