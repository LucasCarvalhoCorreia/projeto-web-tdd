package br.com.rsinet.hub_tdd.passes;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_tdd.pageObject.Modulo;
import br.com.rsinet.hub_tdd.pageObject.PesquisaPage;
import br.com.rsinet.hub_tdd.util.Utilidades;

public class ConsultaPesquisaSucesso extends Utilidades {

	private static WebDriver driver;
	
	@Before
	public void inicio() throws InterruptedException {
		driver = iniciaBrowser();
	}

	@Test
	public void consultaPesquisa() throws Exception {
		Modulo.barraDePesquisa(driver);
		
		Modulo.pesquisaPorDescricao(driver);
		
		String elemento = PesquisaPage.desc_Produto.getText();
		assertTrue("Pesquisa efetuada com sucesso!", elemento.equals("HP ROAR MINI WIRELESS SPEAKER"));
	}

	@After
	public void fim() throws Exception {
		tirarPrintsDeSucesso("ConsultaPesquisaSucesso ", driver);
		driver = fechaBrowser();
	}

}
