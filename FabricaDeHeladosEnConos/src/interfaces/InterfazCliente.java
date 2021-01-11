package interfaces;

import entidades.Clientes;

public interface InterfazCliente {

	public void crearTabla();

	public void registrar(Clientes cl);

	public Clientes buscarCliente(String legajo);

	public Clientes eliminar(String legajo);

}