package tabel;

import java.util.ArrayList;
import java.util.List;

/**
 * @invar | getKolomNamen() != null
 * @invar | getKolomTypes() != null
 * @invar | getKolomTypes().length == getKolomNamen().length
 * @invar | List.of(getKolomNamen()).stream().allMatch(kn -> kn != null)
 * @invar | List.of(getKolomTypes()).stream().allMatch(kt -> kt != null)
 * @invar | List.of(getRijen()).stream().allMatch(r -> r != null)
 */
public class Tabel {
	
	/**
	 * @invar | kolomnamen != null
	 * @invar | kolomtypes != null
	 * @invar | kolomtypes.size() == kolomnamen.size()
	 * @invar | kolomnamen.stream().allMatch(kn -> kn != null)
	 * @invar | kolomtypes.stream().allMatch(kt -> kt != null)
	 * @invar | rijen != null
	 * @invar | rijen.stream().allMatch(r -> r != null)
	 * @representationObject
	 */
	final List<String> kolomnamen;
	
	/**
	 * @representationObject
	 */
	final List<KolomType> kolomtypes;
	
	/**
	 * @representationObject
	 */
	final List<Object[]> rijen = new ArrayList<>();
	
	/**
	 * @throws IllegalArgumentException | namen == null
	 * @throws IllegalArgumentException | types == null
	 * @throws IllegalArgumentException | namen.length != types.length
	 * @throws IllegalArgumentException | List.of(namen).stream().allMatch(kn -> kn == null)
	 * @throws IllegalArgumentException | List.of(types).stream().allMatch(kt -> kt == null)
	 * @post | getKolomNamen().length == namen.length
	 * @post | getKolomTypes().length == types.length
	 * @post | getRijen().length == 0
	 */
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

	
	/**
	 * @creates | result
	 * @post | result != null
	 * @post | result.length == getAantalKolommen()
	 */
	public String[] getKolomNamen() {
		return kolomnamen.toArray(new String[0]);
	}
	
	/**
	 * @creates | result
	 * @post | result != null
	 * @post | result.length == getAantalKolommen()
	 */
	public KolomType[] getKolomTypes() {
		return kolomtypes.toArray(new KolomType[0]);
	}
	
	/**
	 * @creates | result
	 * @post | result != null
	 * @post | List.of(result).stream().allMatch(r -> r != null)
	 * @post | result.length == getAantalRijen()
	 */
	public Object[][] getRijen() {
		return rijen.toArray(new Object[0][]);
	}
	
	/**
	 * @creates | result
	 * @post | result >= 0
	 */
	public int getAantalRijen() {
		return rijen.size();
	}
	
	/**
	 * @creates | result
	 * @post | result >= 0
	 */
	public int getAantalKolommen() {
		return kolomnamen.size();
	}
	
	/**
	 * @pre | rij != null
	 * @pre | List.of(rij).stream().allMatch(r->r != null)
	 * @post | List.of(getRijen()).contains(rij)
	 * @post | getAantalRijen() == old(getAantalRijen()) + 1
	 */
	public void addRij(Object[] rij) {
		rijen.add(rij);
	}
	
	/**
	 * @pre | getAantalRijen() > 0
	 * @post | getAantalRijen() == old(getAantalRijen()) - 1
	 */
	public void removeRij() {
		rijen.remove(rijen.size()-1);
	}
	
	/**
	 * @pre | 0 <= rijindex && rijindex < getAantalRijen()
	 * @pre | 0 <= kolomindex && kolomindex < getAantalKolommen()
	 * @post | result != null
	 */
	public Object getWaarde(int rijindex, int kolomindex) {
		return rijen.get(rijindex)[kolomindex];		
	}
	
	/**
	 * @pre | 0 <= rijindex && rijindex < getAantalRijen()
	 * @post | result != null
	 * @post | result.length == getAantalKolommen()
	 * @post | List.of(result).stream().allMatch(e->e != null)
	 */
	public Object[] getRij(int rijindex) {
		return rijen.get(rijindex).clone();		
	}
}
