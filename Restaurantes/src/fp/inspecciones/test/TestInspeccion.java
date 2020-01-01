package fp.inspecciones.test;
/**
 * @author Beatriz Pontes
 * 
 * @since 2019-05-26
 */

import java.time.LocalDate;

import fp.inspecciones.Distrito;
import fp.inspecciones.Inspeccion;

public class TestInspeccion {

	public static void main(String[] args) {
		testConstructor();
	}
	
	private static void testConstructor() {
		System.out.println("\nTEST del Constructor");
		try {
			Inspeccion inspeccion = new Inspeccion("40376944","TOMOE SUSHI", Distrito.MANHATTAN, "Japanese", LocalDate.of(2015, 6, 10),
					"Cold food item held above (smoked fish and reduced oxygen packaged foods above 38 )", true, 13.0);
			System.out.println("   INSPECCIÓN: "+ inspeccion);			
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e);	
		}
		
		System.out.println("\nTEST con fallo del Constructor");
		try {
			Inspeccion inspeccion = new Inspeccion("40376944","TOMOE SUSHI", Distrito.MANHATTAN, "Japanese", LocalDate.of(2015, 6, 10),
					"Cold food item held above (smoked fish and reduced oxygen packaged foods above 38 )", true, 13.0);
			System.out.println("   INSPECCIÓN: "+ inspeccion);	
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e);	
		}
	}

}
