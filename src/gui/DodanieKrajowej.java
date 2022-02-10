package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import project.Ekstensja;
import project.Motyw;
import project.Ocena;
import project.WycieczkaKrajowa;
import project.WycieczkaZagraniczna;

import javax.swing.JSpinner;
import javax.swing.JComboBox;

public class DodanieKrajowej {

	private JFrame frame;
	private JTextField miastoField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodanieKrajowej window = new DodanieKrajowej();
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
	public DodanieKrajowej() {
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

		JLabel lblNewLabel = new JLabel("Nowa wycieczka");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(142, 16, 164, 25);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Miasto:");
		lblNewLabel_1.setBounds(26, 56, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);

		miastoField = new JTextField();
		miastoField.setBounds(26, 74, 130, 26);
		frame.getContentPane().add(miastoField);
		miastoField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Cena:");
		lblNewLabel_2.setBounds(26, 122, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(26, 143, 130, 26);
		frame.getContentPane().add(spinner);

		JLabel lblNewLabel_3 = new JLabel("Motyw:");
		lblNewLabel_3.setBounds(279, 122, 61, 16);
		frame.getContentPane().add(lblNewLabel_3);

		JComboBox<Motyw> motywBox = new JComboBox<>();
		motywBox.setBounds(279, 142, 130, 27);
		motywBox.setModel(new DefaultComboBoxModel<>(Motyw.values()));
		frame.getContentPane().add(motywBox);

		JLabel lblNewLabel_4 = new JLabel("Ocena:");
		lblNewLabel_4.setBounds(279, 53, 61, 16);
		frame.getContentPane().add(lblNewLabel_4);

		JComboBox<Ocena> ocenaBox = new JComboBox<>();
		ocenaBox.setBounds(279, 75, 130, 27);
		ocenaBox.setModel(new DefaultComboBoxModel<>(Ocena.values()));
		frame.getContentPane().add(ocenaBox);

		JButton btnNewButton_1 = new JButton("Zapisz");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dane = "Podałeś złe dane\n";
				boolean flag = false;
				if (!sprawdzPoprawnoscKraju(miastoField.getText())) {
					dane += "miasto\n";
					flag = true;
				}

				if (flag) {
					JOptionPane.showMessageDialog(null, dane);
					return;
				}

				WycieczkaKrajowa wk = null;

				try {
					wk = new WycieczkaKrajowa((int) spinner.getValue(), (Motyw) motywBox.getSelectedItem(),
							(Ocena) ocenaBox.getSelectedItem(), miastoField.getText());
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
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

				JOptionPane.showMessageDialog(null, "Dodano wycieczke krajową");

				MenuGlowne mg = new MenuGlowne();
				frame.setVisible(false);
				mg.getFrame().setVisible(true);

			}
		});
		btnNewButton_1.setBounds(155, 226, 117, 29);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton = new JButton("Anuluj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				DodanieWycieczki dw = new DodanieWycieczki();
				frame.setVisible(false);
				dw.getFrame().setVisible(true);
			}
		});
		btnNewButton.setBounds(303, 226, 117, 29);
		frame.getContentPane().add(btnNewButton);

	}

	public JFrame getFrame() {
		return frame;
	}

	public static boolean sprawdzPoprawnoscKraju(String kraj) {
		Pattern pattern = Pattern.compile("[A-Z][a-z]{2,}");
		return pattern.matcher(kraj).matches();
	}

}
