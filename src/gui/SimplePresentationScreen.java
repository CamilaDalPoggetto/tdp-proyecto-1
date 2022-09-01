package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.*;
import java.awt.Toolkit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;

	public SimplePresentationScreen(Student studentData) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentacionn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		// Tabbed Pane to student personal data
		setVisible(true);
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Informacion del alumno", null, tabInformation, "Muestra la informacion declarada por el alumno");
		tabInformation.setLayout(null);
		
		JLabel lblLU = new JLabel("LU");
		lblLU.setBounds(10, 8, 83, 14);
		tabInformation.add(lblLU);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 33, 83, 14);
		tabInformation.add(lblApellido);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 58, 83, 14);
		tabInformation.add(lblNombre);
		
		JLabel lblMail = new JLabel("E-mail");
		lblMail.setBounds(10, 91, 83, 14);
		tabInformation.add(lblMail);
		
		JLabel lblGitURL = new JLabel("GitHub URL");
		lblGitURL.setBounds(10, 131, 83, 14);
		tabInformation.add(lblGitURL);
		
		JTextField textLU = new JTextField(studentData.getId());
		textLU.setColumns(10);
		textLU.setBounds(103, 8, 216, 20);
		textLU.setText(""+studentData.getId());
		tabInformation.add(textLU);
		
		JTextField textApellido = new JTextField(studentData.getLastName());
		textApellido.setColumns(10);
		textApellido.setBounds(103, 30, 216, 20);
		tabInformation.add(textApellido);
		
		JTextField textNombre = new JTextField(studentData.getFirstName());
		textNombre.setColumns(10);
		textNombre.setBounds(103, 55, 216, 20);
		tabInformation.add(textNombre);
		
		JTextField textEmail = new JTextField(studentData.getMail());
		textEmail.setColumns(10);
		textEmail.setBounds(103, 88, 216, 20);
		tabInformation.add(textEmail);
		
		JTextField textGitURL = new JTextField(studentData.getGithubURL());
		textGitURL.setColumns(10);
		textGitURL.setBounds(103, 128, 216, 20);
		tabInformation.add(textGitURL);
		
		LocalDateTime fechayhora = LocalDateTime.now();
		DateTimeFormatter dia = DateTimeFormatter.ofPattern("dd/MM/yy");
		DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		JLabel fecha = new JLabel("Esta ventana fue generada el " + fechayhora.format(dia) + " a las "+fechayhora.format(hora));
		fecha.setSize(360, 15);
		fecha.setLocation(10, 158);
		tabInformation.add(fecha);
	    
		contentPane.add(tabbedPane, BorderLayout.WEST);
		
		JLabel foto=new JLabel();
		
		foto.setIcon(new ImageIcon(SimplePresentationScreen.class.getResource("/images/kira.png")));
		foto.setBounds(329, 8, 86, 154);
		
		contentPane.add(foto);	
	}
}
