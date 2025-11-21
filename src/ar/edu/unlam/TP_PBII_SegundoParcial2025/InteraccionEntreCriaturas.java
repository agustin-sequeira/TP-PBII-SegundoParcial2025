package ar.edu.unlam.TP_PBII_SegundoParcial2025;

import ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura.CriaturaElemental;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.enumerable.AfinidadElemental;

public final class InteraccionEntreCriaturas {

	private InteraccionEntreCriaturas() {
	}

	public static void interactuar(CriaturaElemental primera, CriaturaElemental segunda) {
		if (primera == null || segunda == null)
			return;

		
		if (primera.esAncestral() || segunda.esAncestral()) {
			resolverAncestral(primera, segunda);
			return;
		}
		
		if (compartenAfinidad(primera, segunda)) {
			primera.ajustarEnergia(10);
			segunda.ajustarEnergia(10);
			return;
		}
		
		if (sonAfinidadesOpuestas(primera, segunda)) {
			primera.volverInestable();
			segunda.volverInestable();
		}
	}

	private static void resolverAncestral(CriaturaElemental primera, CriaturaElemental segunda) {
		CriaturaElemental ancestral = primera.esAncestral() ? primera : segunda;
		CriaturaElemental noAnsestral = ancestral == primera ? segunda : primera;
		
		ancestral.ajustarEnergia(20);
		noAnsestral.ajustarEnergia(-15);
		noAnsestral.pacificar(); // tras ser dominada queda estabilizada
	}

	private static boolean compartenAfinidad(CriaturaElemental primera, CriaturaElemental segunda) {
		return primera.getAfinidadActiva().equals(segunda.getAfinidadActiva());
	}

	private static boolean sonAfinidadesOpuestas(CriaturaElemental primera, CriaturaElemental segunda) {
		AfinidadElemental afinidadElementalPrimera = primera.getAfinidadActiva();
		AfinidadElemental afinidadElementalSegunda = segunda.getAfinidadActiva();
		return (afinidadElementalPrimera == AfinidadElemental.AGUA && afinidadElementalSegunda == AfinidadElemental.FUEGO) ||
				(afinidadElementalPrimera == AfinidadElemental.FUEGO && afinidadElementalSegunda == AfinidadElemental.AGUA) ||
				(afinidadElementalPrimera == AfinidadElemental.AIRE && afinidadElementalSegunda == AfinidadElemental.TIERRA) ||
				(afinidadElementalPrimera == AfinidadElemental.TIERRA && afinidadElementalSegunda == AfinidadElemental.AIRE);
	}
}
