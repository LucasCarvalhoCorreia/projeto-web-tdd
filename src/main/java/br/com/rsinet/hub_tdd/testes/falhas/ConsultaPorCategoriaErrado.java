package br.com.rsinet.hub_tdd.testes.falhas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.pageFactory.HomePage;
import br.com.rsinet.hub_tdd.pageFactory.PesquisaPage;
import br.com.rsinet.hub_tdd.utils.Constant;
import br.com.rsinet.hub_tdd.utils.DriverFactory;
import br.com.rsinet.hub_tdd.utils.ExcelUtils;
import br.com.rsinet.hub_tdd.utils.Prints;

public class ConsultaPorCategoriaErrado extends DriverFactory {

	private WebDriver driver;
	private HomePage homePage;
	private PesquisaPage pesquisaPage;

	/* Área responsavel pelos testes de falha. */

	/* @ responsavel por executar todos os elementos antes do @Test. */
	@BeforeMethod
	public void inicio() throws Exception {
		driver = DriverFactory.iniciaBrowser(DriverType.Chrome, Constant.URL);

		/* Comando responsavel por ler o arquivo e aba do excel especificados. */
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "PesquisaCat");
		/*
		 * Comando responsavel por iniciar os elementos dentro da pageFactory
		 * especificada.
		 */
		homePage = PageFactory.initElements(driver, HomePage.class);
		pesquisaPage = PageFactory.initElements(driver, PesquisaPage.class);
	}

	/* @ responsavel por executar a pilha de testes. */
	@Test
	public void consultaPorCategoriaComQuantidadeAcimaDoPermitidoNoCarrinho() throws Exception {
		homePage.bt_UserIcon();

		/*
		 * Atribui o valor recebido pela coluna e linha especificada no arquivo excel a
		 * uma variavel
		 */
		String txt_UserLogin = ExcelUtils.getCellData(1, Constant.userNameCat);
		String txt_PasswordLogin = ExcelUtils.getCellData(2, Constant.passwordCat);
		homePage.preencheLogin(txt_UserLogin, txt_PasswordLogin);

		homePage.bt_Logar();

		homePage.clicaProdutoCategoria(driver);

		String produto = ExcelUtils.getCellData(5, Constant.clicaProduto);
		pesquisaPage.selecionaProduto(driver, produto).click();

		String txt_Quantidade = ExcelUtils.getCellData(8, Constant.quantidadeCat);
		pesquisaPage.quantidadeProduto(txt_Quantidade);

		pesquisaPage.bt_SalvaProduto();

		pesquisaPage.bt_Comprar();

		/*
		 * Comandos responsaveis por receber os valores necessários para acionar o
		 * assert.
		 */
		String condicao = ExcelUtils.getCellData(4, Constant.condicaoAssertMassaErro);
		String mensagem = ExcelUtils.getCellData(3, Constant.mensagemAssertMassaErro);
		String aviso = pesquisaPage.qtd_Produto.getText();
		/* Comando responsavel por conferir se o teste agiu como o esperado. */
		Assert.assertTrue(aviso.equals(condicao), mensagem);
	}

	/* @ responsaverl por executar todos os elementos depois do @Test. */
	@AfterMethod
	public void fim() throws Exception {
		Prints.tirarPrintsDeFalha("ConsultaPorCategoriaErrado ", driver);
		DriverFactory.fechaBrowser(driver);
	}

}
