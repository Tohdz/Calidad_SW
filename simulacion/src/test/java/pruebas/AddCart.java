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

public class AddCart {
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
		email.sendKeys("hhernan93vargas@gmail.com");
		pass.sendKeys("123456");
		send.click();
		
		wait.until(ExpectedConditions.urlToBe("https://opencart.abstracta.us/index.php?route=account/account"));
		
		WebElement btncate = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/a"));
		WebElement btnelemt = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/div/ul/li[2]/a"));
		btncate.click();
		btnelemt.click();
		
		wait.until(ExpectedConditions.urlToBe("https://opencart.abstracta.us/index.php?route=product/category&path=20_27"));
		
		WebElement btnadd = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]"));
		btnadd.click();
		
		WebElement btncart = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[4]/a"));
		btncart.click();
		
		wait.until(ExpectedConditions.urlToBe("https://opencart.abstracta.us/index.php?route=checkout/cart"));
		
		WebElement btnname = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[2]/a"));
		
		
		if (btnname.getText().toLowerCase()!= null) {
            System.out.println("Se agrego un articulo correctamente.");
        } else {
            System.out.println("No se agrego ningun articulo.");
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
