package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JTextField;

import project.Ekstensja;
import project.KlientZarejestrowany;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class DodanieKlienta {

	private JFrame frame;
	private JTextField imieField;
	private JTextField nazwiskoField;
	private JTextField telefonField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodanieKlienta window = new DodanieKlienta();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DodanieKlienta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		// wczytanie ekstensji
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("BazaDanych"))) {
			Ekstensja.load(ois);
		} catch (Exception e) {
			System.out.println("Brak ekstensji");
		}

		JLabel lblNewLabel = new JLabel("Nowy klient");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(164, 8, 117, 19);
		frame.getContentPane().add(lblNewLabel);

		imieField = new JTextField();
		imieField.setBounds(20, 73, 130, 26);
		frame.getContentPane().add(imieField);
		imieField.setColumns(10);

		nazwiskoField = new JTextField();
		nazwiskoField.setBounds(273, 73, 130, 26);
		frame.getContentPane().add(nazwiskoField);
		nazwiskoField.setColumns(10);

		telefonField = new JTextField();
		telefonField.setColumns(10);
		telefonField.setBounds(273, 145, 130, 26);
		frame.getContentPane().add(telefonField);

		JLabel lblNewLabel_1 = new JLabel("Imie:");
		lblNewLabel_1.setBounds(22, 59, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Nazwisko:");
		lblNewLabel_2.setBounds(273, 58, 73, 19);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Adres mail:");
		lblNewLabel_2_1.setBounds(20, 128, 85, 16);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 145, 126, 32);
		frame.getContentPane().add(scrollPane);
		
		JTextArea adresMail = new JTextArea();
		scrollPane.setViewportView(adresMail);

		JLabel lblNewLabel_2_2 = new JLabel("Telefon:");
		lblNewLabel_2_2.setBounds(273, 128, 61, 16);
		frame.getContentPane().add(lblNewLabel_2_2);

		JButton btnNewButton = new JButton("Anuluj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				MenuGlowne mg = new MenuGlowne();
				frame.setVisible(false);
				mg.getFrame().setVisible(true);
			}
		});
		btnNewButton.setBounds(327, 222, 117, 29);
		frame.getContentPane().add(btnNewButton);
		


		JButton btnNewButton_1 = new JButton("Zapisz");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dane = "Podałeś złe dane\n";
				boolean flag = false;
				if (!sprawdzPoprawnoscImienia(imieField.getText())) {
					dane += "imie\n";
					flag = true;
				}
				if (!sprawdzPoprawnoscNaziwska(nazwiskoField.getText())) {
					dane += "naziwsko\n";
					flag = true;
				}

				if (!sprawdzPoprawnoscTelefonu(telefonField.getText())) {
					dane += "telefon\n";
					flag = true;
				}
				
				if (flag) {
					JOptionPane.showMessageDialog(null, dane);
					return;
				}

				// tutaj zapisanie w Ekstensji
				KlientZarejestrowany kz = null;
				try {
					kz = new KlientZarejestrowany(imieField.getText(), nazwiskoField.getText(), telefonField.getText());
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				String[] adresy = adresMail.getText().split("\n");
				for (String mail : adresy) {
					if (!sprawdzPoprawnoscAdresuMail(mail)) {
						dane += "adres";
						flag = true;
					}
					kz.dodajAdresMailowy(mail);

				}
				

				ObjectOutputStream oos;
				try {
					oos = new ObjectOutputStream(new FileOutputStream("BazaDanych"));
					Ekstensja.save(oos);
					oos.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				JOptionPane.showMessageDialog(null, "Dodano klienta");

				MenuGlowne mg = new MenuGlowne();
				frame.setVisible(false);
				mg.getFrame().setVisible(true);

			}
		});

		btnNewButton_1.setBounds(198, 222, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public static boolean sprawdzPoprawnoscImienia(String imie) {
		Pattern pattern = Pattern.compile("[A-Z][a-z]{2,}( [A-Z][a-z]{2,})?");
		return pattern.matcher(imie).matches();
	}

	public static boolean sprawdzPoprawnoscNaziwska(String nazwisko) {
		Pattern pattern = Pattern.compile("[A-Z][a-z]{2,}");
		return pattern.matcher(nazwisko).matches();
	}

	public static boolean sprawdzPoprawnoscAdresuMail(String adresMail) {
		Pattern pattern = Pattern.compile("\\w+(-?\\.?\\w+)+?@\\w+.\\w{2,3}(.(\\w{2,3}))?");
		return pattern.matcher(adresMail).matches();
	}

	public static boolean sprawdzPoprawnoscTelefonu(String telefon) {
		Pattern pattern = Pattern.compile("\\d{9}");
		return pattern.matcher(telefon).matches();
	}
}
