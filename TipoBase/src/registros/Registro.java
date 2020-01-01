package registros;

import java.time.LocalDate;

public class Registro {
	
	private LocalDate fecha;
	private Coordenadas coordenadas;
	private String ciudad;
	private Double richter;
	
	public Registro(LocalDate fecha, Coordenadas coordenadas, String ciudad, Double richter) {
		
		Checkers.check("La magnitud debe estar en el intervalo [1.5, 12]", richter >= 1.5 && richter <= 12);
		Checkers.check("La fecha debe ser igual o anterior a la fecha actual", fecha.isEqual(LocalDate.now()) || fecha.isBefore(LocalDate.now()));
		
		this.fecha = fecha;
		this.coordenadas = coordenadas;
		this.ciudad = ciudad;
		this.richter = richter;
		
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordenadas == null) ? 0 : coordenadas.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Registro other = (Registro) obj;
		if (coordenadas == null) {
			if (other.coordenadas != null)
				return false;
		} else if (!coordenadas.equals(other.coordenadas))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		return true;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public Coordenadas getCoordenadas() {
		return coordenadas;
	}

	public String getCiudad() {
		return ciudad;
	}

	public Double getRichter() {
		return richter;
	}
	
	public int compareTo(Registro registro) {
		
		int res = 0;
		
		res = fecha.compareTo(registro.getFecha());
		
		if (res == 0) {
			
			res = coordenadas.compareTo(registro.getCoordenadas());
			
		}
		
		return res;
		
	}

	public String toString() {
		return "Registro [fecha=" + fecha + ", coordenadas=" + coordenadas + ", ciudad=" + ciudad + ", richter="
				+ richter + "]";
	}
	
}
