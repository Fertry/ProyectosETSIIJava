package fp.vinos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.utiles.Checkers;

public class Vinos {
	
	private Collection <Vino> vinos;
	
	public Vinos() {
			
	}
	
	public Vinos(Stream <Vino> vinos) {
		
		this.vinos = vinos.collect(Collectors.toSet());
		
	}
	
	public void añadirVino(Vino vino) {
		
		this.vinos.add(vino);
		
	}

	public String toString() {
		return "Vinos [vinos=" + vinos + "]";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vinos == null) ? 0 : vinos.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vinos other = (Vinos) obj;
		if (vinos == null) {
			if (other.vinos != null)
				return false;
		} else if (!vinos.equals(other.vinos))
			return false;
		return true;
	}
	
	public Integer calcularNumeroVinosPais(String pais) {
		
		Integer contador = 0;
		
		for (Vino vino : vinos) {
			
			if (vino.getPais().equals(pais)) {
				
				contador += 1;
				
			}
			
		}
		
		return contador;
		
	}
	
	public Vino obtenerVinoMejorPuntuado() {
		
		Vino resultado = null;
		Integer maximo = 0;
		
		for (Vino vino : vinos) {
			
			if (vino.getPuntos() > maximo) {
				
				resultado = vino;
				
			}
			
		}
		
		return resultado;
		
	}
	
	private List <Vino> calcularListaVinosDadoPais(String pais) {
		
		List <Vino> resultado = new ArrayList <Vino> ();

		for (Vino vino : vinos) {
			
			if (vino.getPais().equals(pais)) {
				
				resultado.add(vino);
				
			}
			
		}
		
		return resultado;
		
	}
	
	public Map <String, List<Vino>> calcularVinosPorPais() {
		
		Map <String, List<Vino>> resultado = new HashMap <String, List<Vino>> ();
		
		for (Vino vino : vinos) {
			
			if (!resultado.containsKey(vino.getPais())) {
				
				resultado.put(vino.getPais(), calcularListaVinosDadoPais(vino.getPais()));
				
			}
			
		}
		
		return resultado;
		
	}
	
	public Set <String> calcularUvasPorRegion(String region) {
		
		Set <String> resultado = new HashSet <String> ();
		
		for (Vino vino : vinos) {
			
			if (vino.getRegion().equals(region)) {
				
				resultado.add(vino.getUva());
				
			}
			
		}
		
		return resultado;
		
	}
	
	public Collection <Vino> obtenerVinosRangoPuntos(Integer minimo, Integer maximo) {
		
		Collection <Vino> resultado = new ArrayList <Vino> ();
		
		Checkers.check("El valor minimo debe ser menor o igual al valor maximo", minimo <= maximo);
		
		for (Vino vino : vinos) {
			
			if (vino.getPuntos() > minimo && vino.getPuntos() < maximo) {
				
				resultado.add(vino);
				
			}
			
		}
		
		return resultado;
	
	}
	
	private Set <String> calcularUvasPorPais(String pais) {
		
		Set <String> resultado = new HashSet <String> ();
		
		for (Vino vino : vinos) {
			
			if (vino.getPais().equals(pais)) {
				
				if (!resultado.contains(vino.getUva())) {
					
					resultado.add(vino.getUva());
					
				}
				
			}
			
		}
		
		return resultado;
		
	}
	
	public Map <String, Set<String>> calcularUvasPorPais() {
		
		Map <String, Set<String>> resultado = new HashMap <String, Set<String>> ();
		
		for (Vino vino : vinos) {
			
			if (!resultado.containsKey(vino.getPais())) {
				
				resultado.put(vino.getPais(), calcularUvasPorPais(vino.getPais()));
				
			}
			
		}
		
		return resultado;
		
	}
	
	private Long calcularVinosQueSuperanElUmbral(String region, Double umbral) {
		
		Long contador = (long) 0;
		
		for (Vino vino : vinos) {
			
			if (vino.getRegion().equals(region) && vino.getCalidadPrecio() > umbral) {
				
				contador += 1;
				
			}
			
		}
		
		return contador;
		
	}
	
	public Map <String, Long> calcularCalidadPrecioPorRegionMayorDe(Double umbral) {
		
		Map <String, Long> resultado = new HashMap <String, Long> ();
		
		for (Vino vino : vinos) {
			
			if (!resultado.containsKey(vino.getRegion())) {
				
				resultado.put(vino.getRegion(), calcularVinosQueSuperanElUmbral(vino.getRegion(), umbral));
				
			}
			
		}
		
		return resultado;
		
	}
	
}
