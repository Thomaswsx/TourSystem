package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.event.MouseInputListener;

import project.Ekstensja;
import project.KlientZarejestrowany;
import project.Wycieczka;

import java.awt.Color;

public class ZakupioneWycieczki {

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
					ZakupioneWycieczki window = new ZakupioneWycieczki();
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
	public ZakupioneWycieczki() {
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

		JLabel lblNewLabel = new JLabel("Klient:");
		lblNewLabel.setBounds(76, 22, 61, 16);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Wycieczki klienta:");
		lblNewLabel_1.setBounds(292, 22, 117, 16);
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

		listaK.addMouseListener(new MouseInputListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				KlientZarejestrowany kz = listaK.getSelectedValue();

				listaWycieczek.clear();
				for (Wycieczka w : kz.getWycieczki()) {
					System.out.println(w);
					listaWycieczek.addElement(w);
				}
			}
		});

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

		JButton btnNewButton_1 = new JButton("Wydał najwięcej");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, "Najwięcej wydał: "
						+ KlientZarejestrowany.najwiecejWydal(Ekstensja.getEkstensja(KlientZarejestrowany.class)));
			}
		});
		btnNewButton_1.setBounds(173, 237, 134, 29);
		frame.getContentPane().add(btnNewButton_1);
	}

	public JFrame getFrame() {
		return frame;
	}
}
