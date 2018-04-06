package com.ipartek.formacion.nidea.pojo;

public class EjercicioDepuracion {

	public static void main(String[] args) {

		for (int i = 0; i < 5000; i++) {
			System.out.println("estas en la iteracion numero:" + (i + 1));

			if (i == 332) {
				System.out.println("¡¡Eres un fenómeno!!");
			}

		}

		metodoA();

	}

	public static void metodoA() {
		System.out.println("Hola, bienvenido al metodo A");
		metodoB();
	}

	public static void metodoB() {
		System.out.println("Hola, bienvenido al metodo B");
		metodoC();

	}

	private static void metodoC() {
		System.out.println("Hola, bienvenido al metodo C");
		Utilidades.diaHoy();

	}
}
