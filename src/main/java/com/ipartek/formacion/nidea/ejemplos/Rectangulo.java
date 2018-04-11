package com.ipartek.formacion.nidea.ejemplos;

public class Rectangulo extends ObjetoGrafico {

	@Override
	void dibujar() {
		System.out.println("Estoy dibujando un rectangulo en la posicion x: " + x + " y: " + y);

	}

	@Override
	public void imprimir() {
		System.out.println("Estoy imprimiendo un rectangulo dibujado en la posicion x: " + x + " y: " + y);

	}

}
