package ar.edu.unlam.TP_PBII_SegundoParcial2025;

import static org.junit.Assert.*;

import ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura.CriaturaDomesticada;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura.CriaturaElemental;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.enumerable.AfinidadElemental;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.enumerable.EstadoEmocional;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.exception.MaestriaInsuficienteException;
import org.junit.Test;

public class MaestroElementalTest {

	@Test
	public void creacionDeMiMaestroElemental() {
		MaestroElemental miMaestro = new MaestroElemental("Maestro Yoda", 25, AfinidadElemental.AIRE);
		assertNotNull(miMaestro);
	}

	@Test
	public void elMaestroEntrenaSegunSuNivelDeMaestria() throws MaestriaInsuficienteException {
		MaestroElemental syl = new MaestroElemental("Maestra Syl", 15, AfinidadElemental.AIRE);
		CriaturaElemental brisa = new CriaturaDomesticada("Brisa", 40, AfinidadElemental.AIRE, EstadoEmocional.TRANQUILA);
		syl.registrarCriatura(brisa);

		syl.entrenarCriatura(brisa.getNombre(), 10);
		
		assertEquals(50, brisa.getNivelDeEnergia());
	}

}
