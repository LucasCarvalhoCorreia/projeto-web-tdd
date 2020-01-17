package br.com.rsinet.hub_tdd.pageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_tdd.util.Constant;
import br.com.rsinet.hub_tdd.util.ExcelUtils;

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

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/section/article/h3")
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
	
	public void efetuaPagamento(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, PagamentoPage.class);

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Pagamento");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		bt_Next.click();

		WebElement limpaUser = txt_UserNamePay;
		limpaUser.clear();
		limpaUser.sendKeys(ExcelUtils.getCellData(1, Constant.txt_UserNamePay));

		WebElement limpaPass = txt_PasswordPay;
		limpaPass.clear();
		limpaPass.sendKeys(ExcelUtils.getCellData(1, Constant.txt_PasswordPay));

		check_SavePay.click();

		bt_Pay.click();

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "PesquisaCat");
	}
}
