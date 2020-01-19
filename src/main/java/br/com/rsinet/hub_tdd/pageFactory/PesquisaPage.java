package br.com.rsinet.hub_tdd.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PesquisaPage {

	public WebDriver driver;

	@FindBy(how = How.NAME, using = "save_to_cart")
	private WebElement bt_SalvaProduto;

	@FindBy(how = How.ID, using = "checkOutPopUp")
	private WebElement bt_Comprar;

	@FindBy(how = How.NAME, using = "quantity")
	private WebElement txt_Quantidade;

	@FindBy(how = How.XPATH, using = "//*[@id=\"product\"]/td[2]/a/label[1]")
	public WebElement qtd_Produto;

	@FindBy(how = How.XPATH, using = "//*[@id=\"Description\"]/h1")
	public WebElement desc_Produto;

	public WebElement pesquisaProdutoCategoria(WebDriver driver, String produto) {
		WebElement element = driver.findElement(By.linkText(produto));
		return element;
	}
	
	public WebElement pesquisaProdutoBarra(WebDriver driver, String produto) {
		WebElement element = driver.findElement(By.linkText(produto));
		return element;
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
}
