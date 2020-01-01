package fp.eolo.test;
/**
 * @author José A. Troyano
 * 
 * @since 2019-04-02
 */

import java.time.LocalDate;
import fp.eolo.Registro;

public class TestRegistro {
		
	public static void main(String[] args) {	
		testConstructor();
	}
	
	private static void testConstructor() {
		System.out.println("\nTEST del Constructor");
		try {
			
			Registro registro = new Registro(LocalDate.parse("2000-01-01"),"Jaén",190.0,3.96,16.92);
			System.out.println("   REGISTRO: "+ registro);		
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e);	
		}
		
		System.out.println("\nTEST con fallo del Constructor");
		try {
			Registro registro = new Registro(LocalDate.parse("2000-01-01"),"Jaén",190.0,23.96,16.92);
			System.out.println("   REGISTRO: "+ registro);		
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e);	
		}
	}
}
