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





public class Rendimiento {
	private WebDriver driver;
	
	@Before
	public void setUp(){
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(60));
		
	}
	
	@Test
	public void ongoing() {
		long inicio = System.currentTimeMillis();

        // Para navegar en la pagina
        driver.get("https://opencart.abstracta.us/index.php?route=common/home");

        long fin = System.currentTimeMillis();
        long tiempoDeCarga = fin - inicio;

        System.out.println("Tiempo de carga en Chrome: " + tiempoDeCarga + " milisegundos");
    }
	
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
