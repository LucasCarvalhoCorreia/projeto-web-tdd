package br.com.rsi.tdd.passes;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestePasses {

	private WebDriver driver;

	@Before
	public void inicia() {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

	}

	@Test
	public void Cadastro() throws InterruptedException {

		driver.get("http://advantageonlineshopping.com/#/");
		
		Thread.sleep(4000);
		driver.findElement(By.id("hrefUserIcon")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.linkText("CREATE NEW ACCOUNT")).click();
		
		WebDriverWait waitUser = new WebDriverWait(driver, 10);
		WebElement User = waitUser.until(ExpectedConditions.elementToBeClickable(By.name("usernameRegisterPage")));
		User.sendKeys("lucascarvalho");

		driver.findElement(By.name("emailRegisterPage")).sendKeys("lucas.carvalho99@hotmail.com");

		driver.findElement(By.name("passwordRegisterPage")).sendKeys("10203040Lcc");

		driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys("10203040Lcc");

		driver.findElement(By.name("first_nameRegisterPage")).sendKeys("Lucas");

		driver.findElement(By.name("last_nameRegisterPage")).sendKeys("Carvalho Correia");

		driver.findElement(By.name("phone_numberRegisterPage")).sendKeys("967553055");

		WebElement Country = driver.findElement(By.name("countryListboxRegisterPage"));
		Country.click();
		Select comboBox = new Select(Country);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		comboBox.selectByVisibleText("Brazil");

		driver.findElement(By.name("cityRegisterPage")).sendKeys("Guarulhos");

		driver.findElement(By.name("addressRegisterPage")).sendKeys("lucinda fernandes carlos");

		driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys("São Paulo");

		driver.findElement(By.name("postal_codeRegisterPage")).sendKeys("07085310");

		driver.findElement(By.name("allowOffersPromotion")).click();

		driver.findElement(By.name("i_agree")).click();

		driver.findElement(By.id("register_btnundefined")).click();

	}

	@Test
	public void ConsultaMassa() {
		
		driver.get("http://advantageonlineshopping.com/#/");
		
		WebDriverWait waitImg = new WebDriverWait(driver, 10);
		WebElement Img = waitImg.until(ExpectedConditions.elementToBeClickable(By.id("laptopsImg")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Img.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("HP Chromebook 14 G1(ES)")).click();

	}

	@Test
	public void ConsultaPesquisa() {
		
		driver.get("http://advantageonlineshopping.com/#/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("menuSearch")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("autoComplete")).sendKeys("HP CHROMEBOOK 14 G1(ENERGY STAR)");
		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.findElement(By.xpath("//*[@id=\"output\"]/div/div[2]/a[2]/p")).click();

	}

	@After
	public void fecha() {
		driver.quit();
	}

}
