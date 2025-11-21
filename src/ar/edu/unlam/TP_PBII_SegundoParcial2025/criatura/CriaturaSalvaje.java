package ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura;

import ar.edu.unlam.TP_PBII_SegundoParcial2025.enumerable.AfinidadElemental;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.enumerable.EstadoEmocional;

public class CriaturaSalvaje extends Criatura {

	public CriaturaSalvaje(String nombre, int nivelDeEnergia, AfinidadElemental afinidadElemental,
			EstadoEmocional estadoEmocional) {
		super(nombre, nivelDeEnergia, afinidadElemental, estadoEmocional);
	}

	@Override
	public void entrenar(int intensidad) {
		int incrementoImpredecible = intensidad * 2;
		this.ajustarEnergia(incrementoImpredecible);
	}
}
