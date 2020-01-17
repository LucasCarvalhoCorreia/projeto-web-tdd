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

public class ConsultaMassaSucesso extends DriverFactory {

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
	public void consultaMassa() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		homePage.bt_UserIcon();
		
		String txt_UserLogin = ExcelUtils.getCellData(1, Constant.txt_UserNameCat);
		String txt_PasswordLogin = ExcelUtils.getCellData(1, Constant.txt_PasswordCat);
		homePage.preencheLogin(txt_UserLogin, txt_PasswordLogin);
		
		homePage.bt_Logar();
		
		homePage.clicaProdutoCategoria(driver);
		
		pesquisaPage.clica_Produto();
		
		pesquisaPage.bt_SalvaProduto();
		
		pesquisaPage.bt_Comprar();
		
		pagamentoPage.bt_Next();
		
		String txt_UserNamePay = ExcelUtils.getCellData(1, Constant.txt_UserNamePay);
		String txt_PasswordPay = ExcelUtils.getCellData(1, Constant.txt_PasswordPay);
		
		pagamentoPage.limpaUser();
		pagamentoPage.limpaPass();
		pagamentoPage.logaContaPay(txt_UserNamePay, txt_PasswordPay);
		
		pagamentoPage.check_SavePay();
		
		pagamentoPage.bt_Pay();

		String condicao = ExcelUtils.getCellData(1, Constant.condicao_AssertMassa);
		String mensagem = ExcelUtils.getCellData(1, Constant.msg_AssertMassa);
		String aviso = pagamentoPage.lbl_Pago.getText();
		System.out.println(aviso);
		System.out.println(condicao);
		Assert.assertTrue(aviso.equals(condicao), mensagem);
	}

	@AfterMethod
	public void fim() throws Exception {
		Prints.tirarPrintsDeSucesso("ConsultaMassaSucesso ", driver);
		DriverFactory.fechaBrowser(driver);
	}

}
