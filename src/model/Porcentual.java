package model;

import javax.persistence.DiscriminatorValue;


@DiscriminatorValue("Porcentual")
public class Porcentual extends Promocion {

	private double descuento;

	public Porcentual(String descuento) {
		this.descuento = Double.parseDouble(descuento);
	}

	@Override
	public double calcularCostoFinal() {
		return (getCosto() - (getCosto() * (this.descuento / 100)));
	}

}