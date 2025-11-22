package ar.edu.unlam.TP_PBII_SegundoParcial2025;

import static org.junit.Assert.*;

import org.junit.Before;

import ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura.CriaturaDomesticada;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura.CriaturaElemental;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.enumerable.AfinidadElemental;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.enumerable.EstadoEmocional;
import org.junit.Test;

public class MaestroElementalTest {
	
	private MaestroElemental miMaestro;
	private MaestroElemental syl;
	private CriaturaElemental brisa;
	
	@Before
	public void setUp() throws Exception {
		miMaestro = new MaestroElemental("Maestro Yoda", 25, AfinidadElemental.AIRE);
		syl = new MaestroElemental("Maestra Syl", 15, AfinidadElemental.AIRE);
		brisa = new CriaturaDomesticada("Brisa", 40, AfinidadElemental.AIRE, EstadoEmocional.TRANQUILA);
	}

	@Test
	public void creacionDeMiMaestroElementalYVerificaQueInicializa() {
		assertNotNull(miMaestro);
		assertEquals("Maestro Yoda", miMaestro.getNombre());
	}

	@Test
	public void elMaestroEntrenaSegunSuNivelDeMaestria() {
		
		syl.registrarCriatura(brisa);

		syl.entrenarCriatura(brisa.getNombre(), 10);
		
		assertEquals(50, brisa.getNivelDeEnergia());
	}

}
