package br.com.rsinet.hub_tdd.falhas;

import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_tdd.pageObject.CadastroPage;
import br.com.rsinet.hub_tdd.pageObject.Modulo;
import br.com.rsinet.hub_tdd.util.Utilidades;

public class CadastroFalha extends Utilidades {

	private static WebDriver driver;

	@Before
	public void inicio() throws InterruptedException {
		driver = iniciaBrowser();
	}

	@Test
	public void cadastro() throws Exception {
		Modulo.criarNovaConta(driver);
		
		Modulo.cadastrarUsuarioErrado(driver);

		String pass = CadastroPage.not_Password.getText();
		assertFalse("A senha não é a mesma!", pass.equals("Passwords do not match"));
	}

	@After
	public void fim() throws Exception {
		tirarPrintsDeFalha("CadastroFalha ", driver);
		driver = fechaBrowser();
	}

}
