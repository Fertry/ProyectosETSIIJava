package fp.comics.test;

/**
 * @author José A. Troyano
 * 
 * @since 2019-03-29
 */

import java.util.ArrayList;
import java.util.List;

import fp.comics.FactoriaPersonajes;
import fp.comics.Personaje;
import fp.comics.Personajes;

public class TestPersonajes {
	private static Personajes personajes = new Personajes();
	
	public static void main(String[] args) {
		testConstructor();
	    testAñadirPersonaje();
		testObtenerPersonajesDeSexoOrdenados();
		testObtenerPersonajesOrdenadosPorPelo();
		testHayPersonajePeloOjos();
	    testObtenerValoresAtributo();
	    testCalcularAñoPrimerPersonajePorPelo();
	    testGenerarDiagramaSankey();
	}

	public static void testConstructor() {
	    System.out.println("\nTest del Constructor");
	    
	    try {
	    	List<Personaje> lista =new ArrayList<Personaje>();
	    	lista.add(new Personaje("Batman","Good Characters","Blue Eyes","Black Hair","Male Characters",1939));
	    	lista.add(new Personaje("Superman","Good Characters","Blue Eyes","Black Hair","Male Characters",1986));
	    	lista.add(new Personaje("Green Lantern","Good Characters","Brown Eyes","Brown Hair","Male Characters",1959));
	    	lista.add(new Personaje("James Gordon","Good Characters","Brown Eyes","White Hair","Male Characters",1987));
	    	lista.add(new Personaje("Richard Grayson","Good Characters","Blue Eyes","Black Hair","Male Characters",1940));
	    	lista.add(new Personaje("Wonder Woman","Good Characters","Blue Eyes","Black Hair","Female Characters",1941));
	    	lista.add(new Personaje("Aquaman","Good Characters","Blue Eyes","Blond Hair","Male Characters",1941));
	    	lista.add(new Personaje("Timothy Drake","Good Characters","Blue Eyes","Black Hair","Male Characters",1989));
	    	lista.add(new Personaje("Dinah Laurel Lance","Good Characters","Blue Eyes","Blond Hair","Female Characters",1969));
	    
	    	personajes=new Personajes(lista.stream());	
	    	System.out.println("   PERSONAJES: "+ personajes);
	    } catch (Exception e) {
	    	System.out.println("Excepción capturada:\n   " + e);
	    }
	}
	
	public static void testAñadirPersonaje() {
		System.out.println("\nTest de añadirPersonaje");
		try {
			personajes.añadirPersonaje(new Personaje("Flash","Good Characters","Blue Eyes","Blond Hair","Male Characters",1956));
		    System.out.println("   PERSONAJES: "+ personajes);
		} catch (Exception e) {
			System.out.println("Excepción capturada:\n   " + e);
		}
	}
	
	public static void testObtenerPersonajesDeSexoOrdenados() {
	    System.out.println("\nTest de obtenerPersonajesDeSexoOrdenados");
	    try {
	    	System.out.println("   PERSONAJES: "+ personajes.obtenerPersonajesDeSexoOrdenados("Male Characters"));
	    } catch (Exception e) {
	    	System.out.println("Excepción capturada:\n   " + e);
	    }
	}
	
	public static void testObtenerPersonajesOrdenadosPorPelo() {
	    System.out.println("\nTest de obtenerPersonajesOrdenadosPorPelo");
	    try {
	    	System.out.println("   PERSONAJES: "+ personajes.obtenerPersonajesOrdenadosPorPelo());
	    } catch (Exception e) {
	    	System.out.println("Excepción capturada:\n   " + e);
	    }
	}
	
	public static void testHayPersonajePeloOjos() {
	    System.out.println("\nTest de hayPersonajePeloOjos");
	    try {
	    	System.out.println("   PELO: Blond Hair");
	    	System.out.println("   OJOS: Blue Eyes");
	    	System.out.println("      RESULTADO: "+ personajes.hayPersonajePeloOjos("Blond Hair", "Blue Eyes"));
	    	
	    	System.out.println("   PELO: Blond Hair");
	    	System.out.println("   OJOS: Dark Eyes");
	    	System.out.println("      RESULTADO: "+ personajes.hayPersonajePeloOjos("Blond Hair", "Dark Eyes"));
	    } catch (Exception e) {
	    	System.out.println("Excepción capturada:\n   " + e);
	    }
	}
	
	public static void testObtenerValoresAtributo() {
	    System.out.println("\nTest de obtenerValoresAtributo");
	    try {
	    	System.out.println("   TIPOS: "+ personajes.obtenerValoresAtributo(Personaje::getTipo));
	    	System.out.println("   OJOS: "+ personajes.obtenerValoresAtributo(Personaje::getOjos));
	    	System.out.println("   PELOS: "+ personajes.obtenerValoresAtributo(Personaje::getPelo));
	    	System.out.println("   SEXOS: "+ personajes.obtenerValoresAtributo(Personaje::getSexo));
	    	System.out.println("   DÉCADAS: "+ personajes.obtenerValoresAtributo(Personaje::getDecada));
	    } catch (Exception e) {
	    	System.out.println("Excepción capturada:\n   " + e);
	    }
	}
	
	public static void testCalcularAñoPrimerPersonajePorPelo() {
	    System.out.println("\nTest de calcularAñoPrimerPersonajePorPelo");
	    try {
	    	System.out.println("   AÑOS POR PELO: "+ personajes.calcularAñoPrimerPersonajePorPelo());
	    } catch (Exception e) {
	    	System.out.println("Excepción capturada:\n   " + e);
	    }
	}
	
	public static void testGenerarDiagramaSankey() {
	    System.out.println("\nTest de generarDiagramaSankey");
	    try {
	    	Personajes personajes = FactoriaPersonajes.leerPersonajes("data/characters.csv");
	    	
	    	personajes.generarDiagramaSankey("sexo_tipo.html",Personaje::getSexo, Personaje::getTipo);
	    	System.out.println("  DIAGRAMA GENERADO EN ./out/sexo_tipo.html");
	    	
	    	personajes.generarDiagramaSankey("ojos_tipo.html",Personaje::getOjos, Personaje::getTipo);
	    	System.out.println("  DIAGRAMA GENERADO EN ./out/ojos_tipo.html");
	    	
	    	personajes.generarDiagramaSankey("decada_pelo.html",Personaje::getDecada, Personaje::getPelo);
	    	System.out.println("  DIAGRAMA GENERADO EN ./out/decada_pelo.html");

	    } catch (Exception e) {
	    	System.out.println("Excepción capturada:\n   " + e);
	    }
	}
}

