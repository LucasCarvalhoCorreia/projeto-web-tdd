package br.com.rsinet.hub_tdd.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroPage {

	/* Area onde são encontrados os elementos na pagina de cadastro. */

	/*
	 * Encontra os Editores de Texto, Botões, ComboBox e CheckBox para o campo
	 * correspondente ao nome da variável e atribui na mesma.
	 */
	/* Utilizado para preencher as informações de cadastro. */
	@FindBy(name = "usernameRegisterPage")
	private WebElement txt_UserName;

	@FindBy(name = "emailRegisterPage")
	private WebElement txt_Email;

	@FindBy(name = "passwordRegisterPage")
	private WebElement txt_Password;

	@FindBy(name = "confirm_passwordRegisterPage")
	private WebElement txt_ConfirmPassword;

	@FindBy(name = "first_nameRegisterPage")
	private WebElement txt_FirstName;

	@FindBy(name = "last_nameRegisterPage")
	private WebElement txt_LastName;

	@FindBy(name = "phone_numberRegisterPage")
	private WebElement txt_Telefone;

	@FindBy(name = "countryListboxRegisterPage")
	private WebElement combo_Pais;

	@FindBy(name = "cityRegisterPage")
	private WebElement txt_Cidade;

	@FindBy(name = "addressRegisterPage")
	private WebElement txt_Endereco;

	@FindBy(name = "state_/_province_/_regionRegisterPage")
	private WebElement txt_Estado;

	@FindBy(name = "postal_codeRegisterPage")
	private WebElement txt_Cep;

	@FindBy(name = "allowOffersPromotion")
	private WebElement check_Offers;

	@FindBy(name = "i_agree")
	private WebElement check_Agree;

	@FindBy(id = "register_btnundefined")
	private WebElement bt_Registrar;

	/* Elemento utilizado para receber o status da confirmação da senha. */
	@FindBy(xpath = "//*[@id=\"formCover\"]/div[1]/div[2]/sec-view[2]/div/label")
	public WebElement not_Password;

	/* Elemento utilizado para receber o nome de usuário logado. */
	@FindBy(xpath = "//*[@id=\"menuUserLink\"]/span")
	public WebElement user_Logon;

	/*
	 * Método utilizado para receber as informações da massa de dados e preencher o
	 * formulario.
	 */

	public void preencheUserName(String txt_UserName) {
		this.txt_UserName.sendKeys(txt_UserName);
	}

	public void preencheEmail(String txt_Email) {
		this.txt_Email.sendKeys(txt_Email);
	}

	public void preenchePassword(String txt_Password) {
		this.txt_Password.sendKeys(txt_Password);
	}

	public void preencheConfirmPassword(String txt_ConfirmPassword) {
		this.txt_ConfirmPassword.sendKeys(txt_ConfirmPassword);
	}

	public void preencheFirstName(String txt_FirstName) {
		this.txt_FirstName.sendKeys(txt_FirstName);
	}

	public void preencheLastName(String txt_LastName) {
		this.txt_LastName.sendKeys(txt_LastName);
	}

	public void preencheTelefone(String txt_Telefone) {
		this.txt_Telefone.sendKeys(txt_Telefone);
	}

	public void preenchePais(String combo_Pais) {
		this.combo_Pais.click();
		new Select(this.combo_Pais).selectByVisibleText(combo_Pais);
		this.combo_Pais.click();
	}

	public void preencheCidade(String txt_Cidade) {
		this.txt_Cidade.sendKeys(txt_Cidade);
	}

	public void preencheEndereco(String txt_Endereco) {
		this.txt_Endereco.sendKeys(txt_Endereco);
	}

	public void preencheEstado(String txt_Estado) {
		this.txt_Estado.sendKeys(txt_Estado);
	}

	public void preencheCep(String txt_Cep) {
		this.txt_Cep.sendKeys(txt_Cep);
	}

	/* Método utilizado para preencher o campo de confirmação de senha. */
	public void mudaSenha(String txt_ChangePassword) {
		this.txt_ConfirmPassword.sendKeys(txt_ChangePassword);
	}

	/* Método utilizado para limpar o campo de confirmação de senha. */
	public void clear() {
		this.txt_ConfirmPassword.clear();
	}

	/*
	 * Método utilizado para clicar no campo senha para que a notificação de erro na
	 * confirmação de senha apareça.
	 */
	public void clicaPassword() {
		this.txt_Password.click();
	}

	/* Método utilizado para clicar no check box de ofertas. */
	public void check_Offers() {
		this.check_Offers.click();
	}

	/* Método utilizado para clicar no check box de termos de serviço. */
	public void check_Agree() {
		this.check_Agree.click();
	}

	/* Método utilizado para clicar no botão de registrar. */
	public void bt_Registrar() {
		this.bt_Registrar.click();
	}

	/*
	 * Método utilizado para aguardar que o elemento que aparece o nome de usuario
	 * apareça para coletar a informação.
	 */
	public void pega_UserLogon(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(this.user_Logon));
	}

}
