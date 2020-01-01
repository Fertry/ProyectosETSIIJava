package fp.inspecciones.test;
/**
 * @author Beatriz Pontes
 * 
 * @since 2019-05-26
 */

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

import fp.inspecciones.Distrito;
import fp.inspecciones.FactoriaInspecciones;
import fp.inspecciones.Inspeccion;
import fp.inspecciones.Inspecciones;

public class TestInspecciones {
	
	private static Inspecciones inspecciones = FactoriaInspecciones.leerInspecciones("data/inspecciones_restaurantes.csv");

	public static void main(String[] args) {
		testObtenerInspeccionesMasRecientes();
		testObtenerNombresRestaurantesdeTipoCocina();
		testCalcularMediaScores();
		testObtenerRestauranteCritico();
		//testMostrarInformeInspecciones();
		//testObtenerInspeccionMasReciente();
		//testObtenerInspeccionesEnFechas();
		//testObtenerInspeccionesPorRestaurante();
		//testObtenerRestauranteMasInspecciones();
		//testObtenerDistritoMasInspeccionesCriticas();
		//testObtenerDescripcionInspeccionMayorPuntuacionPorNombre();
		//testGenerarFicheroInspeccionesEnDistritoYFecha();
		//testGenerarDiagramaBurbujas();
	}
	
	private static void testObtenerInspeccionesMasRecientes() {
		System.out.println("\nTest de getInspeccionesMasRecientes");
		try {
	    	List<Inspeccion> coleccionInsp = inspecciones.obtenerInspeccionesMasRecientes();
	    	System.out.println("   NÃšMERO DE INSPECCIONES: "+ coleccionInsp.size());	    	
		} catch (Exception e) {
			System.out.println("ExcepciÃ³n capturada:\n   " + e);
		}
	}
	
	private static void testObtenerNombresRestaurantesdeTipoCocina() {
		System.out.println("\nTest de obtenerNombresRestaurantesdeTipoCocina");
		try {
			String tipo = "Ice Cream. Gelato. Yogurt. Ices";
			System.out.println("   TIPO: " + tipo);
	    	SortedSet<String> conjuntoInsp = inspecciones.obtenerNombresRestaurantesdeTipoCocina(tipo);
	    	System.out.println("   NÃšMERO DE RESTAURANTES: "+ conjuntoInsp.size());
	    	System.out.println("   PRIMER RESTAURANTE: " + conjuntoInsp.first());
	    	System.out.println("   ULTIMO RESTAURANTE: " + conjuntoInsp.last());
		} catch (Exception e) {
			System.out.println("ExcepciÃ³n capturada:\n   " + e);
		}
	}
	
	private static void testCalcularMediaScores() {
		System.out.println("\nTest de getMediaScores");
		try {
			String nombre = "DUNKIN' DONUTS";
			System.out.println("   RESTAURANTE: " + nombre);
	    	Double meanSc = inspecciones.calcularMediaScores(nombre);
	    	System.out.println("   MEDIA DE SCORES: "+ meanSc);
		} catch (Exception e) {
			System.out.println("ExcepciÃ³n capturada:\n   " + e);
		}
	}
	
	private static void testObtenerRestauranteCritico() {
		System.out.println("\nTest de getRestauranteCritico");
		try {
	    	String restaurante = inspecciones.obtenerRestauranteCritico();
	    	System.out.println("   RESTAURANTE CRÃ�TICO: "+ restaurante);
		} catch (Exception e) {
			System.out.println("ExcepciÃ³n capturada:\n   " + e);
		}
	}
	
	/*
	 * private static void testMostrarInformeInspecciones() {
	 * System.out.println("\nTest de imprimeInformeInspecciones"); try { String
	 * nombre = "CAFE CLASSICO"; System.out.println("   RESTAURANTE: " + nombre);
	 * inspecciones.mostrarInformeInspecciones(nombre); } catch (Exception e) {
	 * System.out.println("ExcepciÃ³n capturada:\n   " + e); } }
	 * 
	 * private static void testObtenerInspeccionMasReciente() {
	 * System.out.println("\nTest de inspeccionMasReciente"); try { Inspeccion insp
	 * = inspecciones.obtenerInspeccionMasReciente();
	 * System.out.println("   INSPECCIÃ“N MAS RECIENTE: "+ insp); } catch (Exception
	 * e) { System.out.println("ExcepciÃ³n capturada:\n   " + e); } }
	 * 
	 * private static void testObtenerInspeccionesEnFechas() {
	 * System.out.println("\nTest de inspeccionesEnFechas"); try { LocalDate f1 =
	 * LocalDate.of(2015, 04, 15); LocalDate f2 = LocalDate.of(2015, 04, 18);
	 * System.out.println("   FECHAS: " + f1 + ", " + f2); SortedSet<Inspeccion> ss
	 * = inspecciones.obtenerInspeccionesEnFechas(f1, f2); System.out.println("   "
	 * + ss.first()); System.out.println("   " + ss.last()); } catch (Exception e) {
	 * System.out.println("ExcepciÃ³n capturada:\n   " + e); } }
	 * 
	 * private static void testObtenerInspeccionesPorRestaurante() {
	 * System.out.println("\nTest de inspeccionesPorRestaurante"); try { Map<String,
	 * List<Inspeccion>> insPorRest =
	 * inspecciones.obtenerInspeccionesPorRestaurante(); for(Map.Entry<String,
	 * List<Inspeccion>> e: insPorRest.entrySet()) { System.out.println("   " +
	 * e.getKey() + ": " + e.getValue().size()); } } catch (Exception e) {
	 * System.out.println("ExcepciÃ³n capturada:\n   " + e); } }
	 * 
	 * private static void testObtenerRestauranteMasInspecciones() {
	 * System.out.println("\nTest de restauranteMasInspecciones"); try { String
	 * restaurante = inspecciones.obtenerRestauranteMasInspecciones();
	 * System.out.println("   RESTAURANTE CON MAS INSPECCIONES: "+ restaurante); }
	 * catch (Exception e) { System.out.println("ExcepciÃ³n capturada:\n   " + e); }
	 * }
	 * 
	 * private static void testObtenerDistritoMasInspeccionesCriticas() {
	 * System.out.println("\nTest de distritoMasInspeccionesCriticas"); try {
	 * Distrito dist = inspecciones.obtenerDistritoMasInspeccionesCriticas();
	 * System.out.println("   DISTRITO CON MAS INSPECCIONES CRÃ�TICAS: "+ dist); }
	 * catch (Exception e) { System.out.println("ExcepciÃ³n capturada:\n   " + e); }
	 * }
	 * 
	 * private static void
	 * testObtenerDescripcionInspeccionMayorPuntuacionPorNombre() { System.out.
	 * println("\nTest de obtenerDescripcionInspeccionMayorPuntuacionPorNombre");
	 * try { Map<String, String> descPorRest =
	 * inspecciones.obtenerDescripcionInspeccionMayorPuntuacionPorNombre(); String
	 * local = "DUNKIN' DONUTS"; System.out.println("   RESTAURANTE: "+ local);
	 * System.out.println("   " + descPorRest.get(local)); } catch (Exception e) {
	 * System.out.println("ExcepciÃ³n capturada:\n   " + e); } }
	 * 
	 * private static void testGenerarFicheroInspeccionesEnDistritoYFecha() {
	 * System.out.println("\nTest de generarFicheroInspeccionesEnDistritoYFecha");
	 * try { String fichero = "out/inspeccionesBrooklyn12_10_2017.info";
	 * inspecciones.generarFicheroInspeccionesEnDistritoYFecha(fichero,
	 * Distrito.BROOKLYN, LocalDate.of(2017, 5, 18));
	 * System.out.println("   FICHERO GENERADO EN : "+ fichero); } catch (Exception
	 * e) { System.out.println("ExcepciÃ³n capturada:\n   " + e); } }
	 * 
	 * public static void testGenerarDiagramaBurbujas() {
	 * System.out.println("\nTest de generarDiagramaBurbujas"); try {
	 * inspecciones.generarDiagramaBurbujas("diagrama_burbujas.html");
	 * System.out.println("   DIAGRAMA GENERADO EN ./out/diagrama_burbujas.html"); }
	 * catch (Exception e) { System.out.println("ExcepciÃ³n capturada:\n   " + e); }
	 * }
	 */


}
