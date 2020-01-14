package br.com.rsinet.hub_tdd.passes;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_tdd.pageObject.Modulo;
import br.com.rsinet.hub_tdd.pageObject.PesquisaPage;
import br.com.rsinet.hub_tdd.util.Utilidades;

public class ConsultaMassaSucesso extends Utilidades {

	private static WebDriver driver;
	
	@Before
	public void inicio() {
		driver = iniciaBrowser();
	}

	@Test
	public void consultaMassa() throws Exception {
		Modulo.logaNaConta(driver);
		
		Modulo.produtoCategoria(driver);

		Modulo.pesquisaCategoria(driver);

		String aviso = PesquisaPage.qtd_Produto.getText();
		assertTrue("Compra efetuada com sucesso!", aviso.equals("QTY: 1"));
	}

	@After
	public void fim() throws Exception {
		tirarPrintsDeSucesso("ConsultaMassaSucesso ", driver);
		driver = fechaBrowser();
	}

}
