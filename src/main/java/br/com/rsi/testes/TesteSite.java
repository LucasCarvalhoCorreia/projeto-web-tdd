package br.com.rsi.testes;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteSite {

	private WebDriver driver;

	@Before
	public void inicia() {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

	}

//	@Test
//	public void Cadastro() {
//
//		driver.get("http://advantageonlineshopping.com/#/");
//
//		WebDriverWait waitbt = new WebDriverWait(driver, 20);
//		WebElement bt = waitbt.until(ExpectedConditions.elementToBeClickable(By.id("hrefUserIcon")));
//		bt.click();
//
//		WebDriverWait waitCA = new WebDriverWait(driver, 10);
//		WebElement CA = waitCA.until(ExpectedConditions.elementToBeClickable(By.linkText("CREATE NEW ACCOUNT")));
//		CA.click();
//
//		WebDriverWait waitUser = new WebDriverWait(driver, 10);
//		WebElement User = waitUser.until(ExpectedConditions.elementToBeClickable(By.name("usernameRegisterPage")));
//		User.sendKeys("lucascarvalho");
//
//		driver.findElement(By.name("emailRegisterPage")).sendKeys("lucas.carvalho99@hotmail.com");
//
//		driver.findElement(By.name("passwordRegisterPage")).sendKeys("10203040Lcc");
//
//		driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys("10203040Lcc");
//
//		driver.findElement(By.name("first_nameRegisterPage")).sendKeys("Lucas");
//
//		driver.findElement(By.name("last_nameRegisterPage")).sendKeys("Carvalho Correia");
//
//		driver.findElement(By.name("phone_numberRegisterPage")).sendKeys("967553055");
//
//		WebElement Country = driver.findElement(By.name("countryListboxRegisterPage"));
//		Country.click();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		Select comboBox = new Select(Country);
//		comboBox.selectByValue("object:139");
//
//		driver.findElement(By.name("cityRegisterPage")).sendKeys("Guarulhos");
//
//		driver.findElement(By.name("addressRegisterPage")).sendKeys("lucinda fernandes carlos");
//
//		driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys("São Paulo");
//
//		driver.findElement(By.name("postal_codeRegisterPage")).sendKeys("07085310");
//
//		driver.findElement(By.name("allowOffersPromotion")).click();
//
//		driver.findElement(By.name("i_agree")).click();
//
//		driver.findElement(By.id("register_btnundefined")).click();
//
//	}

//	@Test
//	public void ConsultaMassa() {
//		
//		driver.get("http://advantageonlineshopping.com/#/");
//		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.findElement(By.id("laptopsImg")).click();
//		
//		driver.findElement(By.linkText("HP Chromebook 14 G1(ES)")).click();
//
//	}

	@Test
	public void ConsultaPesquisa() {
		
		driver.get("http://advantageonlineshopping.com/#/");

	}

	@After
	public void fecha() {
//		driver.quit();
	}

}
