package fp.vinos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import fp.utiles.Checkers;

public class FactoriaVinos {
	
	private static Vino parsearVino(String lineaCSV) {
		
		String[] datos = lineaCSV.split(",");
		
		Checkers.check("El formato no es valido", datos.length == 5);
		
		String pais = datos[0].trim();
		String region = datos[1].trim();
		Integer puntos = Integer.parseInt(datos[2].trim());
		Double precio = Double.parseDouble(datos[3].trim());
		String uva = datos[4].trim();
		
		Vino resultado = new Vino (pais, region, puntos, precio, uva);
		
		return resultado;
				
	}
	
	public static Vinos leerVinos(String rutaFicheroVinos) {
		
		Vinos res = null;
		
		try {
			
			Stream <Vino> stream_de_vino = Files.lines(Paths.get(rutaFicheroVinos)).skip(1).map(FactoriaVinos::parsearVino);
			res = new Vinos(stream_de_vino);
			
		} catch (IOException error) {
			
			System.out.println("No se encontró el fichero " +rutaFicheroVinos);
			error.printStackTrace();
			
		}
		
		return res;
		
		
	}

}
