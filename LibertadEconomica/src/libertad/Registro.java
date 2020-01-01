package libertad;

public class Registro {
	
	private Integer anyo;
	private String pais;
	private Double puntos;
	private Double gobierno;
	private Double justicia;
	private Double derechos;
	
	public Registro(Integer anyo, String pais, Double puntos, Double gobierno, Double justicia, Double derechos) {
		
		Checkers.check("El año debe estar comprendido entre 2009 y 2016", anyo >= 2009 && anyo <= 2016);
		Checkers.check("El valor de puntos debe estar comprendido entre 0 o 10 (o -1)", puntos >= 0 && puntos <= 10 || puntos == -1);
		Checkers.check("El valor de gobierno debe estar comprendido entre 0 o 10 (o -1)", gobierno >= 0 && gobierno <= 10 || gobierno == -1);
		Checkers.check("El valor de puntos debe estar comprendido entre 0 o 10 (o -1)", justicia >= 0 && justicia <= 10 || justicia == -1);
		Checkers.check("El valor de puntos debe estar comprendido entre 0 o 10 (o -1)", derechos >= 0 && derechos <= 10 || derechos == -1);
		
		
		this.anyo = anyo;
		this.pais = pais;
		this.puntos = puntos;
		this.gobierno = gobierno;
		this.justicia = justicia;
		this.derechos = derechos;
		
	}

	public Integer getAnyo() {
		return anyo;
	}

	public String getPais() {
		return pais;
	}

	public Double getPuntos() {
		return puntos;
	}

	public Double getGobierno() {
		return gobierno;
	}

	public Double getJusticia() {
		return justicia;
	}

	public Double getDerechos() {
		return derechos;
	}
	
	public Nivel getNivel() {
		
		Nivel nivel = null;
		
		if (puntos >= gobierno && puntos >= justicia) {
			
			nivel = Nivel.ALTO;
			
		} else if (gobierno > puntos  && puntos < justicia) {
			
			nivel = Nivel.MEDIO;
			
		} else {
			
			nivel = Nivel.BAJO;
			
		}
		
		return nivel;
		
	}

	public String toString() {
		return "Registro [anyo=" + anyo + ", pais=" + pais + ", puntos=" + puntos + ", gobierno=" + gobierno
				+ ", justicia=" + justicia + ", derechos=" + derechos + "]";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anyo == null) ? 0 : anyo.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
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
		if (anyo == null) {
			if (other.anyo != null)
				return false;
		} else if (!anyo.equals(other.anyo))
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		return true;
	}
	
	public int compareTo(Registro registro) {
		
		int res = anyo.compareTo(registro.getAnyo());
		
		if (res == 0) {
			
			res = pais.compareTo(registro.getPais());
			
		}
		
		return res;
		
	}
	
}
