package com.ipartek.formacion.nidea.ejemplos;

public final class CirculoColoreado extends Circulo {

	private String color;

	public CirculoColoreado() {
		super();

	}

	@Override
	void dibujar() {
		System.out.println("Estoy dibujando un circulo coloreado en la posicion x: " + x + " y: " + y);

	}

	@Override
	public void imprimir() {
		System.out.println(
				"Estoy imprimiendo un circulo coloreado de " + color + " dibujado en la posicion x: " + x + " y: " + y);

	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "CirculoColoreado [color=" + color + "]";
	}

}
