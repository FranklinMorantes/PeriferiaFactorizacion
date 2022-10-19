package PagObject_Login;

import java.io.File;

import org.openqa.selenium.WebDriver;

import MapObject_Login.Login;

import io.qameta.allure.Step;


public class Login_Page extends Login {
	
	public Login_Page(WebDriver driver) {
		super(driver);
	}


	@Step("Ingreso a la pagina http://120.11.10.50/FlGuiaUnicaTest/home")
	public Login_Page Periferia(String url) {
		driver.get(url);
		return new Login_Page(driver);
	}
	
	
	@Step("Metodo para iniciar sesion en Guia Unica")
	public Login_Page inicioDeSesion(File folderPath, String usuario, String contrasenna) {
		
		
		
		
		time(2);
		writeText(txtUsuario, usuario, folderPath, "Se ingresa usuario", 1);
		click(BtnSiguiente, folderPath, "", 1);
		writeText(txtContrase_a,contrasenna, folderPath,"", 1);
		time(2);
		click(btnLogin, folderPath, "click login", 1);
		click(NoMostrar, folderPath, "click en no mostrar", 6);
	
		return this;
	}


	
	
	
	//@Step("Metodo para salir de Guia Unica")
	//public void salir(File folderPath) {
	//	click(btnSalir, folderPath, "Se cierra la sesion");
	//}

}
