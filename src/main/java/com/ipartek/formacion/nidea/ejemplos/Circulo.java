package com.ipartek.formacion.nidea.ejemplos;

public class Circulo extends ObjetoGrafico {

	public Circulo() {
		super();

	}

	@Override
	void dibujar() {
		System.out.println("Estoy dibujando un circulo en la posicion x: " + x + " y: " + y);
	}

	@Override
	public void imprimir() {
		System.out.println("Estoy imprimiendo un triangulo dibujado en la posicion x: " + x + " y: " + y);

	}

}
