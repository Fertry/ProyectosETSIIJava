package fp.albumes.test;

import fp.albumes.Albumes;
import fp.albumes.FactoriaAlbumes;

public class TestFactoriaAlbumes {
	public static void main(String[] args) {
		testCreacionAlbumes();
	}

	private static void testCreacionAlbumes() {
		System.out.println("\nTEST de la creacion de Albumes");
		try {
			Albumes albumes = FactoriaAlbumes.leerAlbumes("data/500mejores.csv");
			System.out.println("   Albumes: "+ albumes.getAlbumes());
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e);	
		}
	}
}
