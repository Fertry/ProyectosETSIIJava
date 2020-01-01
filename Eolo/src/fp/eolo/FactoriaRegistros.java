package fp.eolo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

import fp.utiles.Checkers;

public class FactoriaRegistros {
	
	//Método para construir un objeto Registro a partir de una linea CSV del fichero de entrada
		public static Registro parsearRegistro (String registros_vientos) {
			
			//Separamos por comas
			String [] splits = registros_vientos.split(",");
			
			//Una cadena es valida si tiene 5 elementos
			Checkers.check("Cadena no valida", splits.length == 5);
			
			//Adaptamos los datos
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			
			LocalDate fecha = LocalDate.parse(splits[0], formatter);
			String ciudad = splits[1].trim();
			Double direccion = Double.parseDouble(splits[2].trim());
			Double velocidadMedia = Double.parseDouble(splits[3].trim());
			Double velocidadMaxima = Double.parseDouble(splits[4].trim());
			
			//Creamos el objeto
			Registro res = new Registro (fecha, ciudad, direccion, velocidadMedia, velocidadMaxima);
			
			//Devolvemos el objeto
			return res;
			
		}
		
		//Método que devuelve un objeto Registros a partir de la ruta del fichero en el que se encuentran los datos de los registros
		public static Registros leerRegistros (String rutaFicheroRegistros) {
			
			Registros res = null;
			
			try {
				
				Stream <Registro> sp = Files.lines(Paths.get(rutaFicheroRegistros)).skip(1).map(FactoriaRegistros::parsearRegistro);
				
				res = new Registros(sp);
				
			} catch (IOException error) {
				
				System.out.println("No se encontró el fichero " +rutaFicheroRegistros); 
				error.printStackTrace();
				
			}
			
			return res;
			
		}		

}
