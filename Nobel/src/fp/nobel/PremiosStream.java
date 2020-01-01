package fp.nobel;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.nobel.test.Premios;

public class PremiosStream implements Premios{

	private Collection <Premio> premios;
	
	public PremiosStream() {
		
	}
	
	public PremiosStream(Stream <Premio> premios) {
		
		this.premios = premios.collect(Collectors.toSet());
		
	}
	
	public String toString() {
		return "PremiosStream [premios=" + premios + "]";
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
		PremiosStream other = (PremiosStream) obj;
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
		
		return premios.stream().filter(x -> x.getGenero().equals(genero)).collect(Collectors.toSet());
		
	}

	public Integer calcularNumeroPremiadosMasJovenesDe(Integer edad) {
		
		return (int) premios.stream().filter(x -> x.getEdadPremiado() < edad).count();
		
	}

	public Map<String, Double> calcularMediaEdadPorCategoria() {
		
		return premios.stream().collect(Collectors.groupingBy(Premio::getCategoria, Collectors.averagingInt(Premio::getEdadPremiado)));
		
	}

}
