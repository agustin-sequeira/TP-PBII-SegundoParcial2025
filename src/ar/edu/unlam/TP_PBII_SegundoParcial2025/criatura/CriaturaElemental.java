package ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura;

import ar.edu.unlam.TP_PBII_SegundoParcial2025.enumerable.AfinidadElemental;

public interface CriaturaElemental {
	
	String getNombre();
	
	int getNivelDeEnergia();
	
	AfinidadElemental getAfinidadActiva();
	
	AfinidadElemental getAfinidadPrimaria();
	
	boolean esInestable();
	
	void pacificar();
	
	void volverInestable();
	
	void entrenar(int intensidad);
	
	void ajustarEnergia(int delta);
	
	void interactuarCon(CriaturaElemental otra);
	
	int contarTransformaciones();
	
	boolean esAncestral();
}
