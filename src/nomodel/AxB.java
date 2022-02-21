package nomodel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import model.Atraccion;
import model.Promocion;


@Entity
@DiscriminatorValue("AxB")	
public class AxB extends Promocion {

	private Atraccion atraccionExtra;

	public AxB(Atraccion nuevaAtraccion) {
		this.atraccionExtra = nuevaAtraccion;
	}

	@Override
	public double calcularCostoFinal() {
		return getCosto() - this.atraccionExtra.getCosto();
	}

	@Override
	public boolean cupoDisponible() {
		return super.cupoDisponible() && atraccionExtra.getCupo() > 0;
	}

	public Atraccion getAtraccionExtra() {
		return atraccionExtra;
	}

}