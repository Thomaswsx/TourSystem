package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class MenuGlowne {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGlowne window = new MenuGlowne();
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
	public MenuGlowne() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 426, 388);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Nowy klient");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DodanieKlienta dk = new DodanieKlienta();
				frame.setVisible(false);
				dk.getFrame().setVisible(true);
			}
		});
		btnNewButton.setBounds(49, 67, 117, 57);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_2 = new JButton("Klienci");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZarejestrowniKlienci zk = new ZarejestrowniKlienci();
				frame.setVisible(false);
				zk.getFrame().setVisible(true);

			}
		});
		btnNewButton_2.setBounds(49, 155, 117, 57);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnDodajWycieczke = new JButton("Nowa wycieczka");
		btnDodajWycieczke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DodanieWycieczki dw = new DodanieWycieczki();
				frame.setVisible(false);
				dw.getFrame().setVisible(true);
			}
		});
		btnDodajWycieczke.setBounds(249, 67, 117, 57);
		frame.getContentPane().add(btnDodajWycieczke);
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblNewLabel.setBounds(180, 16, 66, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Wycieczki");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZarejestrowaneWycieczki zw = new ZarejestrowaneWycieczki();
				frame.setVisible(false);
				zw.getFrame().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(249, 155, 117, 57);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Nowy zakup");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KupienieWycieczki kw = new KupienieWycieczki();
				frame.setVisible(false);
				kw.getFrame().setVisible(true);
			}
		});
		btnNewButton_3.setBounds(49, 242, 117, 57);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Zakupy");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZakupioneWycieczki zw = new ZakupioneWycieczki();
				frame.setVisible(false);
				zw.getFrame().setVisible(true);
			}
		});
		btnNewButton_4.setBounds(249, 242, 117, 57);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Wyloguj się");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Logowanie l = new Logowanie();
				frame.setVisible(false);
				l.getFrame().setVisible(true);
			}
		});
		btnNewButton_5.setBounds(303, 325, 117, 29);
		frame.getContentPane().add(btnNewButton_5);

	}

	public JFrame getFrame() {
		return frame;
	}
}
