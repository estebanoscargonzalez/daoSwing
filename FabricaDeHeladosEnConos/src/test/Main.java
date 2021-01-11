package test;

import java.util.Scanner;

import componentes.Alarma;
import componentes.Produccion;
import componentes.Fabrica;
import componentes.Luces;
import conexion.Cliente;
import entidades.Clientes;
import interfaces.InterfazCliente;
import swing.Alert;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Main test = new Main();
		Luces luces = new Luces();
		Fabrica fabrica = new Fabrica();
		Produccion produccion = new Produccion();
		Alarma alarma = new Alarma();
		Alert alert = new Alert();
		// InterfazCliente dao = new Cliente();

		 // dao.crearTabla();

		ControlFabrica control = new ControlFabrica(luces, fabrica, produccion, alarma);

		int opc;

		do {
			System.out.println("1- Encender fabrica");
			System.out.println("2- Registrar cliente");
			System.out.println("3- Buscar cliente");
			System.out.println("4- Eliminar cliente");
			System.out.println("5- Apagar fabrica");

			opc = sc.nextInt();
			sc.nextLine();

			switch (opc) {

			case 1:
				test.encenderFabrica(control);
				break;
			case 2:
				test.registrar(sc);
				break;
			case 3:
				test.buscarCliente(sc);
				break;
			case 4:
				test.eliminarCliente(sc);
				break;
			case 5:
				test.apagarFabrica(control);
				alert.setVisible(true);
				break;
			}
		} while (opc != 5);

		sc.close();

	}

	public void encenderFabrica(ControlFabrica control) {
		control.encenderFabrica();
	}

	public void apagarFabrica(ControlFabrica control) {
		control.apagarFabrica();
	}

	public void registrar(Scanner sc) {

		InterfazCliente dao = new Cliente();

		System.out.println("Ingresar legajo del cliente: ");
		String leg = sc.nextLine();
		sc.nextLine();

		System.out.println("Ingresar apellido del cliente: ");
		String ap = sc.nextLine();

		System.out.println("Ingresar nombre del cliente: ");
		String nom = sc.nextLine();

		System.out.println("Ingresar cantidad de helados comprados: ");
		String cant = sc.nextLine();
		sc.nextLine();

		Clientes cl = new Clientes(leg, ap, nom, cant);

		dao.registrar(cl);
	}

	public void buscarCliente(Scanner sc) {

		InterfazCliente dao = new Cliente();

		System.out.println("Ingrese legajo del cliente que desea buscar: ");

		String leg = sc.nextLine();
		sc.nextLine();

		Clientes cliente = dao.buscarCliente(leg);

		if (cliente != null) {
			System.out.println("Resultado de la busqueda del cliente: " + cliente.toString());
		} else {
			System.out.println("No se encontraron resultados para la busqueda");
		}
	}

	public void eliminarCliente(Scanner sc) {

		InterfazCliente dao = new Cliente();

		System.out.println("Ingrese legajo del cliente que desea eliminar: ");
		String leg = sc.nextLine();
		sc.nextLine();

		dao.eliminar(leg);
	}
}
