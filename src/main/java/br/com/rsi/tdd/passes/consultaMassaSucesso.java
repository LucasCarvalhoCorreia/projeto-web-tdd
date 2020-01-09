package br.com.rsi.tdd.passes;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.rsi.util.Utilidades;

public class consultaMassaSucesso extends Utilidades{
	
	@Before
	public void inicio() throws InterruptedException {
		iniciaBrowser();
	}
	
	@Test
	public void consultaMassa() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		logaNaConta();
		
		driver.findElement(By.id("laptopsImg")).click();
		
		driver.findElement(By.linkText("HP Chromebook 14 G1(ES)")).click();
		
		driver.findElement(By.name("save_to_cart")).click();
		
		driver.findElement(By.id("menuCart")).click();
		
		driver.findElement(By.id("checkOutButton")).click();
		
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
	public void fim() {
		fechaBrowser();
	}

}
