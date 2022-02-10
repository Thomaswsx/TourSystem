package project;

import java.util.*;

public abstract class Osoba extends Ekstensja{

	private String imie;
	private String nazwisko;
	private List<String> adresyMailowe = new ArrayList<>();
	private String telefon;

	public Osoba(String imie, String nazwisko, String telefon) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.telefon = telefon;
	}

	public void dodajAdresMailowy(String adres) {
		adresyMailowe.add(adres);
	}

	public void usunAdresMailowy(String adres) {
		adresyMailowe.remove(adres);
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public List<String> getAdresyMailowe() {
		return adresyMailowe;
	}

	public void setAdresyMailowe(List<String> adresyMailowe) {
		this.adresyMailowe = adresyMailowe;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String toString() {
		return imie + " " + nazwisko + " " + telefon;
	}

}
