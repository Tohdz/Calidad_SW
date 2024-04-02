package pruebas;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.edge.EdgeDriver;




public class Compatibilidad {
	private WebDriver chromeDriver;
    private WebDriver firefoxDriver;
    private WebDriver edgeDriver;
	
	@Before
	public void setUp(){
		   // Se configura el sistema para usar los controladores de los navegadores
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver/geckodriver.exe");
        System.setProperty("webdriver.edge.driver", "./src/test/resources/msedgedriver/msedgedriver.exe");

        // Se crea instancias de WebDriver para Chrome, Firefox y Edge
        chromeDriver = new ChromeDriver();
        firefoxDriver = new FirefoxDriver();
        edgeDriver = new EdgeDriver();
	}
	
	@Test
    public void testCompatibilidadChrome() {
		WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(30));
		
		chromeDriver.get("https://opencart.abstracta.us/index.php?route=common/home");
		
		wait.until(ExpectedConditions.urlToBe("https://opencart.abstracta.us/index.php?route=common/home"));
		
        String urlActual = chromeDriver.getCurrentUrl();	
		
		if (urlActual.toLowerCase().equals("https://opencart.abstracta.us/index.php?route=common/home")) {
		    System.out.println("Pagina cargada correctamente");
		} else {
		    System.out.println("No se cargo la pagina");
		}
    }

    @Test
    public void testCompatibilidadFirefox() {
        WebDriverWait wait = new WebDriverWait(firefoxDriver, Duration.ofSeconds(30));
		
        firefoxDriver.get("https://opencart.abstracta.us/index.php?route=common/home");
		
		wait.until(ExpectedConditions.urlToBe("https://opencart.abstracta.us/index.php?route=common/home"));
		
        String urlActual = firefoxDriver.getCurrentUrl();	
		
		if (urlActual.toLowerCase().equals("https://opencart.abstracta.us/index.php?route=common/home")) {
		    System.out.println("Pagina cargada correctamente");
		} else {
		    System.out.println("No se cargo la pagina");
		}
    }

    @Test
    public void testCompatibilidadEdge() {
        WebDriverWait wait = new WebDriverWait(edgeDriver, Duration.ofSeconds(30));
		
        edgeDriver.get("https://opencart.abstracta.us/index.php?route=common/home");
		
		wait.until(ExpectedConditions.urlToBe("https://opencart.abstracta.us/index.php?route=common/home"));
		
        String urlActual = edgeDriver.getCurrentUrl();	
		
		if (urlActual.toLowerCase().equals("https://opencart.abstracta.us/index.php?route=common/home")) {
		    System.out.println("Pagina cargada correctamente");
		} else {
		    System.out.println("No se cargo la pagina");
		}
    }

	@After
	public void tearDown() {
		chromeDriver.quit();
        firefoxDriver.quit();
        edgeDriver.quit();
	}
}
