package fp.comics.test;

import fp.comics.Personaje;

public class TestPersonaje {
		
	public static void main(String[] args) {	
		testConstructor();
	}
	
	private static void testConstructor() {
		System.out.println("\nTEST del Constructor");
		try {
			Personaje personaje = new Personaje("Batman","Good Characters","Blue Eyes","Black Hair","Male Characters",1939);
			System.out.println("   PERSONAJE: "+ personaje);
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e);	
		}
		
		System.out.println("\nTEST con fallo del Constructor");
		try {
			Personaje personaje = new Personaje("Batman","Good Characters","Blue Eyes","Black Hair","Male Characters",1909);
			System.out.println("   PERSONAJE: "+ personaje);		
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e);	
		}
	}
}
