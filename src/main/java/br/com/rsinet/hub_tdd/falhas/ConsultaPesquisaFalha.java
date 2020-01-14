package br.com.rsinet.hub_tdd.falhas;

import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_tdd.pageObject.Modulo;
import br.com.rsinet.hub_tdd.util.Utilidades;

public class ConsultaPesquisaFalha extends Utilidades {

	private static WebDriver driver;

	@Before
	public void inicio() throws InterruptedException {
		driver = iniciaBrowser();
	}

	@Test
	public void consultaPesquisa() throws Exception {
		Modulo.barraDePesquisaErrado(driver);
		
		String pesquisa = driver.findElement(By.xpath("//*[@id=\"searchPage\"]/div[3]/div/label/span")).getText();
		assertFalse("Nenhum resultado encontrado!", pesquisa.equals("No results for \"fones\""));
	}

	@After
	public void fim() throws Exception {
		tirarPrintsDeFalha("ConsultaPesquisaFalha ", driver);
		driver = fechaBrowser();
	}

}
