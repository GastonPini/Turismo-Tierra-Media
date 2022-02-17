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

	/*
	 * public ArrayList<Promocion> sugerirPromocion(Usuario u, ArrayList<Promocion>
	 * sugerencias) { ArrayList<Promocion> sugerenciasFinal = new
	 * ArrayList<Promocion>(); for (Promocion promocion : sugerencias) { if
	 * (promocion.tieneTipo(u.getAtraccionPreferida()) &&
	 * habilitaSugerenciaPromocion(u, promocion)) { sugerenciasFinal.add(promocion);
	 * } } return sugerenciasFinal; }
	 */
	/*
	 * public ArrayList<Promocion> sugerirPromocionSinTipo(Usuario u,
	 * ArrayList<Promocion> sugerencias) { ArrayList<Promocion> sugerenciasFinal =
	 * new ArrayList<Promocion>(); for (Promocion promocion : sugerencias) { if
	 * (!promocion.tieneTipo(u.getAtraccionPreferida()) &&
	 * habilitaSugerenciaPromocion(u, promocion)) { sugerenciasFinal.add(promocion);
	 * } } return sugerenciasFinal; }
	 */
	
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
/*
	public boolean habilitaSugerenciaPromocion(Usuario u, Promocion p) {
		return p.calcularCostoFinal() <= u.getDineroDisponible() && p.cupoDisponible()
				&& u.getTiempoDisponible() >= p.getTiempo();// && !u.tiene(p);
	}

	public boolean habilitaSugerenciaAtraccion(Usuario u, Atraccion a) {
		return a.calcularCostoFinal() <= u.getDineroDisponible() && a.hayCupo()
				&& u.getTiempoDisponible() >= a.getTiempo();// && !u.tiene(a);
	}
*/
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
