package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Itinerario")
public class Itinerario {
	
	@Id
	private int id;
	
	@Column(name = "id_Usuario")
	private int idUsuario;
	
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