package fp.albumes;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Albumes {
	public Map<Cuartil, SortedSet<Album>> albumesPorCuartil;
	
	public Albumes() {
		albumesPorCuartil=new HashMap<>();
	}
	public Albumes(Stream<Album>albumes) {
		albumesPorCuartil=albumes.collect(Collectors.groupingBy(Album::getCuartil,
				Collectors.toCollection(TreeSet::new)));
	}
	public void añadirAlbum(Album a) {
		if(albumesPorCuartil.containsKey(a.getCuartil())) {
			albumesPorCuartil.get(a.getCuartil()).add(a);
		}else {
			SortedSet<Album>ss=new TreeSet<>();
			ss.add(a);
			albumesPorCuartil.put(a.getCuartil(), ss);
		}
	}

	public Set<Album> getAlbumes(){
		Set<Album>res=new HashSet<>();
		Collection<SortedSet<Album>>sets=albumesPorCuartil.values();
		for(SortedSet<Album>ss:sets) {
			res.addAll(ss);
		}
		return res;
		
		/*
		 * versión flatMap
		 */
		//return albumesPorCuartil.values().stream().flatMap(ss->ss.stream()).collect(Collectors.toSet());
		
	}

	
	/*
	 * Devuelve el número de álbumes que contienen en su título el nombre del artista
	 */
	public Long calcularNumeroAlbumesContienenNombreArtista(){
		return getAlbumes().stream().
			filter(x->x.getNombre().contains(x.getArtista())).count();
	}

	/*
	 * Devuelve el número de géneros que hay en la colección de álbumes
	 */
	
	public Integer calcularNumeroGenerosDistintos() {
		return (int) getAlbumes().stream().map(Album::getGenero).distinct().count();
	}
	/*
	 * Devuelve una lista con los n álbumes más antiguos
	 */
	
	public List<Album> calcularAlbumesMasAntiguos(Integer n){
		return getAlbumes().stream().sorted(Comparator.comparing(Album::getAño)).limit(n).collect(Collectors.toList());
	}
	
	/*
	 * Devuelve un diccionario con el número de álbumes por año
	 */
	public Map<Integer,Integer> contarAlbumesPorAño(){
		return getAlbumes().stream().collect(Collectors.groupingBy(Album::getAño,
				Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
	}
	
	/*
	 * Recibe un entero n y devuelve el conjunto de artistas que tienen al menos n álbumes. 
	 * Se puede usar el método de apoyo 'calcularNumeroAlbumesPorArtista' para calcular 
	 * el número de álbumes por artista.
	 */
	public Map<String, Long> calcularNumeroAlbumesPorArtista(){
		return getAlbumes().stream().
				collect(Collectors.groupingBy(x->x.getArtista(), 
                                                         Collectors.counting()));
	}

	public Set<String> calcularArtistasConAlMenosNAlbumes(Integer n){
		return calcularNumeroAlbumesPorArtista().entrySet().stream().
				filter(x->x.getValue()>=n).
				map(x->x.getKey()).
				collect(Collectors.toSet());
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((albumesPorCuartil == null) ? 0 : albumesPorCuartil.hashCode());
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
		Albumes other = (Albumes) obj;
		if (albumesPorCuartil == null) {
			if (other.albumesPorCuartil != null)
				return false;
		} else if (!albumesPorCuartil.equals(other.albumesPorCuartil))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Albumes [albumesPorCuartil=" + albumesPorCuartil + "]";
	}
}
