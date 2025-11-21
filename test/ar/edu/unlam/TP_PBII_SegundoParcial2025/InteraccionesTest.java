package ar.edu.unlam.TP_PBII_SegundoParcial2025;

import static org.junit.Assert.*;

import ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura.CriaturaAncestral;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura.CriaturaDomesticada;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura.CriaturaElemental;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura.CriaturaSalvaje;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.enumerable.AfinidadElemental;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.enumerable.EstadoEmocional;
import org.junit.Test;

public class InteraccionesTest {

	@Test
	public void afinidadesCompartidasAumentanEnergia() {
		CriaturaElemental c1 = new CriaturaDomesticada("Gotita", 50, AfinidadElemental.AGUA, EstadoEmocional.TRANQUILA);
		CriaturaElemental c2 = new CriaturaSalvaje("Ola", 40, AfinidadElemental.AGUA, EstadoEmocional.INSTABLE);
		
		InteraccionEntreCriaturas.interactuar(c1, c2);
		
		assertEquals(50, c2.getNivelDeEnergia()); //40 +10
		assertEquals(60, c1.getNivelDeEnergia());
	}
	
	@Test
	public void afinidadesOpuestasCausanInestabilidad() {
		CriaturaElemental agua = new CriaturaDomesticada("Lluvia", 70, AfinidadElemental.AGUA, EstadoEmocional.TRANQUILA);
		CriaturaElemental fuego = new CriaturaSalvaje("Fuego", 70, AfinidadElemental.FUEGO, EstadoEmocional.INSTABLE);
		
		InteraccionEntreCriaturas.interactuar(agua, fuego);
		
		assertTrue(agua.esInestable());
		assertTrue(fuego.esInestable());
	}
	
	@Test
	public void laCriaturaAncestralDomina() {
		CriaturaElemental ancestral = new CriaturaAncestral("Gaia", 140, AfinidadElemental.TIERRA, EstadoEmocional.TRANQUILA);
		CriaturaElemental otra = new CriaturaSalvaje("Nube", 30, AfinidadElemental.AIRE, EstadoEmocional.INSTABLE);
		
		InteraccionEntreCriaturas.interactuar(ancestral, otra);
		
		assertEquals(160, ancestral.getNivelDeEnergia());
		assertEquals(15, otra.getNivelDeEnergia());
	}
}
