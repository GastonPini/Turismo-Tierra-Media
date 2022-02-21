package system;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Atraccion;
import model.Promocion;
import model.Usuario;


public class Catalogador {

	public void ordenarPromocionMaxCosto(ArrayList<Promocion> promociones) {
		Collections.sort(promociones, new ComparadorPromocion());
	}

	public void ordenarAtraccionMaxCosto(ArrayList<Atraccion> atracciones) {
		Collections.sort(atracciones, new ComparadorAtracciones());
	}

	public ArrayList<Atraccion> sugerirAtraccion(Usuario u, List<Atraccion> sugerencias) {
		ArrayList<Atraccion> sugerenciasFinal = new ArrayList<Atraccion>();
		for (Atraccion atraccion : sugerencias) {
			if (atraccion.getTipoAtraccion().getNombre().equals(u.getAtraccionPreferida().getNombre())) {
				sugerenciasFinal.add(atraccion);
			}
		}
		ordenarAtraccionMaxCosto(sugerenciasFinal);
		return sugerenciasFinal;
	}

	public ArrayList<Atraccion> sugerirAtraccionSinTipo(Usuario u, List<Atraccion> sugerencias) {
		ArrayList<Atraccion> sugerenciasFinal = new ArrayList<Atraccion>();
		for (Atraccion atraccion : sugerencias) {
			if (!atraccion.getTipoAtraccion().getNombre().equals(u.getAtraccionPreferida().getNombre())) {
				sugerenciasFinal.add(atraccion);
			}
		}
		ordenarAtraccionMaxCosto(sugerenciasFinal);
		return sugerenciasFinal;
	}

	public ArrayList<Atraccion> listaDeSugerencias(Usuario usuario, List<Atraccion> atraccion) {
		
		ArrayList<Atraccion> lista = new ArrayList<Atraccion>();
		lista.addAll(sugerirAtraccion(usuario, atraccion));
		lista.addAll(sugerirAtraccionSinTipo(usuario, atraccion));

		return lista;
	}

	public void comprar(Usuario usuario, Atraccion producto) {
		usuario.comprar(producto);
		producto.comprado();
	}

}