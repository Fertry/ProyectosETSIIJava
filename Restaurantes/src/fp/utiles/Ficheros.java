package fp.utiles;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ficheros {
	
	/**
	 * @param objetos Stream de objetos que se escriben en el fichero.
	 * @param funcion Función que transforma el objeto en una cadena para escribirla en el fichero.
	 * @param nombreFichero Nombre del fichero en el que se escribe el Stream de objetos
	 * Como efecto lateral se crea un fichero con el nombre dado y la transformación del objeto
	 * en cada línea.
	 */
	public static <T> void escribeFichero(Stream<T> objetos, Function<T, String> funcion, String nombreFichero) {
		List<String> cadenas = objetos
				.map(funcion)
				.collect(Collectors.toList());		
		try {
			Files.write(Paths.get(nombreFichero), cadenas, StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println("Error en la escritura del fichero");
			e.printStackTrace();
		}
	}

}
