package br.com.rsinet.hub_tdd.passes;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.pageObject.CadastroPage;
import br.com.rsinet.hub_tdd.pageObject.HomePage;
import br.com.rsinet.hub_tdd.util.Constant;
import br.com.rsinet.hub_tdd.util.ExcelUtils;
import br.com.rsinet.hub_tdd.util.Utilidades;

public class CadastroSucesso extends Utilidades {

	private static WebDriver driver;
	
	@BeforeMethod
	public void inicio() throws InterruptedException {
		driver = iniciaBrowser();
	}

	@Test
	public void cadastro() throws Exception {
		HomePage.criarNovaConta(driver);

		CadastroPage.cadastrarUsuario(driver);
		
		String condicao = ExcelUtils.getCellData(1, Constant.txt_UserName);
		String mensagem = ExcelUtils.getCellData(1, Constant.msg_AssertCadastro);
		String pass = CadastroPage.user_Logon.getText();
		Assert.assertTrue(pass.equals(condicao), mensagem);
	}

	@AfterMethod
	public void fim() throws Exception {
		tirarPrintsDeSucesso("CadastroSucesso ", driver);
		driver = fechaBrowser();
	}

}
