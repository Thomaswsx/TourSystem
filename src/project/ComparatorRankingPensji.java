package project;

import java.util.Comparator;

public class ComparatorRankingPensji implements Comparator<PracownikObslugiKlienta> {

	@Override
	public int compare(PracownikObslugiKlienta o1, PracownikObslugiKlienta o2) {
		if (o1.getPensja() > o2.getPensja()) {
			return -1;
		} else if (o1.getPensja() < o2.getPensja()) {
			return 1;
		} else {
			return 0;
		}
	}

}
