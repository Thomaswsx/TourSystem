package project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class KlientZarejestrowany extends Klient {

	private int idKlienta;

	private static List<KlientZarejestrowany> ekstensja = new ArrayList<>();

	private List<ObslugaKlienta> obslugaKlienta = new ArrayList<>();

	private List<Wycieczka> wycieczki = new ArrayList<>();
	

	public KlientZarejestrowany(String imie, String nazwisko, String telefon) throws IOException {
		super(imie, nazwisko, telefon);
		
		idKlienta = odczytId();		
		zapisId(idKlienta);

		ekstensja.add(this);
	}

	public static void zapisId(int id) throws IOException {

		FileWriter fw = new FileWriter("idKlienta.txt");
		id++;
		fw.write(String.valueOf(id));
		fw.close();
	}

	public static int odczytId() throws IOException {

		FileReader fr = new FileReader("idKlienta.txt");
		BufferedReader br = new BufferedReader(fr);

		return Integer.parseInt(br.readLine());

	}

	public void usunKlienta(KlientZarejestrowany k) {
		ekstensja.remove(k);
	}

	// Pokazanie, który klient wydał najwięcej
	public static KlientZarejestrowany najwiecejWydal(List<KlientZarejestrowany> lista) {

		if (lista == null || lista.isEmpty()) {
			throw new IllegalArgumentException("Lista jest nullem!");
		}

		KlientZarejestrowany najwiecejWydal = lista.get(0);

		for (KlientZarejestrowany k : lista) {
			if (k.obliczSumeWycieczki() > najwiecejWydal.obliczSumeWycieczki()) {
				najwiecejWydal = k;
			}
		}
		return najwiecejWydal;
	}

	public double obliczSumeWycieczki() {

		double sum = 0;

		for (Wycieczka w : wycieczki) {
			sum += w.getCena();
		}
		return sum;
	}

	public void dodajWycieczke(Wycieczka w) {
		wycieczki.add(w);
	}

	public void usunWycieczke(Wycieczka w) {
		wycieczki.remove(w);
	}

	public static List<KlientZarejestrowany> getEkstensja() {
		return ekstensja;
	}

	public static void setEkstensja(List<KlientZarejestrowany> ekstensja) {
		KlientZarejestrowany.ekstensja = ekstensja;
	}

	public List<ObslugaKlienta> getObslugaKlienta() {
		return obslugaKlienta;
	}

	public void setObslugaKlienta(List<ObslugaKlienta> obslugaKlienta) {
		this.obslugaKlienta = obslugaKlienta;
	}

	public List<Wycieczka> getWycieczki() {
		return wycieczki;
	}

	public void setWycieczki(List<Wycieczka> wycieczki) {
		this.wycieczki = wycieczki;
	}

	public String toString() {
		return getImie() + " " + getNazwisko();
	}

}
