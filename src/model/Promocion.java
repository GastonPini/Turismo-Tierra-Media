package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Promocion")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "Tipo")
public /*abstract*/ class Promocion extends Producto {
	
	@Id
	private int id;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinTable(
        name = "Atraccion_Promocion",
        joinColumns = @JoinColumn(name = "ID_Promocion", nullable = false),
        inverseJoinColumns = @JoinColumn(name="ID_Atraccion", nullable = false)
	)
	private Set<Atraccion> atracciones = new HashSet<>();
	
	@Column(name = "Nombre")
	private String nombre;
	
	@Column(name = "Tipo")
	private String tipo;
	
	@Column(name = "DatoExtra")
	private String datoExtra;
	
	@Column(name = "activo")
	private int activo;
	/*
	public Promocion(String id, String nombre, Set<Atraccion> atracciones) {
		super(id, nombre);
		this.atracciones = atracciones;
	}
	*/	
	
	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public Promocion() {
		
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAtracciones(Set<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}

	public void agregarAtraccion(Atraccion atraccion) {
		this.atracciones.add(atraccion);
	}
	
	public Set<Atraccion> getAtracciones() {
		return atracciones;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDatoExtra() {
		return datoExtra;
	}

	public void setDatoExtra(String datoExtra) {
		this.datoExtra = datoExtra;
	}

	public void restarCupo() {
		if (cupoDisponible()) {
			for (Atraccion atraccion : atracciones) {
				atraccion.comprado();
			}
		}
	}
/*
	public abstract double calcularCostoFinal();

	//@Override
	public double getTiempo() {
		double sumaTiempo = 0.0;

		for (Atraccion atraccion : atracciones) {
			sumaTiempo += atraccion.getTiempo();
		}
		return sumaTiempo;
	}
*/
	//@Override
	public double getCosto() {
		double sumaCostos = 0.0;

		for (Atraccion atraccion : atracciones) {
			sumaCostos += atraccion.getCosto();
		}
		return sumaCostos;
	}

	public boolean cupoDisponible() {
		boolean hayCupo = true;

		for (Atraccion atraccion : atracciones) {
			if (!atraccion.hayCupo()) {
				hayCupo = false;
				//System.out.println("No hay cupo disponible.");
				return hayCupo;
			}
		}
		return hayCupo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public boolean tieneTipo(Integer tipoAventura) {
		for (Atraccion atraccion : atracciones) {
			if (atraccion.getTipoAtraccion().equals(tipoAventura)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		String aux = "";
		for (Atraccion atraccion : atracciones) {
			aux += atraccion.getNombre() + ". " + atraccion.toString() + "\n";
		}
		return "Este pack contiene las siguientes atracciones:\n" + aux + "Costo total: " + calcularCostoFinal()
				+ ". Tiempo total: " + getTiempo();
	}

	//@Override
	public String toStringArchivo() {
		String aux = "";
		for (Atraccion atraccion : atracciones) {
			aux += atraccion.toStringArchivo() + "\n";
		}
		return "	-Promocion: " + this.getNombre() + "\n" + "	Incluye: \n" + aux;
	}

	//@Override
	public void comprado() {
		this.restarCupo();
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	//@Override
	public String tipoClase() {
		return "Promocion";
	}
	
	//@Override
	public boolean tieneCupo() {
		for (Atraccion atraccion : atracciones) {
			if(!atraccion.tieneCupo()) {
				return false;
			}
		};
		return true;
	}

	@Override
	public double calcularCostoFinal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTiempo() {
		// TODO Auto-generated method stub
		return 0;
	}

}
