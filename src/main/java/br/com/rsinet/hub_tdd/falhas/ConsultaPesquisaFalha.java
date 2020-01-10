package br.com.rsinet.hub_tdd.falhas;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

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

		driver.findElement(By.id("autoComplete")).sendKeys("HP");

		Thread.sleep(2000);
		driver.findElement(By.id("menuSearch")).click();

		driver.findElement(By.xpath("//*[@id=\"search\"]/div/div/img")).click();

		driver.findElement(By.id("24")).click();
		
		tirarPrintsDeSucesso("ConsultaPesquisa");
	}

	@After
	public void fim() {
		fechaBrowser();
	}

}
