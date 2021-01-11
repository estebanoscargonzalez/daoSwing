package Factory;

import negocio.Sabor;
import negocio.BaniadoEnChocolate;
import negocio.Aderezos;
import negocio.SaborVainilla;
import negocio.Tamanio;
import negocio.ConBaniado;
import negocio.ConAderezos;
import negocio.TamanioChico;

public class ConoChicoCon implements FabricaHelados {

	public Tamanio crearTamanioConoChicoCon() {
		return new TamanioChico();
	}

	public Sabor crearSabor() {
		return new SaborVainilla();
	}
	
	public Aderezos crearAderezos() {
		return new ConAderezos();
	}

	public BaniadoEnChocolate crearBaniadoEnChocolate() {
		return new ConBaniado();
	}

	@Override
	public Tamanio crearTamanio() {
		// TODO Auto-generated method stub
		return null;
	}

    

}