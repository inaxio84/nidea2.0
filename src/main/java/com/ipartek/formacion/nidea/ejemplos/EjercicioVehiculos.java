package com.ipartek.formacion.nidea.ejemplos;

public class EjercicioVehiculos {

	public static void main(String[] args) {
		/*
		 * No se pueden crear objetos de una clase abstracta
		 * 
		 * Vehiculo rayoMacQueen = new Vehiculo();
		 * System.out.println(rayoMacQueen.toString());
		 * 
		 */

		Vehiculo.dimeMatricula();

		System.out.println("---------------------------------------");

		VehiculoElectrico tesla = new VehiculoElectrico();
		System.out.println(tesla.toString());

		System.out.println("Tesla");
		System.out.println("color:" + tesla.getColor());

	}

}
