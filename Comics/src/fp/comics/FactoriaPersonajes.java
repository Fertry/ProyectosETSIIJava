package fp.comics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import fp.utiles.Checkers;

public class FactoriaPersonajes {

	public static Personaje parsearPersonaje (String characters) {
		
		String [] splits = characters.split(",");
			
		Checkers.check("Cadena no valida", splits.length == 6);

		String nombre = splits[0].trim();
		String tipo = splits[1].trim();
		String ojos = splits[2].trim();
		String pelo = splits[3].trim();
		String sexo = splits[4].trim();
		Integer añoAparicion = Integer.parseInt(splits[5].trim());
			
		Personaje res = new Personaje (nombre, tipo, ojos, pelo, sexo, añoAparicion);
			
		return res;
		
		}

	public static Personajes leerPersonajes (String rutaFicheroPersonajes) {
			 
		Personajes res = null;
			
		try {
				
			Stream <Personaje> stream_de_personaje = Files.lines(Paths.get(rutaFicheroPersonajes)).skip(1).map(FactoriaPersonajes::parsearPersonaje);
			
			res = new Personajes (stream_de_personaje);
				
		} catch (IOException error) {
				
			
			System.out.println("No se encontró el fichero " +rutaFicheroPersonajes);
			error.printStackTrace();
				
		}
		
		return res;
		
		}

}
