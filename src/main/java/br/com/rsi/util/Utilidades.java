package br.com.rsi.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilidades {
	
	protected WebDriver driver;
	
	protected void iniciaBrowser() throws InterruptedException {
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.get("http://advantageonlineshopping.com/#/");
		
		Thread.sleep(5000);
	}
	
	protected void fechaBrowser() {
		driver.quit();
	}
	
	protected void criarNovaConta() {
		driver.findElement(By.id("hrefUserIcon")).click();
		
		WebDriverWait waitFrame = new WebDriverWait(driver, 10);
		WebElement criaConta = waitFrame.until(ExpectedConditions.elementToBeClickable(By.linkText("CREATE NEW ACCOUNT")));
		criaConta.click();
	}
	
	protected void logaNaConta() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("hrefUserIcon")).click();
		
		driver.findElement(By.name("username")).sendKeys("lucascarvalhoo");
		
		driver.findElement(By.name("password")).sendKeys("10203040Lcc");
		
		driver.findElement(By.id("sign_in_btnundefined")).click();
		
		Thread.sleep(1000);
	}

}
