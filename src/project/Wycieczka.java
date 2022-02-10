package project;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public abstract class Wycieczka extends Ekstensja{

	private int idWycieczki;
	private double cena;
	private Motyw motyw;
	private Ocena ocena;

	private Przewodnik przewodnik;

	private List<KlientZarejestrowany> klienciZarejestrowani = new ArrayList<>();

	private List<KartaInformacyjna> kartyInformacyjne = new ArrayList<>();

	public Wycieczka(double cena, Motyw motyw, Ocena ocena) throws IOException {
		this.cena = cena;
		this.motyw = motyw;
		this.ocena = ocena;

		idWycieczki = odczytId();
		zapisId(idWycieczki);
	}

	public static void zapisId(int id) throws IOException {
		FileWriter fw = new FileWriter("idWycieczki.txt");
		id++;
		fw.write(String.valueOf(id));
		fw.close();
	}

	public static int odczytId() throws IOException {

		FileReader fr = new FileReader("idWycieczki.txt");
		BufferedReader br = new BufferedReader(fr);

		return Integer.parseInt(br.readLine());
	}

	public void dodajKarteInformacyjna(KartaInformacyjna ki) {
		kartyInformacyjne.add(ki);
	}

	public void usunKarteInformacyjna(KartaInformacyjna ki) {
		kartyInformacyjne.remove(ki);
	}

	public void dodajKlienta(KlientZarejestrowany kz) {
		klienciZarejestrowani.add(kz);
		kz.dodajWycieczke(this);
	}

	public void usunKlienta(KlientZarejestrowany kz) {
		klienciZarejestrowani.remove(kz);
		kz.getWycieczki().remove(this);
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public Motyw getMotyw() {
		return motyw;
	}

	public void setMotyw(Motyw motyw) {
		this.motyw = motyw;
	}

	public Ocena getOcena() {
		return ocena;
	}

	public void setOcena(Ocena ocena) {
		this.ocena = ocena;
	}

	public List<KartaInformacyjna> getKartyInformacyjne() {
		return kartyInformacyjne;
	}

	public void setKartyInformacyjne(List<KartaInformacyjna> kartyInformacyjne) {
		this.kartyInformacyjne = kartyInformacyjne;
	}

	public Przewodnik getPrzewodnik() {
		return przewodnik;
	}

	public void setPrzewodnik(Przewodnik przewodnik) {
		this.przewodnik = przewodnik;
	}

	public List<KlientZarejestrowany> getKlienciZarejestrowani() {
		return klienciZarejestrowani;
	}

	public void setKlienciZarejestrowani(List<KlientZarejestrowany> klienciZarejestrowani) {
		this.klienciZarejestrowani = klienciZarejestrowani;
	}

	public String toString() {
		return idWycieczki + " " + cena + " " + motyw + " " + ocena;
	}

}
