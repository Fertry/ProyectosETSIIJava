package fp.nobel.test;
/**
 * @author Daniel Mateos
 * @author José A. Troyano
 * 
 * @since 2019-03-10
 */

import fp.nobel.Genero;
import fp.nobel.Premio;
import fp.nobel.PremiosBucle;

public class TestPremios {
	private static Premio fisica1 = new Premio(1901,"physics","Wilhelm Conrad","Röntgen",Genero.MALE,1845);
	private static Premio fisica2 = new Premio(1902,"physics","Hendrik Antoon","Lorentz",Genero.MALE,1853);
	private static Premio fisica3 = new Premio(1902,"physics","Pieter","Zeeman",Genero.MALE,1865);
	private static Premio fisica4 = new Premio(1903,"physics","Antoine Henri","Becquerel",Genero.MALE,1852);
	private static Premio fisica5 = new Premio(1903,"physics","Pierre","Curie",Genero.MALE,1859);
	private static Premio fisica6 = new Premio(1903,"physics","Marie","Curie née Sklodowska",Genero.FEMALE,1867);
	private static Premio fisica7 = new Premio(1904,"physics","Lord Rayleigh","(John William Strutt)",Genero.MALE,1842);
	private static Premio fisica8 = new Premio(1905,"physics","Philipp Eduard Anton","von Lenard",Genero.MALE,1862);
	private static Premio fisica9 = new Premio(1906,"physics","Joseph John","Thomson",Genero.MALE,1856);
	private static Premio quimica1 = new Premio(1911,"chemistry","Marie","Curie née Sklodowska",Genero.FEMALE,1867);
	
	
	//private static Premios premios = new PremiosStream();
	private static Premios premios = new PremiosBucle();
	
	
	public static void main(String[] args) {
		testConstructor();
		testObtenerPremiosDeGenero();
		testCalcularNumeroPremiadosMasJovenesDe();
		testCalcularMediaEdadPorCategoria();
	}

	
	private static void testConstructor() {
		System.out.println("\nTEST del Constructor");
		try {
			premios.añadirPremio(fisica1);
			premios.añadirPremio(fisica2);
			premios.añadirPremio(fisica3);
			premios.añadirPremio(fisica4);
			premios.añadirPremio(fisica5);
			premios.añadirPremio(fisica6);
			premios.añadirPremio(fisica7);
			premios.añadirPremio(fisica8);
			premios.añadirPremio(fisica9);
			premios.añadirPremio(quimica1);

			System.out.println("  PREMIOS: "+ premios + "\n");
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e);	
		}
	}
	
	private static void testObtenerPremiosDeGenero() {
		System.out.println("\nTEST de obtenerPremiosDeGenero");
		try {
			System.out.println("  GENERO: " + Genero.MALE);
			System.out.println("    PREMIOS: " + premios.obtenerPremiosDeGenero(Genero.MALE));
			System.out.println("  GENERO: " + Genero.FEMALE);
			System.out.println("    PREMIOS: " + premios.obtenerPremiosDeGenero(Genero.FEMALE));
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e);	
		}
	}
	
	private static void testCalcularNumeroPremiadosMasJovenesDe() {
		System.out.println("\nTEST de calcularNumeroPremiadosMasJovenesDe");
		try {
			System.out.println("  EDAD: " + 60);
			System.out.println("    PREMIADOS: " + premios.calcularNumeroPremiadosMasJovenesDe(60));
			System.out.println("  EDAD: " + 50);
			System.out.println("    PREMIADOS: " + premios.calcularNumeroPremiadosMasJovenesDe(50));			
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e);	
		}
	}
	
	private static void testCalcularMediaEdadPorCategoria() {
		System.out.println("\nTEST de calcularMediaEdadPorCategoria");
		try {
			System.out.println("  MEDIAS EDAD: " + premios.calcularMediaEdadPorCategoria());
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e);	
		}
	}
	
}
