package ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura;

import ar.edu.unlam.TP_PBII_SegundoParcial2025.enumerable.AfinidadElemental;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.enumerable.EstadoEmocional;

public class CriaturaAncestral extends Criatura {

	public CriaturaAncestral(String nombre, int nivelDeEnergia, AfinidadElemental afinidadElemental,
			EstadoEmocional estadoEmocional) {
		super(nombre, nivelDeEnergia, afinidadElemental, estadoEmocional);
	}
	
	@Override
	public void entrenar(int intensidad) {
		if (intensidad > 30) {
			this.volverInestable();
		}
		this.ajustarEnergia(intensidad * 2);
	}
	
	@Override
	public void ajustarEnergia(int delta) {
		super.ajustarEnergia(delta);
		if (this.nivelDeEnergia < 100) {
			this.nivelDeEnergia = 100;
		}
	}
	
	@Override
	public boolean esAncestral() {
		return true;
	}
}
