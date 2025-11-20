package ar.edu.unlam.TP_PBII_SegundoParcial2025;

public abstract class Criatura {
	
	protected String nombre;
	protected Integer nivelDeEnergia;
	protected String afinidadElemental;
	protected String comportamientoEmocional;

	public Criatura(String nombre, Integer nivelDeEnergia, String afinidadElemental, 
			String comportamientoEmocional) {
		this.nombre = nombre;
		this.nivelDeEnergia = nivelDeEnergia;
		this.afinidadElemental = afinidadElemental;
		this.comportamientoEmocional = comportamientoEmocional;
	}

}
