package fp.comics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.utiles.GraphTools;

public class Personajes {
	
	private Collection <Personaje> personajes;
	
	public Personajes() {
		
	}
	
	public Personajes(Stream <Personaje> personajes) {
		
		this.personajes = personajes.collect(Collectors.toSet());
		
	}
	
	public void añadirPersonaje(Personaje personaje) {
		
		this.personajes.add(personaje);
		
	}

	public String toString() {
		return "Personajes [personajes=" + personajes + "]";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((personajes == null) ? 0 : personajes.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personajes other = (Personajes) obj;
		if (personajes == null) {
			if (other.personajes != null)
				return false;
		} else if (!personajes.equals(other.personajes))
			return false;
		return true;
	}
	
	public Collection <Personaje> obtenerPersonajesDeSexoOrdenados(String sexo) {
		
		List <Personaje> resultado = new ArrayList <Personaje> ();
		
		for (Personaje personaje : personajes) {
			
			if (personaje.getSexo().equals(sexo)) {
				
				resultado.add(personaje);
				
			}
			
		}
		
		Comparator <Personaje> comparadorOrdenNatural = Comparator.comparing(Personaje::getAñoAparicion);
		
		Collections.sort(resultado, comparadorOrdenNatural);
		
		return resultado;
		
	}
	
	public Collection <Personaje> obtenerPersonajesOrdenadosPorPelo() {
		
		List <Personaje> resultado = new ArrayList <Personaje> ();
		
		for (Personaje personaje : personajes) {
			
			resultado.add(personaje);
			
		}
		
		Comparator <Personaje> comparadorColorPeloAlfabetico = Comparator.comparing(Personaje::getPelo);
		
		Collections.sort(resultado, comparadorColorPeloAlfabetico);
		
		return resultado;
		
	}
	
	public Boolean hayPersonajePeloOjos(String pelo, String ojos) {
		
		Boolean existe = false;
		
		for (Personaje personaje : personajes) {
			
			if (personaje.getPelo().equals(pelo) && personaje.getOjos().equals(ojos)) {
				
				existe = true;
				
			}
			
		}
		
		return existe;
		
	}
	
	public Set <String> obtenerValoresAtributo (Function <Personaje, String> funcion) {
		
		return personajes.stream().map(funcion).collect(Collectors.toSet());
		
	}
	
	private Integer calcularPrimerAñoDePelo(String pelo) {
		
		Integer año = 0;
		
		for (Personaje personaje : personajes) {
			
			if (personaje.getPelo().equals(pelo)) {
				
				año = personaje.getAñoAparicion();
				return año;
				
			}
			
		}
		
		return año;
		
	}
	
	public Map <String, Integer> calcularAñoPrimerPersonajePorPelo() {
		
		Map <String, Integer> resultado = new HashMap <String, Integer> ();
		
		for (Personaje personaje : personajes) {
			
			if (!resultado.containsKey(personaje.getPelo())) {
				
				resultado.put(personaje.getPelo(), calcularPrimerAñoDePelo(personaje.getPelo()));
				
			}
				
		}
		
		return resultado;
		
	}
	
	public void generarDiagramaSankey (String ficheroSalida, Function<Personaje, String> funcion1, Function<Personaje, String> funcion2) {
		
		Map <String, List<String>> atributos = personajes.stream().collect(Collectors.groupingBy(funcion1, Collectors.mapping(funcion2, Collectors.toList())));
		//
		GraphTools.sankeyChart("out/" + ficheroSalida, atributos);
		
	}
	
}
