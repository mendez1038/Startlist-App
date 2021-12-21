
public class Carrera {

	private int id;
	private String nombre;
	private String archivo;

	public Carrera() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	@Override
	public String toString() {
		return "id: " + getId() + " Nombre: " + getNombre() + " Archivo: " + getArchivo();
	}

}
