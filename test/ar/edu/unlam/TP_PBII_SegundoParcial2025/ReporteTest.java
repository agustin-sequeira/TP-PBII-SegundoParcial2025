package ar.edu.unlam.TP_PBII_SegundoParcial2025;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura.Criatura;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura.CriaturaAncestral;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura.CriaturaDomesticada;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura.CriaturaElemental;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura.CriaturaSalvaje;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.enumerable.AfinidadElemental;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.enumerable.EstadoEmocional;

public class ReporteTest {

	@Test
	public void registraYDevuelveListadoDeCriaturasDeLosMaestros() {
		Criatura miCriatura = new CriaturaSalvaje("Charizard", 100, AfinidadElemental.FUEGO, EstadoEmocional.INSTABLE);
		Criatura domesticada = new CriaturaDomesticada("Coral", 50, AfinidadElemental.AGUA, EstadoEmocional.TRANQUILA);
		Criatura ancestral = new CriaturaAncestral("Ancestro", 120, AfinidadElemental.TIERRA, EstadoEmocional.TRANQUILA);
		
		MaestroElemental miMaestro = new MaestroElemental("Maestro Yoda", 25, AfinidadElemental.AIRE);
		MaestroElemental syl = new MaestroElemental("Maestra Syl", 15, AfinidadElemental.AIRE);
		
		miMaestro.registrarCriatura(miCriatura);
		syl.registrarCriatura(domesticada);
		syl.registrarCriatura(ancestral);
		
		Reporte miReporte = new Reporte();
		
		
	}


}
