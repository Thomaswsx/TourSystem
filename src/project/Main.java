package project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) throws IOException {

		// wczytanie ekstensji
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("BazaDanych"))) {
			Ekstensja.load(ois);
		} catch (Exception e) {
			System.out.println("Brak ekstensji");
		}

		try {
			for (KlientZarejestrowany kz : Ekstensja.getEkstensja(KlientZarejestrowany.class)) {
				System.out.println(kz.getWycieczki());
			}
		} catch (NullPointerException e) {
			System.out.println("brak klientow");
		}

//		try {
//			for (WycieczkaZagraniczna wz : Ekstensja.getEkstensja(WycieczkaZagraniczna.class)) {
//				System.out.println(wz);
//			}
//		} catch (NullPointerException e) {
//			System.out.println("brak wycieczki zagranicznej");
//		}

//		try {
//			for (WycieczkaKrajowa wk : Ekstensja.getEkstensja(WycieczkaKrajowa.class)) {
//				System.out.println(wk);
//			}
//		} catch (NullPointerException e) {
//			System.out.println("brak wycieczki krajowej");
//		}

//		KlientZarejestrowany k1 = new KlientZarejestrowany("Adam", "Nowak" , "2131231");
//		KlientZarejestrowany k2 = new KlientZarejestrowany("Ania", "Kowalska" , "2131231");
//		KlientZarejestrowany k3 = new KlientZarejestrowany("Ola", "Wisniewska" , "2131231");
//		KlientZarejestrowany k4 = new KlientZarejestrowany("Test", "Test" , "2131231");
//		// zapis za pomoc serializacji
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("BazaDanych"));
//		Ekstensja.save(oos);
//		oos.close();

	}

}
