package br.com.rsinet.hub_tdd.falhas;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.pageFactory.CadastroPage;
import br.com.rsinet.hub_tdd.pageFactory.HomePage;
import br.com.rsinet.hub_tdd.util.Constant;
import br.com.rsinet.hub_tdd.util.ExcelUtils;
import br.com.rsinet.hub_tdd.util.Utilidades;

public class CadastroFalha extends Utilidades {

	private WebDriver driver;

	@BeforeMethod
	public void inicio() throws InterruptedException {
		driver = iniciaBrowser();
	}

	@Test
	public void cadastro() throws Exception {
		HomePage.criarNovaConta(driver);
		CadastroPage cadastroSucesso = new CadastroPage();
		
		cadastroSucesso.cadastrarUsuarioErrado(driver);

		String condicao = ExcelUtils.getCellData(5, Constant.condicao_AssertCadastroErro);
		String mensagem = ExcelUtils.getCellData(5, Constant.msg_AssertCadastroErro);
		String pass = cadastroSucesso.not_Password.getText();
		Assert.assertFalse(pass.equals(condicao), mensagem);
	}

	@AfterMethod
	public void fim() throws Exception {
		tirarPrintsDeFalha("CadastroFalha ", driver);
		driver = fechaBrowser();
	}

}
