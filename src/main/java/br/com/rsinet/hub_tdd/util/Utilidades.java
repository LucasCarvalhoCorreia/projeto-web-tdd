package br.com.rsinet.hub_tdd.util;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_tdd.pageObject.HomePage;

public class Utilidades extends HomePage{

	protected  WebDriver driver;

	protected WebDriver iniciaBrowser() {
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://advantageonlineshopping.com/#/");
		
		return driver;
	}

	protected WebDriver fechaBrowser() {
		driver.quit();
		
		return driver;
	}

	protected void logaNaConta() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("hrefUserIcon")).click();

		driver.findElement(By.name("username")).sendKeys("lucascarvalho");

		driver.findElement(By.name("password")).sendKeys("10203040Lcc");

		driver.findElement(By.id("sign_in_btnundefined")).sendKeys(Keys.ENTER);
	}

	protected void tirarPrintsDeSucesso(String nomeDaImagem) throws Exception {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String imageFileDir = "C:\\Users\\lucas.correia\\git\\projeto-tdd\\target\\sucessos";
		FileUtils.copyFile(srcFile, new File(imageFileDir, nomeDaImagem + ".png"));
	}

	protected void tirarPrintsDeFalha(String nomeDaImagem) throws Exception {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String imageFileDir = "C:\\Users\\lucas.correia\\git\\projeto-tdd\\target\\falhas";
		FileUtils.copyFile(srcFile, new File(imageFileDir, nomeDaImagem + ".png"));
	}

}
