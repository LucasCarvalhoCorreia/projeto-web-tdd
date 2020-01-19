package br.com.rsinet.hub_tdd.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	public static WebDriver driver;

	public static WebDriver iniciaBrowser() {
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://advantageonlineshopping.com/#/");
		
		return driver;
	}

	public static void fechaBrowser(WebDriver driver) {
		 if (driver != null) {
	            driver.close();
	            driver.quit();
	            driver = null;
	}

	}
}
