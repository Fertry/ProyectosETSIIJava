package libertad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Registros {
	
	private Collection <Registro> registros;
	
	public Registros(Stream <Registro> registros) {
		
		this.registros = registros.collect(Collectors.toSet());
		
	}

	public String toString() {
		return "Registros [registros=" + registros + "]";
	}
	
	public Double getValorMedioPuntuacionConjuntoPaises(Set <String> conjunto) {
		
		Double media = 0.0;
		
		Double contador = 0.0;
		Double sumador = 0.0;
		
		for (Registro registro : registros) {
			
			if (conjunto.contains(registro.getPais())) {
				
				contador += 1;
				sumador += registro.getPuntos();
				
			}
			
		}
		
		media = sumador / contador;
		
		return media;
		
	}
	
	public String getPaisMayorPuntuacion(Integer año) {
		
		String resultado = null;
		
		List <Registro> listaRegistros = new ArrayList <Registro> ();
		
		Double maximo = 0.0;
		
		for (Registro registro : registros) {
			
			if (registro.getAnyo().equals(año)) {
				
				listaRegistros.add(registro);
				
			}
			
		}
		
		for (Registro registro : listaRegistros) {
			
			if (registro.getPuntos() > maximo) {
				
				maximo = registro.getPuntos();
				resultado = registro.getPais();
				
			}
			
		}
		
		return resultado;
		
	}
	
	private Double calcularMediaDerechosDadoPais(String nombre) {
		
		Double media = 0.0;
		
		Double contador = 0.0;
		Double sumador = 0.0;
		
		for (Registro registro : registros) {
			
			if (registro.getPais().equals(nombre) && registro.getDerechos() != -1) {
				
				contador += 1;
				sumador += registro.getDerechos();
				
			}
			
		}
		
		media = sumador / contador;
		
		return media;
		
	}
	
	public Map <String, Double> getMediaDerechosPorPais() {
		
		Map <String, Double> resultado = new HashMap <String, Double> ();
		
		for (Registro registro : registros) {
			
			if (!resultado.containsKey(registro.getPais())) {
				
				resultado.put(registro.getPais(), calcularMediaDerechosDadoPais(registro.getPais()));
				
			}
			
		}
		
		return resultado;
		
	}
	
	public String getPaisConMenorMediaDerechos() {
		
		String resultado = null;
		
		Map <String, Double> diccionario = getMediaDerechosPorPais();
		
		List <Double> valores = new ArrayList <Double> ();
		
		for (Double valor : diccionario.values()) {
			
			valores.add(valor);
			
		}
		
		Double minimo = valores.get(0);
		
		for (String nombre : diccionario.keySet()) {
			
			for (Double media : diccionario.values()) {
			
				if (minimo > media) {
					
					minimo = media;
					resultado = nombre;
					
				}
				
			}
			
		}
		
		return resultado;
		
	}
	
	private String calcularPaisConMayorMediaDadoAño(Integer año) {
		
		String resultado = null;
		
		Double maximo = 0.0;
		
		for (Registro registro : registros) {
			
			if (registro.getAnyo().equals(año)) {
				
				if (registro.getDerechos() > maximo) {
					
					maximo = registro.getDerechos();
					resultado = registro.getPais();
					
				}
				
			}
			
		}
		
		return resultado;
		
	}
	
	public Map <Integer, String> getPaisMasDerechosPorAnyo() {
		
		Map <Integer, String> resultado = new HashMap <Integer, String> ();
		
		for (Registro registro : registros) {
			
			if (!resultado.containsKey(registro.getAnyo())) {
				
				resultado.put(registro.getAnyo(), calcularPaisConMayorMediaDadoAño(registro.getAnyo()));
				
			}
			
		}
		
		return resultado;
		
	}
	
	private List <Registro> ordenaLosRegistrosPorFecha() {
		
		List <Registro> registrosOrdenados = new ArrayList <Registro> ();
		
		for (Registro registro : registros) {
			
			registrosOrdenados.add(registro);
			
		}
		
		Comparator <Registro> ordenadorPorFecha = Comparator.comparing(Registro::getAnyo);
		
		Collections.sort(registrosOrdenados, ordenadorPorFecha);
		
		return registrosOrdenados;
		
	}
	
	private List <String> calculaNPaisesConMasPuntosEnJusticiaParaUnAño(Integer año, Integer limite, List <Registro> conjunto) {
		
		List <String> resultado = new ArrayList <String> ();
		
		Integer contador = 0;
		
		Comparator <Registro> ordenadorPorJusticia = Comparator.comparing(Registro::getJusticia);
		
		Collections.sort(conjunto, ordenadorPorJusticia);
		
		for (Registro registro : conjunto) {
			
			while (contador < limite) {
				
				if (registro.getAnyo().equals(año)) {
					
					resultado.add(registro.getPais());
					contador += 1;
					
				}
				
			}
			
		}
		
		return resultado;
		
	}
	
	public Map <Integer, List <String>> getListaNPaisesPorAnyo(Integer numero) {
		
		Map <Integer, List <String>> resultado = new HashMap <Integer, List <String>> ();
		
		List <Registro> registrosOrdenados = ordenaLosRegistrosPorFecha();
		
		for (Registro registro : registrosOrdenados) {
			
			if (!resultado.containsKey(registro.getAnyo())) {
				
				resultado.put(registro.getAnyo(), calculaNPaisesConMasPuntosEnJusticiaParaUnAño(registro.getAnyo(), numero, registrosOrdenados));
				
			}
			
		}
		
		return resultado;
		
	}
	
}
