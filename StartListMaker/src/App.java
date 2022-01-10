import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class App {

	public static <E> void crearTabla(JFrame f, JComboBox<E> comboE) {
		String[] header = { "Nombre", "Media", "Selección" };
		int index = comboE.getSelectedIndex();
		Equipo equipo = DB.listaEquipos.get(index);
		Object[][] datos = new Object[equipo.getCorredores().size()][3];
		for (int i = 0; i < equipo.getCorredores().size(); i++) {
			Corredor c = equipo.getCorredores().get(i);
			Object[] o = new Object[3];
			o[0] = c.getNombre() + " " + c.getApellido();
			o[1] = c.getMedia();
			o[2] = c.isCorre();
			datos[i] = o;
		}
		JTable tabla = new JTable(datos, header);
		f.add(new JScrollPane(tabla), new FlowLayout(0, 0, 0));
		f.validate();
		tabla.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = tabla.getSelectedRow();
				
				}
				});
	}

	public static void almacenarCarpeta() throws IOException {
		File archivo;
		File ruta = new File("ruta.txt");
		String path;
		String[] array;
		JFileChooser chooser;
		int opcion;
		if (!ruta.exists()) {

			JOptionPane.showMessageDialog(null, "Selecciona la carpeta donde se guardan las startlist");
			chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			opcion = chooser.showOpenDialog(null);
			if (opcion == JFileChooser.APPROVE_OPTION) {
				archivo = chooser.getSelectedFile();
				path = archivo.getAbsolutePath();
				array = path.split("\\\\");
				int i = array.length - 1;
				System.out.println(array[i]);
				if(array[i].equals("Startlists")) {					
					ruta.createNewFile();
					escribirArchivo(ruta, path);
				} else {
					JOptionPane.showMessageDialog(null, "Carpeta mal seleccionada", "Startlist App", JOptionPane.ERROR_MESSAGE);
					almacenarCarpeta();
				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	public static String leerArchivo() {

		// Inicializar variables
		File archivo = new File("ruta.txt");
		FileInputStream fis = null;
		DataInputStream dis = null;
		String linea;
		String pintar = "";

		try {
			fis = new FileInputStream(archivo);
			dis = new DataInputStream(fis);
			while ((linea = dis.readLine()) != null) {
				if (linea.length() != 0) {
					pintar += linea + "\n";
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (dis != null) {
					dis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return pintar;
	}

	public static void escribirArchivo(File archivo, String txt) {

		FileOutputStream fos = null;
		DataOutputStream dos = null;

		try {
			fos = new FileOutputStream(archivo, true);
			dos = new DataOutputStream(fos);
			dos.writeBytes(txt);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dos != null)
					dos.close();
				if (fos != null)
					fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
