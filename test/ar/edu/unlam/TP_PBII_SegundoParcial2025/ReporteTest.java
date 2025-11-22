package ar.edu.unlam.TP_PBII_SegundoParcial2025;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
		
		List<MaestroElemental> maestros = new ArrayList();
		maestros.add(miMaestro);
		maestros.add(syl);
		
		Reporte miReporte = new Reporte();
		
		List<CriaturaElemental> criaturas = miReporte.listadoTotalDeCriaturas(maestros);
		
		
		assertEquals(3, criaturas.size());
		assertTrue(criaturas.contains(miCriatura));
		assertTrue(criaturas.contains(domesticada));
		assertTrue(criaturas.contains(ancestral));
		
		
	}
	
	@Test
	public void registraYDevuelveLaCriaturaConMayorEnergiaTotal() {
		Criatura miCriatura = new CriaturaSalvaje("Charizard", 100, AfinidadElemental.FUEGO, EstadoEmocional.INSTABLE);
		Criatura domesticada = new CriaturaDomesticada("Coral", 50, AfinidadElemental.AGUA, EstadoEmocional.TRANQUILA);
		Criatura ancestral = new CriaturaAncestral("Ancestro", 120, AfinidadElemental.TIERRA, EstadoEmocional.TRANQUILA);
		
		MaestroElemental miMaestro = new MaestroElemental("Maestro Yoda", 25, AfinidadElemental.AIRE);
		MaestroElemental syl = new MaestroElemental("Maestra Syl", 15, AfinidadElemental.AIRE);
		
		miMaestro.registrarCriatura(miCriatura);
		syl.registrarCriatura(domesticada);
		syl.registrarCriatura(ancestral);
		
		List<MaestroElemental> maestros = new ArrayList();
		maestros.add(miMaestro);
		maestros.add(syl);
		
		Reporte miReporte = new Reporte();
		
		
		CriaturaElemental criaturaConMayorEnergia = miReporte.devuelveCriaturaConMayorEnergiaTotal(maestros);
		
		assertEquals(120, criaturaConMayorEnergia.getNivelDeEnergia());
	
		
	}
	
	@Test
	public void devuelveMaestroConMasCriaturasTransformadas() {
		Criatura domesticada = new CriaturaDomesticada("Coral", 50, AfinidadElemental.AGUA, EstadoEmocional.TRANQUILA);
		Criatura ancestral = new CriaturaAncestral("Ancestro", 120, AfinidadElemental.TIERRA, EstadoEmocional.TRANQUILA);
		
		MaestroElemental miMaestro = new MaestroElemental("Maestro Yoda", 25, AfinidadElemental.AIRE);
		MaestroElemental syl = new MaestroElemental("Maestra Syl", 15, AfinidadElemental.AGUA);
		
		miMaestro.registrarCriatura(domesticada);
		syl.registrarCriatura(ancestral);
		
		miMaestro.aplicarBendicionDelRio(domesticada.getNombre());
		miMaestro.aplicarLlamaInterna(ancestral.getNombre());
		
		
		Reporte miReporte = new Reporte();
		
		List<MaestroElemental> maestros = new ArrayList();
		maestros.add(miMaestro);
		maestros.add(syl);
		MaestroElemental resultado = miReporte.maestroConMasCriaturasTransformadas(maestros);
		
		assertEquals(miMaestro, resultado);
	
		
	}
	
	@Test
	public void devuelveCantidadDeCriaturasPorAfinidadElemental() {
		Criatura miCriatura = new CriaturaSalvaje("Charizard", 100, AfinidadElemental.FUEGO, EstadoEmocional.INSTABLE);
		Criatura domesticada = new CriaturaDomesticada("Coral", 50, AfinidadElemental.AGUA, EstadoEmocional.TRANQUILA);
		Criatura ancestral = new CriaturaAncestral("Ancestro", 120, AfinidadElemental.TIERRA, EstadoEmocional.TRANQUILA);
		
		MaestroElemental miMaestro = new MaestroElemental("Maestro Yoda", 25, AfinidadElemental.AIRE);
		MaestroElemental syl = new MaestroElemental("Maestra Syl", 15, AfinidadElemental.AGUA);
		
		miMaestro.registrarCriatura(miCriatura);
		miMaestro.registrarCriatura(domesticada);
		syl.registrarCriatura(ancestral);
		
		Reporte miReporte = new Reporte();
		List<MaestroElemental> maestros = new ArrayList();
		maestros.add(miMaestro);
		maestros.add(syl);
		HashMap<AfinidadElemental, Integer> mapa = miReporte.cantidadDeCriaturasPorAfinidad(maestros);
		
		assertEquals(1, (int) mapa.get(AfinidadElemental.FUEGO));
		assertEquals(1, (int) mapa.get(AfinidadElemental.AGUA));
		assertEquals(1, (int) mapa.get(AfinidadElemental.TIERRA));
		assertEquals(0, (int) mapa.get(AfinidadElemental.AIRE));
	
		
	}


}
