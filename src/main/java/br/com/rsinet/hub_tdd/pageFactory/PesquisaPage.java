package br.com.rsinet.hub_tdd.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PesquisaPage {

	WebDriver driver;

	@FindBy(how = How.LINK_TEXT, using = "HP Chromebook 14 G1(ES)")
	private WebElement clica_Produto;

	@FindBy(how = How.NAME, using = "save_to_cart")
	private WebElement bt_SalvaProduto;

	@FindBy(how = How.ID, using = "checkOutPopUp")
	private WebElement bt_Comprar;

	@FindBy(how = How.NAME, using = "quantity")
	private WebElement txt_Quantidade;

	@FindBy(how = How.ID, using = "8")
	private WebElement id_Produto;

	@FindBy(how = How.XPATH, using = "//*[@id=\"product\"]/td[2]/a/label[1]")
	public WebElement qtd_Produto;

	@FindBy(how = How.XPATH, using = "//*[@id=\"Description\"]/h1")
	public WebElement desc_Produto;

	
	public void clica_Produto() {
		this.clica_Produto.click();
	}
	
	public void bt_SalvaProduto() {
		this.bt_SalvaProduto.click();
	}
	
	public void bt_Comprar() {
		this.bt_Comprar.click();
	}
	
	public void quantidadeProduto(String txt_Quantidade) {
		this.txt_Quantidade.sendKeys(txt_Quantidade);
	}
	
	public void id_Produto() {
		this.id_Produto.click();
	}
}
