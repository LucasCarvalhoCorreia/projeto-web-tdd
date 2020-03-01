package br.com.rsinet.hub_tdd.testes.falhas;

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

public class ConsultaPorBarraDePesquisaErrado extends DriverFactory {

	private ExtentTest test;
	private WebDriver driver;
	private HomePage homePage;
	private PegaMassa pegaMassa;

	/* Área responsavel pelos testes de falha. */

	/* @ responsavel por executar todos os elementos antes do @Test. */
	@BeforeTest
	public void iniciaExtendReport() {
		ExtendReport.setExtent();
	}
	
	@BeforeMethod
	public void inicio() throws Exception {
		driver = DriverFactory.iniciaBrowser();

		/* Comando responsavel por ler o arquivo e aba do excel especificados. */
		ExcelUtils.setExcelFile(Constantes.Path_TestData + Constantes.File_TestData, "PesquisaBarra");
		/*
		 * Comando responsavel por iniciar os elementos dentro da pageFactory
		 * especificada.
		 */
		homePage = PageFactory.initElements(driver, HomePage.class);
		pegaMassa = new PegaMassa();
	}

	/* @ responsavel por executar a pilha de testes. */
	@Test
	public void consultaPorBarraDePesquisaComProdutoInexistenteNoBanco() throws Exception {
		test = ExtendReport.createTest("ConsultaPorBarraDePesquisaErrado ");
		
		homePage.bt_Lupa();

		/*
		 * Atribui o valor recebido pela coluna e linha especificada no arquivo excel a
		 * uma variavel
		 */
		String txt_Pesquisa = pegaMassa.PesquisaNaBarraErro();
		homePage.pesquisar(txt_Pesquisa);

		/*
		 * Comandos responsaveis por receber os valores necessários para acionar o
		 * assert.
		 */
		String elemento = pegaMassa.PesquisaNaBarraErro();
		String resposta = homePage.result_Produto.getText();
		/* Comando responsavel por conferir se o teste agiu como o esperado. */
		Assert.assertTrue(resposta.equals("No results for " + "\"" + elemento + "\""),
				"Nenhum resultado encontrado para " + elemento + "!");
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
