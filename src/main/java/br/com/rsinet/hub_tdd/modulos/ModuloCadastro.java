package br.com.rsinet.hub_tdd.modulos;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import br.com.rsinet.hub_tdd.pageObject.CadastroPage;
import br.com.rsinet.hub_tdd.util.Constant;
import br.com.rsinet.hub_tdd.util.ExcelUtils;

public class ModuloCadastro {
	
	public static void cadastrarUsuario(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, CadastroPage.class);

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Cadastro");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		CadastroPage.txt_UserName.sendKeys(ExcelUtils.getCellData(1, Constant.txt_UserName));
		
		CadastroPage.txt_Email.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Email));
		
		CadastroPage.txt_Password.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Password));
		
		CadastroPage.txt_ConfirmPassword.sendKeys(ExcelUtils.getCellData(1, Constant.txt_ConfirmPassword));
		
		CadastroPage.txt_FirstName.sendKeys(ExcelUtils.getCellData(1, Constant.txt_FirstName));
		
		CadastroPage.txt_LastName.sendKeys(ExcelUtils.getCellData(1, Constant.txt_LastName));
		
		CadastroPage.txt_Telefone.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Telefone));

		WebElement Country = CadastroPage.combo_Pais;
		Select comboBox = new Select(Country);
		comboBox.selectByVisibleText(ExcelUtils.getCellData(1, Constant.combo_Pais));

		CadastroPage.txt_Cidade.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Cidade));
		
		CadastroPage.txt_Endereco.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Endereco));
		
		CadastroPage.txt_Estado.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Estado));
		
		CadastroPage.txt_Cep.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Cep));
		
		CadastroPage.check_Offers.click();
		
		CadastroPage.check_Agree.click();
		
		CadastroPage.bt_Registrar.click();
		
		Thread.sleep(1000);
	}

	public static void cadastrarUsuarioErrado(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, CadastroPage.class);

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Cadastro");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		CadastroPage.txt_UserName.sendKeys(ExcelUtils.getCellData(1, Constant.txt_UserName));
		
		CadastroPage.txt_Email.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Email));
		
		CadastroPage.txt_Password.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Password));
		
		CadastroPage.txt_ConfirmPassword.sendKeys(ExcelUtils.getCellData(1, Constant.txt_ConfirmPassword));
		
		CadastroPage.txt_FirstName.sendKeys(ExcelUtils.getCellData(1, Constant.txt_FirstName));
		
		CadastroPage.txt_LastName.sendKeys(ExcelUtils.getCellData(1, Constant.txt_LastName));
		
		CadastroPage.txt_Telefone.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Telefone));

		WebElement Country = CadastroPage.combo_Pais;
		Select comboBox = new Select(Country);
		comboBox.selectByVisibleText(ExcelUtils.getCellData(1, Constant.combo_Pais));

		CadastroPage.txt_Cidade.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Cidade));
		
		CadastroPage.txt_Endereco.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Endereco));
		
		CadastroPage.txt_Estado.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Estado));
		
		CadastroPage.txt_Cep.sendKeys(ExcelUtils.getCellData(1, Constant.txt_Cep));
		
		CadastroPage.check_Offers.click();
		
		CadastroPage.check_Agree.click();
		
		CadastroPage.bt_Registrar.click();

		WebElement senha = CadastroPage.txt_ConfirmPassword;
		senha.clear();
		senha.sendKeys(ExcelUtils.getCellData(2, Constant.txt_ConfirmPassword));

		CadastroPage.txt_Password.click();
	}

}
