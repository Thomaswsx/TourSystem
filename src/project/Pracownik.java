package project;

public abstract class Pracownik extends Osoba {

	private static double minimalnaPensja = 3000;
	private double pensja;
	private double liczbaPrzepracowanychGodzin;

	private RodzajUmowy rodzajUmowy;

	public Pracownik(String imie, String nazwisko, String telefon, RodzajUmowy rodzajUmowy) {
		super(imie, nazwisko, telefon);
	}

	public Pracownik(String imie, String nazwisko, String telefon) {
		super(imie, nazwisko, telefon);
	}

	public static double getMinimalnaPensja() {
		return minimalnaPensja;
	}

	public static void setMinimalnaPensja(double minimalnaPensja) {
		Pracownik.minimalnaPensja = minimalnaPensja;
	}

	public double getPensja() {
		return pensja;
	}

	public void setPensja(double pensja) {
		this.pensja = pensja;
	}

	public double getLiczbaPrzepracowanychGodzin() {
		return liczbaPrzepracowanychGodzin;
	}

	public void setLiczbaPrzepracowanychGodzin(double liczbaPrzepracowanychGodzin) {
		this.liczbaPrzepracowanychGodzin = liczbaPrzepracowanychGodzin;
	}

	public RodzajUmowy getRodzajUmowy() {
		return rodzajUmowy;
	}

	public void setRodzajUmowy(RodzajUmowy rodzajUmowy) {
		this.rodzajUmowy = rodzajUmowy;
	}

	public String toString() {
		return pensja + " " + liczbaPrzepracowanychGodzin;
	}
}
