package fp.albumes.test;

import java.lang.Exception;
import java.lang.String;
import java.lang.System;
import java.util.ArrayList;
import java.util.List;

import fp.albumes.Album;
import fp.albumes.Albumes;

public class TestAlbumes {
	private static Albumes albumes;

	public static void main(String[] args) {
		testConstructor();
		testGetAlbumes();
		testCalcularNumeroAlbumesContienenNombreArtista();
		testCalcularNumeroGenerosDistintos();
		testCalcularAlbumesMasAntiguos();
		testContarAlbumesPorAño();
		testCalcularArtistasConAlMenosNAlbumes();
	}

	public static void testConstructor() {
	    System.out.println("\nTEST Constructor");
	    List<Album>l=new ArrayList<>();
	    l.add(new Album(1,1967,"Sgt. Pepper's Lonely Hearts Club Band","The Beatles","Rock"));
	    l.add(new Album(2,1966,"Pet Sounds","The Beach Boys","Rock"));
	    l.add(new Album(3,1966,"Revolver","The Beatles","Rock"));
	    l.add(new Album(4,1965,"Highway 61 Revisited","Bob Dylan","Rock"));
	    l.add(new Album(5,1965,"Rubber Soul","The Beatles","Rock/Pop"));
	    l.add(new Album(6,1971,"What's Going On","Marvin Gaye","Funk/Soul"));
	    l.add(new Album(7,1972,"Exile on Main St.","The Rolling Stones","Rock"));
	    l.add(new Album(8,1979,"London Calling","The Clash","Rock"));
	    l.add(new Album(9,1966,"Blonde on Blonde","Bob Dylan","Rock/Blues"));
	    l.add(new Album(10,1968,"The Beatles (The White Album)","The Beatles","Rock"));
	    
	    albumes=new Albumes();
	    try {
	    	for(Album e:l)
	    		albumes.añadirAlbum(e);
	    } catch (Exception e) {
	    	System.out.println("\nExcepción capturada");
	    }
	    System.out.println(albumes);
	}
	
	public static void testGetAlbumes() {
	    System.out.println("\nTEST testGetAlbumes");
	    try {
	    	System.out.println(albumes.getAlbumes());
	    } catch (Exception e) {
	    	System.out.println("\nExcepción capturada");
	    }
	  }
	
	public static void testCalcularNumeroAlbumesContienenNombreArtista() {
	    System.out.println("\nTEST calcularNumeroAlbumesContienenNombreArtista");
	    try {
	    	System.out.println(albumes.calcularNumeroAlbumesContienenNombreArtista());
	    } catch (Exception e) {
	    	System.out.println("\nExcepción capturada");
	    }
	}


	public static void testCalcularNumeroGenerosDistintos() {
		System.out.println("\nTEST calcularNumeroGenerosDistintos");
		try {
			System.out.println(albumes.calcularNumeroGenerosDistintos());
		} catch (Exception e) {
			System.out.println("\nExcepción capturada");
		}
	}

	public static void testCalcularAlbumesMasAntiguos() {
		System.out.println("\nTEST calcularAlbumesMasAntiguos: 3");
		try {
			System.out.println(albumes.calcularAlbumesMasAntiguos(3));
		} catch (Exception e) {
			System.out.println("\nExcepción capturada");
		}
	}

	public static void testContarAlbumesPorAño() {
		System.out.println("\nTEST contarAlbumesPorAño");
		try {
			System.out.println(albumes.contarAlbumesPorAño());
		} catch (Exception e) {
			System.out.println("\nExcepción capturada");
		}
	}
	
	public static void testCalcularArtistasConAlMenosNAlbumes() {
		System.out.println("\nTEST calcularArtistasConAlMenosNAlbumes");
		try {
			System.out.println(albumes.calcularArtistasConAlMenosNAlbumes(2));
		} catch (Exception e) {
			System.out.println("\nExcepción capturada");
		}
	}
}
