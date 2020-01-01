package registros;

public class Coordenadas {

	private Double latitud;
	private Double longitud;
	
	private static Double RADIO_TIERRA;
	private static String MSG_LONGITUD;
	private static String MSG_LATITUD;
	
	public Coordenadas(Double latitud, Double longitud) {
		
		this.latitud = latitud;
		this.longitud = longitud;
		
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

	public static Double getRADIO_TIERRA() {
		return RADIO_TIERRA;
	}

	public static String getMSG_LONGITUD() {
		return MSG_LONGITUD;
	}

	public static String getMSG_LATITUD() {
		return MSG_LATITUD;
	}

	public int compareTo(Coordenadas coordenadas) {
		
		int res = 0;
		
		res = latitud.compareTo(coordenadas.getLatitud());
		
		if (res == 0) {
			
			res = longitud.compareTo(coordenadas.getLongitud());
			
		}
		
		return res;
		
	}
	
	
	
}
