package ar.edu.unlam.TP_PBII_SegundoParcial2025.transformacion;

import ar.edu.unlam.TP_PBII_SegundoParcial2025.enumerable.AfinidadElemental;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura.CriaturaElemental;

public class LlamaInterna extends TransformacionElemental {

	public LlamaInterna(CriaturaElemental base) {
		super(base);
		if (AfinidadElemental.FUEGO.equals(base.getAfinidadPrimaria())) {
			base.ajustarEnergia(30);
		} else {
			base.volverInestable();
		}
	}
}
