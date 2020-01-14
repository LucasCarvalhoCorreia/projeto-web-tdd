package br.com.rsinet.hub_tdd.falhas;

import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_tdd.pageObject.Modulo;
import br.com.rsinet.hub_tdd.util.Constant;
import br.com.rsinet.hub_tdd.util.ExcelUtils;
import br.com.rsinet.hub_tdd.util.Utilidades;

public class ConsultaPesquisaFalha extends Utilidades {

	private static WebDriver driver;

	@Before
	public void inicio() throws InterruptedException {
		driver = iniciaBrowser();
	}

	@Test
	public void consultaPesquisa() throws Exception {
		String resposta = Modulo.barraDePesquisaErrado(driver);

		String elemento = ExcelUtils.getCellData(1, Constant.txt_PesquisaBarraErro);
		assertFalse("Nenhum resultado encontrado!", resposta.equals("No results for " + "\"" + elemento + "\""));
	}

	@After
	public void fim() throws Exception {
		tirarPrintsDeFalha("ConsultaPesquisaFalha ", driver);
		driver = fechaBrowser();
	}

}
