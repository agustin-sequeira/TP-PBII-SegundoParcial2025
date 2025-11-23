package ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura;

import ar.edu.unlam.TP_PBII_SegundoParcial2025.enumerable.AfinidadElemental;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.enumerable.EstadoEmocional;

public class CriaturaDomesticada extends Criatura {

	public CriaturaDomesticada(String nombre, int nivelDeEnergia, AfinidadElemental afinidadElemental,
			EstadoEmocional estadoEmocional) {
		super(nombre, nivelDeEnergia, afinidadElemental, estadoEmocional);
	}
	
	@Override
	public void volverInestable() {
		// Las domesticadas no se vuelven inestables según enunciado.
		this.estadoEmocional = EstadoEmocional.TRANQUILA;
	}

	@Override
	public void entrenar(int intensidad) {
		this.ajustarEnergia(intensidad);
		this.pacificar();
	}

}
