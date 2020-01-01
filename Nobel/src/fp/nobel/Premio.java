package fp.nobel;

import fp.utiles.Checkers;

public class Premio {
	
	private Integer año;
	private String categoria;
	private String nombre;
	private String apellidos;
	private Genero genero;
	private Integer añoNacimiento;
	
	public Premio (Integer año, String categoria, String nombre, String apellidos, Genero genero, Integer añoNacimiento) {
		
		Checkers.check("El año de nacimiento debe ser menor que el año del premio.", año > añoNacimiento);
		
		this.año = año;
		this.categoria = categoria;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.genero = genero;
		this.añoNacimiento = añoNacimiento;
		
	}

	public Integer getAño() {
		return año;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public Genero getGenero() {
		return genero;
	}

	public Integer getAñoNacimiento() {
		return añoNacimiento;
	}
	
	public Integer getEdadPremiado() {
		
		return this.año - this.añoNacimiento;
		
	}

	public String toString() {
		return "Premio [año=" + año + ", categoria=" + categoria + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", genero=" + genero + ", añoNacimiento=" + añoNacimiento + "]";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((año == null) ? 0 : año.hashCode());
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
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
		Premio other = (Premio) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (año == null) {
			if (other.año != null)
				return false;
		} else if (!año.equals(other.año))
			return false;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
}
