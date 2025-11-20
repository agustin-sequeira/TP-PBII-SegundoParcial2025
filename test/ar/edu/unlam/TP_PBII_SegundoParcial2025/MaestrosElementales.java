package ar.edu.unlam.TP_PBII_SegundoParcial2025;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaestrosElementales {

	@Test
	public void creacionDeMiMaestroElemental() {
		MaestroElemental miMaestro = new MaestroElemental("Maestro Yoda", 25, "Aire");
		assertNotNull(miMaestro);
	}
	
	/*@Test
	public void queLaColeccionDeCriaturasEmpieceDesdeCero() {
		MaestroElemental miMaestro = new MaestroElemental("Maestro Yoda", 25, "Aire");
		valorEsperado Integer = 0;
		assertNotNull(miMaestro);
		assertEquals(valorEsperado, miMaestro.criaturasACargo().);
		
	}*/

}
