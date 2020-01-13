package br.com.rsinet.hub_tdd.falhas;

import static org.junit.Assert.assertFalse;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import br.com.rsinet.hub_tdd.util.Utilidades;

public class ConsultaPesquisaFalha extends Utilidades {

	@Before
	public void inicio() throws InterruptedException {
		iniciaBrowser();
	}

	@Test
	public void consultaPesquisa() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("menuSearch")).click();

		driver.findElement(By.id("autoComplete")).sendKeys("fones" + Keys.ENTER);

		String pesquisa = driver.findElement(By.xpath("//*[@id=\"searchPage\"]/div[3]/div/label/span")).getText();
		
		assertFalse("Nenhum resultado encontrado!", pesquisa.equals("No results for \"fones\""));
	}

	@After
	public void fim() throws Exception {
		tirarPrintsDeFalha("ConsultaPesquisa");
		fechaBrowser();
	}

}
