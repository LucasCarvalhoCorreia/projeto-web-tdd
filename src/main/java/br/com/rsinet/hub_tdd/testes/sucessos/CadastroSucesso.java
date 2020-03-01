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
import br.com.rsinet.hub_tdd.pageObject.CadastroPage;
import br.com.rsinet.hub_tdd.pageObject.HomePage;

public class CadastroSucesso extends DriverFactory {

	private ExtentTest test;
	private WebDriver driver;
	private HomePage homePage;
	private CadastroPage cadastroPage;
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

		/* Comando responsavel por ler o arquivo e aba do excel especificados. */
		ExcelUtils.setExcelFile(Constantes.Path_TestData + Constantes.File_TestData, "Cadastro");
		/*
		 * Comando responsavel por iniciar os elementos dentro da pageFactory
		 * especificada.
		 */
		homePage = PageFactory.initElements(driver, HomePage.class);
		cadastroPage = PageFactory.initElements(driver, CadastroPage.class);
		pegaMassa = new PegaMassa();
	}

	/* @ responsavel por executar a pilha de testes. */
	@Test
	public void cadastrarUsuarioNoBanco() throws Exception {
		test = ExtendReport.createTest("CadastroSucesso ");
		
		homePage.bt_UserIcon();

		homePage.bt_CriarNovaConta();

		/*
		 * Atribui o valor recebido pela coluna e linha especificada no arquivo excel a
		 * uma variavel
		 */
		
		cadastroPage.preencheUserName(pegaMassa.UserName());
		cadastroPage.preencheEmail(pegaMassa.Email());
		cadastroPage.preenchePassword(pegaMassa.Password());
		cadastroPage.preencheConfirmPassword(pegaMassa.ConfirmPassword());
		cadastroPage.preencheFirstName(pegaMassa.FirstName());
		cadastroPage.preencheLastName(pegaMassa.LastName());
		cadastroPage.preencheTelefone(pegaMassa.Telefone());
		cadastroPage.preenchePais(pegaMassa.Pais());
		cadastroPage.preencheCidade(pegaMassa.Cidade());
		cadastroPage.preencheEndereco(pegaMassa.Endereco());
		cadastroPage.preencheEstado(pegaMassa.Estado());
		cadastroPage.preencheCep(pegaMassa.Cep());

		cadastroPage.check_Offers();
		cadastroPage.check_Agree();
		cadastroPage.bt_Registrar();

		String condicao = pegaMassa.UserName();
		String mensagem = pegaMassa.MenssagemAssertCadastroSucesso();

		/*
		 * Comandos responsaveis por receber os valores necessários para acionar o
		 * assert.
		 */
		cadastroPage.pega_UserLogon(driver);
		String pass = cadastroPage.user_Logon.getText();
		/* Comando responsavel por conferir se o teste agiu como o esperado. */
		Assert.assertTrue(pass.equals(condicao), mensagem);
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
