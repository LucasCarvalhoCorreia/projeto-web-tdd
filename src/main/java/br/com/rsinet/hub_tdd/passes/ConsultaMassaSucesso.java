package br.com.rsinet.hub_tdd.passes;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.modulos.ModuloHome;
import br.com.rsinet.hub_tdd.modulos.ModuloPesquisa;
import br.com.rsinet.hub_tdd.pageObject.PesquisaPage;
import br.com.rsinet.hub_tdd.util.Utilidades;

public class ConsultaMassaSucesso extends Utilidades {

	private static WebDriver driver;
	
	@BeforeMethod
	public void inicio() {
		driver = iniciaBrowser();
	}

	@Test
	public void consultaMassa() throws Exception {
		ModuloHome.logaNaConta(driver);
		
		ModuloHome.produtoCategoria(driver);

		ModuloPesquisa.pesquisaCategoria(driver);

		String aviso = PesquisaPage.qtd_Produto.getText();
		Assert.assertTrue(aviso.equals("QTY: 1"), "Compra efetuada com sucesso!");
	}

	@AfterMethod
	public void fim() throws Exception {
		tirarPrintsDeSucesso("ConsultaMassaSucesso ", driver);
		driver = fechaBrowser();
	}

}
