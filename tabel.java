package tabel;

import java.util.ArrayList;
import java.util.List;

public class Tabel {
	
	final List<String> kolomnamen;
	
	final List<KolomType> kolomtypes;
	
	final List<Object[]> rijen = new ArrayList<>();
	
	public Tabel(String[] namen, KolomType[] types) {
		if (namen == null || types == null) {
			throw new IllegalArgumentException();
		}
		if (namen.length != types.length) {
			throw new IllegalArgumentException();
		}
		
		for (int i = 0; i < namen.length; i++) {
			if (namen[i] == null || types[i] == null) {
				throw new IllegalArgumentException();
			}
		}
		
	
		kolomnamen = List.of(namen.clone());
		kolomtypes = List.of(types.clone());
	}

	
	public String[] getKolomNamen() {
		return kolomnamen.toArray(new String[0]);
	}
	
	public KolomType[] getKolomTypes() {
		return kolomtypes.toArray(new KolomType[0]);
	}
	
	public Object[][] getRijen() {
		return rijen.toArray(new Object[0][]);
	}
	
	public int getAantalRijen() {
		return rijen.size();
	}
	
	public int getAantalKolommen() {
		return kolomnamen.size();
	}
	
	public void addRij(Object[] rij) {
		rijen.add(rij);
	}
	
	public void removeRij() {
		rijen.remove(rijen.size()-1);
	}
	
	public Object getWaarde(int rijindex, int kolomindex) {
		return rijen.get(rijindex)[kolomindex];		
	}
	
	public Object[] getRij(int rijindex) {
		return rijen.get(rijindex).clone();		
	}
}
