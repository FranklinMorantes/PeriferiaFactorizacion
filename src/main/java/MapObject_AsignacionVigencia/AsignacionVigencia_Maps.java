package MapObject_AsignacionVigencia;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilidades.BasePage;

public class AsignacionVigencia_Maps extends BasePage {

	
	
	public AsignacionVigencia_Maps(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		
	}
	
	
	protected By DivPrincipal=By.xpath("/html[1]/body[1]/div[3]/iframe[1]"); 
	protected By Frame1=By.xpath("//*[@class='publishedAppContainer']//iframe[1]"); 
	protected By Metodo=By.xpath("//*[@class='appmagic-label-text']"); 
	protected By Menu=By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div[36]/div/div/div/div"); 
	protected By Frame2=By.xpath("/html/body/div[3]/iframe"); 
	protected By Descarga=By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div[29]/div/div/div/div/button/div/div"); 
	
	
	
	
	//iframe[@id='fullscreen-app-host']
	protected By CerrarVentana=By.xpath("//div[@id='toast-container']/div/button/span"); 
	protected By ModAsignacion=By.xpath("//*[@id='publishedCanvas']/div/div[2]/div/div/div[2]/div/div/div/div/div"); 
	protected By txtUsuario=By.xpath("//*[@id='i0116']");  
	protected By BtnSiguiente=By.xpath("//*[@id='idSIButton9']");  
	protected By txtContrase_a=By.xpath("//*[@id='i0118']");
	protected By btnLogin=By.xpath("//*[@id='idSIButton9']");
	
	
	protected By NoMostrar=By.xpath("//*[@id='idBtn_Back']");
	protected By ModAsignacion1=By.xpath("/html[1]/body[1]/div[3]/iframe[1]"); 
	//protected By ModAsignacion1=By.cssSelector("#publishedCanvas > div > div:nth-child(2) > div > div > div:nth-child(2)"); 
	protected By ModAsignacion2=By.xpath("//*[@id=\"publishedCanvas\"]/div/div[2]/div/div/div[2]/div"); 
	protected By ModAsignacion3=By.xpath("//*[@id=\"publishedCanvas\"]/div/div[2]/div/div/div[2]/div/div"); 
	protected By ModAsignacion4=By.xpath("//*[@id=\"publishedCanvas\"]/div/div[2]/div/div/div[2]/div/div/div"); 
	protected By ModAsignacion5=By.xpath("//*[@id=\"publishedCanvas\"]/div/div[2]/div/div/div[2]/div/div/div/div"); 
	
	

}
