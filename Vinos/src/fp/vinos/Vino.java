package fp.vinos;

import fp.utiles.Checkers;

public class Vino {
	
	private String pais;
	private String region;
	private Integer puntos;
	private Double precio;
	private String uva;
	
	public Vino (String pais, String region, Integer puntos, Double precio, String uva) {
		
		Checkers.check("Los puntos deben estar entre 0 y 100.", puntos >= 0 && puntos <= 100);
		Checkers.check("El precio debe ser mayor que cero.", precio > 0);
		
		this.pais = pais;
		this.region = region;
		this.puntos = puntos;
		this.precio = precio;
		this.uva = uva;
		
	}

	public String getPais() {
		return pais;
	}

	public String getRegion() {
		return region;
	}

	public Integer getPuntos() {
		return puntos;
	}

	public Double getPrecio() {
		return precio;
	}

	public String getUva() {
		return uva;
	}
	
	public Double getCalidadPrecio() {
		
		return this.puntos / this.precio;
		
	}

	public String toString() {
		return "Vino [pais=" + pais + ", region=" + region + ", puntos=" + puntos + ", precio=" + precio + ", uva="
				+ uva + "]";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		result = prime * result + ((puntos == null) ? 0 : puntos.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result + ((uva == null) ? 0 : uva.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vino other = (Vino) obj;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		if (puntos == null) {
			if (other.puntos != null)
				return false;
		} else if (!puntos.equals(other.puntos))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		if (uva == null) {
			if (other.uva != null)
				return false;
		} else if (!uva.equals(other.uva))
			return false;
		return true;
	}
	
}
