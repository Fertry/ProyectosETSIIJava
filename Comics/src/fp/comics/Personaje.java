package fp.comics;

import fp.utiles.Checkers;

public class Personaje {
	
	private String nombre;
	private String tipo;
	private String ojos;
	private String pelo;
	private String sexo;
	private Integer añoAparicion;
	
	public Personaje (String nombre, String tipo, String ojos, String pelo, String sexo, Integer añoAparicion) {
		
		Checkers.check("El año de aparición debe ser igual o posterior a 1930", añoAparicion >= 1930);
		
		this.nombre = nombre;
		this.tipo = tipo;
		this.ojos = ojos;
		this.pelo = pelo;
		this.sexo = sexo;
		this.añoAparicion = añoAparicion;
		
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public String getOjos() {
		return ojos;
	}

	public String getPelo() {
		return pelo;
	}

	public String getSexo() {
		return sexo;
	}

	public Integer getAñoAparicion() {
		return añoAparicion;
	}
	
	public String getDecada() {
		
		Integer decada = getAñoAparicion() - getAñoAparicion() % 10;
		
		return decada.toString();
		
	}

	public String toString() {
		return "Personaje [nombre=" + nombre + ", tipo=" + tipo + ", ojos=" + ojos + ", pelo=" + pelo + ", sexo=" + sexo
				+ ", añoAparicion=" + añoAparicion + "]";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personaje other = (Personaje) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	public int compareTo(Personaje personaje) {
		
		int resultado = getAñoAparicion().compareTo(personaje.getAñoAparicion());
		
		return resultado;
		
	}
	
}
