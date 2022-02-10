package gui;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import project.Ekstensja;
import project.KlientZarejestrowany;
import project.Wycieczka;
import project.WycieczkaKrajowa;
import project.WycieczkaZagraniczna;

import javax.swing.JScrollPane;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KupienieWycieczki {

	private JFrame frame;
	private DefaultListModel<KlientZarejestrowany> listaKlientow = new DefaultListModel<>();
	private DefaultListModel<Wycieczka> listaWycieczek = new DefaultListModel<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KupienieWycieczki window = new KupienieWycieczki();
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
	public KupienieWycieczki() {
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
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("BazaDanych"))) {
			Ekstensja.load(ois);
		} catch (Exception e) {
			System.out.println("Brak ekstensji");
		}

		try {
			for (KlientZarejestrowany kz : Ekstensja.getEkstensja(KlientZarejestrowany.class)) {
				listaKlientow.addElement(kz);
			}
		} catch (NullPointerException e) {
			System.out.println("brak klientow");
		}

		try {
			for (WycieczkaKrajowa wk : Ekstensja.getEkstensja(WycieczkaKrajowa.class)) {
				listaWycieczek.addElement(wk);
			}
		} catch (NullPointerException e) {
			System.out.println("brak wycieczek krajowych");
		}

		try {
			for (WycieczkaZagraniczna wz : Ekstensja.getEkstensja(WycieczkaZagraniczna.class)) {
				listaWycieczek.addElement(wz);
			}
		} catch (NullPointerException e) {
			System.out.println("brak wycieczek zagranicznych");
		}

		JLabel lblNewLabel = new JLabel("Klienci:");
		lblNewLabel.setBounds(76, 22, 61, 16);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Wycieczki:");
		lblNewLabel_1.setBounds(305, 22, 78, 16);
		frame.getContentPane().add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 59, 171, 148);
		frame.getContentPane().add(scrollPane);

		JList<KlientZarejestrowany> listaK = new JList<>(listaKlientow);
		listaK.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listaK);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(262, 59, 171, 148);
		frame.getContentPane().add(scrollPane_1);

		JList<Wycieczka> listaW = new JList<>(listaWycieczek);
		scrollPane_1.setViewportView(listaW);

		JButton btnNewButton = new JButton("Anuluj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGlowne mg = new MenuGlowne();
				frame.setVisible(false);
				mg.getFrame().setVisible(true);
			}
		});
		btnNewButton.setBounds(316, 237, 117, 29);
		frame.getContentPane().add(btnNewButton);

		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				KlientZarejestrowany kz = listaK.getSelectedValue();
				if (kz == null) {
					JOptionPane.showMessageDialog(null, "Zaznacz klienta!");

					return;
				}

				List<Wycieczka> wycieczki = listaW.getSelectedValuesList();

				if (wycieczki == null) {
					JOptionPane.showMessageDialog(null, "Zaznacz wycieczke!");
					return;
				}

				for (Wycieczka w : wycieczki) {
					w.dodajKlienta(kz);
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
				
				JOptionPane.showMessageDialog(null, "Dodano wycieczke");

			}
		});
		btnDodaj.setBounds(187, 237, 117, 29);
		frame.getContentPane().add(btnDodaj);

	}

	public JFrame getFrame() {
		return frame;
	}
}
