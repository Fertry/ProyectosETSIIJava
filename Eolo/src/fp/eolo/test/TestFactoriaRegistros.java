package fp.eolo.test;
/**
 * @author José A. Troyano
 * 
 * @since 2019-04-02
 */

import fp.eolo.FactoriaRegistros;
import fp.eolo.Registros;

public class TestFactoriaRegistros {
	
	public static void main(String[] args) {
		testCreacionRegistros();
	}

	private static void testCreacionRegistros() {
		System.out.println("\nTEST de la creacion de Registros");
		try {
			Registros registros = FactoriaRegistros.leerRegistros("data/registros_viento.csv");
			System.out.println("   NUMERO DE REGISTROS: "+ registros.getNumeroRegistros());
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e);	
		}
	}
}
