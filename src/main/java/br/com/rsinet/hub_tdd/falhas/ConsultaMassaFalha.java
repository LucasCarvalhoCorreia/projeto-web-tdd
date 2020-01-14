package br.com.rsinet.hub_tdd.falhas;


import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.rsinet.hub_tdd.pageObject.Modulo;
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
		
		WebElement mensagem = driver.findElement(By.xpath("//*[@id=\"product\"]/td[2]/a/label[1]"));
		String aviso = mensagem.getText().toString();
		
		assertFalse("Quantidade errada.", aviso.equals("QTY: 10"));
	}

	@After
	public void fim() throws Exception {
		tirarPrintsDeFalha("ConsultaMassaFalha ", driver);
		driver = fechaBrowser();
	}

}
