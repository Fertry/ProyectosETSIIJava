package fp.albumes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import fp.utiles.Checkers;



public class FactoriaAlbumes {
	public static Albumes leerAlbumes(String rutaFicheroAlbumes) {
		try {
			Albumes res = new Albumes();
			Files.lines(Paths.get(rutaFicheroAlbumes))
				.skip(1)
				.map(FactoriaAlbumes::parsearAlbum)
				.forEach(a -> res.añadirAlbum(a));
			return res;
		} catch (IOException e) {
			System.out.println("No se ha encontrado el fichero " + rutaFicheroAlbumes);
			e.printStackTrace();
			return null;
		}
	}
	private static Album parsearAlbum(String lineaCSV) {
		String[] campos = lineaCSV.split(";");
		Checkers.check("La línea debe contener 5 campos", campos.length == 5);	
		Integer posicion=Integer.valueOf(campos[0].trim());
		Integer año=Integer.valueOf(campos[1].trim());
		String album=campos[2].trim();
		String artista=campos[3].trim();
		String genero=campos[4].trim();
		return new Album(posicion, año, album, artista, genero);
	}
	
}
