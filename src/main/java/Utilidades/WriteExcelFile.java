package Utilidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {

	// METODO PARA ESCRIBIR UN ARREGO DE DATOS EN EL EXCEL CON CABECERA
	public void writeExcel(String filePath, String sheetName, String[] dataToWrite, String[][] dataToWriteBy)
			throws IOException {

		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);
		try (XSSFWorkbook newbook = new XSSFWorkbook(inputStream)) {
			XSSFSheet newSheet = newbook.getSheet(sheetName);
			String[] header = dataToWrite;
			String[][] body = dataToWriteBy;
			for (int i = 0; i <= dataToWrite.length; i++) {
				XSSFRow row = newSheet.createRow(i);
				for (int j = 0; j < header.length; j++) {
					if (i == 0) {
						XSSFCell cell = row.createCell(j);
						cell.setCellValue(header[j]);
					} else {
						XSSFCell cell = row.createCell(j);
						cell.setCellValue(body[i - 1][j]);
					}
				}
			}
			try (OutputStream fileOut = new FileOutputStream(file)) {
				newbook.write(fileOut);
			} catch (IOException e) {
				e.printStackTrace();
			}
			inputStream.close();
			FileOutputStream outputStream = new FileOutputStream(file);
			newbook.write(outputStream);
			outputStream.close();
		}
	}

	
	//METODO PARA ESCRIBIR UN AREGLO DE DATOS EN EXCEL 
	public static void writeExcel(String filepath, String sheetName, String[] dataToWrite) throws IOException {
		File file = new File(filepath);
		FileInputStream inputStream = new FileInputStream(file);
		try (XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream)) {
			XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
			int rowCount = newSheet.getLastRowNum()-newSheet.getFirstRowNum();
			//XSSFRow row = newSheet.getRow(0);	
			XSSFRow newRow = newSheet.createRow(rowCount+1);
			for (int i = 0; i < dataToWrite.length; i++) {
				XSSFCell newCell = newRow.createCell(i);
				newCell.setCellValue(dataToWrite[i]);
			}
			inputStream.close();
			FileOutputStream outputStream = new FileOutputStream(file);
			newWorkbook.write(outputStream);
			outputStream.close();
		}
	}


	
	// METODO QUE PERMITE CREAR UN VALOR EN UNA CELDA ESPECIFICA DE EXCEL
	public void writeCellValue(String filepath, String sheetName, int rowNumber, int cellNumber, String resultText)
			throws IOException {
		File file = new File(filepath);
		FileInputStream inputStream = new FileInputStream(file);
		try (XSSFWorkbook netWorkbook = new XSSFWorkbook(inputStream)) {
			XSSFSheet newSheet = netWorkbook.getSheet(sheetName);
			XSSFRow row = newSheet.createRow(rowNumber);
			XSSFCell nextCell = row.createCell(cellNumber);
			nextCell.setCellValue(resultText);
			inputStream.close();
			FileOutputStream outputStream = new FileOutputStream(file);
			netWorkbook.write(outputStream);
			outputStream.close();
		}
	}
}
