package br.com.rsinet.hub_tdd.falhas;


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

public class ConsultaMassaFalha extends Utilidades {

	private static WebDriver driver;
	
	@BeforeMethod
	public void inicio() throws InterruptedException {
		driver = iniciaBrowser();
	}

	@Test
	public void consultaMassa() throws Exception {
		HomePage.logaNaConta(driver);
		
		HomePage.produtoCategoria(driver);

		PesquisaPage.pesquisaCategoriaErrada(driver);
		
		String condicao = ExcelUtils.getCellData(1, Constant.condicao_AssertMassaErro);
		String mensagem = ExcelUtils.getCellData(1, Constant.msg_AssertMassaErro);
		String aviso = PesquisaPage.qtd_Produto.getText();
		Assert.assertFalse(aviso.equals(condicao), mensagem);
	}

	@AfterMethod
	public void fim() throws Exception {
		tirarPrintsDeFalha("ConsultaMassaFalha ", driver);
		driver = fechaBrowser();
	}

}
