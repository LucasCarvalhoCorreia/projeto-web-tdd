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
import br.com.rsinet.hub_tdd.util.DriverFactory;
import br.com.rsinet.hub_tdd.util.ExcelUtils;
import br.com.rsinet.hub_tdd.util.Prints;

public class ConsultaPorBarraDePesquisaSucesso extends DriverFactory {

	private WebDriver driver;
	private HomePage homePage;
	private PesquisaPage pesquisaPage;

	@BeforeMethod
	public void inicio() throws Exception {
		driver = DriverFactory.iniciaBrowser();

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "PesquisaBarra");
		homePage = PageFactory.initElements(driver, HomePage.class);
		pesquisaPage = PageFactory.initElements(driver, PesquisaPage.class);
	}

	@Test
	public void consultaProdutoPorBarraDePesquisa() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		homePage.bt_Lupa();

		String txt_Pesquisa = (ExcelUtils.getCellData(1, Constant.pesquisaBarra));
		homePage.pesquisar(txt_Pesquisa);

		homePage.bt_FechaSugestao(driver);

		String produto = ExcelUtils.getCellData(2, Constant.escolheProduto);
		pesquisaPage.pesquisaProdutoBarra(driver, produto).click();

		String condicao = ExcelUtils.getCellData(1, Constant.condicaoAssertBarra);
		String mensagem = ExcelUtils.getCellData(2, Constant.mensagemAssertBarra);
		String elemento = pesquisaPage.desc_Produto.getText();
		Assert.assertTrue(elemento.equals(condicao), mensagem);
	}

	@AfterMethod
	public void fim() throws Exception {
		Prints.tirarPrintsDeSucesso("ConsultaPorBarraDePesquisaSucesso ", driver);
		DriverFactory.fechaBrowser(driver);
	}

}
