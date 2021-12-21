import java.io.File;
import java.util.ArrayList;

public class DB {

	public static ArrayList<Corredor> listaCorredores = new ArrayList<Corredor>();
	public static ArrayList<Equipo> listaEquipos = new ArrayList<Equipo>();
	public static ArrayList<Carrera> listaCarreras = new ArrayList<Carrera>();

	public static void generarDB() {

		generarEquipos(listaEquipos);
		generarCorredores(listaCorredores);
		generarCarreras(listaCarreras);
		System.out.println("DB generada");

	}

	private static void generarCarreras(ArrayList<Carrera> lista) {
		File carreras = new File("carreras.xlsx");
		Carrera c = null;

		Excel.llamada(carreras, "idsCarreras");
		Excel.llamada(carreras, "carreras");
		Excel.llamada(carreras, "nombresCarreras");
		for (int i = 0; i < Excel.idsCarreras.size(); i++) {
			c = new Carrera();
			c.setId(Excel.idsCarreras.get(i));
			c.setNombre(Excel.carreras.get(i + 1));
			c.setArchivo(Excel.nombresCarreras.get(i + 1));
			lista.add(c);
		}
	}

	private static void generarCorredores(ArrayList<Corredor> lista) {
		File excel = new File("T11_Fantasy.xlsx");
		Corredor c = null;

		Excel.llamada(excel, "ids");
		Excel.llamada(excel, "nombres");
		Excel.llamada(excel, "apellidos");
		Excel.llamada(excel, "medias");
		Excel.llamada(excel, "equipos");
		for (int i = 0; i < Excel.ids.size(); i++) {
			c = new Corredor();
			c.setId(Excel.ids.get(i));
			c.setNombre(Excel.nombres.get(i + 1));
			c.setApellido(Excel.apellidos.get(i + 1));
			c.setMedia(Excel.medias.get(i));
			c.setEquipo(Excel.equipos.get(i + 1));
			lista.add(c);
		}
	}

	private static void generarEquipos(ArrayList<Equipo> lista) {
		File equipos = new File("equipos.xlsx");
		Equipo e = null;

		Excel.llamada(equipos, "idsEquipos");
		Excel.llamada(equipos, "equiposLista");
		for (int i = 0; i < Excel.idsEquipos.size(); i++) {
			e = new Equipo();
			e.setId(Excel.idsEquipos.get(i));
			e.setNombre(Excel.equiposLista.get(i + 1));
			lista.add(e);
		}
	}

}
