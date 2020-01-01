package fp.nobel.test;

import java.util.Collection;
import java.util.Map;

import fp.nobel.Genero;
import fp.nobel.Premio;

public interface Premios {
	
	public void añadirPremio(Premio premio);
	public Collection <Premio> obtenerPremiosDeGenero(Genero genero);
	public Integer calcularNumeroPremiadosMasJovenesDe(Integer edad);
	public Map <String, Double> calcularMediaEdadPorCategoria();

}
