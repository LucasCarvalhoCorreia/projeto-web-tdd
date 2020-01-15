package br.com.rsinet.hub_tdd.modulos;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_tdd.pageObject.PesquisaPage;
import br.com.rsinet.hub_tdd.util.Constant;
import br.com.rsinet.hub_tdd.util.ExcelUtils;

public class ModuloPesquisa {

	public static void pesquisaCategoria(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, PesquisaPage.class);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		PesquisaPage.bt_Produto.click();

		PesquisaPage.bt_SalvaProduto.click();

		PesquisaPage.bt_Comprar.click();
	}

	public static void pesquisaCategoriaErrada(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, PesquisaPage.class);

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "PesquisaCat");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		PesquisaPage.bt_Produto.click();

		PesquisaPage.txt_Quantidade.sendKeys(ExcelUtils.getCellData(1, Constant.txt_QuantidadeCat));

		PesquisaPage.bt_SalvaProduto.click();

		PesquisaPage.bt_Comprar.click();
	}

	public static void pesquisaPorDescricao(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, PesquisaPage.class);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		PesquisaPage.id_Produto.click();
	}

}
