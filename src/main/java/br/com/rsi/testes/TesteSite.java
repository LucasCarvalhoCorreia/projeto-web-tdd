package br.com.rsi.testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TesteSite {

	private WebDriver driver;

	@Before
	public void inicializa() {
		driver = new ChromeDriver();

		driver.manage().window().maximize();

	}

	@Test
	public void login() {

		driver.get("http://advantageonlineshopping.com/#/");

		WebDriverWait waitbt = new WebDriverWait(driver, 10);
		WebElement bt = waitbt.until(ExpectedConditions.elementToBeClickable(By.id("hrefUserIcon")));
		bt.click();

//		WebDriverWait waitSenha = new WebDriverWait(driver, 10);
//		WebElement cxSenha = waitSenha.until(ExpectedConditions.elementToBeClickable(By.name("password")));
//		cxSenha.sendKeys("539874601Lcc");

	}

	@After
	public void finaliza() {
//		driver.quit(); 
	}

}
