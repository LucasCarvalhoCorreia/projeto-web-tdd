package br.com.rsinet.hub_tdd.passes;

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

		driver.findElement(By.id("next_btn")).click();

		WebElement User = driver.findElement(By.name("safepay_username"));
		User.clear();
		User.sendKeys("lucascarvalhoo");

		WebElement Pass = driver.findElement(By.name("safepay_password"));
		Pass.clear();
		Pass.sendKeys("10203040Lcc");

		driver.findElement(By.name("save_safepay")).click();

		driver.findElement(By.id("pay_now_btn_SAFEPAY")).click();
	}

	@After
	public void fim() throws Exception {
		tirarPrintsDeSucesso("ConsultaMassa");
		fechaBrowser();
	}

}
