package entidades;

public class Clientes {

	private String legajo;
	private String apellido;
	private String nombre;
	private String cantidad;

	public Clientes(String legajo, String apellido, String nombre, String cantidad) {
		super();
		this.legajo = legajo;
		this.apellido = apellido;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[-LEGAJO: ");
		builder.append(legajo);
		builder.append(" -APELLIDO: ");
		builder.append(apellido);
		builder.append(" -NOMBRE: ");
		builder.append(nombre);
		builder.append(" -CANTIDAD: ");
		builder.append(cantidad);
		builder.append("]");
		return builder.toString();
	}

}