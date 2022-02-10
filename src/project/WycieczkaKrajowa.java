package project;

import java.io.IOException;

public class WycieczkaKrajowa extends Wycieczka {

	private String miasto;

	public WycieczkaKrajowa(double cena, Motyw motyw, Ocena ocena, String miasto) throws IOException{
		super(cena, motyw, ocena);
		this.miasto = miasto;
	}

	public String getMiasto() {
		return miasto;
	}

	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}

	public String toString() {
		return miasto;
	}

}
