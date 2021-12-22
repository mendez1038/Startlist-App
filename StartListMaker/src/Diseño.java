import java.awt.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class Diseño {

	@SuppressWarnings("unchecked")
	public static <E> void crearInterfaz() {
		
		try{
			 JFrame.setDefaultLookAndFeelDecorated(true);
			 JDialog.setDefaultLookAndFeelDecorated(true);
			 UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		
		JFrame f = new JFrame();
		f.setSize(600, 800);
		f.setTitle("StartList Maker");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		//TITULO
		JPanel titulo = new JPanel();
		titulo.setPreferredSize(new Dimension(600,100));
		titulo.setLayout(new FlowLayout(1,0,0));
		JLabel tituloText = new JLabel("StartList App");
		tituloText.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		titulo.add(tituloText);
		f.add(titulo);
		
		//COMBO EQUIPOS
		JPanel comboEquipos = new JPanel();
		comboEquipos.setPreferredSize(new Dimension(550,50));
		comboEquipos.setLayout(new FlowLayout(0,20,0));
		JLabel t = new JLabel("Equipo");
		t.setFont(new Font("Calibri", Font.PLAIN, 17));
		JComboBox<E> comboE = new JComboBox<>();
		comboE.setEditable(false);
		for (Equipo e : DB.listaEquipos) {
			comboE.addItem((E) e.getNombre());
		}
		comboEquipos.add(t);
		comboEquipos.add(comboE);
		f.add(comboEquipos);
		
		//CHECK LIST
		
		//BOTON AÑADIR
		JPanel botonAñadir = new JPanel();
		botonAñadir.setPreferredSize(new Dimension(400,50));
		botonAñadir.setLayout(new FlowLayout(2,0,0));
		JButton bAñadir = new JButton("Añadir corredores");
		botonAñadir.add(bAñadir);
		f.add(botonAñadir);
		
		//COMBO CARRERAS
		JPanel comboCarreras = new JPanel();
		comboCarreras.setPreferredSize(new Dimension(550,50));
		comboCarreras.setLayout(new FlowLayout(0,20,0));
		JLabel texto = new JLabel("Carrera");
		texto.setFont(new Font("Calibri", Font.PLAIN, 17));
		JComboBox<E> combo = new JComboBox<>();
		combo.setEditable(false);
		for (Carrera c : DB.listaCarreras) {
			combo.addItem((E) c.getNombre());
		}
		comboCarreras.add(texto);
		comboCarreras.add(combo);
		f.add(comboCarreras);
		
		//BOTON GUARDAR
		JPanel botonGuardar = new JPanel();
		botonGuardar.setPreferredSize(new Dimension(400,50));
		botonGuardar.setLayout(new FlowLayout(2,0,0));
		JButton bGuardar = new JButton("Guardar StartList");
		bGuardar.setBackground(Color.GREEN);
		bGuardar.setForeground(Color.BLACK);
		botonGuardar.add(bGuardar);
		f.add(botonGuardar);
		
		//VISTA PREVIA
		JPanel preView = new JPanel();
		preView.setPreferredSize(new Dimension(550,400));
		preView.setLayout(new FlowLayout(0,0,0));
		JLabel txt = new JLabel("Vista previa");
		txt.setFont(new Font("Calibri", Font.PLAIN, 17));
		JTextArea ta = new JTextArea(20,50);
		ta.setLineWrap(true);
		JScrollPane scroll = new JScrollPane(ta);
		preView.add(txt);
		preView.add(scroll);
		f.add(preView);
		
		f.setVisible(true);
		
	}

}
