package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Atraccion")
public class Atraccion /*extends Producto*/{
	
	public Atraccion() {}
	
	@Id
	private int id;

	@Column(name = "Nombre")
	private String nombre;

	@Column(name = "Costo")
	private double costo;

	@Column(name = "Tiempo")
	private double tiempo;

	@Column(name = "Cupo")
	private int cupo;
	
	@OneToOne
	@JoinColumn(name = "Tipo")
	private TipoAtraccion tipoAtraccion;

	@Column(name = "activo")
	private int activo;


	public TipoAtraccion getTipoAtraccion() {
		return tipoAtraccion;
	}

	public void setTipoAtraccion(TipoAtraccion tipoAtraccion) {
		this.tipoAtraccion = tipoAtraccion;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}
	
	public double calcularCostoFinal() {
		return this.getCosto();
	}

	
	public void comprado() {
		this.setCupo(this.getCupo() - 1);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(costo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + cupo;
		temp = Double.doubleToLongBits(tiempo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tipoAtraccion == null) ? 0 : tipoAtraccion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		if (Double.doubleToLongBits(costo) != Double.doubleToLongBits(other.costo))
			return false;
		if (Double.doubleToLongBits(tiempo) != Double.doubleToLongBits(other.tiempo))
			return false;
		if (tipoAtraccion == null) {
			if (other.tipoAtraccion != null)
				return false;
		} else if (!tipoAtraccion.equals(other.tipoAtraccion))
			return false;
		return true;
	}
	
	public String tipoClase() {
		return "Atraccion";
	}
	
	public boolean tieneCupo() {
		return this.hayCupo();
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public int getCupo() {
		return cupo;
	}

	public boolean cupoDisponible() {
		return hayCupo();
	}
	
	public boolean hayCupo() {
		return this.getCupo() > 0;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public double getCosto() {
		return costo;
	}

	public double getTiempo() {
		return tiempo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}
	
	public String toStringArchivo() {
		return null;
	}

}
