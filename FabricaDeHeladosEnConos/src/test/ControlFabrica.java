package test;

import componentes.Alarma;
import componentes.Produccion;
import componentes.Fabrica;
import componentes.Luces;

public class ControlFabrica {

	Luces luces;
	Fabrica fabrica;
	Produccion produccion;
	Alarma alarma;

	public ControlFabrica(Luces luces, Fabrica fabrica, Produccion produccion, Alarma alarma) {
		this.luces = luces;
		this.fabrica = fabrica;
		this.produccion = produccion;
		this.alarma = alarma;
	}

	public void encenderFabrica() {
		System.out.println("ENCENDER FÁBRICA");
		alarma.apagarAlarma();
		luces.encender();
		fabrica.iniciarFabrica();
		produccion.iniciarProduccion();
	}
	
	public void apagarFabrica() {
		System.out.println("APAGAR FÁBRICA");
		fabrica.finalizarFabrica();
		produccion.finalizarProduccion();
		luces.apagar();
		alarma.encenderAlarma();
	}

}