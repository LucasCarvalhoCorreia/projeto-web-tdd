package br.com.rsinet.hub_tdd.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

	static WebDriver driver;

	@FindBy(how = How.ID, using = "hrefUserIcon")
	public static WebElement userIcon;
	
	@FindBy(how = How.XPATH, using = "/html/body/login-modal/div/div/div[3]/a[2]")
	public static WebElement criarNovaConta;
	
	@FindBy(how = How.NAME, using = "username")
	public static WebElement userName;
	
	@FindBy(how = How.NAME, using = "password")
	public static WebElement password;
	
	@FindBy(how = How.ID, using = "sign_in_btnundefined")
	public static WebElement btLogar;
	
	@FindBy(how = How.ID, using = "laptopsImg")
	public static WebElement laptopImg;
	
	@FindBy(how = How.ID, using = "menuSearch")
	public static WebElement lupa;
	
	@FindBy(how = How.ID, using = "autoComplete")
	public static WebElement txtPesquisa;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"search\"]/div/div/img")
	public static WebElement fechaSegestao;
}