package br.com.rsinet.hub_tdd.pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	/* Area onde são encontrados os elementos na pagina de inicio. */

	/*
	 * Encontra os Editores de Texto, Botões, ComboBox e CheckBox para o campo
	 * correspondente ao nome da variável e atribui na mesma.
	 */
	/* Utilizado para preencher as informações de Login e Pesquisa. */
	@FindBy(id = "hrefUserIcon")
	private WebElement bt_UserIcon;

	@FindBy(xpath = "/html/body/login-modal/div/div/div[3]/a[2]")
	private WebElement bt_CriarNovaConta;

	@FindBy(name = "username")
	private WebElement txt_UserName;

	@FindBy(name = "password")
	private WebElement txt_Password;

	@FindBy(id = "sign_in_btnundefined")
	private WebElement bt_Logar;

	@FindBy(id = "laptopsImg")
	private WebElement bt_LaptopImg;

	@FindBy(id = "menuSearch")
	private WebElement bt_Lupa;

	@FindBy(id = "autoComplete")
	private WebElement txt_Pesquisa;

	@FindBy(xpath = "//*[@id=\"search\"]/div/div/img")
	private WebElement bt_FechaSugestao;

	@FindBy(xpath = "//*[@id=\"searchPage\"]/div[3]/div/label/span")
	public WebElement result_Produto;

	/*
	 * Método utilizado para clicar no botão para acessar a pagina de criar nova
	 * conta.
	 */
	public void bt_CriarNovaConta() {
		this.bt_CriarNovaConta.sendKeys(Keys.ENTER);
	}

	/* Método utilizado para clicar no botão da área do usuário. */
	public void bt_UserIcon() {
		this.bt_UserIcon.click();
	}

	/* Método tuilizado para preencher os dados de login. */
	public void preencheLogin(String txt_UserLogin, String txt_PasswordLogin) {
		this.txt_UserName.sendKeys(txt_UserLogin);
		this.txt_Password.sendKeys(txt_PasswordLogin);
	}

	/* Método tuilizado para clicar no botão de logar. */
	public void bt_Logar() {
		this.bt_Logar.sendKeys(Keys.ENTER);
	}

	/*
	 * Método tuilizado para clicar na categoria de produtos na pagina inicial
	 * desejada.
	 */
	public void clicaProdutoCategoria(WebDriver driver) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement elemento = bt_LaptopImg;
		executor.executeScript("arguments[0].click();", elemento);
	}

	/* Método tuilizado para clicar no botão de lupa para realizar consultas. */
	public void bt_Lupa() {
		this.bt_Lupa.click();
	}

	/* Método tuilizado para pesquisar produtos na barra de pesquisa. */
	public void pesquisar(String txt_Pesquisa) {
		this.txt_Pesquisa.sendKeys(txt_Pesquisa + Keys.ENTER);
	}

	/*
	 * Método tuilizado para clicar no botão de fechar a janela de sugestões de
	 * pesquisa da barra de pesquisa.
	 */
	public void bt_FechaSugestao(WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");
		this.bt_FechaSugestao.click();
	}

}