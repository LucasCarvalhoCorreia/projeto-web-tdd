package br.com.rsinet.hub_tdd.falhas;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.modulos.ModuloHome;
import br.com.rsinet.hub_tdd.modulos.ModuloPesquisa;
import br.com.rsinet.hub_tdd.pageObject.PesquisaPage;
import br.com.rsinet.hub_tdd.util.Utilidades;

public class ConsultaMassaFalha extends Utilidades {

	private static WebDriver driver;
	
	@BeforeMethod
	public void inicio() throws InterruptedException {
		driver = iniciaBrowser();
	}

	@Test
	public void consultaMassa() throws Exception {
		ModuloHome.logaNaConta(driver);
		
		ModuloHome.produtoCategoria(driver);

		ModuloPesquisa.pesquisaCategoriaErrada(driver);
		
		String aviso = PesquisaPage.qtd_Produto.getText();
		Assert.assertFalse(aviso.equals("QTY: 10"), "Quantidade errada.");
	}

	@AfterMethod
	public void fim() throws Exception {
		tirarPrintsDeFalha("ConsultaMassaFalha ", driver);
		driver = fechaBrowser();
	}

}
