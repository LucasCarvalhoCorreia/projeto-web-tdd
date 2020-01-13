package br.com.rsinet.hub_tdd.pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Modulo {

	public static void criarNovaConta(WebDriver driver) {
		PageFactory.initElements(driver, HomePage.class);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		HomePage.userIcon.click();

		HomePage.criarNovaConta.sendKeys(Keys.ENTER);
	}
	
	

}
