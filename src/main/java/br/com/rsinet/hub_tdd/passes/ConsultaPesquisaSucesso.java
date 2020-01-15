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

public class ConsultaPesquisaSucesso extends Utilidades {

	private static WebDriver driver;
	
	@BeforeMethod
	public void inicio() throws InterruptedException {
		driver = iniciaBrowser();
	}

	@Test
	public void consultaPesquisa() throws Exception {
		ModuloHome.barraDePesquisa(driver);
		
		ModuloPesquisa.pesquisaPorDescricao(driver);
		
		String elemento = PesquisaPage.desc_Produto.getText();
		Assert.assertTrue(elemento.equals("HP ROAR MINI WIRELESS SPEAKER"), "Pesquisa efetuada com sucesso!");
	}

	@AfterMethod
	public void fim() throws Exception {
		tirarPrintsDeSucesso("ConsultaPesquisaSucesso ", driver);
		driver = fechaBrowser();
	}

}
