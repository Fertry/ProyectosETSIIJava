package fp.inspecciones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Inspecciones {
	
	private Collection <Inspeccion> inspecciones;
	
	public Inspecciones() {
		
	}
	
	public Inspecciones(Stream <Inspeccion> inspecciones) {
		
		this.inspecciones = inspecciones.collect(Collectors.toSet());
		
	}

	public Collection <Inspeccion> getInspecciones() {
		
		return inspecciones;
		
	}

	public void añadirInspeccion(Inspeccion inspeccion) {
		
		inspecciones.add(inspeccion);
		
	}

	public String toString() {
		return "Inspecciones [inspecciones=" + inspecciones + "]";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inspecciones == null) ? 0 : inspecciones.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inspecciones other = (Inspecciones) obj;
		if (inspecciones == null) {
			if (other.inspecciones != null)
				return false;
		} else if (!inspecciones.equals(other.inspecciones))
			return false;
		return true;
	}
	
	public List <Inspeccion> obtenerInspeccionesMasRecientes() {
		
		List <Inspeccion> resultado = new ArrayList <Inspeccion> ();
		
		for (Inspeccion inspeccion : inspecciones) {
			
			if (inspeccion.getFecha().isBefore(LocalDate.now()) && inspeccion.getFecha().isAfter(LocalDate.of(2017, 1, 1))) {
				
				resultado.add(inspeccion);
				
			}
		}
		
		return resultado;
		
	}
	
	public SortedSet <String> obtenerNombresRestaurantesdeTipoCocina(String tipo) {
		
		SortedSet <String> resultado = new TreeSet <String> ();
		
		for (Inspeccion inspeccion : inspecciones) {
			
			if (inspeccion.getTipoCocina().equals(tipo)) {
				
				resultado.add(inspeccion.getNombre());
				
			}
			
		}
		
		return resultado;
		
	}
	
	public Double calcularMediaScores(String nombre) {
		
		Double media = 0.0;
		
		Double contador = 0.0;
		Double sumador = 0.0;
		
		for (Inspeccion inspeccion : inspecciones) {
			
			if (inspeccion.getNombre().equals(nombre)) {
				
				contador += 1;
				sumador += inspeccion.getScore();
				
			}
			
		}
		
		media = sumador / contador;
		
		return media;
		
	}

	private Boolean compruebaSiRestauranteEsCritico(String nombre) {
		
		Boolean esCritico = true;
		
		for (Inspeccion inspeccion : inspecciones) {
			
			if (inspeccion.getNombre().equals(nombre)) {
				
				if (!inspeccion.getEsCritica()) {
					
					esCritico = false;
					
				}
				
			}
			
		}
		
		return esCritico;
		
	}
	
	public String obtenerRestauranteCritico() {
		
		String resultado = null;
		
		for (Inspeccion inspeccion : inspecciones) {
			
			if (compruebaSiRestauranteEsCritico(inspeccion.getNombre())) {
				
				resultado = inspeccion.getNombre();
				
			}
			
		}
		
		return resultado;
		
	}
	
	/*
	 * private void todasInspeccionesCriticas(String nombre) {
	 * 
	 * //TODO
	 * 
	 * }
	 */
	
	public void mostrarInformeInspecciones(String nombre) {
		
		for (Inspeccion inspeccion : inspecciones) {
			
			if (inspeccion.getNombre().equals(nombre)) {
				
				System.out.println(inspeccion.toString());
				System.out.println("");
				
			}
			
		}
	
	}
	
	/*
	 * public Inspeccion obtenerInspeccionMasReciente() {
	 * 
	 * return
	 * inspecciones.stream().sorted(Comparator.comparing(Inspeccion::getFecha).
	 * reversed()).get(0);
	 * 
	 * }
	 */
	
	public SortedSet <Inspeccion> obtenerInspeccionesEnFechas(LocalDate inicio, LocalDate fin) {
		
		SortedSet <Inspeccion> resultado = new TreeSet <Inspeccion> ();
		
		for (Inspeccion inspeccion : inspecciones) {
			
			if (inspeccion.getFecha().isBefore(fin) && inspeccion.getFecha().isAfter(inicio)) {
				
				resultado.add(inspeccion);
				
			}
			
		}
		
		return resultado;
		
	}
	
	private List <Inspeccion> calcularListaInspeccionesPorNombre(String nombre) {
		
		List <Inspeccion> resultado = new ArrayList <Inspeccion> ();
		
		for (Inspeccion inspeccion : inspecciones) {
			
			if (inspeccion.getNombre().equals(nombre)) {
				
				resultado.add(inspeccion);
				
			}
			
		}
		
		return resultado;
		
	}
		
	public Map <String, List <Inspeccion>> obtenerInspeccionesPorRestaurante() {
		
		Map <String, List<Inspeccion>> resultado = new HashMap <String, List<Inspeccion>> ();
		
		for (Inspeccion inspeccion : inspecciones) {
			
			if (!resultado.containsKey(inspeccion.getNombre())) {
				
				resultado.put(inspeccion.getNombre(), calcularListaInspeccionesPorNombre(inspeccion.getNombre()));
				
			}
			
		}
		
		return resultado;
		
	}
	
	private Integer calcularNumeroDeInspeccionesDadoNombre(String nombre) {
		
		Integer contador = 0;
		
		for (Inspeccion inspeccion : inspecciones) {
			
			if (inspeccion.getNombre().equals(nombre)) {
				
				contador += 1;
				
			}
			
		}
		
		return contador;
		
	}
	
	public String obtenerRestauranteMasInspecciones() {
		
		String resultado = null;
		Integer maximo = 0;
		
		List <String> listaRestaurantes = new ArrayList <String> ();
		
		for (Inspeccion inspeccion : inspecciones) {
			
			if (!listaRestaurantes.contains(inspeccion.getNombre())) {
				
				listaRestaurantes.add(inspeccion.getNombre());
				
			}
			
		}
		
		for (String nombre : listaRestaurantes) {
				
			if (calcularNumeroDeInspeccionesDadoNombre(nombre) > maximo) {
					
				maximo = calcularNumeroDeInspeccionesDadoNombre(nombre);
					
			} else {
					
				resultado = nombre;
					
			}
				
		}
			
		return resultado;
		
	}
	
	private Integer calcularNumeroInspeccionesCriticasDadoDistrito(Distrito distrito)  {
		
		Integer contador = 0;
		
		for (Inspeccion inspeccion : inspecciones) {
			
			if (inspeccion.getDistrito().equals(distrito)) {
				
				if (inspeccion.getEsCritica()) {
					
					contador += 1;
					
				}
			}
			
		}
		
		return contador;
		
	}
	
	public Distrito obtenerDistritoMasInspeccionesCriticas() {
		
		Distrito resultado = null;
		Integer maximo = 0;
		
		List <Distrito> listaDistritos = new ArrayList <Distrito> ();
		
		
		for (Inspeccion inspeccion : inspecciones) {
			
			if (!listaDistritos.contains(inspeccion.getDistrito())) {
				
				listaDistritos.add(inspeccion.getDistrito());
				
			}
			
		}
		
		for (Distrito distrito : listaDistritos) {
			
			if (calcularNumeroInspeccionesCriticasDadoDistrito(distrito) > maximo) {
				
				maximo = calcularNumeroInspeccionesCriticasDadoDistrito(distrito);
				
			} else {
				
				resultado = distrito;
				
			}
			
		}
		
		return resultado;
		
	}
	
	private String calculaDescripcionConMayorPuntuacionDadoNombre(String nombre) {
		
		String resultado = null;
		Double maximo = 0.0;
		
		for (Inspeccion inspeccion : inspecciones) {
			
			if (inspeccion.getNombre().equals(nombre)) {
				
				if (inspeccion.getScore() > maximo) {
					
					maximo = inspeccion.getScore();
					
				} else {
					
					resultado = inspeccion.getDescripcion();
					
				}
				
			}
			
		}
		
		return resultado;
		
	}
	
	public Map <String, String> obtenerDescripcionInspeccionMayorPuntuacionPorNombre() {
		
		Map <String, String> resultado = new HashMap <String, String> ();
			
		for (Inspeccion inspeccion : inspecciones) {
			
			if (!resultado.containsKey(inspeccion.getNombre())) {
				
				resultado.put(inspeccion.getNombre(), calculaDescripcionConMayorPuntuacionDadoNombre(inspeccion.getNombre()));
				
			}
			
		}
		
		return resultado;
		
	}

}
