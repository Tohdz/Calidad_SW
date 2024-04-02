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

public class Registro {
	
	
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
		driver.get("https://opencart.abstracta.us/index.php?route=account/register");
	}
	
	@Test
	public void registro()
	{
		
		//Se buscan los input por ID
		WebElement primerNombre = driver.findElement(By.id("input-firstname"));
		WebElement apellido = driver.findElement(By.id("input-lastname"));
		WebElement correo = driver.findElement(By.id("input-email"));
		WebElement telefono = driver.findElement(By.id("input-telephone"));
		WebElement contrasena = driver.findElement(By.id("input-password"));
		WebElement confirmaContrasena = driver.findElement(By.id("input-confirm"));
		//Se busca el boton de login por Xpath
		WebElement btnRegistrar = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
		WebElement checkPoliticas = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]"));
	
		int i = 0;
		int consecutivo = 0;
		
		for(i=0;i<10;i++) {
			consecutivo = consecutivo+1;
		}
		
		//Se rellanan los inputs
		primerNombre.sendKeys("OpenCart" + consecutivo);
		apellido.sendKeys("Simulacion" + consecutivo);
		correo.sendKeys("opsimulacion@gmail.com" + consecutivo);
		telefono.sendKeys("88888888");
		contrasena.sendKeys("opencartsimulacion" + consecutivo);
		confirmaContrasena.sendKeys("opencartsimulacion2" + consecutivo);
		

		//Se clickea el boton de login
		checkPoliticas.click();
		btnRegistrar.click();
		
	
		
	}
	@After
	public void tearDown()
	{
		driver.quit();
	}


}

