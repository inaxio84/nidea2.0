package com.ipartek.formacion.nidea.ejemplos;

public class Perro implements Ordenable {

	int numeroVacunas;

	@Override
	public int getValor() {
		int valor = this.getNumeroVacunas();
		return (valor);
	}

	public Perro() {
		super();
		numeroVacunas = 0;

	}

	public int getNumeroVacunas() {
		return numeroVacunas;
	}

	public void setNumeroVacunas(int numeroVacunas) {
		this.numeroVacunas = numeroVacunas;
	}

	@Override
	public String toString() {
		return "Perro [numeroVacunas=" + numeroVacunas + "]";
	}

}
