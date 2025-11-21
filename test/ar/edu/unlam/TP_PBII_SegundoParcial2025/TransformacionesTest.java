package ar.edu.unlam.TP_PBII_SegundoParcial2025;

import static org.junit.Assert.*;

import ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura.CriaturaDomesticada;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura.CriaturaElemental;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura.CriaturaSalvaje;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.enumerable.AfinidadElemental;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.enumerable.EstadoEmocional;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.transformacion.AscensoDelViento;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.transformacion.BendicionDelRio;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.transformacion.LlamaInterna;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.transformacion.VinculoTerrestre;
import org.junit.Test;

public class TransformacionesTest {

	@Test
	public void bendicionDelRioDuplicaEnergiaConTope() {
		CriaturaElemental base = new CriaturaDomesticada("Delta", 70, AfinidadElemental.AGUA, EstadoEmocional.TRANQUILA);
		CriaturaElemental transformada = new BendicionDelRio(base);
		
		assertEquals(140, transformada.getNivelDeEnergia());
	}
	
	@Test
	public void llamaInternaSoloFavoreceAlFuego() {
		CriaturaElemental baseFuego = new CriaturaDomesticada("Fenix", 80, AfinidadElemental.FUEGO, EstadoEmocional.TRANQUILA);
		CriaturaElemental resultadoFuego = new LlamaInterna(baseFuego);
		assertEquals(110, resultadoFuego.getNivelDeEnergia());
		assertFalse(resultadoFuego.esInestable());
		
		CriaturaElemental baseAgua = new CriaturaDomesticada("Nereida", 80, AfinidadElemental.AGUA, EstadoEmocional.TRANQUILA);
		CriaturaElemental resultadoAgua = new LlamaInterna(baseAgua);
		assertTrue(resultadoAgua.esInestable());
	}
	
	@Test
	public void vinculoTerrestreGarantizaEnergiaMinima() {
		CriaturaElemental base = new CriaturaSalvaje("Roca", 20, AfinidadElemental.TIERRA, EstadoEmocional.INSTABLE);
		CriaturaElemental transformada = new VinculoTerrestre(base);
		
		assertEquals(50, transformada.getNivelDeEnergia());
	}
	
	@Test
	public void ascensoDelVientoCambiaAfinidadVisible() {
		CriaturaElemental base = new CriaturaDomesticada("Boreal", 60, AfinidadElemental.TIERRA, EstadoEmocional.TRANQUILA);
		CriaturaElemental transformada = new AscensoDelViento(base);
		
		assertEquals(AfinidadElemental.AIRE, transformada.getAfinidadActiva());
		assertEquals(AfinidadElemental.TIERRA, transformada.getAfinidadPrimaria());
	}
}
