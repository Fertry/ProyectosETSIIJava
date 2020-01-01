package ofertas;

import java.time.LocalDate;

public class OfertaEmpleo {
	
	private String especialidad;
	private Integer numPlazas;
	private Integer numPlazasDiscapacidad;
	private LocalDate fechaPublicacionBOJA;
	private TipoAcceso tipoAcceso;
	
	public OfertaEmpleo(String especialidad, Integer numPlazas, Integer numPlazasDiscapacidad, LocalDate fechaPublicacionBOJA, TipoAcceso tipoAcceso) {
		
		Checkers.check("El numero de plazas no puede ser negativo.", numPlazas > 0);
		Checkers.check("El numero de plazas reservadas para discapacitados no puede ser negativo.", numPlazasDiscapacidad > 0);
		Checkers.check("La fecha debe ser posterior o igual a 1990 y anterior o igual a la fecha actual", fechaPublicacionBOJA.isAfter(LocalDate.of(1990, 1, 1)) && fechaPublicacionBOJA.isBefore(LocalDate.now()));
		
		this.especialidad = especialidad;
		this.numPlazas = numPlazas;
		this.numPlazasDiscapacidad = numPlazasDiscapacidad;
		this.fechaPublicacionBOJA = fechaPublicacionBOJA;
		this.tipoAcceso = tipoAcceso;
		
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public Integer getNumPlazas() {
		return numPlazas;
	}

	public Integer getNumPlazasDiscapacidad() {
		return numPlazasDiscapacidad;
	}

	public LocalDate getFechaPublicacionBOJA() {
		return fechaPublicacionBOJA;
	}

	public TipoAcceso getTipoAcceso() {
		return tipoAcceso;
	}

	public Integer getNumPlazasTotales() {
		
		return numPlazas + numPlazasDiscapacidad;
		
	}
	
	public Double getPorcentajePlazasDiscapacidad() {
		
		Double porcentaje = (numPlazasDiscapacidad * 100.00) / getNumPlazasTotales();
		
		return porcentaje;
		
	}
	
	public Integer getAnyo() {
		
		return fechaPublicacionBOJA.getYear();
		
	}

	public String toString() {
		return "OfertaEmpleo [especialidad=" + especialidad + ", numPlazas=" + numPlazas + ", numPlazasDiscapacidad="
				+ numPlazasDiscapacidad + ", fechaPublicacionBOJA=" + fechaPublicacionBOJA + ", tipoAcceso="
				+ tipoAcceso + ", getNumPlazasTotales()=" + getNumPlazasTotales()
				+ ", getPorcentajePlazasDiscapacidad()=" + getPorcentajePlazasDiscapacidad() + "]";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((especialidad == null) ? 0 : especialidad.hashCode());
		result = prime * result + ((fechaPublicacionBOJA == null) ? 0 : fechaPublicacionBOJA.hashCode());
		result = prime * result + ((tipoAcceso == null) ? 0 : tipoAcceso.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OfertaEmpleo other = (OfertaEmpleo) obj;
		if (especialidad == null) {
			if (other.especialidad != null)
				return false;
		} else if (!especialidad.equals(other.especialidad))
			return false;
		if (fechaPublicacionBOJA == null) {
			if (other.fechaPublicacionBOJA != null)
				return false;
		} else if (!fechaPublicacionBOJA.equals(other.fechaPublicacionBOJA))
			return false;
		if (tipoAcceso != other.tipoAcceso)
			return false;
		return true;
	}
	
	public int compareTo(OfertaEmpleo oferta) {
		
		int res = fechaPublicacionBOJA.compareTo(oferta.getFechaPublicacionBOJA());
		
		if (res == 0) {
			
			res = especialidad.compareTo(oferta.getEspecialidad());
			
		} else if (res == 0) {
			
			res = getNumPlazasTotales().compareTo(oferta.getNumPlazasTotales());
			
		}
		
		return res;
		
	}
	
}
