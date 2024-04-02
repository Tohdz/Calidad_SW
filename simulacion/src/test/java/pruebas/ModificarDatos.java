package pruebas;
import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class ModificarDatos {
	
	
	private WebDriver driver;
 
	@Before
	public void setUp()
	{
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(60));
		driver.get("https://opencart.abstracta.us/index.php?route=common/home");
	}
	
	@Test
	public void ongoing()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")));
		
		WebElement btnuser = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a"));
		WebElement btnlogin = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
		btnuser.click();
		btnlogin.click();
		
		/**
	     * De esta manera se espera a que sea la ruta de login.
	     */
		wait.until(ExpectedConditions.urlToBe("https://opencart.abstracta.us/index.php?route=account/login"));
		
		
		WebElement email = driver.findElement(By.id("input-email"));
		WebElement pass = driver.findElement(By.id("input-password"));
		WebElement send = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
		email.sendKeys("rodriguezugarteluisandres@gmail.com");
		pass.sendKeys("luisandres");
		send.click();
		//rodriguezugarteluisandres@gmail.com
		
		wait.until(ExpectedConditions.urlToBe("https://opencart.abstracta.us/index.php?route=account/account"));
		
		WebElement btnedit = driver.findElement(By.xpath("//*[@id=\"content\"]/ul[1]/li[1]/a"));
		btnedit.click();
		wait.until(ExpectedConditions.urlToBe("https://opencart.abstracta.us/index.php?route=account/edit"));
		WebElement txtnombre = driver.findElement(By.xpath("//*[@id=\"input-firstname\"]"));
		WebElement txtapellido = driver.findElement(By.xpath("//*[@id=\"input-lastname\"]"));
		WebElement txtemail = driver.findElement(By.xpath("//*[@id=\"input-email\"]"));
		WebElement txttelefono = driver.findElement(By.xpath("//*[@id=\"input-telephone\"]"));
	    // Borra el texto actual en los campos antes de ingresar nuevos valores
	    txtnombre.clear();
	    txtapellido.clear();
	    txtemail.clear();
	    txttelefono.clear();

		
		txtnombre.sendKeys("Juan");
		txtapellido.sendKeys("Ugarte");
		txtemail.sendKeys("au33032@gmail.com");
		txttelefono.sendKeys("88888888");
		//au33032@gmail.com
	
				
		WebElement btnsumit = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input"));
		btnsumit.click();
		
		wait.until(ExpectedConditions.urlToBe("https://opencart.abstracta.us/index.php?route=account/account"));
		
		String urlActual = driver.getCurrentUrl();
				
		
		if (urlActual.toLowerCase().equals("https://opencart.abstracta.us/index.php?route=account/account")) {
		    System.out.println("Se modificó correctamente");
		} else {
		    System.out.println("No se ha modificado");
		}
	}
	@After
	public void tearDown()
	{
		driver.quit();
	}
 
 
}