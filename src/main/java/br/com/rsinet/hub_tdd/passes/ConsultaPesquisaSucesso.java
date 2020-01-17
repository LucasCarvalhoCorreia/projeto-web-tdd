package br.com.rsinet.hub_tdd.passes;

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
import br.com.rsinet.hub_tdd.util.Utilidades;

public class ConsultaPesquisaSucesso extends Utilidades {

	private WebDriver driver;
	private HomePage homePage;
	private PesquisaPage pesquisaPage;
	
	@BeforeMethod
	public void inicio() throws Exception {
		driver = iniciaBrowser();
		
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "PesquisaBarra");
		homePage = PageFactory.initElements(driver, HomePage.class);
		pesquisaPage = PageFactory.initElements(driver, PesquisaPage.class);
	}

	@Test
	public void consultaPesquisa() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		homePage.bt_Lupa();
		
		String txt_Pesquisa = (ExcelUtils.getCellData(1, Constant.txt_PesquisaBarra));
		homePage.pesquisar(txt_Pesquisa);
		
		Thread.sleep(1000);
		homePage.bt_FechaSugestao();
		
		pesquisaPage.id_Produto();

		String condicao = ExcelUtils.getCellData(1, Constant.condicao_AssertBarra);
		String mensagem = ExcelUtils.getCellData(1, Constant.msg_AssertBarra);
		String elemento = pesquisaPage.desc_Produto.getText();
		Assert.assertTrue(elemento.equals(condicao), mensagem);
	}

	@AfterMethod
	public void fim() throws Exception {
		tirarPrintsDeSucesso("ConsultaPesquisaSucesso ", driver);
		driver = fechaBrowser();
	}

}
