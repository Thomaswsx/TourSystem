package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DodanieWycieczki {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodanieWycieczki window = new DodanieWycieczki();
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
	public DodanieWycieczki() {
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

		JLabel lblNewLabel = new JLabel("Wybierz wycieczke:");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(131, 17, 189, 29);
		frame.getContentPane().add(lblNewLabel);

		JButton btnZapisz = new JButton("Krajowa");
		btnZapisz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DodanieKrajowej dk = new DodanieKrajowej();
				frame.setVisible(false);
				dk.getFrame().setVisible(true);

			}
		});
		btnZapisz.setBounds(42, 96, 134, 68);
		frame.getContentPane().add(btnZapisz);

		JButton btnZagraniczna = new JButton("Zagraniczna");
		btnZagraniczna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DodanieZagranicznej dz = new DodanieZagranicznej();
				frame.setVisible(false);
				dz.getFrame().setVisible(true);
			}
		});
		btnZagraniczna.setBounds(262, 96, 134, 68);
		frame.getContentPane().add(btnZagraniczna);

		JButton btnNewButton_1 = new JButton("Anuluj");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				MenuGlowne mg = new MenuGlowne();
				frame.setVisible(false);
				mg.getFrame().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(308, 226, 117, 29);
		frame.getContentPane().add(btnNewButton_1);

	}

	public JFrame getFrame() {
		return frame;
	}
}
