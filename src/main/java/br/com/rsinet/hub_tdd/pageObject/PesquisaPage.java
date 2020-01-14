package br.com.rsinet.hub_tdd.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PesquisaPage {
	
	static WebDriver driver;

	@FindBy(how = How.LINK_TEXT, using = "HP Chromebook 14 G1(ES)")
	public static WebElement btProduto;
	
	@FindBy(how = How.NAME, using = "save_to_cart")
	public static WebElement salvaProduto;
	
	@FindBy(how = How.ID, using = "checkOutPopUp")
	public static WebElement comprar;
	
	@FindBy(how = How.NAME, using = "quantity")
	public static WebElement quantidade;
	
	@FindBy(how = How.ID, using = "24")
	public static WebElement idProduto;
}
