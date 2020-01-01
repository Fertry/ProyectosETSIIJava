package registros;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Registros {
	
	private List <Registro> registros;
	
	public Registros() {
		
		this.registros = new ArrayList <Registro> ();
		
	}
	
	public Registros(Stream <Registro> registros) {
		
		this.registros = registros.collect(Collectors.toList());
		
	}
	
	public Integer getNumRegistros() {
		
		return registros.size();
		
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((registros == null) ? 0 : registros.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Registros other = (Registros) obj;
		if (registros == null) {
			if (other.registros != null)
				return false;
		} else if (!registros.equals(other.registros))
			return false;
		return true;
	}

	public String toString() {
		return "Registros [registros=" + registros + "]";
	}
	
	public Set <String> getCiudadesIntensidadMayorEnAnyo(Double umbralRichter, Integer anyo) {
		
		Set <String> resultado = new HashSet <String> ();
		
		for (Registro registro : registros) {
			
			if (registro.getRichter() > umbralRichter && registro.getFecha().getYear() == anyo) {
				
				resultado.add(registro.getCiudad());
				
			}
			
		}
		
		return resultado;
		
	}
	
	public Double calcularPromedioRichterConjuntoCiudades(Set <String> ciudades) {
		
		Double resultado = null;
		
		Double contador = 0.0;
		Double sumador = 0.0;
		
		for (Registro registro : registros) {
			
			for (String ciudad : ciudades) {
				
				if (registro.getCiudad().equals(ciudad)) {
					
					contador += 1.0;
					sumador += registro.getRichter();
					
				}
				
			}
			
		}
		
		resultado = sumador / contador;
		
		return resultado;
		
	}
	
	private List <Coordenadas> calculaListaDeCoordenadasDadoCiudad(String nombre) {
		
		List <Coordenadas> resultado = new ArrayList <Coordenadas> ();
		
		for (Registro registro : registros) {
			
			if (registro.getCiudad().equals(nombre)) {
				
				resultado.add(registro.getCoordenadas());
				
			}
			
		}
	
		return resultado;
		
	}
	
	public Map <String, List <Coordenadas>> getCoordenadasPorCiudad() {
		
		Map <String, List <Coordenadas>> resultado = new HashMap <String, List <Coordenadas>> ();
		
		for (Registro registro : registros) {
			
			if (!resultado.containsKey(registro.getCiudad())) {
				
				resultado.put(registro.getCiudad(), calculaListaDeCoordenadasDadoCiudad(registro.getCiudad()));
				
			}
			
		}
		
		return resultado;
		
	}
	
	private Coordenadas calcularMediaCoordenadasDadoCiudad(String ciudad) {
				
		Double latitudMedia = 0.0;
		Double longitudMedia = 0.0;
		
		Double contador = 0.0;

		Double sumadorLatitud = 0.0;
		Double sumadorLongitud = 0.0;
		
		for (Registro registro : registros) {
			
			if (registro.getCiudad().equals(ciudad)) {
				
				contador += 1;

				sumadorLatitud += registro.getCoordenadas().getLatitud();
				sumadorLongitud += registro.getCoordenadas().getLongitud();
				
			}
			
		}
		
		latitudMedia = sumadorLatitud / contador;
		longitudMedia = sumadorLongitud / contador;
		
		Coordenadas resultado = new Coordenadas(latitudMedia, longitudMedia);
		
		return resultado;
		
	}
	
	public Map <String, Coordenadas> getCoordenadasMediasPorCiudad() {
		
		Map <String, List <Coordenadas>> diccionario = getCoordenadasPorCiudad();
		
		Map <String, Coordenadas> resultado = new HashMap <String, Coordenadas> ();
		
		for (String ciudad : diccionario.keySet()) {
			
			if (!resultado.containsKey(ciudad)) {
				
				resultado.put(ciudad, calcularMediaCoordenadasDadoCiudad(ciudad));
				
			}
	
		}
		
		return resultado;
		
	}
	
	public String getCiudadMasTerremotosNMayores(Integer n) {
		
		String resultado = null;
		
		Stream <Registro> listaTerremotosOrdenados = registros.stream().sorted(Comparator.comparing(Registro::getRichter).reversed()).limit(n);
		
		Registro mayor = listaTerremotosOrdenados.max(Comparator.comparing(Registro::getCiudad)).get();
		
		resultado = mayor.getCiudad();
		
		return resultado;
		
	}
	
	public Double getMediaDiasEntreTerremotosCiudad(String ciudad) {
		
		Double resultado = null;
		
		
		
		return resultado;
		
	}
	
}
