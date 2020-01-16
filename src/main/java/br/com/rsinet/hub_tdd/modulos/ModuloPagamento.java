package br.com.rsinet.hub_tdd.modulos;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_tdd.pageObject.PagamentoPage;
import br.com.rsinet.hub_tdd.util.Constant;
import br.com.rsinet.hub_tdd.util.ExcelUtils;

public class ModuloPagamento {
	
	public static void efetuaPagamento(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, PagamentoPage.class);

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Pagamento");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		PagamentoPage.bt_Next.click();
		
		PagamentoPage.txt_UserNamePay.sendKeys(ExcelUtils.getCellData(1, Constant.txt_UserNamePay));
		
		PagamentoPage.txt_PasswordPay.sendKeys(ExcelUtils.getCellData(1, Constant.txt_PasswordPay));
		
		PagamentoPage.check_SavePay.click();
		
		PagamentoPage.bt_Pay.click();
		
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "PesquisaCat");
	}

}
