package ar.edu.unlam.TP_PBII_SegundoParcial2025;

import static org.junit.Assert.*;

import org.junit.Test;

public class CriaturaTest {

	@Test
	public void creacionDeMiCriaturaSalvaje() {
		Criatura miCriatura = new CriaturaSalvaje("Charizard", 100, "Fuego", "Inestable");
		assertNotNull(miCriatura);
	}
	
	@Test
	public void creacionDeMiCriaturaDomesticada() {
		Criatura miCriatura = new CriaturaDomesticada("Charizard", 100, "Agua", "Tranquila");
		assertNotNull(miCriatura);
	}
	
	@Test
	public void creacionDeMiCriaturaAncestral() {
		Criatura miCriatura = new CriaturaAncestral("Charizard", 100, "Tierra", "Tranquila");
		assertNotNull(miCriatura);
	}

}
