package registros;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Registros {
	
	private List <Registro> registros;
	
	public Integer getNumRegistros() {
		
		return registros.size();
		
	}
	
	public Registros() {
		
	}
	
	public Registros(Stream <Registro> registros) {
		
		this.registros = registros.collect(Collectors.toList());
		
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
		
		Set <String> resultado = new TreeSet <String> ();
		
		for (Registro registro : registros) {
			
			if (registro.getFecha().getYear() == anyo && registro.getRichter() > umbralRichter) {
				
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
			
			if (ciudades.contains(registro.getCiudad())) {
				
				contador += 1;
				sumador += registro.getRichter();
				
			}
		
		}
		
		return resultado;
		
	}
	
	private List <Coordenadas> calculaCoordenadasDadoCiudad(String ciudad) {
		
		List <Coordenadas> resultado = new ArrayList <Coordenadas> ();
		
		for (Registro registro : registros) {
			
			if (registro.getCiudad().equals(ciudad)) {
				
				resultado.add(registro.getCoordenadas());
				
			}
			
		}
		
		return resultado;
		
	}
	
	public Map <String, List <Coordenadas>> getCoordenadasPorCiudad() {
		
		Map <String, List <Coordenadas>> resultado = new HashMap <String, List <Coordenadas>> ();
		
		for (Registro registro : registros) {
			
			if (!resultado.containsKey(registro.getCiudad())) {
				
				resultado.put(registro.getCiudad(), calculaCoordenadasDadoCiudad(registro.getCiudad()));
				
			}
			
		}
		
		return resultado;
		
	}
	
	public String getCiudadMasTerremotosNMayores(Integer n) {
		
		String resultado = null;
		
		//TODO
		
		return resultado;
		
	}
	 
}
