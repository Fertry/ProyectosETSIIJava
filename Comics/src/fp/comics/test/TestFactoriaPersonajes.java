package fp.comics.test;
/**
 * @author José A. Troyano
 * 
 * @since 2019-03-27
 */

import fp.comics.FactoriaPersonajes;
import fp.comics.Personajes;

public class TestFactoriaPersonajes {
	
	public static void main(String[] args) {
		testCreacionPersonajes();
	}

	private static void testCreacionPersonajes() {
		System.out.println("\nTEST de la creacion de Personajes");
		try {
			Personajes personajes = FactoriaPersonajes.leerPersonajes("data/characters.csv");
			System.out.println("   PERSONAJES: "+ personajes);
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e);	
		}
	}
}
