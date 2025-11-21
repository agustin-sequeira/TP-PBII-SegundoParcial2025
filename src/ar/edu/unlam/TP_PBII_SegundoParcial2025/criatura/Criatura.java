package ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura;

import ar.edu.unlam.TP_PBII_SegundoParcial2025.enumerable.AfinidadElemental;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.enumerable.EstadoEmocional;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.InteraccionEntreCriaturas;

public abstract class Criatura implements CriaturaElemental {
	
	protected String nombre;
	protected int nivelDeEnergia;
	protected AfinidadElemental afinidadElemental;
	protected EstadoEmocional estadoEmocional;

	public Criatura(String nombre, int nivelDeEnergia, AfinidadElemental afinidadElemental, 
			EstadoEmocional estadoEmocional) {
		this.nombre = nombre;
		this.nivelDeEnergia = nivelDeEnergia;
		this.afinidadElemental = afinidadElemental;
		this.estadoEmocional = estadoEmocional;
	}
	
	@Override
	public String getNombre() {
		return nombre;
	}
	
	@Override
	public int getNivelDeEnergia() {
		return nivelDeEnergia;
	}
	
	@Override
	public AfinidadElemental getAfinidadActiva() {
		return afinidadElemental;
	}
	
	@Override
	public AfinidadElemental getAfinidadPrimaria() {
		return afinidadElemental;
	}
	
	@Override
	public boolean esInestable() {
		return EstadoEmocional.INSTABLE.equals(estadoEmocional);
	}
	
	@Override
	public void pacificar() {
		this.estadoEmocional = EstadoEmocional.TRANQUILA;
	}
	
	@Override
	public void volverInestable() {
		this.estadoEmocional = EstadoEmocional.INSTABLE;
	}
	
	@Override
	public void ajustarEnergia(int delta) {
		this.nivelDeEnergia = Math.max(0, this.nivelDeEnergia + delta);
	}
	
	@Override
	public void interactuarCon(CriaturaElemental otra) {
		InteraccionEntreCriaturas.interactuar(this, otra);
	}
	
	@Override
	public int contarTransformaciones() {
		return 0;
	}
	
	@Override
	public boolean esAncestral() {
		return false;
	}
}
