package pruebas;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class Contacto {
	
	
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
		
		
		wait.until(ExpectedConditions.urlToBe("https://opencart.abstracta.us/index.php?route=account/login"));
		
		
		WebElement email = driver.findElement(By.id("input-email"));
		WebElement pass = driver.findElement(By.id("input-password"));
		WebElement send = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
		email.sendKeys("au33032@gmail.com");
		pass.sendKeys("luisandres");
		send.click();
		
		wait.until(ExpectedConditions.urlToBe("https://opencart.abstracta.us/index.php?route=account/account"));
		
		WebElement btnedit = driver.findElement(By.xpath("/html/body/footer/div/div/div[2]/ul/li[1]/a"));
		btnedit.click();
		wait.until(ExpectedConditions.urlToBe("https://opencart.abstracta.us/index.php?route=information/contact"));
		
		WebElement txtarea = driver.findElement(By.id("input-enquiry"));
		
		txtarea.sendKeys("Hola, quisiera saber porque no es posible compras mas de 3 productos, por alguna razon la paginas de un error.");
		
		WebElement btnsend = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input"));
		btnsend.click();
		
		wait.until(ExpectedConditions.urlToBe("https://opencart.abstracta.us/index.php?route=information/contact/success"));
		
		String urlActual = driver.getCurrentUrl();	
		
		if (urlActual.toLowerCase().equals("https://opencart.abstracta.us/index.php?route=information/contact/success")) {
		    System.out.println("Mensaje enviado correctamente");
		} else {
		    System.out.println("Mensaje no enviado");
		}
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
 
 
}
