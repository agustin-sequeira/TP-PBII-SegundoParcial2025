package ar.edu.unlam.TP_PBII_SegundoParcial2025;

import java.util.HashMap;
import java.util.Map;

public class MaestroElemental {
	private String nombre;
	private Integer nivelDeMaestria;
	private String afinidadElemental;
	private Map<String, Criatura> criaturasACargo = new HashMap<>();
	
	public MaestroElemental(String nombre, Integer nivelDeMaestria, String afinidadElemental) {
		this.nombre = nombre;
		this.nivelDeMaestria= nivelDeMaestria;
		this.afinidadElemental = afinidadElemental;
	}

}
