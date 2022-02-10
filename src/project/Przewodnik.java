package project;

import java.util.*;

public class Przewodnik extends Pracownik {

	private List<String> jezyki = new ArrayList<>();

	private List<Wycieczka> wycieczki = new ArrayList<>();

	public Przewodnik(String imie, String nazwisko, String telefon) {
		super(imie, nazwisko, telefon);
	}

	public void dodajWycieczke(Wycieczka w) {
		if (w.getPrzewodnik() != null) {
			throw new IllegalArgumentException("Wycieczka ma już przypisanego przewodnika!");
		}
		wycieczki.add(w);
		w.setPrzewodnik(this);
	}

	public void usunWycieczke(Wycieczka w) {
		wycieczki.remove(w);
		w.setPrzewodnik(null);
	}

	public void dodajJezyk(String jezyk) {
		jezyki.add(jezyk);
	}

	public void usunJezyk(String jezyk) {
		jezyki.remove(jezyk);
	}

	public List<String> getJezyki() {
		return jezyki;
	}

	public void setJezyki(List<String> jezyki) {
		this.jezyki = jezyki;
	}

	public List<Wycieczka> getWycieczki() {
		return wycieczki;
	}

	public void setWycieczki(List<Wycieczka> wycieczki) {
		this.wycieczki = wycieczki;
	}

	@Override
	public String toString() {
		return jezyki + " ";
	}

}
