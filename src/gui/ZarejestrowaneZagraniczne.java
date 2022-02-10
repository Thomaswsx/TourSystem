package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import project.Ekstensja;
import project.WycieczkaZagraniczna;

import java.awt.Color;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ZarejestrowaneZagraniczne {

	private JFrame frame;
	private DefaultListModel<WycieczkaZagraniczna> listaZagranicznych = new DefaultListModel<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZarejestrowaneZagraniczne window = new ZarejestrowaneZagraniczne();
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
	public ZarejestrowaneZagraniczne() {
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
			for (WycieczkaZagraniczna wz : Ekstensja.getEkstensja(WycieczkaZagraniczna.class)) {
				listaZagranicznych.addElement(wz);
			}
		} catch (NullPointerException e) {
			System.out.println("brak wycieczek zagranicznych");
		}

		JLabel lblNewLabel = new JLabel("Wycieczki zagraniczne:");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(108, 6, 220, 29);
		frame.getContentPane().add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 49, 397, 164);
		frame.getContentPane().add(scrollPane);

		JList<WycieczkaZagraniczna> list = new JList<>(listaZagranicznych);
		scrollPane.setViewportView(list);

		JButton btnAnuluj = new JButton("Anuluj");
		btnAnuluj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				ZarejestrowaneWycieczki zw = new ZarejestrowaneWycieczki();
				frame.setVisible(false);
				zw.getFrame().setVisible(true);

			}
		});
		btnAnuluj.setBounds(301, 223, 117, 29);
		frame.getContentPane().add(btnAnuluj);

		JButton btnUsuWycieczke = new JButton("Usuń");
		btnUsuWycieczke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int index = list.getSelectedIndex();

				int pytanie = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz usunąć wycieczke?", "Uwaga!",
						JOptionPane.YES_NO_OPTION);

				if (pytanie == JOptionPane.YES_OPTION) {
					listaZagranicznych.remove(index);
					Ekstensja.getEkstensja(WycieczkaZagraniczna.class).remove(index);
					JOptionPane.showMessageDialog(null, "Usunięto wycieczke");
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

		btnUsuWycieczke.setBounds(163, 222, 125, 31);
		frame.getContentPane().add(btnUsuWycieczke);
	}

	public JFrame getFrame() {
		return frame;
	}
}
