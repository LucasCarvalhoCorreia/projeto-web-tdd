package br.com.rsinet.hub_tdd.falhas;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.modulos.ModuloHome;
import br.com.rsinet.hub_tdd.util.Constant;
import br.com.rsinet.hub_tdd.util.ExcelUtils;
import br.com.rsinet.hub_tdd.util.Utilidades;

public class ConsultaPesquisaFalha extends Utilidades {

	private static WebDriver driver;

	@BeforeMethod
	public void inicio() throws InterruptedException {
		driver = iniciaBrowser();
	}

	@Test
	public void consultaPesquisa() throws Exception {
		String resposta = ModuloHome.barraDePesquisaErrado(driver);

		String elemento = ExcelUtils.getCellData(1, Constant.txt_PesquisaBarraErro);
		Assert.assertFalse(resposta.equals("No results for " + "\"" + elemento + "\""), "Nenhum resultado encontrado!");
	}

	@AfterMethod
	public void fim() throws Exception {
		tirarPrintsDeFalha("ConsultaPesquisaFalha ", driver);
		driver = fechaBrowser();
	}

}
