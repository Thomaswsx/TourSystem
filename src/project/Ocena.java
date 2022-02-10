package project;

public enum Ocena {
	
	SłABO(1), PRZECIĘTNIE(2), DOBRZE(3), BARDZO_DOBRZE(4), WSPANIALE(5);
	
	public final int ocena;
	
	private Ocena(int ocena) {
		this.ocena = ocena;
	}

	public int getOcena() {
		return ocena;
	}
	
	
	

}
