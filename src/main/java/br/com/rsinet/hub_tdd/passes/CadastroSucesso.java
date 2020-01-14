package br.com.rsinet.hub_tdd.passes;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_tdd.pageObject.Modulo;
import br.com.rsinet.hub_tdd.util.Utilidades;

public class CadastroSucesso extends Utilidades {

	private static WebDriver driver;
	
	@Before
	public void inicio() throws InterruptedException {
		driver = iniciaBrowser();
	}

	@Test
	public void cadastro() throws Exception {
		Modulo.criarNovaConta(driver);

		Modulo.cadastrarUsuario(driver);
		
		String pass = driver.findElement(By.xpath("//*[@id=\"formCover\"]/div[1]/div[2]/sec-view[2]/div/label")).getText();
		assertTrue("Cadastro efetuado com sucesso", pass.equals("Confirm password"));
	}

	@After
	public void fim() throws Exception {
		tirarPrintsDeSucesso("Cadastro");
		driver = fechaBrowser();
	}

}
