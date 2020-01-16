package br.com.rsinet.hub_tdd.pageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_tdd.util.Constant;
import br.com.rsinet.hub_tdd.util.ExcelUtils;

public class PesquisaPage {

	static WebDriver driver;

	@FindBy(how = How.LINK_TEXT, using = "HP Chromebook 14 G1(ES)")
	private static WebElement clica_Produto;

	@FindBy(how = How.NAME, using = "save_to_cart")
	private static WebElement bt_SalvaProduto;

	@FindBy(how = How.ID, using = "checkOutPopUp")
	private static WebElement bt_Comprar;

	@FindBy(how = How.NAME, using = "quantity")
	private static WebElement txt_Quantidade;

	@FindBy(how = How.ID, using = "24")
	private static WebElement id_Produto;

	@FindBy(how = How.XPATH, using = "//*[@id=\"product\"]/td[2]/a/label[1]")
	public static WebElement qtd_Produto;

	@FindBy(how = How.XPATH, using = "//*[@id=\"Description\"]/h1")
	public static WebElement desc_Produto;

	public static void pesquisaCategoria(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, PesquisaPage.class);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		clica_Produto.click();

		bt_SalvaProduto.click();

		bt_Comprar.click();
	}

	public static void pesquisaCategoriaErrada(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, PesquisaPage.class);

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "PesquisaCat");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		clica_Produto.click();

		txt_Quantidade.sendKeys(ExcelUtils.getCellData(1, Constant.txt_QuantidadeCat));

		bt_SalvaProduto.click();

		bt_Comprar.click();
	}

	public static void pesquisaPorDescricao(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, PesquisaPage.class);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		id_Produto.click();
	}
}
