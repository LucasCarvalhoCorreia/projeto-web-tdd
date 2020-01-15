package br.com.rsinet.hub_tdd.falhas;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.modulos.ModuloCadastro;
import br.com.rsinet.hub_tdd.modulos.ModuloHome;
import br.com.rsinet.hub_tdd.pageObject.CadastroPage;
import br.com.rsinet.hub_tdd.util.Utilidades;

public class CadastroFalha extends Utilidades {

	private static WebDriver driver;

	@BeforeMethod
	public void inicio() throws InterruptedException {
		driver = iniciaBrowser();
	}

	@Test
	public void cadastro() throws Exception {
		ModuloHome.criarNovaConta(driver);
		
		ModuloCadastro.cadastrarUsuarioErrado(driver);

		String pass = CadastroPage.not_Password.getText();
		Assert.assertFalse(pass.equals("Passwords do not match"), "A senha não é a mesma!");
	}

	@AfterMethod
	public void fim() throws Exception {
		tirarPrintsDeFalha("CadastroFalha ", driver);
		driver = fechaBrowser();
	}

}
