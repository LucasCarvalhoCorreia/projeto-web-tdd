package br.com.rsinet.hub_tdd.passes;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_tdd.pageObject.Modulo;
import br.com.rsinet.hub_tdd.util.Utilidades;

public class ConsultaMassaSucesso extends Utilidades {

	private static WebDriver driver;
	
	@Before
	public void inicio() {
		driver = iniciaBrowser();
	}

	@Test
	public void consultaMassa() {
		Modulo.logaNaConta(driver);
		
		Modulo.produtoCategoria(driver);

		Modulo.pesquisaCategoria(driver);

		String msgPagamento = driver.findElement(By.xpath("//*[@id=\"product\"]/td[2]/a/label[1]")).getText();
		assertTrue("Compra efetuada com sucesso!", msgPagamento.equals("QTY: 1"));
	}

	@After
	public void fim() throws Exception {
		tirarPrintsDeSucesso("ConsultaMassa");
		driver = fechaBrowser();
	}

}
