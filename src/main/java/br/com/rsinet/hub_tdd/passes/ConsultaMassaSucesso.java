package br.com.rsinet.hub_tdd.passes;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import br.com.rsinet.hub_tdd.util.Utilidades;

public class ConsultaMassaSucesso extends Utilidades {

	@Before
	public void inicio() {
		iniciaBrowser();
	}

	@Test
	public void consultaMassa() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		logaNaConta();
		
		WebElement elemento = driver.findElement(By.id("laptopsImg"));
		
		executor.executeScript("arguments[0].click();", elemento);

		driver.findElement(By.linkText("HP Chromebook 14 G1(ES)")).click();

		driver.findElement(By.name("save_to_cart")).click();
		
		driver.findElement(By.id("checkOutPopUp")).click();

		String msgPagamento = driver.findElement(By.xpath("//*[@id=\"product\"]/td[2]/a/label[1]")).getText();
		
		assertTrue("Compra efetuada com sucesso!", msgPagamento.equals("QTY: 1"));
	}

	@After
	public void fim() throws Exception {
		tirarPrintsDeSucesso("ConsultaMassa");
		fechaBrowser();
	}

}
