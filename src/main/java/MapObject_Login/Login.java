package MapObject_Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilidades.BasePage;

public class Login extends BasePage {

	public Login(WebDriver driver) {
		super(driver);
	}
	
	
	protected By txtUsuario=By.xpath("//*[@id='i0116']");  
	protected By BtnSiguiente=By.xpath("//*[@id='idSIButton9']");  
	protected By txtContrase_a=By.xpath("//*[@id='i0118']");
	protected By btnLogin=By.xpath("//*[@id='idSIButton9']");
	protected By NoMostrar=By.xpath("//*[@id='idBtn_Back']");
	


}
