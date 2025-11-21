package ar.edu.unlam.TP_PBII_SegundoParcial2025;

import static org.junit.Assert.*;

import ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura.*;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.enumerable.AfinidadElemental;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.enumerable.EstadoEmocional;
import org.junit.Test;

public class CriaturaTest {

	@Test
	public void creacionDeMiCriaturaSalvaje() {
		Criatura miCriatura = new CriaturaSalvaje("Charizard", 100, AfinidadElemental.FUEGO, EstadoEmocional.INSTABLE);
		assertNotNull(miCriatura);
	}

	@Test
	public void creacionDeMiCriaturaDomesticada() {
		Criatura miCriatura = new CriaturaDomesticada("Charizard", 100, AfinidadElemental.AGUA, EstadoEmocional.TRANQUILA);
		assertNotNull(miCriatura);
	}

	@Test
	public void creacionDeMiCriaturaAncestral() {
		Criatura miCriatura = new CriaturaAncestral("Charizard", 100, AfinidadElemental.TIERRA, EstadoEmocional.TRANQUILA);
		assertNotNull(miCriatura);
	}

	@Test
	public void laCriaturaSalvajeAumentaEnergiaDeFormaImpredecible() {
		CriaturaElemental salvaje = new CriaturaSalvaje("Charizard", 90, AfinidadElemental.FUEGO, EstadoEmocional.INSTABLE);
		salvaje.entrenar(20);
		assertEquals(130, salvaje.getNivelDeEnergia());
	}
	
	@Test
	public void laCriaturaDomesticadaSeMantieneTranquila() {
		CriaturaElemental domesticada = new CriaturaDomesticada("Coral", 50, AfinidadElemental.AGUA, EstadoEmocional.TRANQUILA);
		domesticada.volverInestable(); // intentamos desestabilizarla
		domesticada.entrenar(20);
		assertFalse(domesticada.esInestable());
		assertEquals(70, domesticada.getNivelDeEnergia());
	}
	
	@Test
	public void laCriaturaAncestralNoPuedeBajarDeCienDeEnergia() {
		CriaturaElemental ancestral = new CriaturaAncestral("Ancestro", 120, AfinidadElemental.TIERRA, EstadoEmocional.TRANQUILA);
		ancestral.ajustarEnergia(-50);
		assertEquals(100, ancestral.getNivelDeEnergia());
	}

}
