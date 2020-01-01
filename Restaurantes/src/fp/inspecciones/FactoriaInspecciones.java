package fp.inspecciones;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

import fp.utiles.Checkers;

public class FactoriaInspecciones {
	
	private static Inspeccion parsearInspeccion (String lineas) {
		
		String[] datos = lineas.split(",");
		
		Checkers.check("La linea debe contener 8 datos", datos.length == 8);
		
		String id = datos[0].trim();
		String nombre = datos[1].trim();
		String tipoCocina = datos[2].trim();
		String descripcion = datos[3].trim();
		LocalDate fecha = LocalDate.parse(datos[4].trim(), DateTimeFormatter.ofPattern("d/M/y"));
		Distrito distrito = Distrito.valueOf(datos[5].trim());
		Boolean esCritico = Boolean.valueOf(datos[6].trim());
		Double score = Double.valueOf(datos[7].trim());
		
		return new Inspeccion (id, nombre, distrito, descripcion, fecha, tipoCocina, esCritico, score);
		
	}
	
	public static Inspecciones leerInspecciones (String fichero) {
		
		Inspecciones resultado = null;
		
		try {
			
			Stream <Inspeccion> inspeccion = Files.lines(Paths.get(fichero)).skip(1).map(FactoriaInspecciones::parsearInspeccion);
			resultado = new Inspecciones(inspeccion);
			
		} catch (IOException error) {
			
			System.out.println("No se encontró " + fichero);
			error.printStackTrace();
			
		}
		
		return resultado;
		
	}

}
