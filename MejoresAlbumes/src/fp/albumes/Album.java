package fp.albumes;

import fp.utiles.Checkers;

public class Album implements Comparable<Album>{
	/*
	 * Atributos
	 */
	private Integer posicion;
	private Integer año;
	private String nombre;
	private String artista;
	private String genero;
	
	
	/*
	 * constructor
	 */
	public Album(Integer posicion, Integer año, String nombre, String artista, String genero) {
		Checkers.check("La posición debe estar entre 1 y 500", 1<=posicion && posicion<=500);
		Checkers.check("El año debe ser positivo", año>0);
		
		this.posicion = posicion;
		this.año = año;
		this.nombre = nombre;
		this.artista = artista;
		this.genero = genero;
	}

	
	/*
	 * Getters
	 */

	public Integer getPosicion() {
		return posicion;
	}



	public Integer getAño() {
		return año;
	}



	public String getNombre() {
		return nombre;
	}



	public String getArtista() {
		return artista;
	}



	public String getGenero() {
		return genero;
	}


	/*
	 * propiedad derivada: cuartil
	 */
	public Cuartil getCuartil() {
		if(posicion<=125) {
			return Cuartil.PRIMERO;
		}else {
			if(125<posicion && posicion<=250) {
				return Cuartil.SEGUNDO;
			}else {
				if(250<posicion && posicion<=375) {
					return Cuartil.TERCERO;
				}else {
					return Cuartil.CUARTO;
				}
			}
		}
	}

	/*
	 * criterio de igualdad y hashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((artista == null) ? 0 : artista.hashCode());
		result = prime * result + ((posicion == null) ? 0 : posicion.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (artista == null) {
			if (other.artista != null)
				return false;
		} else if (!artista.equals(other.artista))
			return false;
		if (posicion == null) {
			if (other.posicion != null)
				return false;
		} else if (!posicion.equals(other.posicion))
			return false;
		return true;
	}

	/*
	 * representación como cadena
	 */
	
	@Override
	public String toString() {
		return "Album [posicion=" + posicion + ", nombre=" + nombre + ", artista=" + artista + "]";
	}
	
	@Override
	public int compareTo(Album o) {
		/*
		 * artista, album y posición
		 */
		int res=artista.compareTo(o.artista);
		if(res==0) {
			res=nombre.compareTo(o.nombre);
			if(res==0) {
				res=posicion.compareTo(o.posicion);
			}
		}
		return res;
	}	
	
}
