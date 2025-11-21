package ar.edu.unlam.TP_PBII_SegundoParcial2025.transformacion;

import ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura.CriaturaElemental;

public class VinculoTerrestre extends TransformacionElemental {

	public VinculoTerrestre(CriaturaElemental base) {
		super(base);
	}
	
	@Override
	public int getNivelDeEnergia() {
		return Math.max(50, base.getNivelDeEnergia());
	}
}
