package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("AxB")	
public class AxB extends Promocion {

	private Atraccion atraccionExtra;

	public AxB(/*String id,String nombre, Set<Atraccion> atracciones, */Atraccion nuevaAtraccion) {
		//super(id,nombre, atracciones);
		this.atraccionExtra = nuevaAtraccion;
	}

	@Override
	public double calcularCostoFinal() {
		return getCosto() - this.atraccionExtra.getCosto();
	}
/*
	@Override
	public double getTiempo() {
		return super.getTiempo();// + atraccionExtra.getTiempo();
	}
*/
	@Override
	public boolean cupoDisponible() {
		return super.cupoDisponible() && atraccionExtra.getCupo() > 0;
	}

	public Atraccion getAtraccionExtra() {
		return atraccionExtra;
	}

}
