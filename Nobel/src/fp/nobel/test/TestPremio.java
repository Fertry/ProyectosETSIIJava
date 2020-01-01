package fp.nobel.test;
/**
 * @author Daniel Mateos
 * @author José A. Troyano
 * 
 * @since 2019-02-26
 */

import fp.nobel.Genero;
import fp.nobel.Premio;

public class TestPremio {
		
	public static void main(String[] args) {	
		testConstructor();
	}
	
	private static void testConstructor() {
		System.out.println("\nTEST del Constructor");
		try {
			Premio premio = new Premio(1901,"physics","Wilhelm Conrad","Röntgen",Genero.MALE,1845);
			System.out.println("   PREMIO: "+ premio);		
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e);	
		}
		
		System.out.println("\nTEST con fallo del Constructor");
		try {
			Premio premio = new Premio(1801,"physics","Wilhelm Conrad","Röntgen",Genero.MALE,1845);
			System.out.println("   PREMIO: "+ premio);		
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e);	
		}
	}
}
