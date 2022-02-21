package model;


public abstract class Producto {
	
	
	private int id;
	
	
	private String nombre;
	
	
	public Producto() {

	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "nombre=" + nombre;
	}

	public abstract String tipoClase();

	public abstract String toStringArchivo();

	public abstract double calcularCostoFinal();

	public abstract double getCosto();

	public abstract double getTiempo();
	
	public abstract boolean tieneCupo();

	public abstract void comprado();

}