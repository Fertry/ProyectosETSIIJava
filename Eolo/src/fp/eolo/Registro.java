package fp.eolo;

import java.time.LocalDate;

import fp.utiles.Checkers;

public class Registro {
	
	private LocalDate fecha;
	private String ciudad;
	private Double direccion;
	private Double velocidadMedia;
	private Double velocidadMaxima;
	
	public Registro(LocalDate fecha, String ciudad, Double direccion, Double velocidadMedia, Double velocidadMaxima) {
		
		Checkers.check("La velocidad media no puede superar a la velocidad maxima", velocidadMedia < velocidadMaxima);
		
		this.fecha = fecha;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.velocidadMedia = velocidadMedia;
		this.velocidadMaxima = velocidadMaxima;
		
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getCiudad() {
		return ciudad;
	}

	public Double getDireccion() {
		return direccion;
	}

	public Double getVelocidadMedia() {
		return velocidadMedia;
	}

	public Double getVelocidadMaxima() {
		return velocidadMaxima;
	}
	
	public Integer getDia() {
		
		return fecha.getDayOfMonth();
		
	}
	
	public Integer getMes() {
		
		return fecha.getMonthValue();
		
	}
	
	public Integer getAño() {
		
		return fecha.getYear();
		
	}
	
	public Viento getViento(Double direccion, Double velocidadMedia) {
		
		Viento res = null;
		
		if (direccion > 135 && direccion < 225) {
			
			res = Viento.SUR;
			
		} else if (direccion > 225 && direccion <= 315) {
			
			res = Viento.PONIENTE;
			
		} else if (direccion > 315 && direccion < 45) {
			
			res = Viento.NORTE;
			
		} else if (direccion > 45 && direccion <= 135) {
			
			res = Viento.LEVANTE;
			
		} else if (direccion > 45 && direccion < 135 && velocidadMedia < 3) {
			
			res = Viento.LEVANTICHON;
			
		}
		
		return res;
		
	}

	public String toString() {
		return "Registro [fecha=" + fecha + ", ciudad=" + ciudad + ", direccion=" + direccion + ", velocidadMedia="
				+ velocidadMedia + ", velocidadMaxima=" + velocidadMaxima + "]";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ciudad == null) ? 0 : ciudad.hashCode());
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
		if (ciudad == null) {
			if (other.ciudad != null)
				return false;
		} else if (!ciudad.equals(other.ciudad))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		return true;
	}
	
	public int compareTo(Registro registro) {
		
		int res = getCiudad().compareTo(registro.getCiudad());
		
		if (res == 0) {
			
			res = getFecha().compareTo(registro.getFecha());
			
		}
		
		return res;
		
	}
	
	

}
