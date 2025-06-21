package testsuite;

import tabel.IntKolomType;
import tabel.KolomType;
import tabel.StringKolomType;
import tabel.Tabel;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class TabelTest {

	StringKolomType skt1 = new StringKolomType(10);
	IntKolomType ikt1 = new IntKolomType(10,100);
	String[] kolomnamen1 = {"abc","ac"};
	KolomType[] kolomtypes1 = {skt1,ikt1};
	Tabel t1 = new Tabel(kolomnamen1,kolomtypes1);
	Object[] rij1 = {3, "abc"};
	
	@Test
	void testStringKolomTypeConstructor() {
		assertEquals(10, skt1.getMaximumLengte());
	}
	
	@Test
	void testIsGeldigeWaardeString() {
		String s1 = "abcd";
		assertEquals(true, skt1.isGeldigeWaarde(s1));
	}
	
	@Test
	void testIntKolomTypeConstructor() {
		assertEquals(100, ikt1.getMaximumWaarde());
		assertEquals(10, ikt1.getMinimumWaarde());
	}
	
	@Test
	void testIsGeldigeWaardeInt() {
		int i1 = 24;
		assertEquals(true, ikt1.isGeldigeWaarde(i1));
	}
	
	@Test
	void testTabelConstructor() {
		assertArrayEquals(kolomnamen1,t1.getKolomNamen());
		assertArrayEquals(kolomtypes1,t1.getKolomTypes());
		assertEquals(2,t1.getAantalKolommen());
		assertEquals(0,t1.getAantalRijen());
	}
	@Test
	void testAddRij() {
		assertEquals(0,t1.getAantalRijen());
		t1.addRij(rij1);
		assertEquals(1,t1.getAantalRijen());
		Object[][] result = {rij1};
		assertArrayEquals(result,t1.getRijen());
	}
	
	@Test
	void testRemoveRij() {
		assertEquals(0,t1.getAantalRijen());
		t1.addRij(rij1);
		assertEquals(1,t1.getAantalRijen());
		t1.removeRij();
		assertEquals(0,t1.getAantalRijen());
	}
	
	@Test
	void testGetRij() {
		t1.addRij(rij1);
		assertArrayEquals(rij1,t1.getRij(0));
	}
	
	@Test
	void testGetWaarde() {
		t1.addRij(rij1);
		assertEquals(3,t1.getWaarde(0,0));
	}
	
	@Test
	void testEquals() {
		StringKolomType skt2 = new StringKolomType(10);
		IntKolomType ikt2 = new IntKolomType(10,100);
		String[] kolomnamen2 = {"abc","ac"};
		KolomType[] kolomtypes2 = {skt2,ikt2};
		Tabel t2 = new Tabel(kolomnamen2,kolomtypes2);
		
		assertEquals(t1,t2);
		assertEquals(skt1,skt2);
		assertEquals(ikt1,ikt2);
		
	}

}
