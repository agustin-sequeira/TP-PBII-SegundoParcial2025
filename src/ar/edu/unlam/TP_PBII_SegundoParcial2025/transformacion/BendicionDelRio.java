package ar.edu.unlam.TP_PBII_SegundoParcial2025.transformacion;

import ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura.CriaturaElemental;

public class BendicionDelRio extends TransformacionElemental {

	public BendicionDelRio(CriaturaElemental base) {
		super(base);
	}
	
	@Override
	public int getNivelDeEnergia() {
		int energiaDoblada = base.getNivelDeEnergia() * 2;
		return Math.min(180, energiaDoblada);
	}
}
