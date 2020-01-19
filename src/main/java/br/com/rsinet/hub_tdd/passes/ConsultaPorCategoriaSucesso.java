package br.com.rsinet.hub_tdd.passes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.pageFactory.HomePage;
import br.com.rsinet.hub_tdd.pageFactory.PagamentoPage;
import br.com.rsinet.hub_tdd.pageFactory.PesquisaPage;
import br.com.rsinet.hub_tdd.util.Constant;
import br.com.rsinet.hub_tdd.util.ExcelUtils;
import br.com.rsinet.hub_tdd.util.Prints;
import br.com.rsinet.hub_tdd.util.DriverFactory;

public class ConsultaPorCategoriaSucesso extends DriverFactory {

	private WebDriver driver;
	private HomePage homePage;
	private PesquisaPage pesquisaPage;
	private PagamentoPage pagamentoPage;

	@BeforeMethod
	public void inicio() throws Exception {
		driver = DriverFactory.iniciaBrowser();

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Pagamento");
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "PesquisaCat");
		homePage = PageFactory.initElements(driver, HomePage.class);
		pesquisaPage = PageFactory.initElements(driver, PesquisaPage.class);
		pagamentoPage = PageFactory.initElements(driver, PagamentoPage.class);
	}

	@Test
	public void consultaProdutoPorCategoriaEEfetuaCompra() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		homePage.bt_UserIcon();

		String txt_UserLogin = ExcelUtils.getCellData(1, Constant.userNameCat);
		String txt_PasswordLogin = ExcelUtils.getCellData(2, Constant.passwordCat);
		homePage.preencheLogin(txt_UserLogin, txt_PasswordLogin);

		homePage.bt_Logar();

		homePage.clicaProdutoCategoria(driver);

		String produto = ExcelUtils.getCellData(5, Constant.clicaProduto);
		pesquisaPage.pesquisaProdutoCategoria(driver, produto).click();

		pesquisaPage.bt_SalvaProduto();

		pesquisaPage.bt_Comprar();

		pagamentoPage.bt_Next();

		String txt_UserNamePay = ExcelUtils.getCellData(1, Constant.userNamePay);
		String txt_PasswordPay = ExcelUtils.getCellData(2, Constant.passwordPay);

		pagamentoPage.limpaUser();
		pagamentoPage.limpaPass();
		pagamentoPage.logaContaPay(txt_UserNamePay, txt_PasswordPay);

		pagamentoPage.check_SavePay();

		pagamentoPage.bt_Pay();

		String condicao = ExcelUtils.getCellData(2, Constant.condicaoAssertMassaSucesso);
		String mensagem = ExcelUtils.getCellData(1, Constant.mensagemAssertMassaSucesso);
		pagamentoPage.pega_Pago(driver);
		String aviso = pagamentoPage.lbl_Pago.getText();
		Assert.assertTrue(aviso.equals(condicao), mensagem);
	}

	@AfterMethod
	public void fim() throws Exception {
		Prints.tirarPrintsDeSucesso("ConsultaPorCategoriaSucesso ", driver);
		DriverFactory.fechaBrowser(driver);
	}

}
