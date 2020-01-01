package empleo;

import java.time.LocalDate;

public class Empleo {
	
	private String cuerpo;
	private String especialidad;
	private Integer numPlazas;
	private LocalDate fechaPublicacionBOJA;
	private Integer numBOJA;
	private NivelEducativo nivelEducativo;
	
	public Empleo(String cuerpo, String especialidad, Integer numPlazas, LocalDate fechaPublicacionBOJA, Integer numBOJA, NivelEducativo nivelEducativo) {
		
		Checkers.check("El numero de plazas no puede ser negativo", numPlazas >= 0 );
		Checkers.check("El numero de BOJA debe ser mayor o igual a 1", numBOJA >= 1);
		Checkers.check("El año de publicacion debe ser posterior o igual a 1992 y anterior o igual a la fecha de hoy", fechaPublicacionBOJA.isEqual(LocalDate.of(1992, 1, 1)) || fechaPublicacionBOJA.isAfter(LocalDate.of(1992, 1, 1)) && fechaPublicacionBOJA.isEqual(LocalDate.now()) || fechaPublicacionBOJA.isBefore(LocalDate.now()));
		
		this.cuerpo = cuerpo;
		this.especialidad = especialidad;
		this.numPlazas = numPlazas;
		this.fechaPublicacionBOJA = fechaPublicacionBOJA;
		this.numBOJA = numBOJA;
		this.nivelEducativo = nivelEducativo;
		
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public Integer getNumPlazas() {
		return numPlazas;
	}

	public LocalDate getFechaPublicacionBOJA() {
		return fechaPublicacionBOJA;
	}

	public Integer getNumBOJA() {
		return numBOJA;
	}

	public NivelEducativo getNivelEducativo() {
		return nivelEducativo;
	}

	public String toString() {
		return "Empleo [cuerpo=" + cuerpo + ", especialidad=" + especialidad + ", numPlazas=" + numPlazas
				+ ", fechaPublicacionBOJA=" + fechaPublicacionBOJA + ", numBOJA=" + numBOJA + ", nivelEducativo="
				+ nivelEducativo + "]";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cuerpo == null) ? 0 : cuerpo.hashCode());
		result = prime * result + ((especialidad == null) ? 0 : especialidad.hashCode());
		result = prime * result + ((fechaPublicacionBOJA == null) ? 0 : fechaPublicacionBOJA.hashCode());
		result = prime * result + ((nivelEducativo == null) ? 0 : nivelEducativo.hashCode());
		result = prime * result + ((numBOJA == null) ? 0 : numBOJA.hashCode());
		result = prime * result + ((numPlazas == null) ? 0 : numPlazas.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleo other = (Empleo) obj;
		if (cuerpo == null) {
			if (other.cuerpo != null)
				return false;
		} else if (!cuerpo.equals(other.cuerpo))
			return false;
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
		if (nivelEducativo != other.nivelEducativo)
			return false;
		if (numBOJA == null) {
			if (other.numBOJA != null)
				return false;
		} else if (!numBOJA.equals(other.numBOJA))
			return false;
		if (numPlazas == null) {
			if (other.numPlazas != null)
				return false;
		} else if (!numPlazas.equals(other.numPlazas))
			return false;
		return true;
	}
	
	public int compareTo(Empleo empleo) {
		
		int res = 0;
		
		res = fechaPublicacionBOJA.compareTo(empleo.getFechaPublicacionBOJA());
		
		if (res == 0) {
			
			res = cuerpo.compareTo(empleo.getCuerpo());
			
		} else if (res == 0) {
			
			res = especialidad.compareTo(empleo.getEspecialidad());
				
		} else if (res == 0) {
			
			res = numPlazas.compareTo(empleo.getNumPlazas());
			
		}
		
		return res;
		
	}
	
}
