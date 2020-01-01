package fp.eolo.test;
/**
 * @author Jos茅 A. Troyano
 * @author Jos茅 C. Riquelme
 * 
 * @since 2019-04-03
 */

import java.lang.Exception;
import java.lang.String;
import java.lang.System;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import fp.eolo.FactoriaRegistros;
import fp.eolo.Registro;
import fp.eolo.Registros;
import fp.eolo.Viento;

public class TestRegistros {
	private static Registros registros = new Registros();
	
	public static void main(String[] args) {
		testConstructor();
		testA馻dirRegistro();
		testCalcularRegistrosDeViento();
		testCalcularDiasDeVientoEnCiudadEnFechas();
		testObtenerRegistrosMayorVelocidadMaxima();
		testCalcularPromedioVelocidadMediaEnA駉();
		testCalcularVelocidadMediaPorFecha();
		testOrdenarVelocidadesMediasPorFecha();
		testCalcularRegistroMayorVelocidadMaximaPorCiudad();
		//testCalcularVientoPredominanteDeCiudad();
		testCalcularVelocidaMediaDeVientoPorCiudad();
		testGenerarDiagramaBarras();
	}

	
	public static void testConstructor() {
		System.out.println("\nTest del Constructor");
		
		try {
			List<Registro>lista=new ArrayList<Registro>();
			lista.add(new Registro(LocalDate.parse("2000-01-01"),"Ja茅n",190.0,3.96,16.92));
			lista.add(new Registro(LocalDate.parse("2000-01-02"),"Ja茅n",185.0,5.04,15.12));
			lista.add(new Registro(LocalDate.parse("2000-01-03"),"Ja茅n",180.0,5.04,16.92));
			lista.add(new Registro(LocalDate.parse("2000-01-04"),"Ja茅n",170.0,2.16,25.92));
			lista.add(new Registro(LocalDate.parse("2000-01-05"),"Ja茅n",155.0,6.12,12.96));
			lista.add(new Registro(LocalDate.parse("2000-01-06"),"Ja茅n",140.0,5.04,21.96));
			lista.add(new Registro(LocalDate.parse("2000-01-07"),"Ja茅n",150.0,1.08,19.08));
			lista.add(new Registro(LocalDate.parse("2000-01-08"),"Ja茅n",230.0,2.16,14.04));
			lista.add(new Registro(LocalDate.parse("2000-01-09"),"Ja茅n",170.0,2.88,14.04));
			
			registros = new Registros(lista.stream());	
	    	System.out.println("   REGISTROS: "+ registros);
	    } catch (Exception e) {
	    	System.out.println("Excepci髇 capturada:\n   " + e);
	    }
	}

	public static void testA馻dirRegistro() {
		System.out.println("\nTest de a馻dirRegistro");
		try {
			registros.a馻dirRegistro(new Registro(LocalDate.parse("2000-01-10"),"Ja閚",140.0,6.84,47.16));
		    System.out.println("   REGISTROS: "+ registros);
		} catch (Exception e) {
			System.out.println("Excepci髇 capturada:\n   " + e);
		}
	}

	
	public static void testCalcularRegistrosDeViento() {
	    System.out.println("\nTest de calcularRegistrosDeViento");
	    try {
	    	Registros registros = FactoriaRegistros.leerRegistros("data/registros_viento.csv");
	    	Viento viento = Viento.LEVANTICHON;
	    	System.out.println("   VIENTO: "+ viento);
	    	Collection<Registro> coleccionRegistros = registros.calcularRegistrosDeViento(viento);
	    	System.out.println("   NUMERO DE REGISTROS: "+ coleccionRegistros.size());
	    } catch (Exception e) {
	    	System.out.println("Excepci贸n capturada:\n   " + e);
	    }
	}
	
	public static void testCalcularDiasDeVientoEnCiudadEnFechas() {
	    System.out.println("\nTest de calcularDiasDeVientoEnCiudadEnFechas");
	    try {
	    	Registros registros = FactoriaRegistros.leerRegistros("data/registros_viento.csv");
	    	String ciudad = "Tarifa";
	    	Viento viento = Viento.LEVANTE;
	    	LocalDate fechaInicio = LocalDate.parse("2008-10-01");
	    	LocalDate fechaFin = LocalDate.parse("2008-10-31");
	    	System.out.println("   VIENTO: " + viento);
	    	System.out.println("   CIUDAD: " + ciudad);
	    	System.out.println("   FECHA INICIO: " + fechaInicio);
	    	System.out.println("   FECHA FIN: " + fechaFin);
	    	System.out.println("   DIAS: "+ 
	    	                   registros.calcularDiasDeVientoEnCiudadEnFechas(viento, ciudad, fechaInicio, fechaFin));  
	    } catch (Exception e) {
	    	System.out.println("Excepci贸n capturada:\n   " + e);
	    }
	}
	
	public static void testObtenerRegistrosMayorVelocidadMaxima() {
	    System.out.println("\nTest de obtenerRegistrosMayorVelocidadMaxima");
	    try {
	    	Registros registros = FactoriaRegistros.leerRegistros("data/registros_viento.csv");
	    	System.out.println("   REGISTROS: "+ registros.obtenerRegistrosMayorVelocidadMaxima(5));
	    } catch (Exception e) {
	    	System.out.println("Excepci贸n capturada:\n   " + e);
	    }
	}
	
	
	public static void testCalcularPromedioVelocidadMediaEnA駉() {
	    System.out.println("\nTest de calcularPromedioVelocidadMediaEnA帽o");
	    try {
	    	Registros registros = FactoriaRegistros.leerRegistros("data/registros_viento.csv");
	    	Integer a駉 = 2001;
	    	System.out.println("   A脩O: "+ a駉);
	    	System.out.println("   VELOCIDAD PROMEDIO: "+ registros.calcularPromedioVelocidadMediaEnA駉(a駉));
	    } catch (Exception e) {
	    	System.out.println("Excepci贸n capturada:\n   " + e);
	    }
	}
	
	public static void testCalcularVelocidadMediaPorFecha() {
	    System.out.println("\nTest de calcularVelocidadMediaPorFecha");
	    try {
	    	Registros registros = FactoriaRegistros.leerRegistros("data/registros_viento.csv");
	    	Map<LocalDate, Double> velocidades = registros.calcularVelocidadMediaPorFecha();
	    	LocalDate fecha = LocalDate.parse("2000-01-01");
	    	System.out.println("   FECHA: "+ fecha);
	    	System.out.println("   N脷MERO DE FECHAS: "+ velocidades.size());
	    	System.out.println("   MEDIA PARA "+ fecha + ": " + velocidades.get(fecha));
	    } catch (Exception e) {
	    	System.out.println("Excepci贸n capturada:\n   " + e);
	    }
	}
	
	
	public static void testOrdenarVelocidadesMediasPorFecha() {
	    System.out.println("\nTest de ordenarVelocidadesMediasPorFecha");
	    try {
	    	Registros registros = FactoriaRegistros.leerRegistros("data/registros_viento.csv");
	    	System.out.println("   VELOCIDADES: "+ registros.ordenarVelocidadesMediasPorFecha(5));
	    } catch (Exception e) {
	    	System.out.println("Excepci贸n capturada:\n   " + e);
	    }
	}
	
	public static void testCalcularRegistroMayorVelocidadMaximaPorCiudad() {
	    System.out.println("\nTest de calcularRegistroMayorVelocidadMaximaPorCiudad");
	    try {
	    	Registros registros = FactoriaRegistros.leerRegistros("data/registros_viento.csv");
	    	System.out.println("   REGISTROS: "+ registros.calcularRegistroMayorVelocidadMaximaPorCiudad());
	    } catch (Exception e) {
	    	System.out.println("Excepci贸n capturada:\n   " + e);
	    }
	}
	
	
	/*
	 * public static void testCalcularVientoPredominanteDeCiudad() {
	 * System.out.println("\nTest de calcularVientoPredominanteDeCiudad"); try {
	 * Registros registros =
	 * FactoriaRegistros.leerRegistros("data/registros_viento.csv"); String ciudad =
	 * "C谩diz"; System.out.println("   CIUDAD: "+ ciudad);
	 * System.out.println("   VIENTO: "+
	 * registros.calcularVientoPredominanteDeCiudad(ciudad));
	 * 
	 * ciudad = "Tarifa"; System.out.println("   CIUDAD: "+ ciudad);
	 * System.out.println("   VIENTO: "+
	 * registros.calcularVientoPredominanteDeCiudad(ciudad)); } catch (Exception e)
	 * { System.out.println("Excepci贸n capturada:\n   " + e); } }
	 */
	
	
	public static void testCalcularVelocidaMediaDeVientoPorCiudad() {
	    System.out.println("\nTest de calcularVelocidaMediaDeVientoPorCiudad");
	    try {
	    	Registros registros = FactoriaRegistros.leerRegistros("data/registros_viento.csv");
	    	Viento viento = Viento.LEVANTE;
	    	System.out.println("   VIENTO: "+ viento);
	    	System.out.println("   VELOCIDADES: "+ registros.calcularVelocidadMediaDeVientoPorCiudad(viento));
	    } catch (Exception e) {
	    	System.out.println("Excepci贸n capturada:\n   " + e);
	    }
	}
	

	public static void testGenerarDiagramaBarras() {
	    System.out.println("\nTest de generarDiagramaBarras");
	    try {
	    	Registros registros = FactoriaRegistros.leerRegistros("data/registros_viento.csv");
	    	
	    	registros.generarDiagramaBarras("levante_poniente.html",Viento.LEVANTE, Viento.PONIENTE);
	    	System.out.println("  DIAGRAMA GENERADO EN ./out/levante_poniente.html");
	    	
	    	registros.generarDiagramaBarras("norte_sur.html",Viento.NORTE, Viento.SUR);
	    	System.out.println("  DIAGRAMA GENERADO EN ./out/norte_sur.html");

	    } catch (Exception e) {
	    	System.out.println("Excepci贸n capturada:\n   " + e);
	    }
	}
	
}