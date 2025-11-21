package ar.edu.unlam.TP_PBII_SegundoParcial2025.transformacion;

import ar.edu.unlam.TP_PBII_SegundoParcial2025.enumerable.AfinidadElemental;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.InteraccionEntreCriaturas;
import ar.edu.unlam.TP_PBII_SegundoParcial2025.criatura.CriaturaElemental;

public abstract class TransformacionElemental implements CriaturaElemental {
	protected final CriaturaElemental base;
	
	public TransformacionElemental(CriaturaElemental base) {
		this.base = base;
	}

	@Override
	public String getNombre() {
		return base.getNombre();
	}

	@Override
	public int getNivelDeEnergia() {
		return base.getNivelDeEnergia();
	}

	@Override
	public AfinidadElemental getAfinidadActiva() {
		return base.getAfinidadActiva();
	}

	@Override
	public AfinidadElemental getAfinidadPrimaria() {
		return base.getAfinidadPrimaria();
	}

	@Override
	public boolean esInestable() {
		return base.esInestable();
	}

	@Override
	public void pacificar() {
		base.pacificar();
	}

	@Override
	public void volverInestable() {
		base.volverInestable();
	}

	@Override
	public void entrenar(int intensidad) {
		base.entrenar(intensidad);
	}

	@Override
	public void ajustarEnergia(int delta) {
		base.ajustarEnergia(delta);
	}

	@Override
	public void interactuarCon(CriaturaElemental otra) {
		InteraccionEntreCriaturas.interactuar(this, otra);
	}

	@Override
	public int contarTransformaciones() {
		return base.contarTransformaciones() + 1;
	}

	@Override
	public boolean esAncestral() {
		return base.esAncestral();
	}
}
