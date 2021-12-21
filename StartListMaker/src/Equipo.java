import java.util.ArrayList;

public class Equipo {

	private int id;
	private String nombre;
	private ArrayList<Corredor> corredores;

	public Equipo() {
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

	public ArrayList<Corredor> getCorredores() {
		return corredores;
	}

	public void setCorredores(ArrayList<Corredor> corredores) {
		this.corredores = corredores;
	}

	@Override
	public String toString() {
		return "id: " + getId() + " nombre: " + getNombre();
	}

}
