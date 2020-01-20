package br.com.rsinet.hub_tdd.testes.falhas;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.pageFactory.HomePage;
import br.com.rsinet.hub_tdd.utils.Constant;
import br.com.rsinet.hub_tdd.utils.DriverFactory;
import br.com.rsinet.hub_tdd.utils.ExcelUtils;
import br.com.rsinet.hub_tdd.utils.Prints;

public class ConsultaPorBarraDePesquisaErrado extends DriverFactory {

	private WebDriver driver;
	private HomePage homePage;

	/* Área responsavel pelos testes de falha. */

	/* @ responsavel por executar todos os elementos antes do @Test. */
	@BeforeMethod
	public void inicio() throws Exception {
		driver = DriverFactory.iniciaBrowser();

		/* Comando responsavel por ler o arquivo e aba do excel especificados. */
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "PesquisaBarra");
		/*
		 * Comando responsavel por iniciar os elementos dentro da pageFactory
		 * especificada.
		 */
		homePage = PageFactory.initElements(driver, HomePage.class);
	}

	/* @ responsavel por executar a pilha de testes. */
	@Test
	public void consultaPorBarraDePesquisaComProdutoInexistenteNoBanco() throws Exception {
		/*
		 * Comando responsavel por aguardar o tempo especificado entre as linhas de
		 * comando.
		 */
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		homePage.bt_Lupa();

		/*
		 * Atribui o valor recebido pela coluna e linha especificada no arquivo excel a
		 * uma variavel
		 */
		String txt_Pesquisa = (ExcelUtils.getCellData(5, Constant.pesquisaBarraErro));
		homePage.pesquisar(txt_Pesquisa);

		/*
		 * Comandos responsaveis por receber os valores necessários para acionar o
		 * assert.
		 */
		String elemento = ExcelUtils.getCellData(5, Constant.pesquisaBarraErro);
		String resposta = homePage.result_Produto.getText();
		/* Comando responsavel por conferir se o teste agiu como o esperado. */
		Assert.assertTrue(resposta.equals("No results for " + "\"" + elemento + "\""),
				"Nenhum resultado encontrado para " + elemento + "!");
	}

	/* @ responsaverl por executar todos os elementos depois do @Test. */
	@AfterMethod
	public void fim() throws Exception {
		Prints.tirarPrintsDeFalha("ConsultaPorBarraDePesquisaErrado ", driver);
		DriverFactory.fechaBrowser(driver);
	}

}
