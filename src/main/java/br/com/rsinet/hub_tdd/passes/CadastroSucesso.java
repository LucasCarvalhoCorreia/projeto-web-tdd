package br.com.rsinet.hub_tdd.passes;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.com.rsinet.hub_tdd.util.Utilidades;

public class CadastroSucesso extends Utilidades {

	@Before
	public void inicio() throws InterruptedException {
		iniciaBrowser();
	}

	@Test
	public void cadastro() throws Exception {
		criarNovaConta();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.name("usernameRegisterPage")).sendKeys("lucascarvalhoo");

		driver.findElement(By.name("emailRegisterPage")).sendKeys("lucas.carvalho99@hotmail.com");

		driver.findElement(By.name("passwordRegisterPage")).sendKeys("10203040Lcc");

		driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys("10203040Lcc");

		driver.findElement(By.name("first_nameRegisterPage")).sendKeys("Lucas");

		driver.findElement(By.name("last_nameRegisterPage")).sendKeys("Carvalho Correia");

		driver.findElement(By.name("phone_numberRegisterPage")).sendKeys("967553055");

		WebElement Country = driver.findElement(By.name("countryListboxRegisterPage"));
		Country.click();

		Select comboBox = new Select(Country);

		comboBox.selectByVisibleText("Brazil");

		driver.findElement(By.name("cityRegisterPage")).sendKeys("Guarulhos");

		driver.findElement(By.name("addressRegisterPage")).sendKeys("lucinda fernandes carlos");

		driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys("São Paulo");

		driver.findElement(By.name("postal_codeRegisterPage")).sendKeys("07085310");

		driver.findElement(By.name("allowOffersPromotion")).click();

		driver.findElement(By.name("i_agree")).click();

		driver.findElement(By.id("register_btnundefined")).click();
		
		tirarPrintsDeSucesso("Cadastro");
	}

	@After
	public void fim() {
		fechaBrowser();
	}

}
