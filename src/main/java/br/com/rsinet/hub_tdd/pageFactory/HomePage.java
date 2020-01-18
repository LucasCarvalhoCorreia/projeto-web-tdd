package br.com.rsinet.hub_tdd.pageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	@FindBy(how = How.ID, using = "hrefUserIcon")
	private WebElement bt_UserIcon;

	@FindBy(how = How.XPATH, using = "/html/body/login-modal/div/div/div[3]/a[2]")
	private WebElement bt_CriarNovaConta;

	@FindBy(how = How.NAME, using = "username")
	private WebElement txt_UserName;

	@FindBy(how = How.NAME, using = "password")
	private WebElement txt_Password;

	@FindBy(how = How.ID, using = "sign_in_btnundefined")
	private WebElement bt_Logar;

	@FindBy(how = How.ID, using = "laptopsImg")
	private WebElement bt_LaptopImg;

	@FindBy(how = How.ID, using = "menuSearch")
	private WebElement bt_Lupa;

	@FindBy(how = How.ID, using = "autoComplete")
	private WebElement txt_Pesquisa;

	@FindBy(how = How.XPATH, using = "//*[@id=\"search\"]/div/div/img")
	private WebElement bt_FechaSugestao;

	@FindBy(how = How.XPATH, using = "//*[@id=\"searchPage\"]/div[3]/div/label/span")
	public WebElement result_Produto;

	public void bt_CriarNovaConta() {
		this.bt_CriarNovaConta.sendKeys(Keys.ENTER);
	}

	public void bt_UserIcon() {
		this.bt_UserIcon.click();
	}

	public void preencheLogin(String txt_UserLogin, String txt_PasswordLogin) {
		this.txt_UserName.sendKeys(txt_UserLogin);
		this.txt_Password.sendKeys(txt_PasswordLogin);
	}

	public void bt_Logar() {
		this.bt_Logar.sendKeys(Keys.ENTER);
	}

	public void clicaProdutoCategoria(WebDriver driver) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement elemento = bt_LaptopImg;
		executor.executeScript("arguments[0].click();", elemento);
	}

	public void bt_Lupa() {
		this.bt_Lupa.click();
	}
	
	public void pesquisar(String txt_Pesquisa) {
		this.txt_Pesquisa.sendKeys(txt_Pesquisa + Keys.ENTER);
	}
	
	public void bt_FechaSugestao(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(this.bt_FechaSugestao));
	}

}