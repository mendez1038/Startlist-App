import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		// Leer los datos de los Excel
		DB.generarDB();

		// Crear la interfaz gr�fica
		Dise�o.crearInterfaz();
		
		// Guardar carpeta Starlist
		try {
			App.almacenarCarpeta();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
