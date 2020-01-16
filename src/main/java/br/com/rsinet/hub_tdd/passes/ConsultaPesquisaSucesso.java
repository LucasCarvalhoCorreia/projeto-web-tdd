package br.com.rsinet.hub_tdd.passes;

import org.openqa.selenium.WebDriver;
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

	private static WebDriver driver;
	
	@BeforeMethod
	public void inicio() throws InterruptedException {
		driver = iniciaBrowser();
	}

	@Test
	public void consultaPesquisa() throws Exception {
		HomePage.barraDePesquisa(driver);
		
		PesquisaPage.pesquisaPorDescricao(driver);
		
		String condicao = ExcelUtils.getCellData(1, Constant.condicao_AssertBarra);
		String mensagem = ExcelUtils.getCellData(1, Constant.msg_AssertBarra);
		String elemento = PesquisaPage.desc_Produto.getText();
		Assert.assertTrue(elemento.equals(condicao), mensagem);
	}

	@AfterMethod
	public void fim() throws Exception {
		tirarPrintsDeSucesso("ConsultaPesquisaSucesso ", driver);
		driver = fechaBrowser();
	}

}
