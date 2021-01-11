package Factory;

import negocio.Tamanio;
import negocio.BaniadoEnChocolate;
import negocio.Sabor;
import negocio.Aderezos;

public interface FabricaHelados {
	
	public Tamanio crearTamanio();
	public BaniadoEnChocolate crearBaniadoEnChocolate();
	public Sabor crearSabor();
	public Aderezos crearAderezos();

}