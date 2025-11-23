package ar.edu.unlam.TP_PBII_SegundoParcial2025;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura.Criatura;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura.CriaturaAncestral;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura.CriaturaDomesticada;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura.CriaturaElemental;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura.CriaturaSalvaje;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.enumerable.AfinidadElemental;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.enumerable.EstadoEmocional;

public class ReporteTest {
	
	private CriaturaElemental charizard;
	private CriaturaElemental coral;
	private CriaturaElemental ancestro;
	
	private MaestroElemental yoda;
	private MaestroElemental syl;
	
	private Reporte reporte;
	private List<MaestroElemental> maestros;

	
	@Before
	public void setUp() throws Exception {
		charizard = new CriaturaSalvaje("Charizard", 100, AfinidadElemental.FUEGO, EstadoEmocional.INSTABLE);
		coral = new CriaturaDomesticada("Coral", 50, AfinidadElemental.AGUA, EstadoEmocional.TRANQUILA);
		ancestro = new CriaturaAncestral("Ancestro", 120, AfinidadElemental.TIERRA, EstadoEmocional.TRANQUILA);
		
		yoda = new MaestroElemental("Maestro Yoda", 25, AfinidadElemental.AIRE);
		syl = new MaestroElemental("Maestra Syl", 15, AfinidadElemental.AIRE);
		
		reporte = new Reporte();
		maestros = new ArrayList();
		maestros.add(yoda);
		maestros.add(syl);
	}

	@Test
	public void registraYDevuelveListadoDeCriaturasDeLosMaestros() {
		
		yoda.registrarCriatura(charizard);
		syl.registrarCriatura(coral);
		syl.registrarCriatura(ancestro);
		
		List<CriaturaElemental> criaturas = reporte.listadoTotalDeCriaturas(maestros);
		
		
		assertEquals(3, criaturas.size());
		assertTrue(criaturas.contains(charizard));
		assertTrue(criaturas.contains(coral));
		assertTrue(criaturas.contains(ancestro));
		
		
	}
	
	@Test
	public void registraYDevuelveLaCriaturaConMayorEnergiaTotal() {
		
		yoda.registrarCriatura(charizard);
		syl.registrarCriatura(coral);
		syl.registrarCriatura(ancestro);
		
		CriaturaElemental criaturaConMayorEnergia = reporte.devuelveCriaturaConMayorEnergiaTotal(maestros);
		
		assertEquals(120, criaturaConMayorEnergia.getNivelDeEnergia());
	
		
	}
	
	@Test
	public void devuelveMaestroConMasCriaturasTransformadas() {
		
		yoda.registrarCriatura(coral);
		yoda.registrarCriatura(ancestro);
		syl.registrarCriatura(charizard);
		
		yoda.aplicarBendicionDelRio(coral.getNombre());
		yoda.aplicarLlamaInterna(ancestro.getNombre());
		syl.aplicarAscensoDelViento(charizard.getNombre());
		
		MaestroElemental resultado = reporte.maestroConMasCriaturasTransformadas(maestros);
		
		assertEquals(yoda, resultado);
	
		
	}
	
	@Test
	public void devuelveCantidadDeCriaturasPorAfinidadElemental() {
		
		yoda.registrarCriatura(charizard);
		yoda.registrarCriatura(coral);
		syl.registrarCriatura(ancestro);
		
		HashMap<AfinidadElemental, Integer> mapa = reporte.cantidadDeCriaturasPorAfinidad(maestros);
		
		assertEquals(1, (int) mapa.get(AfinidadElemental.FUEGO));
		assertEquals(1, (int) mapa.get(AfinidadElemental.AGUA));
		assertEquals(1, (int) mapa.get(AfinidadElemental.TIERRA));
		assertEquals(0, (int) mapa.get(AfinidadElemental.AIRE));
	
		
	}


}
