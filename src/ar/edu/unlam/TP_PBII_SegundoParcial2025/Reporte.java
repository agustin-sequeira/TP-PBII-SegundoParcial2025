package ar.edu.unlam.TP_PBII_SegundoParcial2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura.Criatura;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura.CriaturaElemental;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.enumerable.AfinidadElemental;

public class Reporte {

	public List<CriaturaElemental> listadoTotalDeCriaturas(List<MaestroElemental> maestros) {
		List<CriaturaElemental> resultado = new ArrayList();
		for (MaestroElemental maestro : maestros) {
			resultado.addAll(maestro.obtenerCriaturas());
		}
		
		return resultado;
	}

	public CriaturaElemental devuelveCriaturaConMayorEnergiaTotal(List<MaestroElemental> maestros) {
		CriaturaElemental criaturaConMayorEnergia = null;
		Integer mayorEnergia = 0;
		
		for(MaestroElemental maestro : maestros) {
			for (CriaturaElemental criatura : maestro.obtenerCriaturas()) {
				if (criatura.getNivelDeEnergia() > mayorEnergia) {
					mayorEnergia = criatura.getNivelDeEnergia();
					criaturaConMayorEnergia = criatura;
				};
			}	
		}
		return criaturaConMayorEnergia;
	}

	public MaestroElemental maestroConMasCriaturasTransformadas(List<MaestroElemental> maestros) {
		MaestroElemental maestroConMasTransformaciones = null ;
		Integer maximaCantidadDeCriaturasTransformadas= 0;
		
		for(MaestroElemental maestro : maestros){
			Integer transformaciones = maestro.contarCriaturasTransformadas();
			if(transformaciones > maximaCantidadDeCriaturasTransformadas) {
				maestroConMasTransformaciones = maestro;
				maximaCantidadDeCriaturasTransformadas = transformaciones;
			}
		} 
		return maestroConMasTransformaciones;
	}

	public HashMap<AfinidadElemental, Integer> cantidadDeCriaturasPorAfinidad(List<MaestroElemental> maestros) {
		HashMap<AfinidadElemental, Integer> mapa = new HashMap();
		
		for(AfinidadElemental afinidad : AfinidadElemental.values()) {
			mapa.put(afinidad, 0);
			
		}
		
		for(MaestroElemental maestro : maestros) {
			for(CriaturaElemental criatura : maestro.obtenerCriaturas()) {
				mapa.put(criatura.getAfinidadPrimaria(), mapa.get(criatura.getAfinidadPrimaria()) + 1);
			}
		}
		return mapa;
	}
	
	
	
}
