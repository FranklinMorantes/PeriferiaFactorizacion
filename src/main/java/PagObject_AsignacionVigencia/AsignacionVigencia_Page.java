package PagObject_AsignacionVigencia;

import java.io.File;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import MapObject_AsignacionVigencia.AsignacionVigencia_Maps;
import MapObject_Login.Login;

import io.qameta.allure.Step;


public class AsignacionVigencia_Page extends AsignacionVigencia_Maps {
	
	public AsignacionVigencia_Page(WebDriver driver) {
		super(driver);
	}

	//LLAMAR URL
	@Step("Ingreso a la pagina http://120.11.10.50/FlGuiaUnicaTest/home")
	public AsignacionVigencia_Page Periferia(String url) {
		driver.get(url);
		return new AsignacionVigencia_Page(driver);
	}
	
	//comentario 
	@Step("Metodo para acceder a modulo Asignacion vigencia")
	public AsignacionVigencia_Page Modulo_Vigencia(File folderPath, String usuario, String contrasenna) {
		
		
		
		
		time(2);
		click(CerrarVentana, folderPath, "Cerrar ventana emergente de error", 2);
		//Iframe para eliminar pantalla superpuesta
		iFrame(Frame2,folderPath, "Se cierra iframe",2);
		click(ModAsignacion, folderPath, "Click metodo asignacion vigencia", 3);
		//iFrame(Frame1, folderPath, "Se cierra iframe",2);
		//click(Descarga, folderPath, " clic Boton descarga", 2);
		//List<WebElement> x = driver.findElements(Metodo);
		//drop=select(x);
		//writeText(txtUsuario, usuario, folderPath, "Se ingresa usuario");
		//time(1);
		//click(BtnSiguiente, folderPath, "");
		//time(1);
		//writeText(txtContrase_a,contrasenna, folderPath,"");
		//time(2);
		//click(btnLogin, folderPath, "click login");
		//time(1);
		//click(NoMostrar, folderPath, "click en no mostrar");
		//time(6);
		return this;
	}

	//comentario 
		@Step("Metodo para acceder a modulo Asignacion vigencia")
		public AsignacionVigencia_Page SeleccionarFecha(File folderPath, String usuario, String contrasenna,String Lista) {
			
			
			
			
			time(2);
			iFrame(Frame2,folderPath, "Se cierra iframe",2);
			captureScreen(folderPath, "se visualiza modulo de facturacion cp09");
			captureScreen(folderPath, "se visualiza modulo de modo agrupacion cp10");
			click(FechaDesde, folderPath, "Seleccionar fecha inicial", 2);
			//Iframe para eliminar pantalla superpuesta
			//click(Fecha1, folderPath, "Seleccionar fecha inicial", 3);
			//iFrame(Frame1, folderPath, "Se cierra iframe",2);
			//iFrame(Frame2,folderPath, "Se cierra iframe",2);
			click(FechaHasta, folderPath, " Seleccionar fecha final", 2);
			//click(AportesLinea, folderPath, " Seleccionar fecha final", 2);
			//selectElementList(AportesLinea, Lista, folderPath, "se selecciona aportes en linea",2);
			click(AportesLinea, folderPath, " Cliente", 2);
			click(AportesLinea1, folderPath, " Seleccionar cliente", 2);
			iFrame(Frame3,folderPath, "Se cierra iframe",2);
			//selectElementList(AportesLinea, Lista, folderPath, "se selecciona aportes en linea",2);
			selectElementRow(AportesLinea1, folderPath, "lista variable ");
			time(4);
			
			//iFrame(Frame2,folderPath, "Se cierra iframe",2);
			//click(Fecha2, folderPath, " Seleccionar fecha final", 2);
			
			
			//List<WebElement> x = driver.findElements(Metodo);
			//drop=select(x);
			//writeText(txtUsuario, usuario, folderPath, "Se ingresa usuario");
			//time(1);
			//click(BtnSiguiente, folderPath, "");
			//time(1);
			//writeText(txtContrase_a,contrasenna, folderPath,"");
			//time(2);
			//click(btnLogin, folderPath, "click login");
			//time(1);
			//click(NoMostrar, folderPath, "click en no mostrar");
			//time(6);
			return this;
		}


	private Object select(List<WebElement> x) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
	//@Step("Metodo para salir de Guia Unica")
	//public void salir(File folderPath) {
	//	click(btnSalir, folderPath, "Se cierra la sesion");
	//}

}
