package fp.nobel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import fp.nobel.Genero;
import fp.nobel.test.Premios;
import fp.utiles.Checkers;

public class FactoriaNobel {
	
	private static Premio parsearPremio(String linea) {
		
		String[] datos = linea.split(",");
		
		Checkers.check("Cadena no valida!", datos.length == 6);
		
		Integer año = Integer.parseInt(datos[0].trim());
		String categoria = datos[1].trim();
		String nombre = datos[2].trim();
		String apellidos = datos[3].trim();
		Genero genero = Genero.valueOf(datos[4].trim().toUpperCase());
		Integer añoNacimiento = Integer.parseInt(datos[5].trim());
		
		Premio resultado = new Premio(año,categoria,nombre,apellidos,genero,añoNacimiento);
		
		return resultado;
		
	}
	
	public static Premios leerPremios(String fichero) {
		
		Premios resultado = null;
		
		try {
			
			Stream <Premio> premio = Files.lines(Paths.get(fichero)).skip(1).map(FactoriaNobel::parsearPremio);
			
			resultado = new PremiosStream(premio);
					
		} catch (IOException excepcion) {
			
			System.out.println("No se encontró el fichero " + fichero);
			excepcion.printStackTrace();
			
		}
		
		return resultado;
		
	}

}
