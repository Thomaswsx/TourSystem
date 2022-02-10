package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;

public class ZarejestrowaneWycieczki {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZarejestrowaneWycieczki window = new ZarejestrowaneWycieczki();
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
	public ZarejestrowaneWycieczki() {
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

		JLabel lblNewLabel = new JLabel("Znajdź wycieczke:");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(131, 17, 189, 29);
		frame.getContentPane().add(lblNewLabel);

		JButton btnZapisz = new JButton("Krajowa");
		btnZapisz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZarejestrowaneKrajowe zk = new ZarejestrowaneKrajowe();
				frame.setVisible(false);
				zk.getFrame().setVisible(true);

			}
		});
		btnZapisz.setBounds(42, 96, 134, 68);
		frame.getContentPane().add(btnZapisz);

		JButton btnZagraniczna = new JButton("Zagraniczna");
		btnZagraniczna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZarejestrowaneZagraniczne zz = new ZarejestrowaneZagraniczne();
				frame.setVisible(false);
				zz.getFrame().setVisible(true);
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
