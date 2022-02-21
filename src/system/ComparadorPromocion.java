package system;

import java.util.Comparator;

import model.Promocion;


public class ComparadorPromocion implements Comparator<Promocion> {

	private static Integer esMayor = -1;

	@Override
	public int compare(Promocion p1, Promocion p2) {
		if (Double.compare(p1.calcularCostoFinal(), p2.calcularCostoFinal()) == 0) {
			return Double.compare(p1.getTiempo(), p2.getTiempo()) * esMayor;
		}
		return Double.compare(p1.calcularCostoFinal(), p2.calcularCostoFinal()) * esMayor;
	}

}