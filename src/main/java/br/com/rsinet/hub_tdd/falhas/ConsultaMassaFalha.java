package br.com.rsinet.hub_tdd.falhas;


import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_tdd.pageObject.Modulo;
import br.com.rsinet.hub_tdd.pageObject.PesquisaPage;
import br.com.rsinet.hub_tdd.util.Utilidades;

public class ConsultaMassaFalha extends Utilidades {

	private static WebDriver driver;
	
	@Before
	public void inicio() throws InterruptedException {
		driver = iniciaBrowser();
	}

	@Test
	public void consultaMassa() throws Exception {
		Modulo.logaNaConta(driver);
		
		Modulo.produtoCategoria(driver);

		Modulo.pesquisaCategoriaErrada(driver);
		
		String aviso = PesquisaPage.qtd_Produto.getText();
		assertFalse("Quantidade errada.", aviso.equals("QTY: 10"));
	}

	@After
	public void fim() throws Exception {
		tirarPrintsDeFalha("ConsultaMassaFalha ", driver);
		driver = fechaBrowser();
	}

}
