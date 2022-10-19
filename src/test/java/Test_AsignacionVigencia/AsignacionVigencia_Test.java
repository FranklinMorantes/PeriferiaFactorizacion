package Test_AsignacionVigencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import Utilidades.BasePage;
import Utilidades.ReportePDF;
import UtilidadesTest.BaseTest;
import UtilidadesTest.MyScreenRecorder;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class AsignacionVigencia_Test extends BaseTest {
	
	
	//MANEJE UNA EJECION CONTROLADA TENIENDO EN CUENTA LA DATA UBICADA EN EL ARCHIVO PROPERTIES
	public Properties fileprops = new Properties();
	public Properties getProperties()  {
		try {
			fileprops.load(new FileInputStream(new File("./src/test/resources/properties/Account/login.properties").getAbsolutePath()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			return fileprops;
		}
	
	
	
	public void loginRecursion(File folderPath, String nameTest, String usuario, String contrasenna) {
		MyScreenRecorder.starRecording(nameTest, 
				   					   folderPath,
				   					   getProperties().getProperty("evidenceRecording"));
		ReportePDF.createTemplate(folderPath,
								  nameTest, 
								  getProperties().getProperty("evidencePDF"),
								  getProperties().getProperty("analista"),
								  getProperties().getProperty("url"));
		login.Periferia(getProperties().getProperty("url"));
		login.inicioDeSesion(folderPath,
							 usuario,
							 contrasenna);
	}	
	
	
	@Severity(SeverityLevel.NORMAL)
    @Story("Modulo Inicio Sesion")
	@Description("Caso de prueba para inicio de sesion")
	@Test(priority=0)
	public void inicioDeSesion_Test() {
		String nameTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		File folderPath = BasePage.createFolder(nameTest,
												getProperties().getProperty("path"));
		loginRecursion(folderPath,
					   nameTest,
				   	   getProperties().getProperty("usuario"),
				   	   getProperties().getProperty("contrasenna"));
		asignacion.Modulo_Vigencia(folderPath, nameTest, nameTest);
		
		
		//login.salir(folderPath);
		MyScreenRecorder.StopRecording();
		ReportePDF.closeTemplate();
	}
	
	@Severity(SeverityLevel.NORMAL)
    @Story("Guardar en modulo asignacion vigencia CP04")
	@Description("Caso de prueba para inicio de sesion")
	@Test(priority=1)
	public void GuardarMetodoVigencia() {
		String nameTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		File folderPath = BasePage.createFolder(nameTest,
												getProperties().getProperty("path"));
		loginRecursion(folderPath,
					   nameTest,
				   	   getProperties().getProperty("usuario"),
				   	   getProperties().getProperty("contrasenna"));
		asignacion.Modulo_Vigencia(folderPath, nameTest, nameTest);
		
		
		//login.salir(folderPath);
		MyScreenRecorder.StopRecording();
		ReportePDF.closeTemplate();
	}
	

	

}
