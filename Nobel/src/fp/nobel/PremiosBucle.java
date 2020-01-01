package fp.nobel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.nobel.test.Premios;

public class PremiosBucle implements Premios{

	private Collection <Premio> premios;
	
	public PremiosBucle() {
		
	}
	
	public PremiosBucle(Stream <Premio> premios) {
		
		this.premios = premios.collect(Collectors.toSet());
		
	}
	
	public String toString() {
		return "PremiosBucle [premios=" + premios + "]";
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((premios == null) ? 0 : premios.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PremiosBucle other = (PremiosBucle) obj;
		if (premios == null) {
			if (other.premios != null)
				return false;
		} else if (!premios.equals(other.premios))
			return false;
		return true;
	}

	public void añadirPremio(Premio premio) {
		
		premios.add(premio);
		
	}

	public Collection<Premio> obtenerPremiosDeGenero(Genero genero) {
		
		Collection <Premio> resultado = new ArrayList <Premio> ();
		
		for (Premio premio : premios) {
			
			if (premio.getGenero().equals(genero)) {
				
				resultado.add(premio);
				
			}
			
		}
		
		return resultado;
		
	}

	public Integer calcularNumeroPremiadosMasJovenesDe(Integer edad) {
		
		Integer contador = 0;
		
		for (Premio premio : premios) {                            
			
			if (premio.getEdadPremiado() < edad) {
				
				contador += 1;
				
			}
			
		}                             
		return contador;
		
	}
	
	private Double calcularMediaPorCategoria(String categoria, Collection <Premio> ColeccionPremios) {
		
		Double media = 0.0;
		
		Integer contador = 0;
		Integer suma = 0;
		
		for (Premio premio : ColeccionPremios) {
			
			if (premio.getCategoria().equals(categoria)) {
				
				contador += 1;
				suma += premio.getEdadPremiado();                                                                                                                                                                          
				
			}
			
		}
		
		media = (double) (suma / contador);
		
		return media;
		
	}

	public Map<String, Double> calcularMediaEdadPorCategoria() {
		
		Map <String, Double> resultado = new HashMap <String, Double> ();
		
		for (Premio premio : premios) {
			
			if (!resultado.containsKey(premio.getCategoria())) {
				
				resultado.put(premio.getCategoria(), calcularMediaPorCategoria(premio.getCategoria(), premios));
				
			}
			
		}
		
		return resultado;
		
	}

}
