package br.com.rsinet.hub_tdd.falhas;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.pageFactory.HomePage;
import br.com.rsinet.hub_tdd.pageFactory.PesquisaPage;
import br.com.rsinet.hub_tdd.util.Constant;
import br.com.rsinet.hub_tdd.util.ExcelUtils;
import br.com.rsinet.hub_tdd.util.Prints;
import br.com.rsinet.hub_tdd.util.DriverFactory;

public class ConsultaPorCategoriaErrado extends DriverFactory {

	private WebDriver driver;
	private HomePage homePage;
	private PesquisaPage pesquisaPage;
	
	@BeforeMethod
	public void inicio() throws Exception {
		driver = DriverFactory.iniciaBrowser();
		
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "PesquisaCat");
		homePage = PageFactory.initElements(driver, HomePage.class);
		pesquisaPage = PageFactory.initElements(driver, PesquisaPage.class);
	}

	@Test
	public void consultaPorCategoriaComQuantidadeAcimaDoPermitidoNoCarrinho() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		homePage.bt_UserIcon();
		
		String txt_UserLogin = ExcelUtils.getCellData(1, Constant.txt_UserNameCat);
		String txt_PasswordLogin = ExcelUtils.getCellData(1, Constant.txt_PasswordCat);
		homePage.preencheLogin(txt_UserLogin, txt_PasswordLogin);
		
		homePage.bt_Logar();
		
		homePage.clicaProdutoCategoria(driver);
		
		pesquisaPage.clica_Produto();
		
		String txt_Quantidade = ExcelUtils.getCellData(1, Constant.txt_QuantidadeCat);
		pesquisaPage.quantidadeProduto(txt_Quantidade);
		
		pesquisaPage.bt_SalvaProduto();
		
		pesquisaPage.bt_Comprar();
		
		String condicao = ExcelUtils.getCellData(1, Constant.condicao_AssertMassaErro);
		String mensagem = ExcelUtils.getCellData(1, Constant.msg_AssertMassaErro);
		String aviso = pesquisaPage.qtd_Produto.getText();
		System.out.println(aviso);
		Assert.assertTrue(aviso.equals(condicao), mensagem);
	}

	@AfterMethod
	public void fim() throws Exception {
		Prints.tirarPrintsDeFalha("ConsultaPorCategoriaErrado ", driver);
		DriverFactory.fechaBrowser(driver);
	}

}
