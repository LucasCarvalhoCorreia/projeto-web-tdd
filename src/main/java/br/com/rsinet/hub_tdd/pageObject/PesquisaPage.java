package br.com.rsinet.hub_tdd.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PesquisaPage {
	
	static WebDriver driver;

	@FindBy(how = How.LINK_TEXT, using = "HP Chromebook 14 G1(ES)")
	public static WebElement bt_Produto;
	
	@FindBy(how = How.NAME, using = "save_to_cart")
	public static WebElement bt_SalvaProduto;
	
	@FindBy(how = How.ID, using = "checkOutPopUp")
	public static WebElement bt_Comprar;
	
	@FindBy(how = How.NAME, using = "quantity")
	public static WebElement txt_Quantidade;
	
	@FindBy(how = How.ID, using = "24")
	public static WebElement id_Produto;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"product\"]/td[2]/a/label[1]")
	public static WebElement qtd_Produto;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Description\"]/h1")
	public static WebElement desc_Produto;
}
