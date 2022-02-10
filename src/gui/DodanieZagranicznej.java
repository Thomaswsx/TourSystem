package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import project.Ekstensja;
import project.KlientZarejestrowany;
import project.Motyw;
import project.Ocena;
import project.SrodekTransportu;
import project.WycieczkaZagraniczna;

import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

public class DodanieZagranicznej {

	private JFrame frame;
	private JTextField krajField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodanieZagranicznej window = new DodanieZagranicznej();
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
	public DodanieZagranicznej() {
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

		JLabel lblNewLabel = new JLabel("Nowa wycieczka");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(136, 16, 171, 17);
		frame.getContentPane().add(lblNewLabel);

		krajField = new JTextField();
		krajField.setBounds(22, 71, 130, 26);
		frame.getContentPane().add(krajField);
		krajField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Kraj:");
		lblNewLabel_1.setBounds(22, 55, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Środek transportu:");
		lblNewLabel_2.setBounds(260, 55, 130, 17);
		frame.getContentPane().add(lblNewLabel_2);

		JComboBox<SrodekTransportu> srodekTBox = new JComboBox<>();
		srodekTBox.setBounds(260, 71, 117, 29);
		srodekTBox.setModel(new DefaultComboBoxModel<>(SrodekTransportu.values()));
		frame.getContentPane().add(srodekTBox);

		JLabel lblNewLabel_3 = new JLabel("Cena:");
		lblNewLabel_3.setBounds(22, 120, 61, 16);
		frame.getContentPane().add(lblNewLabel_3);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(22, 135, 130, 29);
		frame.getContentPane().add(spinner);

		JLabel lblNewLabel_4 = new JLabel("Motyw:");
		lblNewLabel_4.setBounds(260, 120, 61, 16);
		frame.getContentPane().add(lblNewLabel_4);

		JComboBox<Motyw> motywBox = new JComboBox<>();
		motywBox.setBounds(260, 136, 117, 29);
		motywBox.setModel(new DefaultComboBoxModel<>(Motyw.values()));
		frame.getContentPane().add(motywBox);

		JLabel lblNewLabel_5 = new JLabel("Ocena:");
		lblNewLabel_5.setBounds(22, 177, 61, 16);
		frame.getContentPane().add(lblNewLabel_5);

		JComboBox<Ocena> ocenaBox = new JComboBox<>();
		ocenaBox.setBounds(19, 193, 117, 26);
		ocenaBox.setModel(new DefaultComboBoxModel<>(Ocena.values()));
		frame.getContentPane().add(ocenaBox);
		
		JButton btnNewButton = new JButton("Anuluj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				DodanieWycieczki dw = new DodanieWycieczki();
				frame.setVisible(false);
				dw.getFrame().setVisible(true);
			}
		});
		btnNewButton.setBounds(316, 224, 117, 29);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Zapisz");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dane = "Podałeś złe dane\n";
				boolean flag = false;
				if (!sprawdzPoprawnoscKraju(krajField.getText())) {
					dane += "kraj\n";
					flag = true;
				}
				
				if (flag) {
					JOptionPane.showMessageDialog(null, dane);
					return;
				}

				WycieczkaZagraniczna wz = null;
					try {
						wz = new WycieczkaZagraniczna((int) spinner.getValue(), (Motyw) motywBox.getSelectedItem(),
								(Ocena) ocenaBox.getSelectedItem(), krajField.getText(),
								(SrodekTransportu) srodekTBox.getSelectedItem());
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

				JOptionPane.showMessageDialog(null, "Dodano wycieczke zagraniczną");

				MenuGlowne mg = new MenuGlowne();
				frame.setVisible(false);
				mg.getFrame().setVisible(true);

			}
		});
		btnNewButton_1.setBounds(175, 224, 117, 29);
		frame.getContentPane().add(btnNewButton_1);

	}

	public JFrame getFrame() {
		return frame;
	}

	public static boolean sprawdzPoprawnoscKraju(String kraj) {
		Pattern pattern = Pattern.compile("[A-Z][a-z]{2,}");
		return pattern.matcher(kraj).matches();
	}
}
