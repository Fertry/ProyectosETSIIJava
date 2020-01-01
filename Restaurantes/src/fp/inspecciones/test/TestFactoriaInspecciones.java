package fp.inspecciones.test;
/**
 * @author Beatriz Pontes
 * 
 * @since 2019-05-26
 */
import fp.inspecciones.FactoriaInspecciones;
import fp.inspecciones.Inspecciones;

public class TestFactoriaInspecciones {

	public static void main(String[] args) {
		testCreacionInspecciones();

	}
	
	private static void testCreacionInspecciones() {
		System.out.println("\nTEST de la creación de Inspecciones");
		try {
			Inspecciones inspecciones = FactoriaInspecciones.leerInspecciones("data/inspecciones_restaurantes.csv");
			System.out.println("   NÚMERO DE INSPECCIONES: "+ inspecciones.getInspecciones().size());
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e);	
		}
	}

}
