package br.com.rsinet.hub_tdd.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utilidades {

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

	public static void tirarPrintsDeSucesso(String nomeDaImagem, WebDriver driver) throws Exception {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String imageFileDir = "C:\\Users\\Lucas\\git\\projeto-tdd\\target\\sucessos";
//		String imageFileDir = "C:\\Users\\lucas.correia\\git\\projeto-tdd\\target\\sucessos";
		FileUtils.copyFile(srcFile, new File(imageFileDir, nomeDaImagem +timestamp()+".png"));
	}

	public static void tirarPrintsDeFalha(String nomeDaImagem, WebDriver driver) throws Exception {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String imageFileDir = "C:\\\\Users\\\\Lucas\\\\git\\\\projeto-tdd\\\\target\\\\falhas";
//		String imageFileDir = "C:\\Users\\lucas.correia\\git\\projeto-tdd\\target\\falhas";
		FileUtils.copyFile(srcFile, new File(imageFileDir, nomeDaImagem +timestamp()+".png"));
	}
	
	public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
}

}
