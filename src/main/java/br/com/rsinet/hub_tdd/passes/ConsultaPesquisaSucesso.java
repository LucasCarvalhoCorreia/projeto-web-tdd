package br.com.rsinet.hub_tdd.passes;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import br.com.rsinet.hub_tdd.util.Utilidades;

public class ConsultaPesquisaSucesso extends Utilidades {

	@Before
	public void inicio() throws InterruptedException {
		iniciaBrowser();
	}

	@Test
	public void consultaPesquisa() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("menuSearch")).click();

		driver.findElement(By.id("autoComplete")).sendKeys("HP" + Keys.ENTER);
		
		driver.findElement(By.id("24")).click();
		
		driver.findElement(By.id("bunny")).click();
		
		String elemento = driver.findElement(By.xpath("//*[@id=\"Description\"]/h1")).getText();
		
		assertTrue("Pesquisa efetuada com sucesso!", elemento.equals("HP ROAR MINI WIRELESS SPEAKER"));
	}

	@After
	public void fim() throws Exception {
		tirarPrintsDeSucesso("ConsultaPesquisa");
//		fechaBrowser();
	}

}
