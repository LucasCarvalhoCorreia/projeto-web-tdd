package br.com.rsinet.hub_tdd.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

	static WebDriver driver;

	@FindBy(how = How.ID, using = "hrefUserIcon")
	public static WebElement bt_UserIcon;
	
	@FindBy(how = How.XPATH, using = "/html/body/login-modal/div/div/div[3]/a[2]")
	public static WebElement bt_CriarNovaConta;
	
	@FindBy(how = How.NAME, using = "username")
	public static WebElement txt_UserName;
	
	@FindBy(how = How.NAME, using = "password")
	public static WebElement txt_Password;
	
	@FindBy(how = How.ID, using = "sign_in_btnundefined")
	public static WebElement bt_Logar;
	
	@FindBy(how = How.ID, using = "laptopsImg")
	public static WebElement bt_LaptopImg;
	
	@FindBy(how = How.ID, using = "menuSearch")
	public static WebElement bt_Lupa;
	
	@FindBy(how = How.ID, using = "autoComplete")
	public static WebElement txt_Pesquisa;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"search\"]/div/div/img")
	public static WebElement bt_FechaSugestao;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"searchPage\"]/div[3]/div/label/span")
	public static WebElement result_Produto;
}