package UtilidadesTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import PagObject_AsignacionVigencia.AsignacionVigencia_Page;
import PagObject_Login.Login_Page;
import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseTest {

	public WebDriver driver;
	
	//LOGIN
	public Login_Page login;
	public AsignacionVigencia_Page  asignacion;
	//GUIAS RO

	//GUIAS

	
	
	public WebDriver getDriver() {
		return driver;
	}
	

	@BeforeMethod
	@Parameters({"BrowserType"})
	public void inicializar(@Optional("Chrome") String browserType) {
		
		if(browserType.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--windows-size=1920,1080");
			options.addArguments("--start-maximized");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--no-sandbox");
			driver = new ChromeDriver(options);
		}else if(browserType.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--windows-size=1920,1080");
			options.addArguments("--start-maximized");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--no-sandbox");
			driver = new FirefoxDriver(options);
		}else if(browserType.equalsIgnoreCase("MicrosoftEdge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			driver = new EdgeDriver(options);
		}else if(browserType.equalsIgnoreCase("InternetExplorer")) {
			System.setProperty("webdriver.ie.driver", "./src/test/resources/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
		
		//LOGIN
		login = new Login_Page(driver);
		asignacion = new AsignacionVigencia_Page(driver);
		//guiasGeneradas = new GuiasGeneradas_Page(driver);
		//GUIAS
		//generarPedidos = new GeneracionPedidos_Page(driver);
		//consultarPedidos = new ConsultarPedidos_Page(driver);
		
		System.out.println("Opening: " + browserType );
	}
	
	
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}


}
