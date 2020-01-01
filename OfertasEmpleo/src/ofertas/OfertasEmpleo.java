package ofertas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import libertad.Registro;

public class OfertasEmpleo {
	
	private List <OfertaEmpleo> ofertas;
	
	public Integer getNumOfertasEmpleo() {
		
		return this.ofertas.size();
		
	}
	
	public OfertasEmpleo(Stream <OfertaEmpleo> ofertas) {
		
		this.ofertas = ofertas.collect(Collectors.toList());
		
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ofertas == null) ? 0 : ofertas.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OfertasEmpleo other = (OfertasEmpleo) obj;
		if (ofertas == null) {
			if (other.ofertas != null)
				return false;
		} else if (!ofertas.equals(other.ofertas))
			return false;
		return true;
	}

	public String toString() {
		return "OfertasEmpleo [ofertas=" + ofertas + "]";
	}
	
	public Boolean hayAlgunaOfertaConPorcentajePlazasDiscapacidadMayorA(Double minimo) {
		
		Checkers.check("El minimo debe estar entre 0 y 100.", minimo > 0 && minimo < 100);
		
		Boolean resultado = false;
		
		for (OfertaEmpleo ofertaEmpleo : ofertas) {
			
			if (ofertaEmpleo.getPorcentajePlazasDiscapacidad() >= minimo) {
				
				resultado = true;
				return resultado;
				
			}
			
		}
		
		return resultado;
		
	}
	
	public Integer getNumeroEspecialidadesFacultativosEspecialistas() {
		
		Integer contadorDeMierda = 0;
		
		for (OfertaEmpleo ofertaEmpleo : ofertas) {
			
			if (ofertaEmpleo.getEspecialidad().contains("FEA")) {
				
				contadorDeMierda += 1;
				
			}
			
		}
		
		return contadorDeMierda;
		
	}
	
	public Integer getTotalPlazas(String especialidad, Integer anyo) {
		
		Integer contador = 0;
		
		for (OfertaEmpleo ofertaEmpleo : ofertas) {
			
			if (ofertaEmpleo.getEspecialidad().equals(especialidad) && ofertaEmpleo.getFechaPublicacionBOJA().getYear() == anyo) {
				
				contador += ofertaEmpleo.getNumPlazasTotales();
				
			}
			
		}
		
		return contador;
		
	}
	
	private Integer calcularNumeroPlazasDeUnTipoDadoElTipoYLaFecha(Integer año, TipoAcceso tipo) {
		
		Integer contador = 0;
		
		for (OfertaEmpleo ofertaEmpleo : ofertas) {
			
			if (ofertaEmpleo.getFechaPublicacionBOJA().getYear() == año && ofertaEmpleo.getTipoAcceso().equals(tipo)) {
				
				contador += 1;
				
			}
			
		}
		
		return contador;
		
	}
	
	public SortedMap <Integer, Integer> getTotalPlazasTipo(TipoAcceso tipo) {
		
		SortedMap <Integer, Integer> resultado = new TreeMap <Integer, Integer> ();
		
		for (OfertaEmpleo ofertaEmpleo : ofertas) {
			
			if (!resultado.containsKey(ofertaEmpleo.getFechaPublicacionBOJA().getYear())) {
				
				resultado.put(ofertaEmpleo.getFechaPublicacionBOJA().getYear(), calcularNumeroPlazasDeUnTipoDadoElTipoYLaFecha(ofertaEmpleo.getFechaPublicacionBOJA().getYear(), tipo));
				
			}
			
		}
		
		return resultado;
		
	}
	
	private Integer calcularNumeroDeOfertasDadaEspecialidad(String especialidad) {
		
		Integer contador = 0;
		
		for (OfertaEmpleo ofertaEmpleo : ofertas) {
			
			if (ofertaEmpleo.getEspecialidad().equals(especialidad)) {
				
				contador += ofertaEmpleo.getNumPlazasTotales();
				
			}
			
		}
		
		return contador;
		
	}
	
	private Map <String, Integer> calcularNumeroDeOfertasPorEspecialidad() {
		
		Map <String, Integer> resultado = new HashMap <String, Integer> ();
		
		for (OfertaEmpleo ofertaEmpleo : ofertas) {
			
			if (!resultado.containsKey(ofertaEmpleo.getEspecialidad())) {
				
				resultado.put(ofertaEmpleo.getEspecialidad(), calcularNumeroDeOfertasDadaEspecialidad(ofertaEmpleo.getEspecialidad()));
				
			}
			
		}
		
		return resultado;
		
	}
	
	public String getEspecialidadMasOfertada() {
		
		Map <String, Integer> diccionario = calcularNumeroDeOfertasPorEspecialidad();
		
		String resultado = null;
		
		Integer maximo = 0;
		
		for (String nombre : diccionario.keySet()) {
			
			for (Integer numero : diccionario.values()) {
				
				if (numero > maximo) {
					
					maximo = numero;
					resultado = nombre;
					
				}
				
			}
			
		}
		
		return resultado;
		
	}
	
	private List <OfertaEmpleo> ofertasOrdenadasPorAño() {
		
		List <OfertaEmpleo> ofertasOrdenadasPorFecha = new ArrayList <OfertaEmpleo> ();
		
		for (OfertaEmpleo ofertaEmpleo : ofertas) {
			
			ofertasOrdenadasPorFecha.add(ofertaEmpleo);
			
		}
		
		Comparator <OfertaEmpleo> ordenadorPorFecha = Comparator.comparing(OfertaEmpleo::getAnyo);
		
		Collections.sort(ofertasOrdenadasPorFecha, ordenadorPorFecha);
		
		return ofertasOrdenadasPorFecha;
		
	}
	
	private List <String> calcularNEspecialidadesConMasPlazas(Integer numero) {
		
		Integer contador = 0;
		
		List <OfertaEmpleo> ofertasOrdenadasPorNumeroPlazas = new ArrayList <OfertaEmpleo> ();
		
		List <String> resultado = new ArrayList <String> ();
		
		//TODO
		
		return resultado;
		
	}
	
	public Map <Integer, List <String>> getNEspecialidadesMasPlazasPorAnyo(Integer numero) {
		
		Map <Integer, List <String>> resultado = new HashMap <Integer, List <String>> ();
		
		for (OfertaEmpleo ofertaEmpleo : ofertasOrdenadasPorAño()) {
			
			if (!resultado.containsKey(ofertaEmpleo.getFechaPublicacionBOJA().getYear())) {
				
				resultado.put(ofertaEmpleo.getFechaPublicacionBOJA().getYear(), calcularNEspecialidadesConMasPlazas(numero));
				
			}
			
		}
		
		return resultado;
		
	}
	
	

}
