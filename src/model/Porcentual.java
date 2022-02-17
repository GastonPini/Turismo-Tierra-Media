package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//@Entity
@DiscriminatorValue("Porcentual")
public class Porcentual extends Promocion {

	private double descuento;

	public Porcentual(/*String id,String nombre, Set<Atraccion> atracciones, */String descuento) {
		//super(id,nombre, atracciones);
		this.descuento = Double.parseDouble(descuento);
	}

	@Override
	public double calcularCostoFinal() {
		return (getCosto() - (getCosto() * (this.descuento / 100)));
	}
}
