package com.ipartek.formacion.nidea;

import org.junit.Test;

import com.ipartek.formacion.nidea.ejemplos.Perro;

public class TestIterfaceOrdenable {

	@Test
	public void test() {
		Perro perro1 = new Perro();
		Perro perro2 = new Perro();
		perro1.setNumeroVacunas(0);
		perro2.setNumeroVacunas(1);
	}

}
