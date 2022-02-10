package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class Logowanie {

	private JFrame frame;
	private JTextField loginField;
	private JPasswordField passwordField;
	private JLabel lblHaslo;
	private JButton zalogujNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logowanie window = new Logowanie();
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
	public Logowanie() {
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

		loginField = new JTextField();
		loginField.setHorizontalAlignment(SwingConstants.CENTER);
		loginField.setBackground(Color.WHITE);
		loginField.setBounds(144, 105, 153, 26);
		frame.getContentPane().add(loginField);
		loginField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(144, 175, 153, 26);
		frame.getContentPane().add(passwordField);

		JLabel loginLabel = new JLabel("Login");
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setBounds(189, 74, 61, 16);
		frame.getContentPane().add(loginLabel);

		lblHaslo = new JLabel("Hasło");
		lblHaslo.setHorizontalAlignment(SwingConstants.CENTER);
		lblHaslo.setBounds(189, 147, 61, 16);
		frame.getContentPane().add(lblHaslo);

		zalogujNewButton = new JButton("Zaloguj");
		zalogujNewButton.setBackground(Color.WHITE);
		zalogujNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!sprawdzPoprawnoscLoginu(loginField.getText())
						|| !sprawdzPoprawnoscHasla(passwordField.getPassword())) {
					JOptionPane.showMessageDialog(null, "Błędny login lub hasło");
					return;
				}

				MenuGlowne mg = new MenuGlowne();
				frame.setVisible(false);
				mg.getFrame().setVisible(true);

			}
		});
		zalogujNewButton.setBounds(161, 213, 117, 29);
		frame.getContentPane().add(zalogujNewButton);

		JLabel lblNewLabel = new JLabel("Zaloguj się:");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(154, 6, 143, 40);
		frame.getContentPane().add(lblNewLabel);
	}

	public static boolean sprawdzPoprawnoscLoginu(String login) {
		String log = "asd";
		return log.equals(login);
	}

	public static boolean sprawdzPoprawnoscHasla(char[] haslo) {
		char[] has = { 'a', 's', 'd' };
		return Arrays.equals(haslo, has);
	}
	public JFrame getFrame() {
		return frame;
	}
}
