package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

import project.Ekstensja;
import project.Klient;
import project.KlientZarejestrowany;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTable;

public class ZarejestrowniKlienci {

	private JFrame frame;

	private DefaultListModel<KlientZarejestrowany> listaKlientow = new DefaultListModel<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZarejestrowniKlienci window = new ZarejestrowniKlienci();
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
	public ZarejestrowniKlienci() {
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

		JLabel lblNewLabel = new JLabel("Klienci:");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(192, 6, 79, 25);
		frame.getContentPane().add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 49, 397, 164);
		frame.getContentPane().add(scrollPane);

		JList<KlientZarejestrowany> list = new JList<>(listaKlientow);
		scrollPane.setViewportView(list);

		JButton btnAnuluj = new JButton("Anuluj");
		btnAnuluj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				MenuGlowne mg = new MenuGlowne();
				frame.setVisible(false);
				mg.getFrame().setVisible(true);

			}
		});

		btnAnuluj.setBounds(301, 223, 117, 29);
		frame.getContentPane().add(btnAnuluj);

		JButton btnUsuKlienta = new JButton("Usuń");
		btnUsuKlienta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				KlientZarejestrowany kz = list.getSelectedValue();
				
				if(kz == null) {
					JOptionPane.showMessageDialog(null, "Zaznacz klienta!");
				
					return;
				}

				int pytanie = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz usunąć Klienta?", "Uwaga!",
						JOptionPane.YES_NO_OPTION);

				if (pytanie == JOptionPane.YES_OPTION) {
				
					Ekstensja.getEkstensja(KlientZarejestrowany.class).remove(kz);
					JOptionPane.showMessageDialog(null, "Usunięto klienta");
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

			}

		});

		btnUsuKlienta.setBounds(164, 223, 117, 29);
		frame.getContentPane().add(btnUsuKlienta);
	}

	public JFrame getFrame() {
		return frame;
	}
}
