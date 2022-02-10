package project;

import java.time.LocalDate;

public class ObslugaKlienta {

	private LocalDate dataObslugiPrzezPracownika;

	private final KlientZarejestrowany klientZarejestrowany;
	private final PracownikObslugiKlienta pracownikObslugiKlienta;

	public ObslugaKlienta(LocalDate dataObslugiPrzezPracownika, KlientZarejestrowany klientZarejestrowany,
			PracownikObslugiKlienta pracownikObslugiKlienta) {

		if (klientZarejestrowany == null || pracownikObslugiKlienta == null) {
			throw new IllegalArgumentException("Klient lub pracownik są nullami!");
		}

		this.dataObslugiPrzezPracownika = dataObslugiPrzezPracownika;
		this.klientZarejestrowany = klientZarejestrowany;
		this.pracownikObslugiKlienta = pracownikObslugiKlienta;

		klientZarejestrowany.getObslugaKlienta().add(this);
		pracownikObslugiKlienta.getObslugaKlienta().add(this);
	}

	public LocalDate getDataObslugiPrzezPracownika() {
		return dataObslugiPrzezPracownika;
	}

	public void setDataObslugiPrzezPracownika(LocalDate dataObslugiPrzezPracownika) {
		this.dataObslugiPrzezPracownika = dataObslugiPrzezPracownika;
	}

	public KlientZarejestrowany getKlientZarejestrowany() {
		return klientZarejestrowany;
	}

	public PracownikObslugiKlienta getPracownikObslugiKlienta() {
		return pracownikObslugiKlienta;
	}

	public String toString() {
		return dataObslugiPrzezPracownika + " "
				+ klientZarejestrowany + " " + pracownikObslugiKlienta;
	}
	
	
	
}
