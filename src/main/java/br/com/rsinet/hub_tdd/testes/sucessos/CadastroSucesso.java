package br.com.rsinet.hub_tdd.testes.sucessos;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.pageFactory.CadastroPage;
import br.com.rsinet.hub_tdd.pageFactory.HomePage;
import br.com.rsinet.hub_tdd.utils.Constant;
import br.com.rsinet.hub_tdd.utils.DriverFactory;
import br.com.rsinet.hub_tdd.utils.ExcelUtils;
import br.com.rsinet.hub_tdd.utils.Prints;

public class CadastroSucesso extends DriverFactory {

	private WebDriver driver;
	private HomePage homePage;
	private CadastroPage cadastroPage;

	/* Área responsavel pelos testes de sucesso. */

	/* @ responsavel por executar todos os elementos antes do @Test. */
	@BeforeMethod
	public void inicio() throws Exception {
		driver = DriverFactory.iniciaBrowser();

		/* Comando responsavel por ler o arquivo e aba do excel especificados. */
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Cadastro");
		/*
		 * Comando responsavel por iniciar os elementos dentro da pageFactory
		 * especificada.
		 */
		homePage = PageFactory.initElements(driver, HomePage.class);
		cadastroPage = PageFactory.initElements(driver, CadastroPage.class);
	}

	/* @ responsavel por executar a pilha de testes. */
	@Test
	public void cadastrarUsuarioNoBanco() throws Exception {
		/*
		 * Comando responsavel por aguardar o tempo especificado entre as linhas de
		 * comando.
		 */
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		homePage.bt_UserIcon();

		homePage.bt_CriarNovaConta();

		/*
		 * Atribui o valor recebido pela coluna e linha especificada no arquivo excel a
		 * uma variavel
		 */
		String txt_UserName = ExcelUtils.getCellData(1, Constant.userName);
		String txt_Email = ExcelUtils.getCellData(2, Constant.email);
		String txt_Password = ExcelUtils.getCellData(3, Constant.password);
		String txt_ConfirmPassword = ExcelUtils.getCellData(4, Constant.confirmPassword);
		String txt_FirstName = ExcelUtils.getCellData(6, Constant.firstName);
		String txt_LastName = ExcelUtils.getCellData(7, Constant.lastName);
		String txt_Telefone = ExcelUtils.getCellData(8, Constant.telefone);
		String combo_Pais = ExcelUtils.getCellData(9, Constant.pais);
		String txt_Cidade = ExcelUtils.getCellData(10, Constant.cidade);
		String txt_Endereco = ExcelUtils.getCellData(11, Constant.endereco);
		String txt_Estado = ExcelUtils.getCellData(12, Constant.estado);
		String txt_Cep = ExcelUtils.getCellData(13, Constant.cep);

		cadastroPage.cadastrarUsuario(txt_UserName, txt_Email, txt_Password, txt_ConfirmPassword, txt_FirstName,
				txt_LastName, txt_Telefone, combo_Pais, txt_Cidade, txt_Endereco, txt_Estado, txt_Cep);

		cadastroPage.check_Offers();
		cadastroPage.check_Agree();
		cadastroPage.bt_Registrar();

		String condicao = ExcelUtils.getCellData(1, Constant.userName);
		String mensagem = ExcelUtils.getCellData(3, Constant.mensagemAssertCadastroSucesso);

		/*
		 * Comandos responsaveis por receber os valores necessários para acionar o
		 * assert.
		 */
		cadastroPage.pega_UserLogon(driver);
		String pass = cadastroPage.user_Logon.getText();
		/* Comando responsavel por conferir se o teste agiu como o esperado. */
		Assert.assertTrue(pass.equals(condicao), mensagem);
	}

	/* @ responsaverl por executar todos os elementos depois do @Test. */
	@AfterMethod
	public void fim() throws Exception {
		Prints.tirarPrintsDeSucesso("CadastroSucesso ", driver);
		DriverFactory.fechaBrowser(driver);
	}

}
