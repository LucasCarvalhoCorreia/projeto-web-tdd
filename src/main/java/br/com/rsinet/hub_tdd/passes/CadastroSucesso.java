package br.com.rsinet.hub_tdd.passes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.pageFactory.CadastroPage;
import br.com.rsinet.hub_tdd.pageFactory.HomePage;
import br.com.rsinet.hub_tdd.util.Constant;
import br.com.rsinet.hub_tdd.util.ExcelUtils;
import br.com.rsinet.hub_tdd.util.Prints;
import br.com.rsinet.hub_tdd.util.DriverFactory;

public class CadastroSucesso extends DriverFactory {

	private WebDriver driver;
	private HomePage homePage;
	private CadastroPage cadastroPage;
	
	@BeforeMethod
	public void inicio() throws Exception {
		driver = DriverFactory.iniciaBrowser();
		
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Cadastro");
		homePage = PageFactory.initElements(driver, HomePage.class);
		cadastroPage = PageFactory.initElements(driver, CadastroPage.class);
	}

	@Test
	public void cadastro() throws Exception {
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		homePage.bt_UserIcon();
		
		homePage.bt_CriarNovaConta();
		
		String txt_UserName = ExcelUtils.getCellData(1, Constant.txt_UserName);
		String txt_Email = ExcelUtils.getCellData(1, Constant.txt_Email);
		String txt_Password = ExcelUtils.getCellData(1, Constant.txt_Password);
		String txt_ConfirmPassword = ExcelUtils.getCellData(1, Constant.txt_ConfirmPassword);
		String txt_FirstName = ExcelUtils.getCellData(1, Constant.txt_FirstName);
		String txt_LastName = ExcelUtils.getCellData(1, Constant.txt_LastName);
		String txt_Telefone = ExcelUtils.getCellData(1, Constant.txt_Telefone);
		String combo_Pais = ExcelUtils.getCellData(1, Constant.combo_Pais);
		String txt_Cidade = ExcelUtils.getCellData(1, Constant.txt_Cidade);
		String txt_Endereco = ExcelUtils.getCellData(1, Constant.txt_Endereco);
		String txt_Estado = ExcelUtils.getCellData(1, Constant.txt_Estado);
		String txt_Cep = ExcelUtils.getCellData(1, Constant.txt_Cep);
		
		cadastroPage.cadastrarUsuario(txt_UserName, txt_Email, txt_Password, txt_ConfirmPassword, txt_FirstName, txt_LastName, 
				txt_Telefone, combo_Pais, txt_Cidade, txt_Endereco, txt_Estado, txt_Cep);
		
		cadastroPage.check_Offers();
		cadastroPage.check_Agree();
		cadastroPage.bt_Registrar();
		
		String condicao = ExcelUtils.getCellData(1, Constant.txt_UserName);
		String mensagem = ExcelUtils.getCellData(1, Constant.msg_AssertCadastro);
		
		String pass = cadastroPage.user_Logon.getText();
		Assert.assertTrue(pass.equals(condicao), mensagem);
	}

	@AfterMethod
	public void fim() throws Exception {
		Prints.tirarPrintsDeSucesso("CadastroSucesso ", driver);
		DriverFactory.fechaBrowser(driver);
	}

}
