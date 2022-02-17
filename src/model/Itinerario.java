package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Itinerario")
public class Itinerario {
	
	@Id
	private int id;
	
	/*@OneToOne
	@JoinColumn(name = "Usuario")*/
	@Column(name = "id_Usuario")
	private int idUsuario;
	
	/*@OneToOne
	@JoinColumn(name = "Atraccion")*/
	@Column(name = "id_Atraccion")
	private int idAtraccion;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdAtraccion() {
		return idAtraccion;
	}

	public void setIdAtraccion(int idAtraccion) {
		this.idAtraccion = idAtraccion;
	}

	public Itinerario() {

	}	
}
