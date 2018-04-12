package com.ipartek.formacion.nidea.ejemplos;

public class Circulo extends ObjetoGrafico implements Ordenable {

	int radio;

	public Circulo() {
		super();
		radio = 1;

	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	@Override
	void dibujar() {
		System.out.println("Estoy dibujando un circulo en la posicion x: " + x + " y: " + y);
	}

	@Override
	public void imprimir() {
		System.out.println("Estoy imprimiendo un triangulo dibujado en la posicion x: " + x + " y: " + y);

	}

	@Override
	public int getValor() {
		return this.radio;
	}

}
