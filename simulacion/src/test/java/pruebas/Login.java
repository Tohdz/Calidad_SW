package pruebas;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;





public class Login {
	
	
	private WebDriver driver;

	@Before
	public void setUp()
	{
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		//Se carga y se ubica el driver para abrir Chrome
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver(co);
		//Maximiza la pantalla
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(60));
		//Se pasa la URL de la página a testear
		driver.get("https://opencart.abstracta.us/index.php?route=account/login");
	}
	
	@Test
	public void login()
	{
		
		//Se buscan los input por ID
		WebElement correoUsuario = driver.findElement(By.id("input-email"));
		WebElement contrasena = driver.findElement(By.id("input-password"));
		//Se busca el boton de login por Xpath
		WebElement btningresar = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
		
	
		//Se rellanan los inputs
		correoUsuario.sendKeys("opsimulacion@gmail.com");
		contrasena.sendKeys("opencartsimulacion");
		//Se clickea el boton de login
		btningresar.click();
	
		
	}
	@After
	public void tearDown()
	{
		driver.quit();
	}


}

