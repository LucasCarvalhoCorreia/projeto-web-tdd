package br.com.rsinet.hub_tdd.manager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	public static WebDriver driver;

	
	
	/* Método onde inicia o browzer especificado. */
	/* Maximiza a janela. */
	/* E entra no site especificado. */
	/* Aplica um tempo de espera para cada linha de código na sequencia. */
	
	public static WebDriver getDriver() throws Exception {
		return (driver == null) ? iniciaBrowser() : driver; 
	}

	public static WebDriver iniciaBrowser() throws Exception {
				driver = new ChromeDriver();
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				driver.manage().window().maximize();
				driver.get("http://advantageonlineshopping.com/#/");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	/* Método responsavel por fechar o browser. */
	public static void fechaBrowser() {
		if (driver != null) {
			driver.close();
			driver.quit();
			driver = null;
		}

	}
}
