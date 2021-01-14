package Factory;

import negocio.Sabor;
import negocio.BaniadoEnChocolate;
import negocio.Aderezos;
import negocio.SaborFrutilla;
import negocio.SinBaniado;
import negocio.SinAderezos;
import negocio.Tamanio;
import negocio.TamanioChico;

public class ConoChicoSin implements FabricaHelados {

	public Tamanio crearTamanio() {
		return new TamanioChico();
	}

	public Sabor crearSabor() {
		return new SaborFrutilla();
	}

	public Aderezos crearAderezos() {
		return new SinAderezos();
	}

	public BaniadoEnChocolate crearBaniadoEnChocolate() {
		return new SinBaniado();
	}

}
