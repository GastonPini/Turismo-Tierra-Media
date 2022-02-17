package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dao.ItinerarioDao;

@Entity
@Table(name = "Usuario")
public class Usuario {

	public Usuario() {
	}

	@Id
	private int id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "tiempoDisponible")
	private Double tiempoDisponible;

	@Column(name = "presupuesto")
	private Double dineroDisponible;

	@OneToOne
	@JoinColumn(name = "preferencia")
	private TipoAtraccion atraccionPreferida;

	@Column(name = "es_admin")
	private Integer esAdmin;

	@Column(name = "activo")
	private int activo;

	public Integer getEsAdmin() {
		return esAdmin;
	}

	public void setEsAdmin(Integer esAdmin) {
		this.esAdmin = esAdmin;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Saldo disponible: " + dineroDisponible + ". Tiempo disponible: " + tiempoDisponible + ". Preferencia: "
				+ atraccionPreferida + ".";
	}

	public String toStringArchivo() {
		return "El usuario " + this.getUsername() + " realizo las siguientes compras:";
	}

	public void comprar(Atraccion producto) {
		this.setDineroDisponible(this.getDineroDisponible() - producto.calcularCostoFinal());
		this.setTiempoDisponible(this.getTiempoDisponible() - producto.getTiempo());
	}

	public boolean tiene(Atraccion a) {
		ItinerarioDao itinerarioDao = new ItinerarioDao();

		return itinerarioDao.tieneById(this.getId(), a.getId());
	}

	/*
	 * public boolean tiene(Promocion p) { for (Producto producto : listaDeCompras)
	 * { if (producto.equals(p)) { return true; } } for (Atraccion atraccion :
	 * p.getAtracciones()) { if (this.tiene(atraccion)) return true; } return false;
	 * }
	 * 
	 * public boolean tieneComprado(Producto p) { if(p.tipoClase() == "Atraccion") {
	 * return tiene((Atraccion) p); }else { return tiene((Promocion) p); } }
	 */
	public boolean puedeComprar(Producto producto) {
		return this.getDineroDisponible() >= producto.calcularCostoFinal()
				&& this.getTiempoDisponible() >= producto.getTiempo() && producto.tieneCupo();
		// && !tieneComprado(producto);
	}

	public double getCostoDeCompra() {
		double sumatoriaDeCosto = 0;
		/*
		 * for (Producto producto : listaDeCompras) { sumatoriaDeCosto +=
		 * producto.calcularCostoFinal(); }
		 */
		return sumatoriaDeCosto;
	}

	public double getTiempoDeCompra() {
		double sumatoriaDeTiempo = 0;
		/*
		 * for (Producto producto : listaDeCompras) { sumatoriaDeTiempo +=
		 * producto.getTiempo(); }
		 */
		return sumatoriaDeTiempo;
	}

	/*
	 * public void setCompra(Producto Compra) { this.listaDeCompras.add(Compra); }
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public void setTiempoDisponible(Double tiempoDisponible) {
		this.tiempoDisponible = tiempoDisponible;
	}

	public double getDineroDisponible() {
		return dineroDisponible;
	}

	public void setDineroDisponible(Double dineroDisponible) {
		this.dineroDisponible = dineroDisponible;
	}

	public TipoAtraccion getAtraccionPreferida() {
		return atraccionPreferida;
	}

	public void setAtraccionPreferida(TipoAtraccion atraccionPreferida) {
		this.atraccionPreferida = atraccionPreferida;
	}

	/*
	 * public Set<Atraccion> getListaDeCompras() { return listaDeCompras; }
	 * 
	 * public void setListaDeCompras(Set<Atraccion> listaDeCompras) {
	 * this.listaDeCompras = listaDeCompras; }
	 */
}
