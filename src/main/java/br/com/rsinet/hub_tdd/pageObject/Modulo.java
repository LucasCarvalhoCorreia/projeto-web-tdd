package br.com.rsinet.hub_tdd.pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import br.com.rsinet.hub_tdd.util.Constant;
import br.com.rsinet.hub_tdd.util.ExcelUtils;

public class Modulo {

	public static void criarNovaConta(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, HomePage.class);

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Cadastro");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		HomePage.bt_UserIcon.click();

		HomePage.bt_CriarNovaConta.sendKeys(Keys.ENTER);
	}

	public static void logaNaConta(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, HomePage.class);

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "PesquisaCat");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		HomePage.bt_UserIcon.click();

		HomePage.txt_UserName.sendKeys(ExcelUtils.getCellData(1, Constant.txt_UserNameCat));

		HomePage.txt_Password.sendKeys(ExcelUtils.getCellData(1, Constant.txt_PasswordCat));

		HomePage.bt_Logar.sendKeys(Keys.ENTER);
	}

	public static void produtoCategoria(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, HomePage.class);

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement elemento = HomePage.bt_LaptopImg;
		executor.executeScript("arguments[0].click();", elemento);
	}

	public static void barraDePesquisa(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, HomePage.class);

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "PesquisaBarra");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		HomePage.bt_Lupa.click();

		HomePage.txt_Pesquisa.sendKeys(ExcelUtils.getCellData(1, Constant.txt_PesquisaBarra), Keys.ENTER);

		Thread.sleep(2000);
		HomePage.bt_FechaSugestao.click();
	}

	public static String barraDePesquisaErrado(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, HomePage.class);

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "PesquisaBarra");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		HomePage.bt_Lupa.click();

		HomePage.txt_Pesquisa.sendKeys(ExcelUtils.getCellData(1, Constant.txt_PesquisaBarraErro), Keys.ENTER);
		
		return HomePage.result_Produto.getText();
	}

	public static void cadastrarUsuario(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, CadastroPage.class);

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Cadastro");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		CadastroPage.txt_UserName.sendKeys(ExcelUtils.getCellData(1, Constant.txt_UserName));
		CadastroPage.txt_Email.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Email));
		CadastroPage.txt_Password.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Password));
		CadastroPage.txt_ConfirmPassword.sendKeys(ExcelUtils.getCellData(1, Constant.txt_ConfirmPassword));
		CadastroPage.txt_FirstName.sendKeys(ExcelUtils.getCellData(1, Constant.txt_FirstName));
		CadastroPage.txt_LastName.sendKeys(ExcelUtils.getCellData(1, Constant.txt_LastName));
		CadastroPage.txt_Telefone.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Telefone));

		WebElement Country = CadastroPage.combo_Pais;
		Select comboBox = new Select(Country);
		comboBox.selectByVisibleText(ExcelUtils.getCellData(1, Constant.combo_Pais));

		CadastroPage.txt_Cidade.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Cidade));
		CadastroPage.txt_Endereco.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Endereco));
		CadastroPage.txt_Estado.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Estado));
		CadastroPage.txt_Cep.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Cep));
		CadastroPage.check_Offers.click();
		CadastroPage.check_Agree.click();
		CadastroPage.bt_Registrar.click();
	}

	public static void cadastrarUsuarioErrado(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, CadastroPage.class);

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Cadastro");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		CadastroPage.txt_UserName.sendKeys(ExcelUtils.getCellData(1, Constant.txt_UserName));
		CadastroPage.txt_Email.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Email));
		CadastroPage.txt_Password.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Password));
		CadastroPage.txt_ConfirmPassword.sendKeys(ExcelUtils.getCellData(1, Constant.txt_ConfirmPassword));
		CadastroPage.txt_FirstName.sendKeys(ExcelUtils.getCellData(1, Constant.txt_FirstName));
		CadastroPage.txt_LastName.sendKeys(ExcelUtils.getCellData(1, Constant.txt_LastName));
		CadastroPage.txt_Telefone.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Telefone));

		WebElement Country = CadastroPage.combo_Pais;
		Select comboBox = new Select(Country);
		comboBox.selectByVisibleText(ExcelUtils.getCellData(1, Constant.combo_Pais));

		CadastroPage.txt_Cidade.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Cidade));
		CadastroPage.txt_Endereco.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Endereco));
		CadastroPage.txt_Estado.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Estado));
		CadastroPage.txt_Cep.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Cep));
		CadastroPage.check_Offers.click();
		CadastroPage.check_Agree.click();
		CadastroPage.bt_Registrar.click();

		WebElement senha = CadastroPage.txt_ConfirmPassword;
		senha.clear();
		senha.sendKeys(ExcelUtils.getCellData(2, Constant.txt_ConfirmPassword));

		CadastroPage.txt_Password.click();
	}

	public static void pesquisaCategoria(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, PesquisaPage.class);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		PesquisaPage.bt_Produto.click();

		PesquisaPage.bt_SalvaProduto.click();

		PesquisaPage.bt_Comprar.click();
	}

	public static void pesquisaCategoriaErrada(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, PesquisaPage.class);

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "PesquisaCat");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		PesquisaPage.bt_Produto.click();

		PesquisaPage.txt_Quantidade.sendKeys(ExcelUtils.getCellData(1, Constant.txt_QuantidadeCat));

		PesquisaPage.bt_SalvaProduto.click();

		PesquisaPage.bt_Comprar.click();
	}

	public static void pesquisaPorDescricao(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, PesquisaPage.class);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		PesquisaPage.id_Produto.click();
	}

}
