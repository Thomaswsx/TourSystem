package project;

import java.io.IOException;

public class WycieczkaZagraniczna extends Wycieczka {

	private String kraj;
	private SrodekTransportu srodekTransportu;

	public WycieczkaZagraniczna(double cena, Motyw motyw, Ocena ocena, String kraj,
			SrodekTransportu srodekTransportu) throws IOException {
		super(cena, motyw, ocena);
		this.kraj = kraj;
		this.srodekTransportu = srodekTransportu;
	}

	public String getKraj() {
		return kraj;
	}

	public void setKraj(String kraj) {
		this.kraj = kraj;
	}

	public SrodekTransportu getSrodekTransportu() {
		return srodekTransportu;
	}

	public void setSrodekTransportu(SrodekTransportu srodekTransportu) {
		this.srodekTransportu = srodekTransportu;
	}

	public String toString() {
		return kraj + " " + srodekTransportu;
	}

}
