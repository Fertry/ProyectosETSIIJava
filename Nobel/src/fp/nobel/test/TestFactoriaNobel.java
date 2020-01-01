package fp.nobel.test;
/**
 * @author Daniel Mateos
 * @author José A. Troyano
 * 
 * @since 2019-03-05
 */

import fp.nobel.FactoriaNobel;

public class TestFactoriaNobel {
	
	public static void main(String[] args) {
		testCreacionPremios();
	}

	private static void testCreacionPremios() {
		System.out.println("\nTEST de la creacion de Premios");
		try {
			Premios premios = FactoriaNobel.leerPremios("data/nobel_prizes.csv");
			System.out.println("   PREMIOS: "+ premios);
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e);	
		}
	}
}
