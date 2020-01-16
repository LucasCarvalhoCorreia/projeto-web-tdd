package br.com.rsinet.hub_tdd.passes;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.pageObject.HomePage;
import br.com.rsinet.hub_tdd.pageObject.PagamentoPage;
import br.com.rsinet.hub_tdd.pageObject.PesquisaPage;
import br.com.rsinet.hub_tdd.util.Constant;
import br.com.rsinet.hub_tdd.util.ExcelUtils;
import br.com.rsinet.hub_tdd.util.Utilidades;

public class ConsultaMassaSucesso extends Utilidades {

	private static WebDriver driver;
	
	@BeforeMethod
	public void inicio() {
		driver = iniciaBrowser();
	}

	@Test
	public void consultaMassa() throws Exception {
		HomePage.logaNaConta(driver);
		
		HomePage.produtoCategoria(driver);

		PesquisaPage.pesquisaCategoria(driver);
		
		PagamentoPage.efetuaPagamento(driver);

		String condicao = ExcelUtils.getCellData(1, Constant.condicao_AssertMassa);
		String mensagem = ExcelUtils.getCellData(1, Constant.msg_AssertMassa);
		String aviso = PagamentoPage.lbl_Pago.getText();
		Assert.assertTrue(aviso.equals(condicao), mensagem);
	}

	@AfterMethod
	public void fim() throws Exception {
		tirarPrintsDeSucesso("ConsultaMassaSucesso ", driver);
		driver = fechaBrowser();
	}

}
