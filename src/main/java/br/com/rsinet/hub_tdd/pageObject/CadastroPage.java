package br.com.rsinet.hub_tdd.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CadastroPage {
	
	static WebDriver driver;

	@FindBy(how = How.NAME, using = "usernameRegisterPage")
	public static WebElement txt_UserName;
	
	@FindBy(how = How.NAME, using = "emailRegisterPage")
	public static WebElement txt_Email;
	
	@FindBy(how = How.NAME, using = "passwordRegisterPage")
	public static WebElement txt_Password;
	
	@FindBy(how = How.NAME, using = "confirm_passwordRegisterPage")
	public static WebElement txt_ConfirmPassword;
	
	@FindBy(how = How.NAME, using = "first_nameRegisterPage")
	public static WebElement txt_FirstName;
	
	@FindBy(how = How.NAME, using = "last_nameRegisterPage")
	public static WebElement txt_LastName;
	
	@FindBy(how = How.NAME, using = "phone_numberRegisterPage")
	public static WebElement txt_Telefone;
	
	@FindBy(how = How.NAME, using = "countryListboxRegisterPage")
	public static WebElement combo_Pais;
	
	@FindBy(how = How.NAME, using = "cityRegisterPage")
	public static WebElement txt_Cidade;
	
	@FindBy(how = How.NAME, using = "addressRegisterPage")
	public static WebElement txt_Endereco;
	
	@FindBy(how = How.NAME, using = "state_/_province_/_regionRegisterPage")
	public static WebElement txt_Estado;
	
	@FindBy(how = How.NAME, using = "postal_codeRegisterPage")
	public static WebElement txt_Cep;
	
	@FindBy(how = How.NAME, using = "allowOffersPromotion")
	public static WebElement check_Offers;
	
	@FindBy(how = How.NAME, using = "i_agree")
	public static WebElement check_Agree;
	
	@FindBy(how = How.ID, using = "register_btnundefined")
	public static WebElement bt_Registrar;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"formCover\"]/div[1]/div[2]/sec-view[2]/div/label")
	public static WebElement not_Password;
}
