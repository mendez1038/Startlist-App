
public class Corredor {

	private int id;
	private String nombre;
	private String apellido;
	private int media;
	private String equipo;
	private boolean corre;

	public Corredor() {
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getMedia() {
		return media;
	}

	public void setMedia(int media) {
		this.media = media;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public boolean isCorre() {
		return corre;
	}

	public void setCorre(boolean corre) {
		this.corre = corre;
	}

	@Override
	public String toString() {
		return "id: " + getId() + " nombre: " + getNombre() + " " + getApellido() + " media: " + getMedia()
				+ " equipo: " + getEquipo();
	}

}
