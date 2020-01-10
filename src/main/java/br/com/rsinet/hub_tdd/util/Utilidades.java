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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilidades {

	protected WebDriver driver;

	protected void iniciaBrowser() throws InterruptedException {
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://advantageonlineshopping.com/#/");
	}

	protected void fechaBrowser() {
		driver.quit();
	}

	protected void criarNovaConta() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("hrefUserIcon")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]")));
		driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]")).sendKeys(Keys.ENTER);
	}

	protected void logaNaConta() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("hrefUserIcon")).click();

		driver.findElement(By.name("username")).sendKeys("lucascarvalhoo");

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
