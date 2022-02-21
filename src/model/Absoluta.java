package model;

import javax.persistence.DiscriminatorValue;


@DiscriminatorValue("Absoluta")
public class Absoluta extends Promocion {

	private double descuento;

	public Absoluta(String descuento) {
		this.descuento = Double.parseDouble(descuento);
	}

	@Override
	public double calcularCostoFinal() {
		return descuento;
	}

}