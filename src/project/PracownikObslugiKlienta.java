package project;

import java.util.*;

public class PracownikObslugiKlienta extends Pracownik{
	
	private List<ObslugaKlienta> obslugaKlienta = new ArrayList<>();

	public PracownikObslugiKlienta(String imie, String nazwisko, String telefon) {
		super(imie, nazwisko, telefon);
	}

	public List<ObslugaKlienta> getObslugaKlienta() {
		return obslugaKlienta;
	}

	public void setObslugaKlienta(List<ObslugaKlienta> obslugaKlienta) {
		this.obslugaKlienta = obslugaKlienta;
	}
	
	public static List<PracownikObslugiKlienta> wyliczRanking(List<PracownikObslugiKlienta> lista){
		
		List<PracownikObslugiKlienta> najlepszeZarobki = new ArrayList<>();
	
		if(lista == null) {
			throw new IllegalArgumentException("Lista jest nullem!");
		}
		
		Collections.sort(lista, new ComparatorRankingPensji());

		Iterator<PracownikObslugiKlienta> campIterator = lista.iterator();
		
		for (PracownikObslugiKlienta p : lista) {
			while (campIterator.hasNext()) {
				p = campIterator.next();
				najlepszeZarobki.add(p);
			}
		}
		return najlepszeZarobki;
	}
		
//		for(PracownikObslugiKlienta p : lista.sort(Comparator<PracownikObslugiKlienta>)) {
//			
//		}
		
//		Collections.sort(lista, new Comparator<PracownikObslugiKlienta>() {
//		    public int compare(PracownikObslugiKlienta o1, PracownikObslugiKlienta o2) {
//		    	List<PracownikObslugiKlienta> najlepszeZarobki = new ArrayList<>();
//		        if (o1.getPensja() > o2.getPensja()) {
//		        	najlepszeZarobki.add(o1);
//		        	
//		        }
//				return 0;
//		    }
//		    
//		});
//		return najlepszeZarobki;
//		
//	}
	
}
