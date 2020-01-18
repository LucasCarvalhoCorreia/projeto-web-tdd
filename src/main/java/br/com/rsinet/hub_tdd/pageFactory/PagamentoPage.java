package br.com.rsinet.hub_tdd.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PagamentoPage {

	WebDriver driver;

	@FindBy(how = How.ID, using = "next_btn")
	private WebElement bt_Next;

	@FindBy(how = How.NAME, using = "safepay_username")
	private WebElement txt_UserNamePay;

	@FindBy(how = How.NAME, using = "safepay_password")
	private WebElement txt_PasswordPay;

	@FindBy(how = How.NAME, using = "save_safepay")
	private WebElement check_SavePay;

	@FindBy(how = How.ID, using = "pay_now_btn_SAFEPAY")
	private WebElement bt_Pay;

	@FindBy(how = How.XPATH, using = "//*[@id=\"orderPaymentSuccess\"]/h2/span")
	public WebElement lbl_Pago;

	
	public void bt_Next() {
		this.bt_Next.click();
	}
	
	public void limpaUser() {
		this.txt_UserNamePay.clear();
	}
	
	public void limpaPass() {
		this.txt_PasswordPay.clear();
	}
	
	public void logaContaPay(String txt_UserNamePay, String txt_PasswordPay) {
		this.txt_UserNamePay.sendKeys(txt_UserNamePay);
		this.txt_PasswordPay.sendKeys(txt_PasswordPay);
	}
	
	public void check_SavePay() {
		this.check_SavePay.click();
	}
	
	public void bt_Pay() {
		this.bt_Pay.click();
	}
	
	public void pega_Pago(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(this.lbl_Pago));
	}
}
