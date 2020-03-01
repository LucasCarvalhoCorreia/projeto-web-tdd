package br.com.rsinet.hub_tdd.testes.sucessos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub_tdd.excel.Constantes;
import br.com.rsinet.hub_tdd.excel.ExcelUtils;
import br.com.rsinet.hub_tdd.excel.PegaMassa;
import br.com.rsinet.hub_tdd.extendReport.ExtendReport;
import br.com.rsinet.hub_tdd.manager.DriverFactory;
import br.com.rsinet.hub_tdd.pageObject.HomePage;
import br.com.rsinet.hub_tdd.pageObject.PesquisaPage;

public class ConsultaPorCategoriaSucesso extends DriverFactory {

	private ExtentTest test;
	private WebDriver driver;
	private HomePage homePage;
	private PesquisaPage pesquisaPage;
	private PegaMassa pegaMassa;

	/* Área responsavel pelos testes de sucesso. */

	/* @ responsavel por executar todos os elementos antes do @Test. */
	@BeforeTest
	public void iniciaExtendReport() {
		ExtendReport.setExtent();
	}
	
	@BeforeMethod
	public void inicio() throws Exception {
		driver = DriverFactory.iniciaBrowser();

		/*
		 * Comando responsavel por iniciar os elementos dentro da pageFactory
		 * especificada.
		 */
		homePage = PageFactory.initElements(driver, HomePage.class);
		pesquisaPage = PageFactory.initElements(driver, PesquisaPage.class);
		pegaMassa = new PegaMassa();
	}

	/* @ responsavel por executar a pilha de testes. */
	@Test
	public void consultaProdutoPorCategoriaEEfetuaCompra() throws Exception {
		test = ExtendReport.createTest("ConsultaPorCategoriaSucesso ");
		
		homePage.bt_UserIcon();

		ExcelUtils.setExcelFile(Constantes.Path_TestData + Constantes.File_TestData, "Cadastro");
		/*
		 * Atribui o valor recebido pela coluna e linha especificada no arquivo excel a
		 * uma variavel
		 */
		String txt_UserLogin = pegaMassa.UserName();
		String txt_PasswordLogin = pegaMassa.Password();
		homePage.preencheLogin(txt_UserLogin, txt_PasswordLogin);

		homePage.bt_Logar();

		homePage.clicaProdutoCategoria(driver);

		ExcelUtils.setExcelFile(Constantes.Path_TestData + Constantes.File_TestData, "PesquisaCat");
		
		String produto = pegaMassa.ClicaNoProduto();
		pesquisaPage.selecionaProdutoCat(driver, produto).click();

		/*
		 * Comandos responsaveis por receber os valores necessários para acionar o
		 * assert.
		 */
		String condicao = pegaMassa.CondicaoAssertMassaSucesso();
		String mensagem = pegaMassa.MenssagemAssertMassaSucesso();
		String desc = pesquisaPage.desc_Produto.getText();
		
		/* Comando responsavel por conferir se o teste agiu como o esperado. */
		Assert.assertTrue(desc.equals(condicao), mensagem);
	}

	/* @ responsaverl por executar todos os elementos depois do @Test. */
	@AfterMethod
	public void fim(ITestResult result) throws Exception {
		ExtendReport.tearDown(result, test, driver);
		DriverFactory.fechaBrowser();
	}
	
	@AfterTest
	public void finalizaExtendReport() {
		ExtendReport.endReport();
	}

}
