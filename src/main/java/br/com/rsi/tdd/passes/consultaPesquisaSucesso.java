package br.com.rsi.tdd.passes;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.com.rsi.util.Utilidades;

public class consultaPesquisaSucesso extends Utilidades{
	
	@Before
	public void inicio() throws InterruptedException {
		iniciaBrowser();
	}
	
	@Test
	public void consultaPesquisa() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("menuSearch")).click();
		
		driver.findElement(By.id("autoComplete")).sendKeys("HP");
		
		Thread.sleep(2000);
		driver.findElement(By.id("menuSearch")).click();
		
		driver.findElement(By.xpath("//*[@id=\"search\"]/div/div/img")).click();
		
		driver.findElement(By.linkText("HP Roar Mini Wireless Speaker")).click();
	}
	
	@After
	public void fim() {
		fechaBrowser();
	}

}
