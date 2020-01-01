package registros;

public class Coordenadas {

	private Double latitud;
	private Double longitud;
	private Double RADIO_TIERRA;
	private String MSG_LONGITUD;
	private String MSG_LATITUD;
	
	public Coordenadas(Double latitud, Double longitud) {
		
		this.latitud = latitud;
		this.longitud = longitud;

	}

	public String toString() {
		return "Coordenadas [latitud=" + latitud + ", longitud=" + longitud + ", RADIO_TIERRA=" + RADIO_TIERRA
				+ ", MSG_LONGITUD=" + MSG_LONGITUD + ", MSG_LATITUD=" + MSG_LATITUD + "]";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((latitud == null) ? 0 : latitud.hashCode());
		result = prime * result + ((longitud == null) ? 0 : longitud.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenadas other = (Coordenadas) obj;
		if (latitud == null) {
			if (other.latitud != null)
				return false;
		} else if (!latitud.equals(other.latitud))
			return false;
		if (longitud == null) {
			if (other.longitud != null)
				return false;
		} else if (!longitud.equals(other.longitud))
			return false;
		return true;
	}
	
	public Double getLatitud() {
		return latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public int compareTo(Coordenadas coordenadas) {
		
		int resultado = 0;
		
		resultado = this.latitud.compareTo(coordenadas.getLatitud());
		
		if (resultado == 0) {
			
			resultado = this.longitud.compareTo(coordenadas.getLongitud());
			
		}
		
		return resultado;
		
	}
	
}
