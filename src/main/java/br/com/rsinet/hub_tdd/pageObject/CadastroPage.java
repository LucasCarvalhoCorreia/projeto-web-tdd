package br.com.rsinet.hub_tdd.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CadastroPage {
	
	static WebDriver driver;

	@FindBy(how = How.NAME, using = "usernameRegisterPage")
	public static WebElement userName;
	
	@FindBy(how = How.NAME, using = "emailRegisterPage")
	public static WebElement email;
	
	@FindBy(how = How.NAME, using = "passwordRegisterPage")
	public static WebElement password;
	
	@FindBy(how = How.NAME, using = "confirm_passwordRegisterPage")
	public static WebElement confirmPassword;
	
	@FindBy(how = How.NAME, using = "first_nameRegisterPage")
	public static WebElement firstName;
	
	@FindBy(how = How.NAME, using = "last_nameRegisterPage")
	public static WebElement lastName;
	
	@FindBy(how = How.NAME, using = "phone_numberRegisterPage")
	public static WebElement telefone;
	
	@FindBy(how = How.NAME, using = "countryListboxRegisterPage")
	public static WebElement pais;
	
	@FindBy(how = How.NAME, using = "cityRegisterPage")
	public static WebElement cidade;
	
	@FindBy(how = How.NAME, using = "addressRegisterPage")
	public static WebElement endereco;
	
	@FindBy(how = How.NAME, using = "state_/_province_/_regionRegisterPage")
	public static WebElement estado;
	
	@FindBy(how = How.NAME, using = "postal_codeRegisterPage")
	public static WebElement cep;
	
	@FindBy(how = How.NAME, using = "allowOffersPromotion")
	public static WebElement boxOffers;
	
	@FindBy(how = How.NAME, using = "i_agree")
	public static WebElement boxAgree;
	
	@FindBy(how = How.ID, using = "register_btnundefined")
	public static WebElement btRegistrar;
}
