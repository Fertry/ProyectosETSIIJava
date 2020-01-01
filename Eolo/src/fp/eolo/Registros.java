package fp.eolo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import fp.utiles.Checkers;
import fp.utiles.GraphTools;

public class Registros {
	
	private Collection <Registro> registros;
	
	public Registros() {
		
	}
	
	public Registros(Stream <Registro> registros) {
		
		this.registros = registros.collect(Collectors.toSet());
		
	}
	
	public void añadirRegistro(Registro registro) {
		
		registros.add(registro);
		
	}
	
	public Integer getNumeroRegistros() {
		
		Integer contador = 0;
		
		for (@SuppressWarnings("unused") Registro registro : registros) {
			
			contador += 1;
			
		}
		
		return contador;
		
	}

	public String toString() {
		return "Registros [registros=" + registros + "]";
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
	
	public Collection <Registro> calcularRegistrosDeViento(Viento viento) {
		
		Collection <Registro> resultado = new ArrayList <Registro> ();
		
		for (Registro registro : registros) {
			
			if (registro.getViento(registro.getDireccion(), registro.getVelocidadMedia()).equals(viento)) {
				
				resultado.add(registro);
				
			}
			
		}
		
		return resultado;
		
	}
	
	public Long calcularDiasDeVientoEnCiudadEnFechas(Viento viento, String ciudad, LocalDate inicio, LocalDate fin) {
		
		Checkers.check("La fecha de inicio debe ser anterior a la fecha de fin", inicio.isBefore(fin));
		
		Long contador = (long) 0;
		
		for (Registro registro : registros) {
			
			if (registro.getViento(registro.getDireccion(), registro.getVelocidadMedia()).equals(viento) && registro.getCiudad().equals(ciudad) && registro.getFecha().isAfter(inicio) && registro.getFecha().isBefore(fin)) {
				
				contador += 1;
				
			}
		}
		
		return contador;
		
	}
	
	public List <Registro> obtenerRegistrosMayorVelocidadMaxima(Integer minimo) {
		
		List <Registro> resultado = new ArrayList <Registro> ();
		
		for (Registro registro : registros) {
			
			if (registro.getVelocidadMaxima() > minimo) {
				
				resultado.add(registro);
				
			}
			
		}
		
		return resultado;
		
	}
	
	public Double calcularPromedioVelocidadMediaEnAño(Integer año) {
		
		Double media = 0.0;
		
		Double sumador = 0.0;
		Double contador = 0.0;
		
		for (Registro registro : registros) {
			
			if (registro.getAño().equals(año)) {
				
				sumador += registro.getVelocidadMedia();
				contador += 1;
				
			}
			
		}
		
		media = sumador / contador;
		
		return media;
		
	}
	
	private Double calcularPromedioDadoFecha(LocalDate fecha) {
		
		Double media = 0.0;
		
		Double sumador = 0.0;
		Double contador = 0.0;
		
		for (Registro registro : registros) {
			
			if (registro.getFecha().equals(fecha)) {
				
				sumador += registro.getVelocidadMedia();
				contador += 1;
				
			}
			
		}
		
		media = sumador / contador;
		
		return media;
		
	}
	
	public Map <LocalDate, Double> calcularVelocidadMediaPorFecha() {
		
		Map <LocalDate, Double> resultado = new HashMap <LocalDate, Double> ();
		
		for (Registro registro : registros) {
			
			if (!resultado.containsKey(registro.getFecha())) {
				
				resultado.put(registro.getFecha(), calcularPromedioDadoFecha(registro.getFecha()));
				
			}
			
		}
		
		return resultado;
		
	}

	public List <Double> ordenarVelocidadesMediasPorFecha (Integer numero) {
		 
		Map <LocalDate, Double> velocidadesPorFecha = calcularVelocidadMediaPorFecha();
		
		return velocidadesPorFecha.keySet().stream().sorted().map(x -> velocidadesPorFecha.get(x)).limit(numero).collect(Collectors.toList());
		
	}
	
	private Registro mayorVelocidadMaximaPorCiudad(String ciudad) {
		
		Registro resultado = null;
		
		Double maximo = 0.0;
		
		for (Registro registro : registros) {
			
			if (registro.getCiudad().equals(ciudad)) {
				
				if (registro.getVelocidadMaxima() > maximo) {
					
					maximo = registro.getVelocidadMaxima();
					resultado = registro;
					
				}
				
			}
			
		}
		
		return resultado;
		
	}
	
	public Map <String, Registro> calcularRegistroMayorVelocidadMaximaPorCiudad() {
		
		Map <String, Registro> resultado = new HashMap <String, Registro> ();
		
		for (Registro registro : registros) {
			
			if (!resultado.containsKey(registro.getCiudad())) {
				
				resultado.put(registro.getCiudad(), mayorVelocidadMaximaPorCiudad(registro.getCiudad()));
				
			}
			
		}
		
		return resultado;
		
	}
	
	/*
	 * public Viento calcularVientoPredominanteDeCiudad (String ciudad) {
	 * 
	 * Map <Viento, Long> registrosPorViento = registros.stream().filter(x ->
	 * x.getCiudad().equals(ciudad)).collect(Collectors.groupingBy(WHAT THE ACTUAL
	 * FUCK, Collectors.counting()));
	 * 
	 * return registrosPorViento.keySet().stream().max(Comparator.comparing(x ->
	 * registrosPorViento.get(x))).get();
	 * 
	 * }
	 */
	
	private Double calcularPromedioVelocidadesMediasDadoUnaCiudadYUnViento(String ciudad, Viento viento) {
		
		Double promedio = 0.0;
		
		Double sumador = 0.0;
		Double contador = 0.0;
		
		for (Registro registro : registros) {
			
			if (registro.getCiudad().equals(ciudad) && registro.getViento(registro.getDireccion(), registro.getVelocidadMedia()).equals(viento)) {
				
				sumador += registro.getVelocidadMedia();
				contador += 1;
				
			}
			
		}
		
		promedio = sumador / contador;
		
		return promedio;
		
	}
	
	public Map <String, Double> calcularVelocidadMediaDeVientoPorCiudad(Viento viento) {
		
		Map <String, Double> resultado = new HashMap <String, Double> ();
		
		for (Registro registro : registros) {
			
			if (!resultado.containsKey(registro.getCiudad())) {
				
				resultado.put(registro.getCiudad(), calcularPromedioVelocidadesMediasDadoUnaCiudadYUnViento(registro.getCiudad(), viento));
				
			}
			
		}
		
		return resultado;
		
	}
	
	public void generarDiagramaBarras (String ficheroSalida, Viento viento1, Viento viento2) {
		
		Map <String, Double> velocidadesViento1 = calcularVelocidadMediaDeVientoPorCiudad(viento1);
		Map <String, Double> velocidadesViento2 = calcularVelocidadMediaDeVientoPorCiudad(viento2);
		
		Map <String, Double> medias = new HashMap<>();
		
		for (String x: velocidadesViento1.keySet()) {
			
			medias.put(x, (velocidadesViento1.get(x) + velocidadesViento2.get(x)) / 2);
			
		}
		
		List <String> ciudadesOrdenadas = medias.keySet().stream().sorted(Comparator.comparing(x -> medias.get(x))).collect(Collectors.toList());
		
		GraphTools.barChart("out/" + ficheroSalida, ciudadesOrdenadas, viento1.toString(), velocidadesViento1, viento2.toString(), velocidadesViento2);
		
	}
	
	
	
	

}
