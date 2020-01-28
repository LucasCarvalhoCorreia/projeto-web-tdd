package br.com.rsinet.hub_tdd.testes.falhas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.utils.PegaMassa;
import br.com.rsinet.hub_tdd.pageFactory.CadastroPage;
import br.com.rsinet.hub_tdd.pageFactory.HomePage;
import br.com.rsinet.hub_tdd.utils.Constantes;
import br.com.rsinet.hub_tdd.utils.DriverFactory;
import br.com.rsinet.hub_tdd.utils.DriverFactory.DriverType;
import br.com.rsinet.hub_tdd.utils.ExcelUtils;
import br.com.rsinet.hub_tdd.utils.Prints;

public class CadastroErrado {

	private WebDriver driver;
	private HomePage homePage;
	private CadastroPage cadastroPage;
	private PegaMassa pegaMassa;

	/* Área responsavel pelos testes de falha. */

	/* @ responsavel por executar todos os elementos antes do @Test. */
	@BeforeMethod
	public void inicio() throws Exception {
		driver = DriverFactory.iniciaBrowser(DriverType.Chrome, Constantes.URL);

		/* Comando responsavel por ler o arquivo e aba do excel especificados. */
		ExcelUtils.setExcelFile(Constantes.Path_TestData + Constantes.File_TestData, "Cadastro");
		/*
		 * Comando responsavel por iniciar os elementos dentro da pageFactory
		 * especificada.
		 */
		homePage = PageFactory.initElements(driver, HomePage.class);
		cadastroPage = PageFactory.initElements(driver, CadastroPage.class);
		pegaMassa = new PegaMassa();
	}

	/* @ responsavel por executar a pilha de testes. */
	@Test
	public void cadastroComPreenchimentoDeDadosIncorretos() throws Exception {
		homePage.bt_UserIcon();

		homePage.bt_CriarNovaConta();

		/*
		 * Atribui o valor recebido pela coluna e linha especificada no arquivo excel a
		 * uma variavel
		 */
		cadastroPage.cadastrarUsuario(pegaMassa.UserName(), pegaMassa.Email(), pegaMassa.Password(),
				pegaMassa.ConfirmPasswordErrado(), pegaMassa.FirstName(), pegaMassa.LastName(), pegaMassa.Telefone(),
				pegaMassa.Pais(), pegaMassa.Cidade(), pegaMassa.Endereco(), pegaMassa.Estado(), pegaMassa.Cep());

		cadastroPage.check_Offers();
		cadastroPage.check_Agree();
		cadastroPage.bt_Registrar();

		String txt_ChangePassword = pegaMassa.ConfirmPasswordErrado();
		cadastroPage.clear();
		cadastroPage.mudaSenha(txt_ChangePassword);

		cadastroPage.clicaPassword();

		/*
		 * Comandos responsaveis por receber os valores necessários para acionar o
		 * assert.
		 */
		String condicao = pegaMassa.CondicaoAssertCadastroErro();
		String mensagem = pegaMassa.MenssagemAssertCadastroErro();
		String pass = cadastroPage.not_Password.getText();
		/* Comando responsavel por conferir se o teste agiu como o esperado. */
		Assert.assertTrue(pass.equals(condicao), mensagem);
	}

	/* @ responsaverl por executar todos os elementos depois do @Test. */
	@AfterMethod
	public void fim() throws Exception {
		Prints.tirarPrintsDeFalha("CadastroErrado ", driver);
		DriverFactory.fechaBrowser(driver);
	}

}
