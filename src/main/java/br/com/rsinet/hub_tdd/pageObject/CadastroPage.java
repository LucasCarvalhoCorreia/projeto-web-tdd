package br.com.rsinet.hub_tdd.pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import br.com.rsinet.hub_tdd.util.Constant;
import br.com.rsinet.hub_tdd.util.ExcelUtils;

public class CadastroPage{

	static WebDriver driver;

	@FindBy(how = How.NAME, using = "usernameRegisterPage")
	private static WebElement txt_UserName;

	@FindBy(how = How.NAME, using = "emailRegisterPage")
	private static WebElement txt_Email;

	@FindBy(how = How.NAME, using = "passwordRegisterPage")
	private static WebElement txt_Password;

	@FindBy(how = How.NAME, using = "confirm_passwordRegisterPage")
	private static WebElement txt_ConfirmPassword;

	@FindBy(how = How.NAME, using = "first_nameRegisterPage")
	private static WebElement txt_FirstName;

	@FindBy(how = How.NAME, using = "last_nameRegisterPage")
	private static WebElement txt_LastName;

	@FindBy(how = How.NAME, using = "phone_numberRegisterPage")
	private static WebElement txt_Telefone;

	@FindBy(how = How.NAME, using = "countryListboxRegisterPage")
	private static WebElement combo_Pais;

	@FindBy(how = How.NAME, using = "cityRegisterPage")
	private static WebElement txt_Cidade;

	@FindBy(how = How.NAME, using = "addressRegisterPage")
	private static WebElement txt_Endereco;

	@FindBy(how = How.NAME, using = "state_/_province_/_regionRegisterPage")
	private static WebElement txt_Estado;

	@FindBy(how = How.NAME, using = "postal_codeRegisterPage")
	private static WebElement txt_Cep;

	@FindBy(how = How.NAME, using = "allowOffersPromotion")
	private static WebElement check_Offers;

	@FindBy(how = How.NAME, using = "i_agree")
	private static WebElement check_Agree;

	@FindBy(how = How.ID, using = "register_btnundefined")
	private static WebElement bt_Registrar;

	@FindBy(how = How.XPATH, using = "//*[@id=\"formCover\"]/div[1]/div[2]/sec-view[2]/div/label")
	public static WebElement not_Password;

	@FindBy(how = How.XPATH, using = "//*[@id=\"menuUserLink\"]/span")
	public static WebElement user_Logon;

	
	public static void cadastrarUsuario(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, CadastroPage.class);

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Cadastro");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		txt_UserName.sendKeys(ExcelUtils.getCellData(1, Constant.txt_UserName));

		txt_Email.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Email));

		txt_Password.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Password));

		txt_ConfirmPassword.sendKeys(ExcelUtils.getCellData(1, Constant.txt_ConfirmPassword));

		txt_FirstName.sendKeys(ExcelUtils.getCellData(1, Constant.txt_FirstName));

		txt_LastName.sendKeys(ExcelUtils.getCellData(1, Constant.txt_LastName));

		txt_Telefone.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Telefone));

		WebElement Country = combo_Pais;
		Select comboBox = new Select(Country);
		comboBox.selectByVisibleText(ExcelUtils.getCellData(1, Constant.combo_Pais));

		txt_Cidade.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Cidade));

		txt_Endereco.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Endereco));

		txt_Estado.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Estado));

		txt_Cep.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Cep));

		check_Offers.click();

		check_Agree.click();

		bt_Registrar.click();

		// Comadno utilizado para esperar a pagina carregar para pegar o texto do
		// elemento.
		// Nenhum outro comando waiter utilizado fez efeito nesta situação.
		Thread.sleep(500);
	}
	
	public static void cadastrarUsuarioErrado(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, CadastroPage.class);

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Cadastro");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		txt_UserName.sendKeys(ExcelUtils.getCellData(1, Constant.txt_UserName));
		
		txt_Email.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Email));
		
		txt_Password.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Password));
		
		txt_ConfirmPassword.sendKeys(ExcelUtils.getCellData(1, Constant.txt_ConfirmPassword));
		
		txt_FirstName.sendKeys(ExcelUtils.getCellData(1, Constant.txt_FirstName));
		
		txt_LastName.sendKeys(ExcelUtils.getCellData(1, Constant.txt_LastName));
		
		txt_Telefone.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Telefone));

		WebElement Country = combo_Pais;
		Select comboBox = new Select(Country);
		comboBox.selectByVisibleText(ExcelUtils.getCellData(1, Constant.combo_Pais));

		txt_Cidade.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Cidade));
		
		txt_Endereco.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Endereco));
		
		txt_Estado.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Estado));
		
		txt_Cep.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Cep));
		
		check_Offers.click();
		
		check_Agree.click();
		
		bt_Registrar.click();

		WebElement senha = txt_ConfirmPassword;
		senha.clear();
		senha.sendKeys(ExcelUtils.getCellData(2, Constant.txt_ConfirmPassword));

		txt_Password.click();
	}
}
