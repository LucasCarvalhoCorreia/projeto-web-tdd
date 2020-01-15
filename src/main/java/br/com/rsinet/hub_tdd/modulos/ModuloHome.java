package br.com.rsinet.hub_tdd.modulos;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_tdd.pageObject.HomePage;
import br.com.rsinet.hub_tdd.util.Constant;
import br.com.rsinet.hub_tdd.util.ExcelUtils;

public class ModuloHome {
	
	public static void criarNovaConta(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, HomePage.class);

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Cadastro");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		HomePage.bt_UserIcon.click();

		HomePage.bt_CriarNovaConta.sendKeys(Keys.ENTER);
	}

	public static void logaNaConta(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, HomePage.class);

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "PesquisaCat");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		HomePage.bt_UserIcon.click();

		HomePage.txt_UserName.sendKeys(ExcelUtils.getCellData(1, Constant.txt_UserNameCat));

		HomePage.txt_Password.sendKeys(ExcelUtils.getCellData(1, Constant.txt_PasswordCat));

		HomePage.bt_Logar.sendKeys(Keys.ENTER);
	}

	public static void produtoCategoria(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, HomePage.class);

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement elemento = HomePage.bt_LaptopImg;
		executor.executeScript("arguments[0].click();", elemento);
	}

	public static void barraDePesquisa(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, HomePage.class);

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "PesquisaBarra");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		HomePage.bt_Lupa.click();

		HomePage.txt_Pesquisa.sendKeys(ExcelUtils.getCellData(1, Constant.txt_PesquisaBarra), Keys.ENTER);

		Thread.sleep(2000);
		HomePage.bt_FechaSugestao.click();
	}

	public static String barraDePesquisaErrado(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, HomePage.class);

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "PesquisaBarra");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		HomePage.bt_Lupa.click();

		HomePage.txt_Pesquisa.sendKeys(ExcelUtils.getCellData(1, Constant.txt_PesquisaBarraErro), Keys.ENTER);
		
		Thread.sleep(1000);
		HomePage.bt_FechaSugestao.click();
		
		return HomePage.result_Produto.getText();
	}

}
