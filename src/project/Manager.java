package project;

public class Manager extends Pracownik {
	
	private double premiaZaOstatniMiesiac;
	public Manager(String imie, String nazwisko, String telefon) {
		super(imie, nazwisko, telefon);
	}
	public double getPremiaZaOstatniMiesiac() {
		return premiaZaOstatniMiesiac;
	}
	public void setPremiaZaOstatniMiesiac(double premiaZaOstatniMiesiac) {
		this.premiaZaOstatniMiesiac = premiaZaOstatniMiesiac;
	}

	// pomyslec by stworzyc przykladowy system premiowy np: jesli pracownik
	// przepracuje wieksza ilosc godzin to wlicza sie ona do pensji

	// pomyslec by stworzyc typ wyliczalny dla roznych aktywnosci premiowania np:
	// skonczenie udzial w innych aktywnosciach firmy = $$$

//	public double premiaZaOstatniMiesiac() {
//
//	}
	
	

}
