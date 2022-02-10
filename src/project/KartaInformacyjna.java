package project;

public class KartaInformacyjna extends Ekstensja{

	private int ograniczenieWiekowe;
	private String ograniczenieKulturowe;
	private String uwagaDotWycieczki;

	private Wycieczka wycieczka;

	public KartaInformacyjna(int ograniczenieWiekowe, String ograniczenieKulturowe, String uwagaDotWycieczki,
			Wycieczka wycieczka) {
		
		if (wycieczka == null) {
			throw new IllegalArgumentException("Wycieczka jest nullem!");
		}

		this.ograniczenieWiekowe = ograniczenieWiekowe;
		this.ograniczenieKulturowe = ograniczenieKulturowe;
		this.uwagaDotWycieczki = uwagaDotWycieczki;
		this.wycieczka = wycieczka;

		wycieczka.dodajKarteInformacyjna(this);
	}

	public int getOgraniczenieWiekowe() {
		return ograniczenieWiekowe;
	}

	public void setOgraniczenieWiekowe(int ograniczenieWiekowe) {
		this.ograniczenieWiekowe = ograniczenieWiekowe;
	}

	public String getOgraniczenieKulturowe() {
		return ograniczenieKulturowe;
	}

	public void setOgraniczenieKulturowe(String ograniczenieKulturowe) {
		this.ograniczenieKulturowe = ograniczenieKulturowe;
	}

	public String getUwagaDotWycieczki() {
		return uwagaDotWycieczki;
	}

	public void setUwagaDotWycieczki(String uwagaDotWycieczki) {
		this.uwagaDotWycieczki = uwagaDotWycieczki;
	}

	public Wycieczka getWycieczka() {
		return wycieczka;
	}

	public void setWycieczka(Wycieczka wycieczka) {
		this.wycieczka = wycieczka;
	}

	@Override
	public String toString() {
		return ograniczenieWiekowe + " " + ograniczenieKulturowe + " " + uwagaDotWycieczki + " " + wycieczka;
	}

}
