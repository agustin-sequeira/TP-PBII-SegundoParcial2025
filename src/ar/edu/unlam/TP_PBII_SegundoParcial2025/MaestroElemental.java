package ar.edu.unlam.TP_PBII_SegundoParcial2025;

import ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura.CriaturaElemental;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.enumerable.AfinidadElemental;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.exception.MaestriaInsuficienteException;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.transformacion.AscensoDelViento;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.transformacion.BendicionDelRio;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.transformacion.LlamaInterna;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.transformacion.VinculoTerrestre;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MaestroElemental {
	private String nombre;
	private int nivelDeMaestria;
	private AfinidadElemental afinidadElemental;
	private Map<String, CriaturaElemental> criaturasACargo = new HashMap<>();
	
	public MaestroElemental(String nombre, int nivelDeMaestria, AfinidadElemental afinidadElemental) {
		this.nombre = nombre;
		this.nivelDeMaestria= nivelDeMaestria;
		this.afinidadElemental = afinidadElemental;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void registrarCriatura(CriaturaElemental criatura) {
		criaturasACargo.put(criatura.getNombre(), criatura);
	}
	
	public CriaturaElemental obtenerCriatura(String nombre) {
		return criaturasACargo.get(nombre);
	}
	
	public void entrenarCriatura(String nombreCriatura, int intensidad)  {
		CriaturaElemental criatura = criaturasACargo.get(nombreCriatura);
		if (criatura != null)
			criatura.entrenar(intensidad);
	}
	
	public void pacificarCriatura(String nombreCriatura) {
		CriaturaElemental criatura = criaturasACargo.get(nombreCriatura);
		if (criatura != null)
			criatura.pacificar();
	}
	
	public void aplicarBendicionDelRio(String nombreCriatura) {
		CriaturaElemental criatura = criaturasACargo.get(nombreCriatura);
		if (criatura != null)
			reemplazarCriatura(nombreCriatura, new BendicionDelRio(criatura));
	}
	
	public void aplicarLlamaInterna(String nombreCriatura) {
		CriaturaElemental criatura = criaturasACargo.get(nombreCriatura);
		if (criatura != null)
			reemplazarCriatura(nombreCriatura, new LlamaInterna(criatura));
	}
	
	public void aplicarVinculoTerrestre(String nombreCriatura) {
		CriaturaElemental criatura = criaturasACargo.get(nombreCriatura);
		if (criatura != null)
			reemplazarCriatura(nombreCriatura, new VinculoTerrestre(criatura));
	}
	
	public void aplicarAscensoDelViento(String nombreCriatura) {
		CriaturaElemental criatura = criaturasACargo.get(nombreCriatura);
		if (criatura != null)
			reemplazarCriatura(nombreCriatura, new AscensoDelViento(criatura));
	}
	
	private void reemplazarCriatura(String nombre, CriaturaElemental nueva) {
		if (nombre != null && criaturasACargo.containsKey(nombre) && nueva != null)
			criaturasACargo.put(nombre, nueva);
	}
	
	public int contarCriaturasTransformadas() {
		return (int) criaturasACargo.values().stream()
				.filter(c -> c.contarTransformaciones() > 0)
				.count();
	}
	
	public List<CriaturaElemental> obtenerCriaturas() {
		return criaturasACargo.values().stream().toList();
	}
}
