package pruebas;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindProduct {
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search\"]/input")));
		
		WebElement barnav = driver.findElement(By.xpath("//*[@id=\"search\"]/input"));
		WebElement btnbusq = driver.findElement(By.xpath("//*[@id=\"search\"]/span/button"));
		

		barnav.sendKeys("samsung");
		btnbusq.click();

		 /**
	     * De esta manera se espera a que el contenido del elemento h1 aparezca.
	     */
		//wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/h1")));
		
		
		/**
	     * De esta manera se espera a que la ruta contenga samsung.
	     */
		wait.until(ExpectedConditions.urlContains("route=product/search&search=samsung"));
		
		/**
	     * se trae el titulo del primer producto.
	     */
		WebElement title = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[1]/h4/a"));
		/**
	     * se compara con lo que estamos buscando, luego se imprime en consola para saber si fue exitoso.
	     */
		if (title.getText().toLowerCase().contains("samsung")) {
            System.out.println("La búsqueda se realizó correctamente.");
        } else {
            System.out.println("La búsqueda no se realizó correctamente.");
        }
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,250)", "");
				
		
	}
	@After
	public void tearDown()
	{
		driver.quit();
	}
}
