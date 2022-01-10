import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	public static ArrayList<Integer> ids = new ArrayList<>();
	public static ArrayList<String> nombres = new ArrayList<>();
	public static ArrayList<String> apellidos = new ArrayList<>();
	public static ArrayList<Integer> medias = new ArrayList<>();
	public static ArrayList<String> equipos = new ArrayList<>();
	public static ArrayList<Integer> idsEquipos = new ArrayList<>();
	public static ArrayList<String> equiposLista = new ArrayList<>();
	public static ArrayList<Integer> idsCarreras = new ArrayList<>();
	public static ArrayList<String> carreras = new ArrayList<>();
	public static ArrayList<String> nombresCarreras = new ArrayList<>();

	public static void llamada(File archivo, String metodo) {
		FileInputStream fis = null;
		XSSFWorkbook wb = null;
		XSSFSheet hoja;
		int filas;
		Row fila;
		try {
			fis = new FileInputStream(archivo);
			wb = new XSSFWorkbook(fis);
			// Primera hoja del excel
			hoja = wb.getSheetAt(0);
			filas = hoja.getLastRowNum();
			for (int i = 0; i <= filas; i++) {
				fila = hoja.getRow(i);
				switch (metodo) {
				case "ids":
					recogerIds(fila, ids);
					break;
				case "nombres":
					recogerNombres(fila, nombres);
					break;
				case "apellidos":
					recogerApellidos(fila, apellidos);
					break;
				case "medias":
					recogerMedias(fila, medias);
					break;
				case "equipos":
					recogerEquipos(fila, equipos);
					break;
				case "idsEquipos":
					recogerIdsEquipos(fila, idsEquipos);
					break;
				case "equiposLista":
					recogerEquiposLista(fila, equiposLista);
					break;
				case "idsCarreras":
					recogerIdsCarreras(fila, idsCarreras);
					break;
				case "carreras":
					recogerCarreras(fila, carreras);
					break;
				case "nombresCarreras":
					recogerNombresCarreras(fila, nombresCarreras);
					break;
				}
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "No existe el archivo", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
				if (wb != null)
					wb.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void recogerIds(Row fila, ArrayList<Integer> ids) {
		Cell celda;
		// Columna A
		celda = fila.getCell(0);
		if (celda != null)
			switch (celda.getCellType().toString()) {
			case "NUMERIC":
				ids.add((int) celda.getNumericCellValue());
				break;
			}
	}

	public static void recogerNombres(Row fila, ArrayList<String> nombres) {
		Cell celda;
		// Columna B
		celda = fila.getCell(1);
		if (celda != null)
			switch (celda.getCellType().toString()) {
			case "STRING":
				nombres.add(celda.getStringCellValue());
				break;
			}
	}

	public static void recogerApellidos(Row fila, ArrayList<String> apellidos) {
		Cell celda;
		// Columna C
		celda = fila.getCell(2);
		if (celda != null)
			switch (celda.getCellType().toString()) {
			case "STRING":
				apellidos.add(celda.getStringCellValue());
				break;
			}
	}

	public static void recogerMedias(Row fila, ArrayList<Integer> medias) {
		Cell celda;
		// Columna R
		celda = fila.getCell(17);
		if (celda != null)
			switch (celda.getCellType().toString()) {
			case "FORMULA":
				medias.add((int) celda.getNumericCellValue());
				break;
			}
	}

	public static void recogerEquipos(Row fila, ArrayList<String> equipos) {
		Cell celda;
		// Columna W
		celda = fila.getCell(22);
		if (celda != null)
			switch (celda.getCellType().toString()) {
			case "STRING":
				equipos.add(celda.getStringCellValue());
				break;
			}
	}

	public static void recogerIdsEquipos(Row fila, ArrayList<Integer> idsEquipos) {
		Cell celda;
		// Columna A
		celda = fila.getCell(0);
		if (celda != null)
			switch (celda.getCellType().toString()) {
			case "NUMERIC":
				idsEquipos.add((int) celda.getNumericCellValue());
				break;
			}
	}

	public static void recogerEquiposLista(Row fila, ArrayList<String> equiposLista) {
		Cell celda;
		// Columna B
		celda = fila.getCell(1);
		if (celda != null)
			switch (celda.getCellType().toString()) {
			case "STRING":
				equiposLista.add(celda.getStringCellValue());
				break;
			}
	}

	public static void recogerIdsCarreras(Row fila, ArrayList<Integer> idsCarreras) {
		Cell celda;
		// Columna A
		celda = fila.getCell(0);
		if (celda != null)
			switch (celda.getCellType().toString()) {
			case "NUMERIC":
				idsCarreras.add((int) celda.getNumericCellValue());
				break;
			}
	}

	public static void recogerCarreras(Row fila, ArrayList<String> carreras) {
		Cell celda;
		// Columna B
		celda = fila.getCell(1);
		if (celda != null)
			switch (celda.getCellType().toString()) {
			case "STRING":
				carreras.add(celda.getStringCellValue());
				break;
			}
	}

	public static void recogerNombresCarreras(Row fila, ArrayList<String> nombresCarreras) {
		Cell celda;
		// Columna C
		celda = fila.getCell(2);
		if (celda != null)
			switch (celda.getCellType().toString()) {
			case "STRING":
				nombresCarreras.add(celda.getStringCellValue());
				break;
			}
	}

}