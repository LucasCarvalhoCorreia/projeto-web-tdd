package br.com.rsinet.hub_tdd.pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_tdd.util.Constant;
import br.com.rsinet.hub_tdd.util.ExcelUtils;

public class PagamentoPage {

	static WebDriver driver;

	@FindBy(how = How.ID, using = "next_btn")
	private static WebElement bt_Next;

	@FindBy(how = How.NAME, using = "safepay_username")
	private static WebElement txt_UserNamePay;

	@FindBy(how = How.NAME, using = "safepay_password")
	private static WebElement txt_PasswordPay;

	@FindBy(how = How.NAME, using = "save_safepay")
	private static WebElement check_SavePay;

	@FindBy(how = How.ID, using = "pay_now_btn_SAFEPAY")
	private static WebElement bt_Pay;

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/section/article/h3")
	public static WebElement lbl_Pago;

	public static void efetuaPagamento(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, PagamentoPage.class);

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Pagamento");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		bt_Next.click();

		WebElement limpaUser = PagamentoPage.txt_UserNamePay;
		limpaUser.clear();
		limpaUser.sendKeys(ExcelUtils.getCellData(1, Constant.txt_UserNamePay));

		WebElement limpaPass = PagamentoPage.txt_PasswordPay;
		limpaPass.clear();
		limpaPass.sendKeys(ExcelUtils.getCellData(1, Constant.txt_PasswordPay));

		check_SavePay.click();

		bt_Pay.click();

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "PesquisaCat");
	}
}
