package empleo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Empleos {
	
	private List <Empleo> empleos;
	
	public Empleos(Stream <Empleo> empleos) {
		
		this.empleos = empleos.collect(Collectors.toList());
		
	}
	
	public Integer getNumOfertasEmpleo() {
		
		return empleos.size();
		
	}

	public List<Empleo> getEmpleos() {
		return empleos;
	}

	public String toString() {
		return "Empleos [empleos=" + empleos + "]";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empleos == null) ? 0 : empleos.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleos other = (Empleos) obj;
		if (empleos == null) {
			if (other.empleos != null)
				return false;
		} else if (!empleos.equals(other.empleos))
			return false;
		return true;
	}
	
	public SortedSet <String> getEspecialidadesDeCuerpo(String cuerpo) {
		
		SortedSet <String> resultado = new TreeSet <String> ();
		
		for (Empleo empleo : empleos) {
			
			if (empleo.getCuerpo().equals(cuerpo)) {
				
				resultado.add(empleo.getEspecialidad());
				
			}
			
		}
		
		return resultado;
		
	}
	
	public Double getMediaPlazasPorOferta(String cuerpo, String especialidad) {
		
		Double media = null;
		
		Double sumador = 0.0;
		Double contador = 0.0;
		
		for (Empleo empleo : empleos) {
			
			if (empleo.getCuerpo().equals(cuerpo) && empleo.getEspecialidad().equals(especialidad)) {
				
				sumador += empleo.getNumPlazas();
				contador += 1;
				
			}
			
		}
		
		media = sumador / contador;
		
		return media;
		
	}
	
	public List <Empleo> getNOfertasMasPlazas(Integer anyo, Integer n) {
		
		//Creamos y ordenamos la lista por numero de plazas de mayor a menor:
		List <Empleo> empleosOrdenadosPorNumeroPlazas = new ArrayList <Empleo> ();
		
		for (Empleo empleo : empleos) {
			
			empleosOrdenadosPorNumeroPlazas.add(empleo);
			
		}
		
		Comparator <Empleo> ordenadorPorNumeroPlazas = Comparator.comparing(Empleo::getNumPlazas);
		
		Collections.sort(empleosOrdenadosPorNumeroPlazas, ordenadorPorNumeroPlazas);
		
		//
		
		Integer contador = 0; 
		
		List <Empleo> resultado = new ArrayList <Empleo> ();
		
		for (Empleo empleo : empleosOrdenadosPorNumeroPlazas) {
			
			while (contador < n) {
				
				if (empleo.getFechaPublicacionBOJA().getYear() == anyo) {
					
					resultado.add(empleo);
					contador += 1;
					
				}
				
			}
			
		}
		
		return resultado;
		
	}
	
	private Integer calculaNumeroPlazasDadoNivelEducativoYAnyo(NivelEducativo nivelEducativo, Integer anyo) {
		
		Integer contador = 0;
		
		for (Empleo empleo : empleos) {
			
			if (empleo.getNivelEducativo().equals(nivelEducativo) && empleo.getFechaPublicacionBOJA().getYear() == anyo) {
				
				contador += 1;
				
			}
			
		}
		
		return contador;
		
	}
	
	public Map <NivelEducativo, Integer> getNumPlazasPorNivelEducativo(Integer anyo) {
		
		Map <NivelEducativo, Integer> resultado = new HashMap <NivelEducativo, Integer> ();
		
		for (Empleo empleo : empleos) {
			
			if (!resultado.containsKey(empleo.getNivelEducativo())) {
				
				resultado.put(empleo.getNivelEducativo(), calculaNumeroPlazasDadoNivelEducativoYAnyo(empleo.getNivelEducativo(), anyo));
				
			}
			
		}
		
		return resultado;
		
	}
	
	public Integer getAnyoMasOferta(String cuerpo) {
		
		Integer anyo = 0;
		
		Integer maximo = 0;
		
		for (Empleo empleo : empleos) {
			
			if (empleo.getCuerpo().equals(cuerpo)) {
				
				if (empleo.getNumPlazas() > maximo) {
					
					maximo = empleo.getNumPlazas();
					anyo = empleo.getFechaPublicacionBOJA().getYear();
					
				}
				
			}
			
		}
		
		return anyo;
		
	}
	
	private Double calculaPorcentajeDePlazasParaUnNivelEducativo(Integer anyo, NivelEducativo nivelEducativo) {
		
		Map <NivelEducativo, Integer> diccionario = getNumPlazasPorNivelEducativo(anyo);
		
		Double resultado = 0.0;

		for (Empleo empleo : empleos) {
			
			for (NivelEducativo nivel : diccionario.keySet()) {
				
				for (Integer valor : diccionario.values()) {
					
					if (nivel.equals(nivelEducativo)) {
						
						resultado = (valor * 100.0) / empleo.getNumPlazas();
						
						return resultado;
						
					}
					
				}
				
			}
			
		}
		
		return resultado;
		
	}
	
	
	public Map <NivelEducativo, Double> getPorcentajePlazasPorNivelEducativo(Integer anyo) {
		
		Map <NivelEducativo, Double> resultado = new HashMap <NivelEducativo, Double> ();
		
		for (Empleo empleo : empleos) {
			
			if (!resultado.containsKey(empleo.getNivelEducativo())) {
				
				resultado.put(empleo.getNivelEducativo(), calculaPorcentajeDePlazasParaUnNivelEducativo(anyo, empleo.getNivelEducativo()));
				
			}
			
		}
		
		return resultado;
	
	}
	
}
