package br.com.rsinet.hub_tdd.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PagamentoPage {

	static WebDriver driver;

	@FindBy(how = How.ID, using = "next_btn")
	public static WebElement bt_Next;
	
	@FindBy(how = How.NAME, using = "safepay_username")
	public static WebElement txt_UserNamePay;
	
	@FindBy(how = How.NAME, using = "safepay_password")
	public static WebElement txt_PasswordPay;
	
	@FindBy(how = How.NAME, using = "save_safepay")
	public static WebElement check_SavePay;
	
	@FindBy(how = How.ID, using = "pay_now_btn_SAFEPAY")
	public static WebElement bt_Pay;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[3]/section/article/h3")
	public static WebElement lbl_Pago;
}
