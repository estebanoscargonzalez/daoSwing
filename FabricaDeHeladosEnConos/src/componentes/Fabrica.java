package componentes;

import Factory.ConoChicoCon;
import Factory.ConoChicoSin;
import Factory.ConoGrandeCon;
import Factory.ConoGrandeSin;
import Factory.FabricaHelados;
import negocio.Aderezos;
import negocio.BaniadoEnChocolate;
import negocio.Sabor;
import negocio.Tamanio;

public class Fabrica {

	public void iniciarFabrica() {

		System.out.println("Comenzando a fabricar helados...");

		FabricaHelados conoGrandeCon = new ConoGrandeCon();
		CrearHelado(conoGrandeCon);

		FabricaHelados conoGrandeSin = new ConoGrandeSin();
		CrearHelado(conoGrandeSin);

		FabricaHelados conoChicoCon = new ConoChicoCon();
		CrearHelado(conoChicoCon);

		FabricaHelados conoChicoSin = new ConoChicoSin();
		CrearHelado(conoChicoSin);

	}

	public void finalizarFabrica() {
		System.out.println("Finalizando fabricacion de helados...");
	}

	public static void CrearHelado(FabricaHelados factory) {

		Tamanio tamanio = factory.crearTamanio();
		Sabor sabor = factory.crearSabor();
		Aderezos aderezos = factory.crearAderezos();
		BaniadoEnChocolate baniadoEnChocolate = factory.crearBaniadoEnChocolate();

		System.out.println("Creando helado " + tamanio + ", " + aderezos + ", " + sabor + " y " + baniadoEnChocolate);

	}

}