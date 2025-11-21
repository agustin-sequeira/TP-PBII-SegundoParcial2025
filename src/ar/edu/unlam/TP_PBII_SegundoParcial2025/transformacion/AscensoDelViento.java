package ar.edu.unlam.TP_PBII_SegundoParcial2025.transformacion;

import ar.edu.unlam.TP_PBII_SegundoParcial2025.enumerable.AfinidadElemental;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura.CriaturaElemental;

public class AscensoDelViento extends TransformacionElemental {

	public AscensoDelViento(CriaturaElemental base) {
		super(base);
	}
	
	@Override
	public AfinidadElemental getAfinidadActiva() {
		return AfinidadElemental.AIRE;
	}
}
