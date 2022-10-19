package Utilidades;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.itextpdf.text.DocumentException;

public class BasePage {

	public static WebDriver driver;

	WebElement element;
	boolean display = false;
	boolean isPresent = false;
	boolean isEnabled = false;
	String row = null;
	String readText = "";
	String errorLocalizador = "No se encontro el localizador o las properties enviadas son incorrectas";
	String errorBusqueda = "No se encontro el localizador o la busqueda es incorrecta";
	String errorSubirArchivo = "\"No se encontro el localizador o la ubicacion o formato del archivo es incorrecto";
	protected By elementFake = By.xpath("");

	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
	}

	// METODO PARA COMPROBAR SI UN ELEMENTO SE ENCUENTRA Y ES VISIBLE
	public void visibilityOfElementLocated(By elementLocation) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
	}

	// METODO PARA IMPRIMIR POR CONSOLA
	public void print(String text) {
		System.out.println(text);
	}

	// METODO PARA FORZAR UN ERROR EN EL RESULTADO DE EJECUCION
	public void error() {
		driver.findElement(elementFake).click();
	}

	public By localizadorVariable(By locator, String valor) {
		String jj = locator.toString().replace("{0}", valor);
		String kk = jj.replace("By.xpath: ", "");
		By localizador = By.xpath(kk);
		return localizador;
	}

	// METODO PARA DAR CLICK EN UN ELEMENTO
	public void click(By elementLocation, File folderPath, String steps,int tiempo) {
		try {
			visibilityOfElementLocated(elementLocation);
			captureScreen(folderPath, steps);
			driver.findElement(elementLocation).click();
		} catch (Exception e) {
			captureScreen(folderPath, errorLocalizador);
			ReportePDF.closeTemplate(errorLocalizador);
			error();
		}
		time(tiempo);
	}

	// METODO QUE DEVUELVE EL TEXTO DE UN ELEMENTO
	public String readText(By elementLocation, File folderPath, String steps) {
		try {
			visibilityOfElementLocated(elementLocation);
			captureScreen(folderPath, steps);
			readText = driver.findElement(elementLocation).getText();
		} catch (Exception e) {
			captureScreen(folderPath, errorLocalizador);
			ReportePDF.closeTemplate(errorLocalizador);
			error();
		}
		return readText;
	}

	// METODO PARA ESCRIBIR EN UN ELEMENTO
	public void writeText(By elementLocation, String text, File folderPath, String steps, int tiempo) {
		try {
			visibilityOfElementLocated(elementLocation);
			driver.findElement(elementLocation).sendKeys(text);
			captureScreen(folderPath, steps);
		} catch (Exception e) {
			captureScreen(folderPath, errorLocalizador);
			ReportePDF.closeTemplate(errorLocalizador);
			error();
		}
		time(tiempo);
	}

	// METODO PARA DEVOLVER UN ELEMENTO
	public WebElement getElement(By elementLocation, File folderPath, String steps) {
		try {
			visibilityOfElementLocated(elementLocation);
			element = driver.findElement(elementLocation);
			captureScreen(folderPath, steps);
		} catch (Exception e) {
			captureScreen(folderPath, errorLocalizador);
			ReportePDF.closeTemplate(errorLocalizador);
			error();
		}
		return element;
	}

	// METODO ENTER SUBMIN
	public void submit(By elementLocation, File folderPath, String steps) {
		try {
			visibilityOfElementLocated(elementLocation);
			captureScreen(folderPath, steps);
			driver.findElement(elementLocation).submit();
		} catch (Exception e) {
			captureScreen(folderPath, errorLocalizador);
			ReportePDF.closeTemplate(errorLocalizador);
			error();
		}
	}

	// METODO PARA LIMPIAR UN CAMPO
	public void clear(By elementLocation, File folderPath, String steps) {
		try {
			visibilityOfElementLocated(elementLocation);
			driver.findElement(elementLocation).clear();
			captureScreen(folderPath, steps);
		} catch (Exception e) {
			captureScreen(folderPath, errorLocalizador);
			ReportePDF.closeTemplate(errorLocalizador);
			error();
		}
	}

	// METODO PARA COMPROBAR SI UN ELEMENTO SE ENCUENTRA
	public boolean displayed(By elementLocation, File folderPath, String steps, String error) {
		try {
			time(5);
			visibilityOfElementLocated(elementLocation);
			captureScreen(folderPath, steps);
			display = driver.findElement(elementLocation).isDisplayed();
		} catch (Exception e) {
			captureScreen(folderPath, error);
			ReportePDF.closeTemplate(error);
			error();
		}
		return display;
	}

	// METODO PARA COMPROBAR SI UN ELEMENTO SE ENCUENTRA, SIN EVIDENCIA
	public boolean displayed(By elementLocation) {
		time(5);
		display = driver.findElement(elementLocation).isDisplayed();
		return display;
	}

	// METODO PARA COMPROBAR SI UN ELEMENTO ESTA PRESENTE
	public boolean isPresent(By elementLocation, File folderPath, String steps) {
		time(5);
		captureScreen(folderPath, steps);
		isPresent = driver.findElements(elementLocation).size() > 0;
		return isPresent;
	}

	// METODO PARA COMPROBAR SI UN ELEMENTO ESTA PRESENTE, SIN EVIDENCIA
	public boolean isPresent(By elementLocation) {
		time(5);
		isPresent = driver.findElements(elementLocation).size() > 0;
		return isPresent;
	}

	// METODO PARA COMPROBAR SI UN EMLEMENTO SE ENCUENTRA HABILITADO
	public boolean isEnabled(By elementLocation, File folderPath, String steps) {
		try {
			time(5);
			isEnabled = driver.findElement(elementLocation).isEnabled();
			captureScreen(folderPath, steps);
		} catch (Exception e) {
			captureScreen(folderPath, errorLocalizador);
			ReportePDF.closeTemplate(errorLocalizador);
			error();
		}
		return isEnabled;
	}

	// METODO PARA CARGAR UN ARCHIVO DESDE LA MAQUINA
	public void fileUpload(By elementLocation, String filePath, File folderPath, String steps) {
		try {
			visibilityOfElementLocated(elementLocation);
			File file = new File(filePath);
			WebElement ruta = driver.findElement(elementLocation);
			ruta.sendKeys(file.getAbsolutePath());
			captureScreen(folderPath, steps);
		} catch (Exception e) {
			captureScreen(folderPath, errorSubirArchivo);
			ReportePDF.closeTemplate(errorSubirArchivo);
			error();
		}
	}

	// METODO PARA SELECCIONAR UN ELEMENTO DE UNA LISTA
	public void selectElementList(By elementLocation, String valorLista, File folderPath, String steps) {
		try {
			visibilityOfElementLocated(elementLocation);
			Select lista = new Select(driver.findElement(elementLocation));
			time(5);
			lista.selectByVisibleText(valorLista);
			captureScreen(folderPath, steps);
		} catch (Exception e) {
			captureScreen(folderPath, errorLocalizador);
			ReportePDF.closeTemplate(errorLocalizador);
			error();
		}
	}

	// METODO PARA BUSCAR LOS ELEMENTOS DE UNA GRILLA
	public String selectElementRow(By tableResult, File folderPath, String steps) {
		try {
			visibilityOfElementLocated(tableResult);
			captureScreen(folderPath, steps);
			ArrayList<WebElement> resultado = (ArrayList<WebElement>) driver.findElement(tableResult)
					.findElements(By.tagName("td"));
			for (Iterator<WebElement> iterator = resultado.iterator(); iterator.hasNext();) {
				WebElement campo = (WebElement) iterator.next();
				row = campo.getText();
			}
		} catch (Exception e) {
			captureScreen(folderPath, errorBusqueda);
			ReportePDF.closeTemplate(errorBusqueda);
			error();
		}
		return row;
	}

	// METODO PARA BUSCAR UN ELEMENTO EN UNA GRILLA
	public String searchElementGrid(By tableResult, String searchValue, File folderPath, String steps) {
		try {
			visibilityOfElementLocated(tableResult);
			captureScreen(folderPath, steps);
			ArrayList<WebElement> resultado = (ArrayList<WebElement>) driver.findElement(tableResult)
					.findElements(By.tagName("td"));
			for (Iterator<WebElement> iterator = resultado.iterator(); iterator.hasNext();) {
				WebElement campo = (WebElement) iterator.next();
				row = campo.getText();
				if (row.equals(searchValue)) {
					break;
				}
			}
		} catch (Exception e) {
			captureScreen(folderPath, errorBusqueda);
			ReportePDF.closeTemplate(errorBusqueda);
			error();
		}
		return row;
	}

	// METODO PARA DAR CLICK AL ELEMENTO DENTRO DE UNA GRILLA
	public void clickElementGrid(By tableResult, String searchValue, File folderPath, String steps) {
		try {
			visibilityOfElementLocated(tableResult);
			captureScreen(folderPath, steps);
			ArrayList<WebElement> resultado = (ArrayList<WebElement>) driver.findElement(tableResult)
					.findElements(By.tagName("td"));
			for (Iterator<WebElement> iterator = resultado.iterator(); iterator.hasNext();) {
				WebElement campo = (WebElement) iterator.next();
				String row = campo.getText();
				if (row.equals(searchValue)) {
					campo.click();
					break;
				}
			}
		} catch (Exception e) {
			captureScreen(folderPath, errorBusqueda);
			ReportePDF.closeTemplate(errorBusqueda);
			error();
		}

	}

	// METODO PARA CONTAR LA CANTIDAD DE FILAS DE UNA GRILLA
	public int numberRows(By tableResult, File folderPath, String steps) {
		ArrayList<WebElement> resultado = null;
		try {
			captureScreen(folderPath, steps);
			visibilityOfElementLocated(tableResult);
			resultado = (ArrayList<WebElement>) driver.findElement(tableResult).findElements(By.tagName("tr"));
		} catch (Exception e) {
			captureScreen(folderPath, errorLocalizador);
			ReportePDF.closeTemplate(errorLocalizador);
			error();
		}
		return resultado.size() - 2;
	}

	// METODO DE SCROLL HACIA UN LOCALIZADOR
	public void scrollElement(By locator) {
		visibilityOfElementLocated(locator);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(locator);
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// METODO DE SCROLL HACIA ABAJO
	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
	}

	// METODO DE SCROLL HACIA ARRIBA
	public void scrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-1000)");
	}

	// METODO DE ESPERA
	public static void time(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// FECHA PARA MOSTRAR FECHA EN PDF
	public static String fechaPdf() {
		LocalDateTime fechaSistema = LocalDateTime.now();
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String fechaPdf = fecha.format(fechaSistema);
		return fechaPdf;
	}

	// HORA PARA MOSTRAR HORA EN PDF
	public static String horaPdf() {
		LocalDateTime horaSistema = LocalDateTime.now();
		DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH:mm:ss");
		String horaPdf = hora.format(horaSistema);
		return horaPdf;
	}

	// METODO PARA TRAER LA FECHA DEL SISTEMA
	public static String fechaSistema() {
		LocalDateTime fechaSistema = LocalDateTime.now();
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String Fecha = fecha.format(fechaSistema);
		return Fecha;
	}

	// METODO PARA TRAER LA HORA DEL SISTEMA
	public static String horaSistema() {
		LocalTime horaSistema = LocalTime.now();
		DateTimeFormatter horaS = DateTimeFormatter.ofPattern("HHmmss");
		String hora = horaS.format(horaSistema);
		return hora;
	}

	// CAPTURA DE PANTALLA
	public void captureScreen(File folderPath, String steps) {
		String hora = horaSistema();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(folderPath + "\\" + hora + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String imagePath = new File(folderPath + "\\" + hora + ".png").toString();
		try {
			ReportePDF.createBody(steps, imagePath);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		deleteFile(imagePath);
	}

	// METODO PARA CREAR CARPETA PARA CAPTURA
	public static File createFolder(String nameFolder, String path) {
		String fecha = fechaSistema();
		String hora = horaSistema();
		String nomCarpeta = nameFolder + " " + fecha + " " + hora;
		File directorio = new File(path + nomCarpeta);
		directorio.mkdir();
		return directorio;
	}

	// METODO PARA ELIMINAR ARCHIVO
	public void deleteFile(String filePath) {
		File fichero = new File(filePath);
		fichero.delete();
	}

	// ACEPTAR UNA ALERTA
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	// CANCELAR UNA ALERTA
	public void cancelAlert() {
		driver.switchTo().alert().dismiss();
	}

	// ESCRIBIR EN UNA ALERTA
	public void writeAlert(String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	// OPRIMIR ENTER
	public void enter(By element) {
		driver.findElement(element).sendKeys(Keys.RETURN);
	}

	// SALTO DE PAGINA
	public void jumpPage(File folderPath, String steps) {
		driver.switchTo().defaultContent();
		driver.switchTo().window(driver.getWindowHandle());
		Object[] parentHandle = driver.getWindowHandles().toArray();
		driver.switchTo().window((String) parentHandle[1]);
		driver.manage().window().maximize();
		time(5);
		captureScreen(folderPath, steps);
	}

	// METODO SALTO A IFRAME
	public void iFrame(By locator,  File folderPath,  String steps,int tiempo ) {
		try {
			driver.switchTo().frame(driver.findElement(locator));

		} catch (Exception e) {
			System.out.println(e);
		}
		time(tiempo);
	}

	// ELIMINAR TEXTO CON COMANDO
	public void eliminarTextoKeyBoard(By elementLocation) {
		visibilityOfElementLocated(elementLocation);
		driver.findElement(elementLocation).sendKeys(Keys.CONTROL + "a");
		driver.findElement(elementLocation).sendKeys(Keys.DELETE);
	}

}
