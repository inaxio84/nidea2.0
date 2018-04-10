package com.ipartek.formacion.nidea.ejemplos;

public class VehiculoElectrico extends Vehiculo {
	private float potencia; // kW

	public VehiculoElectrico() {
		super();
		this.potencia = 0;
		System.out.println("instanciado VehiculoElectrico");
	}

	public VehiculoElectrico(float potencia) {
		// por defecto eclipse añade el super() siempre al crear el constructor, en este
		// caso deberemos sustituirlo por this()
		// super();
		this();
		this.potencia = potencia;
	}

	@Override
	public String toString() {
		return super.toString() + "VehiculoElectrico [potencia=" + potencia + "]";
	}

	public float getPotencia() {
		return potencia;
	}

	public void setPotencia(float potencia) {
		this.potencia = potencia;
	}

	@Override
	public void arrancar() {
		// super.arrancar(); no nos interesa aprovechar el código heredado del padre
		System.out.println("pulsar boton encendido");
	}

}
