package fp.inspecciones;

import java.time.LocalDate;
import java.time.Period;

import fp.utiles.Checkers;

public class Inspeccion {
	
	private String id;
	private String nombre;
	private String tipoCocina;
	private String descripcion;
	private Distrito distrito;
	private LocalDate fecha;
	private Boolean esCritica;
	private Double score;
	
	public Inspeccion(String id, String nombre, Distrito distrito, String tipoCocina, LocalDate fecha, String descripcion, Boolean esCritica, Double score) {
		
		Checkers.check("La fecha de inspección debe ser posterior al 1/1/1900", fecha.isBefore(LocalDate.of(1900, 1, 1)));
		Checkers.check("La puntuación debe ser mayor o igual a 0", score >= 0);
		
		this.id = id;
		this.nombre = nombre;
		this.distrito = distrito;
		this.tipoCocina = tipoCocina;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.esCritica = esCritica;
		this.score = score;
		
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipoCocina() {
		return tipoCocina;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public Boolean getEsCritica() {
		return esCritica;
	}

	public Double getScore() {
		return score;
	}
	
	public Period getTiempoTranscurrido() {
		
		LocalDate fechaActual = LocalDate.now();
		LocalDate fechaInspeccion = fecha;
		
		Period resultado = Period.between(fechaActual, fechaInspeccion);
		
		return resultado;
		
	}

	public String toString() {
		return "Inspeccion [nombre=" + nombre + ", descripcion=" + descripcion + ", fecha=" + fecha + ", esCritica="
				+ esCritica + ", score=" + score + "]";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inspeccion other = (Inspeccion) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
