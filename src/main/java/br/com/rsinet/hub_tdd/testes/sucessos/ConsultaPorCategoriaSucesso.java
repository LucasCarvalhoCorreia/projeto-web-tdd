package br.com.rsinet.hub_tdd.testes.sucessos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.pageFactory.HomePage;
import br.com.rsinet.hub_tdd.pageFactory.PagamentoPage;
import br.com.rsinet.hub_tdd.pageFactory.PesquisaPage;
import br.com.rsinet.hub_tdd.utils.Constant;
import br.com.rsinet.hub_tdd.utils.DriverFactory;
import br.com.rsinet.hub_tdd.utils.ExcelUtils;
import br.com.rsinet.hub_tdd.utils.Prints;

public class ConsultaPorCategoriaSucesso extends DriverFactory {

	private WebDriver driver;
	private HomePage homePage;
	private PesquisaPage pesquisaPage;
	private PagamentoPage pagamentoPage;

	/* Área responsavel pelos testes de sucesso. */

	/* @ responsavel por executar todos os elementos antes do @Test. */
	@BeforeMethod
	public void inicio() throws Exception {
		driver = DriverFactory.iniciaBrowser(DriverType.Chrome, Constant.URL);

		/* Comando responsavel por ler o arquivo e aba do excel especificados. */
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Pagamento");
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "PesquisaCat");
		/*
		 * Comando responsavel por iniciar os elementos dentro da pageFactory
		 * especificada.
		 */
		homePage = PageFactory.initElements(driver, HomePage.class);
		pesquisaPage = PageFactory.initElements(driver, PesquisaPage.class);
		pagamentoPage = PageFactory.initElements(driver, PagamentoPage.class);
	}

	/* @ responsavel por executar a pilha de testes. */
	@Test
	public void consultaProdutoPorCategoriaEEfetuaCompra() throws Exception {
		homePage.bt_UserIcon();

		/*
		 * Atribui o valor recebido pela coluna e linha especificada no arquivo excel a
		 * uma variavel
		 */
		String txt_UserLogin = ExcelUtils.getCellData(1, Constant.userNameCat);
		String txt_PasswordLogin = ExcelUtils.getCellData(2, Constant.passwordCat);
		homePage.preencheLogin(txt_UserLogin, txt_PasswordLogin);

		homePage.bt_Logar();

		homePage.clicaProdutoCategoria(driver);

		String produto = ExcelUtils.getCellData(5, Constant.clicaProduto);
		pesquisaPage.selecionaProduto(driver, produto).click();

		pesquisaPage.bt_SalvaProduto();

		pesquisaPage.bt_Comprar();

		pagamentoPage.bt_Next();

		String txt_UserNamePay = ExcelUtils.getCellData(1, Constant.userNamePay);
		String txt_PasswordPay = ExcelUtils.getCellData(2, Constant.passwordPay);
		pagamentoPage.logaContaPay(txt_UserNamePay, txt_PasswordPay);

		pagamentoPage.check_SavePay();

		pagamentoPage.bt_Pay();

		/*
		 * Comandos responsaveis por receber os valores necessários para acionar o
		 * assert.
		 */
		String condicao = ExcelUtils.getCellData(2, Constant.condicaoAssertMassaSucesso);
		String mensagem = ExcelUtils.getCellData(1, Constant.mensagemAssertMassaSucesso);
		pagamentoPage.pega_Pago(driver);
		String aviso = pagamentoPage.lbl_Pago.getText();
		/* Comando responsavel por conferir se o teste agiu como o esperado. */
		Assert.assertTrue(aviso.equals(condicao), mensagem);
	}

	/* @ responsaverl por executar todos os elementos depois do @Test. */
	@AfterMethod
	public void fim() throws Exception {
		Prints.tirarPrintsDeSucesso("ConsultaPorCategoriaSucesso ", driver);
		DriverFactory.fechaBrowser(driver);
	}

}
