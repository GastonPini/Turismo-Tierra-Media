package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//@Entity
@DiscriminatorValue("Absoluta")
public class Absoluta extends Promocion {

	private double descuento;

	public Absoluta(/*String id, String nombre, Set<Atraccion> atracciones, */String descuento) {
		//super(id, nombre, atracciones);
		this.descuento = Double.parseDouble(descuento);
	}

	@Override
	public double calcularCostoFinal() {
		return descuento;
	}
}
