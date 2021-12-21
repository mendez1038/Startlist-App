import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

public class Main {

	@SuppressWarnings("unchecked")
	public static <E> void main(String[] args) {

		DB.generarDB();

		JFrame f = new JFrame();
		f.setBounds(10, 10, 500, 500);
		f.setTitle("StartList Maker");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel t = new JLabel("Equipo");
		JComboBox<E> comboE = new JComboBox<>();
		comboE.setEditable(false);
		for (Equipo e : DB.listaEquipos) {
			comboE.addItem((E) e.getNombre());
		}
		JLabel texto = new JLabel("Carrera");
		JComboBox<E> combo = new JComboBox<>();
		combo.setEditable(true);
		for (Carrera c : DB.listaCarreras) {
			combo.addItem((E) c.getNombre());
		}
		f.setLayout(new FlowLayout());
		f.add(t);
		f.add(comboE);
		f.add(texto);
		f.add(combo);
		f.setVisible(true);
	}

}
