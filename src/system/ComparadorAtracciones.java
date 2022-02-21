package system;

import java.util.Comparator;

import model.Atraccion;


public class ComparadorAtracciones implements Comparator<Atraccion> {

	private static Integer esMayor = -1;

	@Override
	public int compare(Atraccion a1, Atraccion a2) {
		if (Double.compare(a1.getCosto(), a2.getCosto()) == 0) {
			return Double.compare(a1.getTiempo(), a2.getTiempo()) * esMayor;
		}
		return Double.compare(a1.getCosto(), a2.getCosto()) * esMayor;
	}

}