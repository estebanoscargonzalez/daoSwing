package Factory;

import negocio.Sabor;
import negocio.BaniadoEnChocolate;
import negocio.Aderezos;
import negocio.SaborFrutilla;
import negocio.ConBaniado;
import negocio.ConAderezos;
import negocio.Tamanio;
import negocio.TamanioGrande;

public class ConoGrandeCon implements FabricaHelados {

	public Tamanio crearTamanio() {
		return new TamanioGrande();
	}

	public Sabor crearSabor() {
		return new SaborFrutilla();
	}
	
	public Aderezos crearAderezos() {
		return new ConAderezos();
	}

	public BaniadoEnChocolate crearBaniadoEnChocolate() {
		return new ConBaniado();
	}

}